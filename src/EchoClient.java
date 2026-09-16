import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) {

        String serverAddress = "127.0.0.1";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port)) {

            System.out.println("Подключение к серверу...");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            String message = "Привет, сервер!";

            output.println(message);

            System.out.println("Отправлено сообщение: " + message);

            String response = input.readLine();

            System.out.println("Ответ от сервера: " + response);

        } catch (IOException e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
        }
    }
}