package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.util.HashSet;
import java.util.Set;

public class al
{
  public static f a;
  public static h b;
  public static Set<String> c = new HashSet();
  public static final f d = new b();
  public static h e = new a();
  
  public static void a()
  {
    i.f = true;
  }
  
  public static void a(Activity paramActivity)
  {
    c.add(paramActivity.getClass().getName());
    i.g.add(paramActivity.getClass().getName());
  }
  
  public static void a(Context paramContext, f paramf, h paramh)
  {
    try
    {
      a = paramf;
      b = paramh;
      paramContext = paramContext.getApplicationContext();
      i.e = e;
      if (!i.a)
      {
        i.a = true;
        i.a();
        i.a((Application)paramContext);
      }
      return;
    }
    finally {}
  }
  
  public static final class a
    implements h
  {
    public void a(Activity paramActivity)
    {
      h localh = al.b;
      if (localh != null) {
        localh.a(paramActivity);
      }
      int i;
      if (al.c.contains(paramActivity.getClass().getName())) {
        i = 100;
      } else {
        i = 999;
      }
      ((c)c.a.b()).a(paramActivity, i, al.d);
    }
    
    public void b(Activity paramActivity)
    {
      ((c)c.a.b()).a(paramActivity);
    }
  }
  
  public static final class b
    implements f
  {
    public void a(String paramString, int paramInt1, int paramInt2, Lemon paramLemon)
    {
      f localf = al.a;
      if (localf != null) {
        localf.a(paramString, paramInt1, paramInt2, paramLemon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.al
 * JD-Core Version:    0.7.0.1
 */