package com.yuqiyu.lesson;


import com.yuqiyu.lesson.service.UserService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/18
 * Time：22:55
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    //完成自定义认证实体注入
//    @Bean
//    UserDetailsService userService2()
//    {
//        return new UserService2();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()//所有请求必须登陆后访问
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .permitAll()//登录界面，错误界面可以直接访问
//                .and()
//                .logout()
//                .permitAll();//注销请求可直接访问
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance(); //密码不加密
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService2()).passwordEncoder(passwordEncoder());
//    }
}
