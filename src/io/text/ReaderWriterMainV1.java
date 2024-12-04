package io.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        // 문자 - byte UTF-9 encoding
        byte[] writerBytes = writeString.getBytes(UTF_8);
        System.out.println("write String = " + writeString);
        System.out.println("write Bytes = " + Arrays.toString(writerBytes));

        //파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writerBytes);
        fos.close();

        //파일 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readBytes = fis.readAllBytes();
        fis.close();

        System.out.println("read String = " + new String(readBytes, UTF_8)); // 디코딩
        System.out.println("read Bytes = " + Arrays.toString(readBytes));
    }
}
