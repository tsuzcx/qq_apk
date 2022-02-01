package com.tencent.token;

public final class ma
  implements Runnable
{
  public Object a = new Object();
  public volatile boolean b = false;
  private mb c;
  private volatile boolean d = false;
  private Object e = new Object();
  
  public ma(mb parammb)
  {
    lh.b("SaveService", "new BDSaveService...");
    this.c = parammb;
    new Thread(this, "HalleyDownload-SaveThread").start();
  }
  
  public final void a()
  {
    lh.b("SaveService", "start SaveService...");
    synchronized (this.e)
    {
      if (!this.d)
      {
        this.d = true;
        this.e.notify();
      }
      return;
    }
  }
  
  public final void b()
  {
    lh.b("SaveService", "stop SaveService...");
    synchronized (this.e)
    {
      if (this.d) {
        this.d = false;
      }
      return;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 69	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 38	com/tencent/token/ma:c	Lcom/tencent/token/mb;
    //   8: invokeinterface 75 1 0
    //   13: istore 6
    //   15: goto +15 -> 30
    //   18: astore 7
    //   20: ldc 29
    //   22: aload 7
    //   24: invokestatic 78	com/tencent/token/lh:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   27: iconst_0
    //   28: istore 6
    //   30: invokestatic 69	android/os/SystemClock:elapsedRealtime	()J
    //   33: lload_2
    //   34: lsub
    //   35: lstore_2
    //   36: iload 6
    //   38: ifne +82 -> 120
    //   41: getstatic 83	com/tencent/token/kx:f	I
    //   44: istore_1
    //   45: lload_2
    //   46: lconst_0
    //   47: lcmp
    //   48: ifle +72 -> 120
    //   51: iload_1
    //   52: i2l
    //   53: lstore 4
    //   55: lload_2
    //   56: lload 4
    //   58: lcmp
    //   59: ifge +61 -> 120
    //   62: lload 4
    //   64: lload_2
    //   65: lsub
    //   66: l2i
    //   67: istore_1
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 27	com/tencent/token/ma:b	Z
    //   73: aload_0
    //   74: getfield 25	com/tencent/token/ma:a	Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 7
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 25	com/tencent/token/ma:a	Ljava/lang/Object;
    //   86: iload_1
    //   87: i2l
    //   88: invokevirtual 87	java/lang/Object:wait	(J)V
    //   91: aload 7
    //   93: monitorexit
    //   94: goto +21 -> 115
    //   97: astore 8
    //   99: aload 7
    //   101: monitorexit
    //   102: aload 8
    //   104: athrow
    //   105: astore 7
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 27	com/tencent/token/ma:b	Z
    //   112: aload 7
    //   114: athrow
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 27	com/tencent/token/ma:b	Z
    //   120: aload_0
    //   121: getfield 23	com/tencent/token/ma:e	Ljava/lang/Object;
    //   124: astore 7
    //   126: aload 7
    //   128: monitorenter
    //   129: aload_0
    //   130: getfield 21	com/tencent/token/ma:d	Z
    //   133: istore 6
    //   135: iload 6
    //   137: ifne +27 -> 164
    //   140: ldc 29
    //   142: ldc 89
    //   144: invokestatic 91	com/tencent/token/lh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_0
    //   148: getfield 23	com/tencent/token/ma:e	Ljava/lang/Object;
    //   151: invokevirtual 93	java/lang/Object:wait	()V
    //   154: goto +10 -> 164
    //   157: astore 8
    //   159: aload 8
    //   161: invokevirtual 96	java/lang/InterruptedException:printStackTrace	()V
    //   164: aload 7
    //   166: monitorexit
    //   167: goto -167 -> 0
    //   170: astore 8
    //   172: aload 7
    //   174: monitorexit
    //   175: aload 8
    //   177: athrow
    //   178: astore 7
    //   180: goto -65 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	ma
    //   44	43	1	i	int
    //   3	62	2	l1	long
    //   53	10	4	l2	long
    //   13	123	6	bool	boolean
    //   18	5	7	localThrowable	java.lang.Throwable
    //   105	8	7	localObject2	Object
    //   178	1	7	localException	java.lang.Exception
    //   97	6	8	localObject4	Object
    //   157	3	8	localInterruptedException	java.lang.InterruptedException
    //   170	6	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	18	java/lang/Throwable
    //   82	94	97	finally
    //   68	82	105	finally
    //   99	105	105	finally
    //   140	154	157	java/lang/InterruptedException
    //   129	135	170	finally
    //   140	154	170	finally
    //   159	164	170	finally
    //   164	167	170	finally
    //   68	82	178	java/lang/Exception
    //   99	105	178	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ma
 * JD-Core Version:    0.7.0.1
 */