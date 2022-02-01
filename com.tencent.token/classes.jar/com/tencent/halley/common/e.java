package com.tencent.halley.common;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.halley.common.b.d;
import com.tencent.token.bi;
import com.tencent.token.bj;
import com.tencent.token.bp;
import com.tencent.token.br;
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
      return l * i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  public static bj a(d paramd)
  {
    paramd = new bp(paramd);
    try
    {
      paramd.i();
      return paramd;
    }
    catch (Exception localException)
    {
      paramd.b = -2;
      paramd.c = br.a(localException);
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
        paramString1 = new StringBuilder("downloadfile");
        paramString1.append(paramString4);
        paramString3 = paramString1.toString();
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = paramString3;
          if (paramString2.equalsIgnoreCase("application/vnd.android.package-archive"))
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramString3);
            paramString1.append(".apk");
            paramString1 = paramString1.toString();
          }
        }
        paramString3 = paramString1;
      }
    }
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString3.replace("?", "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "");
    }
    return paramString1;
  }
  
  public static HashMap a(bi parambi)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.d);
    localHashMap.put("B50", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(parambi.g));
    localHashMap.put("B51", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(parambi.e));
    localHashMap.put("B69", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.h);
    localHashMap.put("B52", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(parambi.j));
    localHashMap.put("B53", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.k);
    localHashMap.put("B54", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.l);
    localHashMap.put("B55", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.m);
    localHashMap.put("B56", localStringBuilder.toString());
    if (!TextUtils.isEmpty(parambi.n))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(parambi.n));
      localHashMap.put("B57", localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(parambi.o)) && (!parambi.o.equals("null")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(parambi.o));
      localHashMap.put("B58", localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.p);
    localHashMap.put("B59", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.u);
    localHashMap.put("B63", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.q);
    localHashMap.put("B60", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.r);
    localHashMap.put("B61", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.s);
    localHashMap.put("B62", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambi.t);
    localHashMap.put("B71", localStringBuilder.toString());
    parambi = new StringBuilder();
    parambi.append(0);
    localHashMap.put("B76", parambi.toString());
    return localHashMap;
  }
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    try
    {
      g.a(paramString, true, 0L, 0L, paramHashMap, true);
      label10:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("--");
      localStringBuilder.append(paramHashMap.toString());
      b.b("report:", localStringBuilder.toString());
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
      return l * i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  private static String b(String paramString1, String paramString2)
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
    paramString1 = new StringBuilder();
    paramString1.append(str1);
    paramString1.append(paramString2);
    paramString1.append(str2);
    return paramString1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.e
 * JD-Core Version:    0.7.0.1
 */