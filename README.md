**[简体中文](https://github.com/qos-max/quote-ocean-system/blob/main/README.md) | [English](https://github.com/qos-max/quote-ocean-system/blob/main/README_en.md)**
# QOS行情API(Quote Ocean System)-欢迎对接使用
**quote-ocean-system系统简称"QOS行情API"，包括了港股实时API,美股实时API,A股实时API，加密货币实时报价API，数字币实时行情API,外汇API，贵金属API,黄金API，白银API，大宗商品API，能源API,采用REST API与websocket接口形式，非常容易接入。**</br>
**免费开源股票API、港股API、美股API、沪深股票API、A股API实时股票行情数据、加密货币实时报价数据，数字币实时行情,外汇行情数据，贵金属行情数据,黄金行情报价，白银行情报价，大宗商品行情数据，能源行情数据**</br>
**QOS行情报价系统目前提供：全港，全美，沪深等股票和加密货币（数字币），外汇，贵金属，大宗商品，黄金，白银，能源等的实时报价，实时K线，历史K线数据等，欢迎免费试用及联系作者,现提供免费试用对接。**
- **官网**：[https://qos.hk](https://qos.hk)
- **更新时间**：2025-6-3
## 联系作者：
- **Email**: support@qos.hk
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)
## [QOS行情API代码示例](https://github.com/qos-max/quote-ocean-system/tree/main/example)
## [QOS行情API-GO语言SDK](https://github.com/qos-max/qos-quote-api-go-sdk)
## [QOS行情API-Python语言SDK](https://github.com/qos-max/qos-quote-api-python-sdk)
## [使用PostMan快速体验QOS报价系统](https://github.com/qos-max/quote-ocean-system/blob/main/postman/README.md)
# 快速开始-接入指南
## 一、注册key
访问官网快速注册key:
- **官网**：[https://qos.hk](https://qos.hk)

使用邮箱注册后会得到key相关信息一定要**注意保存好**，下面的步骤中将要使用。
# 目录
## 二、查看[一些枚举定义](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#2一些枚举定义)
2.1、[K线类型](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#21k线类型)</br>
2.2、[交易方向](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#22交易方向)</br>
2.3、[美股交易时段类型](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#23美股交易时段类型)</br>
## 三、查看[各类交易品种的编码和交易时间](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#3各类交易品种的编码和交易时间)
## 四、请求[Http接口](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#4http协议接口定义)
把key加入到**URL参数中**或者**请求头中**使用key字段填充，然后根据http的各个接口定义的参数就可以获取数据了。</br>
4.1、[http协议接入说明](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#40http协议接入说明)</br>
4.2、[获取交易品种的基础信息](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#42获取交易品种的基础信息)</br>
4.3、[获取交易品种的实时行情快照](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#43获取交易品种的实时行情快照)</br>
4.4、[获取交易品种的实时最新盘口深度](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#44获取交易品种的实时最新盘口深度)</br>
4.5、[获取交易品种的实时最新逐笔成交明细](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#45获取交易品种的实时最新逐笔成交明细)</br>
4.6、[获取交易品种的K线](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#46获取交易品种的K线)</br>
4.7、[获取交易品种的K线-历史](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#47获取交易品种的K线历史)</br>
4.8、[获取市场交易日历](https://github.com/qos-max/qos-quote-api-stock-api/blob/main/api.md#48%E8%8E%B7%E5%8F%96%E5%B8%82%E5%9C%BA%E4%BA%A4%E6%98%93%E6%97%A5%E5%8E%86)</br>
4.9、[获取产品列表](https://github.com/qos-max/qos-quote-api-stock-api/blob/main/api.md#49%E8%8E%B7%E5%8F%96%E4%BA%A7%E5%93%81%E5%88%97%E8%A1%A8)</br>
## 五、通过[Webscoket订阅或者请求实时数据接口](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#5websocket协议接口定义)
把key加入到**URL参数中**或者**请求头中**使用key字段填充，然后建立websocket连接，发送相应的订阅命令，并保持心跳就可以得到实时报价了</br>
5.0、[websocket协议接入说明](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#50websocket协议接入说明)</br>
5.1、[心跳](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#51心跳)</br>
5.2、[订阅交易品种的实时快照](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#52订阅交易品种的实时快照)</br>
5.3、[订阅交易品种的实时逐口成交明细](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#53订阅交易品种的实时逐口成交明细)</br>
5.4、[订阅交易品种的实时盘口](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#54订阅交易品种的实时盘口)</br>
5.5、[订阅交易品种的K线](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#55订阅交易品种的实时k线)</br>
5.6、[请求交易品种的实时快照](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#56请求交易品种的实时快照)</br>
5.7、[请求交易品种的实时逐口成交明细](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#57请求交易品种的实时逐口成交明细)</br>
5.8、[请求交易品种的实时盘口](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#58请求交易品种的实时盘口)</br>
5.9、[请求交易品种的K线](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#59请求交易品种的实时k线)</br>
5.10、[请求交易品种的K线历史](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#510请求交易品种的k线历史)</br>
5.11、[请求交易品种的基础信息](https://github.com/qos-max/quote-ocean-system/blob/main/api.md#511请求交易品种的基础信息)</br>

## 联系作者：
- **Email**: support@qos.hk
- **Telegram**: [https://t.me/stock_quote_api](https://t.me/stock_quote_api)
