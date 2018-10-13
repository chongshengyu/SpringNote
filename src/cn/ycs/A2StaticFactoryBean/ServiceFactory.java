package cn.ycs.A2StaticFactoryBean;

public class ServiceFactory {
    public static IService getService(){
        return new ServiceImpl();
    }
}
