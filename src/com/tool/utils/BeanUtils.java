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

    /**
     * 列表拷贝
     * @param targetClass 目标对象的 class
     * @param sources 来源对象列表
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(final Class<T> targetClass, List<T> sources) {
        return copyList(targetClass, sources, null);
    }
    /**
     * 列表拷贝
     * @param targetClass 目标对象的 class
     * @param sources 来源对象列表
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(final Class<T> targetClass, List<T> sources, String... ignoreProperties) {
        List<T> targets = new ArrayList<>(sources.size());
        for (T source : sources) {
            try {
                T target = targetClass.getDeclaredConstructor().newInstance();
                copyProperties(source, target, ignoreProperties);
                targets.add(target);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }

       return targets;
    }

    /**
     * 对象拷贝
     * @param source 来源对象
     * @param target 目标对象
     */
    @Test
    public static <T> void copyProperties(final T source, T target) {
        copyProperties(source, target, null);
    }

    /**
     * 对象拷贝
     * @param source 拷贝来源对象
     * @param target 拷贝输出对象
     * @param ignoreProperties 忽略属性
     */
    @Test
    public static <T> void copyProperties(final T source, T target, String... ignoreProperties) {

        Map<String, T> sourceMap = toMap(source);
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
     * @param t 转化对象
     * @return 返回
     */
    @Test
    public static <T> Map<String, T> toMap(T t) {
        Map<String, T> editor = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {

                String propertyName = property.getName();

                Method getter = property.getReadMethod();

                T val = getter != null ? (T) getter.invoke(t) : null;

                editor.put(propertyName, val);
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        return editor;
    }


}
