package com.ali.interceptor;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * @author QingzheHu
 * @date 2021/7/4 19:01
 * <p>
 * 创建日期转换类
 */


public class DateConverter implements Converter<String, Date> {

    /**
     * 重写Converter接口中的convert方法
     * 使用patterns字符数组枚举出可以转换的日期格式
     * 使用lang3增强包中的parseDate方法
     * 将接收到的日期和枚举数组作为参数
     */

    @Override
    public Date convert(String s) {
        String[] patterns = new String[]{
                "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd hh:mm:ss",
                "MM-dd-yyyy", "dd-MM-yyyy"};
        try {
            return DateUtils.parseDate(s, patterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Date, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
