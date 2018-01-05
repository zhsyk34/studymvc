package com.cat.spi;

import java.util.ServiceLoader;

/**
 * spring-mvc包 META-INF/service/javax.servlet.ServletContainerInitializer
 * 内容为 {@link org.springframework.web.SpringServletContainerInitializer}
 * <p>
 * 因为这个类@HandlesTypes注解的是WebApplicationInitializer.class
 * Servlet3.0容器会自动的扫描classpath下面WebApplicationInitializer接口的实现类
 * 并提供给SpringServletContainerInitializer的onStartup()方法
 */
public class UserProviderFactory {

    public static void main(String[] args) {
        ServiceLoader<UserProvider> serviceLoader = ServiceLoader.load(UserProvider.class);
        for (UserProvider userProvider : serviceLoader) {
            System.out.println(userProvider.provide());
        }
    }
}
