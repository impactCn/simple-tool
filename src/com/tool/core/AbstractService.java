package com.tool.core;


import java.util.Set;

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
