package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");

        Files.copy(source, target, REPLACE_EXISTING);  // 자바에 파일을 메모리에 올리지 않고 바로 복사하여 성능이 좋다.
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
