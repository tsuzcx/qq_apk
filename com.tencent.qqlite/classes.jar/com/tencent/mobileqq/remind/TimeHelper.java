package com.tencent.mobileqq.remind;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeHelper
{
  public static int a;
  public static String[] a;
  public static final int b = 0;
  public static String[] b = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
  
  static
  {
    jdField_a_of_type_Int = 25568;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };
  }
  
  public static int a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(11);
  }
  
  public static long a()
  {
    return new Date().getTime() + 120000L;
  }
  
  public static long a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * (86400L * paramInt1));
    localCalendar.set(11, paramInt2);
    localCalendar.set(12, paramInt3);
    try
    {
      long l = localCalendar.getTimeInMillis();
      return l;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return new Date().getTime();
  }
  
  public static long a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1970, 0, 1, 0, 0, 0);
    long l = (paramLong - localCalendar.getTime().getTime()) / 1000L / 86400L;
    paramLong = l;
    if (l > 25568L) {
      paramLong = 25568L;
    }
    l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    return l;
  }
  
  public static String a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    localDate.setTime(1000L * (86400L * paramInt));
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日 E");
    if (localSimpleDateFormat.format(localDate).equals(localSimpleDateFormat.format(localCalendar.getTime()))) {
      return "今天";
    }
    return localSimpleDateFormat.format(localDate);
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(1000L * (86400L * paramInt1));
    ((Calendar)localObject).set(11, paramInt2);
    ((Calendar)localObject).set(12, paramInt3);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm");
    try
    {
      localObject = ((Calendar)localObject).getTime();
      return localSimpleDateFormat.format((Date)localObject);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Date localDate = new Date();
      }
    }
  }
  
  public static String a(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm");
    try
    {
      localObject = ((Calendar)localObject).getTime();
      return localSimpleDateFormat.format((Date)localObject);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Date localDate = new Date();
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong >= new Date().getTime() + 120000L;
  }
  
  public static int b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.remind.TimeHelper
 * JD-Core Version:    0.7.0.1
 */