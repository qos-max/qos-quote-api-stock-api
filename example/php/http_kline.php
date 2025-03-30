<?php

$curl = curl_init();
//官网：https://qos.hk
//免费api key注册申请：https://qos.hk
curl_setopt_array($curl, array(
  CURLOPT_URL => 'https://api.qos.hk/kline?key=your-api-key',
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => '',
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 0,
  CURLOPT_FOLLOWLOCATION => true,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => 'POST',
  CURLOPT_POSTFIELDS =>'{
    "kline_reqs":[
        {"c":"US:AAPL,TSLA","co":1,"a":0,"kt":1001},
        {"c":"SH:600519","co":1,"a":0,"kt":1001},
        {"c":"SZ:000001","co":1,"a":0,"kt":1001},
        {"c":"HK:700","co":1,"a":0,"kt":1001},
        {"c":"CF:BTCUSDT","co":2,"a":0,"kt":1001}
    ]
}',
  CURLOPT_HTTPHEADER => array(
    'Content-Type: application/json'
  ),
));

$response = curl_exec($curl);

curl_close($curl);
echo $response;
