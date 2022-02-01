package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

public class TGlobalHelper
{
  private static Context a;
  private static volatile String b;
  public static String curProcessName;
  
  /* Error */
  private static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 22	com/tencent/tpns/dataacquisition/DeviceInfos:getDM	()Ljava/lang/String;
    //   21: putstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   24: getstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   27: astore_0
    //   28: goto -15 -> 13
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	16	0	str	String
    //   31	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	31	finally
    //   18	28	31	finally
  }
  
  /* Error */
  public static String getDM(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: astore_1
    //   20: aload_0
    //   21: ifnonnull +7 -> 28
    //   24: getstatic 27	com/tencent/tpns/baseapi/base/util/TGlobalHelper:a	Landroid/content/Context;
    //   27: astore_1
    //   28: aload_1
    //   29: invokestatic 33	com/tencent/tpns/baseapi/base/util/Util:isMainProcess	(Landroid/content/Context;)Z
    //   32: ifne +35 -> 67
    //   35: aload_1
    //   36: ldc 35
    //   38: ldc 37
    //   40: invokestatic 43	com/tencent/tpns/baseapi/base/PushPreferences:getObject	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   43: checkcast 45	java/lang/String
    //   46: putstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   49: getstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   52: ifnonnull +8 -> 60
    //   55: ldc 37
    //   57: putstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   60: getstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   63: astore_0
    //   64: goto -51 -> 13
    //   67: invokestatic 22	com/tencent/tpns/dataacquisition/DeviceInfos:getDM	()Ljava/lang/String;
    //   70: putstatic 17	com/tencent/tpns/baseapi/base/util/TGlobalHelper:b	Ljava/lang/String;
    //   73: goto -24 -> 49
    //   76: astore_0
    //   77: ldc 47
    //   79: new 49	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   86: ldc 52
    //   88: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 68	com/tencent/tpns/baseapi/base/logger/TBaseLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -52 -> 49
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramContext	Context
    //   19	17	1	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   28	49	76	java/lang/Throwable
    //   67	73	76	java/lang/Throwable
    //   3	13	104	finally
    //   24	28	104	finally
    //   28	49	104	finally
    //   49	60	104	finally
    //   60	64	104	finally
    //   67	73	104	finally
    //   77	101	104	finally
  }
  
  public static Object loadWithIPC(String paramString)
  {
    if (Util.isNullOrEmptyString(paramString)) {
      return null;
    }
    if ("dm".equals(paramString)) {
      return a();
    }
    TBaseLogger.d("TGlobalHelper", "don't support type");
    return null;
  }
  
  public static void setContext(Context paramContext)
  {
    a = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.TGlobalHelper
 * JD-Core Version:    0.7.0.1
 */