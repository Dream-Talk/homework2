package com.personal.socket;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author admin
 * @create 2020-05-31 17:10
 * @desc 网页工具类
 **/
public class PageUtils {

    public static void getWebPage(String url,String des) {
        InputStream inputStream=null;//接收字节输入流
        InputStreamReader inputStreamReader = null;//将字节输入流转换成字符输入流
        BufferedReader bufferedReader = null;//为字符输入流加缓冲
        FileOutputStream fileOutputStream = null;//字节输出流
        OutputStreamWriter outputStreamWriter = null;//将字节输出流转换成字符输出流
        try {
            URL webPage = new URL(url);
            inputStream = webPage.openStream();
            inputStreamReader = new InputStreamReader(inputStream, "gb2312");
            bufferedReader = new BufferedReader(inputStreamReader);
            String s;
            File dest = new File(des);
            fileOutputStream = new FileOutputStream(dest);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gb2312");
            while ((s = bufferedReader.readLine()) != null) {
                outputStreamWriter.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
                fileOutputStream.close();
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
