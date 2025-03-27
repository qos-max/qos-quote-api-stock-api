<?php
require_once __DIR__ . '/vendor/autoload.php';

use Workerman\Worker;
use Workerman\Connection\AsyncTcpConnection;
use Workerman\Timer;
//官网：https://qos.hk
//免费api key注册申请：https://qos.hk
$worker = new Worker('http://0.0.0.0:8081');
$worker->onWorkerStart = function() {
    $ws_connection = new AsyncTcpConnection("ws://qos.hk:443/ws?key=Your-API-Key");
    
    $ws_connection->transport = 'ssl';
    
    $ws_connection->onConnect = function($connection) {
        echo "[" . date('Y-m-d H:i:s') . "]Connected to WSS server\n";
        // 启动定时器，每20秒发送一次心跳
        $timer_id = Timer::add(20, function() use ($connection) {
            $heartbeat = json_encode(['type' => 'H']);
            $connection->send($heartbeat);
            echo "[" . date('Y-m-d H:i:s') . "] Sent heartbeat: {$heartbeat}\n";
        });
        
        // 将定时器ID保存到连接对象中，以便后续清理
        $connection->timer_id = $timer_id;
        
		    // 发送第1个订阅
		    $connection->send('{"type": "K","codes": ["CF:ETHUSDT,BTCUSDT"],"kt":1001}');
        
        // 1秒后发送第2个订阅
        Timer::add(1, function() use ($connection) {
            $connection->send('{"type": "T","codes": ["US:AAPL,TSLA"]}');
            echo "[" . date('Y-m-d H:i:s') . "] Sent sub msg\n";
        }, null, false);
        
        // 2秒后发送第3个订阅
        Timer::add(2, function() use ($connection) {
            $connection->send('{"type": "S","codes": ["HK:700","SZ:000001","SH:600519"]}');
            echo "[" . date('Y-m-d H:i:s') . "] Sent sub msg\n";
        }, null, false);
        
        // 3秒后发送第4个订阅
        Timer::add(3, function() use ($connection) {
            $connection->send('{"type": "D","codes": ["HK:700","SZ:000001","SH:600519"]}');
            echo "[" . date('Y-m-d H:i:s') . "] Sent sub msg\n";
        }, null, false);

    };
    
    $ws_connection->onMessage = function($connection, $data) {
        echo "Received: $data\n";
    };
    
    $ws_connection->onClose = function($connection) {
        echo "Connection closed, reconnecting...\n";
        $connection->reConnect(5);
    };
    
    $ws_connection->onError = function($connection, $code, $msg) {
        echo "Error: $msg\n";
    };
    
    $ws_connection->connect();
};

Worker::runAll();
