package cn.ycs.A1DynamicFactoryBean;

public class ServiceFactory {
    public IService getService(){
        return new ServiceImpl();
    }
}
