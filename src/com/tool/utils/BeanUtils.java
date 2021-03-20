package com.tool.utils;


import com.tool.annotion.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Bean 工具类
 * @author impactCn
 * @createTime 2021-03-20
 */
public class BeanUtils {

    public static <T>List<T> copyList(T target, List<T> list) {

       return null;
    }


    @Test
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, null);
    }

    /**
     * 对象拷贝
     * @param source 拷贝来源对象
     * @param target 拷贝输出对象
     * @param ignoreProperties 忽略属性
     */
    @Test
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {

        Map<String, Object> sourceMap = toMap(source);
        List<String> ignorePropertiesList = new ArrayList<>();
        if (null != ignoreProperties) {
            ignorePropertiesList = Arrays.asList(ignoreProperties);
        }
        Class<?> editor = target.getClass();
        for (Field field : editor.getDeclaredFields()) {


            if (sourceMap.containsKey(field.getName())
                    && !ignorePropertiesList.contains(field.getName())) {

                field.setAccessible(true);
                try {
                    field.set(target, sourceMap.get(field.getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 对象转 map
     * @param object 转化对象
     * @return 返回
     */
    @Test
    public static Map<String, Object> toMap(Object object) {
        Map<String, Object> editor = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {

                String propertyName = property.getName();

                Method getter = property.getReadMethod();

                Object val = getter != null ? getter.invoke(object): null;

                editor.put(propertyName, val);

            }


        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        return editor;
    }


}
