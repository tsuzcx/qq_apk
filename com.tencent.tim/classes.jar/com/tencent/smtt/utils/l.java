package com.tencent.smtt.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;

public class l
  implements Runnable
{
  public static String a = "TBSFileLock";
  private static Object f = new Object();
  private static Object g = new Object();
  private static HashMap<l, Object> h = null;
  private static Handler i = null;
  File b = null;
  RandomAccessFile c = null;
  FileLock d = null;
  long e = 0L;
  
  public l(File paramFile, String paramString)
  {
    this.b = new File(paramFile, "." + paramString + ".lock");
  }
  
  Handler a()
  {
    if (i == null) {}
    try
    {
      if (i == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("QBFileLock.Thread");
        localHandlerThread.start();
        i = new Handler(localHandlerThread.getLooper());
      }
      return i;
    }
    finally {}
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 30	com/tencent/smtt/utils/l:a	Ljava/lang/String;
    //   5: new 55	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   12: ldc 95
    //   14: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 45	com/tencent/smtt/utils/l:b	Ljava/io/File;
    //   21: invokevirtual 98	java/io/File:getName	()Ljava/lang/String;
    //   24: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 103	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   33: pop
    //   34: aload_0
    //   35: getfield 49	com/tencent/smtt/utils/l:d	Ljava/nio/channels/FileLock;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +15 -> 55
    //   43: aload_0
    //   44: getfield 49	com/tencent/smtt/utils/l:d	Ljava/nio/channels/FileLock;
    //   47: invokevirtual 108	java/nio/channels/FileLock:release	()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 49	com/tencent/smtt/utils/l:d	Ljava/nio/channels/FileLock;
    //   55: aload_0
    //   56: getfield 47	com/tencent/smtt/utils/l:c	Ljava/io/RandomAccessFile;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +15 -> 76
    //   64: aload_0
    //   65: getfield 47	com/tencent/smtt/utils/l:c	Ljava/io/RandomAccessFile;
    //   68: invokevirtual 113	java/io/RandomAccessFile:close	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 47	com/tencent/smtt/utils/l:c	Ljava/io/RandomAccessFile;
    //   76: getstatic 41	com/tencent/smtt/utils/l:i	Landroid/os/Handler;
    //   79: ifnull +19 -> 98
    //   82: aload_0
    //   83: getfield 51	com/tencent/smtt/utils/l:e	J
    //   86: lconst_0
    //   87: lcmp
    //   88: ifle +10 -> 98
    //   91: getstatic 41	com/tencent/smtt/utils/l:i	Landroid/os/Handler;
    //   94: aload_0
    //   95: invokevirtual 117	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   98: iload_1
    //   99: ifeq +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 119	com/tencent/smtt/utils/l:d	()V
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   114: goto -64 -> 50
    //   117: astore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   127: goto -56 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	l
    //   0	130	1	paramBoolean	boolean
    //   38	23	2	localObject1	Object
    //   109	2	2	localException1	Exception
    //   117	4	2	localObject2	Object
    //   122	2	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   43	50	109	java/lang/Exception
    //   2	39	117	finally
    //   43	50	117	finally
    //   50	55	117	finally
    //   55	60	117	finally
    //   64	71	117	finally
    //   71	76	117	finally
    //   76	98	117	finally
    //   102	106	117	finally
    //   110	114	117	finally
    //   123	127	117	finally
    //   64	71	122	java/lang/Exception
  }
  
  public void b()
  {
    for (;;)
    {
      Object localObject4;
      long l;
      try
      {
        this.c = new RandomAccessFile(this.b, "rw");
        if (this.c != null)
        {
          localFileChannel = this.c.getChannel();
          if (localFileChannel != null)
          {
            if (this.e > 0L) {
              a().postDelayed(this, this.e);
            }
            localObject4 = null;
            l = System.currentTimeMillis();
          }
        }
      }
      catch (Exception localException1)
      {
        FileChannel localFileChannel;
        Object localObject1;
        localException1 = localException1;
        localException1.printStackTrace();
        continue;
      }
      finally {}
      try
      {
        Object localObject3;
        Thread.sleep(50L);
        localObject4 = localObject3;
        if (Math.abs(System.currentTimeMillis() - l) < 1000L) {
          continue;
        }
        Log.d(a, ">>> lock timeout, quit...");
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  void c()
  {
    synchronized (g)
    {
      if (h == null) {
        h = new HashMap();
      }
      h.put(this, f);
      return;
    }
  }
  
  void d()
  {
    synchronized (g)
    {
      if (h == null) {
        return;
      }
      h.remove(this);
      return;
    }
  }
  
  public void e()
  {
    a(true);
  }
  
  public void run()
  {
    Log.d(a, ">>> releaseLock on TimeOut");
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.l
 * JD-Core Version:    0.7.0.1
 */