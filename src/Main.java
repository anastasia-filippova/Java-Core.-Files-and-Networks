import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String jsonPayload =
                "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        String responsePostRequest = HttpUtility.sendPostRequest("https://jsonplaceholder.typicode.com/posts",jsonPayload);

        System.out.println(responsePostRequest);

        String responseGetRequest = HttpUtility.sendGetRequest(
                "https://jsonplaceholder.typicode.com/posts/1"
        );

        System.out.println(responseGetRequest);
    }

}