package com.tencent.qqmail.calendar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtils
{
  public static int computeDate(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt2 * 100 + paramInt3 + paramInt1 * 10000;
  }
  
  public static int computeDate(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return computeDate(localCalendar);
  }
  
  public static int computeDate(Calendar paramCalendar)
  {
    return computeDate(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
  }
  
  public static int computeYearFromDate(int paramInt)
  {
    return paramInt / 10000;
  }
  
  public static int getDaysInCUrrentMonth()
  {
    return new GregorianCalendar(Calendar.getInstance().get(1), Calendar.getInstance().get(2) + 1, 0).getActualMaximum(5);
  }
  
  public static String getYearAndMon(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("yyyy/MM").format(localDate);
  }
  
  public static boolean isLastMonth(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(5, 1);
    localCalendar.add(5, -1);
    return isTheSameMon(localCalendar.getTimeInMillis(), paramLong);
  }
  
  private static boolean isTheSameMon(long paramLong1, long paramLong2)
  {
    Date localDate1 = new Date(paramLong1);
    Date localDate2 = new Date(paramLong2);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
    return localSimpleDateFormat.format(localDate1).equals(localSimpleDateFormat.format(localDate2));
  }
  
  public static boolean isThisMonth(long paramLong)
  {
    return isThisTime(paramLong, "yyyy-MM");
  }
  
  private static boolean isThisTime(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString);
    return paramString.format(localDate).equals(paramString.format(new Date()));
  }
  
  public static boolean isThisWeek(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(3);
    localCalendar.setTime(new Date(paramLong));
    return localCalendar.get(3) == i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.util.CalendarUtils
 * JD-Core Version:    0.7.0.1
 */