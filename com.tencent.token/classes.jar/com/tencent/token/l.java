package com.tencent.token;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.halley.common.f;
import com.tencent.halley.common.h;
import java.io.File;

public final class l
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static int d = 5;
  public static boolean e = true;
  public static int f = 50;
  private static int g = 2;
  private static int h = 3;
  private static String i = ".temp";
  private static volatile int j = 500;
  private static int k = 20000;
  
  public static int a()
  {
    return g;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".bdcfg");
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt)
  {
    g = Math.min(Math.max(paramInt, 1), 4);
  }
  
  public static int b()
  {
    return h;
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public static void b(int paramInt)
  {
    h = Math.min(Math.max(paramInt, 1), 6);
  }
  
  public static int c()
  {
    q.e();
    return 20000;
  }
  
  public static boolean c(String paramString)
  {
    return !h.a(paramString);
  }
  
  public static int d()
  {
    q.e();
    return 20000;
  }
  
  public static int e()
  {
    int n = q.e();
    int m = 1048576;
    switch (n)
    {
    default: 
      return 1048576;
    case 3: 
      m = 524288;
    }
    return m;
  }
  
  public static int f()
  {
    return 524288;
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      str = h.e();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/HalleyDownload");
      str = ((StringBuilder)localObject).toString();
    }
    else
    {
      str = "";
    }
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = f.a().getFilesDir().toString();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static int h()
  {
    return j;
  }
  
  public static int i()
  {
    return 60000;
  }
  
  public static int j()
  {
    return 20000;
  }
  
  public static int k()
  {
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.l
 * JD-Core Version:    0.7.0.1
 */