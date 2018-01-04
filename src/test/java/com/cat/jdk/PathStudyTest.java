package com.cat.jdk;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

//TODO spock:测试工具
public class PathStudyTest {

    @Test
    public void name() throws IOException {
        FileChannel.open(Paths.get(""));
    }
}