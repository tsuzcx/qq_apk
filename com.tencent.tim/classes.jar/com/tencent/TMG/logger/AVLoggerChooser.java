package com.tencent.TMG.logger;

public class AVLoggerChooser
{
  private static Logger sLogger = null;
  private static boolean sUseImsdk = true;
  
  /* Error */
  public static Logger getLogger()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 14	com/tencent/TMG/logger/AVLoggerChooser:sLogger	Lcom/tencent/TMG/logger/Logger;
    //   8: ifnull +12 -> 20
    //   11: getstatic 14	com/tencent/TMG/logger/AVLoggerChooser:sLogger	Lcom/tencent/TMG/logger/Logger;
    //   14: astore_1
    //   15: ldc 2
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: getstatic 12	com/tencent/TMG/logger/AVLoggerChooser:sUseImsdk	Z
    //   23: istore_0
    //   24: iload_0
    //   25: ifeq +40 -> 65
    //   28: ldc 28
    //   30: invokestatic 34	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +18 -> 53
    //   38: aconst_null
    //   39: astore_1
    //   40: goto -25 -> 15
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 37	java/lang/ClassNotFoundException:printStackTrace	()V
    //   48: aconst_null
    //   49: astore_1
    //   50: goto -16 -> 34
    //   53: aload_1
    //   54: invokevirtual 41	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   57: checkcast 43	com/tencent/TMG/logger/Logger
    //   60: astore_1
    //   61: aload_1
    //   62: putstatic 14	com/tencent/TMG/logger/AVLoggerChooser:sLogger	Lcom/tencent/TMG/logger/Logger;
    //   65: getstatic 14	com/tencent/TMG/logger/AVLoggerChooser:sLogger	Lcom/tencent/TMG/logger/Logger;
    //   68: astore_1
    //   69: goto -54 -> 15
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 44	java/lang/InstantiationException:printStackTrace	()V
    //   77: aload_2
    //   78: astore_1
    //   79: goto -18 -> 61
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 45	java/lang/IllegalAccessException:printStackTrace	()V
    //   93: aload_2
    //   94: astore_1
    //   95: goto -34 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	2	0	bool	boolean
    //   14	26	1	localObject1	Object
    //   43	2	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   49	20	1	localLogger	Logger
    //   72	2	1	localInstantiationException	java.lang.InstantiationException
    //   78	1	1	localObject2	Object
    //   82	5	1	localObject3	Object
    //   88	2	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   94	1	1	localObject4	Object
    //   1	93	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	43	java/lang/ClassNotFoundException
    //   53	61	72	java/lang/InstantiationException
    //   5	15	82	finally
    //   20	24	82	finally
    //   28	34	82	finally
    //   44	48	82	finally
    //   53	61	82	finally
    //   61	65	82	finally
    //   65	69	82	finally
    //   73	77	82	finally
    //   89	93	82	finally
    //   53	61	88	java/lang/IllegalAccessException
  }
  
  public static void setLoger(Logger paramLogger)
  {
    try
    {
      sLogger = paramLogger;
      return;
    }
    finally
    {
      paramLogger = finally;
      throw paramLogger;
    }
  }
  
  public static void setUseImsdk(boolean paramBoolean)
  {
    try
    {
      sUseImsdk = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.logger.AVLoggerChooser
 * JD-Core Version:    0.7.0.1
 */