package com.tencent.token.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.token.dv;
import com.tencent.token.dx;
import com.tencent.token.dy;
import com.tencent.token.global.c.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class c
  extends dy
  implements Handler.Callback
{
  private d a;
  private FileOutputStream b;
  private File c;
  private char[] d;
  private volatile dv e;
  private volatile dv f;
  private volatile dv g;
  private volatile dv h;
  private volatile boolean i = false;
  private HandlerThread j;
  private Handler k;
  
  public c(int paramInt, boolean paramBoolean, dx paramdx, d paramd)
  {
    super(paramInt, paramBoolean, paramdx);
    a(paramd);
    this.e = new dv();
    this.f = new dv();
    this.g = this.e;
    this.h = this.f;
    this.d = new char[paramd.f()];
    g();
    this.j = new HandlerThread(paramd.c(), paramd.i());
    if (this.j != null) {
      this.j.start();
    }
    if (this.j.isAlive()) {
      this.k = new Handler(this.j.getLooper(), this);
    }
    e();
    this.k.postDelayed(new Runnable()
    {
      public void run()
      {
        c.this.b().b();
      }
    }, 15000L);
  }
  
  public c(d paramd)
  {
    this(c.a.h, true, dx.a, paramd);
  }
  
  private void e()
  {
    this.k.sendEmptyMessageDelayed(1024, b().g());
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: invokestatic 132	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: aload_0
    //   4: getfield 72	com/tencent/token/utils/c:j	Landroid/os/HandlerThread;
    //   7: if_acmpeq +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 34	com/tencent/token/utils/c:i	Z
    //   15: ifne -5 -> 10
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 34	com/tencent/token/utils/c:i	Z
    //   23: aconst_null
    //   24: astore_1
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_0
    //   28: invokespecial 134	com/tencent/token/utils/c:i	()V
    //   31: aload_1
    //   32: astore_2
    //   33: aload_0
    //   34: invokespecial 60	com/tencent/token/utils/c:g	()Ljava/io/FileOutputStream;
    //   37: astore 4
    //   39: aload_3
    //   40: astore_2
    //   41: aload 4
    //   43: ifnull +48 -> 91
    //   46: aload_1
    //   47: astore_2
    //   48: aload 4
    //   50: invokevirtual 140	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   53: invokevirtual 146	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   56: astore_1
    //   57: aload_1
    //   58: astore_2
    //   59: new 148	java/io/OutputStreamWriter
    //   62: dup
    //   63: aload 4
    //   65: invokespecial 151	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: ifnull +19 -> 91
    //   75: aload_1
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dv;
    //   81: aload_3
    //   82: aload_0
    //   83: getfield 57	com/tencent/token/utils/c:d	[C
    //   86: invokevirtual 154	com/tencent/token/dv:a	(Ljava/io/Writer;[C)V
    //   89: aload_1
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 159	java/nio/channels/FileLock:release	()V
    //   99: aload_0
    //   100: getfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dv;
    //   103: invokevirtual 161	com/tencent/token/dv:b	()V
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 34	com/tencent/token/utils/c:i	Z
    //   111: return
    //   112: astore_1
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 159	java/nio/channels/FileLock:release	()V
    //   121: aload_0
    //   122: getfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dv;
    //   125: invokevirtual 161	com/tencent/token/dv:b	()V
    //   128: goto -22 -> 106
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 159	java/nio/channels/FileLock:release	()V
    //   142: aload_0
    //   143: getfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dv;
    //   146: invokevirtual 161	com/tencent/token/dv:b	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: goto -53 -> 99
    //   155: astore_1
    //   156: goto -35 -> 121
    //   159: astore_2
    //   160: goto -18 -> 142
    //   163: astore_3
    //   164: aload_1
    //   165: astore_2
    //   166: aload_3
    //   167: astore_1
    //   168: goto -34 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	c
    //   24	66	1	localFileLock	java.nio.channels.FileLock
    //   112	1	1	localException1	Exception
    //   131	19	1	localObject1	Object
    //   151	1	1	localException2	Exception
    //   155	10	1	localException3	Exception
    //   167	1	1	localObject2	Object
    //   32	107	2	localObject3	Object
    //   159	1	2	localException4	Exception
    //   165	1	2	localException5	Exception
    //   26	56	3	localOutputStreamWriter	java.io.OutputStreamWriter
    //   163	4	3	localObject4	Object
    //   37	27	4	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   33	39	112	java/lang/Exception
    //   48	57	112	java/lang/Exception
    //   59	69	112	java/lang/Exception
    //   77	89	112	java/lang/Exception
    //   33	39	131	finally
    //   48	57	131	finally
    //   95	99	151	java/lang/Exception
    //   117	121	155	java/lang/Exception
    //   138	142	159	java/lang/Exception
    //   59	69	163	finally
    //   77	89	163	finally
  }
  
  private FileOutputStream g()
  {
    int n = 0;
    File localFile = b().a();
    int m = n;
    if (this.c != null) {
      if (this.c.exists())
      {
        m = n;
        if (this.c.canWrite()) {}
      }
      else
      {
        m = 1;
      }
    }
    if ((m != 0) || ((localFile != null) && (!localFile.equals(this.c))))
    {
      this.c = localFile;
      h();
    }
    try
    {
      this.b = new FileOutputStream(this.c, true);
      return this.b;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  private void h()
  {
    try
    {
      if (this.b != null)
      {
        this.b.flush();
        this.b.close();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/tencent/token/utils/c:g	Lcom/tencent/token/dv;
    //   6: aload_0
    //   7: getfield 44	com/tencent/token/utils/c:e	Lcom/tencent/token/dv;
    //   10: if_acmpne +22 -> 32
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 46	com/tencent/token/utils/c:f	Lcom/tencent/token/dv;
    //   18: putfield 48	com/tencent/token/utils/c:g	Lcom/tencent/token/dv;
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 44	com/tencent/token/utils/c:e	Lcom/tencent/token/dv;
    //   26: putfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dv;
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 44	com/tencent/token/utils/c:e	Lcom/tencent/token/dv;
    //   37: putfield 48	com/tencent/token/utils/c:g	Lcom/tencent/token/dv;
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 46	com/tencent/token/utils/c:f	Lcom/tencent/token/dv;
    //   45: putfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dv;
    //   48: goto -19 -> 29
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	c
    //   51	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	51	finally
    //   29	31	51	finally
    //   32	48	51	finally
    //   52	54	51	finally
  }
  
  public void a()
  {
    if (this.k.hasMessages(1024)) {
      this.k.removeMessages(1024);
    }
    this.k.sendEmptyMessage(1024);
  }
  
  protected void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(d().a(paramInt, paramThread, paramLong, paramString1, paramString2, paramThrowable));
  }
  
  public void a(d paramd)
  {
    this.a = paramd;
  }
  
  protected void a(String paramString)
  {
    this.g.a(paramString);
    if (this.g.a() >= b().f()) {
      a();
    }
  }
  
  public d b()
  {
    return this.a;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      f();
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.c
 * JD-Core Version:    0.7.0.1
 */