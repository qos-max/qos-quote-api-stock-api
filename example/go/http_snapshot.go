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
	url := "https://api.qos.hk/snapshot?key=your-api-key"
	method := "POST"

	payload := strings.NewReader(`{
		"codes": [
			"US:AAPL,TSLA",
			"HK:700,9988",
			"SH:600519,600518",
			"SZ:000001,002594",
			"CF:BTCUSDT"
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
