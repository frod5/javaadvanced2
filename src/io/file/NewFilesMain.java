package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class NewFilesMain {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        System.out.println("Files.exists(): " + Files.exists(file));

        try {
            Files.createFile(file);
            System.out.println("File created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + " already exists");
        }

        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException e) {
            System.out.println(directory + " already exists");
        }

//        Files.delete(file);
//        System.out.println("Files deleted");

        System.out.println("Is Regular File" + Files.isRegularFile(file)); // 파일 확인
        System.out.println("Is directory" + Files.isDirectory(directory)); // 디렉토리 확인

        System.out.println("file Name: " + file.getFileName()); // 파일명
        System.out.println("file size: " + Files.size(file) + " bytes"); // 파일 크기

        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File move/renamed");

        System.out.println("last modified: " + Files.getLastModifiedTime(newFile));
        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("==== Attributes ====");
        System.out.println("Creation time: " + attrs.creationTime());
        System.out.println("isDirectory: " + attrs.isDirectory());
        System.out.println("isRegularFile: " + attrs.isRegularFile());
        System.out.println("isSymbolicLink: " + attrs.isSymbolicLink());
        System.out.println("size: " + attrs.size());
    }
}
