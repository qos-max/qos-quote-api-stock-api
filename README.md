**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/README.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/README_en.md)**
# QOS行情API(Quote Ocean System)-欢迎对接使用
**quote-ocean-system系统简称"qos行情api"，包括了港股实时API,美股实时API,A股实时API,采用REST API与websocket接口形式，非常容易接入。免费开源股票API、港股API、美股API、沪深股票API、A股API实时股票行情数据.QOS行情报价系统目前提供：全港，全美，沪深等股票的实时报价，实时K线，历史K线数据等，欢迎免费试用及联系作者,现提供免费试用对接。**

- **作者**：Max
- **更新时间**：2024-12-25
- **http基础URL**：`https://api.qos.hk`
- **websocketURL**：`wss://api.qos.hk/ws`
- **认证方式**：请求头添加key字段
- **错误码说明**：msg字段返回"OK"视为成功，非"OK"则是具体的错误描述
- **格式**：所有请求和响应均为 JSON 格式。
- **请求方式**：所有http请求统一为POST方法。

## [使用PostMan快速体验QOS报价系统](https://github.com/qos-max/quote-ocean-system/blob/main/postman/README.md)

## 联系作者：
- **telegram**: [https://t.me/qos_max](https://t.me/qos_max)
- **skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)
# 目录
## [1、免费快速开始-接入指南](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#1%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B-%E6%8E%A5%E5%85%A5%E6%8C%87%E5%8D%97)
### [1.1、注册key](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#11%E6%B3%A8%E5%86%8Ckey)
### [1.2、请求Http接口](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#12%E8%AF%B7%E6%B1%82http%E6%8E%A5%E5%8F%A3)
### [1.3、订阅webscoket实时数据接口](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#13%E8%AE%A2%E9%98%85webscoket%E5%AE%9E%E6%97%B6%E6%95%B0%E6%8D%AE%E6%8E%A5%E5%8F%A3)
## [2、一些枚举定义](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#2%E4%B8%80%E4%BA%9B%E6%9E%9A%E4%B8%BE%E5%AE%9A%E4%B9%89)
### [2.1、K线类型](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#21k%E7%BA%BF%E7%B1%BB%E5%9E%8B)
### [2.2、交易方向](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#22%E4%BA%A4%E6%98%93%E6%96%B9%E5%90%91)
## [3、各类交易品种的编码和交易时间的](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#3%E5%90%84%E7%B1%BB%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E7%BC%96%E7%A0%81%E5%92%8C%E4%BA%A4%E6%98%93%E6%97%B6%E9%97%B4)
## [4、http协议接口定义](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#4http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%8F%A3%E5%AE%9A%E4%B9%89)
### [4.0、http协议接入说明](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#40http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)
#### [4.0.1、请求头](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#40http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)
#### [4.0.2、限制说明](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#40http%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)
### [4.1、注册一个新的Key](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#41%E6%B3%A8%E5%86%8C%E4%B8%80%E4%B8%AA%E6%96%B0%E7%9A%84key)
### [4.2、获取交易品种的基础信息](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#42%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%9F%BA%E7%A1%80%E4%BF%A1%E6%81%AF)
### [4.3、获取交易品种的实时行情快照](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#43%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E8%A1%8C%E6%83%85%E5%BF%AB%E7%85%A7)
### [4.4、获取交易品种的实时最新盘口深度](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#44%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E6%9C%80%E6%96%B0%E7%9B%98%E5%8F%A3%E6%B7%B1%E5%BA%A6)
### [4.5、获取交易品种的实时最新逐笔成交明细](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#45%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E6%9C%80%E6%96%B0%E9%80%90%E7%AC%94%E6%88%90%E4%BA%A4%E6%98%8E%E7%BB%86)
### [4.6、获取交易品种的K线](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#46%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84k%E7%BA%BF)
### [4.7、获取交易品种的K线-历史](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#47%E8%8E%B7%E5%8F%96%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84k%E7%BA%BF-%E5%8E%86%E5%8F%B2)
## [5、websocket协议接口定义](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#5websocket%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%8F%A3%E5%AE%9A%E4%B9%89)
### [5.0、websocket协议接入说明](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#50websocket%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)
#### [5.0.1、请求头](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#50websocket%E5%8D%8F%E8%AE%AE%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)
#### [5.0.2、限制说明](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#502%E9%99%90%E5%88%B6%E8%AF%B4%E6%98%8E)
### [5.1、心跳](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#51%E5%BF%83%E8%B7%B3)
### [5.2、订阅交易品种的实时快照](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#52%E8%AE%A2%E9%98%85%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E5%BF%AB%E7%85%A7)
### [5.3、订阅交易品种的实时逐口成交明细](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#53%E8%AE%A2%E9%98%85%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E9%80%90%E5%8F%A3%E6%88%90%E4%BA%A4%E6%98%8E%E7%BB%86)
### [5.4、订阅交易品种的实时盘口](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#54%E8%AE%A2%E9%98%85%E4%BA%A4%E6%98%93%E5%93%81%E7%A7%8D%E7%9A%84%E5%AE%9E%E6%97%B6%E7%9B%98%E5%8F%A3)
## 联系作者：
- **telegram**: [https://t.me/qos_max](https://t.me/qos_max)
- **skype**: [https://join.skype.com/invite/wWXtMxKNFOYE](https://join.skype.com/invite/wWXtMxKNFOYE)
