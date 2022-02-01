package com.tencent.halley.common;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.halley.common.b.d;
import com.tencent.token.bh;
import com.tencent.token.bi;
import com.tencent.token.bo;
import com.tencent.token.bq;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class e
{
  public int a = 0;
  public String b = "";
  
  public e() {}
  
  public e(int paramInt, String paramString)
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
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  public static bi a(d paramd)
  {
    paramd = new bo(paramd);
    try
    {
      paramd.i();
      return paramd;
    }
    catch (Exception localException)
    {
      paramd.b = -2;
      paramd.c = bq.a(localException);
    }
    return paramd;
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
    }
    return str;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        i = paramString1.indexOf("filename=");
        if (-1 == i) {
          break;
        }
        int k = i + 9;
        int j = paramString1.indexOf(";", k);
        i = j;
        if (j == -1) {
          i = paramString1.length();
        }
        paramString1 = paramString1.substring(k, i);
      }
      catch (Exception paramString1)
      {
        try
        {
          int i;
          String str1;
          String str4;
          String str2 = URLDecoder.decode(paramString1, "gbk");
          paramString1 = str2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2) {}
        paramString1 = paramString1;
        paramString1.printStackTrace();
        return null;
      }
      try
      {
        str1 = URLDecoder.decode(paramString1, "utf-8");
        paramString1 = str1;
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        i = paramString1.lastIndexOf("/") + 1;
        if (i <= 0) {
          break label142;
        }
        str1 = paramString1.substring(i);
        str4 = str1;
        if (!TextUtils.isEmpty(str1)) {
          str4 = c(paramString1, paramString2);
        }
        return str4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1) {}
      continue;
      label142:
      String str3 = paramString1;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = a(paramString3, paramString4);
    paramString3 = str;
    if (str == null)
    {
      paramString1 = b(paramString1, paramString4);
      paramString3 = paramString1;
      if (paramString1 == null)
      {
        paramString1 = "downloadfile" + paramString4;
        paramString3 = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString1;
          if (paramString2.equalsIgnoreCase("application/vnd.android.package-archive")) {
            paramString3 = paramString1 + ".apk";
          }
        }
      }
    }
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString3.replace("?", "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "");
    }
    return paramString1;
  }
  
  public static HashMap a(bh parambh)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("B50", parambh.d);
    localHashMap.put("B51", a(parambh.g));
    localHashMap.put("B69", a(parambh.e));
    localHashMap.put("B52", parambh.h);
    localHashMap.put("B53", a(parambh.j));
    localHashMap.put("B54", parambh.k);
    localHashMap.put("B55", parambh.l);
    localHashMap.put("B56", parambh.m);
    if (!TextUtils.isEmpty(parambh.n)) {
      localHashMap.put("B57", a(parambh.n));
    }
    if ((!TextUtils.isEmpty(parambh.o)) && (!parambh.o.equals("null"))) {
      localHashMap.put("B58", a(parambh.o));
    }
    localHashMap.put("B59", parambh.p);
    localHashMap.put("B63", parambh.u);
    localHashMap.put("B60", parambh.q);
    localHashMap.put("B61", parambh.r);
    localHashMap.put("B62", parambh.s);
    localHashMap.put("B71", parambh.t);
    localHashMap.put("B76", 0);
    return localHashMap;
  }
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    try
    {
      g.a(paramString, true, 0L, 0L, paramHashMap, true);
      label10:
      b.b("report:", paramString + "--" + paramHashMap.toString());
      return;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
  
  public static boolean a(Exception paramException)
  {
    if ((paramException != null) && ((paramException instanceof IOException)))
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
      String str = f.a().getFilesDir().getAbsolutePath();
      StatFs localStatFs = new StatFs(str);
      localStatFs.restat(str);
      long l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    String str1 = null;
    for (;;)
    {
      try
      {
        String str2 = Uri.decode(paramString1);
        if (str2 != null)
        {
          int i = str2.indexOf('?');
          paramString1 = str2;
          if (i > 0) {
            paramString1 = str2.substring(0, i);
          }
          if (!paramString1.endsWith("/"))
          {
            i = paramString1.lastIndexOf('/') + 1;
            if (i > 0)
            {
              paramString1 = paramString1.substring(i);
              if (!TextUtils.isEmpty(paramString1)) {
                str1 = c(paramString1, paramString2);
              }
              return str1;
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      paramString1 = null;
    }
  }
  
  public static boolean b(Exception paramException)
  {
    if ((paramException != null) && ((paramException instanceof IOException)))
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
    return str1 + paramString2 + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.e
 * JD-Core Version:    0.7.0.1
 */