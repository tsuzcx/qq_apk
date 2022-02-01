package com.tencent.halley.common;

public final class d
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
  private static boolean a(java.lang.String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: new 38	java/net/Socket
    //   8: dup
    //   9: invokespecial 41	java/net/Socket:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: new 43	java/net/InetSocketAddress
    //   19: dup
    //   20: aload_0
    //   21: bipush 80
    //   23: invokespecial 46	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   26: sipush 5000
    //   29: invokevirtual 50	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   32: aload 4
    //   34: invokevirtual 53	java/net/Socket:isConnected	()Z
    //   37: ifeq +7 -> 44
    //   40: iconst_1
    //   41: putstatic 31	com/tencent/halley/common/d:b	Z
    //   44: aload 4
    //   46: invokevirtual 56	java/net/Socket:close	()V
    //   49: goto +52 -> 101
    //   52: astore_0
    //   53: aload 4
    //   55: astore_3
    //   56: goto +49 -> 105
    //   59: astore_3
    //   60: aload 4
    //   62: astore_0
    //   63: aload_3
    //   64: astore 4
    //   66: goto +12 -> 78
    //   69: astore_0
    //   70: goto +35 -> 105
    //   73: astore 4
    //   75: aload 5
    //   77: astore_0
    //   78: aload_0
    //   79: astore_3
    //   80: aload 4
    //   82: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   85: aload_0
    //   86: ifnull +15 -> 101
    //   89: aload_0
    //   90: invokevirtual 56	java/net/Socket:close	()V
    //   93: goto +8 -> 101
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   101: getstatic 31	com/tencent/halley/common/d:b	Z
    //   104: ireturn
    //   105: aload_3
    //   106: ifnull +15 -> 121
    //   109: aload_3
    //   110: invokevirtual 56	java/net/Socket:close	()V
    //   113: goto +8 -> 121
    //   116: astore_3
    //   117: aload_3
    //   118: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	java.lang.String
    //   0	123	1	paramInt1	int
    //   0	123	2	paramInt2	int
    //   4	52	3	localObject1	Object
    //   59	5	3	localThrowable1	Throwable
    //   79	31	3	str	java.lang.String
    //   116	2	3	localThrowable2	Throwable
    //   12	53	4	localObject2	Object
    //   73	8	4	localThrowable3	Throwable
    //   1	75	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	44	52	finally
    //   14	44	59	java/lang/Throwable
    //   5	14	69	finally
    //   80	85	69	finally
    //   5	14	73	java/lang/Throwable
    //   44	49	96	java/lang/Throwable
    //   89	93	96	java/lang/Throwable
    //   109	113	116	java/lang/Throwable
  }
  
  private static boolean b()
  {
    boolean bool = true;
    try
    {
      a = true;
      Object localObject = Runtime.getRuntime();
      StringBuilder localStringBuilder = new StringBuilder("/system/bin/ping -c 1 -W 5 ");
      localStringBuilder.append("info.3g.qq.com");
      localObject = ((Runtime)localObject).exec(localStringBuilder.toString());
      new a((Process)localObject).start();
      int i = ((Process)localObject).waitFor();
      if (i != 0) {
        bool = false;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      bool = a("info.3g.qq.com", 80, 5000);
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
 * Qualified Name:     com.tencent.halley.common.d
 * JD-Core Version:    0.7.0.1
 */