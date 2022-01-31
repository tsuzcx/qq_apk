package com.tencent.token.global.taiji;

import android.os.HandlerThread;

public class k
  extends HandlerThread
{
  private long a;
  private boolean b = false;
  
  public k(String paramString, int paramInt, long paramLong)
  {
    super(paramString, paramInt);
    this.a = paramLong;
  }
  
  public k(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    super(paramString, paramInt);
    this.a = paramLong;
    this.b = paramBoolean;
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    super.destroy();
  }
  
  public void interrupt()
  {
    if (this.b) {
      return;
    }
    super.interrupt();
  }
  
  public boolean quit()
  {
    if (this.b) {
      return false;
    }
    return super.quit();
  }
  
  public void run()
  {
    super.run();
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 37	com/tencent/token/global/taiji/k:isAlive	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 39	android/os/HandlerThread:start	()V
    //   18: goto -7 -> 11
    //   21: astore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_2
    //   25: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	k
    //   6	2	1	bool	boolean
    //   21	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	7	21	finally
    //   14	18	21	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.k
 * JD-Core Version:    0.7.0.1
 */