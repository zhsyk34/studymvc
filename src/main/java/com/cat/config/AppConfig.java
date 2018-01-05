package com.cat.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static org.springframework.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

@Configuration
@PropertySource(CLASSPATH_URL_PREFIX + "apk.properties")
@Data
public class AppConfig {
    @Value("${dir}")
    public String dir;
    @Value("${suffix}")
    public String suffix;
}
