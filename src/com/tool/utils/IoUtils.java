package com.tool.utils;

import java.io.*;

/**
 * @author impactCn
 * @createTime 2021-04-01
 */
public class IoUtils {

    public static String read(String path) {

        File file = new File(path);
        StringBuilder contentBuilder = new StringBuilder();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            if (file.exists()) {
                fis = new FileInputStream(file);

                isr = new InputStreamReader(fis);
                br = new BufferedReader(isr);

                String content;

                while ((content = br.readLine()) != null) {
                    contentBuilder.append(content);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                isr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return contentBuilder.toString();
    }






}
