**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/README.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/README_en.md)**
# QOS Market API (Quote Ocean System) - Welcome to Integrate
**The quote-ocean-system, abbreviated as "QOS Market API," includes real-time APIs for Hong Kong stocks, US stocks, A-shares, cryptocurrency real-time quotes, and digital currency real-time market data. It adopts REST API and WebSocket interfaces, making it very easy to integrate.**</br>
**Free and open-source stock API, Hong Kong stock API, US stock API, Shanghai-Shenzhen stock API, A-share API for real-time stock market data, cryptocurrency real-time quotes, and digital currency real-time market data.**</br>
**The QOS Market Quotation System currently provides real-time quotes, real-time K-lines, historical K-line data, etc., for all Hong Kong, US, and Shanghai-Shenzhen stocks, as well as cryptocurrencies (digital currencies). Welcome to try it for free and contact the author. Free trial integration is now available.**
- **Official Website**: [https://qos.hk](https://qos.hk)
- **Last Updated**: 2025-3-15
## Contact the Author:
- **Email**: support@qos.hk
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)
- **Telegram Group**: [https://t.me/stock_quote_api_hk_us_ashre_api](https://t.me/stock_quote_api_hk_us_ashre_api)
# [Quickly Experience QOS Quotation System with PostMan](https://github.com/qos-max/quote-ocean-system/blob/main/postman/README.md)
# Quick Start - Integration Guide
## 1. Register for a Key
Visit the official website to quickly register for a key:
- **Official Website**: [https://qos.hk](https://qos.hk)

After registering with your email, you will receive key-related information. **Please ensure to save it securely**, as it will be used in the following steps.
# Table of Contents
## 2. View [Some Enum Definitions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#2-some-enum-definitions)
2.1. [K-line Types](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#21-k-line-types)</br>
2.2. [Trade Directions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#22-trade-directions)</br>
## 3. View [Codes and Trading Hours for Various Trading Instruments](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#3-codes-and-trading-hours-for-various-trading-instruments)
## 4. Request [HTTP Interfaces](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#4-http-protocol-interface-definitions)
Add the key to **URL parameters** or **request headers** using the key field, then follow the parameters defined in each HTTP interface to retrieve data.</br>
4.1. [HTTP Protocol Integration Instructions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#40-http-protocol-integration-instructions)</br>  
4.2. [Get Basic Information of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#42-get-basic-information-of-trading-products)</br>  
4.3. [Get Real-time Market Snapshots of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#43-get-real-time-market-snapshots-of-trading-products)</br>  
4.4. [Get Real-time Latest Market Depth of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#44-get-real-time-latest-market-depth-of-trading-products)</br>  
4.5. [Get Real-time Latest Trade-by-Trade Details of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#45-get-real-time-latest-trade-by-trade-details-of-trading-products)</br>  
4.6. [Get K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#46-get-k-line-data-of-trading-products)</br>  
4.7. [Get Historical K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#47-get-historical-k-line-data-of-trading-products)</br>  
## 5. Subscribe or Request Real-time Data via [WebSocket Interfaces](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#5-websocket-protocol-interface-definitions)
Add the key to **URL parameters** or **request headers** using the key field, then establish a WebSocket connection, send the corresponding subscription commands, and maintain a heartbeat to receive real-time quotes.</br>
5.1. [WebSocket Protocol Integration Instructions](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#50-websocket-protocol-integration-instructions)</br>  
5.2. [Heartbeat](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#51-heartbeat)</br>  
5.3. [Subscribe to Real-time Snapshots of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#52-subscribe-to-real-time-snapshots-of-trading-products)</br>  
5.4. [Subscribe to Real-time Trade-by-Trade Details of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#53-subscribe-to-real-time-trade-by-trade-details-of-trading-products)</br>  
5.5. [Subscribe to Real-time Market Depth of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#54-subscribe-to-real-time-market-depth-of-trading-products)</br>  
5.6. [Subscribe to Real-time K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#55-subscribe-to-real-time-k-line-data-of-trading-products)</br>  
5.7. [Request Real-time Snapshots of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#56-request-real-time-snapshots-of-trading-products)</br>  
5.8. [Request Real-time Trade-by-Trade Details of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#57-request-real-time-trade-by-trade-details-of-trading-products)</br>  
5.9. [Request Real-time Market Depth of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#58-request-real-time-market-depth-of-trading-products)</br>  
5.10. [Request Real-time K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#59-request-real-time-k-line-data-of-trading-products)</br>  
5.11. [Request Historical K-line Data of Trading Products](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#510-request-historical-k-line-data-of-trading-products)</br>  
5.12. [Request Basic Information of Trading Instruments](https://github.com/qos-max/quote-ocean-system/blob/main/api_en.md#511-request-basic-information-of-trading-instruments)</br> 

## Contact the Author:
- **Email**: support@qos.hk
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)
- **Telegram Group**: [https://t.me/stock_quote_api_hk_us_ashre_api](https://t.me/stock_quote_api_hk_us_ashre_api)
