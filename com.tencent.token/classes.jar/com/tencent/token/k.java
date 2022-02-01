package com.tencent.token;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.halley.common.f;
import com.tencent.halley.common.h;
import java.io.File;

public final class k
{
  public static String a;
  public static String b;
  public static String c;
  public static int d;
  public static boolean e;
  public static int f = 50;
  private static int g = 2;
  private static int h = 3;
  private static String i;
  private static volatile int j;
  private static int k = 20000;
  
  static
  {
    a = "";
    b = "";
    c = "";
    d = 5;
    i = ".temp";
    e = true;
    j = 500;
  }
  
  public static int a()
  {
    return g;
  }
  
  public static String a(String paramString)
  {
    return paramString + ".bdcfg";
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
    return paramString + i;
  }
  
  public static void b(int paramInt)
  {
    h = Math.min(Math.max(paramInt, 1), 6);
  }
  
  public static int c()
  {
    p.e();
    return 20000;
  }
  
  public static boolean c(String paramString)
  {
    return !h.a(paramString);
  }
  
  public static int d()
  {
    p.e();
    return 20000;
  }
  
  public static int e()
  {
    switch ()
    {
    case 1: 
    case 2: 
    default: 
      return 1048576;
    }
    return 524288;
  }
  
  public static int f()
  {
    return 524288;
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      m = 1;
      if (m == 0) {
        break label98;
      }
      str1 = h.e();
    }
    label98:
    for (String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + str1 + "/HalleyDownload";; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = f.a().getFilesDir().toString();
      }
      localStringBuilder.append(str2);
      return localStringBuilder.toString();
      m = 0;
      break;
    }
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
 * Qualified Name:     com.tencent.token.k
 * JD-Core Version:    0.7.0.1
 */