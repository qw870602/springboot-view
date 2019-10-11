package com.yuqiyu.lesson;

import com.yuqiyu.lesson.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author fengxiao
 * @date 2019/10/11 11:06
 * @description
 */
@Configuration
@ServletComponentScan
public class servletConfiguration{

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//        return new ServletRegistrationBean(new TestServlet(),"/test");
//    }

}
