package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;

public class NearPeopleFilterActivity$NearPeopleFilters
{
  public static final int a = 0;
  public static final String[] a;
  public static final int b = 1;
  public static final String b = "nearpeople_filters";
  public static final String[] b = { "不限", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
  public static final int c = 2;
  public static final String c = "gender";
  public static final int d = 0;
  public static final String d = "time";
  public static final int e = 1;
  public static final String e = "age";
  public static final int f = 2;
  public static final String f = "xingzuo";
  public static final int g = 3;
  public static final String g = "key_career";
  public static final int h = 4;
  public static final String h = "key_hometown_country";
  public static final String i = "key_hometown_province";
  public static final String j = "key_hometown_city";
  public static final String k = "key_hometown_string";
  public String a;
  public String[] c = { "0", "0", "0", "0" };
  public int i;
  public int j;
  public int k;
  public int l;
  public int m = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
  }
  
  public NearPeopleFilterActivity$NearPeopleFilters()
  {
    this.jdField_a_of_type_JavaLangString = "不限";
  }
  
  public static NearPeopleFilters a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return null;
        paramContext = paramContext.getSharedPreferences("nearpeople_filters" + paramString, 0);
      } while (paramContext == null);
      paramString = new NearPeopleFilters();
      paramString.i = paramContext.getInt("gender", -1);
    } while (paramString.i == -1);
    paramString.k = paramContext.getInt("age", 0);
    paramString.j = paramContext.getInt("time", 0);
    paramString.l = paramContext.getInt("xingzuo", 0);
    paramString.m = paramContext.getInt("key_career", 0);
    paramString.c[0] = paramContext.getString("key_hometown_country", "0");
    paramString.c[1] = paramContext.getString("key_hometown_province", "0");
    paramString.c[2] = paramContext.getString("key_hometown_city", "0");
    paramString.jdField_a_of_type_JavaLangString = paramContext.getString("key_hometown_string", "不限");
    if ("-1".equals(paramString.c[0])) {
      paramString.c[0] = "0";
    }
    if ("-1".equals(paramString.c[1])) {
      paramString.c[1] = "0";
    }
    if ("-1".equals(paramString.c[2])) {
      paramString.c[2] = "0";
    }
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, NearPeopleFilters paramNearPeopleFilters)
  {
    if ((paramNearPeopleFilters == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences("nearpeople_filters" + paramString, 0);
    } while (paramContext == null);
    paramContext.edit().putInt("gender", paramNearPeopleFilters.i).putInt("time", paramNearPeopleFilters.j).putInt("age", paramNearPeopleFilters.k).putInt("xingzuo", paramNearPeopleFilters.l).putInt("key_career", paramNearPeopleFilters.m).putString("key_hometown_country", paramNearPeopleFilters.c[0]).putString("key_hometown_province", paramNearPeopleFilters.c[1]).putString("key_hometown_city", paramNearPeopleFilters.c[2]).putString("key_hometown_string", paramNearPeopleFilters.jdField_a_of_type_JavaLangString).commit();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    String[] arrayOfString = this.c;
    int i2 = arrayOfString.length;
    int i1 = 0;
    int n = 1;
    while (i1 < i2)
    {
      if (!arrayOfString[i1].equals("0")) {
        n = 0;
      }
      i1 += 1;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("不限")) {
      n = 0;
    }
    boolean bool1 = bool2;
    if (n != 0)
    {
      bool1 = bool2;
      if (this.i == 0) {
        if (this.j != 4)
        {
          bool1 = bool2;
          if (this.j != 0) {}
        }
        else
        {
          bool1 = bool2;
          if (this.k == 0)
          {
            bool1 = bool2;
            if (this.l == 0)
            {
              bool1 = bool2;
              if (this.m == 0) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("筛选：");
    String str1;
    int n;
    switch (this.i)
    {
    case 0: 
    default: 
      if ((this.k != 0) && (this.k < jdField_a_of_type_ArrayOfJavaLangString.length)) {
        localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[this.k] + ",");
      }
      if ((this.m != 0) && (this.m < NearbyProfileUtil.e.length))
      {
        String str2 = NearbyProfileUtil.e[this.m];
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "其他";
        }
        localStringBuilder.append(str1 + ",");
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals("不限")))
      {
        n = this.jdField_a_of_type_JavaLangString.lastIndexOf("-");
        if (n > 0)
        {
          str1 = this.jdField_a_of_type_JavaLangString.substring(n + 1);
          label209:
          localStringBuilder.append(str1 + ",");
        }
      }
      else
      {
        if ((this.l != 0) && (this.l < b.length)) {
          localStringBuilder.append(b[this.l] + ",");
        }
        switch (this.j)
        {
        }
      }
      break;
    }
    for (;;)
    {
      str1 = localStringBuilder.toString();
      if (TextUtils.isEmpty(str1)) {
        break label415;
      }
      n = localStringBuilder.lastIndexOf(",");
      if (n <= 0) {
        break label415;
      }
      return str1.substring(0, n);
      localStringBuilder.append("男,");
      break;
      localStringBuilder.append("女,");
      break;
      str1 = this.jdField_a_of_type_JavaLangString;
      break label209;
      localStringBuilder.append("30分钟内,");
      continue;
      localStringBuilder.append("1个小时内,");
      continue;
      localStringBuilder.append("4小时内,");
    }
    label415:
    return "全部";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters
 * JD-Core Version:    0.7.0.1
 */