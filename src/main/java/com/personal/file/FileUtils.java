package com.personal.file;

import java.io.*;

/**
 * @author admin
 * @create 2020-05-31 12:38
 * @desc 文件file，对文件操作，查看路径、大小写和目录，递归遍历
 **/
public class FileUtils {
    /**
     * 获取文件绝对路径
     * @param file
     * @return5ux
     */
    public static String getPath(File file){
        String filePath = "";
        if(file!=null && file.exists() ){
           filePath = file.getAbsolutePath();
        }
        return  filePath;
    }
    public static long getSize(File file){
        long size = -1;
        if (file.exists() && file.isFile()){
             size = file.length();
        }
       return size;
    }

    /**
     * 递归方式遍历目录
     * @param dir
     */
    public static void showDir(File dir) {
        if(dir.exists()){
            //抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件和目录。
            File[] files = dir.listFiles();
            if(null!=files){
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        showDir(files[i]);
                    } else {
                        System.out.println(files[i]);
                    }
                }
            }
        }else{
            System.out.println("文件不存在！");
        }
    }

    /**
     * 读取数据并写入文件当中
     * @param source 源数据File对象
     * @param des     目标数据File对象
     */
    public static void readAndWriteByTxt(File source, File des){
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            if(source!=null && source.exists()){
                 reader = new BufferedReader(new FileReader(source));
                 writer = new BufferedWriter(new FileWriter(des));
                 //读取数据 一次读取一行数据
                String str = null;
                while ((str = reader.readLine()) != null) {
                    //写入相关文件
                    writer.write(str);
                    writer.newLine();
                    //清除缓存向文件写入数据
                    writer.flush();
                }
            }
        } catch (Exception e){
           e.printStackTrace();
        }
        finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
