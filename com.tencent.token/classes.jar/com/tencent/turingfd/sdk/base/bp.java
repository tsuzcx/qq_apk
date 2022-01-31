package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class bp
{
  public Handler a;
  
  public bp(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("turingfd_conf_105678_32_baseFull", 0);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("turingfd_conf_105678_32_baseFull", 0);
    if (paramContext == null) {
      paramContext = "";
    }
    do
    {
      return paramContext;
      paramString = paramContext.getString(paramString, "");
      paramContext = paramString;
    } while (TextUtils.isEmpty(paramString));
    try
    {
      int j = paramString.length() / 2;
      paramContext = new byte[j];
      paramString = paramString.toUpperCase().toCharArray();
      int i = 0;
      while (i < j)
      {
        int k = i * 2;
        int m = paramString[k];
        m = (byte)"0123456789ABCDEF".indexOf(m);
        k = paramString[(k + 1)];
        paramContext[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(k) | m << 4));
        i += 1;
      }
      paramContext = ed.b(paramContext, ed.c());
      paramContext = new String(paramContext, "UTF-8");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public void a(Context paramContext, int paramInt, long paramLong)
  {
    a(paramContext, "202", paramInt + "_" + paramLong);
  }
  
  public void a(Context paramContext, long paramLong)
  {
    a(paramContext, "204", "" + paramLong);
  }
  
  public void a(Context paramContext, bg parambg)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("101", parambg.b);
    localHashMap.put("102", "" + parambg.c);
    if (!TextUtils.isEmpty(parambg.f)) {
      localHashMap.put("104", parambg.f);
    }
    if (!TextUtils.isEmpty(parambg.g)) {
      localHashMap.put("105", parambg.g);
    }
    if (!TextUtils.isEmpty(parambg.h)) {
      localHashMap.put("106", parambg.h);
    }
    this.a.post(new bo(this, paramContext, localHashMap));
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    this.a.post(new bo(this, paramContext, localHashMap));
  }
  
  public bg b(Context paramContext)
  {
    String str1 = a(paramContext, "101");
    if (TextUtils.isEmpty(str1)) {
      return bg.a(1);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(a(paramContext, "102")).longValue();
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      label40:
      String str2;
      String str3;
      bh localbh;
      break label40;
    }
    str2 = a(paramContext, "104");
    str3 = a(paramContext, "105");
    paramContext = a(paramContext, "106");
    localbh = bg.b(0);
    localbh.b = l1;
    localbh.a = str1;
    localbh.e = str2;
    localbh.f = str3;
    localbh.g = paramContext;
    return localbh.a();
  }
  
  public void b(Context paramContext, long paramLong)
  {
    a(paramContext, "203", "" + paramLong);
  }
  
  public String c(Context paramContext)
  {
    return a(paramContext, "203");
  }
  
  public void c(Context paramContext, long paramLong)
  {
    a(paramContext, "201", "" + paramLong);
  }
  
  public String d(Context paramContext)
  {
    return a(paramContext, "202");
  }
  
  public String e(Context paramContext)
  {
    return a(paramContext, "201");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bp
 * JD-Core Version:    0.7.0.1
 */