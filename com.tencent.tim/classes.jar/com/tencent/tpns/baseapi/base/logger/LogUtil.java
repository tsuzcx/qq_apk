package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogUtil
{
  public static String PATTERN_DATETIME_FILENAME = "yyyyMMdd_HHmm";
  private static ThreadLocal<DateFormat> a = new ThreadLocal();
  
  private static DateFormat a(String paramString)
  {
    DateFormat localDateFormat = (DateFormat)a.get();
    Object localObject = localDateFormat;
    if (localDateFormat == null)
    {
      localObject = new SimpleDateFormat(paramString);
      a.set(localObject);
    }
    return localObject;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.e("LogUtil", "checkPermission error", paramContext);
    }
    return false;
  }
  
  public static String formatDate(Date paramDate, String paramString)
  {
    try
    {
      paramDate = a(paramString).format(paramDate);
      return paramDate;
    }
    catch (Throwable paramDate) {}
    return "";
  }
  
  public static String getTodayDateTimeForFilename()
  {
    return new SimpleDateFormat(PATTERN_DATETIME_FILENAME).format(new Date());
  }
  
  public static boolean isDaysAgo(Date paramDate, int paramInt)
  {
    if (paramDate == null) {
      return false;
    }
    try
    {
      Calendar localCalendar1 = Calendar.getInstance();
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(paramDate.getTime());
      localCalendar1.add(5, -paramInt);
      boolean bool = localCalendar1.after(localCalendar2);
      return bool;
    }
    catch (Throwable paramDate)
    {
      TBaseLogger.e("LogUtil", "action -> isDaysAgo ", paramDate);
    }
    return false;
  }
  
  public static boolean isSDCardMounted(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        if (a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
        {
          paramContext = Environment.getExternalStorageState();
          if (paramContext != null)
          {
            boolean bool = paramContext.equals("mounted");
            if (bool) {
              return true;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        TBaseLogger.e("LogUtil", "isSDCardMounted", paramContext);
      }
    }
    return false;
  }
  
  public static Date parse(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(paramString2).parse(paramString1);
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return null;
  }
  
  public static Date parseDateInFilename(String paramString)
  {
    Object localObject = new SimpleDateFormat(PATTERN_DATETIME_FILENAME);
    try
    {
      localObject = ((SimpleDateFormat)localObject).parse(paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      TBaseLogger.e("LogUtil", "parse filename datetime error - " + paramString, localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.logger.LogUtil
 * JD-Core Version:    0.7.0.1
 */