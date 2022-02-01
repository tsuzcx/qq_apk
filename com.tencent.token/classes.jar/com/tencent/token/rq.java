package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class rq
{
  @SuppressLint({"StaticFieldLeak"})
  private static rq c;
  Context a;
  int b = 0;
  
  private rq(Context paramContext)
  {
    this.a = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = 4;
    }
  }
  
  public static rq a(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new rq(paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public static String a()
  {
    return rk.a.a().a("tjs").a("md5", "");
  }
  
  public static void a(long paramLong)
  {
    rk.a.a().a("tjs").b("pull_all_time", paramLong);
  }
  
  public static void a(HashMap<Integer, String> paramHashMap, HashMap<Integer, Integer> paramHashMap1)
  {
    avb localavb = rk.a.a().a("tjs");
    localavb.b();
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      localavb.b(String.valueOf(i), (String)paramHashMap.get(Integer.valueOf(i)));
    }
    paramHashMap = paramHashMap1.keySet().iterator();
    while (paramHashMap.hasNext())
    {
      i = ((Integer)paramHashMap.next()).intValue();
      localavb.b(String.valueOf(i), ((Integer)paramHashMap1.get(Integer.valueOf(i))).intValue());
    }
    localavb.c();
  }
  
  public static void a(boolean paramBoolean)
  {
    rk.a.a().a("tjs").b("none", paramBoolean);
  }
  
  public static void b(boolean paramBoolean)
  {
    rk.a.a().a("tjs").b("k_l_l_s_s", paramBoolean);
  }
  
  public static boolean b()
  {
    return rk.a.a().a("tjs").a("cloud", false);
  }
  
  public static void c()
  {
    rk.a.a().a("tjs").b("cloud", true);
  }
  
  public static boolean d()
  {
    return rk.a.a().a("tjs").a("none", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rq
 * JD-Core Version:    0.7.0.1
 */