package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class OldFilePath {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println("path: " + file.getPath());

        //절대 경로
        System.out.println("Absolute path: " + file.getAbsolutePath());

        //정규 경로
        System.out.println("Canonical path: " + file.getCanonicalPath());

        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> System.out.println((f.isFile() ? "F" : "D") + " | " + f.getName()));
    }
}
