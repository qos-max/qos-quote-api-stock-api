import requests
import json

# 官网：https://qos.hk
# 免费api key注册申请：https://qos.hk
url = "https://api.qos.hk/kline?key=your-api-key"

payload = json.dumps({
  "kline_reqs": [
    {
      "c": "US:AAPL,TSLA",
      "co": 1,
      "a": 0,
      "kt": 1001
    },
    {
      "c": "SH:600519",
      "co": 1,
      "a": 0,
      "kt": 1001
    },
    {
      "c": "SZ:000001",
      "co": 1,
      "a": 0,
      "kt": 1001
    },
    {
      "c": "HK:700",
      "co": 1,
      "a": 0,
      "kt": 1001
    },
    {
      "c": "CF:BTCUSDT",
      "co": 2,
      "a": 0,
      "kt": 1001
    }
  ]
})
headers = {
  'Content-Type': 'application/json'
}

response = requests.request("POST", url, headers=headers, data=payload)

print(response.text)
