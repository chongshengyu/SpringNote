package cn.ycs.A4BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Step5.BeanPostProcessor，Bean初始化前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Step8.BeanPostProcessor. Bean初始化后");
        if ("myService".equals(beanName)) {
            Object obj = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if ("doSome".equals(method.getName())) {
                                System.out.println("myService.doSome()开始执行时间:" + System.currentTimeMillis());
                                Object invoke = method.invoke(bean, args);
                                System.out.println("myService.doSome()结束执行时间:" + System.currentTimeMillis());
                                return invoke;
                            }
                            return method.invoke(bean, args);
                        }
                    });
            return obj;
        }
        return bean;
    }
}
