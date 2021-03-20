package com.tool.utils;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: impactCn
 * @createTime: 2020-12-22
 */
public class TimeUtils {

    private static ZoneId zoneId = ZoneId.systemDefault();

    private static DateTimeFormatter formatter;



    public static Date localDateToDate(LocalDate localDate) {

        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    public static Date minus(LocalDate localDate, long year, long month, long day) {
        return Date.from(localDate
                .minusYears(year)
                .minusMonths(month)
                .minusDays(day)
                .atStartOfDay(zoneId)
                .toInstant());
    }

    public static Date minus(LocalDate localDate, long year, long month) {
        return Date.from(localDate
                .minusYears(year)
                .minusMonths(month)
                .atStartOfDay(zoneId)
                .toInstant());
    }

    public static Date minus(LocalDate localDate, long year) {
        return Date.from(localDate
                .minusYears(year)
                .atStartOfDay(zoneId)
                .toInstant());
    }


    public static Date localDateTimeToDate(LocalDateTime localDateTime) {

        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }


    public static LocalDate dateToLocalDate(Date date) {

        return date.toInstant().atZone(zoneId).toLocalDate();

    }

    public static LocalDateTime dateToLocalDateTime(Date date) {

        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    public static String format(Date date, String format) {
        formatter = DateTimeFormatter.ofPattern(format);

        return dateToLocalDate(date).format(formatter);

    }

    public static String format(LocalDate localDate, String format) {
        formatter = DateTimeFormatter.ofPattern(format);

        return localDate.format(formatter);
    }

    public static String format(LocalDateTime localDateTime, String format) {
        formatter = DateTimeFormatter.ofPattern(format);

        return localDateTime.format(formatter);
    }

    public static LocalDateTime minOfToday() {

        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }


    public static LocalDateTime maxOfToday() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    public static LocalDateTime noonOfToday() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
    }

    public static LocalDateTime midnightOfToday() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
    }

    public static long dateRange(Date startTime, Date endTime) {

        return  dateToLocalDate(endTime).toEpochDay() - dateToLocalDate(startTime).toEpochDay();
    }


}
