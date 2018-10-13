package cn.ycs.A3BeanScope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/ycs/A3BeanScope/appContext.xml");
        IService is = (IService) ac.getBean("myService");
        is.doSome();
    }
}
