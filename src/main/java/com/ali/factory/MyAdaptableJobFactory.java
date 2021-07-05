package com.ali.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author QingzheHu
 * @date 2021/7/5 8:23
 */


@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {
    @Resource
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj = super.createJobInstance(bundle);
        this.autowireCapableBeanFactory.autowireBean(obj);
        return obj;
    }
}
