package cn.ycs.A4BeanLifeCycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/ycs/A4BeanLifeCycle/appContext.xml");
        IService is = (IService) ac.getBean("myService");
        is.doSome();
        is.doSome();
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
