package com.tool.utils;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: impactCn
 * @createTime: 2020-12-24
 */
public class IoUtils {

    private static ClassLoader classLoader = IoUtils.class.getClassLoader();

    private static final char SLASH = '/';

    public static List<String> getFileNames(String referencePath) {

        URL url = classLoader.getResource(referencePath.replaceAll("\\.", "/"));

        File file = new File(url.getFile());
        List<String> clazzNames = new ArrayList<>();

        if (file.listFiles() == null) {
            return clazzNames;
        }
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                getFileNames(referencePath + "." + f.getName());
            } else {
                clazzNames.add(referencePath + "." + f.getName());
            }
        }
        return clazzNames;
    }

    public static boolean upload(FileInputStream fis, String fileName, String path) {

        if (path.charAt(path.length() - 1) != SLASH) {
            path = path + SLASH;
        }
        mkdir(path);

        String url = path + fileName;
        try {
            FileOutputStream fos = new FileOutputStream(url);
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            inChannel.transferTo(0, inChannel.size(), outChannel);
            fos.close();
            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean mkdir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return file.mkdir();
        } else {
            return false;
        }
    }


    public static void download(String url) {
    }

    public static OutputStream read(String url) {
        return null;
    }

    public static OutputStream read(InputStream inputStream) {
        return null;
    }

    public static void transfer() {

    }

}
