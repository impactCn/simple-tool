package com.tool.core;

import com.tool.utils.IOUtils;
import jdk.jfr.StackTrace;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.*;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: impactCn
 * @createTime: 2020-12-23
 */
public  class AbstractService {

    private final String SCAN_PACKAGE = "com.tool.utils";


//    abstract void register();

    static {

    }

    private void globalRegister(String scanPackage) {

    }

    private void scanner() {

    }

    private static void findClassesByFile(String pkgName, String pkgPath, Set<Class<?>> classes) {

    }

    private static Class<?> loadClass(String fullClzName) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(fullClzName);
        } catch (ClassNotFoundException ignored) {
        }
        return null;
    }

    public static void main(String[] args) {



        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.err.println(stackTraceElement.getMethodName());
        }

    }





}
