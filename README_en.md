# QOS Quote Ocean System - Welcome to Connect and Use
The Quote Ocean System currently provides: real-time quotes, real-time K-line, historical K-line data for stocks in Hong Kong, the U.S., and Shanghai-Shenzhen. Free trials and integration support are available. Feel free to contact the author.

- **Version**: V1.0.1  
- **Author**: Max  
- **Last Updated**: 2024-12-24  
- **HTTP Base URL**: `https://api.qos.hk`  
- **WebSocket URL**: `wss://api.qos.hk/ws`  
- **Authentication Method**: Add the `key` field in the request header  
- **Error Code Description**: A `msg` field returning "OK" indicates success, while any other value provides specific error details  
- **Format**: All requests and responses are in JSON format  
- **Request Method**: All HTTP requests are unified as POST  

## Contact the Author:
- **Telegram**: [https://t.me/qos_max](https://t.me/qos_max)  
- **Skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)  

# Table of Contents

## [1. Free Quick Start - Integration Guide](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#1%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B-%E6%8E%A5%E5%85%A5%E6%8C%87%E5%8D%97)
### [1.1. Register a Key](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#11%E6%B3%A8%E5%86%8Ckey)  
### [1.2. Request HTTP APIs](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#12%E8%AF%B7%E6%B1%82http%E6%8E%A5%E5%8F%A3)  
### [1.3. Subscribe to WebSocket Real-time Data Interfaces](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#13%E8%AE%A2%E9%98%85webscoket%E5%AE%9E%E6%97%B6%E6%95%B0%E6%8D%AE%E6%8E%A5%E5%8F%A3)  

## [2. Enumerations Definitions](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#2%E4%B8%80%E4%BA%9B%E6%9E%9A%E4%B8%BE%E5%AE%9A%E4%B9%89)  
### [2.1. K-line Types](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#21k%E7%BA%BF%E7%B1%BB%E5%9E%8B)  
### [2.2. Trade Directions](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#22%E4%BA%A4%E6%98%93%E6%96%B9%E5%90%91)  

## [3. Codes and Trading Times for Various Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#3%E5%90%84%E7%B1%BB%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E7%BC%96%E7%A0%81%E5%92%8C%E4%BA%A4%E6%98%93%E6%97%B6%E9%97%B4)  

## [4. HTTP Protocol API Definitions](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#4http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%8F%A3%E5%AE%9A%E4%B9%89)  
### [4.0. HTTP Protocol Integration Description](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#40http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)  
#### [4.0.1. Request Header](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#40http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)  
#### [4.0.2. Limitation Description](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#40http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)  
### [4.1. Register a New Key](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#41%E6%B3%A8%E5%86%8C%E4%B8%80%E4%B8%AA%E6%96%B0%E7%9A%84key)  
### [4.2. Get Basic Information of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#42%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%9F%BA%E7%A1%80%E4%BF%A1%E6%81%AF)  
### [4.3. Get Real-time Market Snapshots of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#43%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E8%A1%8C%E6%83%85%E5%BF%AB%E7%85%A7)  
### [4.4. Get Real-time Latest Depths of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#44%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E6%9C%80%E6%96%B0%E7%9B%98%E5%8F%A3%E6%B7%B1%E5%BA%A6)  
### [4.5. Get Real-time Latest Trade Details of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#45%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E6%9C%80%E6%96%B0%E9%80%90%E7%AC%94%E6%88%90%E4%BA%A4%E6%98%8E%E7%BB%86)  
### [4.6. Get K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#46%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84k%E7%BA%BF)  
### [4.7. Get Historical K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#47%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84k%E7%BA%BF-%E5%8E%86%E5%8F%B2)  

## [5. WebSocket Protocol API Definitions](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#5websocket%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%8F%A3%E5%AE%9A%E4%B9%89)  
### [5.0. WebSocket Protocol Integration Description](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#50websocket%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)  
#### [5.0.1. Request Header](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#50websocket%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)  
#### [5.0.2. Limitation Description](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#502%E9%99%90%E5%88%B6%E8%AF%B4%E6%98%8E)  
### [5.1. Heartbeat](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#51%E5%BF%83%E8%B7%B3)  
### [5.2. Subscribe to Real-time Snapshots of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#52%E8%AE%A2%E9%98%85%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E5%BF%AB%E7%85%A7)  
### [5.3. Subscribe to Real-time Trade Details of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#53%E8%AE%A2%E9%98%85%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E9%80%90%E5%8F%A3%E6%88%90%E4%BA%A4%E6%98%8E%E7%BB%86)  
### [5.4. Subscribe to Real-time Market Depth of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#54%E8%AE%A2%E9%98%85%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E7%9B%98%E5%8F%A3)  

## Contact the Author:
- **Telegram**: [https://t.me/qos_max](https://t.me/qos_max)  
- **Skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)
