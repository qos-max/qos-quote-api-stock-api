import websocket
import time
import threading
import json

# WebSocket URL（根据实际情况替换）
url = "wss://api.qos.hk/ws"
# API Key（替换为你的API Key）
# 官网：https://qos.hk
# 免费api key注册申请：https://qos.hk
api_key = "your-api-key"

def on_message(ws, message):
    print("接收到消息:", message)

def on_error(ws, error):
    print("错误:", error)

def on_close(ws, close_status_code, close_msg):
    print("连接关闭")

def on_open(ws):
    # 发送初始订阅行情快照消息
    subscribe_message_1 = json.dumps({
        "type": "S",
        "codes": [
            "US:AAPL",
            "HK:700,9988",
            "CF:BTCUSDT",
            "SZ:000001",
            "SH:600519"
        ],
        "reqid": 1
    })
    ws.send(subscribe_message_1)

    # 2秒后发送第二个订阅命令
    def send_second_subscription():
        time.sleep(1)
        subscribe_message_2 = json.dumps({
            "type": "T",
            "codes": [
                "US:AAPL",
                "HK:700,9988",
                "CF:BTCUSDT",
                "SZ:000001",
                "SH:600519"
            ],
            "reqid": 1
        })
        ws.send(subscribe_message_2)
        
        time.sleep(1)
        
        subscribe_message_2 = json.dumps({
            "type": "D",
            "codes": [
                "US:AAPL",
                "HK:700,9988",
                "CF:BTCUSDT",
                "SZ:000001",
                "SH:600519"
            ],
            "reqid": 1
        })
        ws.send(subscribe_message_2)
        
        time.sleep(1)
        
        subscribe_message_2 = json.dumps({
            "type": "K",
            "codes": [
                "CF:BTCUSDT",
            ],
            "kt":1001,
            "reqid": 1
        })
        ws.send(subscribe_message_2)

    threading.Thread(target=send_second_subscription).start()
    
    # 发送心跳包（每20秒）
    def send_heartbeat():
        while True:
            time.sleep(20)
            heartbeat_message = json.dumps({"type":"H"})
            ws.send(heartbeat_message)
            print("发送心跳包")

    threading.Thread(target=send_heartbeat, daemon=True).start()

# 创建WebSocket连接
ws = websocket.WebSocketApp(url + "?key=" + api_key,
                            on_message=on_message,
                            on_error=on_error,
                            on_close=on_close,
                            on_open=on_open)

# 运行WebSocket连接
ws.run_forever()

