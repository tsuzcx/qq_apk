package com.tencent.token;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.text.format.Time;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zu
  extends abl
  implements Handler.Callback
{
  zv a;
  private FileOutputStream d;
  private File e;
  private char[] f;
  private volatile abi g;
  private volatile abi h;
  private volatile abi i;
  private volatile abi j;
  private volatile boolean k = false;
  private HandlerThread l;
  private Handler m;
  
  private zu(int paramInt, abk paramabk, zv paramzv)
  {
    super(paramInt, paramabk);
    this.a = paramzv;
    this.g = new abi();
    this.h = new abi();
    this.i = this.g;
    this.j = this.h;
    this.f = new char[paramzv.c];
    b();
    this.l = new HandlerThread(paramzv.b, paramzv.f);
    paramabk = this.l;
    if (paramabk != null) {
      paramabk.start();
    }
    if (this.l.isAlive()) {
      this.m = new Handler(this.l.getLooper(), this);
    }
    a();
    this.m.postDelayed(new Runnable()
    {
      public final void run()
      {
        zv localzv = zu.this.a;
        if (localzv.e != null)
        {
          File[] arrayOfFile = localzv.e.listFiles(zv.a);
          if (arrayOfFile != null)
          {
            int j = arrayOfFile.length;
            int i = 0;
            while (i < j)
            {
              File localFile = arrayOfFile[i];
              long l = zv.a(localFile);
              if (System.currentTimeMillis() - l > localzv.h) {
                zw.a(localFile);
              }
              i += 1;
            }
          }
        }
      }
    }, 15000L);
  }
  
  public zu(zv paramzv)
  {
    this(ww.a.h, abk.a, paramzv);
  }
  
  private void a()
  {
    this.m.sendEmptyMessageDelayed(1024, this.a.d);
  }
  
  private FileOutputStream b()
  {
    File localFile1 = this.a.a(System.currentTimeMillis());
    File localFile2 = this.e;
    int n;
    if ((localFile2 != null) && ((!localFile2.exists()) || (!this.e.canWrite()))) {
      n = 1;
    } else {
      n = 0;
    }
    if ((n != 0) || ((localFile1 != null) && (!localFile1.equals(this.e))))
    {
      this.e = localFile1;
      try
      {
        if (this.d != null)
        {
          this.d.flush();
          this.d.close();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    try
    {
      this.d = new FileOutputStream(this.e, true);
      return this.d;
    }
    catch (IOException localIOException)
    {
      label118:
      break label118;
    }
    return null;
  }
  
  public final void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2)
  {
    long l1 = paramLong % 1000L;
    Time localTime = new Time();
    localTime.set(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(abk.a(paramInt));
    localStringBuilder.append('/');
    localStringBuilder.append(localTime.format("%Y-%m-%d %H:%M:%S"));
    localStringBuilder.append('.');
    if (l1 < 10L) {
      localStringBuilder.append("00");
    } else if (l1 < 100L) {
      localStringBuilder.append('0');
    }
    localStringBuilder.append(l1);
    localStringBuilder.append(' ');
    localStringBuilder.append('[');
    if (paramThread == null) {
      localStringBuilder.append("N/A");
    } else {
      localStringBuilder.append(paramThread.getName());
    }
    localStringBuilder.append(']');
    localStringBuilder.append('[');
    localStringBuilder.append(paramString1);
    localStringBuilder.append(']');
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString2);
    localStringBuilder.append('\n');
    paramThread = localStringBuilder.toString();
    paramString1 = this.i;
    paramInt = paramThread.length();
    paramString1.a.add(paramThread);
    paramString1.b.addAndGet(paramInt);
    if (this.i.b.get() >= this.a.c)
    {
      if (this.m.hasMessages(1024)) {
        this.m.removeMessages(1024);
      }
      this.m.sendEmptyMessage(1024);
    }
  }
  
  /* Error */
  public final boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 258	android/os/Message:what	I
    //   4: sipush 1024
    //   7: if_icmpeq +5 -> 12
    //   10: iconst_1
    //   11: ireturn
    //   12: invokestatic 262	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: aload_0
    //   16: getfield 73	com/tencent/token/zu:l	Landroid/os/HandlerThread;
    //   19: if_acmpne +192 -> 211
    //   22: aload_0
    //   23: getfield 34	com/tencent/token/zu:k	Z
    //   26: ifne +185 -> 211
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 34	com/tencent/token/zu:k	Z
    //   34: aconst_null
    //   35: astore 4
    //   37: aconst_null
    //   38: astore 5
    //   40: aconst_null
    //   41: astore_2
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 47	com/tencent/token/zu:i	Lcom/tencent/token/abi;
    //   48: aload_0
    //   49: getfield 43	com/tencent/token/zu:g	Lcom/tencent/token/abi;
    //   52: if_acmpne +22 -> 74
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 45	com/tencent/token/zu:h	Lcom/tencent/token/abi;
    //   60: putfield 47	com/tencent/token/zu:i	Lcom/tencent/token/abi;
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 43	com/tencent/token/zu:g	Lcom/tencent/token/abi;
    //   68: putfield 49	com/tencent/token/zu:j	Lcom/tencent/token/abi;
    //   71: goto +19 -> 90
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 43	com/tencent/token/zu:g	Lcom/tencent/token/abi;
    //   79: putfield 47	com/tencent/token/zu:i	Lcom/tencent/token/abi;
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 45	com/tencent/token/zu:h	Lcom/tencent/token/abi;
    //   87: putfield 49	com/tencent/token/zu:j	Lcom/tencent/token/abi;
    //   90: aload_0
    //   91: monitorexit
    //   92: aload 4
    //   94: astore_3
    //   95: aload 5
    //   97: astore_1
    //   98: aload_0
    //   99: invokespecial 61	com/tencent/token/zu:b	()Ljava/io/FileOutputStream;
    //   102: astore 6
    //   104: aload 6
    //   106: ifnull +50 -> 156
    //   109: aload 4
    //   111: astore_3
    //   112: aload 5
    //   114: astore_1
    //   115: aload 6
    //   117: invokevirtual 266	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   120: invokevirtual 272	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   123: astore_2
    //   124: aload_2
    //   125: astore_3
    //   126: aload_2
    //   127: astore_1
    //   128: new 274	java/io/OutputStreamWriter
    //   131: dup
    //   132: aload 6
    //   134: invokespecial 277	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   137: astore 4
    //   139: aload_2
    //   140: astore_3
    //   141: aload_2
    //   142: astore_1
    //   143: aload_0
    //   144: getfield 49	com/tencent/token/zu:j	Lcom/tencent/token/abi;
    //   147: aload 4
    //   149: aload_0
    //   150: getfield 57	com/tencent/token/zu:f	[C
    //   153: invokevirtual 280	com/tencent/token/abi:a	(Ljava/io/Writer;[C)V
    //   156: aload_2
    //   157: ifnull +34 -> 191
    //   160: aload_2
    //   161: astore_1
    //   162: goto +25 -> 187
    //   165: astore_1
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 285	java/nio/channels/FileLock:release	()V
    //   174: aload_0
    //   175: getfield 49	com/tencent/token/zu:j	Lcom/tencent/token/abi;
    //   178: invokevirtual 286	com/tencent/token/abi:a	()V
    //   181: aload_1
    //   182: athrow
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 285	java/nio/channels/FileLock:release	()V
    //   191: aload_0
    //   192: getfield 49	com/tencent/token/zu:j	Lcom/tencent/token/abi;
    //   195: invokevirtual 286	com/tencent/token/abi:a	()V
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 34	com/tencent/token/zu:k	Z
    //   203: goto +8 -> 211
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: aload_0
    //   212: invokespecial 93	com/tencent/token/zu:a	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_2
    //   218: goto -35 -> 183
    //   221: astore_2
    //   222: goto -48 -> 174
    //   225: astore_1
    //   226: goto -35 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	zu
    //   0	229	1	paramMessage	android.os.Message
    //   41	120	2	localFileLock	java.nio.channels.FileLock
    //   217	1	2	localException1	Exception
    //   221	1	2	localException2	Exception
    //   94	77	3	localObject1	Object
    //   35	113	4	localOutputStreamWriter	java.io.OutputStreamWriter
    //   38	75	5	localObject2	Object
    //   102	31	6	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   98	104	165	finally
    //   115	124	165	finally
    //   128	139	165	finally
    //   143	156	165	finally
    //   44	71	206	finally
    //   74	90	206	finally
    //   90	92	206	finally
    //   207	209	206	finally
    //   98	104	217	java/lang/Exception
    //   115	124	217	java/lang/Exception
    //   128	139	217	java/lang/Exception
    //   143	156	217	java/lang/Exception
    //   170	174	221	java/lang/Exception
    //   187	191	225	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zu
 * JD-Core Version:    0.7.0.1
 */