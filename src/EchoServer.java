import java.io.*;
import java.net.*;

public class EchoServer {

    public static void main(String[] args) {

        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Сервер запущен. Ожидание подключения...");

            while (true) {

                Socket clientSocket = serverSocket.accept();

                System.out.println("Клиент подключился!");

                BufferedReader input = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())
                );

                PrintWriter output = new PrintWriter(
                        clientSocket.getOutputStream(), true
                );

                String message = input.readLine();

                System.out.println("Получено сообщение: " + message);

                output.println(message);

                clientSocket.close();
            }

        } catch (IOException e) {
            System.out.println("Ошибка сервера: " + e.getMessage());
        }
    }
}

