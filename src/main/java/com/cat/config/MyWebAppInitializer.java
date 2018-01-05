package com.cat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html
 * <p>
 * TODO @EnableWebMvc ???  @EnableTransactionManagement
 * <p>
 * maven war plugin : <failOnMissingWebXml>false</failOnMissingWebXml>
 */
public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(AppConfig.class);
//        rootContext.refresh();

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(DispatcherConfig.class);//@EnableWebMvc+@Configuration

        // Register and map the dispatcher servlet
        DispatcherServlet servlet = new DispatcherServlet(dispatcherContext);
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DispatcherServlet.class.getSimpleName(), servlet);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME, servlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}

@Configuration
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}