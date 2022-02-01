package com.tencent.token;

public final class lm
{
  private static boolean a = false;
  private static boolean b = false;
  
  public static boolean a()
  {
    if (a)
    {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      return b;
    }
    return b();
  }
  
  /* Error */
  private static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 38	java/net/Socket
    //   7: dup
    //   8: invokespecial 41	java/net/Socket:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: new 43	java/net/InetSocketAddress
    //   16: dup
    //   17: aload_0
    //   18: bipush 80
    //   20: invokespecial 46	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   23: sipush 5000
    //   26: invokevirtual 50	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   29: aload_2
    //   30: invokevirtual 53	java/net/Socket:isConnected	()Z
    //   33: ifeq +7 -> 40
    //   36: iconst_1
    //   37: putstatic 31	com/tencent/token/lm:b	Z
    //   40: aload_2
    //   41: invokevirtual 56	java/net/Socket:close	()V
    //   44: goto +46 -> 90
    //   47: astore_0
    //   48: goto +46 -> 94
    //   51: astore_1
    //   52: aload_2
    //   53: astore_0
    //   54: aload_1
    //   55: astore_2
    //   56: goto +12 -> 68
    //   59: astore_0
    //   60: aload_1
    //   61: astore_2
    //   62: goto +32 -> 94
    //   65: astore_2
    //   66: aload_3
    //   67: astore_0
    //   68: aload_0
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   74: aload_0
    //   75: ifnull +15 -> 90
    //   78: aload_0
    //   79: invokevirtual 56	java/net/Socket:close	()V
    //   82: goto +8 -> 90
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   90: getstatic 31	com/tencent/token/lm:b	Z
    //   93: ireturn
    //   94: aload_2
    //   95: ifnull +15 -> 110
    //   98: aload_2
    //   99: invokevirtual 56	java/net/Socket:close	()V
    //   102: goto +8 -> 110
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString	String
    //   3	1	1	localObject1	Object
    //   51	10	1	localThrowable1	Throwable
    //   69	1	1	str	String
    //   105	2	1	localThrowable2	Throwable
    //   11	51	2	localObject2	Object
    //   65	34	2	localThrowable3	Throwable
    //   1	66	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	40	47	finally
    //   12	40	51	java/lang/Throwable
    //   4	12	59	finally
    //   70	74	59	finally
    //   4	12	65	java/lang/Throwable
    //   40	44	85	java/lang/Throwable
    //   78	82	85	java/lang/Throwable
    //   98	102	105	java/lang/Throwable
  }
  
  private static boolean b()
  {
    boolean bool = true;
    try
    {
      a = true;
      Process localProcess = Runtime.getRuntime().exec("/system/bin/ping -c 1 -W 5 ".concat(String.valueOf("info.3g.qq.com")));
      new a(localProcess).start();
      int i = localProcess.waitFor();
      if (i != 0) {
        bool = false;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      bool = a("info.3g.qq.com");
    }
    a = false;
    return bool;
  }
  
  static final class a
    extends Thread
  {
    private final Process a;
    
    public a(Process paramProcess)
    {
      this.a = paramProcess;
      setDaemon(true);
    }
    
    public final void run()
    {
      try
      {
        try
        {
          wait(5000L);
          this.a.destroy();
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
        return;
      }
      catch (InterruptedException|Throwable localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lm
 * JD-Core Version:    0.7.0.1
 */