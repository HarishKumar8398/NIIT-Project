package com.niit.Middleware.config;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configurable
@EnableWebMvc
@ComponentScan(basePackages= {"com.niit"})
public class RestConfig extends  WebMvcConfigurerAdapter{
	@Bean(name="viewResolver")
	public ViewResolver getViewResolver() {
	InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/views");
	viewResolver.setSuffix(".jsp");
	
		
		return viewResolver;
	}
	
	}




