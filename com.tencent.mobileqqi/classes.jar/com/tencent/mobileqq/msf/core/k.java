package com.tencent.mobileqq.msf.core;

import com.tencent.msf.boot.config.NativeConfigStore;

public class k
{
  static NativeConfigStore a = null;
  private static String c = "MSF.C.MsfStore";
  MsfCore b;
  
  public k(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
  }
  
  public static NativeConfigStore a()
  {
    return a;
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  public void a(String paramString1, String paramString2) {}
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new 33	com/tencent/msf/boot/config/NativeConfigStore
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 36	com/tencent/msf/boot/config/NativeConfigStore:<init>	(Landroid/content/Context;)V
    //   12: putstatic 14	com/tencent/mobileqq/msf/core/k:a	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   15: aload_1
    //   16: invokestatic 41	com/tencent/mobileqq/msf/core/c:a	(Landroid/content/Context;)Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnonnull +32 -> 53
    //   24: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +12 -> 39
    //   30: getstatic 18	com/tencent/mobileqq/msf/core/k:c	Ljava/lang/String;
    //   33: iconst_2
    //   34: ldc 49
    //   36: invokestatic 53	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: getstatic 14	com/tencent/mobileqq/msf/core/k:a	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   42: getfield 57	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   45: iconst_0
    //   46: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   49: aload_0
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: getstatic 14	com/tencent/mobileqq/msf/core/k:a	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   56: aload_3
    //   57: invokevirtual 67	com/tencent/msf/boot/config/NativeConfigStore:setSaveRootPath	(Ljava/lang/String;)V
    //   60: getstatic 14	com/tencent/mobileqq/msf/core/k:a	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   63: aload_1
    //   64: iconst_0
    //   65: invokevirtual 71	com/tencent/msf/boot/config/NativeConfigStore:loadConfig	(Landroid/content/Context;Z)V
    //   68: iconst_1
    //   69: istore_2
    //   70: goto -21 -> 49
    //   73: astore_1
    //   74: getstatic 18	com/tencent/mobileqq/msf/core/k:c	Ljava/lang/String;
    //   77: iconst_1
    //   78: new 73	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   85: ldc 76
    //   87: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aload_1
    //   98: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: goto -52 -> 49
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	k
    //   0	109	1	paramContext	android.content.Context
    //   1	69	2	bool	boolean
    //   19	38	3	str	String
    // Exception table:
    //   from	to	target	type
    //   53	68	73	java/lang/Throwable
    //   4	20	104	finally
    //   24	39	104	finally
    //   39	49	104	finally
    //   53	68	104	finally
    //   74	101	104	finally
  }
  
  public String[] b(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k
 * JD-Core Version:    0.7.0.1
 */