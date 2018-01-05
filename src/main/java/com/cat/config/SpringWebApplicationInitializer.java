package com.cat.config;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.nio.charset.StandardCharsets;

public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private WebApplicationContext applicationContext;

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return this.applicationContext = super.createRootApplicationContext();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return dispatcherServlet;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true)};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        if (applicationContext != null && applicationContext instanceof AbstractApplicationContext) {
            ((AbstractApplicationContext) applicationContext).refresh();
            registration.setMultipartConfig(applicationContext.getBean(MultipartConfigElement.class));
        }
    }

}

