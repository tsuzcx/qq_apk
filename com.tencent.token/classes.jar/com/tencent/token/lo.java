package com.tencent.token;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public final class lo
{
  public int a = 0;
  public String b = "";
  
  public lo() {}
  
  public lo(int paramInt, String paramString)
  {
    this.a = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      this.b = paramString;
      return;
    }
    this.b = "";
  }
  
  public static long a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return l * i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  public static nt a(ll paramll)
  {
    paramll = new nz(paramll);
    try
    {
      paramll.b = paramll.a.a();
      return paramll;
    }
    catch (Exception localException)
    {
      paramll.e = -2;
      paramll.f = ob.a(localException);
    }
    return paramll;
  }
  
  private static String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        i = paramString1.indexOf("filename=");
        if (-1 != i)
        {
          int k = i + 9;
          int j = paramString1.indexOf(";", k);
          i = j;
          if (j == -1) {
            i = paramString1.length();
          }
          paramString1 = paramString1.substring(k, i);
        }
      }
    }
    catch (Exception paramString1)
    {
      int i;
      String str1;
      label68:
      label79:
      label109:
      paramString1.printStackTrace();
    }
    try
    {
      str1 = URLDecoder.decode(paramString1, "utf-8");
      paramString1 = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      break label68;
    }
    try
    {
      str1 = URLDecoder.decode(paramString1, "gbk");
      paramString1 = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      break label79;
      String str2 = paramString1;
      break label109;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      i = paramString1.lastIndexOf("/") + 1;
      if (i > 0)
      {
        str1 = paramString1.substring(i);
        if (!TextUtils.isEmpty(str1))
        {
          paramString1 = c(paramString1, paramString2);
          return paramString1;
        }
        return str1;
      }
    }
    else
    {
      return null;
    }
  }
  
  public static HashMap a(ns paramns)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.d);
    localHashMap.put("B50", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramns.g));
    localHashMap.put("B51", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramns.e));
    localHashMap.put("B69", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.h);
    localHashMap.put("B52", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramns.j));
    localHashMap.put("B53", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.k);
    localHashMap.put("B54", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.l);
    localHashMap.put("B55", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.m);
    localHashMap.put("B56", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramns.n))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramns.n));
      localHashMap.put("B57", localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramns.o)) && (!paramns.o.equals("null")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramns.o));
      localHashMap.put("B58", localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.p);
    localHashMap.put("B59", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.u);
    localHashMap.put("B63", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.q);
    localHashMap.put("B60", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.r);
    localHashMap.put("B61", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.s);
    localHashMap.put("B62", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramns.t);
    localHashMap.put("B71", localStringBuilder.toString());
    localHashMap.put("B76", "0");
    return localHashMap;
  }
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    try
    {
      lq.a(paramString, paramHashMap);
      label6:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("--");
      localStringBuilder.append(paramHashMap.toString());
      li.b("report:", localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      break label6;
    }
  }
  
  public static boolean a(Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      paramException = paramException.getMessage();
      if ((paramException != null) && ((paramException.contains("ENOSPC")) || (paramException.contains("No space left on device")))) {
        return true;
      }
    }
    return false;
  }
  
  public static long b()
  {
    try
    {
      String str = lp.a().getFilesDir().getAbsolutePath();
      StatFs localStatFs = new StatFs(str);
      localStatFs.restat(str);
      long l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      return l * i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        String str = Uri.decode(paramString1);
        if (str == null) {
          break label82;
        }
        int i = str.indexOf('?');
        paramString1 = str;
        if (i > 0) {
          paramString1 = str.substring(0, i);
        }
        if (paramString1.endsWith("/")) {
          break label82;
        }
        i = paramString1.lastIndexOf('/') + 1;
        if (i <= 0) {
          break label82;
        }
        paramString1 = paramString1.substring(i);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = c(paramString1, paramString2);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return null;
      label82:
      paramString1 = null;
    }
  }
  
  public static boolean b(Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      paramException = paramException.getMessage();
      if ((paramException != null) && (paramException.contains("Read-only file system"))) {
        return true;
      }
    }
    return false;
  }
  
  private static String c(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(".");
    String str3 = "";
    String str2 = str3;
    String str1 = paramString1;
    if (i > 0)
    {
      str2 = str3;
      str1 = paramString1;
      if (paramString1.length() > i + 1)
      {
        str1 = paramString1.substring(0, i);
        str2 = paramString1.substring(i);
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append(str1);
    paramString1.append(paramString2);
    paramString1.append(str2);
    return paramString1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lo
 * JD-Core Version:    0.7.0.1
 */