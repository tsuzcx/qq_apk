package com.tencent.token;

import android.telephony.PhoneStateListener;

public final class s
{
  private static volatile boolean a = false;
  private static PhoneStateListener b = new t();
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 27	com/tencent/halley/common/h:a	()Landroid/content/Context;
    //   6: ldc 29
    //   8: invokevirtual 35	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11: checkcast 37	android/telephony/TelephonyManager
    //   14: getstatic 19	com/tencent/token/s:b	Landroid/telephony/PhoneStateListener;
    //   17: bipush 64
    //   19: invokevirtual 41	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    //   32: astore_0
    //   33: goto -11 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	5	0	localObject	Object
    //   32	1	0	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	22	26	finally
    //   3	22	32	java/lang/Exception
  }
  
  public static boolean b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.s
 * JD-Core Version:    0.7.0.1
 */