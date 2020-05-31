package com.personal.regex;

/**
 * @author admin
 * @create 2020-05-31 20:01
 * @des 正则测试类
 **/
public class Test {
    public static void main(String args[]){
        String str = "中华人民共和国山东省潍坊市花花乡区香香镇窊流路潘家庄村4号楼";
      System.out.println(RegexUtils.getRegexStr(str));
    }
}
