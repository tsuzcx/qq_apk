package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicInteger;

public final class zo
  extends Handler
{
  public volatile boolean a = false;
  private final int b = 4;
  private zp c;
  private long d;
  private AtomicInteger e = new AtomicInteger(0);
  private AtomicInteger f = new AtomicInteger(0);
  private AtomicInteger g = new AtomicInteger(0);
  private zq h;
  private long[] i;
  private File[] j;
  private File k;
  private volatile boolean l;
  private volatile boolean m;
  private zm n;
  
  public zo(zp paramzp, zm paramzm)
  {
    this.c = paramzp;
    this.n = paramzm;
    this.i = new long[4];
    this.j = new File[4];
    this.h = zq.a();
  }
  
  private static boolean a(AtomicInteger paramAtomicInteger)
  {
    return paramAtomicInteger.incrementAndGet() % 4 != 0;
  }
  
  private void c()
  {
    this.l = false;
    this.m = false;
    this.a = false;
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 89	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 205
    //   8: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 41	com/tencent/token/zo:a	Z
    //   17: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: ldc 210
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload_0
    //   30: getfield 54	com/tencent/token/zo:c	Lcom/tencent/token/zp;
    //   33: getfield 149	com/tencent/token/zp:b	Ljava/lang/String;
    //   36: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_0
    //   41: getfield 41	com/tencent/token/zo:a	Z
    //   44: istore_1
    //   45: iload_1
    //   46: ifeq +6 -> 52
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 41	com/tencent/token/zo:a	Z
    //   57: aload_0
    //   58: getfield 69	com/tencent/token/zo:h	Lcom/tencent/token/zq;
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 54	com/tencent/token/zo:c	Lcom/tencent/token/zp;
    //   66: getfield 149	com/tencent/token/zp:b	Ljava/lang/String;
    //   69: astore_3
    //   70: new 6	com/tencent/token/zo$1
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 212	com/tencent/token/zo$1:<init>	(Lcom/tencent/token/zo;)V
    //   78: astore 4
    //   80: aload_2
    //   81: new 154	com/tencent/token/akl$a
    //   84: dup
    //   85: invokespecial 155	com/tencent/token/akl$a:<init>	()V
    //   88: aload_3
    //   89: invokevirtual 170	com/tencent/token/akl$a:a	(Ljava/lang/String;)Lcom/tencent/token/akl$a;
    //   92: invokevirtual 173	com/tencent/token/akl$a:a	()Lcom/tencent/token/akl;
    //   95: aload 4
    //   97: invokevirtual 176	com/tencent/token/zq:a	(Lcom/tencent/token/akl;Lcom/tencent/token/ajt;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: astore_2
    //   104: goto +15 -> 119
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   112: aload_0
    //   113: invokespecial 79	com/tencent/token/zo:c	()V
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_2
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	zo
    //   44	2	1	bool	boolean
    //   11	70	2	localObject1	Object
    //   103	1	2	localObject2	Object
    //   107	15	2	localIOException	java.io.IOException
    //   69	20	3	str	String
    //   78	18	4	local1	1
    // Exception table:
    //   from	to	target	type
    //   2	45	103	finally
    //   52	100	103	finally
    //   108	116	103	finally
    //   2	45	107	java/io/IOException
    //   52	100	107	java/io/IOException
  }
  
  public final void b()
  {
    this.l = true;
    this.a = false;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.n == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4: 
      if (a(this.e)) {
        return;
      }
      c();
      this.i = new long[4];
      this.n.c();
      return;
    case 3: 
      this.n.b();
      if (a(this.f)) {
        return;
      }
      c();
      return;
    case 2: 
      if (a(this.g)) {
        return;
      }
      this.k.renameTo(new File(this.c.c, this.c.a));
      c();
      this.n.a();
      return;
    }
    long l1 = 0L;
    int i1 = 0;
    int i2 = this.i.length;
    while (i1 < i2)
    {
      l1 += this.i[i1];
      i1 += 1;
    }
    this.n.a((float)l1 * 1.0F / (float)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zo
 * JD-Core Version:    0.7.0.1
 */