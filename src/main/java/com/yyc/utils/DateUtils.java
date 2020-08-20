package com.yyc.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils  extends DateFormatUtils{

    /**
     * yyyy.MM
     */
    public static final String format6 = "yyyy.MM";

    /**
     * yyyy.MM.dd
     */
    public static final String format7 = "yyyy.MM.dd";

    /**
     * 日期-中文格式
     */
    public static final String formatCN = "yyyy年MM月dd日";

    /**
     * yyyy-MM-dd
     */
    public static final String format5 = "yyyy-MM-dd";

    /**
     * 365天的毫秒数
     */
    public static final long dayNumOfDay = 365 * 24 * 60 * 60 * 1000L;

    /**
     * 30天的毫秒数
     */
    public static final long MonthNum = 30 * 24 * 60 * 60 * 1000L;


    /**
     * yyyy
     */
    public static final String format8 = "yyyy";


    /**
     * yyyy-MM-dd
     */
    public static final String format9 = "yyyy-MM";

    /**
     * yyyyMMdd
     */
    public static final String format10 = "yyyyMMdd";

    /**
     * yyyyMMdd
     */
    public static final String format11 = "yyyyMMddHHmmss";
    /**
     * 时间类转化为字读串
     *
     * @param date
     * @param pattern
     * @return
     * @Title: strToDate
     * @Description:
     * @author: xpy 2018年7月12日
     * @modify: xpy 2018年7月12日
     */
    public static String strToDate(Date date, String pattern) {
        if (StringUtils.isEmpty(pattern))
            pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String str = sdf.format(date);
        return str;
    }

    /**
     * 日期-中文格式 转化 yyyy-MM
     *
     * @param
     * @return
     * @author
     */
    public static String farmatDateToFormat5(String date) throws Exception {
        Date format = null;
        try {
            format = new SimpleDateFormat(format6).parse(date);
        } catch (Exception e) {
//            log.info("日期-中文格式 转化 yyyy-MM-，转化异常={}", e.getMessage());
//            log.error(e.getMessage(), e);
            throw e;
        }
        String strToDate = DateUtils.strToDate(format, format5);
        return strToDate;
    }

    /**
     * 日期-yyyy.MM.dd 转化 yyyy-MM-dd
     *
     * @param
     * @return
     * @author
     */
    public static String farmatDateFormat7ToFormat5(String date) throws Exception {
        Date format = null;
        try {
            format = new SimpleDateFormat(format7).parse(date);
        } catch (Exception e) {
//            log.info("日期-yyyy.MM.dd 转化 yyyy-MM-dd，转化异常={}", e.getMessage());
//            log.error(e.getMessage(), e);
            throw e;
        }
        String strToDate = DateUtils.strToDate(format, format5);
        return strToDate;
    }

    /**
     * 获取多少月前或者后，根据preN 是正数还是负数
     *
     * @param d
     * @param preN
     * @return
     * @Title: getPreTimeMoth
     * @Description: TODO
     * @author: hanxingyu 2018年8月11日
     * @modify: hanxingyu 2018年8月11日
     */
    public static Date getPreTimeMoth(Date d, int preN) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(d);
        instance.add(Calendar.MONTH, preN);
        return instance.getTime();
    }

    // 获取前N月的日期,返回String yyyy-MM-dd
    public static String getPreTimeMothStr5(Date d, int preN) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(d);
        instance.add(Calendar.MONTH, -preN);
        String dateStr = new SimpleDateFormat(format5).format(instance.getTime());
        return dateStr;
    }

    /**
     * Created by froad - glh 返回 date1 是否大于等于 date2
     *
     * @param dfs   例如 "yyyyMMdd HHmmss"
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public static boolean dateCompare(String dfs, String date1, String date2) throws Exception {
        DateFormat df = new SimpleDateFormat(dfs);
        // 获取Calendar实例
        Calendar currentTime = Calendar.getInstance();
        Calendar compareTime = Calendar.getInstance();
        try {
            // 把字符串转成日期类型
            currentTime.setTime(df.parse(date1));
            compareTime.setTime(df.parse(date2));
        } catch (Exception e) {
//            log.info("日期比较异常={}", e.getMessage());
//            log.error(e.getMessage(), e);
            throw e;
        }
        // 利用Calendar的方法比较大小
        return currentTime.compareTo(compareTime) >= 0;
    }

    public static String dateToStrWithFormat5(Date date) {
        return new SimpleDateFormat(format5).format(date);
    }

    public static Date strToDateWithFormatCN(String str) throws Exception {
        try {
            return new SimpleDateFormat(formatCN).parse(str);
        } catch (Exception e) {
//            log.info("日期转化异常={}", e.getMessage());
//            log.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 时间字符串转化为时间类
     *
     * @param dateStr
     * @param pattern
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateStr, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d = null;
        try {
            d = sdf.parse(dateStr);
        } catch (Exception e) {
//            log.info("时间字符串转化为时间类，转化异常={}", e.getMessage());
//            log.error(e.getMessage(), e);
            throw e;
        }
        return d;
    }

    /**
     * 根据指定的日期及前后天数，取日期，整正数为后天数，负正数为前天数，即num为7时则指定日期七天后的日期，-7时为取指定日期的前七天日期
     *
     * @param date 指定的日期
     * @param num  正或负数
     * @return 指定num数后的日期
     */
    public static Date getDate(Date date, int num) {
        if (num == 0)
            return date;
        Calendar cal = Calendar.getInstance(java.util.Locale.CHINA);
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + num);
        return cal.getTime();
    }

    public static String getCurDate(long cur_millis, String strformat) {
        return format(cur_millis, strformat);
    }

    /**
     * 判断当前时间是否在时间段内，指定时间格式
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendarByFormat(String beginTime, String endTime, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);// 设置日期格式
        Date now = null;
        Date beginDate = null;
        Date endDate = null;
        try {
            now = df.parse(df.format(new Date()));
            beginDate = df.parse(beginTime);
            endDate = df.parse(endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return belongCalendar(now, beginDate, endDate);
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param useTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date useTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(useTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取指定时间，指定格式（可以理解为指定精度）的时间戳
     *
     * @param date
     * @param format
     * @return
     */
    public static long dateToStamp(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = parseDate(sdf.format(date), format);
        } catch (Exception e) {
//            log.error(e.getMessage(), e);
        }
        return date.getTime();
    }

    /**
     * 将时间戳按照转换成日期
     *
     * @param stamp
     * @return
     */
    public static Date stampToDate(long stamp) {
        Date date = new Date(stamp);
        return date;
    }

    /**
     * 获取精确到天的时间戳/365的数据
     *
     * @param stamp
     * @return
     */
    public static double getStampExactDay(long stamp) {
        double dateToStamp = dateToStamp(stampToDate(stamp), format5);
        return dateToStamp / dayNumOfDay;
    }


    //获取当前年
    public static Date getStartMonthDate() {
        return stampToDate(dateToStamp(new Date(), format8));
    }

    /**
     * 获取当前时间与传入时间的间隔月数
     *
     * @param dateStr
     * @param formatStr
     * @return
     * @throws Exception
     */
    public static Integer getIntervalMonth(String dateStr, String formatStr) throws Exception {
        Date now = new Date();
        Date date = parseDate(dateStr, formatStr);
        long diff = now.getTime() - date.getTime();
        long diffMonth = diff / MonthNum;
        return Integer.valueOf(String.valueOf(diffMonth));
    }

    /**
     * 将String类型时间转换成yyyy.MM格式
     *
     * @param dataStr
     * @return
     * @throws Exception
     */
    public static String transDateStrForFormat6(String dataStr, String formatStr) throws Exception {
        return strToDate(DateUtils.parseDate(dataStr, formatStr), format6);
    }

}
