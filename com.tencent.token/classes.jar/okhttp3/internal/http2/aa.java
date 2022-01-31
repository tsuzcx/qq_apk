package okhttp3.internal.http2;

import okio.f;
import okio.x;

final class aa
  implements x
{
  boolean a;
  boolean b;
  private final f e = new f();
  
  static
  {
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  aa(z paramz) {}
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   13: getfield 43	okhttp3/internal/http2/z:g	Lokhttp3/internal/http2/ac;
    //   16: invokevirtual 47	okhttp3/internal/http2/ac:c	()V
    //   19: aload_0
    //   20: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   23: getfield 50	okhttp3/internal/http2/z:b	J
    //   26: lconst_0
    //   27: lcmp
    //   28: ifgt +60 -> 88
    //   31: aload_0
    //   32: getfield 52	okhttp3/internal/http2/aa:b	Z
    //   35: ifne +53 -> 88
    //   38: aload_0
    //   39: getfield 54	okhttp3/internal/http2/aa:a	Z
    //   42: ifne +46 -> 88
    //   45: aload_0
    //   46: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   49: getfield 58	okhttp3/internal/http2/z:h	Lokhttp3/internal/http2/ErrorCode;
    //   52: ifnonnull +36 -> 88
    //   55: aload_0
    //   56: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   59: invokevirtual 61	okhttp3/internal/http2/z:l	()V
    //   62: goto -43 -> 19
    //   65: astore 6
    //   67: aload_0
    //   68: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   71: getfield 43	okhttp3/internal/http2/z:g	Lokhttp3/internal/http2/ac;
    //   74: invokevirtual 63	okhttp3/internal/http2/ac:b	()V
    //   77: aload 6
    //   79: athrow
    //   80: astore 6
    //   82: aload 5
    //   84: monitorexit
    //   85: aload 6
    //   87: athrow
    //   88: aload_0
    //   89: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   92: getfield 43	okhttp3/internal/http2/z:g	Lokhttp3/internal/http2/ac;
    //   95: invokevirtual 63	okhttp3/internal/http2/ac:b	()V
    //   98: aload_0
    //   99: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   102: invokevirtual 66	okhttp3/internal/http2/z:k	()V
    //   105: aload_0
    //   106: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   109: getfield 50	okhttp3/internal/http2/z:b	J
    //   112: aload_0
    //   113: getfield 38	okhttp3/internal/http2/aa:e	Lokio/f;
    //   116: invokevirtual 69	okio/f:b	()J
    //   119: invokestatic 75	java/lang/Math:min	(JJ)J
    //   122: lstore_3
    //   123: aload_0
    //   124: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   127: astore 6
    //   129: aload 6
    //   131: aload 6
    //   133: getfield 50	okhttp3/internal/http2/z:b	J
    //   136: lload_3
    //   137: lsub
    //   138: putfield 50	okhttp3/internal/http2/z:b	J
    //   141: aload 5
    //   143: monitorexit
    //   144: aload_0
    //   145: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   148: getfield 43	okhttp3/internal/http2/z:g	Lokhttp3/internal/http2/ac;
    //   151: invokevirtual 47	okhttp3/internal/http2/ac:c	()V
    //   154: aload_0
    //   155: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   158: getfield 78	okhttp3/internal/http2/z:d	Lokhttp3/internal/http2/h;
    //   161: astore 5
    //   163: aload_0
    //   164: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   167: getfield 81	okhttp3/internal/http2/z:c	I
    //   170: istore_2
    //   171: iload_1
    //   172: ifeq +40 -> 212
    //   175: lload_3
    //   176: aload_0
    //   177: getfield 38	okhttp3/internal/http2/aa:e	Lokio/f;
    //   180: invokevirtual 69	okio/f:b	()J
    //   183: lcmp
    //   184: ifne +28 -> 212
    //   187: iconst_1
    //   188: istore_1
    //   189: aload 5
    //   191: iload_2
    //   192: iload_1
    //   193: aload_0
    //   194: getfield 38	okhttp3/internal/http2/aa:e	Lokio/f;
    //   197: lload_3
    //   198: invokevirtual 86	okhttp3/internal/http2/h:a	(IZLokio/f;J)V
    //   201: aload_0
    //   202: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   205: getfield 43	okhttp3/internal/http2/z:g	Lokhttp3/internal/http2/ac;
    //   208: invokevirtual 63	okhttp3/internal/http2/ac:b	()V
    //   211: return
    //   212: iconst_0
    //   213: istore_1
    //   214: goto -25 -> 189
    //   217: astore 5
    //   219: aload_0
    //   220: getfield 31	okhttp3/internal/http2/aa:d	Lokhttp3/internal/http2/z;
    //   223: getfield 43	okhttp3/internal/http2/z:g	Lokhttp3/internal/http2/ac;
    //   226: invokevirtual 63	okhttp3/internal/http2/ac:b	()V
    //   229: aload 5
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	aa
    //   0	232	1	paramBoolean	boolean
    //   170	22	2	i	int
    //   122	76	3	l	long
    //   4	186	5	localObject1	Object
    //   217	13	5	localObject2	Object
    //   65	13	6	localObject3	Object
    //   80	6	6	localObject4	Object
    //   127	5	6	localz	z
    // Exception table:
    //   from	to	target	type
    //   19	62	65	finally
    //   9	19	80	finally
    //   67	80	80	finally
    //   82	85	80	finally
    //   88	144	80	finally
    //   154	171	217	finally
    //   175	187	217	finally
    //   189	201	217	finally
  }
  
  public okio.z a()
  {
    return this.d.g;
  }
  
  public void a_(f paramf, long paramLong)
  {
    if ((!c) && (Thread.holdsLock(this.d))) {
      throw new AssertionError();
    }
    this.e.a_(paramf, paramLong);
    while (this.e.b() >= 16384L) {
      a(false);
    }
  }
  
  public void close()
  {
    if ((!c) && (Thread.holdsLock(this.d))) {
      throw new AssertionError();
    }
    synchronized (this.d)
    {
      if (this.a) {
        return;
      }
      if (this.d.e.b) {
        break label113;
      }
      if (this.e.b() > 0L)
      {
        if (this.e.b() <= 0L) {
          break label113;
        }
        a(true);
      }
    }
    this.d.d.a(this.d.c, true, null, 0L);
    label113:
    synchronized (this.d)
    {
      this.a = true;
      this.d.d.b();
      this.d.j();
      return;
    }
  }
  
  public void flush()
  {
    if ((!c) && (Thread.holdsLock(this.d))) {
      throw new AssertionError();
    }
    synchronized (this.d)
    {
      this.d.k();
      if (this.e.b() > 0L)
      {
        a(false);
        this.d.d.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.aa
 * JD-Core Version:    0.7.0.1
 */