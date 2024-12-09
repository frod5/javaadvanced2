package network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        //TCP 규율상 FIN 을 받으면 FIN을 보내야한다.
        //그러나 강제로 메세지를 보내면 서버는 RST를 보낸다.

        // client <- server: FIN
        Thread.sleep(1000); // 서버가 close() 호출할 때 까지 잠시 대기

        // client -> server: PUSH[1]
        output.write(1);

        // client <- server: RST
        Thread.sleep(1000); // RST 메세지 전송 대기

        try {
            // java.net.SocketException: Connection reset
            int read = input.read();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            // java.net.SocketException: Broken pipe
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
