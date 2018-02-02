// Note: Most of the code comes from the MacResearch OpenCL podcast

#define CL_USE_DEPRECATED_OPENCL_1_2_APIS
#include <stdio.h>
#include <stdlib.h>

#include <CL/cl.h>

#include "bmp.h"
#include "cl_helper.h"

#define MEM_SIZE (128)
#define MAX_SOURCE_SIZE (0x100000)

int runCL(int width, int height)
{
cl_device_id device_id = NULL;
cl_context context = NULL;
cl_command_queue command_queue = NULL;
cl_mem memobj = NULL;
cl_program program = NULL;
cl_kernel kernel = NULL;
cl_platform_id platform_id = NULL;
cl_uint ret_num_devices;
cl_uint ret_num_platforms;
cl_int ret;
cl_command_queue cmd_queue[16];
int err;
cl_device_id devices[16];
cl_mem image;
 
char string[MEM_SIZE];
 
FILE *fp;
char fileName[] = "./mandelbrot.cl";
char *source_str;
size_t source_size;
size_t buffer_size = sizeof(char) * width * height * 3;
  char *host_image = (char *) malloc(buffer_size);
 
/* Load the source code containing the kernel*/
fp = fopen(fileName, "r");
if (!fp) {
fprintf(stderr, "Failed to load kernel.\n");
exit(1);
}
source_str = (char*)malloc(MAX_SOURCE_SIZE);
source_size = fread(source_str, 1, MAX_SOURCE_SIZE, fp);
fclose(fp);
 
/* Get Platform and Device Info */
ret = clGetPlatformIDs(1, &platform_id, &ret_num_platforms);
ret = clGetDeviceIDs(platform_id, CL_DEVICE_TYPE_DEFAULT, 1, &device_id, &ret_num_devices);
 
/* Create OpenCL context */
context = clCreateContext(NULL, 1, &device_id, NULL, NULL, &ret);
	check_succeeded("creating context", ret);
 
/* Create Command Queue */
command_queue = clCreateCommandQueue(context, device_id, 0, &ret);
	check_succeeded("creating queue", ret);
 
/* Create Memory Buffer */
memobj = clCreateBuffer(context, CL_MEM_READ_WRITE,MEM_SIZE * sizeof(char), NULL, &ret);
	check_succeeded("creating buffer", ret);
 
/* Create Kernel Program from the source */
program = clCreateProgramWithSource(context, 1, (const char **)&source_str,
(const size_t *)&source_size, &ret);
	check_succeeded("creating program", ret);
 
/* Build Kernel Program */
ret = clBuildProgram(program, 1, &device_id, NULL, NULL, NULL);
	check_succeeded("Building program", ret);

err = clGetContextInfo(context, CL_CONTEXT_DEVICES, sizeof(cl_device_id) * 16,
                         &devices, NULL);
  check_succeeded("Getting context info", err);

int i;
for(i = 0; i < ret_num_devices; i++) {
printf("%d\n", i);
cmd_queue[i] = clCreateCommandQueue(context, devices[i], 0, &err);
check_succeeded("Creating command queue", err);
}
   image	= clCreateBuffer(context, CL_MEM_WRITE_ONLY, buffer_size, NULL, &err);
  check_succeeded("Creating buffer", err);
    size_t offset;
kernel = clCreateKernel(program, "mandelbrot", &ret);
  check_succeeded("Create kernel", err);
  err  = clSetKernelArg(kernel, 0, sizeof(cl_mem), &image);
  check_succeeded("Setting kernel arg", err);


size_t device_work_size[2] = {width, height/ret_num_devices};
  for(i = 0; i < ret_num_devices; i++) {
    size_t device_work_offset[2] = {0, device_work_size[1]*i};
    offset = device_work_offset[1]*3*width;
    err = clEnqueueNDRangeKernel(cmd_queue[i], kernel, 2, device_work_offset,
                                 device_work_size, NULL, 0, NULL, NULL);
    check_succeeded("Running kernel", err);

    // Non-blocking read, so we can continue queuing up more kernels
    err = clEnqueueReadBuffer(cmd_queue[i], image, CL_FALSE, offset,
                              buffer_size/ret_num_devices,
                              host_image, 0, NULL, NULL);
    check_succeeded("Reading buffer", err);
  }
  for(i = 0; i < ret_num_devices; i++) {
    clFinish(cmd_queue[i]);
  }

  	return CL_SUCCESS;
}

int main(int argc, const char * argv[]) {
  runCL(1024, 1024);
  return 0;
}
