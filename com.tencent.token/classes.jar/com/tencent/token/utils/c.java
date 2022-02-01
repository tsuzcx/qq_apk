package com.tencent.token.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.token.dy;
import com.tencent.token.ea;
import com.tencent.token.eb;
import com.tencent.token.global.c.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class c
  extends eb
  implements Handler.Callback
{
  private d a;
  private FileOutputStream b;
  private File c;
  private char[] d;
  private volatile dy e;
  private volatile dy f;
  private volatile dy g;
  private volatile dy h;
  private volatile boolean i = false;
  private HandlerThread j;
  private Handler k;
  
  public c(int paramInt, boolean paramBoolean, ea paramea, d paramd)
  {
    super(paramInt, paramBoolean, paramea);
    a(paramd);
    this.e = new dy();
    this.f = new dy();
    this.g = this.e;
    this.h = this.f;
    this.d = new char[paramd.f()];
    g();
    this.j = new HandlerThread(paramd.c(), paramd.i());
    paramea = this.j;
    if (paramea != null) {
      paramea.start();
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
    this(c.a.h, true, ea.a, paramd);
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
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 34	com/tencent/token/utils/c:i	Z
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: invokespecial 134	com/tencent/token/utils/c:i	()V
    //   36: aload 4
    //   38: astore_3
    //   39: aload 5
    //   41: astore_1
    //   42: aload_0
    //   43: invokespecial 60	com/tencent/token/utils/c:g	()Ljava/io/FileOutputStream;
    //   46: astore 6
    //   48: aload 6
    //   50: ifnull +50 -> 100
    //   53: aload 4
    //   55: astore_3
    //   56: aload 5
    //   58: astore_1
    //   59: aload 6
    //   61: invokevirtual 140	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   64: invokevirtual 146	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   67: astore_2
    //   68: aload_2
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: new 148	java/io/OutputStreamWriter
    //   75: dup
    //   76: aload 6
    //   78: invokespecial 151	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   81: astore 4
    //   83: aload_2
    //   84: astore_3
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dy;
    //   91: aload 4
    //   93: aload_0
    //   94: getfield 57	com/tencent/token/utils/c:d	[C
    //   97: invokevirtual 154	com/tencent/token/dy:a	(Ljava/io/Writer;[C)V
    //   100: aload_2
    //   101: ifnull +34 -> 135
    //   104: aload_2
    //   105: astore_1
    //   106: goto +25 -> 131
    //   109: astore_1
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 159	java/nio/channels/FileLock:release	()V
    //   118: aload_0
    //   119: getfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dy;
    //   122: invokevirtual 161	com/tencent/token/dy:b	()V
    //   125: aload_1
    //   126: athrow
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 159	java/nio/channels/FileLock:release	()V
    //   135: aload_0
    //   136: getfield 50	com/tencent/token/utils/c:h	Lcom/tencent/token/dy;
    //   139: invokevirtual 161	com/tencent/token/dy:b	()V
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 34	com/tencent/token/utils/c:i	Z
    //   147: return
    //   148: astore_2
    //   149: goto -22 -> 127
    //   152: astore_2
    //   153: goto -35 -> 118
    //   156: astore_1
    //   157: goto -22 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	c
    //   41	65	1	localObject1	Object
    //   109	23	1	localObject2	Object
    //   156	1	1	localException1	Exception
    //   31	74	2	localFileLock	java.nio.channels.FileLock
    //   148	1	2	localException2	Exception
    //   152	1	2	localException3	Exception
    //   38	77	3	localObject3	Object
    //   25	67	4	localOutputStreamWriter	java.io.OutputStreamWriter
    //   28	29	5	localObject4	Object
    //   46	31	6	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   42	48	109	finally
    //   59	68	109	finally
    //   72	83	109	finally
    //   87	100	109	finally
    //   42	48	148	java/lang/Exception
    //   59	68	148	java/lang/Exception
    //   72	83	148	java/lang/Exception
    //   87	100	148	java/lang/Exception
    //   114	118	152	java/lang/Exception
    //   131	135	156	java/lang/Exception
  }
  
  private FileOutputStream g()
  {
    File localFile1 = b().a();
    File localFile2 = this.c;
    int m;
    if ((localFile2 != null) && ((!localFile2.exists()) || (!this.c.canWrite()))) {
      m = 1;
    } else {
      m = 0;
    }
    if ((m != 0) || ((localFile1 != null) && (!localFile1.equals(this.c))))
    {
      this.c = localFile1;
      h();
    }
    try
    {
      this.b = new FileOutputStream(this.c, true);
      return this.b;
    }
    catch (IOException localIOException)
    {
      label90:
      break label90;
    }
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
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void i()
  {
    try
    {
      if (this.g == this.e)
      {
        this.g = this.f;
        this.h = this.e;
      }
      else
      {
        this.g = this.e;
        this.h = this.f;
      }
      return;
    }
    finally {}
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
    if (paramMessage.what == 1024)
    {
      f();
      e();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.c
 * JD-Core Version:    0.7.0.1
 */