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

public final class mi
{
  public int a = 0;
  public String b = "";
  
  public mi() {}
  
  public mi(int paramInt, String paramString)
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
  
  public static on a(mf parammf)
  {
    parammf = new ot(parammf);
    try
    {
      parammf.b = parammf.a.a();
      return parammf;
    }
    catch (Exception localException)
    {
      parammf.e = -2;
      parammf.f = ov.a(localException);
    }
    return parammf;
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
  
  public static HashMap a(om paramom)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.d);
    localHashMap.put("B50", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramom.g));
    localHashMap.put("B51", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramom.e));
    localHashMap.put("B69", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.h);
    localHashMap.put("B52", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramom.j));
    localHashMap.put("B53", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.k);
    localHashMap.put("B54", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.l);
    localHashMap.put("B55", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.m);
    localHashMap.put("B56", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramom.n))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramom.n));
      localHashMap.put("B57", localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramom.o)) && (!paramom.o.equals("null")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramom.o));
      localHashMap.put("B58", localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.p);
    localHashMap.put("B59", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.u);
    localHashMap.put("B63", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.q);
    localHashMap.put("B60", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.r);
    localHashMap.put("B61", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.s);
    localHashMap.put("B62", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramom.t);
    localHashMap.put("B71", localStringBuilder.toString());
    localHashMap.put("B76", "0");
    return localHashMap;
  }
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    try
    {
      mk.a(paramString, paramHashMap);
      label6:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("--");
      localStringBuilder.append(paramHashMap.toString());
      mc.b("report:", localStringBuilder.toString());
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
      String str = mj.a().getFilesDir().getAbsolutePath();
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
 * Qualified Name:     com.tencent.token.mi
 * JD-Core Version:    0.7.0.1
 */