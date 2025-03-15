**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/README.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/README_en.md)**
# QOS行情API(Quote Ocean System)-欢迎对接使用
**quote-ocean-system系统简称"QOS行情API"，包括了港股实时API,美股实时API,A股实时API，加密货币实时报价API，数字币实时行情API,采用REST API与websocket接口形式，非常容易接入。**</br>
**免费开源股票API、港股API、美股API、沪深股票API、A股API实时股票行情数据、加密货币实时报价数据，数字币实时行情。**</br>
**QOS行情报价系统目前提供：全港，全美，沪深等股票和加密货币（数字币）的实时报价，实时K线，历史K线数据等，欢迎免费试用及联系作者,现提供免费试用对接。**
- **官网**：[https://qos.hk](https://qos.hk)
- **更新时间**：2025-3-15
## 联系作者：
- **Email**: support@qos.hk
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)
- **Telegram group**: [https://t.me/stock_quote_api_hk_us_ashre_api](https://t.me/stock_quote_api_hk_us_ashre_api)

## [使用PostMan快速体验QOS报价系统](https://github.com/qos-max/quote-ocean-system/blob/main/postman/README.md)


## 1、快速开始-接入指南
### 1.1、注册key
访问官网快速注册key:
- **官网**：[https://qos.hk](https://qos.hk)

使用邮箱注册后会得到key相关信息一定要**注意保存好**，下面的步骤中将要使用。
# 目录
### 1.2、查看[一些枚举定义](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#2一些枚举定义)
1.2.1、[K线类型](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#21k线类型)</br>
1.2.2、[交易方向](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#22交易方向)</br>
### 1.3、查看[各类交易品种的编码和交易时间](#3各类交易品种的编码和交易时间)
### 1.4、请求[Http接口](#4http协议接口定义)
把key加入到**URL参数中**或者**请求头中**使用key字段填充，然后根据http的各个接口定义的参数就可以获取数据了。</br>
1.4.1、[http协议接入说明](#40http协议接入说明)</br>
1.4.2、[获取交易品种的基础信息](#42获取交易品种的基础信息)</br>
1.4.3、[获取交易品种的实时行情快照](#43获取交易品种的实时行情快照)</br>
1.4.4、[获取交易品种的实时最新盘口深度](#44获取交易品种的实时最新盘口深度)</br>
1.4.5、[获取交易品种的实时最新逐笔成交明细](#45获取交易品种的实时最新逐笔成交明细)</br>
1.4.6、[获取交易品种的K线](#46获取交易品种的K线)</br>
1.4.7、[获取交易品种的K线-历史](#47获取交易品种的K线历史)</br>
### 1.5、通过[Webscoket订阅或者请求实时数据接口](#5websocket协议接口定义)
把key加入到**URL参数中**或者**请求头中**使用key字段填充，然后建立websocket连接，发送相应的订阅命令，并保持心跳就可以得到实时报价了</br>
1.5.1、[websocket协议接入说明](#50websocket协议接入说明)</br>
1.5.2、[心跳](#51心跳)</br>
1.5.3、[订阅交易品种的实时快照](#52订阅交易品种的实时快照)</br>
1.5.4、[订阅交易品种的实时逐口成交明细](#53订阅交易品种的实时逐口成交明细)</br>
1.5.5、[订阅交易品种的实时盘口](#54订阅交易品种的实时盘口)</br>
1.5.6、[订阅交易品种的K线](#55订阅交易品种的实时k线)</br>
1.5.7、[请求交易品种的实时快照](#56请求交易品种的实时快照)</br>
1.5.8、[请求交易品种的实时逐口成交明细](#57请求交易品种的实时逐口成交明细)</br>
1.5.9、[请求交易品种的实时盘口](#58请求交易品种的实时盘口)</br>
1.5.10、[请求交易品种的K线](#59请求交易品种的实时k线)</br>
1.5.11、[请求交易品种的K线历史](#510请求交易品种的k线历史)</br>

## 联系作者：
- **Email**: support@qos.hk
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)
- **Telegram group**: [https://t.me/stock_quote_api_hk_us_ashre_api](https://t.me/stock_quote_api_hk_us_ashre_api)
