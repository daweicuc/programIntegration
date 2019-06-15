package cuc.dawei.springbootprogramintegration.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName MyCacheConfig
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/15 11:36
 * @Version 1.0
 */
@Configuration
public class MyCacheConfig {
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+"["+Arrays.asList(params).toString()+"]";
            }
        };
    }
}
