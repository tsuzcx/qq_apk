package com.tencent.mobileqq.remind;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeHelper
{
  public static final int a = 25568;
  public static String[] a = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };
  public static final int b = 0;
  public static String[] b = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
  
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
    Object localObject = Calendar.getInstance();
    Date localDate = new Date();
    localDate.setTime(1000L * (86400L * paramInt));
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    if (localSimpleDateFormat.format(localDate).equals(localSimpleDateFormat.format(((Calendar)localObject).getTime()))) {
      return BaseApplicationImpl.getContext().getString(2131559323);
    }
    String str = new SimpleDateFormat("E").format(localDate);
    if (str.equals("周日")) {
      localObject = BaseApplicationImpl.getContext().getString(2131559959);
    }
    for (;;)
    {
      return localSimpleDateFormat.format(localDate) + " " + (String)localObject;
      if (str.equals("周一"))
      {
        localObject = BaseApplicationImpl.getContext().getString(2131559960);
      }
      else if (str.equals("周二"))
      {
        localObject = BaseApplicationImpl.getContext().getString(2131559961);
      }
      else if (str.equals("周三"))
      {
        localObject = BaseApplicationImpl.getContext().getString(2131559962);
      }
      else if (str.equals("周四"))
      {
        localObject = BaseApplicationImpl.getContext().getString(2131559963);
      }
      else if (str.equals("周五"))
      {
        localObject = BaseApplicationImpl.getContext().getString(2131559964);
      }
      else
      {
        localObject = str;
        if (str.equals("周六")) {
          localObject = BaseApplicationImpl.getContext().getString(2131559965);
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.remind.TimeHelper
 * JD-Core Version:    0.7.0.1
 */