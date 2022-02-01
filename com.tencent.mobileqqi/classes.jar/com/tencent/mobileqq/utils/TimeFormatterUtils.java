package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeFormatterUtils
{
  private static final char jdField_a_of_type_Char = '/';
  public static final int a = 0;
  public static final long a = 86400000L;
  private static final String jdField_a_of_type_JavaLangString = "EEEE";
  private static StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static int e = 0;
  private static final int f = 1;
  private static final int g = 7;
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar(paramInt1, paramInt2, paramInt3);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(paramInt4, paramInt5, paramInt6);
    return (int)((localGregorianCalendar1.getTimeInMillis() - localGregorianCalendar2.getTimeInMillis()) / 1000L / 60L / 60L / 24L);
  }
  
  public static int a(long paramLong)
  {
    int i = -1;
    int j = (int)((System.currentTimeMillis() + e) / 86400000L);
    int k = (int)((e + paramLong) / 86400000L);
    if (k == j) {
      i = 2131563093;
    }
    do
    {
      return i;
      if (k == j - 1) {
        return 2131563229;
      }
    } while (k != j - 2);
    return 2131561995;
  }
  
  public static int a(long paramLong, Calendar paramCalendar)
  {
    int j = -1;
    int k = (int)((System.currentTimeMillis() + e) / 86400000L);
    int m = k - 1;
    int n = (int)((e + paramLong) / 86400000L);
    int i;
    if (n == k) {
      i = 2131563093;
    }
    do
    {
      do
      {
        return i;
        if (n == m) {
          return 2131563229;
        }
        i = j;
      } while (n >= m);
      i = j;
    } while (n <= k - 7);
    Calendar localCalendar = paramCalendar;
    if (paramCalendar == null)
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
    }
    switch (localCalendar.get(7))
    {
    default: 
      return -1;
    case 1: 
      return 2131562992;
    case 2: 
      return 2131562403;
    case 3: 
      return 2131563106;
    case 4: 
      return 2131563209;
    case 5: 
      return 2131563087;
    case 6: 
      return 2131562133;
    }
    return 2131562797;
  }
  
  private static TimeFormatterUtils.TimeInterval a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 != paramInt4) {
      return TimeFormatterUtils.TimeInterval.WITHOUT_YEAR;
    }
    if (paramInt3 == paramInt6) {
      return TimeFormatterUtils.TimeInterval.TODAY;
    }
    if (paramInt3 == paramInt6 + 1) {
      return TimeFormatterUtils.TimeInterval.YESTERDAY;
    }
    if (paramInt3 == paramInt6 + 2) {
      return TimeFormatterUtils.TimeInterval.THE_DAY_BEFORE_YESTERDAY;
    }
    return TimeFormatterUtils.TimeInterval.WITHIN_YEAR;
  }
  
  public static TimeFormatterUtils.TimeInterval a(long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = jdField_a_of_type_JavaUtilCalendar.get(1);
    int j = jdField_a_of_type_JavaUtilCalendar.get(2);
    int k = jdField_a_of_type_JavaUtilCalendar.get(6);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    return a(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6));
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong)
  {
    return a(paramContext, paramInt, paramLong, true);
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = LocaleUtil.a(LocaleUtil.a(LocaleUtil.a(paramContext.getApplicationContext())).toString());
    if (android.text.format.DateFormat.is24HourFormat(BaseApplication.getContext())) {}
    for (localObject = new SimpleDateFormat("HH:mm", (Locale)localObject); paramInt == 0; localObject = (SimpleDateFormat)java.text.DateFormat.getTimeInstance(3, (Locale)localObject)) {
      return ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
    }
    return a(paramContext, paramLong, localStringBuilder, (SimpleDateFormat)localObject, paramInt, paramBoolean);
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    return String.format("%s.%s", new Object[] { Integer.valueOf(jdField_a_of_type_JavaUtilCalendar.get(2) + 1), Integer.valueOf(jdField_a_of_type_JavaUtilCalendar.get(5)) });
  }
  
  private static CharSequence a(Context paramContext, long paramLong, StringBuilder paramStringBuilder, SimpleDateFormat paramSimpleDateFormat, int paramInt, boolean paramBoolean)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    Time localTime2 = new Time();
    localTime2.setToNow();
    Locale localLocale = LocaleUtil.a(LocaleUtil.a(LocaleUtil.a(paramContext.getApplicationContext())).toString());
    int i;
    if ((paramInt & 0x2) != 0)
    {
      i = 1;
      if ((paramInt & 0x1) == 0) {
        break label146;
      }
      paramInt = 1;
      label67:
      if (localTime1.year == localTime2.year) {
        break label152;
      }
      paramStringBuilder.append(new SimpleDateFormat("yyyy-MM-dd", localLocale).toLocalizedPattern()).append(" ");
      paramInt = 0;
    }
    for (;;)
    {
      paramContext = new SimpleDateFormat(paramStringBuilder.toString(), localLocale);
      if ((paramInt == 0) && (!paramBoolean))
      {
        return paramContext.format(Long.valueOf(paramLong));
        i = 0;
        break;
        label146:
        paramInt = 0;
        break label67;
        label152:
        if (localTime1.yearDay == localTime2.yearDay) {
          break label421;
        }
        int k = Math.abs(localTime2.yearDay - localTime1.yearDay);
        if (localTime2.yearDay > localTime1.yearDay) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            break label229;
          }
          paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
          paramInt = 0;
          break;
        }
        label229:
        if ((k == 1) && (paramInt != 0))
        {
          paramStringBuilder.append(paramContext.getString(2131563230)).append(" ");
          if (!paramBoolean) {
            return paramStringBuilder.toString().trim();
          }
          return paramStringBuilder.toString() + paramSimpleDateFormat.format(Long.valueOf(paramLong));
        }
        if ((k > 1) && (k < 7) && (i != 0))
        {
          paramStringBuilder.append("EEEE").append(" ");
          paramInt = 0;
          continue;
        }
        if (localTime1.year == localTime2.year)
        {
          paramStringBuilder.append("MM/dd").append(" ");
          paramInt = 0;
          continue;
        }
        paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
        paramInt = 0;
        continue;
      }
      return paramContext.format(Long.valueOf(paramLong)) + paramSimpleDateFormat.format(Long.valueOf(paramLong));
      label421:
      paramInt = 1;
    }
  }
  
  public static String a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Date localDate = new Date(paramLong);
    localCalendar1.setTime(localDate);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      return BaseApplicationImpl.getContext().getString(2131559323);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) + 1 == localCalendar2.get(6))) {
      return BaseApplicationImpl.getContext().getString(2131559321);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) > localCalendar2.get(6) - 7)) {
      switch (localCalendar1.get(7))
      {
      }
    }
    while (localCalendar1.get(1) != localCalendar2.get(1))
    {
      return new SimpleDateFormat("yy-MM-dd").format(localDate);
      return BaseApplicationImpl.getContext().getString(2131559324);
      return BaseApplicationImpl.getContext().getString(2131559325);
      return BaseApplicationImpl.getContext().getString(2131559326);
      return BaseApplicationImpl.getContext().getString(2131559327);
      return BaseApplicationImpl.getContext().getString(2131559328);
      return BaseApplicationImpl.getContext().getString(2131559329);
      return BaseApplicationImpl.getContext().getString(2131559330);
    }
    return new SimpleDateFormat("MM-dd").format(localDate);
  }
  
  public static String a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString).format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    jdField_a_of_type_JavaLangStringBuffer.setLength(0);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    int i = 0;
    int m = a(paramLong);
    if (m != -1)
    {
      j = 1;
      i = j;
      if (m != 2131563093)
      {
        jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(m));
        i = j;
      }
    }
    int k = jdField_a_of_type_JavaUtilCalendar.get(11);
    int j = jdField_a_of_type_JavaUtilCalendar.get(12);
    if (i != 0) {
      if (m == 2131563093) {
        if (BaseApplication.getContext().getString(2131561656).equals("AM")) {
          if (k == 12)
          {
            i = 12;
            if (i < 10) {
              jdField_a_of_type_JavaLangStringBuffer.append('0');
            }
            jdField_a_of_type_JavaLangStringBuffer.append(i);
            jdField_a_of_type_JavaLangStringBuffer.append(':');
            if (j < 10) {
              jdField_a_of_type_JavaLangStringBuffer.append('0');
            }
            jdField_a_of_type_JavaLangStringBuffer.append(j);
            jdField_a_of_type_JavaLangStringBuffer.append(' ');
            if ((k < 0) || (k >= 12)) {
              break label228;
            }
            jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(2131561656));
          }
        }
      }
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangStringBuffer.toString();
      i = k % 12;
      break;
      label228:
      jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(2131562651));
      continue;
      if ((k >= 0) && (k < 12))
      {
        jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(2131561656));
        label275:
        jdField_a_of_type_JavaLangStringBuffer.append(' ');
        if (k != 12) {
          break label373;
        }
      }
      label373:
      for (i = 12;; i = k % 12)
      {
        if (i < 10) {
          jdField_a_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_a_of_type_JavaLangStringBuffer.append(i);
        jdField_a_of_type_JavaLangStringBuffer.append(':');
        if (j < 10) {
          jdField_a_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_a_of_type_JavaLangStringBuffer.append(j);
        break;
        jdField_a_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(2131562651));
        break label275;
      }
      if (!paramBoolean)
      {
        jdField_a_of_type_JavaLangStringBuffer.append(' ');
        if (k < 10) {
          jdField_a_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_a_of_type_JavaLangStringBuffer.append(k);
        jdField_a_of_type_JavaLangStringBuffer.append(':');
        if (j < 10) {
          jdField_a_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_a_of_type_JavaLangStringBuffer.append(j);
        continue;
        jdField_a_of_type_JavaLangStringBuffer.append(jdField_a_of_type_JavaUtilCalendar.get(1)).append('/').append(jdField_a_of_type_JavaUtilCalendar.get(2) + 1).append('/').append(jdField_a_of_type_JavaUtilCalendar.get(5));
        if (!paramBoolean)
        {
          jdField_a_of_type_JavaLangStringBuffer.append(' ');
          jdField_a_of_type_JavaLangStringBuffer.append(k);
          jdField_a_of_type_JavaLangStringBuffer.append(':');
          if (j < 10) {
            jdField_a_of_type_JavaLangStringBuffer.append('0');
          }
          jdField_a_of_type_JavaLangStringBuffer.append(j);
        }
      }
    }
  }
  
  public static String a(long paramLong, boolean paramBoolean, String paramString)
  {
    return a(jdField_a_of_type_JavaLangStringBuffer, paramLong, paramBoolean, paramString);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = jdField_a_of_type_JavaUtilCalendar.get(1);
    int j = jdField_a_of_type_JavaUtilCalendar.get(2);
    int k = jdField_a_of_type_JavaUtilCalendar.get(5);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    i = a(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(5));
    if (i == 0)
    {
      try
      {
        i = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
        if (i == 12) {
          if (jdField_a_of_type_JavaUtilCalendar.get(11) < 12)
          {
            i = 2131561656;
            String str = paramContext.getString(i);
            paramContext = new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale);
            if (!BaseApplication.getContext().getString(2131561656).equals("AM")) {
              break label201;
            }
            return String.format("%s %s", new Object[] { paramContext.format(new Date(paramLong)), str });
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          i = 0;
          continue;
          i = 2131562651;
        }
        label201:
        return String.format("%s %s", new Object[] { localSettingNotFoundException, paramContext.format(new Date(paramLong)) });
      }
      return new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (i == 1) {
      return paramContext.getString(2131563229);
    }
    if ((i < 7) && (i > 1)) {
      return new SimpleDateFormat("E", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return android.text.format.DateFormat.getDateFormat(paramContext).format(new Date(paramLong));
  }
  
  public static String a(StringBuffer paramStringBuffer, long paramLong, boolean paramBoolean, String paramString)
  {
    int i = 0;
    Calendar localCalendar;
    int j;
    int m;
    Locale localLocale;
    if (paramStringBuffer != null)
    {
      paramStringBuffer.setLength(0);
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      int k = b(paramLong, localCalendar);
      if (k != -1)
      {
        j = 1;
        i = j;
        if (k != 2131563093)
        {
          paramStringBuffer.append(BaseApplication.getContext().getString(k));
          i = j;
        }
      }
      j = localCalendar.get(11);
      m = localCalendar.get(12);
      localLocale = LocaleUtil.a(LocaleUtil.a(LocaleUtil.a(BaseApplicationImpl.getContext())).toString());
      if (i == 0) {
        break label241;
      }
      boolean bool = android.text.format.DateFormat.is24HourFormat(BaseApplication.getContext());
      if (k != 2131563093) {
        break label178;
      }
      if (!bool) {
        break label164;
      }
      paramString = new SimpleDateFormat("HH:mm", localLocale);
      paramStringBuffer.append(paramString.format(new Date(paramLong)));
    }
    for (;;)
    {
      return paramStringBuffer.toString();
      label164:
      paramString = (SimpleDateFormat)java.text.DateFormat.getTimeInstance(3, localLocale);
      break;
      label178:
      if (!paramBoolean)
      {
        paramStringBuffer.append(' ');
        if (j < 10) {
          paramStringBuffer.append('0');
        }
        paramStringBuffer.append(j);
        paramStringBuffer.append(':');
        if (m < 10) {
          paramStringBuffer.append('0');
        }
        paramStringBuffer.append(m);
        continue;
        label241:
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = "yyyy-MM-dd";
        }
        paramStringBuffer.append(new SimpleDateFormat(str, localLocale).format(localCalendar.getTime()));
        if (!paramBoolean)
        {
          paramStringBuffer.append(' ');
          paramStringBuffer.append(j);
          paramStringBuffer.append(':');
          if (m < 10) {
            paramStringBuffer.append('0');
          }
          paramStringBuffer.append(m);
        }
      }
    }
  }
  
  public static void a()
  {
    e = TimeZone.getTimeZone("GMT+8").getRawOffset();
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  }
  
  public static int b(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = new Time();
    paramCalendar.set(paramLong);
    long l = System.currentTimeMillis();
    Time localTime = new Time();
    localTime.set(l);
    int i = localTime.yearDay - 1;
    int j = localTime.yearDay;
    if (paramCalendar.year == localTime.year) {
      if (localTime.yearDay >= paramCalendar.yearDay) {}
    }
    do
    {
      do
      {
        do
        {
          return -1;
          if (localTime.yearDay == paramCalendar.yearDay) {
            return 2131563093;
          }
          if (paramCalendar.yearDay == i) {
            return 2131563229;
          }
        } while ((paramCalendar.yearDay >= i) || (paramCalendar.yearDay <= j - 7));
        switch (paramCalendar.weekDay)
        {
        default: 
          return -1;
        case 0: 
          return 2131562992;
        case 1: 
          return 2131562403;
        case 2: 
          return 2131563106;
        case 3: 
          return 2131563209;
        case 4: 
          return 2131563087;
        case 5: 
          return 2131562133;
        }
        return 2131562797;
      } while (paramCalendar.year + 1 != localTime.year);
      paramLong = (l - paramLong + 86400000L - 1L) / 86400000L;
    } while ((paramLong <= 0L) || (paramLong > 7L));
    if (paramLong == 1L) {
      return 2131563229;
    }
    switch (paramCalendar.weekDay)
    {
    default: 
      return -1;
    case 0: 
      return 2131562992;
    case 1: 
      return 2131562403;
    case 2: 
      return 2131563106;
    case 3: 
      return 2131563209;
    case 4: 
      return 2131563087;
    case 5: 
      return 2131562133;
    }
    return 2131562797;
  }
  
  public static CharSequence b(Context paramContext, long paramLong)
  {
    return android.text.format.DateFormat.getTimeFormat(paramContext).format(new Date(paramLong));
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = jdField_a_of_type_JavaUtilCalendar.get(1);
    int j = jdField_a_of_type_JavaUtilCalendar.get(2);
    int k = jdField_a_of_type_JavaUtilCalendar.get(5);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    i = a(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(5));
    SimpleDateFormat localSimpleDateFormat2;
    Object localObject;
    if (i == 0) {
      try
      {
        i = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
        if (i == 12) {
          if (jdField_a_of_type_JavaUtilCalendar.get(11) < 12)
          {
            i = 2131561656;
            String str = paramContext.getString(i);
            localSimpleDateFormat2 = new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale);
            return paramContext.getString(2131563093) + " " + String.format("%s %s", new Object[] { str, localSimpleDateFormat2.format(new Date(paramLong)) });
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException1)
      {
        for (;;)
        {
          i = 0;
          continue;
          i = 2131562651;
        }
        localObject = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
        return paramContext.getString(2131563093) + " " + ((SimpleDateFormat)localObject).format(new Date(paramLong));
      }
    }
    if (i == 1) {
      try
      {
        i = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
        if (i == 12) {
          if (jdField_a_of_type_JavaUtilCalendar.get(11) < 12)
          {
            i = 2131561656;
            localObject = paramContext.getString(i);
            localSimpleDateFormat2 = new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale);
            return paramContext.getString(2131563229) + " " + String.format("%s %s", new Object[] { localObject, localSimpleDateFormat2.format(new Date(paramLong)) });
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException2)
      {
        for (;;)
        {
          i = 0;
          continue;
          i = 2131562651;
        }
        SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
        return paramContext.getString(2131563229) + " " + localSimpleDateFormat1.format(new Date(paramLong));
      }
    }
    if ((i < 7) && (i > 1)) {
      return new SimpleDateFormat("E", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("yyyy-MM-dd", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = jdField_a_of_type_JavaUtilCalendar.get(1);
    int j = jdField_a_of_type_JavaUtilCalendar.get(2);
    int k = jdField_a_of_type_JavaUtilCalendar.get(6);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    Object localObject = a(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6));
    switch (hed.a[localObject.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    case 2: 
      localObject = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
      return String.format("%s %s", new Object[] { paramContext.getString(2131559321), ((SimpleDateFormat)localObject).format(new Date(paramLong)) });
    case 3: 
      localObject = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
      return String.format("%s %s", new Object[] { paramContext.getString(2131559322), ((SimpleDateFormat)localObject).format(new Date(paramLong)) });
    case 4: 
      return new SimpleDateFormat("MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("yy-MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TimeFormatterUtils
 * JD-Core Version:    0.7.0.1
 */