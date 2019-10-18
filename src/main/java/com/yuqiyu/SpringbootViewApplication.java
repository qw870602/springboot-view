package com.yuqiyu;

import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//关闭SpringSecurity(pom.xml中引入就会自动配置登录验证页面)
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringbootViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootViewApplication.class, args);
    }

}
