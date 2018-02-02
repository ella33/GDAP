all: mandelbrot

run: mandelbrot
	./mandelbrot

mandelbrot: *.c *.h
	gcc -Wall -o mandelbrot -pthread -lrt *.c -lm

clean:
	-rm mandelbrot mandelbrot.zip *.png report.txt

pack:
	-rm mandelbrot.zip
	zip mandelbrot.zip ./*.h ./*.c Makefile

.PHONY: all clean run pack
