# Use PostMan to Quickly Experience the QOS Quotation System
Once you use PostMan, you can directly request access to data. PostMan also automatically generates related invocation examples.</br>
Quick start process:</br>
Register a key -> Request HTTP interfaces or subscribe to WebSocket real-time market quotations.</br>

## 一、HTTP Interface
### 1.1 Direct Fork
- **PostMan Project Link:** [https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview](https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview)
You can directly fork and use it with the PostMan tool.

### 1.2 Import JSON File into PostMan
The JSON files in the [json_file](https://github.com/qos-max/quote-ocean-system/tree/main/postman/json_file) directory can be directly imported into PostMan for use and experience.</br>
- First, import the [RegisterKey.postman_collection.json](https://github.com/qos-max/quote-ocean-system/blob/main/postman/json_file/RegisterKey.postman_collection.json) file to register the key.</br>
- Then, import the [API-http.postman_collection.json](https://github.com/qos-max/quote-ocean-system/blob/main/postman/json_file/API-http.postman_collection.json) file to directly request data.</br>

---

## 二、WebSocket Interface
### 2.1 Direct Fork
- **PostMan Project Link:** [https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview](https://www.postman.com/telecoms-cosmonaut-98667288/qos-us-hk-sh-sz-stock-realtime-quote-api/overview)
You can directly fork and use it with the PostMan tool.

### 2.2 Manually Add to PostMan
Below are the steps to manually add the QOS Quotation System WebSocket in PostMan:

#### 2.2.1 Add a Collection Named `API-WebSocket`, and select the WebSocket Basics template, as shown below:
![image](https://github.com/user-attachments/assets/9c42d09b-3331-4381-8000-d41c3410553d)

![image](https://github.com/user-attachments/assets/10b9993b-ea5a-4ada-b180-a5f2a9bd88e5)

#### 2.2.2 Add a WebSocket Request
Click on the three dots (...) next to the newly created `API-WebSocket` collection and select `Add WebSocket Request`, as shown below:
![image](https://github.com/user-attachments/assets/e0410015-1971-4100-b3b5-454d3a95d1c1)

#### 2.2.3 Configure WebSocket Request Details
![image](https://github.com/user-attachments/assets/36214d69-359d-46d1-b06a-0fa2eb073a04)
![image](https://github.com/user-attachments/assets/3187da31-a4ff-4754-a76e-1fabefc4a3f6)

#### 2.2.4 Add Parameters for the WebSocket Request
- **WebSocket Address:** wss://api.qos.hk/ws
- **Key:** Obtain the key through the `Register Key` API. Be sure to save the retrieved key information.
- **Message - Send Heartbeat:**
```json
{"type":"H"}
```
- **Message - Subscribe to Real-Time Snapshots:**
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
- **Message - Subscribe to Real-Time Trades:**
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
- **Message - Subscribe to Real-Time Order Book:**
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

At this point, the configuration is complete, and you can request data. However, PostMan does not automatically generate example code for WebSocket requests. WebSocket example code will be provided separately.
