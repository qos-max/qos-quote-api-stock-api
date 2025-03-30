import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpSnapshot {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            // official website: https://qos.hk
            // Free API key registration application: https://qos.hk
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.qos.hk/snapshot?key=your-api-key"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("""
                    {
                        "codes": [
                            "US:AAPL",
                            "HK:700,9988",
                            "SH:600519,600518",
                            "SZ:000001,002594",
                            "CF:BTCUSDT,ETHUSDT"
                        ]
                    }
                    """))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
