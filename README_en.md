**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/README.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/README_en.md)**
# QOS Quote Ocean System - Welcome to Connect and Use
**The quote-ocean-system, abbreviated as "QOS Market Data API," includes real-time APIs for Hong Kong stocks, U.S. stocks, and A-shares. It utilizes REST API and WebSocket interfaces, making it very easy to integrate. This is a free and open-source stock API providing real-time stock data for Hong Kong stocks, U.S. stocks, and mainland China stocks (A-shares). The QOS Market Data System currently offers real-time quotes, real-time K-line, and historical K-line data for stocks across Hong Kong, the United States, and mainland China. Free trials and integration support are available—feel free to contact the author for further details.**
 
- **Author**: Max  
- **Last Updated**: 2024-12-24  
- **HTTP Base URL**: `https://api.qos.hk`  
- **WebSocket URL**: `wss://api.qos.hk/ws`  
- **Authentication Method**: Add the `key` field in the request header  
- **Error Code Description**: A `msg` field returning "OK" indicates success, while any other value provides specific error details  
- **Format**: All requests and responses are in JSON format  
- **Request Method**: All HTTP requests are unified as POST  

[Use PostMan to Quickly Experience the QOS Quotation System](https://github.com/qos-max/quote-ocean-system/blob/main/postman/README_en.md)

## Contact the Author:
- **Telegram**: [https://t.me/qos_max](https://t.me/qos_max)  
- **Skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)  

# Table of Contents

## [1. Free Quick Start - Integration Guide](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#1-quick-start---integration-guide)
### [1.1. Register a Key](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#11-register-a-key)  
### [1.2. Request HTTP APIs](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#12-request-http-api)  
### [1.3. Subscribe to WebSocket Real-time Data Interfaces](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#13-subscribe-to-websocket-real-time-data-api)  

## [2. Enumerations Definitions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#2-enumeration-definitions)  
### [2.1. K-line Types](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#21-k-line-types)  
### [2.2. Trade Directions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#22-trade-directions)  

## [3. Codes and Trading Times for Various Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#3-trading-instrument-codes-and-trading-hours)  

## [4. HTTP Protocol API Definitions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#4-http-protocol-api-definition)  
### [4.0. HTTP Protocol Integration Description](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#40-http-protocol-access-description)  
#### [4.0.1. Request Header](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#401-request-header)  
#### [4.0.2. Limitation Description](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#402-limitations)  
### [4.1. Register a New Key](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#41-register-a-new-key)  
### [4.2. Get Basic Information of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#42-retrieve-basic-instrument-information)  
### [4.3. Get Real-time Market Snapshots of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#43-get-real-time-market-snapshot-for-trading-instruments)  
### [4.4. Get Real-time Latest Depths of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#44-get-real-time-latest-order-book-depth-for-trading-instruments)  
### [4.5. Get Real-time Latest Trade Details of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#45-get-real-time-latest-trade-details-for-trading-instruments)  
### [4.6. Get K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#46-get-k-line-for-trading-instruments)  
### [4.7. Get Historical K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#47-get-historical-k-line-for-trading-instruments)  

## [5. WebSocket Protocol API Definitions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#5-websocket-protocol-api-definition)  
### [5.0. WebSocket Protocol Integration Description](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#50-websocket-protocol-access-instructions)  
#### [5.0.1. Request Header](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#501-request-header)  
#### [5.0.2. Limitation Description](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#502-limitations)  
### [5.1. Heartbeat](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#51-heartbeat)  
### [5.2. Subscribe to Real-time Snapshots of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#52-subscribe-to-real-time-snapshot-of-trading-instruments)  
### [5.3. Subscribe to Real-time Trade Details of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#53-subscribe-to-real-time-trade-detail-by-price-level)  
### [5.4. Subscribe to Real-time Market Depth of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#54-subscribe-to-real-time-order-book-depth-of-trading-instruments)  

## Contact the Author:
- **Telegram**: [https://t.me/qos_max](https://t.me/qos_max)  
- **Skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)
