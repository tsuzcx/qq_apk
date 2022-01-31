package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class QfileTimeUtils
{
  private static Calendar a = ;
  
  private static QfileTimeUtils.TimeInterval a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (a == null) {
      a = Calendar.getInstance();
    }
    return QfileTimeUtils.TimeInterval.TODAY;
  }
  
  public static String a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(MessageCache.a() * 1000L);
    localCalendar2.setTimeInMillis(paramLong);
    int i = localCalendar1.get(6) - localCalendar2.get(6);
    int k = localCalendar1.get(1);
    int j = i;
    if (localCalendar2.get(1) != k)
    {
      localCalendar1 = (Calendar)localCalendar2.clone();
      do
      {
        j = i + localCalendar1.getActualMaximum(6);
        localCalendar1.add(1, 1);
        i = j;
      } while (localCalendar1.get(1) != k);
    }
    if (j > 60) {
      return "两个月前";
    }
    if (j > 30) {
      return "一个月前";
    }
    if (j > 7) {
      return "一周前";
    }
    if (j > 1) {
      return "一周内";
    }
    if (j == 1) {
      return "昨天";
    }
    if (j == 0) {
      return "今天";
    }
    if (QLog.isDevelopLevel()) {
      throw new IllegalArgumentException("参数错误");
    }
    return "两个月前";
  }
  
  public static String b(long paramLong)
  {
    a.setTimeInMillis(System.currentTimeMillis());
    int i = a.get(1);
    a.setTimeInMillis(paramLong);
    if (i != a.get(1)) {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("MM-dd HH:mm", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QfileTimeUtils
 * JD-Core Version:    0.7.0.1
 */