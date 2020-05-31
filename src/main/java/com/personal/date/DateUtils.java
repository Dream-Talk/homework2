package com.personal.date;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author admin
 * @create 2020-05-31 12:38
 * @desc java8时间类的使用方法
 **/
public class DateUtils {
    /**
     * date类型转换为LocalDateTime类型
     * @return  LocalDateTime
     */
private static LocalDateTime toLocalDate(Date date){
    Instant instant = date.toInstant();
    ZoneId zone = ZoneId.systemDefault();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    return localDateTime;
}

    /**
     * 获取年方法
     * @param date
     * @return 年份整数
     */
    public static int getYear(Date date){
   LocalDateTime localDateTime = DateUtils.toLocalDate(date);
   return localDateTime.getYear();
    }
    /**
     * 获取月方法
     * @param date
     * @return 月份整数
     */
    public static int getMonth(Date date){
        LocalDateTime localDateTime = DateUtils.toLocalDate(date);
        return localDateTime.getMonthValue();
    }

    /**
     * 获取季度 1-3月为第一个季度
     * @param date
     * @return
     */
    public static int getQuarter(Date date){
        LocalDateTime localDateTime = DateUtils.toLocalDate(date);
        int month = localDateTime.getMonthValue();
        int quarter = -1;
        if(month>=6){
          quarter = month>9?4:3;
        }else{
            quarter = month>3?2:1;
        }
       return quarter;
    }

    /**
     * 获取每月中的日期数
     * @param date
     * @return int月份中日期数
     */
    public static int getDayOfMonth(Date date){
        LocalDateTime localDateTime = DateUtils.toLocalDate(date);
       return localDateTime.getDayOfMonth();
    }

    /**
     * 一年当中的星期数获取星期数本星期未过完星期数+1
     * @param date
     * @return 星期数
     */
    public static int getWeekOfYear(Date date){
        LocalDateTime localDateTime = DateUtils.toLocalDate(date);
        int days = localDateTime.getDayOfYear();
        int weeks = days/7;
        weeks = (days%7==0)?weeks++:weeks;
        return weeks;
    }

    /**
     * 获取年(365天)中的天数
     * @param date
     * @return 天数
     */
    public static int getDayOfYear(Date date){
        LocalDateTime localDateTime = DateUtils.toLocalDate(date);
        return localDateTime.getDayOfYear();
    }

    /**
     *
     * @param str 传入时间字符串
     * @param date
     * @return 按照指定格式转换的localDateTime对象
     */
    public static String formatDate(String str,Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(str);
        LocalDateTime localDateTime = DateUtils.toLocalDate(date);
        return  formatter.format(localDateTime);
    }

    /**
     * 传入一个日期，并且传入要增加或减少的小时数
     * @return
     */
    public static String addOrMinHours(int hours,Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime localDateTime =DateUtils.toLocalDate(date);
        localDateTime = localDateTime.plusHours(hours);
        return formatter.format(localDateTime);
    }
    /**
     * 传入一个日期，并且传入要增加或减少的月个数
     * @return
     */
    public static String addOrMinMonth(int month,Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime localDateTime =DateUtils.toLocalDate(date);
        localDateTime = localDateTime.plusMonths(month);
        return formatter.format(localDateTime);
    }

    /**
     *
     * @param day 准备增加的天数
     * @param date
     * @return
     */
    public static String addOrMinDay(int day,Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime localDateTime =DateUtils.toLocalDate(date);
        localDateTime = localDateTime.plusDays(day);
        return formatter.format(localDateTime);
    }







}
