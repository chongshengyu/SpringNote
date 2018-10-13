# Spring Bean 生命周期
Bean从创建到销毁的11个可控点，按顺序依次为：

* 调用无参构造，创建实例对象
* 调用参数setter，为属性注入值
* 若Bean实现了BeanNameAware接口，则会执行接口方法setBeanName(String beanId)，使Bean类可以获取其在容器中的id名称
* 若Bean实现了BeanFactoryAware接口，则会执行接口方法setBeanFactory(BeanFactory beanFactory)，使Bean类可以获取到BeanFactory对象
* 若定义并注册了Bean后处理器BeanPostProcessor，则执行接口方法postProcessBeforeInitialization()
* 若Bean实现了InitializingBean接口，则执行接口方法afterPropertiesSet()。该方法在Bean的所有属性setter方法执行完毕后执行，是Bean初始化结束的标志。
* 若设置了init-method方法，则执行
* 若定义并注册了Bean后处理器BeanPostProcessor，则执行接口方法postProcessAfterInitialization()
* 执行业务方法
* 若Bean实现了DisposableBean接口，则在容器close前执行接口方法destroy()
* 若设置了destroy-method，则在容器close前执行对应方法。