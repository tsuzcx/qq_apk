package com.tencent.halley.common;

public final class e
{
  private static boolean a = false;
  private static boolean b = false;
  
  public static boolean a()
  {
    if (a) {
      try
      {
        Thread.sleep(5000L);
        return b;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    return b();
  }
  
  /* Error */
  private static boolean a(java.lang.String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 35	java/net/Socket
    //   3: dup
    //   4: invokespecial 38	java/net/Socket:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: aload 4
    //   14: new 40	java/net/InetSocketAddress
    //   17: dup
    //   18: aload_0
    //   19: bipush 80
    //   21: invokespecial 43	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   24: sipush 5000
    //   27: invokevirtual 47	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   30: aload 4
    //   32: astore_3
    //   33: aload 4
    //   35: invokevirtual 50	java/net/Socket:isConnected	()Z
    //   38: ifeq +10 -> 48
    //   41: aload 4
    //   43: astore_3
    //   44: iconst_1
    //   45: putstatic 13	com/tencent/halley/common/e:b	Z
    //   48: aload 4
    //   50: invokevirtual 53	java/net/Socket:close	()V
    //   53: getstatic 13	com/tencent/halley/common/e:b	Z
    //   56: ireturn
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 54	java/lang/Throwable:printStackTrace	()V
    //   62: goto -9 -> 53
    //   65: astore 5
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_0
    //   70: astore_3
    //   71: aload 5
    //   73: invokevirtual 54	java/lang/Throwable:printStackTrace	()V
    //   76: aload_0
    //   77: ifnull -24 -> 53
    //   80: aload_0
    //   81: invokevirtual 53	java/net/Socket:close	()V
    //   84: goto -31 -> 53
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 54	java/lang/Throwable:printStackTrace	()V
    //   92: goto -39 -> 53
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 53	java/net/Socket:close	()V
    //   106: aload_0
    //   107: athrow
    //   108: astore_3
    //   109: aload_3
    //   110: invokevirtual 54	java/lang/Throwable:printStackTrace	()V
    //   113: goto -7 -> 106
    //   116: astore_0
    //   117: goto -19 -> 98
    //   120: astore 5
    //   122: aload 4
    //   124: astore_0
    //   125: goto -56 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	java.lang.String
    //   0	128	1	paramInt1	int
    //   0	128	2	paramInt2	int
    //   11	92	3	localObject	Object
    //   108	2	3	localThrowable1	Throwable
    //   7	116	4	localSocket	java.net.Socket
    //   65	7	5	localThrowable2	Throwable
    //   120	1	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   48	53	57	java/lang/Throwable
    //   0	9	65	java/lang/Throwable
    //   80	84	87	java/lang/Throwable
    //   0	9	95	finally
    //   102	106	108	java/lang/Throwable
    //   12	30	116	finally
    //   33	41	116	finally
    //   44	48	116	finally
    //   71	76	116	finally
    //   12	30	120	java/lang/Throwable
    //   33	41	120	java/lang/Throwable
    //   44	48	120	java/lang/Throwable
  }
  
  private static boolean b()
  {
    for (bool = true;; bool = false)
    {
      try
      {
        a = true;
        Process localProcess = Runtime.getRuntime().exec("/system/bin/ping -c 1 -W 5 " + "info.3g.qq.com");
        new f(localProcess).start();
        int i = localProcess.waitFor();
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          bool = a("info.3g.qq.com", 80, 5000);
        }
      }
      a = false;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.e
 * JD-Core Version:    0.7.0.1
 */