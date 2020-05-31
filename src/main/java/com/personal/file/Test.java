package com.personal.file;


import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 * @author admin
 * @create 2020-05-31 14:21
 * @desc
 **/
public class Test {
    /**
     * 测试获取文件绝对路径
     */
    @org.junit.Test
    public void  testPath(){

        try {
            File file = ResourceUtils.getFile("classpath:file/data.txt");
            System.out.println(FileUtils.getPath(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     *测试文件大小
     */
    @org.junit.Test
    public void testSize(){
        try {
            File file = ResourceUtils.getFile("classpath:file/data.txt");
            System.out.println(FileUtils.getSize(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取文本数据并写入到文本文件里,生成的des存在于maven 打包的路径当中。
     */
    @org.junit.Test
    public void testReadAndWriter(){
        try {
            File source = ResourceUtils.getFile("classpath:file/data.txt");
            File des = new File("src/main/resources/file/des.txt");
            FileUtils.readAndWriteByTxt(source,des);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 递归遍历目录并打印
     */
    @org.junit.Test
    public void testDir(){
        try {
            File source = ResourceUtils.getFile("classpath:file/data.txt");
            FileUtils.showDir(source.getParentFile().getParentFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
