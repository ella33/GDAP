import pyopencl as cl
import numpy as np

platform = cl.get_platforms()[0]
device = platform.get_devices()[0]
ctx = cl.Context([device])

queue = cl.CommandQueue(ctx)

a = np.array(np.arange(10), dtype=np.int32)

b = np.empty(a.shape, dtype=np.int32)

a_dev = cl.Buffer(ctx, cl.mem_flags.READ_ONLY | cl.mem_flags.COPY_HOST_PTR,
                    hostbuf=a)

b_dev = cl.Buffer(ctx, cl.mem_flags.WRITE_ONLY, b.nbytes)

code = """
__kernel void test1(__global int* a, __global int* b) {
    int i = get_global_id(0);
    b[i] = a[i]*a[i];
}
"""

prg = cl.Program(ctx, code).build()

event = prg.test1(queue, a.shape, None, a_dev, b_dev)
event.wait()

cl.enqueue_copy(queue, b, b_dev)

print(b)
