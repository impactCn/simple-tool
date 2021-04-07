package com.tool.utils;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类
 * @author: impactCn
 * @createTime: 2020-12-22
 */
public class TimeUtils {

    private static ZoneId zoneId = ZoneId.systemDefault();

    private static DateTimeFormatter formatter;


    /**
     * localDate 转 date
     * @param localDate localDate 对象
     * @return
     */
    public static Date localDateToDate(LocalDate localDate) {

        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    /**
     * localDate 对象时间倒退
     * @param localDate
     * @param year 年
     * @param month 月
     * @param day 日
     * @return date
     */
    public static Date minus(LocalDate localDate, long year, long month, long day) {
        return Date.from(localDate
                .minusYears(year)
                .minusMonths(month)
                .minusDays(day)
                .atStartOfDay(zoneId)
                .toInstant());
    }

    /**
     * localDate 对象时间倒退
     * @param localDate
     * @param year 年
     * @param month 月
     * @return date
     */
    public static Date minus(LocalDate localDate, long year, long month) {
        return Date.from(localDate
                .minusYears(year)
                .minusMonths(month)
                .atStartOfDay(zoneId)
                .toInstant());
    }

    /**
     * localDate 对象时间倒退
     * @param localDate
     * @param year 年
     * @return
     */
    public static Date minus(LocalDate localDate, long year) {
        return Date.from(localDate
                .minusYears(year)
                .atStartOfDay(zoneId)
                .toInstant());
    }


    /**
     * localDateTime 转 date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {

        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    /**
     * date 转 LocalDate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {

        return date.toInstant().atZone(zoneId).toLocalDate();

    }

    /**
     * date 转 localDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {

        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    /**
     * date 时间格式化
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        formatter = DateTimeFormatter.ofPattern(format);

        return dateToLocalDate(date).format(formatter);

    }

    /**
     * localDate 对象时间格式化
     * @param localDate
     * @param format
     * @return
     */
    public static String format(LocalDate localDate, String format) {
        formatter = DateTimeFormatter.ofPattern(format);

        return localDate.format(formatter);
    }

    /**
     * localDateTime 时间格式化
     * @param localDateTime
     * @param format
     * @return
     */
    public static String format(LocalDateTime localDateTime, String format) {
        formatter = DateTimeFormatter.ofPattern(format);

        return localDateTime.format(formatter);
    }

    /**
     * 获取今天的 23 点 59 分 59 秒
     * @return
     */
    public static LocalDateTime minOfToday() {

        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    /**
     * 获取今天的 00 点 00 分 00 秒
     * @return
     */
    public static LocalDateTime maxOfToday() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    /**
     * 获取今天的午夜 12 点
     * @return
     */
    public static LocalDateTime noonOfToday() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
    }

    /**
     * 获取今天的中午 12 点
     * @return
     */
    public static LocalDateTime midnightOfToday() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
    }

    /**
     * 计算两个时间日期的相差天数
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diff(Date startTime, Date endTime) {

        return dateToLocalDate(endTime).toEpochDay() - dateToLocalDate(startTime).toEpochDay();
    }

    /**
     * 计算两个时间日期的相差天数
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffMillis(Date startTime, Date endTime) {
        return (endTime.getTime() - startTime.getTime()) / (1000 * 60);
    }






}
