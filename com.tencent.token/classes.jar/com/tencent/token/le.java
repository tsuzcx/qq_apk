package com.tencent.token;

import android.telephony.PhoneStateListener;

public final class le
{
  private static volatile boolean a = false;
  private static PhoneStateListener b = new lf();
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 26	com/tencent/token/lo:a	()Landroid/content/Context;
    //   6: ldc 28
    //   8: invokevirtual 34	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11: checkcast 36	android/telephony/TelephonyManager
    //   14: getstatic 18	com/tencent/token/le:b	Landroid/telephony/PhoneStateListener;
    //   17: bipush 64
    //   19: invokevirtual 40	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: goto -5 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	5	0	localObject	Object
    //   36	1	0	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	22	26	finally
    //   3	22	36	java/lang/Exception
  }
  
  public static boolean b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.le
 * JD-Core Version:    0.7.0.1
 */