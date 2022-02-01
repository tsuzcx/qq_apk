package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public abstract class w
  extends z
{
  private volatile HandlerThread c = null;
  private volatile a d = null;
  
  private void b(long paramLong)
  {
    try
    {
      ai.a(this.c, this.d, paramLong);
      this.c = null;
      this.d = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!ai.a()) {}
      ai.a(c(), "shutdown thread error.", localThrowable);
    }
  }
  
  public final int a(Looper paramLooper)
  {
    synchronized (this.b)
    {
      if (f()) {
        return -1;
      }
      this.a = true;
    }
    try
    {
      if (ai.a()) {
        ai.a(3, c(), "startup()", null);
      }
      if (paramLooper == null)
      {
        this.c = new HandlerThread("th_" + c());
        this.c.start();
      }
      for (this.d = new a(this.c.getLooper());; this.d = new a(paramLooper))
      {
        this.d.getLooper();
        int i = a();
        return i;
        paramLooper = finally;
        throw paramLooper;
      }
      return -1;
    }
    catch (Throwable paramLooper)
    {
      if (ai.a()) {
        ai.a(c(), "startup error.", paramLooper);
      }
    }
  }
  
  /* Error */
  public final void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	c/t/m/g/w:b	[B
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 50	c/t/m/g/w:a	Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifne +7 -> 22
    //   18: aload 4
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 32	c/t/m/g/ai:a	()Z
    //   25: ifeq +14 -> 39
    //   28: iconst_3
    //   29: aload_0
    //   30: invokevirtual 35	c/t/m/g/w:c	()Ljava/lang/String;
    //   33: ldc 90
    //   35: aconst_null
    //   36: invokestatic 55	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   39: aload_0
    //   40: invokevirtual 92	c/t/m/g/w:b	()V
    //   43: aload_0
    //   44: lload_1
    //   45: invokespecial 94	c/t/m/g/w:b	(J)V
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 50	c/t/m/g/w:a	Z
    //   53: aload 4
    //   55: monitorexit
    //   56: return
    //   57: astore 5
    //   59: aload 4
    //   61: monitorexit
    //   62: aload 5
    //   64: athrow
    //   65: astore 5
    //   67: invokestatic 32	c/t/m/g/ai:a	()Z
    //   70: ifeq -17 -> 53
    //   73: aload_0
    //   74: invokevirtual 35	c/t/m/g/w:c	()Ljava/lang/String;
    //   77: ldc 96
    //   79: aload 5
    //   81: invokestatic 40	c/t/m/g/ai:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: goto -31 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	w
    //   0	87	1	paramLong	long
    //   13	2	3	bool	boolean
    //   57	6	5	localObject	Object
    //   65	15	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	14	57	finally
    //   18	21	57	finally
    //   22	39	57	finally
    //   39	53	57	finally
    //   53	56	57	finally
    //   59	62	57	finally
    //   67	84	57	finally
    //   9	14	65	java/lang/Throwable
    //   22	39	65	java/lang/Throwable
    //   39	53	65	java/lang/Throwable
  }
  
  public abstract void a(Message paramMessage)
    throws Exception;
  
  public final boolean a(int paramInt, long paramLong)
  {
    synchronized (this.b)
    {
      boolean bool = ai.a(this.d, paramInt, paramLong);
      return bool;
    }
  }
  
  public final boolean b(Message paramMessage)
  {
    synchronized (this.b)
    {
      boolean bool = ai.a(this.d, paramMessage, 0L);
      return bool;
    }
  }
  
  public final void d()
  {
    a(0L);
  }
  
  public final Handler e()
  {
    synchronized (this.b)
    {
      a locala = this.d;
      return locala;
    }
  }
  
  public final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      try
      {
        w.this.a(paramMessage);
        return;
      }
      catch (Throwable localThrowable)
      {
        while (!ai.a()) {}
        ai.a(w.this.c(), "handleInnerMessage[" + paramMessage.what + "] error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.w
 * JD-Core Version:    0.7.0.1
 */