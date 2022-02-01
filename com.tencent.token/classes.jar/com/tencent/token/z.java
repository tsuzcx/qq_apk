package com.tencent.token;

import com.tencent.halley.common.b;

public final class z
  implements Runnable
{
  private aa a;
  private volatile boolean b = false;
  private Object c = new Object();
  private Object d = new Object();
  private volatile boolean e = false;
  
  public z(aa paramaa)
  {
    b.b("SaveService", "new BDSaveService...");
    this.a = paramaa;
    new Thread(this, "HalleyDownload-SaveThread").start();
  }
  
  public final void a()
  {
    b.b("SaveService", "start SaveService...");
    synchronized (this.c)
    {
      if (!this.b)
      {
        this.b = true;
        this.c.notify();
      }
      return;
    }
  }
  
  public final void b()
  {
    b.b("SaveService", "stop SaveService...");
    synchronized (this.c)
    {
      if (this.b) {
        this.b = false;
      }
      return;
    }
  }
  
  public final void c()
  {
    try
    {
      if (this.e) {}
      synchronized (this.d)
      {
        this.d.notify();
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 69	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 38	com/tencent/token/z:a	Lcom/tencent/token/aa;
    //   8: invokeinterface 74 1 0
    //   13: istore 4
    //   15: invokestatic 69	android/os/SystemClock:elapsedRealtime	()J
    //   18: lload_2
    //   19: lsub
    //   20: lstore_2
    //   21: iload 4
    //   23: ifne +57 -> 80
    //   26: getstatic 80	com/tencent/token/k:f	I
    //   29: istore_1
    //   30: lload_2
    //   31: lconst_0
    //   32: lcmp
    //   33: ifle +47 -> 80
    //   36: lload_2
    //   37: iload_1
    //   38: i2l
    //   39: lcmp
    //   40: ifge +40 -> 80
    //   43: iload_1
    //   44: i2l
    //   45: lload_2
    //   46: lsub
    //   47: l2i
    //   48: istore_1
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 27	com/tencent/token/z:e	Z
    //   54: aload_0
    //   55: getfield 25	com/tencent/token/z:d	Ljava/lang/Object;
    //   58: astore 5
    //   60: aload 5
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 25	com/tencent/token/z:d	Ljava/lang/Object;
    //   67: iload_1
    //   68: i2l
    //   69: invokevirtual 84	java/lang/Object:wait	(J)V
    //   72: aload 5
    //   74: monitorexit
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 27	com/tencent/token/z:e	Z
    //   80: aload_0
    //   81: getfield 23	com/tencent/token/z:c	Ljava/lang/Object;
    //   84: astore 5
    //   86: aload 5
    //   88: monitorenter
    //   89: aload_0
    //   90: getfield 21	com/tencent/token/z:b	Z
    //   93: istore 4
    //   95: iload 4
    //   97: ifne +17 -> 114
    //   100: ldc 29
    //   102: ldc 86
    //   104: invokestatic 88	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 23	com/tencent/token/z:c	Ljava/lang/Object;
    //   111: invokevirtual 90	java/lang/Object:wait	()V
    //   114: aload 5
    //   116: monitorexit
    //   117: goto -117 -> 0
    //   120: astore 6
    //   122: aload 5
    //   124: monitorexit
    //   125: aload 6
    //   127: athrow
    //   128: astore 5
    //   130: ldc 29
    //   132: aload 5
    //   134: invokestatic 93	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: iconst_0
    //   138: istore 4
    //   140: goto -125 -> 15
    //   143: astore 6
    //   145: aload 5
    //   147: monitorexit
    //   148: aload 6
    //   150: athrow
    //   151: astore 5
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 27	com/tencent/token/z:e	Z
    //   158: goto -78 -> 80
    //   161: astore 5
    //   163: aload_0
    //   164: iconst_0
    //   165: putfield 27	com/tencent/token/z:e	Z
    //   168: aload 5
    //   170: athrow
    //   171: astore 6
    //   173: aload 6
    //   175: invokevirtual 96	java/lang/InterruptedException:printStackTrace	()V
    //   178: goto -64 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	z
    //   29	39	1	i	int
    //   3	43	2	l	long
    //   13	126	4	bool	boolean
    //   128	18	5	localThrowable	java.lang.Throwable
    //   151	1	5	localException	Exception
    //   161	8	5	localObject2	Object
    //   120	6	6	localObject3	Object
    //   143	6	6	localObject4	Object
    //   171	3	6	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   89	95	120	finally
    //   100	114	120	finally
    //   114	117	120	finally
    //   173	178	120	finally
    //   4	15	128	java/lang/Throwable
    //   63	75	143	finally
    //   49	63	151	java/lang/Exception
    //   145	151	151	java/lang/Exception
    //   49	63	161	finally
    //   145	151	161	finally
    //   100	114	171	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.z
 * JD-Core Version:    0.7.0.1
 */