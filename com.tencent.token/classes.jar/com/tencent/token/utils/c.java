package com.tencent.token.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import com.tencent.token.ga;
import com.tencent.token.gc;
import com.tencent.token.gd;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class c
  extends gd
  implements Handler.Callback
{
  private e a;
  private FileOutputStream b;
  private File c;
  private char[] d;
  private volatile ga e;
  private volatile ga f;
  private volatile ga g;
  private volatile ga h;
  private volatile boolean i = false;
  private HandlerThread j;
  private Handler k;
  
  private c(int paramInt, gc paramgc, e parame)
  {
    super(paramInt, paramgc);
    this.a = parame;
    this.e = new ga();
    this.f = new ga();
    this.g = this.e;
    this.h = this.f;
    this.d = new char[parame.d()];
    b();
    this.j = new HandlerThread(parame.c(), parame.f());
    if (this.j != null) {
      this.j.start();
    }
    if (this.j.isAlive()) {
      this.k = new Handler(this.j.getLooper(), this);
    }
    this.k.sendEmptyMessageDelayed(1024, this.a.e());
    this.k.postDelayed(new d(this), 15000L);
  }
  
  public c(e parame)
  {
    this(com.tencent.token.global.c.h, gc.a, parame);
  }
  
  private FileOutputStream b()
  {
    int n = 0;
    File localFile = this.a.a();
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
    if ((m != 0) || ((localFile != null) && (!localFile.equals(this.c)))) {
      this.c = localFile;
    }
    try
    {
      if (this.b != null)
      {
        this.b.flush();
        this.b.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.b = new FileOutputStream(this.c, true);
          return this.b;
        }
        catch (IOException localIOException) {}
        localException = localException;
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public final e a()
  {
    return this.a;
  }
  
  protected final void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2)
  {
    paramThread = gc.a(paramInt, paramThread, paramLong, paramString1, paramString2);
    this.g.a(paramThread);
    if (this.g.a() >= this.a.d())
    {
      if (this.k.hasMessages(1024)) {
        this.k.removeMessages(1024);
      }
      this.k.sendEmptyMessage(1024);
    }
  }
  
  /* Error */
  public final boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 184	android/os/Message:what	I
    //   4: tableswitch	default:+20 -> 24, 1024:+22->26
    //   25: ireturn
    //   26: invokestatic 190	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: aload_0
    //   30: getfield 69	com/tencent/token/utils/c:j	Landroid/os/HandlerThread;
    //   33: if_acmpne +120 -> 153
    //   36: aload_0
    //   37: getfield 32	com/tencent/token/utils/c:i	Z
    //   40: ifne +113 -> 153
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 32	com/tencent/token/utils/c:i	Z
    //   48: aconst_null
    //   49: astore_3
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: monitorenter
    //   54: aload_0
    //   55: getfield 45	com/tencent/token/utils/c:g	Lcom/tencent/token/ga;
    //   58: aload_0
    //   59: getfield 41	com/tencent/token/utils/c:e	Lcom/tencent/token/ga;
    //   62: if_acmpne +111 -> 173
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 43	com/tencent/token/utils/c:f	Lcom/tencent/token/ga;
    //   70: putfield 45	com/tencent/token/utils/c:g	Lcom/tencent/token/ga;
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 41	com/tencent/token/utils/c:e	Lcom/tencent/token/ga;
    //   78: putfield 47	com/tencent/token/utils/c:h	Lcom/tencent/token/ga;
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: astore_2
    //   85: aload_0
    //   86: invokespecial 57	com/tencent/token/utils/c:b	()Ljava/io/FileOutputStream;
    //   89: astore 4
    //   91: aload 4
    //   93: ifnull +40 -> 133
    //   96: aload_3
    //   97: astore_2
    //   98: aload 4
    //   100: invokevirtual 194	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   103: invokevirtual 200	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: new 202	java/io/OutputStreamWriter
    //   112: dup
    //   113: aload 4
    //   115: invokespecial 205	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   118: astore_3
    //   119: aload_1
    //   120: astore_2
    //   121: aload_0
    //   122: getfield 47	com/tencent/token/utils/c:h	Lcom/tencent/token/ga;
    //   125: aload_3
    //   126: aload_0
    //   127: getfield 54	com/tencent/token/utils/c:d	[C
    //   130: invokevirtual 208	com/tencent/token/ga:a	(Ljava/io/Writer;[C)V
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 213	java/nio/channels/FileLock:release	()V
    //   141: aload_0
    //   142: getfield 47	com/tencent/token/utils/c:h	Lcom/tencent/token/ga;
    //   145: invokevirtual 215	com/tencent/token/ga:b	()V
    //   148: aload_0
    //   149: iconst_0
    //   150: putfield 32	com/tencent/token/utils/c:i	Z
    //   153: aload_0
    //   154: getfield 87	com/tencent/token/utils/c:k	Landroid/os/Handler;
    //   157: sipush 1024
    //   160: aload_0
    //   161: getfield 34	com/tencent/token/utils/c:a	Lcom/tencent/token/utils/e;
    //   164: invokevirtual 90	com/tencent/token/utils/e:e	()J
    //   167: invokevirtual 94	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   170: pop
    //   171: iconst_1
    //   172: ireturn
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 41	com/tencent/token/utils/c:e	Lcom/tencent/token/ga;
    //   178: putfield 45	com/tencent/token/utils/c:g	Lcom/tencent/token/ga;
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 43	com/tencent/token/utils/c:f	Lcom/tencent/token/ga;
    //   186: putfield 47	com/tencent/token/utils/c:h	Lcom/tencent/token/ga;
    //   189: goto -108 -> 81
    //   192: astore_1
    //   193: aload_0
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    //   197: astore_1
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 213	java/nio/channels/FileLock:release	()V
    //   206: aload_0
    //   207: getfield 47	com/tencent/token/utils/c:h	Lcom/tencent/token/ga;
    //   210: invokevirtual 215	com/tencent/token/ga:b	()V
    //   213: goto -65 -> 148
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 213	java/nio/channels/FileLock:release	()V
    //   227: aload_0
    //   228: getfield 47	com/tencent/token/utils/c:h	Lcom/tencent/token/ga;
    //   231: invokevirtual 215	com/tencent/token/ga:b	()V
    //   234: aload_1
    //   235: athrow
    //   236: astore_1
    //   237: goto -96 -> 141
    //   240: astore_1
    //   241: goto -35 -> 206
    //   244: astore_2
    //   245: goto -18 -> 227
    //   248: astore_3
    //   249: aload_1
    //   250: astore_2
    //   251: aload_3
    //   252: astore_1
    //   253: goto -34 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	c
    //   0	256	1	paramMessage	android.os.Message
    //   84	140	2	localObject1	java.lang.Object
    //   244	1	2	localException	Exception
    //   250	1	2	localMessage	android.os.Message
    //   49	77	3	localOutputStreamWriter	java.io.OutputStreamWriter
    //   248	4	3	localObject2	java.lang.Object
    //   89	25	4	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   54	81	192	finally
    //   81	83	192	finally
    //   173	189	192	finally
    //   85	91	197	java/lang/Exception
    //   98	107	197	java/lang/Exception
    //   109	119	197	java/lang/Exception
    //   121	133	197	java/lang/Exception
    //   85	91	216	finally
    //   98	107	216	finally
    //   137	141	236	java/lang/Exception
    //   202	206	240	java/lang/Exception
    //   223	227	244	java/lang/Exception
    //   109	119	248	finally
    //   121	133	248	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.c
 * JD-Core Version:    0.7.0.1
 */