package com.tencent.token;

import okio.f;
import okio.h;
import okio.l;
import okio.x;
import okio.z;

final class hr
  implements x
{
  private final l b = new l(this.a.d.a());
  private boolean c;
  
  hr(ho paramho) {}
  
  public z a()
  {
    return this.b;
  }
  
  public void a_(f paramf, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {
      return;
    }
    this.a.d.k(paramLong);
    this.a.d.b("\r\n");
    this.a.d.a_(paramf, paramLong);
    this.a.d.b("\r\n");
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/token/hr:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 42	com/tencent/token/hr:c	Z
    //   19: aload_0
    //   20: getfield 16	com/tencent/token/hr:a	Lcom/tencent/token/ho;
    //   23: getfield 27	com/tencent/token/ho:d	Lokio/h;
    //   26: ldc 63
    //   28: invokeinterface 58 2 0
    //   33: pop
    //   34: aload_0
    //   35: getfield 16	com/tencent/token/hr:a	Lcom/tencent/token/ho;
    //   38: aload_0
    //   39: getfield 37	com/tencent/token/hr:b	Lokio/l;
    //   42: invokevirtual 66	com/tencent/token/ho:a	(Lokio/l;)V
    //   45: aload_0
    //   46: getfield 16	com/tencent/token/hr:a	Lcom/tencent/token/ho;
    //   49: iconst_3
    //   50: putfield 70	com/tencent/token/ho:e	I
    //   53: goto -42 -> 11
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	hr
    //   6	2	1	bool	boolean
    //   56	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	53	56	finally
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/token/hr:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 16	com/tencent/token/hr:a	Lcom/tencent/token/ho;
    //   18: getfield 27	com/tencent/token/ho:d	Lokio/h;
    //   21: invokeinterface 73 1 0
    //   26: goto -15 -> 11
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	hr
    //   6	2	1	bool	boolean
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hr
 * JD-Core Version:    0.7.0.1
 */