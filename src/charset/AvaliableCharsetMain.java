package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvaliableCharsetMain {

    public static void main(String[] args) {
        //이용 가능한 모든 charset 자바 + os
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (String s : charsets.keySet()) {
            System.out.println("s = " + s);
        }

        System.out.println("=====");

        //문자로 조회
        Charset charset1 = Charset.forName("MS949");
        System.out.println("charset1 = " + charset1);

        //별칭 조회
        Set<String> aliases = charset1.aliases();
        for (String alias : aliases) {
            System.out.println("alias = " + alias);
        }

        //UTF-8
        Charset charset2 = Charset.forName("UTF-8");
        System.out.println("charset2 = " + charset2);

        //UTF-8 상수로 조회
        System.out.println("charset3 = " + StandardCharsets.UTF_8);

        // 시스템의 기본 Charset조회
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);
    }
}
