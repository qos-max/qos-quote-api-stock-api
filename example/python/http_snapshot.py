import requests
import json

# 官网：https://qos.hk
# 免费api key注册申请：https://qos.hk
url = "https://api.qos.hk/snapshot?key=your-api-key"

payload = json.dumps({
  "codes": [
    "US:AAPL",
    "HK:700,9988",
    "SH:600519,600518",
    "SZ:000001,002594",
    "CF:BTCUSDT,ETHUSDT"
  ]
})
headers = {
  'Content-Type': 'application/json'
}

response = requests.request("POST", url, headers=headers, data=payload)

print(response.text)
