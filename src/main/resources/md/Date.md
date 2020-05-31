Date类：
1.毫秒值特点
毫秒的0点:公元1970年1月1日,午夜0:00:00 毫秒的值是0
1000毫秒 = 1秒
时间和日期的计算都依赖于毫秒值
System.currentTimeMillis();方法返回当前毫秒值
2.Date类空参构造方法返回值为当前系统时间
3.Date(long date) long类型的毫秒值 将毫秒值转换为日期对象
4.Date类getTime方法返回当前毫秒值
5.Date类setTime方法与long类型构造方法类似
 
DateFormat类:
特点：
　　是一个抽象类,需要调用子类SimpleDateFormat实现相应功能
1.字母所表示的字段含义（常用）

字段
含义
yyyy	表示年份
MM	表示月份
dd	表示一个月中的天数
HH	表示十二小时格式
hh	表示二十四小时格式
mm	表示一小时中的分钟数
ss	表示秒数
2.调用simpleDateFormat类实现日期格式化
　　SimpleDateFormat sfg = new SimpleDateFormt("YYYY年MM月dd日HH点mm分ss秒");
3.SimpleDateFormat类format方法传递日期格式
　　String date = sdf.format(new Date());

java8当中的四个类  LocalDate  localDateTime  LocalTime


　　　　Java 8中的 LocalDate 用于表示当天日期。和java.util.Date不同，它只有日期，不包含时间。

public static void main(String[] args) {
　　LocalDate date = LocalDate.now();
　　System.out.println("当前日期=" + date);
}
 

　　示例2： 构造指定日期

　　　　调用工厂方法LocalDate.of()创建任意日期， 该方法需要传入年、月、日做参数，返回对应的LocalDate实例。这个方法的好处是没再犯老API的设计错误，比如年度起始于1900，月份是从0开始等等

public static void main(String[] args) {
    LocalDate date = LocalDate.of(2000, 1, 1);
    System.out.println("千禧年=" + date);
}
 

　　示例3： 获取年月日信息

public static void main(String[] args) {
    LocalDate date = LocalDate.now();
    System.out.printf("年=%d， 月=%d， 日=%d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
}
 

　　示例4： 比较两个日期是否相等

public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    LocalDate date = LocalDate.of(2018, 9, 24);
    System.out.println("日期是否相等=" + now.equals(date));
}
 

三、时间初识

　　示例： 获取当前时间

　　　　Java 8中的 LocalTime 用于表示当天时间。和java.util.Date不同，它只有时间，不包含日期。

public static void main(String[] args) {
    LocalTime time = LocalTime.now();
    System.out.println("当前时间=" + time);
}
 

四、比较与计算

　　示例1： 日期时间计算

　　　　Java8提供了新的plusXxx()方法用于计算日期时间增量值，替代了原来的add()方法。新的API将返回一个全新的日期时间示例，需要使用新的对象进行接收。

复制代码
    public static void main(String[] args) {
        
　　　　 // 时间增量
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2);
        System.out.println("newTime=" + newTime);
        
　　　　　// 日期增量
        LocalDate date = LocalDate.now();
        LocalDate newDate = date.plus(1, ChronoUnit.WEEKS);
        System.out.println("newDate=" + newDate);
        
    }
复制代码
 

　　示例2： 日期时间比较

　　　　Java8提供了isAfter()、isBefore()用于判断当前日期时间和指定日期时间的比较

复制代码
    public static void main(String[] args) {
        
        LocalDate now = LocalDate.now();
        
        LocalDate date1 = LocalDate.of(2000, 1, 1);
        if (now.isAfter(date1)) {
            System.out.println("千禧年已经过去了");
        }
        
        LocalDate date2 = LocalDate.of(2020, 1, 1);
        if (now.isBefore(date2)) {
            System.out.println("2020年还未到来");
        }
        
    }
复制代码
 

五、时区

　　示例： 创建带有时区的日期时间

　　　　Java 8不仅分离了日期和时间，也把时区分离出来了。现在有一系列单独的类如ZoneId来处理特定时区，ZoneDateTime类来表示某时区下的时间。

复制代码
    public static void main(String[] args) {
        
        // 上海时间
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now(shanghaiZoneId);
        
        // 东京时间
        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoZonedDateTime = ZonedDateTime.now(tokyoZoneId);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("上海时间: " + shanghaiZonedDateTime.format(formatter));
        System.out.println("东京时间: " + tokyoZonedDateTime.format(formatter));
        
    }
复制代码
 

六、格式化

　　示例1: 使用预定义格式解析与格式化日期

复制代码
　　public static void main(String[] args) {
        
        // 解析日期
        String dateText = "20180924";
        LocalDate date = LocalDate.parse(dateText, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("格式化之后的日期=" + date);
        
        // 格式化日期
        dateText = date.format(DateTimeFormatter.ISO_DATE);
        System.out.println("dateText=" + dateText);
        
    }
复制代码
 

　　示例2： 日期和字符串的相互转换

复制代码
    public static void main(String[] args) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // 日期时间转字符串
        LocalDateTime now = LocalDateTime.now();
        String nowText = now.format(formatter);
        System.out.println("nowText=" + nowText);
        
        // 字符串转日期时间
        String datetimeText = "1999-12-31 23:59:59";
        LocalDateTime datetime = LocalDateTime.parse(datetimeText, formatter);
        System.out.println(datetime);
        
    }
复制代码
 

七、相关类说明

复制代码
Instant         时间戳
Duration        持续时间、时间差
LocalDate       只包含日期，比如：2018-09-24
LocalTime       只包含时间，比如：10:32:10
LocalDateTime   包含日期和时间，比如：2018-09-24 10:32:10
Peroid          时间段
ZoneOffset      时区偏移量，比如：+8:00
ZonedDateTime   带时区的日期时间
Clock           时钟，可用于获取当前时间戳
java.time.format.DateTimeFormatter      时间格式化类