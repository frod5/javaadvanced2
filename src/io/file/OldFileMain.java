package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("File exists(): " + file.exists());
        boolean created = file.createNewFile(); // 파일생성
        System.out.println("created = " + created);

        boolean dirCreated = directory.mkdir(); // 디렉토리 생성
        System.out.println("dirCreated = " + dirCreated);

//        boolean deleted = file.delete(); // 파일삭제
//        System.out.println("deleted = " + deleted);

        System.out.println("Is file: " + file.isFile());  // 파일 확인
        System.out.println("Is Directory: " + directory.isDirectory()); // 디렉토리 확인
        System.out.println("File name: " + file.getName()); // 파일명 확인
        System.out.println("File length: " + file.length() + " bytes"); // 파일 크기

        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile); // 파일명 변경
        System.out.println("renamed = " + renamed);

        long lastModified = newFile.lastModified(); // 최종 수정 일시
        System.out.println("lastModified = " + new Date(lastModified));
    }
}
