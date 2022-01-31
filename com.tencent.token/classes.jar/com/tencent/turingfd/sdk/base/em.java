package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import java.util.HashSet;
import java.util.Set;

public class em
{
  public static au a;
  public static aw b;
  public static Set c = new HashSet();
  public static final au d = new dl();
  public static aw e = new dq();
  
  public static void a()
  {
    ba.f = true;
  }
  
  public static void a(Activity paramActivity)
  {
    c.add(paramActivity.getClass().getName());
    ba.g.add(paramActivity.getClass().getName());
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, au paramau, aw paramaw)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: putstatic 61	com/tencent/turingfd/sdk/base/em:a	Lcom/tencent/turingfd/sdk/base/au;
    //   7: aload_2
    //   8: putstatic 63	com/tencent/turingfd/sdk/base/em:b	Lcom/tencent/turingfd/sdk/base/aw;
    //   11: aload_0
    //   12: invokevirtual 69	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: astore_0
    //   16: getstatic 31	com/tencent/turingfd/sdk/base/em:e	Lcom/tencent/turingfd/sdk/base/aw;
    //   19: putstatic 70	com/tencent/turingfd/sdk/base/ba:e	Lcom/tencent/turingfd/sdk/base/aw;
    //   22: getstatic 72	com/tencent/turingfd/sdk/base/ba:a	Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifeq +7 -> 34
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: iconst_1
    //   35: putstatic 72	com/tencent/turingfd/sdk/base/ba:a	Z
    //   38: invokestatic 74	com/tencent/turingfd/sdk/base/ba:a	()V
    //   41: aload_0
    //   42: checkcast 76	android/app/Application
    //   45: invokestatic 79	com/tencent/turingfd/sdk/base/ba:a	(Landroid/app/Application;)V
    //   48: goto -18 -> 30
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	android.content.Context
    //   0	57	1	paramau	au
    //   0	57	2	paramaw	aw
    //   25	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	26	51	finally
    //   34	48	51	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.em
 * JD-Core Version:    0.7.0.1
 */