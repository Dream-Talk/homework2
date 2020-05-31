package com.personal.date;

import java.util.Date;

/**
 * @author admin
 * @create 2020-05-31 13:34
 * @desc 工具类测试
 **/
public class Test {
    public static void main(String args[]){
        //1获取年份月份季度日期星期数 365中的哪一天
        Date date = new Date();
        System.out.println("年份"+DateUtils.getYear(date));
        System.out.println("月份"+DateUtils.getMonth(date));
        System.out.println("季度"+DateUtils.getQuarter(date));
        System.out.println("日期"+DateUtils.getDayOfMonth(date));
        System.out.println("星期数"+DateUtils.getWeekOfYear(date));
        System.out.println("365天中的天数"+DateUtils.getDayOfYear(date));
        //2 按指定要求格式化日期
        System.out.println("按照指定格式格式化日期"+DateUtils.formatDate("yyyy-MM-dd hh:mm:ss",date));
        //3 对日期进行相关操作，进行增减小时、月份、日期
        System.out.println("对日期进行加操作"+DateUtils.addOrMinHours(1,date));
        System.out.println("对日期进行减操作"+DateUtils.addOrMinHours(-1,date));
        System.out.println("对月份进行加操作"+DateUtils.addOrMinMonth(1,date));
        System.out.println("对月份进行加操作"+DateUtils.addOrMinMonth(-1,date));
        System.out.println("对日期进行加操作"+DateUtils.addOrMinDay(1,date));
        System.out.println("对日期进行加操作"+DateUtils.addOrMinDay(-1,date));
    }
}
