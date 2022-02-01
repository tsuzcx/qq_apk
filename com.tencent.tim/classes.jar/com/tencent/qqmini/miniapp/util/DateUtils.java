package com.tencent.qqmini.miniapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils
{
  private static final String TAG = "DateUtils";
  
  public static long dateToLong(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static int getDayByDateStr(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(5);
  }
  
  public static int getHour(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(11);
  }
  
  public static int getMinute(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(12);
  }
  
  public static int getMonthByDateStr(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(2);
  }
  
  public static Date getSmartDateByTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat;
    if (paramString.length() >= 10) {
      if (Pattern.compile(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getString(R.string.mini_app_time_pattern)).matcher(paramString).matches()) {
        localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      }
    }
    for (;;)
    {
      if (localSimpleDateFormat == null)
      {
        return null;
        localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        continue;
        if (paramString.length() >= 7)
        {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
          continue;
        }
        if (paramString.length() >= 4) {
          localSimpleDateFormat = new SimpleDateFormat("yyyy");
        }
      }
      else
      {
        try
        {
          paramString = localSimpleDateFormat.parse(paramString);
          return paramString;
        }
        catch (ParseException paramString)
        {
          paramString.printStackTrace();
          QMLog.e("DateUtils", "getDateByStrTime exception." + paramString);
          return null;
        }
      }
      localSimpleDateFormat = null;
    }
  }
  
  public static Date getTimeByStrTime(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static int getYearByDateStr(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.DateUtils
 * JD-Core Version:    0.7.0.1
 */