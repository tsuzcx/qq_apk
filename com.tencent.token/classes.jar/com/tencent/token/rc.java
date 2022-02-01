package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class rc
{
  @SuppressLint({"StaticFieldLeak"})
  private static rc c;
  Context a;
  int b = 0;
  
  private rc(Context paramContext)
  {
    this.a = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = 4;
    }
  }
  
  public static rc a(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new rc(paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public static String a()
  {
    return qw.a.a().a("tjs").a("md5", "");
  }
  
  public static void a(long paramLong)
  {
    qw.a.a().a("tjs").b("pull_all_time", paramLong);
  }
  
  public static void a(HashMap<Integer, String> paramHashMap, HashMap<Integer, Integer> paramHashMap1)
  {
    aud localaud = qw.a.a().a("tjs");
    localaud.b();
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      localaud.b(String.valueOf(i), (String)paramHashMap.get(Integer.valueOf(i)));
    }
    paramHashMap = paramHashMap1.keySet().iterator();
    while (paramHashMap.hasNext())
    {
      i = ((Integer)paramHashMap.next()).intValue();
      localaud.b(String.valueOf(i), ((Integer)paramHashMap1.get(Integer.valueOf(i))).intValue());
    }
    localaud.c();
  }
  
  public static void a(boolean paramBoolean)
  {
    qw.a.a().a("tjs").b("none", paramBoolean);
  }
  
  public static void b(boolean paramBoolean)
  {
    qw.a.a().a("tjs").b("k_l_l_s_s", paramBoolean);
  }
  
  public static boolean b()
  {
    return qw.a.a().a("tjs").a("cloud", false);
  }
  
  public static void c()
  {
    qw.a.a().a("tjs").b("cloud", true);
  }
  
  public static boolean d()
  {
    return qw.a.a().a("tjs").a("none", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rc
 * JD-Core Version:    0.7.0.1
 */