package okhttp3.internal.http2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;
import okio.i;
import okio.x;
import okio.y;

public final class z
{
  long a = 0L;
  long b;
  final int c;
  final h d;
  final aa e;
  final ac f = new ac(this);
  final ac g = new ac(this);
  ErrorCode h = null;
  private final List j;
  private List k;
  private boolean l;
  private final ab m;
  
  static
  {
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      return;
    }
  }
  
  z(int paramInt, h paramh, boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    if (paramh == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.c = paramInt;
    this.d = paramh;
    this.b = paramh.l.d();
    this.m = new ab(this, paramh.k.d());
    this.e = new aa(this);
    this.m.b = paramBoolean2;
    this.e.b = paramBoolean1;
    this.j = paramList;
  }
  
  private boolean d(ErrorCode paramErrorCode)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.h != null) {
        return false;
      }
      if ((this.m.b) && (this.e.b)) {
        return false;
      }
    }
    finally {}
    this.h = paramErrorCode;
    notifyAll();
    this.d.b(this.c);
    return true;
  }
  
  public int a()
  {
    return this.c;
  }
  
  void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  /* Error */
  void a(List paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: getstatic 36	okhttp3/internal/http2/z:i	Z
    //   5: ifne +18 -> 23
    //   8: aload_0
    //   9: invokestatic 105	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   12: ifeq +11 -> 23
    //   15: new 107	java/lang/AssertionError
    //   18: dup
    //   19: invokespecial 108	java/lang/AssertionError:<init>	()V
    //   22: athrow
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 118	okhttp3/internal/http2/z:l	Z
    //   30: aload_0
    //   31: getfield 120	okhttp3/internal/http2/z:k	Ljava/util/List;
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: aload_1
    //   39: putfield 120	okhttp3/internal/http2/z:k	Ljava/util/List;
    //   42: aload_0
    //   43: invokevirtual 122	okhttp3/internal/http2/z:b	()Z
    //   46: istore_2
    //   47: aload_0
    //   48: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_2
    //   54: ifne +15 -> 69
    //   57: aload_0
    //   58: getfield 67	okhttp3/internal/http2/z:d	Lokhttp3/internal/http2/h;
    //   61: aload_0
    //   62: getfield 65	okhttp3/internal/http2/z:c	I
    //   65: invokevirtual 114	okhttp3/internal/http2/h:b	(I)Lokhttp3/internal/http2/z;
    //   68: pop
    //   69: return
    //   70: new 124	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 125	java/util/ArrayList:<init>	()V
    //   77: astore_3
    //   78: aload_3
    //   79: aload_0
    //   80: getfield 120	okhttp3/internal/http2/z:k	Ljava/util/List;
    //   83: invokeinterface 131 2 0
    //   88: pop
    //   89: aload_3
    //   90: aconst_null
    //   91: invokeinterface 134 2 0
    //   96: pop
    //   97: aload_3
    //   98: aload_1
    //   99: invokeinterface 131 2 0
    //   104: pop
    //   105: aload_0
    //   106: aload_3
    //   107: putfield 120	okhttp3/internal/http2/z:k	Ljava/util/List;
    //   110: goto -59 -> 51
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	z
    //   0	118	1	paramList	List
    //   1	53	2	bool	boolean
    //   77	30	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   25	51	113	finally
    //   51	53	113	finally
    //   70	110	113	finally
    //   114	116	113	finally
  }
  
  public void a(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.d.b(this.c, paramErrorCode);
  }
  
  void a(i parami, int paramInt)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.m.a(parami, paramInt);
  }
  
  public void b(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.d.a(this.c, paramErrorCode);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 54	okhttp3/internal/http2/z:h	Lokhttp3/internal/http2/ErrorCode;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 88	okhttp3/internal/http2/z:m	Lokhttp3/internal/http2/ab;
    //   21: getfield 95	okhttp3/internal/http2/ab:b	Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 88	okhttp3/internal/http2/z:m	Lokhttp3/internal/http2/ab;
    //   31: getfield 148	okhttp3/internal/http2/ab:a	Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 93	okhttp3/internal/http2/z:e	Lokhttp3/internal/http2/aa;
    //   41: getfield 96	okhttp3/internal/http2/aa:b	Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 93	okhttp3/internal/http2/z:e	Lokhttp3/internal/http2/aa;
    //   51: getfield 149	okhttp3/internal/http2/aa:a	Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 118	okhttp3/internal/http2/z:l	Z
    //   61: istore_2
    //   62: iload_2
    //   63: ifne -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	z
    //   1	67	1	bool1	boolean
    //   61	2	2	bool2	boolean
    //   8	2	3	localErrorCode	ErrorCode
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  void c(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.h == null)
      {
        this.h = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public boolean c()
  {
    if ((this.c & 0x1) == 1) {}
    for (int n = 1; this.d.a == n; n = 0) {
      return true;
    }
    return false;
  }
  
  public List d()
  {
    try
    {
      if (!c()) {
        throw new IllegalStateException("servers cannot read response headers");
      }
    }
    finally {}
    this.f.c();
    try
    {
      while ((this.k == null) && (this.h == null)) {
        l();
      }
      localList = this.k;
    }
    finally
    {
      this.f.b();
    }
    List localList;
    if (localList != null)
    {
      this.k = null;
      return localList;
    }
    throw new StreamResetException(this.h);
  }
  
  public okio.z e()
  {
    return this.f;
  }
  
  public okio.z f()
  {
    return this.g;
  }
  
  public y g()
  {
    return this.m;
  }
  
  public x h()
  {
    try
    {
      if ((!this.l) && (!c())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.e;
  }
  
  void i()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      this.m.b = true;
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  void j()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.m.b) && (this.m.a))
        {
          if (this.e.b) {
            break label112;
          }
          if (this.e.a)
          {
            break label112;
            bool = b();
            if (n == 0) {
              break label95;
            }
            a(ErrorCode.CANCEL);
            return;
          }
        }
        n = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.d.b(this.c);
      return;
      label112:
      int n = 1;
    }
  }
  
  void k()
  {
    if (this.e.a) {
      throw new IOException("stream closed");
    }
    if (this.e.b) {
      throw new IOException("stream finished");
    }
    if (this.h != null) {
      throw new StreamResetException(this.h);
    }
  }
  
  void l()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.z
 * JD-Core Version:    0.7.0.1
 */