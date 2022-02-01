package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class v
{
  protected static String b = "NA";
  protected Context a = null;
  
  public v(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private StringBuffer a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if ((paramString[i] > ' ') && (paramString[i] != '/') && (paramString[i] != '_') && (paramString[i] != '&') && (paramString[i] != '|') && (paramString[i] != '-')) {
        localStringBuffer.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuffer;
  }
  
  public static String b()
  {
    if ("1002".contains("BuildNo")) {
      return "0000";
    }
    return "1002";
  }
  
  private int c()
  {
    if (e()) {
      return 0;
    }
    return this.a.getResources().getDisplayMetrics().widthPixels;
  }
  
  private int d()
  {
    if (e()) {
      return 0;
    }
    return this.a.getResources().getDisplayMetrics().heightPixels;
  }
  
  private boolean e()
  {
    if (this.a == null) {}
    while ((this.a.getResources() == null) || (this.a.getResources().getDisplayMetrics() == null)) {
      return true;
    }
    return false;
  }
  
  private int f()
  {
    return 0;
  }
  
  private String g()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(Build.BRAND));
    localStringBuffer.append("_");
    localStringBuffer.append(a(Build.MODEL));
    return localStringBuffer.toString();
  }
  
  private String h()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Build.VERSION.RELEASE;
    if (TextUtils.isEmpty(str)) {
      localStringBuffer.append("NA");
    }
    for (;;)
    {
      localStringBuffer.append("_");
      localStringBuffer.append(Build.VERSION.SDK_INT);
      return localStringBuffer.toString();
      localStringBuffer.append(str);
    }
  }
  
  public String a()
  {
    u localu = new u();
    localu.c = b();
    localu.d = "";
    localu.e = b;
    localu.f = h();
    localu.h = d();
    localu.g = c();
    localu.i = f();
    localu.a = g();
    localu.b = "1002";
    return localu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.v
 * JD-Core Version:    0.7.0.1
 */