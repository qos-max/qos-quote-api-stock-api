<?php

$curl = curl_init();
//官网：https://qos.hk
//免费api key注册申请：https://qos.hk
curl_setopt_array($curl, array(
  CURLOPT_URL => 'https://api.qos.hk/snapshot?key=your-api-key',
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => '',
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 0,
  CURLOPT_FOLLOWLOCATION => true,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => 'POST',
  CURLOPT_POSTFIELDS =>'{
    "codes": [
        "US:TQQQ",
        "HK:700,9988",
        "SH:600519,600518",
        "SZ:000001,002594",
        "CF:BTCUSDT,ETHUSDT"
    ]
}',
  CURLOPT_HTTPHEADER => array(
    'Content-Type: application/json'
  ),
));

$response = curl_exec($curl);

curl_close($curl);
echo $response;
