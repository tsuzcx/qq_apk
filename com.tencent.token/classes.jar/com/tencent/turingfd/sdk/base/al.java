package com.tencent.turingfd.sdk.base;

import android.app.Activity;
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
  
  /* Error */
  public static void a(android.content.Context paramContext, f paramf, h paramh)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: putstatic 62	com/tencent/turingfd/sdk/base/al:a	Lcom/tencent/turingfd/sdk/base/f;
    //   7: aload_2
    //   8: putstatic 64	com/tencent/turingfd/sdk/base/al:b	Lcom/tencent/turingfd/sdk/base/h;
    //   11: aload_0
    //   12: invokevirtual 70	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: astore_0
    //   16: getstatic 32	com/tencent/turingfd/sdk/base/al:e	Lcom/tencent/turingfd/sdk/base/h;
    //   19: putstatic 71	com/tencent/turingfd/sdk/base/i:e	Lcom/tencent/turingfd/sdk/base/h;
    //   22: getstatic 73	com/tencent/turingfd/sdk/base/i:a	Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifeq +7 -> 34
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: iconst_1
    //   35: putstatic 73	com/tencent/turingfd/sdk/base/i:a	Z
    //   38: invokestatic 75	com/tencent/turingfd/sdk/base/i:a	()V
    //   41: aload_0
    //   42: checkcast 77	android/app/Application
    //   45: invokestatic 80	com/tencent/turingfd/sdk/base/i:a	(Landroid/app/Application;)V
    //   48: goto -18 -> 30
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	android.content.Context
    //   0	57	1	paramf	f
    //   0	57	2	paramh	h
    //   25	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	26	51	finally
    //   34	48	51	finally
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
      if (al.c.contains(paramActivity.getClass().getName())) {}
      for (int i = 100;; i = 999)
      {
        ((c)c.a.b()).a(paramActivity, i, al.d);
        return;
      }
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