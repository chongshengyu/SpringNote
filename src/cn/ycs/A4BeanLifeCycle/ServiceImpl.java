package cn.ycs.A4BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class ServiceImpl implements IService, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String aDao;
    private String bDao;

    public ServiceImpl(){
        System.out.println("Step1.无参构造");
    }

    public void setaDao(String aDao) {
        this.aDao = aDao;
        System.out.println("Step2.执行setter");
    }

    public void setbDao(String bDao) {
        this.bDao = bDao;
        System.out.println("Step2.执行setter");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Step3.BeanNameAware接口，获取Bean的id属性");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Step4.BeanFactoryAware接口，获取BeanFactory容器");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Step6.InitializingBean接口，afterPropertiesSet()方法");
    }

    public void setUp(){
        System.out.println("Step7.init-method方法");
    }

    @Override
    public void doSome() {
        System.out.println("Step9.业务方法doSome");
    }

    @Override
    public void doOther() {
        System.out.println("do other");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Step10.DisposableBean接口，容器关闭时，Bean销毁之前执行destroy()方法");
    }

    public void tearDown(){
        System.out.println("Step11.容器关闭时，Bean销毁之前执行destroy-method.");
    }
}
