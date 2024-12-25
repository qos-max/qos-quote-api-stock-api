**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/postman/README.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/postman/README_en.md)**
# 使用PostMan快速体验QOS报价系统
一旦您使用了postman里面就可以直接请求访问到数据。并且postman自动生成了相关的调用示例。</br>
简单入门流程：</br>
注册key->请求http接口或者订阅websocket实时行情报价。</br>
## 一、http接口
### 1.1、直接Fork
- **postman项目连接：** </br> [https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview](https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview) </br>
可以直接使用postman工具进行fork使用。
### 1.2、通过Json文件导入到PostMan
在[json_file](https://github.com/qos-max/quote-ocean-system/tree/main/postman/json_file)目录的json文件可以直接导入到postman中供您使用体验。</br>
- 先导入[RegisterKey.postman_collection.json](https://github.com/qos-max/quote-ocean-system/blob/main/postman/json_file/RegisterKey.postman_collection.json)文件，进行注册key。</br>
- 再导入[API-http.postman_collection.json](https://github.com/qos-max/quote-ocean-system/blob/main/postman/json_file/API-http.postman_collection.json)文件进行直接请求数据。</br>

---

## 二、websocket接口
### 2.1、直接Fork
- **postman项目连接：** [https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview](https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview)
可以直接使用postman工具进行fork使用。
### 2.2、手动添加到PostMan中
下面介绍在postman中手动添加QOS报价系统的websocket的步骤方法：
#### 2.2.1、添加一个collections叫做：API-WebSocket，模板选择websocket basics,如下图：
![image](https://github.com/user-attachments/assets/9c42d09b-3331-4381-8000-d41c3410553d)

![image](https://github.com/user-attachments/assets/10b9993b-ea5a-4ada-b180-a5f2a9bd88e5)
#### 2.2.2、添加一个websocket请求，点击刚才添加的API-WebSocket后面三个...，如下图，选择添加Websocket的请求。
![image](https://github.com/user-attachments/assets/e0410015-1971-4100-b3b5-454d3a95d1c1)
#### 2.2.3、添加websocket请求的细节：
![image](https://github.com/user-attachments/assets/36214d69-359d-46d1-b06a-0fa2eb073a04)
![image](https://github.com/user-attachments/assets/3187da31-a4ff-4754-a76e-1fabefc4a3f6)
#### 2.2.4、添加websocket请求用到的参数：
- **websocket地址：** wss://api.qos.hk/ws
- **key:** 通过调用[注册Key](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#41%E6%B3%A8%E5%86%8C%E4%B8%80%E4%B8%AA%E6%96%B0%E7%9A%84Key)接口获取，注意保存获取的key信息。
- **message-发送心跳:**
```json
{"type":"H"}
```
- **message-订阅实时快照t:**
```json
{
    "type": "S",
    "codes": [
        "US:AAPL",
        "HK:700,9988",
        "SH:600519,688981,601127,600938,601727,600837",
        "SZ:002594"
    ]
}
```
- **message-订阅实时交易明细:**
```json
{
    "type": "T",
    "codes": [
        "US:AAPL",
        "HK:700,9988",
        "SH:600519,688981,601127,600938,601727,600837",
        "SZ:002594"
    ]
}
```
- **message-订阅实时盘口:**
```json
{
    "type": "D",
    "codes": [
        "US:AAPL",
        "HK:700,9988",
        "SH:600519,688981,601127,600938,601727,600837",
        "SZ:002594"
    ]
}
```
到此已经添加完成可以请求到数据了。但是postman并不会为websocket自动生成示例代码，关于websocket的示例代码会另外单独提供。
