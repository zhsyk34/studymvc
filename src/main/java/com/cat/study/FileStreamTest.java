package com.cat.study;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileStreamTest {

    public static void main(String[] args) throws FileNotFoundException {
        new FileOutputStream("path", true);
    }
}
