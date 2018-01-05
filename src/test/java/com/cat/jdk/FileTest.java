package com.cat.jdk;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class FileTest {

    @Test
    public void test1() throws IOException {
        RandomAccessFile file = new RandomAccessFile("", "rw");

        file.seek(200);

        long pointer = file.getFilePointer();
        System.out.println(pointer);

        file.close();
    }

    @Test
    public void test2() throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader("Mary had 1 little lamb..."));

        while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println(streamTokenizer.sval);
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(streamTokenizer.nval);
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println();
            }
        }
    }
}
