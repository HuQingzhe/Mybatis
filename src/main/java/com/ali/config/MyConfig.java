package com.ali.config;

import com.ali.converter.LoginInterceptor;
import com.ali.factory.MyAdaptableJobFactory;
import com.ali.interceptor.DateConverter;
import com.ali.job.MyJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Objects;

/**
 * 创建MyConfig配置类
 * 对其使用@Configuration表示该类是一个配置类
 * 实现WebMvcConfigurer接口
 * 重写接口中的addFormatters方法
 * 通过FormatterRegistry的addConverter方法，将自定义的DateConverter日期转换类添加进去
 * 重写接口中的addInterceptors方法
 * 通过InterceptorRegistry的addInterceptor方法，将自定义的LoginInterceptor拦截器添加进去，并指明拦截的路径
 *
 * @author QingzheHu
 * @date 2021/7/4 19:09
 */

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/student/**");

    }
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(MyJob.class);
        return factory;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean
                                                                 jobDetailFactoryBean) {
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
        factory.setJobDetail(Objects.requireNonNull(jobDetailFactoryBean.getObject()));
        factory.setCronExpression("0/2 * * * * ?");
        return factory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTriggers(cronTriggerFactoryBean.getObject());
        factory.setJobFactory(myAdaptableJobFactory);
        return factory;
    }
}
