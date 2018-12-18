package com.rock;

import com.rock.threadLocal.Filter.HttpFilter;
import com.rock.threadLocal.interceptor.HttpInterceptor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConcurrencyApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyApplication.class, args);
    }

    //配置过滤器
    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置自定义过滤器对象
        filterRegistrationBean.setFilter(new HttpFilter());
        //设置过滤路径
        filterRegistrationBean.addUrlPatterns("/threadLocal/*");
        return filterRegistrationBean;
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截路径
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
