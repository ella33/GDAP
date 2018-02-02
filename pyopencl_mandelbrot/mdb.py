from __future__ import absolute_import
from __future__ import print_function

import time

import numpy as np

import pyopencl as cl
from six.moves import range
from device_info import printDeviceInfo

w = 1024
h = 1024

def calc_fractal_opencl(q, maxiter):
    platform = cl.get_platforms()[0]
    device = platform.get_devices()[0]
    ctx = cl.Context([device])
    queue = cl.CommandQueue(ctx)

    output = np.empty(q.shape, dtype=np.uint16)

    mf = cl.mem_flags
    q_opencl = cl.Buffer(ctx, mf.READ_ONLY | mf.COPY_HOST_PTR, hostbuf=q)
    output_opencl = cl.Buffer(ctx, mf.WRITE_ONLY, output.nbytes)

    prg = cl.Program(ctx, """
    #pragma OPENCL EXTENSION cl_khr_byte_addressable_store : enable
    __kernel void mandelbrot(__global float2 *q,
                     __global ushort *output, ushort const maxiter)
    {
        int gid = get_global_id(0);
        float nreal, real = 0;
        float imag = 0;
        output[gid] = 0;
        for(int curiter = 0; curiter < maxiter; curiter++) {
            nreal = real*real - imag*imag + q[gid].x;
            imag = 2* real*imag + q[gid].y;
            real = nreal;
            if (real*real + imag*imag > 4.0f)
                 output[gid] = curiter;
        }
    }
    """).build()

    prg.mandelbrot(queue, (20, 16), None, q_opencl,
                   output_opencl, np.uint16(maxiter))


    return output

if __name__ == '__main__':
    try:
        import six.moves.tkinter as tk
    except ImportError:
        # Python 3
        import tkinter as tk
    from PIL import Image, ImageTk

    class Mandelbrot(object):
        def __init__(self):
            # create window
            self.root = tk.Tk()
            self.root.title("Mandelbrot Set")
            self.create_image()
            self.create_label()
            # start event loop
            self.root.mainloop()

        def draw(self, x1, x2, y1, y2, maxiter=30):
            # draw the Mandelbrot set
            xx = np.arange(x1, x2, (x2-x1)/w)
            yy = np.arange(y2, y1, (y1-y2)/h) * 1j
            q = np.ravel(xx+yy[:, np.newaxis]).astype(np.complex64)

            start_main = time.time()
            output = calc_fractal_opencl(q, maxiter)
            end_main = time.time()

            secs = end_main - start_main
            print("Main took", secs)

            self.mandel = (output.reshape((h, w)) /
                           float(output.max()) * 255.).astype(np.uint8)

        def create_image(self):
            """"
            create the image from the draw() string
            """
            # you can experiment with these x and y ranges
            self.draw(-4, 2.77, -6.3, 3.3)
            self.im = Image.fromarray(self.mandel)
            self.im.putpalette([i for rgb in ((0, j, j) for j in range(255))
                                for i in rgb])
            self.im.save("Mandelbrot_" + str(int(time.time())) + ".bmp")

        def create_label(self):
            # put the image on a label widget
            self.image = ImageTk.PhotoImage(self.im)
            self.label = tk.Label(self.root, image=self.image)
            self.label.pack()

    printDeviceInfo()
    test = Mandelbrot()
