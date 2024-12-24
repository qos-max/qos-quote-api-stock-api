# QOS Quote Ocean System API Documentation
The Quote Ocean System currently provides: real-time quotes, real-time K-line, and historical K-line data for Hong Kong, US, and Chinese stocks. Free trial access is available—feel free to contact the author.

- **Version**: V1.0.0  
- **Author**: Max  
- **Last Updated**: 2024-12-16  
- **HTTP Base URL**: `https://api.qos.hk`  
- **WebSocket URL**: `wss://api.qos.hk/ws`  
- **Authentication**: Add the `key` field in the request header.  
- **Error Code Explanation**: A "msg" field value of "OK" indicates success; otherwise, it provides specific error details.  
- **Format**: All requests and responses use JSON format.  
- **Request Method**: All HTTP requests use the POST method.  

## Contact the Author:
- **Telegram**: [https://t.me/qos_max](https://t.me/qos_max)  
- **Skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)  

## 1. Quick Start - Integration Guide
### 1.1 Register a Key
[1.1.1 HTTP Protocol Access Instructions](#40http-protocol-access-instructions)  
[1.1.2 Register a Key](#41register-a-new-key)  

After registering with your email, you will receive key-related information. Please keep it safe, as it will be used in subsequent steps.  

### 1.2 Request HTTP API
Include the key in the request header by filling the `key` field. Then, use the parameters defined for each HTTP interface to fetch the data.  
[1.2.1 HTTP Protocol Access Instructions](#40http-protocol-access-instructions)  
[1.2.2 Retrieve Basic Information for Trading Instruments](#42retrieve-basic-information-for-trading-instruments)  
[1.2.3 Retrieve Real-Time Quote Snapshots of Trading Instruments](#43retrieve-real-time-quote-snapshots-of-trading-instruments)  
[1.2.4 Retrieve Real-Time Latest Order Book Depth of Trading Instruments](#44retrieve-real-time-latest-order-book-depth-of-trading-instruments)  
[1.2.5 Retrieve Real-Time Trade Details of Trading Instruments](#45retrieve-real-time-trade-details-of-trading-instruments)  
[1.2.6 Retrieve K-Line Data of Trading Instruments](#46retrieve-k-line-data-of-trading-instruments)  
[1.2.7 Retrieve Historical K-Line Data of Trading Instruments](#47retrieve-historical-k-line-data-of-trading-instruments)  

### 1.3 Subscribe to WebSocket Real-Time Data API
Include the key in the request header by filling the `key` field. Then, establish a WebSocket connection, send subscription commands, and maintain the heartbeat to receive real-time quotes.  
[1.3.1 WebSocket Protocol Access Instructions](#50websocket-protocol-access-instructions)  
[1.3.2 Heartbeat](#51heartbeat)  
[1.3.3 Subscribe to Real-Time Snapshots of Trading Instruments](#52subscribe-to-real-time-snapshots-of-trading-instruments)  
[1.3.4 Subscribe to Real-Time Trade Details of Trading Instruments](#53subscribe-to-real-time-trade-details-of-trading-instruments)  
[1.3.5 Subscribe to Real-Time Order Book of Trading Instruments](#54subscribe-to-real-time-order-book-of-trading-instruments)  

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
| US          | US Stocks   | Normal Trading Hours (Eastern Time, ET):</br>Opening Time: 9:30 AM</br>Closing Time: 4:00 PM</br>Pre-Market Trading:</br>Start Time: 4:00 AM</br>End Time: 9:30 AM</br>After-Hours Trading:</br>Start Time: 4:00 PM</br>End Time: 8:00 PM</br>Note: The above times are in US local time. Ensure proper daylight saving time (DST) adjustments:</br> DST (usually from the second Sunday in March to the first Sunday in November)</br> Standard Time (usually from the first Sunday in November to the second Sunday in March)</br> Convert to UTC+8: During standard time, the opening is at 9:30 PM, and during DST, it’s at 10:30 PM. |
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

#### 4.3.4. Response Example
```
{
  "msg": "OK",
  "data": [
    {
      "c": "US:AAPL",
      "e": "NASD",
      "tc": "USD",
      "nc": "Apple",
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
      "nc": "Tencent Holdings",
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
      "nc": "Moutai",
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
