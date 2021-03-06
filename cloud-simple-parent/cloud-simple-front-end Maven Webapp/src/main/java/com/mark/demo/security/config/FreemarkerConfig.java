package com.mark.demo.security.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
@Configuration
@EnableConfigurationProperties(FreeMarkerProperties.class)
public class FreemarkerConfig {
	private final FreeMarkerProperties properties;
	
	public FreemarkerConfig(ApplicationContext applicationContext,
			FreeMarkerProperties properties) {
		this.properties = properties;
	}
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPaths("classpath:/templates/","/WEB-INF/ftl/");
		configurer.setDefaultEncoding("UTF-8");
		configurer.setPreferFileSystemAccess(properties.isPreferFileSystemAccess());
		Properties settings = new Properties();
		settings.putAll(this.properties.getSettings());
		configurer.setFreemarkerSettings(settings);
		return configurer;
	}
}
