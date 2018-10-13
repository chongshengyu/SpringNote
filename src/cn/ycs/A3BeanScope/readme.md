# bean 的 scope属性
scope取值：
* singleton scope的默认值，单例模式，对象的创建时机是默认的（使用ApplicationContext时是在容器初始化时创建）
* prototype 原型模式，对象的创建时机不是在Spring容器初始化时，而是在代码中访问对象时创建
* request 对于每次HTTP请求，都会产生一个不同的Bean实例
* session 对于每个不同的HTTP session，都会产生一个不同的Bean实例

