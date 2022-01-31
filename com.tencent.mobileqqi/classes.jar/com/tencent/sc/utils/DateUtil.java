package com.tencent.sc.utils;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil
{
  public static final String a;
  public static final SimpleDateFormat a;
  public static final String b;
  public static final SimpleDateFormat b;
  public static final String c;
  public static final SimpleDateFormat c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public static final String i;
  public static final String j;
  public static final String k;
  public static final String l;
  public static final String m;
  public static final String n;
  public static final String o = ":";
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131562269);
    jdField_b_of_type_JavaLangString = BaseApplication.getContext().getString(2131562379);
    jdField_c_of_type_JavaLangString = BaseApplication.getContext().getString(2131562223);
    d = BaseApplication.getContext().getString(2131563228);
    e = BaseApplication.getContext().getString(2131561994);
    f = BaseApplication.getContext().getString(2131561907);
    g = BaseApplication.getContext().getString(2131562405);
    h = BaseApplication.getContext().getString(2131563226);
    i = BaseApplication.getContext().getString(2131562221);
    j = BaseApplication.getContext().getString(2131563225);
    k = BaseApplication.getContext().getString(2131562404);
    l = BaseApplication.getContext().getString(2131561906);
    m = BaseApplication.getContext().getString(2131562377);
    n = BaseApplication.getContext().getString(2131561700);
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
    jdField_b_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    jdField_c_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat(BaseApplication.getContext().getString(2131562382), Locale.CHINA);
  }
  
  public static long a(int paramInt)
  {
    Date localDate = new Date(paramInt * 1000L);
    return (new Date().getTime() - localDate.getTime()) / 1000L / 3600L;
  }
  
  public static long a(Date paramDate)
  {
    return (new Date().getTime() - paramDate.getTime()) / 1000L % 86400L / 3600L;
  }
  
  static String a(int paramInt)
  {
    if (paramInt < 10) {
      return '0' + String.valueOf(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return jdField_a_of_type_JavaTextSimpleDateFormat.format(localDate);
  }
  
  public static final String a(Date paramDate)
  {
    int i1 = paramDate.getYear() + 1900;
    int i2 = paramDate.getMonth();
    int i3 = paramDate.getDate();
    int i4 = paramDate.getHours();
    int i5 = paramDate.getMinutes();
    Date localDate = new Date();
    int i6 = localDate.getYear();
    long l3 = new Date(localDate.getYear(), localDate.getMonth(), localDate.getDate(), 0, 0, 0).getTime() - paramDate.getTime();
    long l2 = localDate.getTime() - paramDate.getTime();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    l1 /= 1000L;
    if ((l1 >= 0L) && (l1 < 60L)) {
      return jdField_a_of_type_JavaLangString;
    }
    if ((l1 >= 60L) && (l1 < 3600L)) {
      return l1 / 60L + jdField_b_of_type_JavaLangString;
    }
    if (l3 < 0L) {
      return l1 / 3600L + jdField_c_of_type_JavaLangString;
    }
    if ((l3 >= 0L) && (l3 < 86400000L)) {
      return d + a(i4) + ":" + a(i5);
    }
    if ((l3 >= 86400000L) && (l3 < 172800000L)) {
      return e + a(i4) + ":" + a(i5);
    }
    if (l3 >= 172800000L)
    {
      if (i6 + 1900 != i1) {
        return i1 + j + a(i2 + 1) + k + a(i3) + l;
      }
      return a(paramDate.getMonth() + 1) + k + a(paramDate.getDate()) + l + a(paramDate.getHours()) + ":" + a(paramDate.getMinutes());
    }
    return "";
  }
  
  public static boolean a(Date paramDate)
  {
    int i1 = paramDate.getYear();
    int i2 = paramDate.getMonth();
    int i3 = paramDate.getDate();
    paramDate = new Date();
    int i4 = paramDate.getYear();
    int i5 = paramDate.getMonth();
    int i6 = paramDate.getDate();
    return (i1 + 1900 == i4 + 1900) && (i2 + 1 == i5 + 1) && (i3 == i6);
  }
  
  public static final String b(int paramInt)
  {
    if (paramInt > 99999999) {
      return a(new Date(paramInt * 1000L));
    }
    Date localDate = new Date(paramInt * 1000L);
    return jdField_c_of_type_JavaTextSimpleDateFormat.format(localDate);
  }
  
  public static String b(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return jdField_b_of_type_JavaTextSimpleDateFormat.format(localDate);
  }
  
  public static final String b(Date paramDate)
  {
    long l4 = (new Date().getTime() - paramDate.getTime()) / 1000L;
    long l1 = l4 / 86400L;
    long l2 = l4 % 86400L / 3600L;
    long l3 = l4 % 3600L / 60L;
    l4 = l4 % 60L / 60L;
    if (l1 > 0L)
    {
      if (l1 == 1L) {
        return d + paramDate.getHours() + i + ":" + paramDate.getMinutes() + m;
      }
      if (l1 == 2L) {
        return e + paramDate.getHours() + i + ":" + paramDate.getMinutes() + m;
      }
      if (l1 < 30L) {
        return l1 + f;
      }
      if (l1 >= 30L) {
        return l1 / 30L + g;
      }
    }
    else
    {
      if ((l1 <= 0L) && (l2 >= 1L)) {
        return l2 + jdField_c_of_type_JavaLangString;
      }
      if (l3 > 0L) {
        return l3 + jdField_b_of_type_JavaLangString;
      }
      return jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String c(Date paramDate)
  {
    Date localDate = new Date();
    int i3 = localDate.getYear();
    int i4 = localDate.getMonth();
    int i5 = localDate.getDate();
    int i6 = localDate.getHours();
    int i7 = localDate.getMinutes();
    int i8 = paramDate.getYear();
    int i9 = paramDate.getMonth();
    int i10 = paramDate.getDate();
    int i1 = paramDate.getHours();
    int i2 = paramDate.getMinutes();
    if (i3 > i8) {
      return i3 - i8 + h;
    }
    if (i4 > i9) {
      return i4 - i9 + g;
    }
    if (i5 > i10)
    {
      i3 = i5 - i10;
      if (i3 == 1) {
        return d + i1 + i + ":" + i2 + m;
      }
      if (i3 == 2) {
        return e + i1 + i + ":" + i2;
      }
      return i3 + f;
    }
    if (i6 > i1) {
      return i6 - i1 + jdField_c_of_type_JavaLangString;
    }
    if (i7 > i2) {
      return i7 - i2 + jdField_b_of_type_JavaLangString;
    }
    return jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.sc.utils.DateUtil
 * JD-Core Version:    0.7.0.1
 */