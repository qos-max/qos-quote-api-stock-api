import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpKline {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            // official website:https://qos.hk
            // Free API key registration application.https://qos.hk
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.qos.hk/kline?key=your-api-key"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("""
                    {
                        "kline_reqs":[
                            {"c":"US:AAPL,TSLA","co":1,"a":0,"kt":1001},
                            {"c":"SH:600519","co":1,"a":0,"kt":1001},
                            {"c":"SZ:000001","co":1,"a":0,"kt":1001},
                            {"c":"HK:700","co":1,"a":0,"kt":1001},
                            {"c":"CF:BTCUSDT","co":2,"a":0,"kt":1001}
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

