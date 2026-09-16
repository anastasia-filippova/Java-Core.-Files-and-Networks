import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtility {

    // GET-запрос
    public static String sendGetRequest(String urlString) throws IOException {

        URL url = new URL(urlString);

        // Открытие соединения
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Установка метода запроса
        connection.setRequestMethod("GET");

        // Получение кода ответа
        int responseCode = connection.getResponseCode();

        System.out.println("Код ответа: " + responseCode);

        // Чтение ответа
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }


    // POST-запрос
    public static String sendPostRequest(String urlString,String jsonPayload) throws IOException {

        URL url = new URL(urlString);

        // Открытие соединения
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Установка метода запроса
        connection.setRequestMethod("POST");

        // Установите флаг для добавления тела запроса
        connection.setDoOutput(true);

        // Указываем, что отправляем JSON
        connection.setRequestProperty("Content-Type","application/json");

        // Запись JSON в тело запроса
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonPayload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Получение кода ответа
        int responseCode = connection.getResponseCode();

        System.out.println("Код ответа: " + responseCode);

        // Чтение ответа
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }
}
