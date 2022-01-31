package com.tencent.token;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class bw
{
  private Lock a = new ReentrantLock();
  private bs b = null;
  
  public final bs a()
  {
    return this.b;
  }
  
  /* Error */
  public final void a(bs parambs)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +33 -> 34
    //   4: aload_0
    //   5: getfield 17	com/tencent/token/bw:a	Ljava/util/concurrent/locks/Lock;
    //   8: invokeinterface 29 1 0
    //   13: aload_0
    //   14: getfield 19	com/tencent/token/bw:b	Lcom/tencent/token/bs;
    //   17: ifnonnull +18 -> 35
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 19	com/tencent/token/bw:b	Lcom/tencent/token/bs;
    //   25: aload_0
    //   26: getfield 17	com/tencent/token/bw:a	Ljava/util/concurrent/locks/Lock;
    //   29: invokeinterface 32 1 0
    //   34: return
    //   35: aload_1
    //   36: invokevirtual 36	com/tencent/token/bs:b	()V
    //   39: goto -14 -> 25
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 17	com/tencent/token/bw:a	Ljava/util/concurrent/locks/Lock;
    //   47: invokeinterface 32 1 0
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	bw
    //   0	54	1	parambs	bs
    // Exception table:
    //   from	to	target	type
    //   13	25	42	finally
    //   35	39	42	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bw
 * JD-Core Version:    0.7.0.1
 */