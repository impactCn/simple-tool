package com.tool.utils;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * io 工具类
 * @author: impactCn
 * @createTime: 2020-12-24
 */
public class NioUtils {

    private static ClassLoader classLoader = NioUtils.class.getClassLoader();

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

    /**
     * 图片上传
     * @param fis 文件流
     * @param fileName 文件名
     * @param path 路径
     * @return 是否成功
     */
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



    public static String read(String path) {

        File file = new File(path);
        StringBuilder contentBuilder = new StringBuilder();
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                FileChannel channel = fis.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                int length;

                while ((length = channel.read(buffer)) != -1) {
                    buffer.clear();
                    byte[] bytes = buffer.array();
                    contentBuilder.append(new String(bytes, 0, length));

                }
                fis.close();
                channel.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return contentBuilder.toString();
    }

    public static OutputStream read(InputStream inputStream) {
        return null;
    }

    public static void transfer() {

    }

}
