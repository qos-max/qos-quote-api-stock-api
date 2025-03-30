import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class WSSClient {
    public static void main(String[] args) {
        try {
            // WebSocket URL
            //官网：https://qos.hk
            //免费api key注册申请：https://qos.hk
            String url = "wss://api.qos.hk/ws?key=your-api-key";
            
            WebSocketClient client = new WebSocketClient(new URI(url)) {
                @Override
                public void onOpen(ServerHandshake handshake) {
                    System.out.println("WebSocket 连接成功！");
                    
                    send("""
                    {"type":"S","codes":["US:AAPL","HK:700,9988","CF:BTCUSDT","SZ:000001","SH:600519"],"reqid":1}
                    """);
                    
                    new Thread(() -> {
                        try {
                            Thread.sleep(1000);
                            send("""
                            {"type":"T","codes":["US:AAPL","HK:700,9988","CF:BTCUSDT","SZ:000001","SH:600519"],"reqid":1}
                            """);
                            Thread.sleep(1000);
                            send("""
                            {"type":"D","codes":["US:AAPL","HK:700,9988","CF:BTCUSDT","SZ:000001","SH:600519"],"reqid":1}
                            """);
                            Thread.sleep(1000);
                            send("""
                            {"type":"K","codes":["CF:BTCUSDT"],"kt":1001,"reqid":1}
                            """);

                        } catch (InterruptedException e) {
                            System.err.println("WebSocket send error: " + e.getMessage());
                        }
                    }).start();
                    
                    // 启动心跳，每 20 秒发送一次
                    Timer timer = new Timer(true);
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            send("{\"action\":\"ping\"}");
                            System.out.println("发送心跳包");
                        }
                    }, 20000, 20000);
                }

                @Override
                public void onMessage(String message) {
                    System.out.println("收到消息: " + message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("WebSocket 连接关闭: " + reason);
                }

                @Override
                public void onError(Exception ex) {
                    System.out.println("WebSocket 错误: " + ex.getMessage());
                }
            };

            client.connect();

        }catch (URISyntaxException e) {
            System.err.println("WebSocket URL 格式错误: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("WebSocket 连接失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

