**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/api.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md)**
# QOS Quote API(Quote Ocean System API) Documentation
**The quote-ocean-system, abbreviated as "QOS Market Data API," includes real-time APIs for Hong Kong stocks, U.S. stocks, and A-shares. It utilizes REST API and WebSocket interfaces, making it very easy to integrate. This is a free and open-source stock API providing real-time stock data for Hong Kong stocks, U.S. stocks, and mainland China stocks (A-shares). The QOS Market Data System currently offers real-time quotes, real-time K-line, and historical K-line data for stocks across Hong Kong, the United States, and mainland China. Free trials and integration support are available—feel free to contact the author for further details.**
- **official website**：[https://qos.hk](https://qos.hk)
- **Author**: Max  
- **Last Updated**: 2024-12-16  
- **HTTP Base URL**: `https://api.qos.hk`  
- **WebSocket URL**: `wss://api.qos.hk/ws`  
- **Authentication**: Add the `key` field in the request header.  
- **Error Code Explanation**: A "msg" field value of "OK" indicates success; otherwise, it provides specific error details.  
- **Format**: All requests and responses use JSON format.  
- **Request Method**: All HTTP requests use the POST method.  

## Contact the Author:
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)  
- **Skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)
- **telegram group**: [https://t.me/stock_quote_api_hk_us_ashre_api](https://t.me/stock_quote_api_hk_us_ashre_api)

## 1. Quick Start - Integration Guide
### 1.1 Register a Key
- **official website**：[https://qos.hk](https://qos.hk)

After registering with your email, you will receive key-related information. Please keep it safe, as it will be used in subsequent steps.  

### 1.2 Request HTTP API
Include the key in the request header by filling the `key` field. Then, use the parameters defined for each HTTP interface to fetch the data.  
[1.2.1 HTTP Protocol Access Instructions](#40-http-protocol-access-description)  
[1.2.2 Retrieve Basic Information for Trading Instruments](#42-retrieve-basic-instrument-information)  
[1.2.3 Retrieve Real-Time Quote Snapshots of Trading Instruments](#43-get-real-time-market-snapshot-for-trading-instruments)  
[1.2.4 Retrieve Real-Time Latest Order Book Depth of Trading Instruments](#44-get-real-time-latest-order-book-depth-for-trading-instruments)  
[1.2.5 Retrieve Real-Time Trade Details of Trading Instruments](#45-get-real-time-latest-trade-details-for-trading-instruments)  
[1.2.6 Retrieve K-Line Data of Trading Instruments](#46-get-k-line-for-trading-instruments)  
[1.2.7 Retrieve Historical K-Line Data of Trading Instruments](#47-get-historical-k-line-for-trading-instruments)  

### 1.3 Subscribe to WebSocket Real-Time Data API
Include the key in the request header by filling the `key` field. Then, establish a WebSocket connection, send subscription commands, and maintain the heartbeat to receive real-time quotes.  
[1.3.1 WebSocket Protocol Access Instructions](#50-websocket-protocol-access-instructions)  
[1.3.2 Heartbeat](#51-heartbeat)  
[1.3.3 Subscribe to Real-Time Snapshots of Trading Instruments](#52-subscribe-to-real-time-snapshot-of-trading-instruments)  
[1.3.4 Subscribe to Real-Time Trade Details of Trading Instruments](#53-subscribe-to-real-time-trade-detail-by-price-level)  
[1.3.5 Subscribe to Real-Time Order Book of Trading Instruments](#54-subscribe-to-real-time-order-book-depth-of-trading-instruments)  

## 2. Enumeration Definitions
### 2.1 K-Line Types
| Enum Constant | Value |
|---------------|-------|
| min1          | 1     |
| min5          | 5     |
| min15         | 15    |
| min30         | 30    |
| hour1         | 60    |
| hour2         | 120   |
| hour4         | 240   |
| day           | 1001  |
| week          | 1007  |
| month         | 1030  |
| year          | 2001  |
---

### 2.2 Trade Directions
| Enum Constant | Value |
|---------------|-------|
| unknown       | 0     |
| buy           | 1     |
| sell          | 2     |
---

## 3. Trading Instrument Codes and Trading Hours
| Market Code | Description | Trading Hours |
|-------------|-------------|---------------|
| US          | US Stocks   | Normal Trading Hours (Eastern Time, ET):</br>Opening Time: 9:30 AM</br>Closing Time: 4:00 PM</br>Pre-Market Trading:</br>Start Time: 4:00 AM</br>End Time: 9:30 AM</br>After-Hours Trading:</br>Start Time: 4:00 PM</br>End Time: 8:00 PM</br>Night Trading: </br> Start Time: 8:00 PM </br> End Time: 3:50 AM (the next day) </br>Note: The above times are in US local time. Ensure proper daylight saving time (DST) adjustments:</br> DST (usually from the second Sunday in March to the first Sunday in November)</br> Standard Time (usually from the first Sunday in November to the second Sunday in March)</br> Convert to UTC+8: During standard time, the opening is at 10:30 PM, and during DST, it’s at 9:30 PM. |
| HK          | Hong Kong Stocks | UTC+8 Morning Session: 9:30 AM - 12:00 PM</br>Afternoon Session: 1:00 PM - 4:00 PM |
| SZ          | Shenzhen A-Shares | UTC+8 Morning Session: 9:30 AM - 11:30 AM</br>Afternoon Session: 1:00 PM - 3:00 PM |
| SH          | Shanghai A-Shares | UTC+8 Morning Session: 9:30 AM - 11:30 AM</br>Afternoon Session: 1:00 PM - 3:00 PM |
## 4. HTTP Protocol API Definition  
### 4.0 HTTP Protocol Access Description  
When making requests, simply include the `key` in the request header, filling in the `key` field.  
- **Request URL**: Base URL + endpoint address  
- **Request Method**: POST only; non-POST requests are not accepted.  
#### 4.0.1 Request Header  
| Parameter | Type   | Description          |  
|-----------|--------|----------------------|  
| `key`     | string | The API key for the request. |  

#### 4.0.2 Limitations  
The number of subscribed products and request frequency is limited based on the selected plan. By default, the limit is 10 products and 30 requests per minute. Contact customer service for adjustments according to your plan.  

---

### 4.1 Register a New Key  
- **Endpoint**: `/register`  
- **Request Method**: `POST`  
- **Description**: Quickly apply for a free key. Note: After requesting this endpoint, keep the received information secure and do not disclose it. If you lose it, contact customer service for authentication and retrieval.  

#### 4.1.1 Request Parameters  

| Parameter Name | Type   | Required | Description                                                |  
|----------------|--------|----------|------------------------------------------------------------|  
| `email`        | string | Yes      | Provide a valid email address to receive the verification code (needed for key recovery and permission upgrades). |  

#### 4.1.2 Request Example  
```json  
{  
    "email": "test@exp.com"  
}  
```  

#### 4.1.3 Response Fields  

| Field Name     | Type    | Description                                                  |  
|----------------|---------|--------------------------------------------------------------|  
| `key`          | string  | The verification key. Keep it secure and do not disclose it. Contact customer service for authentication and retrieval if lost. |  
| `email`        | string  | User email address                                           |  
| `created_at`   | string  | Key creation time                                            |  
| `expires_at`   | string  | Key expiration time                                          |  
| `permission`   | obj     | Permission details                                          |  
| `> depth`      | obj     | Depth snapshot API permissions                              |  
| `>> product_count` | int | Limit on the number of products for depth snapshot API      |  
| `>> request_frequency` | int | Request frequency limit for depth snapshot API        |  
| `> history`    | obj     | Historical K-line API permissions                           |  
| `>> product_count` | int | Limit on the number of products for historical K-line API   |  
| `>> request_frequency` | int | Request frequency limit for historical K-line API     |  
| `> instrumen_info` | obj | Instrument information API permissions                     |  
| `>> product_count` | int | Limit on the number of products for instrument info API     |  
| `>> request_frequency` | int | Request frequency limit for instrument info API       |  
| `> kline`      | obj     | K-line API permissions                                      |  
| `>> product_count` | int | Limit on the number of products for K-line API             |  
| `>> request_frequency` | int | Request frequency limit for K-line API               |  
| `> snapshot`   | obj     | Market snapshot API permissions                            |  
| `>> product_count` | int | Limit on the number of products for market snapshot API    |  
| `>> request_frequency` | int | Request frequency limit for market snapshot API      |  
| `> trade`      | obj     | Trade data API permissions                                 |  
| `>> product_count` | int | Limit on the number of products for trade data API         |  
| `>> request_frequency` | int | Request frequency limit for trade data API           |  
| `> ws`         | obj     | WebSocket subscription permissions                         |  
| `>> product_count` | int | Limit on the number of products for WebSocket subscription |  
| `>> request_frequency` | int | Request frequency limit for WebSocket subscription   |  
| `>> max_connections` | int | Maximum number of WebSocket connections allowed       |  

#### 4.1.4 Response Example  

```json  
{  
    "msg": "OK",  
    "data": {  
        "key": "b56efc3a0951ae19819505427491a6ee",  
        "email": "test4@qos.com",  
        "created_at": "2024-11-12T09:43:12.436446868+08:00",  
        "expires_at": "2024-11-27T09:43:12.436446868+08:00",  
        "permission": {  
            "depth": {  
                "product_count": 10,  
                "request_frequency": 30  
            },  
            "history": {  
                "product_count": 10,  
                "request_frequency": 30  
            },  
            "instrumen_info": {  
                "product_count": 10,  
                "request_frequency": 30  
            },  
            "kline": {  
                "product_count": 10,  
                "request_frequency": 30  
            },  
            "snapshot": {  
                "product_count": 10,  
                "request_frequency": 30  
            },  
            "trade": {  
                "product_count": 10,  
                "request_frequency": 30  
            },  
            "ws": {  
                "product_count": 10,  
                "request_frequency": 30,  
                "max_connections": 1  
            }  
        }  
    }  
}  
```  
---
### 4.2 Retrieve Basic Instrument Information  
- **Endpoint**: `/instrument-info`  
- **Request Method**: `POST`  
- **Description**: Retrieve basic information about trading instruments.  

#### 4.2.1 Request Parameters  

| Parameter Name | Type   | Required | Description                           |  
|----------------|--------|----------|---------------------------------------|  
| `codes`        | array  | Yes      | Array of trading instrument codes. See the request example for details. |  

#### 4.2.2 Request Example  
```  
{  
    "codes": [  
        "US:AAPL,TSLA",  
        "HK:700",  
        "SH:600519"  
    ]  
}  
```  

#### 4.2.3 Response Fields  

| Field Name | Type    | Description                |  
|------------|---------|----------------------------|  
| `c`        | string  | Stock code                 |  
| `e`        | string  | Exchange                   |  
| `tc`       | string  | Trading currency           |  
| `nc`       | string  | Chinese name               |  
| `ne`       | string  | English name               |  
| `ls`       | integer | Minimum trading unit       |  
| `ts`       | integer | Timestamp                  |  
| `os`       | integer | Total stock quantity       |  
| `ep`       | string  | Earnings per share         |  
| `na`       | string  | Net asset per share        |  
| `dy`       | string  | Dividend yield             |  

#### 4.2.4 Response Example  

```  
{  
  "msg": "OK",  
  "data": [  
    {  
      "c": "US:AAPL",  
      "e": "NASD",  
      "tc": "USD",  
      "nc": "苹果",  
      "ne": "AppleInc.",  
      "ls": 1,  
      "ts": 15115823000,  
      "os": 15091141884,  
      "ep": "6.2012",  
      "na": "3.7676",  
      "dy": "0.98"  
    },  
    {  
      "c": "HK:700",  
      "e": "SEHK",  
      "tc": "HKD",  
      "nc": "腾讯控股",  
      "ne": "TENCENT",  
      "ls": 100,  
      "ts": 9267359712,  
      "os": 9267359712,  
      "ep": "13.719",  
      "na": "101.7578",  
      "dy": "3.4558"  
    },  
    {  
      "c": "SH:600519",  
      "e": "SSE",  
      "tc": "CNY",  
      "nc": "贵州茅台",  
      "ne": "Moutai",  
      "ls": 100,  
      "ts": 1256197800,  
      "os": 1256197800,  
      "ep": "59.4923",  
      "na": "189.2293",  
      "dy": "49.982"  
    }  
  ]  
}  
```  
---
### 4.3. Get Real-Time Market Snapshot for Trading Instruments
- **API Endpoint**: `/snapshot`
- **Request Method**: `POST`
- **API Description**: Get the real-time market snapshot for trading instruments.

#### 4.3.1. Request Parameters

| Parameter  | Type   | Required | Description                                         |
|------------|--------|----------|-----------------------------------------------------|
| `codes`    | array  | Yes      | List of trading instruments, see request example below for details.   |

#### 4.3.2. Request Example
```
{
    "codes": [
        "US:AAPL,TSLA",
        "HK:700",
        "SH:600519"
    ]
}
```

#### 4.3.3. Response Fields

| Field Name  | Type   | Description                                         |
|-------------|--------|-----------------------------------------------------|
| c           | string | Stock code                                          |
| lp          | string | Current price                                       |
| yp          | string | Previous closing price                              |
| o           | string | Opening price                                       |
| h           | string | Highest price                                       |
| l           | string | Lowest price                                        |
| ts          | integer| Timestamp                                           |
| v           | string | Volume                                              |
| t           | string | Transaction amount                                  |
| s           | integer| Trading suspension status (0 for not suspended, 1 for suspended) |
| pq   | object | US stock pre-market snapshot data, see definition below |
| aq   | object | US stock after-hours snapshot data, see definition below |
| nq   | object | US stock night session snapshot data, see definition below |

| Field Name | Type    | Description                              |
|------------|--------|------------------------------------------|
| lp         | string | Current price                           |
| yp         | string | Previous closing price                 |
| h          | string | Highest price                          |
| l          | string | Lowest price                           |
| ts         | integer| Timestamp                              |
| v          | string | Trading volume                        |
| t          | string | Trading amount                        |

#### 4.3.4. Response Example
```
{
    "msg": "OK",
    "data": [
        {
            "c": "US:AAPL",
            "lp": "238.03",
            "yp": "241.84",
            "o": "241.79",
            "h": "244.027",
            "l": "236.112",
            "ts": 1741035600,
            "v": "47183985",
            "t": "11319574967",
            "s": 0,
            "pq": {
                "lp": "238.06",
                "ts": 1741084832,
                "v": "29673",
                "t": "7076551.6299999999",
                "h": "239.24",
                "l": "237.76",
                "yp": "238.03"
            },
            "aq": {
                "lp": "240.4",
                "ts": 1741049997,
                "v": "4867814",
                "t": "1158971205.635999918",
                "h": "240.495",
                "l": "237.659",
                "yp": "238.03"
            }
        },
        {
            "c": "US:BTOG",
            "lp": "0.3193",
            "yp": "0.182",
            "o": "0.9497",
            "h": "0.96",
            "l": "0.235",
            "ts": 1741035600,
            "v": "292773019",
            "t": "195842787",
            "s": 0,
            "pq": {
                "lp": "0.4398",
                "ts": 1741084836,
                "v": "2065900",
                "t": "1045727.045",
                "h": "0.5898",
                "l": "0.3882",
                "yp": "0.3193"
            },
            "aq": {
                "lp": "0.399",
                "ts": 1741049999,
                "v": "6388895",
                "t": "2609760.0299999998",
                "h": "0.4695",
                "l": "0.2908",
                "yp": "0.3193"
            }
        },
        {
            "c": "HK:700",
            "lp": "491",
            "yp": "483.2",
            "o": "479",
            "h": "493",
            "l": "473.2",
            "ts": 1741075712,
            "v": "31124964",
            "t": "15131838819",
            "s": 0
        },
        {
            "c": "SH:600519",
            "lp": "1470.11",
            "yp": "1487.02",
            "o": "1485",
            "h": "1486",
            "l": "1465.21",
            "ts": 1741071600,
            "v": "25211",
            "t": "3710675863",
            "s": 0
        }
    ]
}
```

---
### 4.4. Get Real-Time Latest Order Book Depth for Trading Instruments
- **API Endpoint**: `/depth`
- **Request Method**: `POST`
- **API Description**: Get the real-time latest order book depth for trading instruments.

#### 4.4.1. Request Parameters

| Parameter  | Type   | Required | Description                                         |
|------------|--------|----------|-----------------------------------------------------|
| `codes`    | array  | Yes      | List of trading instruments, see request example below for details.   |

#### 4.4.2. Request Example
```
{
    "codes": [
        "US:AAPL,TSLA",
        "HK:700",
        "SH:600519"
    ]
}
```

#### 4.4.3. Response Fields

| Field Name  | Type   | Description                                         |
|-------------|--------|-----------------------------------------------------|
| c           | string | Stock code                                          |
| b           | array  | Array of buy orders                                  |
| > p         | string | Buy order price                                      |
| > v         | string | Buy order volume                                     |
| a           | array  | Array of sell orders                                 |
| > p         | string | Sell order price                                     |
| > v         | string | Sell order volume                                    |
| ts          | integer| Timestamp                                           |

#### 4.4.4. Response Example
```
{
  "msg": "OK",
  "data": [
    {
      "c": "US:AAPL",
      "b": [
        { "p": "224.42", "v": "100" }
      ],
      "a": [
        { "p": "224.74", "v": "20" }
      ],
      "ts": 1731293478
    },
    {
      "c": "US:TSLA",
      "b": [
        { "p": "295.8", "v": "5" }
      ],
      "a": [
        { "p": "295.9", "v": "130" }
      ],
      "ts": 1731293478
    },
    {
      "c": "SH:600519",
      "b": [
        { "p": "1593.01", "v": "1" },
        { "p": "1593", "v": "5" }
      ],
      "a": [
        { "p": "1593.02", "v": "1" },
        { "p": "1594", "v": "6" }
      ],
      "ts": 1731293478
    }
  ]
}
```

---
### 4.5. Get Real-Time Latest Trade Details for Trading Instruments
- **API Endpoint**: `/trade`
- **Request Method**: `POST`
- **API Description**: Get real-time latest trade details for trading instruments.

#### 4.5.1. Request Parameters

| Parameter  | Type   | Required | Description                                         |
|------------|--------|----------|-----------------------------------------------------|
| `codes`    | array  | Yes      | List of trading instruments, see request example below for details.   |
| `count`    | integer| Yes      | Number of recent trades requested (must not exceed 50) |

#### 4.5.2. Request Example
```
{
    "codes": [
        "US:AAPL",
        "HK:700",
        "SH:600519,688981,601127,600938,601727,600837,688185",
        "SZ:002594"
    ],
    "count": 2
}
```

#### 4.5.3. Response Fields

| Field Name  | Type   | Description                                         |
|-------------|--------|-----------------------------------------------------|
| c           | string | Stock code                                          |
| p           | string | Current price                                       |
| v           | string | Current transaction volume                           |
| ts          | integer| Timestamp                                           |
| d           | integer| Trade direction, see section 5.2 for details.       |

#### 4.5.4. Response Example
```
{
    "msg": "OK",
    "data": [
        {
            "c": "SH:688185",
            "p": 66.99,
            "v": 2,
            "ts": 1731635481,
            "d": 2
        },
        {
            "c": "SH:600519",
            "p": 1555.8,
            "v": 74,
            "ts": 1731635489,
            "d": 2
        },
        {
            "c": "SH:601127",
            "p": 135.81,
            "v": 327,
            "ts": 1731635489,
            "d": 0
        },
        {
            "c": "SH:688981",
            "p": 96.25,
            "v": 364,
            "ts": 1731635491,
            "d": 2
        },
        {
            "c": "SH:600938",
            "p": 25.85,
            "v": 75,
            "ts": 1731635488,
            "d": 1
        },
        {
            "c": "SH:601727",
            "p": 9.01,
            "v": 8414,
            "ts": 1731635491,
            "d": 1
        },
        {
            "c": "SH:600837",
            "p": 11.92,
            "v": 510,
            "ts": 1731635490,
            "d": 2
        },
        {
            "c": "SZ:002594",
            "p": 285.88,
            "v": 59,
            "ts": 1731635493,
            "d": 0
        }
    ]
}
```

---
### 4.6. Get K-Line for Trading Instruments
- **API Endpoint**: `/kline`
- **Request Method**: `POST`
- **API Description**: Get K-line for trading instruments, starting from the most recent and moving backward for a specified number of K-lines.

#### 4.6.1. Request Parameters

| Parameter  | Type   | Required | Description                                         |
|------------|--------|----------|-----------------------------------------------------|
| c          | string | Stock codes, multiple codes separated by commas |
| co         | integer| Count: number of K-lines requested |
| a          | integer| Adjustment type: 0 for no adjustment, 1 for forward adjustment |
| kt         | integer| K-line type, refer to section 5.1 for K-line type definition |

#### 4.6.2. Request Example
```
{
    "kline_reqs": [
        {
            "c": "US:AAPL,TSLA",
            "co": 2,
            "a": 0,
            "kt": 1
        },
        {
            "c": "HK:700",
            "co": 2,
            "a": 0,
            "kt": 1
        },{
            "c": "SH:600519",
            "co": 2,
            "a": 0,
            "kt": 2001
        }
    ]
}
```

#### 4.6.3. Response Fields

| Field Name  | Type   | Description                                         |
|-------------|--------|-----------------------------------------------------|
| c           | string | Stock code                                          |
| k           | array  | Array of K-line data                                |
| > o         | string | Opening price                                       |
| > cl        | string | Closing price                                       |
| > h         | string | Highest price                                       |
| > l         | string | Lowest price                                        |
| > v         | string | Volume                                              |
| > ts        | integer| Timestamp                                           |
| > kt        | integer| K-line type, refer to section 5.1 for K-line type definition |

#### 4.6.4. Response Example
```
{
    "msg": "OK",
    "data": [
        {
            "c": "SH:600519",
            "k": [
                {
                    "c": "SH:600519",
                    "o": "1731.2",
                    "cl": "1726",
                    "h": "1935",
                    "l": "1616.25",
                    "v": "5627550",
                    "ts": 1672502400,
                    "kt": 2001
                },
                {
                    "c": "SH:600519",
                    "o": "1715",
                    "cl": "1585.58",
                    "h": "1910",
                    "l": "1245.83",
                    "v": "7147731",
                    "ts": 1704038400,
                    "kt": 2001
                }
            ]
        },
        {
            "c": "US:TSLA",
            "k": [
                {
                    "c": "US:TSLA",
                    "o": "330.32",
                    "cl": "330.19",
                    "h": "330.79",
                    "l": "329.957",
                    "v": "578346",
                    "ts": 1731531540,
                    "kt": 1
                },
                {
                    "c": "US:TSLA",
                    "o": "330.27",
                    "cl": "330.24",
                    "h": "330.29",
                    "l": "330.24",
                    "v": "2404646",
                    "ts": 1731531600,
                    "kt": 1
                }
            ]
        },
        {
            "c": "US:AAPL",
            "k": [
                {
                    "c": "US:AAPL",
                    "o": "225.11",
                    "cl": "225.07",
                    "h": "225.32",
                    "l": "225",
                    "v": "813271",
                    "ts": 1731531540,
                    "kt": 1
                },
                {
                    "c": "US:AAPL",
                    "o": "225.12",
                    "cl": "225.12",
                    "h": "225.12",
                    "l": "225.12",
                    "v": "8870001",
                    "ts": 1731531600,
                    "kt": 1
                }
            ]
        },
        {
            "c": "HK:700",
            "k": [
                {
                    "c": "HK:700",
                    "o": "411.4",
                    "cl": "411.6",
                    "h": "411.6",
                    "l": "411.2",
                    "v": "51115",
                    "ts": 1731553860,
                    "kt": 1
                },
                {
                    "c": "HK:700",
                    "o": "411.6",
                    "cl": "411.4",
                    "h": "411.8",
                    "l": "411.4",
                    "v": "84400",
                    "ts": 1731553920,
                    "kt": 1
                }
            ]
        }
    ]
}
```

---
### 4.7. Get Historical K-Line for Trading Instruments
- **API Endpoint**: `/history`
- **Request Method**: `POST`
- **API Description**: Get historical K-line for trading instruments, starting from the specified end time and moving backward for a specified number of K-lines.

#### 4.7.1. Request Parameters

| Parameter  | Type   | Required | Description                                         |
|------------|--------|----------|-----------------------------------------------------|
| c          | string | Stock codes, multiple codes separated by commas |
| e          | integer| Request end timestamp (in seconds)                 |
| co         | integer| Count: number of K-lines requested |
| a          | integer| Adjustment type: 0 for no adjustment, 1 for forward adjustment |
| kt         | integer| K-line type, refer to section 5.1 for K-line type definition |

#### 4.7.2. Request Example
```
{
    "kline_reqs": [
        {
            "c": "US:AAPL,TSLA",
            "e": 1722441600,
            "co": 1,
            "a": 0,
            "kt": 1001
        },
        {
            "c": "HK:700",
            "e": 1722441600,
            "co": 1,
            "a": 0,
            "kt": 2001
        }
    ]
}
```

#### 4.7.3. Response Fields

| Field Name  | Type   | Description                                         |
|-------------|--------|-----------------------------------------------------|
| c           | string | Stock code                                          |
| k           | array  | Array of K-line data                                |
| > o         | string | Opening price                                       |
| > cl        | string | Closing price                                       |
| > h         | string | Highest price                                       |
| > l         | string | Lowest price                                        |
| > v         | string | Volume                                              |
| > ts        | integer| Timestamp                                           |
| > kt        | integer| K-line type, refer to section 5.1 for K-line type definition |

#### 4.7.4. Response Example
```
{
    "msg": "OK",
    "data": [
        {
            "c": "US:AAPL",
            "k": [
                {
                    "c": "US:AAPL",
                    "o": "224.01",
                    "cl": "225.12",
                    "h": "226.65",
                    "l": "222.76",
                    "v": "48566217",
                    "ts": 1731474000,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "US:TSLA",
            "k": [
                {
                    "c": "US:TSLA",
                    "o": "335.85",
                    "cl": "330.24",
                    "h": "344.6",
                    "l": "322.5",
                    "v": "125405599",
                    "ts": 1731474000,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "HK:700",
            "k": [
                {
                    "c": "HK:700",
                    "o": "300",
                    "cl": "410.8",
                    "h": "482.4",
                    "l": "260.2",
                    "v": "4682849510",
                    "ts": 1704038400,
                    "kt": 2001
                }
            ]
        }
    ]
}
```
---
## 5. WebSocket Protocol API Definition
### 5.0. WebSocket Protocol Access Instructions
When establishing the connection, you only need to include the API key in the request header by filling in the key field. Once the connection is established, you can start sending heartbeats, subscribing to real-time snapshots, real-time quotes, and real-time transaction prices.
- **WebSocket URL:** wss://api.qos.hk/ws
#### 5.0.1. Request Header
| Parameter | Type   | Description        |
|-----------|--------|--------------------|
| key       | string | API key for the request |

#### 5.0.2. Limitations
The number of subscribed products and the number of connections will be limited based on the subscription plan. By default, 10 products and 1 connection are allowed. You can contact customer service for adjustments based on your subscription plan. The frequency of subscription requests must not exceed 30 times per minute.

### 5.1. Heartbeat
A heartbeat should be sent every 20 seconds.
#### 5.1.1. Sending Heartbeat
```json
{"type":"H"}
```
#### 5.1.2. Heartbeat Response
```json
{
    "type": "H",
    "msg": "OK",
    "time": 1731640508
}
```
### 5.2. Subscribe to Real-Time Snapshot of Trading Instruments
#### 5.2.1. Sending Subscription Command
| Field Name | Value                                                               |
|------------|---------------------------------------------------------------------|
| type       | Use "S" for subscription, "SC" for unsubscription.                   |
| codes      | List of codes; refer to the example below for the specific format. |

#### 5.2.2. Subscription Command Example
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
#### 5.2.3. Subscription Command Response
```json
{
    "type": "S",
    "msg": "OK",
    "time": 1731650860
}
```
#### 5.2.4. Unsubscription Command Example
```json
{
    "type": "SC",
    "codes": [
        "US:AAPL",
        "HK:700,9988",
        "SH:600519,688981,601127,600938,601727,600837",
        "SZ:002594"
    ]
}
```
#### 5.2.5. Unsubscription Command Response
```json
{
    "type": "SC",
    "msg": "OK",
    "time": 1731650871
}
```
#### 5.2.6. Data Push
| Field Name | Type   | Description                                                      |
|------------|--------|------------------------------------------------------------------|
| tp         | string | Data type, "S" indicates market snapshot data                    |
| c          | string | Stock code                                                       |
| lp         | string | Current price                                                    |
| yp         | string | Previous day's closing price                                      |
| o          | string | Opening price                                                    |
| h          | string | Highest price                                                    |
| l          | string | Lowest price                                                     |
| ts         | integer| Timestamp                                                        |
| v          | string | Volume                                                           |
| t          | string | Transaction amount                                               |
| s          | integer| Trading suspension status (0 indicates not suspended, 1 for suspended) |

#### 5.2.7. Data Push Example
```json
{
    "tp": "S",
    "c": "SH:600938",
    "lp": "25.92",
    "yp": "26.15",
    "o": "26.19",
    "h": "26.19",
    "l": "25.62",
    "ts": 1731650869,
    "v": "694420",
    "t": "1793887058",
    "s": 0
}
```
### 5.3. Subscribe to Real-Time Trade Detail by Price Level
#### 5.3.1. Sending Subscription Command
| Field Name | Value                                                               |
|------------|---------------------------------------------------------------------|
| type       | Use "T" for subscription, "TC" for unsubscription.                  |
| codes      | List of codes; refer to the example below for the specific format. |

#### 5.3.2. Subscription Command Example
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
#### 5.3.3. Subscription Command Response
```json
{
    "type": "T",
    "msg": "OK",
    "time": 1731650860
}
```
#### 5.3.4. Unsubscription Command Example
```json
{
    "type": "TC",
    "codes": [
        "US:AAPL",
        "HK:700,9988",
        "SH:600519,688981,601127,600938,601727,600837",
        "SZ:002594"
    ]
}
```
#### 5.3.5. Unsubscription Command Response
```json
{
    "type": "TC",
    "msg": "OK",
    "time": 1731650871
}
```
#### 5.3.6. Data Push
| Field Name | Type   | Description                                                      |
|------------|--------|------------------------------------------------------------------|
| tp         | string | Data type, "T" indicates trade data                              |
| c          | string | Stock code                                                       |
| p          | string | Current price                                                    |
| v          | string | Current transaction volume                                        |
| ts         | integer| Timestamp                                                        |
| d          | integer| Trade direction, refer to section 5.2 for details                |

#### 5.3.7. Data Push Example
```json
{
    "tp": "T",
    "c": "SH:600837",
    "p": 11.75,
    "v": 71,
    "ts": 1731651249,
    "d": 2
}
```
### 5.4. Subscribe to Real-Time Order Book Depth of Trading Instruments
#### 5.4.1. Sending Subscription Command
| Field Name | Value                                                               |
|------------|---------------------------------------------------------------------|
| type       | Use "D" for subscription, "DC" for unsubscription.                  |
| codes      | List of codes; refer to the example below for the specific format. |

#### 5.4.2. Subscription Command Example
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
#### 5.4.3. Subscription Command Response
```json
{
    "type": "D",
    "msg": "OK",
    "time": 1731650860
}
```
#### 5.4.4. Unsubscription Command Example
```json
{
    "type": "DC",
    "codes": [
        "US:AAPL",
        "HK:700,9988",
        "SH:600519,688981,601127,600938,601727,600837",
        "SZ:002594"
    ]
}
```
#### 5.4.5. Unsubscription Command Response
```json
{
    "type": "DC",
    "msg": "OK",
    "time": 1731650871
}
```
#### 5.4.6. Data Push
| Field Name | Type   | Description                                                      |
|------------|--------|------------------------------------------------------------------|
| tp         | string | Data type, "D" indicates order book depth data                   |
| c          | string | Stock code                                                       |
| b          | array  | Array of buy orders                                               |
| > p        | string | Buy order price                                                   |
| > v        | string | Buy order volume                                                  |
| a          | array  | Array of sell orders                                              |
| > p        | string | Sell order price                                                  |
| > v        | string | Sell order volume                                                 |
| ts         | integer| Timestamp                                                        |

#### 5.4.7. Data Push Example
```json
{
    "tp": "D",
    "c": "SH:688981",
    "b": [
        {
            "p": "96.66",
            "v": "21"
        },
        {
            "p": "96.65",
            "v": "16"
        },
        {
            "p": "96.63",
            "v": "13"
        },
        {
            "p": "96.61",
            "v": "6"
        },
        {
            "p": "96.6",
            "v": "34"
        }
    ],
    "a": [
        {
            "p": "96.67",
            "v": "221"
        },
        {
            "p": "96.7",
            "v": "10"
        },
        {
            "p": "96.71",
            "v": "1542"
        },
        {
            "p": "96.74",
            "v": "62"
        },
        {
            "p": "96.75",
            "v": "915"
        }
    ],
    "ts": 1731651419
}
```
