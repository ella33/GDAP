C = gcc
CFLAGS = -std=c99
OPENCL = -lOpenCL

all: mandelbrot

mandelbrot: main.c bmp.o cl_helper.o
	$(C) $(CFLAGS) -o mandelbrot main.c bmp.o cl_helper.o $(OPENCL)

bmp.o: bmp.c bmp.h
	$(C) $(CFLAGS) -c bmp.c

cl_helper.o: cl_helper.c cl_helper.h
	$(C) $(CFLAGS) -c cl_helper.c


clean:
	rm -f mandelbrot output.bmp *.o
