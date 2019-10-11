package com.yuqiyu.lesson;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author fengxiao
 * @date 2019/10/11 10:26
 * @description
 */
@Configuration
public class ResourceConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/yuqiyu/9/resource/**").addResourceLocations("classpath:/static/");
    }
}
