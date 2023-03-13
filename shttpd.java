package nhn;

import java.io.*;
import java.net.*;

public class shttpd {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt("8080"); // 포트번호를 인자로 받습니다.
        ServerSocket serverSocket = new ServerSocket(port); // 입력받은 포트번호로 listen 합니다.
        String documentRoot = System.getProperty("user.dir"); // 프로그램이 실행된 디렉토리를 document-root 로 지정합니다.

        while (true) {
            Socket clientSocket = serverSocket.accept(); // 클라이언트의 요청을 받습니다.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = in.readLine(); // 요청 메시지의 첫 줄을 읽어옵니다.

            if (request.startsWith("GET / ")) { // GET / 요청인 경우
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html");
                out.println();

                File[] files = new File(documentRoot).listFiles(); // 현재 폴더 내부 목록을 구합니다.

                out.println("<html><body><ul>");
                for (File file : files) {
                    out.println("<li>" + file.getName() + "</li>"); // 각 파일을 <li> 태그로 감싸서 출력합니다.
                }
                out.println("</ul></body></html>");

                out.close();
            }

            clientSocket.close();
        }
    }
}
