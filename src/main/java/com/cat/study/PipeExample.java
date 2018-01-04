package com.cat.study;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream output = new PipedOutputStream();
//        final PipedInputStream input = new PipedInputStream(output);
        final PipedInputStream input = new PipedInputStream();
        input.connect(output);

        Thread thread1 = new Thread(() -> {
            try {
                output.write("Hello world, pipe!".getBytes());
            } catch (IOException e) {
                //ignore
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                int data = input.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = input.read();
                }
            } catch (IOException e) {
            }
        });

        thread1.start();
        thread2.start();

    }
}