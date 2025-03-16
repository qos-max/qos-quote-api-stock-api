**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/api.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md)**
# QOS Market API (Quote Ocean System) Documentation  
**The quote-ocean-system, abbreviated as "QOS Market API," includes real-time APIs for Hong Kong stocks, US stocks, A-shares, cryptocurrency real-time quotes, and digital currency real-time market data. It is easy to integrate using REST API and WebSocket interfaces.**</br>  
**Free and open-source stock API, Hong Kong stock API, US stock API, Shanghai-Shenzhen stock API, A-share API, real-time stock market data, cryptocurrency real-time quotes, and digital currency real-time market data.**</br>  
**The QOS market quotation system currently provides real-time quotes, real-time K-line data, and historical K-line data for all Hong Kong, US, and Shanghai-Shenzhen stocks, as well as cryptocurrencies (digital currencies). Welcome to try it for free and contact the author. Free trial integration is now available.**  
- **Official Website**: [https://qos.hk](https://qos.hk)  
- **Last Updated**: 2025-3-14  

## Contact the Author:  
- **Email**: support@qos.hk  
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)  
- **Telegram Group**: [https://t.me/stock_quote_api_hk_us_ashre_api](https://t.me/stock_quote_api_hk_us_ashre_api)  

## 1. Quick Start - Integration Guide  
### 1.1. Register for a Key  
Visit the official website to quickly register for a key:  
- **Official Website**: [https://qos.hk](https://qos.hk)  

After registering with your email, you will receive key-related information. **Make sure to save it securely**, as it will be used in the following steps.  

# Table of Contents  
### 1.2. View [Some Enum Definitions](#2-some-enum-definitions)  
1.2.1. [K-line Types](#21-k-line-types)</br>  
1.2.2. [Trade Directions](#22-trade-directions)</br>  
### 1.3. View [Codes and Trading Hours for Various Trading Products](#3-codes-and-trading-hours-for-various-trading-products)  
### 1.4. Request [HTTP Interfaces](#4-http-protocol-interface-definitions)  
Add the key to **URL parameters** or **request headers** using the key field, and then use the parameters defined in the HTTP interfaces to retrieve data.</br>  
1.4.1. [HTTP Protocol Integration Instructions](#40-http-protocol-integration-instructions)</br>  
1.4.2. [Get Basic Information of Trading Products](#42-get-basic-information-of-trading-products)</br>  
1.4.3. [Get Real-time Market Snapshots of Trading Products](#43-get-real-time-market-snapshots-of-trading-products)</br>  
1.4.4. [Get Real-time Latest Market Depth of Trading Products](#44-get-real-time-latest-market-depth-of-trading-products)</br>  
1.4.5. [Get Real-time Latest Trade-by-Trade Details of Trading Products](#45-get-real-time-latest-trade-by-trade-details-of-trading-products)</br>  
1.4.6. [Get K-line Data of Trading Products](#46-get-k-line-data-of-trading-products)</br>  
1.4.7. [Get Historical K-line Data of Trading Products](#47-get-historical-k-line-data-of-trading-products)</br>  
### 1.5. Subscribe or Request Real-time Data via [WebSocket Interfaces](#5-websocket-protocol-interface-definitions)  
Add the key to **URL parameters** or **request headers** using the key field, establish a WebSocket connection, send the corresponding subscription commands, and maintain a heartbeat to receive real-time quotes.</br>  
1.5.1. [WebSocket Protocol Integration Instructions](#50-websocket-protocol-integration-instructions)</br>  
1.5.2. [Heartbeat](#51-heartbeat)</br>  
1.5.3. [Subscribe to Real-time Snapshots of Trading Products](#52-subscribe-to-real-time-snapshots-of-trading-products)</br>  
1.5.4. [Subscribe to Real-time Trade-by-Trade Details of Trading Products](#53-subscribe-to-real-time-trade-by-trade-details-of-trading-products)</br>  
1.5.5. [Subscribe to Real-time Market Depth of Trading Products](#54-subscribe-to-real-time-market-depth-of-trading-products)</br>  
1.5.6. [Subscribe to Real-time K-line Data of Trading Products](#55-subscribe-to-real-time-k-line-data-of-trading-products)</br>  
1.5.7. [Request Real-time Snapshots of Trading Products](#56-request-real-time-snapshots-of-trading-products)</br>  
1.5.8. [Request Real-time Trade-by-Trade Details of Trading Products](#57-request-real-time-trade-by-trade-details-of-trading-products)</br>  
1.5.9. [Request Real-time Market Depth of Trading Products](#58-request-real-time-market-depth-of-trading-products)</br>  
1.5.10. [Request Real-time K-line Data of Trading Products](#59-request-real-time-k-line-data-of-trading-products)</br>  
1.5.11. [Request Historical K-line Data of Trading Products](#510-request-historical-k-line-data-of-trading-products)</br>  
1.5.12. [Request Basic Information of Trading Instruments](#511-request-basic-information-of-trading-instruments)</br> 

## 2. Some Enum Definitions  
### 2.1. K-line Types  
| Enum Constant | Value   |  
|---------------|---------|  
| min1          | `1`     |  
| min5          | `5`     |  
| min15         | `15`    |  
| min30         | `30`    |  
| hour1         | `60`    |  
| hour2         | `120`   |  
| hour4         | `240`   |  
| day           | `1001`  |  
| week          | `1007`  |  
| month         | `1030`  |  
| year          | `2001`  |  
> [Back to Table of Contents](#table-of-contents)  
---  

### 2.2. Trade Directions  
| Enum Constant | Value   |  
|---------------|---------|  
| unknown       | `0`     |  
| buy           | `1`     |  
| sell          | `2`     |  
> [Back to Table of Contents](#table-of-contents)  
---  

## 3. Codes and Trading Hours for Various Trading Products  
| Market Code | Description | Trading Hours |  
|-------------|-------------|---------------|  
| `US`        | US Stocks   | Normal US trading hours (Eastern Time, ET):</br>Market Open: 9:30 AM</br>Market Close: 4:00 PM</br>Pre-Market Trading:</br>Start Time: 4:00 AM</br>End Time: 9:30 AM</br>After-Hours Trading:</br>Start Time: 4:00 PM</br>End Time: 8:00 PM</br>Night Trading:</br>Start Time: 8:00 PM</br>End Time: 3:50 AM the next day</br>The above times are in local US time. Pay attention to time zone conversions when converting to other time zones.</br>Daylight Saving Time (usually from the second Sunday in March to the first Sunday in November)</br>Standard Time (usually from the first Sunday in November to the second Sunday in March)</br>Converted to UTC+8, the market opens at 10:30 PM during Standard Time and 9:30 PM during Daylight Saving Time. |  
| `HK`        | Hong Kong Stocks | UTC+8 Morning Session: 9:30 AM - 12:00 PM Afternoon Session: 1:00 PM - 4:00 PM |  
| `SZ`        | Shenzhen A-Shares | UTC+8 Morning Session: 9:30 AM - 11:30 AM Afternoon Session: 1:00 PM - 3:00 PM |  
| `SH`        | Shanghai A-Shares | UTC+8 Morning Session: 9:30 AM - 11:30 AM Afternoon Session: 1:00 PM - 3:00 PM |  
| `CF`        | Cryptocurrency Perpetual Contracts | 24 Hours |  
> [Back to Table of Contents](#table-of-contents)  
---  

## 4. HTTP Protocol Interface Definitions  
### 4.0. HTTP Protocol Integration Instructions  
- **HTTP Base URL**: `https://api.qos.hk`  
- **Request URL**: Base URL + Interface Address  
- **Error Code Explanation**: The `msg` field returns "OK" for success; otherwise, it returns a specific error description.  
- **Format**: All requests and responses are in JSON format.  
- **Request Method**: All HTTP requests use the POST method.  
- **Authentication Method**: Add the key field to the URL parameters or request headers.  

When making requests, simply add the key to the **request headers** or **URL parameters** by filling in the key field.  
> [Back to Table of Contents](#table-of-contents)  

#### 4.0.1. Request Headers or URL Parameters  
| Parameter | Type   | Description |  
|-----------|--------|-------------|  
| `key`     | string | The API key value returned during registration |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.0.2. Limitations  
The number of subscribed products and request frequency are limited based on the subscription plan. The default is 10 products and 10 requests per minute. Contact customer service to adjust these limits according to different subscription plans.  
> [Back to Table of Contents](#table-of-contents)  
---  

### 4.1. Register a New Key  
Please visit the official website homepage to register online: [https://qos.hk](https://qos.hk)  
> [Back to Table of Contents](#table-of-contents)  
---  

### 4.2. Get Basic Information of Trading Products  
- **Interface Address**: `/instrument-info`  
- **Request Method**: `POST`  
- **Interface Description**: Get basic information of trading products.  
> [Back to Table of Contents](#table-of-contents)  

#### 4.2.1. Request Parameters  
| Parameter Name | Type   | Required | Description |  
|----------------|--------|----------|-------------|  
| `codes`        | array  | Yes      | List of trading products. See the example below for details. |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.2.2. Request Example  
```json
{
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,600518",
        "SZ:000001,002594",
        "CF:BTCUSDT,ETHUSDT"
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 4.2.3. Response Results  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `e`        | string | Exchange |  
| `tc`       | string | Trading Currency |  
| `nc`       | string | Chinese Name |  
| `ne`       | string | English Name |  
| `ls`       | integer| Minimum Trading Unit |  
| `ts`       | integer| Total Shares |  
| `os`       | integer| Outstanding Shares |  
| `ep`       | string | Earnings Per Share |  
| `na`       | string | Net Asset Per Share |  
| `dy`       | string | Dividend Yield |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.2.4. Response Example  
```json
{
    "msg": "OK",
    "data": [
        {
            "c": "HK:700",
            "e": "SEHK",
            "tc": "HKD",
            "nc": "腾讯控股",
            "ne": "TENCENT",
            "ls": 100,
            "ts": 9178822571,
            "os": 9178822571,
            "ep": "13.8513523179",
            "na": "110.2507143217",
            "dy": "3.4891482482"
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
            "ep": "59.49",
            "na": "189.2293196185",
            "dy": "54.758"
        },
        {
            "c": "US:AAPL",
            "e": "NASD",
            "tc": "USD",
            "nc": "苹果",
            "ne": "Apple Inc.",
            "ls": 1,
            "ts": 15022073000,
            "os": 14998202926,
            "ep": "6.2398844687",
            "na": "4.4439938483",
            "dy": "1"
        },
        {
            "c": "US:TSLA",
            "e": "NASD",
            "tc": "USD",
            "nc": "特斯拉",
            "ne": "Tesla, Inc.",
            "ls": 1,
            "ts": 3216517037,
            "os": 2799672511,
            "ep": "2.2166834243",
            "na": "22.6683083476",
            "dy": "0"
        },
        {
            "c": "HK:9988",
            "e": "SEHK",
            "tc": "HKD",
            "nc": "阿里巴巴-W",
            "ne": "BABA-W",
            "ls": 100,
            "ts": 19008233516,
            "os": 19008233516,
            "ep": "4.6275184269",
            "na": "56.8746237928",
            "dy": "1.649298669"
        },
        {
            "c": "SZ:002594",
            "e": "SZSE",
            "tc": "CNY",
            "nc": "比亚迪",
            "ne": "BYD",
            "ls": 100,
            "ts": 3039065855,
            "os": 1811265855,
            "ep": "10.32",
            "na": "51.1546641032",
            "dy": "2.9654648599"
        },
        {
            "c": "SH:600518",
            "e": "SSE",
            "tc": "CNY",
            "nc": "康美药业",
            "ne": "KMYY",
            "ls": 100,
            "ts": 13863866690,
            "os": 13612928105,
            "ep": "0.01",
            "na": "0.5079295503",
            "dy": "0"
        },
        {
            "c": "CF:ETHUSDT",
            "e": "Crypto Perpetual Contract",
            "tc": "USDT"
        },
        {
            "c": "CF:BTCUSDT",
            "e": "Crypto Perpetual Contract",
            "tc": "USDT"
        },
        {
            "c": "SZ:000001",
            "e": "SZSE",
            "tc": "CNY",
            "nc": "平安银行",
            "ne": "PAB",
            "ls": 100,
            "ts": 19405918198,
            "os": 19405762053,
            "ep": "2.247036",
            "na": "21.6699357232",
            "dy": "0.965"
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 4.3. Get Real-time Market Snapshots of Trading Products  
- **Interface Address**: `/snapshot`  
- **Request Method**: `POST`  
- **Interface Description**: Get real-time market snapshots of trading products.  
> [Back to Table of Contents](#table-of-contents)  

#### 4.3.1. Request Parameters  
| Parameter Name | Type   | Required | Description |  
|----------------|--------|----------|-------------|  
| `codes`        | array  | Yes      | List of trading products. See the example below for details. |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.3.2. Request Example  
```json
{
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,600518",
        "SZ:000001,002594",
        "CF:BTCUSDT,ETHUSDT"
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 4.3.3. Response Results  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `lp`       | string | Current Price |  
| `yp`       | string | Yesterday's Closing Price |  
| `o`        | string | Opening Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `ts`       | integer| Timestamp (in seconds) |  
| `v`        | string | Trading Volume |  
| `t`        | string | Trading Amount |  
| `s`        | integer| Trading Status (0: Trading, 1: Suspended) |  
| `pq`       | object | Pre-Market Snapshot Data (for US stocks) |  
| `aq`       | object | After-Hours Snapshot Data (for US stocks) |  
| `nq`       | object | Night Trading Snapshot Data (for US stocks) |  

| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `lp`       | string | Current Price |  
| `yp`       | string | Previous Closing Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `ts`       | integer| Timestamp (in seconds) |  
| `v`        | string | Trading Volume |  
| `t`        | string | Trading Amount |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.3.4. Response Example  
```json
{
    "msg": "OK",
    "data": [
        {
            "c": "SH:600519",
            "lp": "1628.01",
            "yp": "1537.77",
            "o": "1547.66",
            "h": "1628.01",
            "l": "1541",
            "ts": 1741935600,
            "v": "92913",
            "t": "14882842708",
            "s": 0
        },
        {
            "c": "US:AAPL",
            "lp": "211.103",
            "yp": "216.98",
            "o": "210.71",
            "h": "210.88",
            "l": "209.6",
            "ts": 1741958321,
            "v": "701504",
            "t": "147479220.1710000038",
            "s": 0,
            "pq": {
                "lp": "215.98",
                "ts": 1741872600,
                "v": "370456",
                "t": "80089373.5069999993",
                "h": "216.98",
                "l": "215.06",
                "yp": "216.98"
            },
            "aq": {
                "lp": "210.35",
                "ts": 1741910230,
                "v": "2975239",
                "t": "624035747.6239999533",
                "h": "210.88",
                "l": "209.6",
                "yp": "209.68"
            }
        },
        {
            "c": "US:TSLA",
            "lp": "246.104",
            "yp": "248.09",
            "o": "243.36",
            "h": "242.27",
            "l": "239.24",
            "ts": 1741958323,
            "v": "1491898",
            "t": "364182449.1850000024",
            "s": 0,
            "pq": {
                "lp": "248.16",
                "ts": 1741872600,
                "v": "2386811",
                "t": "588452692.8420000076",
                "h": "250.35",
                "l": "242.25",
                "yp": "248.09"
            },
            "aq": {
                "lp": "241.325",
                "ts": 1741910236,
                "v": "1983968",
                "t": "477821172.7369999886",
                "h": "242.27",
                "l": "239.24",
                "yp": "240.68"
            }
        },
        {
            "c": "HK:9988",
            "lp": "135.8",
            "yp": "131.5",
            "o": "134.5",
            "h": "137.6",
            "l": "132.8",
            "ts": 1741939708,
            "v": "108673140",
            "t": "14720179876.3500003815",
            "s": 0
        },
        {
            "c": "SZ:002594",
            "lp": "375.94",
            "yp": "354.5",
            "o": "357",
            "h": "377.18",
            "l": "355.62",
            "ts": 1741935600,
            "v": "224697",
            "t": "8292987453.8599996567",
            "s": 0
        },
        {
            "c": "SZ:000001",
            "lp": "11.97",
            "yp": "11.84",
            "o": "11.82",
            "h": "12",
            "l": "11.82",
            "ts": 1741935600,
            "v": "1722418",
            "t": "2057970454.4000000954",
            "s": 0
        },
        {
            "c": "HK:700",
            "lp": "521.5",
            "yp": "507.5",
            "o": "513",
            "h": "531",
            "l": "507.5",
            "ts": 1741939708,
            "v": "30711707",
            "t": "16031719897.3950004578",
            "s": 0
        },
        {
            "c": "CF:ETHUSDT",
            "lp": "1898.24",
            "o": "1903.01",
            "h": "1908.20",
            "l": "1820.20",
            "ts": 1741958323,
            "v": "3888386.123",
            "t": "7279502879.43",
            "s": 0
        },
        {
            "c": "CF:BTCUSDT",
            "lp": "83326.10",
            "o": "82622.60",
            "h": "83538.00",
            "l": "79903.40",
            "ts": 1741958323,
            "v": "231872.088",
            "t": "18927958320.32",
            "s": 0
        },
        {
            "c": "SH:600518",
            "lp": "2.18",
            "yp": "2.15",
            "o": "2.14",
            "h": "2.18",
            "l": "2.14",
            "ts": 1741935600,
            "v": "1829039",
            "t": "395823012",
            "s": 0
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 4.4. Get Real-time Latest Market Depth of Trading Products  
- **Interface Address**: `/depth`  
- **Request Method**: `POST`  
- **Interface Description**: Get real-time latest market depth of trading products.  
> [Back to Table of Contents](#table-of-contents)  

#### 4.4.1. Request Parameters  
| Parameter Name | Type   | Required | Description |  
|----------------|--------|----------|-------------|  
| `codes`        | array  | Yes      | List of trading products. See the example below for details. |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.4.2. Request Example  
```json
{
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,600518",
        "SZ:000001,002594",
        "CF:BTCUSDT,ETHUSDT"
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 4.4.3. Response Results  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `b`        | array  | Buy Orders Array |  
| > `p`      | string | Buy Order Price |  
| > `v`      | string | Buy Order Volume |  
| `a`        | array  | Sell Orders Array |  
| > `p`      | string | Sell Order Price |  
| > `v`      | string | Sell Order Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.4.4. Response Example  
```json
{
    "msg": "OK",
    "data": [
        {
            "c": "SZ:002594",
            "b": [
                {
                    "p": "375.94",
                    "v": "258"
                },
                {
                    "p": "375.93",
                    "v": "5"
                },
                {
                    "p": "375.91",
                    "v": "4"
                },
                {
                    "p": "375.9",
                    "v": "5"
                },
                {
                    "p": "375.89",
                    "v": "1"
                }
            ],
            "a": [
                {
                    "p": "376",
                    "v": "65"
                },
                {
                    "p": "376.04",
                    "v": "1"
                },
                {
                    "p": "376.06",
                    "v": "2"
                },
                {
                    "p": "376.08",
                    "v": "1"
                },
                {
                    "p": "376.1",
                    "v": "9"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "US:TSLA",
            "b": [
                {
                    "p": "245.9",
                    "v": "20"
                }
            ],
            "a": [
                {
                    "p": "246",
                    "v": "1040"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "SZ:000001",
            "b": [
                {
                    "p": "11.97",
                    "v": "4460"
                },
                {
                    "p": "11.96",
                    "v": "19581"
                },
                {
                    "p": "11.95",
                    "v": "6701"
                },
                {
                    "p": "11.94",
                    "v": "5378"
                },
                {
                    "p": "11.93",
                    "v": "6165"
                }
            ],
            "a": [
                {
                    "p": "11.98",
                    "v": "18070"
                },
                {
                    "p": "11.99",
                    "v": "23478"
                },
                {
                    "p": "12",
                    "v": "82766"
                },
                {
                    "p": "12.01",
                    "v": "23966"
                },
                {
                    "p": "12.02",
                    "v": "13333"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "SH:600518",
            "b": [
                {
                    "p": "2.17",
                    "v": "81062"
                },
                {
                    "p": "2.16",
                    "v": "119137"
                },
                {
                    "p": "2.15",
                    "v": "113072"
                },
                {
                    "p": "2.14",
                    "v": "66228"
                },
                {
                    "p": "2.13",
                    "v": "42995"
                }
            ],
            "a": [
                {
                    "p": "2.18",
                    "v": "194574"
                },
                {
                    "p": "2.19",
                    "v": "135127"
                },
                {
                    "p": "2.2",
                    "v": "158599"
                },
                {
                    "p": "2.21",
                    "v": "67378"
                },
                {
                    "p": "2.22",
                    "v": "58428"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "US:AAPL",
            "b": [
                {
                    "p": "211.12",
                    "v": "1"
                }
            ],
            "a": [
                {
                    "p": "211.16",
                    "v": "400"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "HK:700",
            "b": [
                {
                    "p": "521.5",
                    "v": "197500"
                },
                {
                    "p": "521",
                    "v": "199200"
                },
                {
                    "p": "520.5",
                    "v": "260300"
                },
                {
                    "p": "520",
                    "v": "663700"
                },
                {
                    "p": "519.5",
                    "v": "43000"
                },
                {
                    "p": "519",
                    "v": "144100"
                },
                {
                    "p": "518.5",
                    "v": "94900"
                },
                {
                    "p": "518",
                    "v": "145100"
                },
                {
                    "p": "517.5",
                    "v": "16000"
                },
                {
                    "p": "517",
                    "v": "49700"
                }
            ],
            "a": [
                {
                    "p": "522",
                    "v": "100"
                },
                {
                    "p": "522.5",
                    "v": "100"
                },
                {
                    "p": "523",
                    "v": "10800"
                },
                {
                    "p": "523.5",
                    "v": "100"
                },
                {
                    "p": "524",
                    "v": "700"
                },
                {
                    "p": "524.5",
                    "v": "128600"
                },
                {
                    "p": "525",
                    "v": "128400"
                },
                {
                    "p": "525.5",
                    "v": "77100"
                },
                {
                    "p": "526",
                    "v": "87100"
                },
                {
                    "p": "526.5",
                    "v": "86500"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "SH:600519",
            "b": [
                {
                    "p": "1628.01",
                    "v": "16"
                },
                {
                    "p": "1628",
                    "v": "28"
                },
                {
                    "p": "1627.99",
                    "v": "1"
                },
                {
                    "p": "1627.87",
                    "v": "1"
                },
                {
                    "p": "1627.61",
                    "v": "1"
                }
            ],
            "a": [
                {
                    "p": "1628.02",
                    "v": "4"
                },
                {
                    "p": "1628.03",
                    "v": "0"
                },
                {
                    "p": "1628.05",
                    "v": "2"
                },
                {
                    "p": "1628.08",
                    "v": "4"
                },
                {
                    "p": "1628.09",
                    "v": "1"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "HK:9988",
            "b": [
                {
                    "p": "135.8",
                    "v": "45500"
                },
                {
                    "p": "135.7",
                    "v": "606300"
                },
                {
                    "p": "135.6",
                    "v": "199600"
                },
                {
                    "p": "135.5",
                    "v": "233400"
                },
                {
                    "p": "135.4",
                    "v": "216200"
                },
                {
                    "p": "135.3",
                    "v": "160800"
                },
                {
                    "p": "135.2",
                    "v": "569900"
                },
                {
                    "p": "135.1",
                    "v": "167500"
                },
                {
                    "p": "135",
                    "v": "1663500"
                },
                {
                    "p": "134.9",
                    "v": "160400"
                }
            ],
            "a": [
                {
                    "p": "135.9",
                    "v": "310000"
                },
                {
                    "p": "136",
                    "v": "355500"
                },
                {
                    "p": "136.1",
                    "v": "48500"
                },
                {
                    "p": "136.2",
                    "v": "377700"
                },
                {
                    "p": "136.3",
                    "v": "51600"
                },
                {
                    "p": "136.4",
                    "v": "235500"
                },
                {
                    "p": "136.5",
                    "v": "148500"
                },
                {
                    "p": "136.6",
                    "v": "220100"
                },
                {
                    "p": "136.7",
                    "v": "257200"
                },
                {
                    "p": "136.8",
                    "v": "298100"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "CF:BTCUSDT",
            "b": [
                {
                    "p": "83349.90",
                    "v": "11.377"
                },
                {
                    "p": "83349.80",
                    "v": "0.204"
                },
                {
                    "p": "83349.70",
                    "v": "0.002"
                },
                {
                    "p": "83349.60",
                    "v": "0.048"
                },
                {
                    "p": "83349.00",
                    "v": "0.048"
                },
                {
                    "p": "83348.80",
                    "v": "0.050"
                },
                {
                    "p": "83348.60",
                    "v": "0.002"
                },
                {
                    "p": "83348.00",
                    "v": "0.058"
                },
                {
                    "p": "83347.80",
                    "v": "0.002"
                },
                {
                    "p": "83347.60",
                    "v": "0.228"
                },
                {
                    "p": "83347.10",
                    "v": "0.004"
                },
                {
                    "p": "83346.90",
                    "v": "0.002"
                },
                {
                    "p": "83346.80",
                    "v": "0.048"
                },
                {
                    "p": "83346.70",
                    "v": "0.002"
                },
                {
                    "p": "83346.60",
                    "v": "0.409"
                },
                {
                    "p": "83346.40",
                    "v": "0.048"
                },
                {
                    "p": "83346.10",
                    "v": "0.004"
                },
                {
                    "p": "83346.00",
                    "v": "0.654"
                },
                {
                    "p": "83345.90",
                    "v": "0.146"
                },
                {
                    "p": "83345.80",
                    "v": "0.140"
                }
            ],
            "a": [
                {
                    "p": "83350.00",
                    "v": "1.832"
                },
                {
                    "p": "83350.10",
                    "v": "0.002"
                },
                {
                    "p": "83350.20",
                    "v": "0.015"
                },
                {
                    "p": "83350.40",
                    "v": "0.002"
                },
                {
                    "p": "83350.60",
                    "v": "0.063"
                },
                {
                    "p": "83350.80",
                    "v": "0.002"
                },
                {
                    "p": "83351.00",
                    "v": "0.002"
                },
                {
                    "p": "83351.20",
                    "v": "0.002"
                },
                {
                    "p": "83351.80",
                    "v": "0.002"
                },
                {
                    "p": "83352.00",
                    "v": "0.002"
                },
                {
                    "p": "83352.50",
                    "v": "0.002"
                },
                {
                    "p": "83352.60",
                    "v": "0.002"
                },
                {
                    "p": "83352.70",
                    "v": "0.002"
                },
                {
                    "p": "83353.00",
                    "v": "0.002"
                },
                {
                    "p": "83353.10",
                    "v": "0.002"
                },
                {
                    "p": "83353.20",
                    "v": "0.363"
                },
                {
                    "p": "83353.30",
                    "v": "0.527"
                },
                {
                    "p": "83353.40",
                    "v": "0.002"
                },
                {
                    "p": "83353.50",
                    "v": "0.002"
                },
                {
                    "p": "83353.70",
                    "v": "0.005"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "CF:ETHUSDT",
            "b": [
                {
                    "p": "1899.65",
                    "v": "251.119"
                },
                {
                    "p": "1899.64",
                    "v": "0.034"
                },
                {
                    "p": "1899.63",
                    "v": "5.214"
                },
                {
                    "p": "1899.62",
                    "v": "13.234"
                },
                {
                    "p": "1899.61",
                    "v": "13.173"
                },
                {
                    "p": "1899.60",
                    "v": "6.532"
                },
                {
                    "p": "1899.59",
                    "v": "5.791"
                },
                {
                    "p": "1899.58",
                    "v": "10.863"
                },
                {
                    "p": "1899.57",
                    "v": "5.809"
                },
                {
                    "p": "1899.56",
                    "v": "0.844"
                },
                {
                    "p": "1899.55",
                    "v": "3.688"
                },
                {
                    "p": "1899.54",
                    "v": "0.036"
                },
                {
                    "p": "1899.52",
                    "v": "2.655"
                },
                {
                    "p": "1899.51",
                    "v": "2.118"
                },
                {
                    "p": "1899.50",
                    "v": "27.446"
                },
                {
                    "p": "1899.49",
                    "v": "0.090"
                },
                {
                    "p": "1899.48",
                    "v": "3.388"
                },
                {
                    "p": "1899.47",
                    "v": "0.579"
                },
                {
                    "p": "1899.46",
                    "v": "22.098"
                },
                {
                    "p": "1899.45",
                    "v": "8.447"
                }
            ],
            "a": [
                {
                    "p": "1899.66",
                    "v": "0.386"
                },
                {
                    "p": "1899.68",
                    "v": "0.168"
                },
                {
                    "p": "1899.70",
                    "v": "0.011"
                },
                {
                    "p": "1899.72",
                    "v": "0.058"
                },
                {
                    "p": "1899.73",
                    "v": "0.080"
                },
                {
                    "p": "1899.74",
                    "v": "0.037"
                },
                {
                    "p": "1899.75",
                    "v": "2.526"
                },
                {
                    "p": "1899.76",
                    "v": "0.053"
                },
                {
                    "p": "1899.77",
                    "v": "1.000"
                },
                {
                    "p": "1899.78",
                    "v": "0.022"
                },
                {
                    "p": "1899.79",
                    "v": "1.011"
                },
                {
                    "p": "1899.80",
                    "v": "19.269"
                },
                {
                    "p": "1899.81",
                    "v": "45.746"
                },
                {
                    "p": "1899.82",
                    "v": "0.551"
                },
                {
                    "p": "1899.83",
                    "v": "0.027"
                },
                {
                    "p": "1899.84",
                    "v": "0.153"
                },
                {
                    "p": "1899.85",
                    "v": "0.848"
                },
                {
                    "p": "1899.86",
                    "v": "2.139"
                },
                {
                    "p": "1899.87",
                    "v": "0.074"
                },
                {
                    "p": "1899.88",
                    "v": "3.014"
                }
            ],
            "ts": 1741958378
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 4.5. Get Real-time Latest Trade-by-Trade Details of Trading Products  
- **Interface Address**: `/trade`  
- **Request Method**: `POST`  
- **Interface Description**: Get real-time latest trade-by-trade details of trading products.  
> [Back to Table of Contents](#table-of-contents)  

#### 4.5.1. Request Parameters  
| Parameter Name | Type   | Required | Description |  
|----------------|--------|----------|-------------|  
| `codes`        | array  | Yes      | List of trading products. See the example below for details. |  
| `count`        | integer| Yes      | Number of recent trades to request (maximum 50). |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.5.2. Request Example  
```json
{
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,600518",
        "SZ:000001,002594",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "count": 1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 4.5.3. Response Results  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `p`        | string | Current Price |  
| `v`        | string | Current Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
| `d`        | integer| Trade Direction (see [Section 2.2](#22-trade-directions) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.5.4. Response Example  
```json
{
    "msg": "OK",
    "data": [
        {
            "c": "CF:ETHUSDT",
            "p": "1900.73",
            "v": "0.025",
            "ts": 1741958480,
            "d": 1
        },
        {
            "c": "CF:BTCUSDT",
            "p": "83429.70",
            "v": "0.025",
            "ts": 1741958479,
            "d": 2
        },
        {
            "c": "HK:700",
            "p": "521.5",
            "v": "2027400",
            "ts": 1741939708,
            "d": 0
        },
        {
            "c": "US:TSLA",
            "p": "246.039",
            "v": "10",
            "ts": 1741958480,
            "d": 0
        },
        {
            "c": "SZ:002594",
            "p": "375.94",
            "v": "3778",
            "ts": 1741935600,
            "d": 1
        },
        {
            "c": "US:AAPL",
            "p": "211.223",
            "v": "1",
            "ts": 1741958478,
            "d": 0
        },
        {
            "c": "SH:600519",
            "p": "1628.01",
            "v": "1581",
            "ts": 1741935600,
            "d": 1
        },
        {
            "c": "SH:600518",
            "p": "2.18",
            "v": "31067",
            "ts": 1741935600,
            "d": 1
        },
        {
            "c": "HK:9988",
            "p": "135.8",
            "v": "5944400",
            "ts": 1741939708,
            "d": 0
        },
        {
            "c": "SZ:000001",
            "p": "11.97",
            "v": "24450",
            "ts": 1741935600,
            "d": 1
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 4.6. Get K-line Data of Trading Products  
- **Interface Address**: `/kline`  
- **Request Method**: `POST`  
- **Interface Description**: Get K-line data of trading products, starting from the most recent and moving backward.  
> [Back to Table of Contents](#table-of-contents)  

#### 4.6.1. Request Parameters  
| Parameter Name | Type   | Required | Description |  
|----------------|--------|----------|-------------|  
| `kline_reqs`   | array  | Yes      | K-line request array |  
| > `c`          | string | Yes      | Stock code (multiple codes separated by commas) |  
| > `co`         | integer| Yes      | Number of K-lines to request |  
| > `a`          | integer| Yes      | Adjustment type (0: No adjustment, 1: Forward adjustment) |  
| > `kt`         | integer| Yes      | K-line type (see [Section 2.1](#21-k-line-types) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.6.2. Request Example  
```json
{
    "kline_reqs": [
        {
            "c": "US:AAPL,TSLA",
            "co": 1,
            "a": 0,
            "kt": 1001
        },
        {
            "c": "HK:700,9988",
            "co": 1,
            "a": 0,
            "kt": 1001
        },
        {
            "c": "SH:600519,600518",
            "co": 1,
            "a": 0,
            "kt": 1001
        },
        {
            "c": "CF:BTCUSDT,ETHUSDT",
            "co": 1,
            "a": 0,
            "kt": 1001
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 4.6.3. Response Results  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `k`        | array  | K-line Data Array |  
| > `o`      | string | Opening Price |  
| > `cl`     | string | Closing Price |  
| > `h`      | string | Highest Price |  
| > `l`      | string | Lowest Price |  
| > `v`      | string | Trading Volume |  
| > `ts`     | integer| Timestamp (in seconds) |  
| > `kt`     | integer| K-line Type (see [Section 2.1](#21-k-line-types) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.6.4. Response Example  
```json
{
    "msg": "OK",
    "data": [
        {
            "c": "SH:600519",
            "k": [
                {
                    "c": "SH:600519",
                    "o": "1547.66",
                    "cl": "1628.01",
                    "h": "1628.01",
                    "l": "1541",
                    "v": "91332",
                    "ts": 1741881600,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "US:TSLA",
            "k": [
                {
                    "c": "US:TSLA",
                    "o": "247.31",
                    "cl": "249.805",
                    "h": "249.86",
                    "l": "246.111",
                    "v": "8356767",
                    "ts": 1741924800,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "US:AAPL",
            "k": [
                {
                    "c": "US:AAPL",
                    "o": "211.25",
                    "cl": "212.8",
                    "h": "213.43",
                    "l": "211.25",
                    "v": "4827801",
                    "ts": 1741924800,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "HK:9988",
            "k": [
                {
                    "c": "HK:9988",
                    "o": "134.5",
                    "cl": "135.8",
                    "h": "137.6",
                    "l": "132.8",
                    "v": "108673140",
                    "ts": 1741881600,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "CF:ETHUSDT",
            "k": [
                {
                    "c": "CF:ETHUSDT",
                    "o": "1863.75",
                    "cl": "1908.41",
                    "h": "1912.14",
                    "l": "1860.41",
                    "v": "1384521.330",
                    "ts": 1741910400,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "CF:BTCUSDT",
            "k": [
                {
                    "c": "CF:BTCUSDT",
                    "o": "81085.50",
                    "cl": "83723.30",
                    "h": "83771.80",
                    "l": "80772.00",
                    "v": "92544.973",
                    "ts": 1741910400,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "HK:700",
            "k": [
                {
                    "c": "HK:700",
                    "o": "513",
                    "cl": "521.5",
                    "h": "531",
                    "l": "507.5",
                    "v": "30711707",
                    "ts": 1741881600,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "SH:600518",
            "k": [
                {
                    "c": "SH:600518",
                    "o": "2.14",
                    "cl": "2.18",
                    "h": "2.18",
                    "l": "2.14",
                    "v": "1829039",
                    "ts": 1741881600,
                    "kt": 1001
                }
            ]
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 4.7. Get Historical K-line Data of Trading Products  
- **Interface Address**: `/history`  
- **Request Method**: `POST`  
- **Interface Description**: Get historical K-line data of trading products, starting from the specified end time and moving backward.  
> [Back to Table of Contents](#table-of-contents)  

#### 4.7.1. Request Parameters  
| Parameter Name | Type   | Required | Description |  
|----------------|--------|----------|-------------|  
| `kline_reqs`   | array  | Yes      | K-line request array |  
| > `c`          | string | Yes      | Stock code (multiple codes separated by commas) |  
| > `co`         | integer| Yes      | Number of K-lines to request |  
| > `a`          | integer| Yes      | Adjustment type (0: No adjustment, 1: Forward adjustment) |  
| > `kt`         | integer| Yes      | K-line type (see [Section 2.1](#21-k-line-types) for details) |  
| > `e`          | integer| Yes      | End timestamp for the K-line request (in seconds) |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.7.2. Request Example  
```json
{
    "kline_reqs": [
        {
            "c": "CF:BTCUSDT",
            "e": 1741959608,
            "co": 1,
            "a": 0,
            "kt": 1001
        },
        {
            "c": "US:AAPL",
            "e": 1741959608,
            "co": 1,
            "a": 0,
            "kt": 1001
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 4.7.3. Response Results  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `k`        | array  | K-line Data Array |  
| > `o`      | string | Opening Price |  
| > `cl`     | string | Closing Price |  
| > `h`      | string | Highest Price |  
| > `l`      | string | Lowest Price |  
| > `v`      | string | Trading Volume |  
| > `ts`     | integer| Timestamp (in seconds) |  
| > `kt`     | integer| K-line Type (see [Section 2.1](#21-k-line-types) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 4.7.4. Response Example  
```json
{
    "msg": "OK",
    "data": [
        {
            "c": "US:AAPL",
            "k": [
                {
                    "c": "US:AAPL",
                    "o": "211.29",
                    "cl": "213",
                    "h": "213.43",
                    "l": "211.25",
                    "v": "5848917",
                    "ts": 1741924800,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "CF:BTCUSDT",
            "k": [
                {
                    "c": "CF:BTCUSDT",
                    "o": "81085.50",
                    "cl": "83399.10",
                    "h": "83771.80",
                    "l": "80772.00",
                    "v": "93898.117",
                    "ts": 1741910400,
                    "kt": 1001
                }
            ]
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

## 5. WebSocket Protocol Interface Definitions  
### 5.0. WebSocket Protocol Integration Instructions  
- **WebSocket Address**: `wss://api.qos.hk/ws`  
- **Error Code Explanation**: The `msg` field returns "OK" for success; otherwise, it returns a specific error description.  
- **Format**: All requests and responses are in JSON format.  
- **Authentication Method**: Add the key field to the URL parameters or request headers.  

When establishing a connection, simply add the key to the **URL parameters** or **request headers** by filling in the key field. After establishing the connection, you can start sending heartbeats, subscribing to real-time snapshots, subscribing to real-time quotes, subscribing to real-time trade prices, and subscribing to K-line data.  
> [Back to Table of Contents](#table-of-contents)  

#### 5.0.1. Request Headers or URL Parameters  
| Parameter | Type   | Description |  
|-----------|--------|-------------|  
| `key`     | string | The API key value returned during registration |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.0.2. Limitations  
The number of subscribed products and connections is limited based on the subscription plan. The default is 10 products and 1 connection. Contact customer service to adjust these limits according to different subscription plans. Note: The request frequency to the server must be at least 1 second per request.  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.1. Heartbeat  
Send a heartbeat every 10-30 seconds.  
#### 5.1.1. Send Heartbeat  
```json
{"type":"H"}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.1.2. Heartbeat Response  
```json
{
    "type": "H",
    "msg": "OK",
    "time": 1742046368
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.2. Subscribe to Real-time Snapshots of Trading Products  
#### 5.2.1. Send Subscription Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "S" for subscription, "SC" for unsubscription |  
| `codes`    | List of codes (see example below for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.2.2. Subscription Command Example  
```json
{
    "type": "S",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.2.3. Subscription Command Response  
```json
{
    "type": "S",
    "msg": "OK",
    "time": 1731650860,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.2.4. Unsubscription Command Example  
```json
{
    "type": "SC",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.2.5. Unsubscription Command Response  
```json
{
    "type": "SC",
    "msg": "OK",
    "time": 1731650871,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.2.6. Data Push  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `tp`       | string | Data type ("S" for snapshot data) |  
| `c`        | string | Stock Code |  
| `lp`       | string | Current Price |  
| `yp`       | string | Yesterday's Closing Price |  
| `o`        | string | Opening Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `ts`       | integer| Timestamp (in seconds) |  
| `v`        | string | Trading Volume |  
| `t`        | string | Trading Amount |  
| `s`        | integer| Trading Status (0: Trading, 1: Suspended) |  
> [Back to Table of Contents](#table-of-contents)  

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
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.3. Subscribe to Real-time Trade-by-Trade Details of Trading Products  
#### 5.3.1. Send Subscription Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "T" for subscription, "TC" for unsubscription |  
| `codes`    | List of codes (see example below for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.3.2. Subscription Command Example  
```json
{
    "type": "T",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.3.3. Subscription Command Response  
```json
{
    "type": "T",
    "msg": "OK",
    "time": 1731650860,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.3.4. Unsubscription Command Example  
```json
{
    "type": "TC",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.3.5. Unsubscription Command Response  
```json
{
    "type": "TC",
    "msg": "OK",
    "time": 1731650871,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.3.6. Data Push  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `tp`       | string | Data type ("T" for trade data) |  
| `c`        | string | Stock Code |  
| `p`        | string | Current Price |  
| `v`        | string | Current Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
| `d`        | integer| Trade Direction (see [Section 2.2](#22-trade-directions) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.3.7. Data Push Example  
```json
{
    "tp": "T",
    "c": "US:TSLA",
    "p": "246.39",
    "v": "100",
    "ts": 1741960243,
    "d": 1
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.4. Subscribe to Real-time Market Depth of Trading Products  
#### 5.4.1. Send Subscription Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "D" for subscription, "DC" for unsubscription |  
| `codes`    | List of codes (see example below for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.4.2. Subscription Command Example  
```json
{
    "type": "D",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.4.3. Subscription Command Response  
```json
{
    "type": "D",
    "msg": "OK",
    "time": 1731650860,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.4.4. Unsubscription Command Example  
```json
{
    "type": "DC",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.4.5. Unsubscription Command Response  
```json
{
    "type": "DC",
    "msg": "OK",
    "time": 1731650871,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.4.6. Data Push  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `tp`       | string | Data type ("D" for market depth) |  
| `c`        | string | Stock Code |  
| `b`        | array  | Buy Orders Array |  
| > `p`      | string | Buy Order Price |  
| > `v`      | string | Buy Order Volume |  
| `a`        | array  | Sell Orders Array |  
| > `p`      | string | Sell Order Price |  
| > `v`      | string | Sell Order Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.4.7. Data Push Example  
```json
{
    "tp": "D",
    "c": "US:AAPL",
    "b": [
        {
            "p": "212.62",
            "v": "110"
        }
    ],
    "a": [
        {
            "p": "212.66",
            "v": "338"
        }
    ],
    "ts": 1741960347
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.5. Subscribe to Real-time K-line Data of Trading Products  
#### 5.5.1. Send Subscription Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "K" for subscription, "KC" for unsubscription |  
| `codes`    | List of codes (see example below for details) |  
| `kt`       | K-line type (see [Section 2.1](#21-k-line-types) for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.5.2. Subscription Command Example  
```json
{
    "type": "K",
    "codes": [
        "CF:BTCUSDT,ETHUSDT"
    ],
    "kt":1001,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.5.3. Subscription Command Response  
```json
{
    "type": "K",
    "msg": "OK",
    "time": 1731650860,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.5.4. Unsubscription Command Example  
```json
{
    "type": "KC",
    "codes": [
        "CF:BTCUSDT,ETHUSDT"
    ],
    "kt":1001,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.5.5. Unsubscription Command Response  
```json
{
    "type": "KC",
    "msg": "OK",
    "time": 1741960736,
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.5.6. Data Push  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `tp`       | string | Data type ("K" for K-line data) |  
| `c`        | string | Stock Code |  
| `o`        | string | Opening Price |  
| `cl`       | string | Closing Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `v`        | string | Trading Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
| `kt`       | integer| K-line Type (see [Section 2.1](#21-k-line-types) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.5.7. Data Push Example  
```json
{
    "tp": "K",
    "c": "CF:BTCUSDT",
    "o": "81085.50",
    "cl": "83504.10",
    "h": "83856.00",
    "l": "80772.00",
    "v": "103162.630",
    "ts": 1741910400,
    "kt": 1001
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.6. Request Real-time Snapshots of Trading Products  
#### 5.6.1. Send Request Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "RS" for request, response type is also "RS" |  
| `codes`    | List of codes (see example below for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.6.2. Request Command Example  
```json
{
    "type": "RS",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.6.3. Response Data  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `lp`       | string | Current Price |  
| `yp`       | string | Yesterday's Closing Price |  
| `o`        | string | Opening Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `ts`       | integer| Timestamp (in seconds) |  
| `v`        | string | Trading Volume |  
| `t`        | string | Trading Amount |  
| `s`        | integer| Trading Status (0: Trading, 1: Suspended) |  
| `pq`       | object | Pre-Market Snapshot Data (for US stocks) |  
| `aq`       | object | After-Hours Snapshot Data (for US stocks) |  
| `nq`       | object | Night Trading Snapshot Data (for US stocks) |  

| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `lp`       | string | Current Price |  
| `yp`       | string | Previous Closing Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `ts`       | integer| Timestamp (in seconds) |  
| `v`        | string | Trading Volume |  
| `t`        | string | Trading Amount |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.6.4. Response Data Example  
```json
{
    "type": "RS",
    "msg": "OK",
    "reqid": 1,
    "data": [
        {
            "c": "HK:700",
            "lp": "521.5",
            "yp": "507.5",
            "o": "513",
            "h": "531",
            "l": "507.5",
            "ts": 1741939710,
            "v": "30711707",
            "t": "16031719897",
            "s": 0
        },
        {
            "c": "SZ:000001",
            "lp": "11.97",
            "yp": "11.84",
            "o": "11.82",
            "h": "12",
            "l": "11.82",
            "ts": 1741935600,
            "v": "1722418",
            "t": "2057970454.4000000954",
            "s": 0
        },
        {
            "c": "SZ:002594",
            "lp": "375.94",
            "yp": "354.5",
            "o": "357",
            "h": "377.18",
            "l": "355.62",
            "ts": 1741935600,
            "v": "224697",
            "t": "8292987453.8599996567",
            "s": 0
        },
        {
            "c": "HK:9988",
            "lp": "135.8",
            "yp": "131.5",
            "o": "134.5",
            "h": "137.6",
            "l": "132.8",
            "ts": 1741939710,
            "v": "108673140",
            "t": "14720179876",
            "s": 0
        },
        {
            "c": "US:AAPL",
            "lp": "213.3",
            "yp": "209.68",
            "o": "213.49",
            "h": "213.94",
            "l": "209.58",
            "ts": 1741994900,
            "v": "60086076",
            "t": "12765424420.7719993591",
            "s": 0,
            "pq": {
                "lp": "211.34",
                "ts": 1741959001,
                "v": "785589",
                "t": "165231199.5090000033",
                "h": "211.83",
                "l": "210.201",
                "yp": "209.68"
            },
            "aq": {
                "lp": "210.2",
                "ts": 1741910397,
                "v": "2959409",
                "t": "620717515.6900000572",
                "h": "210.88",
                "l": "209.6",
                "yp": "209.68"
            }
        },
        {
            "c": "SH:600519",
            "lp": "1628.01",
            "yp": "1537.77",
            "o": "1547.66",
            "h": "1628.01",
            "l": "1541",
            "ts": 1741935600,
            "v": "92913",
            "t": "14882842708",
            "s": 0
        },
        {
            "c": "US:TSLA",
            "lp": "249.79",
            "yp": "240.68",
            "o": "249.85",
            "h": "251.58",
            "l": "240.74",
            "ts": 1741994901,
            "v": "100132131",
            "t": "24755030678.8250007629",
            "s": 0,
            "pq": {
                "lp": "247.14",
                "ts": 1741959000,
                "v": "1612706",
                "t": "394031355.1779999733",
                "h": "247.45",
                "l": "242.56",
                "yp": "240.68"
            },
            "aq": {
                "lp": "241.1",
                "ts": 1741910399,
                "v": "1996190",
                "t": "480767552.1090000272",
                "h": "242.27",
                "l": "239.24",
                "yp": "240.68"
            }
        },
        {
            "c": "SH:688981",
            "lp": "94.81",
            "yp": "92.98",
            "o": "92.98",
            "h": "95.61",
            "l": "92.5",
            "ts": 1741935600,
            "v": "401376",
            "t": "3790992802",
            "s": 0
        },
        {
            "c": "CF:ETHUSDT",
            "lp": "1918.00",
            "o": "1863.19",
            "h": "1945.62",
            "l": "1860.41",
            "ts": 1741994903,
            "v": "3476304.838",
            "t": "6634489059.81",
            "s": 0
        },
        {
            "c": "CF:BTCUSDT",
            "lp": "84185.50",
            "o": "81113.80",
            "h": "85270.20",
            "l": "80772.00",
            "ts": 1741994901,
            "v": "233257.549",
            "t": "19451169797.35",
            "s": 0
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.7. Request Real-time Trade-by-Trade Details of Trading Products  
#### 5.7.1. Send Request Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "RT" for request, response type is also "RT" |  
| `codes`    | List of codes (see example below for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
| `count`    | Number of recent trades to request (maximum 50). |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.7.2. Request Command Example  
```json
{
    "type": "RT",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1,
    "count":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.7.3. Response Data  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `p`        | string | Current Price |  
| `v`        | string | Current Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
| `d`        | integer| Trade Direction (see [Section 2.2](#22-trade-directions) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.7.4. Response Data Example  
```json
{
    "type": "RT",
    "msg": "OK",
    "reqid": 1,
    "data": [
        {
            "c": "CF:ETHUSDT",
            "p": "1913.68",
            "v": "0.050",
            "ts": 1741997836,
            "d": 1
        },
        {
            "c": "CF:BTCUSDT",
            "p": "84135.00",
            "v": "0.005",
            "ts": 1741997836,
            "d": 1
        },
        {
            "c": "US:TSLA",
            "p": "249.83",
            "v": "4",
            "ts": 1741996798,
            "d": 0
        },
        {
            "c": "US:AAPL",
            "p": "213.35",
            "v": "1",
            "ts": 1741996798,
            "d": 1
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.8. Request Real-time Market Depth of Trading Products  
#### 5.8.1. Send Request Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "RD" for request, response type is also "RD" |  
| `codes`    | List of codes (see example below for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.8.2. Request Command Example  
```json
{
    "type": "RD",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.8.3. Response Data  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `b`        | array  | Buy Orders Array |  
| > `p`      | string | Buy Order Price |  
| > `v`      | string | Buy Order Volume |  
| `a`        | array  | Sell Orders Array |  
| > `p`      | string | Sell Order Price |  
| > `v`      | string | Sell Order Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.8.4. Response Data Example  
```json
{
    "type": "RD",
    "msg": "OK",
    "reqid": 1,
    "data": [
        {
            "c": "US:TSLA",
            "b": [
                {
                    "p": "245.9",
                    "v": "20"
                }
            ],
            "a": [
                {
                    "p": "246",
                    "v": "1040"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "US:AAPL",
            "b": [
                {
                    "p": "211.12",
                    "v": "1"
                }
            ],
            "a": [
                {
                    "p": "211.16",
                    "v": "400"
                }
            ],
            "ts": 1741958378
        },
        {
            "c": "SH:688981",
            "b": [
                {
                    "p": "94.81",
                    "v": "1256"
                },
                {
                    "p": "94.8",
                    "v": "550"
                },
                {
                    "p": "94.79",
                    "v": "165"
                },
                {
                    "p": "94.78",
                    "v": "170"
                },
                {
                    "p": "94.77",
                    "v": "15"
                }
            ],
            "a": [
                {
                    "p": "94.82",
                    "v": "199"
                },
                {
                    "p": "94.83",
                    "v": "70"
                },
                {
                    "p": "94.84",
                    "v": "66"
                },
                {
                    "p": "94.85",
                    "v": "330"
                },
                {
                    "p": "94.86",
                    "v": "159"
                }
            ],
            "ts": 1742047367
        },
        {
            "c": "SZ:000001",
            "b": [
                {
                    "p": "11.97",
                    "v": "4460"
                },
                {
                    "p": "11.96",
                    "v": "19581"
                },
                {
                    "p": "11.95",
                    "v": "6701"
                },
                {
                    "p": "11.94",
                    "v": "5378"
                },
                {
                    "p": "11.93",
                    "v": "6165"
                }
            ],
            "a": [
                {
                    "p": "11.98",
                    "v": "18070"
                },
                {
                    "p": "11.99",
                    "v": "23478"
                },
                {
                    "p": "12",
                    "v": "82766"
                },
                {
                    "p": "12.01",
                    "v": "23966"
                },
                {
                    "p": "12.02",
                    "v": "13333"
                }
            ],
            "ts": 1742047367
        },
        {
            "c": "SH:600519",
            "b": [
                {
                    "p": "1628.01",
                    "v": "16"
                },
                {
                    "p": "1628",
                    "v": "28"
                },
                {
                    "p": "1627.99",
                    "v": "1"
                },
                {
                    "p": "1627.87",
                    "v": "1"
                },
                {
                    "p": "1627.61",
                    "v": "1"
                }
            ],
            "a": [
                {
                    "p": "1628.02",
                    "v": "4"
                },
                {
                    "p": "1628.03",
                    "v": "0"
                },
                {
                    "p": "1628.05",
                    "v": "2"
                },
                {
                    "p": "1628.08",
                    "v": "4"
                },
                {
                    "p": "1628.09",
                    "v": "1"
                }
            ],
            "ts": 1742047367
        },
        {
            "c": "SZ:002594",
            "b": [
                {
                    "p": "375.94",
                    "v": "258"
                },
                {
                    "p": "375.93",
                    "v": "5"
                },
                {
                    "p": "375.91",
                    "v": "4"
                },
                {
                    "p": "375.9",
                    "v": "5"
                },
                {
                    "p": "375.89",
                    "v": "1"
                }
            ],
            "a": [
                {
                    "p": "376",
                    "v": "65"
                },
                {
                    "p": "376.04",
                    "v": "1"
                },
                {
                    "p": "376.06",
                    "v": "2"
                },
                {
                    "p": "376.08",
                    "v": "1"
                },
                {
                    "p": "376.1",
                    "v": "9"
                }
            ],
            "ts": 1742047367
        },
        {
            "c": "HK:9988",
            "b": [
                {
                    "p": "135.8",
                    "v": "45500"
                },
                {
                    "p": "135.7",
                    "v": "606300"
                },
                {
                    "p": "135.6",
                    "v": "199600"
                },
                {
                    "p": "135.5",
                    "v": "233400"
                },
                {
                    "p": "135.4",
                    "v": "216200"
                },
                {
                    "p": "135.3",
                    "v": "160800"
                },
                {
                    "p": "135.2",
                    "v": "569900"
                },
                {
                    "p": "135.1",
                    "v": "167500"
                },
                {
                    "p": "135",
                    "v": "1663500"
                },
                {
                    "p": "134.9",
                    "v": "160400"
                }
            ],
            "a": [
                {
                    "p": "135.9",
                    "v": "310000"
                },
                {
                    "p": "136",
                    "v": "355500"
                },
                {
                    "p": "136.1",
                    "v": "48500"
                },
                {
                    "p": "136.2",
                    "v": "377700"
                },
                {
                    "p": "136.3",
                    "v": "51600"
                },
                {
                    "p": "136.4",
                    "v": "235500"
                },
                {
                    "p": "136.5",
                    "v": "148500"
                },
                {
                    "p": "136.6",
                    "v": "220100"
                },
                {
                    "p": "136.7",
                    "v": "257200"
                },
                {
                    "p": "136.8",
                    "v": "298100"
                }
            ],
            "ts": 1742047367
        },
        {
            "c": "HK:700",
            "b": [
                {
                    "p": "521.5",
                    "v": "197500"
                },
                {
                    "p": "521",
                    "v": "199200"
                },
                {
                    "p": "520.5",
                    "v": "260300"
                },
                {
                    "p": "520",
                    "v": "663700"
                },
                {
                    "p": "519.5",
                    "v": "43000"
                },
                {
                    "p": "519",
                    "v": "144100"
                },
                {
                    "p": "518.5",
                    "v": "94900"
                },
                {
                    "p": "518",
                    "v": "145100"
                },
                {
                    "p": "517.5",
                    "v": "16000"
                },
                {
                    "p": "517",
                    "v": "49700"
                }
            ],
            "a": [
                {
                    "p": "522",
                    "v": "100"
                },
                {
                    "p": "522.5",
                    "v": "100"
                },
                {
                    "p": "523",
                    "v": "10800"
                },
                {
                    "p": "523.5",
                    "v": "100"
                },
                {
                    "p": "524",
                    "v": "700"
                },
                {
                    "p": "524.5",
                    "v": "128600"
                },
                {
                    "p": "525",
                    "v": "128400"
                },
                {
                    "p": "525.5",
                    "v": "77100"
                },
                {
                    "p": "526",
                    "v": "87100"
                },
                {
                    "p": "526.5",
                    "v": "86500"
                }
            ],
            "ts": 1742047367
        },
        {
            "c": "CF:ETHUSDT",
            "b": [
                {
                    "p": "1928.17",
                    "v": "43.593"
                },
                {
                    "p": "1928.16",
                    "v": "0.029"
                },
                {
                    "p": "1928.15",
                    "v": "2.046"
                },
                {
                    "p": "1928.13",
                    "v": "0.022"
                },
                {
                    "p": "1928.11",
                    "v": "0.023"
                },
                {
                    "p": "1928.10",
                    "v": "6.507"
                },
                {
                    "p": "1928.09",
                    "v": "1.556"
                },
                {
                    "p": "1928.08",
                    "v": "0.013"
                },
                {
                    "p": "1928.07",
                    "v": "2.133"
                },
                {
                    "p": "1928.05",
                    "v": "0.508"
                },
                {
                    "p": "1928.04",
                    "v": "5.451"
                },
                {
                    "p": "1928.03",
                    "v": "8.369"
                },
                {
                    "p": "1928.02",
                    "v": "0.027"
                },
                {
                    "p": "1928.01",
                    "v": "2.698"
                },
                {
                    "p": "1928.00",
                    "v": "31.130"
                },
                {
                    "p": "1927.99",
                    "v": "20.815"
                },
                {
                    "p": "1927.98",
                    "v": "0.046"
                },
                {
                    "p": "1927.97",
                    "v": "3.022"
                },
                {
                    "p": "1927.96",
                    "v": "10.045"
                },
                {
                    "p": "1927.95",
                    "v": "2.910"
                }
            ],
            "a": [
                {
                    "p": "1928.18",
                    "v": "192.359"
                },
                {
                    "p": "1928.19",
                    "v": "0.023"
                },
                {
                    "p": "1928.20",
                    "v": "6.086"
                },
                {
                    "p": "1928.21",
                    "v": "0.011"
                },
                {
                    "p": "1928.22",
                    "v": "0.012"
                },
                {
                    "p": "1928.23",
                    "v": "12.587"
                },
                {
                    "p": "1928.24",
                    "v": "0.449"
                },
                {
                    "p": "1928.25",
                    "v": "5.066"
                },
                {
                    "p": "1928.26",
                    "v": "0.023"
                },
                {
                    "p": "1928.27",
                    "v": "13.890"
                },
                {
                    "p": "1928.28",
                    "v": "8.296"
                },
                {
                    "p": "1928.29",
                    "v": "3.421"
                },
                {
                    "p": "1928.30",
                    "v": "11.516"
                },
                {
                    "p": "1928.31",
                    "v": "2.095"
                },
                {
                    "p": "1928.32",
                    "v": "0.062"
                },
                {
                    "p": "1928.33",
                    "v": "32.940"
                },
                {
                    "p": "1928.35",
                    "v": "2.307"
                },
                {
                    "p": "1928.36",
                    "v": "0.065"
                },
                {
                    "p": "1928.37",
                    "v": "41.346"
                },
                {
                    "p": "1928.38",
                    "v": "0.020"
                }
            ],
            "ts": 1742047367
        },
        {
            "c": "CF:BTCUSDT",
            "b": [
                {
                    "p": "84304.90",
                    "v": "4.269"
                },
                {
                    "p": "84304.80",
                    "v": "0.004"
                },
                {
                    "p": "84304.40",
                    "v": "0.022"
                },
                {
                    "p": "84304.20",
                    "v": "0.041"
                },
                {
                    "p": "84303.70",
                    "v": "0.002"
                },
                {
                    "p": "84303.30",
                    "v": "0.050"
                },
                {
                    "p": "84303.00",
                    "v": "0.047"
                },
                {
                    "p": "84302.70",
                    "v": "0.008"
                },
                {
                    "p": "84302.50",
                    "v": "0.178"
                },
                {
                    "p": "84302.00",
                    "v": "0.002"
                },
                {
                    "p": "84301.40",
                    "v": "0.002"
                },
                {
                    "p": "84301.20",
                    "v": "0.004"
                },
                {
                    "p": "84301.10",
                    "v": "0.002"
                },
                {
                    "p": "84301.00",
                    "v": "0.047"
                },
                {
                    "p": "84300.90",
                    "v": "0.002"
                },
                {
                    "p": "84300.80",
                    "v": "0.716"
                },
                {
                    "p": "84300.60",
                    "v": "0.137"
                },
                {
                    "p": "84300.50",
                    "v": "0.005"
                },
                {
                    "p": "84300.40",
                    "v": "0.047"
                },
                {
                    "p": "84300.30",
                    "v": "0.002"
                }
            ],
            "a": [
                {
                    "p": "84305.00",
                    "v": "5.340"
                },
                {
                    "p": "84305.10",
                    "v": "0.017"
                },
                {
                    "p": "84305.40",
                    "v": "0.002"
                },
                {
                    "p": "84305.50",
                    "v": "0.775"
                },
                {
                    "p": "84306.00",
                    "v": "0.061"
                },
                {
                    "p": "84306.10",
                    "v": "0.002"
                },
                {
                    "p": "84306.20",
                    "v": "0.002"
                },
                {
                    "p": "84306.30",
                    "v": "0.496"
                },
                {
                    "p": "84306.40",
                    "v": "0.062"
                },
                {
                    "p": "84306.60",
                    "v": "0.002"
                },
                {
                    "p": "84306.70",
                    "v": "0.002"
                },
                {
                    "p": "84306.80",
                    "v": "0.002"
                },
                {
                    "p": "84307.00",
                    "v": "0.002"
                },
                {
                    "p": "84307.30",
                    "v": "0.074"
                },
                {
                    "p": "84307.50",
                    "v": "0.027"
                },
                {
                    "p": "84307.60",
                    "v": "0.002"
                },
                {
                    "p": "84307.70",
                    "v": "0.004"
                },
                {
                    "p": "84307.80",
                    "v": "0.004"
                },
                {
                    "p": "84308.00",
                    "v": "0.111"
                },
                {
                    "p": "84308.10",
                    "v": "0.178"
                }
            ],
            "ts": 1742047367
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.9. Request Real-time K-line Data of Trading Products  
#### 5.9.1. Send Request Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "RK" for request, response type is also "RK" |  
| `kline_reqs` | K-line request array |  
| > `c`      | Stock code (multiple codes separated by commas) |  
| > `co`     | Number of K-lines to request |  
| > `a`      | Adjustment type (0: No adjustment, 1: Forward adjustment) |  
| > `kt`     | K-line type (see [Section 2.1](#21-k-line-types) for details) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.9.2. Request Command Example  
```json
{
    "type": "RK",
    "kline_reqs": [
        {
            "c": "CF:BTCUSDT,ETHUSDT",
            "co": 2,
            "a": 0,
            "kt": 1001
        }
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.9.3. Response Data  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `o`        | string | Opening Price |  
| `cl`       | string | Closing Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `v`        | string | Trading Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
| `kt`       | integer| K-line Type (see [Section 2.1](#21-k-line-types) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.9.4. Response Data Example  
```json
{
    "type": "RK",
    "msg": "OK",
    "reqid": 1,
    "data": [
        {
            "c": "CF:ETHUSDT",
            "k": [
                {
                    "c": "CF:ETHUSDT",
                    "o": "1863.75",
                    "cl": "1910.79",
                    "h": "1945.62",
                    "l": "1860.41",
                    "v": "3494472.929",
                    "ts": 1741910400,
                    "kt": 1001
                },
                {
                    "c": "CF:ETHUSDT",
                    "o": "1910.78",
                    "cl": "1928.35",
                    "h": "1934.77",
                    "l": "1902.47",
                    "v": "1005667.699",
                    "ts": 1741996800,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "CF:BTCUSDT",
            "k": [
                {
                    "c": "CF:BTCUSDT",
                    "o": "81085.50",
                    "cl": "83939.80",
                    "h": "85270.20",
                    "l": "80772.00",
                    "v": "233544.708",
                    "ts": 1741910400,
                    "kt": 1001
                },
                {
                    "c": "CF:BTCUSDT",
                    "o": "83939.90",
                    "cl": "84295.80",
                    "h": "84625.00",
                    "l": "83564.50",
                    "v": "54549.786",
                    "ts": 1741996800,
                    "kt": 1001
                }
            ]
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.10. Request Historical K-line Data of Trading Products  
#### 5.10.1. Send Request Command  
| Field Name | Value |  
|------------|-------|  
| `type`     | "RH" for request, response type is also "RH" |  
| `kline_reqs` | K-line request array |  
| > `c`      | Stock code (multiple codes separated by commas) |  
| > `co`     | Number of K-lines to request |  
| > `a`      | Adjustment type (0: No adjustment, 1: Forward adjustment) |  
| > `kt`     | K-line type (see [Section 2.1](#21-k-line-types) for details) |  
| > `e`      | End timestamp for the K-line request (in seconds) |  
| `reqid`    | Optional. Request ID (integer type). The server will return this value as-is for client-side tracking. |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.10.2. Request Command Example  
```json
{
    "type": "RH",
    "kline_reqs": [
        {
            "c": "CF:BTCUSDT,ETHUSDT",
            "e": 1742047133,
            "co": 2,
            "a": 0,
            "kt": 1001
        }
    ],
    "reqid":1
}
```  
> [Back to Table of Contents](#table-of-contents)  

#### 5.10.3. Response Data  
| Field Name | Type   | Description |  
|------------|--------|-------------|  
| `c`        | string | Stock Code |  
| `o`        | string | Opening Price |  
| `cl`       | string | Closing Price |  
| `h`        | string | Highest Price |  
| `l`        | string | Lowest Price |  
| `v`        | string | Trading Volume |  
| `ts`       | integer| Timestamp (in seconds) |  
| `kt`       | integer| K-line Type (see [Section 2.1](#21-k-line-types) for details) |  
> [Back to Table of Contents](#table-of-contents)  

#### 5.10.4. Response Data Example  
```json
{
    "type": "RH",
    "msg": "OK",
    "reqid": 1,
    "data": [
        {
            "c": "CF:ETHUSDT",
            "k": [
                {
                    "c": "CF:ETHUSDT",
                    "o": "1863.75",
                    "cl": "1910.79",
                    "h": "1945.62",
                    "l": "1860.41",
                    "v": "3494472.929",
                    "ts": 1741910400,
                    "kt": 1001
                },
                {
                    "c": "CF:ETHUSDT",
                    "o": "1910.78",
                    "cl": "1928.73",
                    "h": "1934.77",
                    "l": "1902.47",
                    "v": "1004454.519",
                    "ts": 1741996800,
                    "kt": 1001
                }
            ]
        },
        {
            "c": "CF:BTCUSDT",
            "k": [
                {
                    "c": "CF:BTCUSDT",
                    "o": "81085.50",
                    "cl": "83939.80",
                    "h": "85270.20",
                    "l": "80772.00",
                    "v": "233544.708",
                    "ts": 1741910400,
                    "kt": 1001
                },
                {
                    "c": "CF:BTCUSDT",
                    "o": "83939.90",
                    "cl": "84363.90",
                    "h": "84625.00",
                    "l": "83564.50",
                    "v": "54354.026",
                    "ts": 1741996800,
                    "kt": 1001
                }
            ]
        }
    ]
}
```  
> [Back to Table of Contents](#table-of-contents)  
---  

### 5.11 Request Basic Information of Trading Instruments
#### 5.11.1 Send Request Command
| Field Name | Value                                                                 |
|------------|---------------------------------------------------------------------|
| `type`     | Request Type: RI, the response type will also be RI                 |
| `codes`    | List of codes, specific input method is shown in the example below  |
| `reqid`    | Integer type. Optional. Request ID, provided by the client, and returned as-is by the server. Used by the client to index a unique request and response. The client should decide whether to provide an appropriate value based on its own needs. |

> [Back to Table of Contents](#table-of-contents)

#### 5.11.2 Request Command Example
```json
{
    "type": "RI",
    "codes": [
        "US:AAPL,TSLA",
        "HK:700,9988",
        "SH:600519,688981",
        "SZ:002594,000001",
        "CF:BTCUSDT,ETHUSDT"
    ],
    "reqid":1
}
```
> [Back to Table of Contents](#table-of-contents)
#### 5.11.3 Response Data
| Field Name | Type    | Description                                |
|------------|---------|--------------------------------------------|
| `c`        | string  | Stock code                                 |
| `e`        | string  | Exchange                                   |
| `tc`       | string  | Trading currency                           |
| `nc`       | string  | Chinese name                               |
| `ne`       | string  | English name                               |
| `ls`       | integer | Minimum trading unit                       |
| `ts`       | integer | Total shares                               |
| `os`       | integer | Outstanding shares                         |
| `ep`       | string  | Earnings per share                         |
| `na`       | string  | Net assets per share                       |
| `dy`       | string  | Dividend yield                             |

> [Back to Table of Contents](#table-of-contents)
#### 5.11.4 Response Data Example
```json
{
    "type": "RI",
    "msg": "OK",
    "reqid": 1,
    "data": [
        {
            "c": "US:AAPL",
            "e": "NASD",
            "tc": "USD",
            "nc": "苹果",
            "ne": "Apple Inc.",
            "ls": 1,
            "ts": 15022073000,
            "os": 14998202926,
            "ep": "6.2398844687",
            "na": "4.4439938483",
            "dy": "1"
        },
        {
            "c": "SZ:000001",
            "e": "SZSE",
            "tc": "CNY",
            "nc": "平安银行",
            "ne": "PAB",
            "ls": 100,
            "ts": 19405918198,
            "os": 19405762053,
            "ep": "2.2935271367",
            "na": "21.8950732279",
            "dy": "0.965"
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
            "ep": "59.49",
            "na": "189.2293196185",
            "dy": "54.758"
        },
        {
            "c": "SH:688981",
            "e": "SSE",
            "tc": "CNY",
            "nc": "中芯国际",
            "ne": "SMIC",
            "ls": 100,
            "ts": 7981135214,
            "os": 1988359129,
            "ep": "0.7849289306",
            "na": "18.1090038102",
            "dy": "0"
        },
        {
            "c": "HK:700",
            "e": "SEHK",
            "tc": "HKD",
            "nc": "腾讯控股",
            "ne": "TENCENT",
            "ls": 100,
            "ts": 9178822571,
            "os": 9178822571,
            "ep": "13.8513523179",
            "na": "110.2507143217",
            "dy": "3.4891482482"
        },
        {
            "c": "SZ:002594",
            "e": "SZSE",
            "tc": "CNY",
            "nc": "比亚迪",
            "ne": "BYD",
            "ls": 100,
            "ts": 3039065855,
            "os": 1811265855,
            "ep": "10.32",
            "na": "51.1546641032",
            "dy": "2.9654648599"
        },
        {
            "c": "US:TSLA",
            "e": "NASD",
            "tc": "USD",
            "nc": "特斯拉",
            "ne": "Tesla, Inc.",
            "ls": 1,
            "ts": 3216517037,
            "os": 2799672511,
            "ep": "2.2166834243",
            "na": "22.6683083476",
            "dy": "0"
        },
        {
            "c": "CF:BTCUSDT",
            "e": "Crypto Perpetual Contract",
            "tc": "USDT"
        },
        {
            "c": "CF:ETHUSDT",
            "e": "Crypto Perpetual Contract",
            "tc": "USDT"
        },
        {
            "c": "HK:9988",
            "e": "SEHK",
            "tc": "HKD",
            "nc": "阿里巴巴-W",
            "ne": "BABA-W",
            "ls": 100,
            "ts": 19008233516,
            "os": 19008233516,
            "ep": "4.6275184269",
            "na": "56.8746237928",
            "dy": "1.649298669"
        }
    ]
}
```
> [Back to Table of Contents](#table-of-contents)
---




