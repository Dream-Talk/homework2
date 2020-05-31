package com.personal.socket;

/**
 * @author admin
 * @create 2020-05-31 17:24
 * @desc 储存网页测试
 **/
public class Test {
    @org.junit.Test
    public void getWebPage(){
        String url = "http://www.baidu.com/";
        String des = "src/main/resources/webPage.html";
        PageUtils.getWebPage(url,des);
    }
}
