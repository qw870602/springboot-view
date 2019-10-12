package com.yuqiyu.lesson;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @author fengxiao
 * @date 2019/10/12 14:50
 * @description
 */
@Configuration //表明是配置类，没有这个注解不会被spring扫描
@EnableCaching  //等价于xml配置中的 <cache:annotation-driven/> ,主要用于创建代理拦截方法调用
public class RedisConfiguration extends CachingConfigurerSupport {

    /**
     * 等同于<bean id="cacheManager" class=""/>
     * @Bean标注的方法有参数，则会从spring容器中根据类型或者名称注入
     * */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1)); //失效时间1小时
        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory)).cacheDefaults(redisCacheConfiguration).build();
    }

    /**
     * 自定义生成key规则
     * */
    @Override
    public KeyGenerator keyGenerator() {
        return (o,method,objects)->{
            StringBuilder sb=new StringBuilder();
            sb.append(o.getClass().getName());
            sb.append(method.getName());
            for (Object object : objects) {
                sb.append(object.toString());
            }
            System.out.println("调用Redis缓存Key:"+sb.toString());
            return sb.toString();
        };
        //return keyGenerator;
    }
}
