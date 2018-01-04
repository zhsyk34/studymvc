package com.cat.jdk;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//https://docs.oracle.com/javase/tutorial/essential/io/legacy.html
public class PathStudy {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("e:/down", "aio12.zip");
        System.out.println(Files.size(path));

        File file = path.toFile();

    }
}
