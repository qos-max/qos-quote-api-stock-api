package main

import (
	"fmt"
	"io"
	"net/http"
	"strings"
)

func main() {
	//官网：https://qos.hk
	//免费api key注册申请：https://qos.hk
	url := "https://api.qos.hk/kline?key=your-api-key"
	method := "POST"

	payload := strings.NewReader(`{
		"kline_reqs":[
			{"c":"US:AAPL,TSLA","co":1,"a":0,"kt":1001},
			{"c":"SH:600519","co":1,"a":0,"kt":1001},
			{"c":"SZ:000001","co":1,"a":0,"kt":1001},
			{"c":"HK:700","co":1,"a":0,"kt":1001},
			{"c":"CF:BTCUSDT","co":2,"a":0,"kt":1001}
		]
	}`)

	client := &http.Client{}
	req, err := http.NewRequest(method, url, payload)

	if err != nil {
		fmt.Println(err)
		return
	}
	req.Header.Add("Content-Type", "application/json")

	res, err := client.Do(req)
	if err != nil {
		fmt.Println(err)
		return
	}
	defer res.Body.Close()

	body, err := io.ReadAll(res.Body)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(string(body))
}
