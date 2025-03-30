package main

import (
	"fmt"
	"github.com/gorilla/websocket"
	"log"
	"time"
)

func main() {
	url := "wss://api.qos.hk/ws"
	apiKey := "your-api-key" //替换你的api key

	// 建立WebSocket连接
	conn, _, err := websocket.DefaultDialer.Dial(url+"?key="+apiKey, nil)
	if err != nil {
		log.Fatal("连接WebSocket失败:", err)
	}
	defer conn.Close()

	// 发送订阅行情快照消息
	subscribeMessage := `{"type":"S","codes":["US:AAPL","HK:700,9988","CF:BTCUSDT","SZ:000001","SH:600519"],"reqid":1}`
	err = conn.WriteMessage(websocket.TextMessage, []byte(subscribeMessage))
	if err != nil {
		log.Fatal("发送订阅消息失败:", err)
	}

	go func() {
		time.Sleep(1 * time.Second)
    // 发送订阅最新成交
		subscribeMessage = `{"type":"T","codes":["US:AAPL","HK:700,9988","CF:BTCUSDT","SZ:000001","SH:600519"],"reqid":1}`
		err = conn.WriteMessage(websocket.TextMessage, []byte(subscribeMessage))
		if err != nil {
			log.Fatal("发送订阅消息失败:", err)
		}

		time.Sleep(2 * time.Second)
    // 发送订阅深度盘口
		subscribeMessage = `{"type":"D","codes":["US:AAPL","HK:700,9988","CF:BTCUSDT","SZ:000001","SH:600519"],"reqid":1}`
		err = conn.WriteMessage(websocket.TextMessage, []byte(subscribeMessage))
		if err != nil {
			log.Fatal("发送订阅消息失败:", err)
		}
		
		time.Sleep(3 * time.Second)
    // 发送订阅K线
		subscribeMessage = `{"type":"K","codes":["CF:BTCUSDT"],"kt":1001,reqid":1}`
		err = conn.WriteMessage(websocket.TextMessage, []byte(subscribeMessage))
		if err != nil {
			log.Fatal("发送订阅消息失败:", err)
		}
	}()

	// 发送心跳包
	go func() {
		for {
			heartbeatMessage := `{"type":"H"}`
			err := conn.WriteMessage(websocket.TextMessage, []byte(heartbeatMessage))
			if err != nil {
				log.Fatal("发送心跳包失败:", err)
			}
			time.Sleep(20 * time.Second) // 每20秒发送一次心跳包
		}
	}()

	// 读取并打印消息
	for {
		_, msg, err := conn.ReadMessage()
		if err != nil {
			log.Fatal("读取消息失败:", err)
		}
		fmt.Println("接收到消息:", string(msg))
	}

	// 保持连接
	time.Sleep(120 * time.Second) // 保持连接120秒
}
