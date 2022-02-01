package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MsfStore
{
  static NativeConfigStore nativeConfigStore = null;
  public static int sLoadCfg = 0;
  private static String tag = "MSF.C.MsfStore";
  
  public static NativeConfigStore getNativeConfigStore()
  {
    return nativeConfigStore;
  }
  
  public String get(String paramString)
  {
    return null;
  }
  
  public String[] getArray(String paramString)
  {
    return null;
  }
  
  /* Error */
  public boolean init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new 36	com/tencent/msf/boot/config/NativeConfigStore
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 39	com/tencent/msf/boot/config/NativeConfigStore:<init>	(Landroid/content/Context;)V
    //   12: putstatic 14	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   15: aload_1
    //   16: invokestatic 45	com/tencent/mobileqq/msf/core/c:a	(Landroid/content/Context;)Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnonnull +32 -> 53
    //   24: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +12 -> 39
    //   30: getstatic 18	com/tencent/mobileqq/msf/core/MsfStore:tag	Ljava/lang/String;
    //   33: iconst_2
    //   34: ldc 53
    //   36: invokestatic 57	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: getstatic 14	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   42: getfield 61	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   45: iconst_0
    //   46: invokevirtual 67	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   49: aload_0
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: getstatic 14	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   56: aload_3
    //   57: invokevirtual 71	com/tencent/msf/boot/config/NativeConfigStore:setSaveRootPath	(Ljava/lang/String;)V
    //   60: getstatic 14	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   63: aload_1
    //   64: iconst_0
    //   65: invokevirtual 75	com/tencent/msf/boot/config/NativeConfigStore:loadConfig	(Landroid/content/Context;Z)I
    //   68: putstatic 20	com/tencent/mobileqq/msf/core/MsfStore:sLoadCfg	I
    //   71: iconst_1
    //   72: istore_2
    //   73: goto -24 -> 49
    //   76: astore_1
    //   77: getstatic 18	com/tencent/mobileqq/msf/core/MsfStore:tag	Ljava/lang/String;
    //   80: iconst_1
    //   81: new 77	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   88: ldc 80
    //   90: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: aload_1
    //   101: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: goto -55 -> 49
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	MsfStore
    //   0	112	1	paramContext	android.content.Context
    //   1	72	2	bool	boolean
    //   19	38	3	str	String
    // Exception table:
    //   from	to	target	type
    //   53	71	76	java/lang/Throwable
    //   4	20	107	finally
    //   24	39	107	finally
    //   39	49	107	finally
    //   53	71	107	finally
    //   77	104	107	finally
  }
  
  public void reportLoadCfgTempFile()
  {
    if (sLoadCfg != 0)
    {
      HashMap localHashMap = new HashMap(8);
      localHashMap.put("ret", sLoadCfg + "");
      MsfCore.sCore.statReporter.a("EvtLodCfgTempFileReport", true, 0L, 0L, localHashMap, false, false);
      QLog.d(tag, 1, "check load config find temp file");
    }
  }
  
  public void save(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.MsfStore
 * JD-Core Version:    0.7.0.1
 */