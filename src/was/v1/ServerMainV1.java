package was.v1;

import java.io.IOException;

public class ServerMainV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpSeverV1 httpSeverV1 = new HttpSeverV1(PORT);
        httpSeverV1.start();
    }
}
