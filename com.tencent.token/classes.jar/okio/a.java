package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a
  extends r
{
  private static final long a = TimeUnit.SECONDS.toMillis(60L);
  @Nullable
  static a b;
  private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
  private boolean e;
  @Nullable
  private a f;
  private long g;
  
  private static void a(a parama, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (b == null)
      {
        b = new a();
        new a().start();
      }
      long l = System.nanoTime();
      if ((paramLong != 0L) && (paramBoolean))
      {
        parama.g = (Math.min(paramLong, parama.d() - l) + l);
      }
      else if (paramLong != 0L)
      {
        parama.g = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label174;
        }
        parama.g = parama.d();
      }
      paramLong = parama.b(l);
      for (a locala = b; (locala.f != null) && (paramLong >= locala.f.b(l)); locala = locala.f) {}
      parama.f = locala.f;
      locala.f = parama;
      if (locala == b) {
        a.class.notify();
      }
      return;
      label174:
      throw new AssertionError();
    }
    finally {}
  }
  
  private static boolean a(a parama)
  {
    try
    {
      for (a locala = b; locala != null; locala = locala.f) {
        if (locala.f == parama)
        {
          locala.f = parama.f;
          parama.f = null;
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  private long b(long paramLong)
  {
    return this.g - paramLong;
  }
  
  @Nullable
  static a e()
  {
    Object localObject1 = b.f;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      l1 = System.nanoTime();
      a.class.wait(a);
      localObject1 = localObject2;
      if (b.f == null)
      {
        localObject1 = localObject2;
        if (System.nanoTime() - l1 >= d) {
          localObject1 = b;
        }
      }
      return localObject1;
    }
    long l1 = ((a)localObject1).b(System.nanoTime());
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      a.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    b.f = ((a)localObject1).f;
    ((a)localObject1).f = null;
    return localObject1;
  }
  
  protected IOException a(@Nullable IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public final p a(final p paramp)
  {
    new p()
    {
      public r a()
      {
        return a.this;
      }
      
      /* Error */
      public void a_(c paramAnonymousc, long paramAnonymousLong)
      {
        // Byte code:
        //   0: aload_1
        //   1: getfield 34	okio/c:b	J
        //   4: lconst_0
        //   5: lload_2
        //   6: invokestatic 39	okio/s:a	(JJJ)V
        //   9: lconst_0
        //   10: lstore 4
        //   12: lload_2
        //   13: lconst_0
        //   14: lcmp
        //   15: ifle +121 -> 136
        //   18: aload_1
        //   19: getfield 42	okio/c:a	Lokio/n;
        //   22: astore 8
        //   24: lload 4
        //   26: lstore 6
        //   28: lload 4
        //   30: ldc2_w 43
        //   33: lcmp
        //   34: ifge +43 -> 77
        //   37: lload 4
        //   39: aload 8
        //   41: getfield 50	okio/n:c	I
        //   44: aload 8
        //   46: getfield 52	okio/n:b	I
        //   49: isub
        //   50: i2l
        //   51: ladd
        //   52: lstore 4
        //   54: lload 4
        //   56: lload_2
        //   57: lcmp
        //   58: iflt +9 -> 67
        //   61: lload_2
        //   62: lstore 6
        //   64: goto +13 -> 77
        //   67: aload 8
        //   69: getfield 55	okio/n:f	Lokio/n;
        //   72: astore 8
        //   74: goto -50 -> 24
        //   77: aload_0
        //   78: getfield 18	okio/a$1:b	Lokio/a;
        //   81: invokevirtual 57	okio/a:c	()V
        //   84: aload_0
        //   85: getfield 20	okio/a$1:a	Lokio/p;
        //   88: aload_1
        //   89: lload 6
        //   91: invokeinterface 59 4 0
        //   96: lload_2
        //   97: lload 6
        //   99: lsub
        //   100: lstore_2
        //   101: aload_0
        //   102: getfield 18	okio/a$1:b	Lokio/a;
        //   105: iconst_1
        //   106: invokevirtual 62	okio/a:a	(Z)V
        //   109: goto -100 -> 9
        //   112: astore_1
        //   113: goto +13 -> 126
        //   116: astore_1
        //   117: aload_0
        //   118: getfield 18	okio/a$1:b	Lokio/a;
        //   121: aload_1
        //   122: invokevirtual 65	okio/a:b	(Ljava/io/IOException;)Ljava/io/IOException;
        //   125: athrow
        //   126: aload_0
        //   127: getfield 18	okio/a$1:b	Lokio/a;
        //   130: iconst_0
        //   131: invokevirtual 62	okio/a:a	(Z)V
        //   134: aload_1
        //   135: athrow
        //   136: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	137	0	this	1
        //   0	137	1	paramAnonymousc	c
        //   0	137	2	paramAnonymousLong	long
        //   10	45	4	l1	long
        //   26	72	6	l2	long
        //   22	51	8	localn	n
        // Exception table:
        //   from	to	target	type
        //   84	96	112	finally
        //   117	126	112	finally
        //   84	96	116	java/io/IOException
      }
      
      /* Error */
      public void close()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	okio/a$1:b	Lokio/a;
        //   4: invokevirtual 57	okio/a:c	()V
        //   7: aload_0
        //   8: getfield 20	okio/a$1:a	Lokio/p;
        //   11: invokeinterface 68 1 0
        //   16: aload_0
        //   17: getfield 18	okio/a$1:b	Lokio/a;
        //   20: iconst_1
        //   21: invokevirtual 62	okio/a:a	(Z)V
        //   24: return
        //   25: astore_1
        //   26: goto +13 -> 39
        //   29: astore_1
        //   30: aload_0
        //   31: getfield 18	okio/a$1:b	Lokio/a;
        //   34: aload_1
        //   35: invokevirtual 65	okio/a:b	(Ljava/io/IOException;)Ljava/io/IOException;
        //   38: athrow
        //   39: aload_0
        //   40: getfield 18	okio/a$1:b	Lokio/a;
        //   43: iconst_0
        //   44: invokevirtual 62	okio/a:a	(Z)V
        //   47: aload_1
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	1
        //   25	1	1	localObject	Object
        //   29	19	1	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   7	16	25	finally
        //   30	39	25	finally
        //   7	16	29	java/io/IOException
      }
      
      /* Error */
      public void flush()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	okio/a$1:b	Lokio/a;
        //   4: invokevirtual 57	okio/a:c	()V
        //   7: aload_0
        //   8: getfield 20	okio/a$1:a	Lokio/p;
        //   11: invokeinterface 71 1 0
        //   16: aload_0
        //   17: getfield 18	okio/a$1:b	Lokio/a;
        //   20: iconst_1
        //   21: invokevirtual 62	okio/a:a	(Z)V
        //   24: return
        //   25: astore_1
        //   26: goto +13 -> 39
        //   29: astore_1
        //   30: aload_0
        //   31: getfield 18	okio/a$1:b	Lokio/a;
        //   34: aload_1
        //   35: invokevirtual 65	okio/a:b	(Ljava/io/IOException;)Ljava/io/IOException;
        //   38: athrow
        //   39: aload_0
        //   40: getfield 18	okio/a$1:b	Lokio/a;
        //   43: iconst_0
        //   44: invokevirtual 62	okio/a:a	(Z)V
        //   47: aload_1
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	1
        //   25	1	1	localObject	Object
        //   29	19	1	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   7	16	25	finally
        //   30	39	25	finally
        //   7	16	29	java/io/IOException
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncTimeout.sink(");
        localStringBuilder.append(paramp);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
    };
  }
  
  public final q a(final q paramq)
  {
    new q()
    {
      /* Error */
      public long a(c paramAnonymousc, long paramAnonymousLong)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	okio/a$2:b	Lokio/a;
        //   4: invokevirtual 30	okio/a:c	()V
        //   7: aload_0
        //   8: getfield 20	okio/a$2:a	Lokio/q;
        //   11: aload_1
        //   12: lload_2
        //   13: invokeinterface 32 4 0
        //   18: lstore_2
        //   19: aload_0
        //   20: getfield 18	okio/a$2:b	Lokio/a;
        //   23: iconst_1
        //   24: invokevirtual 35	okio/a:a	(Z)V
        //   27: lload_2
        //   28: lreturn
        //   29: astore_1
        //   30: goto +13 -> 43
        //   33: astore_1
        //   34: aload_0
        //   35: getfield 18	okio/a$2:b	Lokio/a;
        //   38: aload_1
        //   39: invokevirtual 38	okio/a:b	(Ljava/io/IOException;)Ljava/io/IOException;
        //   42: athrow
        //   43: aload_0
        //   44: getfield 18	okio/a$2:b	Lokio/a;
        //   47: iconst_0
        //   48: invokevirtual 35	okio/a:a	(Z)V
        //   51: aload_1
        //   52: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	53	0	this	2
        //   0	53	1	paramAnonymousc	c
        //   0	53	2	paramAnonymousLong	long
        // Exception table:
        //   from	to	target	type
        //   7	19	29	finally
        //   34	43	29	finally
        //   7	19	33	java/io/IOException
      }
      
      public r a()
      {
        return a.this;
      }
      
      /* Error */
      public void close()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 20	okio/a$2:a	Lokio/q;
        //   4: invokeinterface 42 1 0
        //   9: aload_0
        //   10: getfield 18	okio/a$2:b	Lokio/a;
        //   13: iconst_1
        //   14: invokevirtual 35	okio/a:a	(Z)V
        //   17: return
        //   18: astore_1
        //   19: goto +13 -> 32
        //   22: astore_1
        //   23: aload_0
        //   24: getfield 18	okio/a$2:b	Lokio/a;
        //   27: aload_1
        //   28: invokevirtual 38	okio/a:b	(Ljava/io/IOException;)Ljava/io/IOException;
        //   31: athrow
        //   32: aload_0
        //   33: getfield 18	okio/a$2:b	Lokio/a;
        //   36: iconst_0
        //   37: invokevirtual 35	okio/a:a	(Z)V
        //   40: aload_1
        //   41: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	42	0	this	2
        //   18	1	1	localObject	Object
        //   22	19	1	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   0	9	18	finally
        //   23	32	18	finally
        //   0	9	22	java/io/IOException
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncTimeout.source(");
        localStringBuilder.append(paramq);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
    };
  }
  
  protected void a() {}
  
  final void a(boolean paramBoolean)
  {
    if (b_())
    {
      if (!paramBoolean) {
        return;
      }
      throw a(null);
    }
  }
  
  final IOException b(IOException paramIOException)
  {
    if (!b_()) {
      return paramIOException;
    }
    return a(paramIOException);
  }
  
  public final boolean b_()
  {
    if (!this.e) {
      return false;
    }
    this.e = false;
    return a(this);
  }
  
  public final void c()
  {
    if (!this.e)
    {
      long l = c_();
      boolean bool = d_();
      if ((l == 0L) && (!bool)) {
        return;
      }
      this.e = true;
      a(this, l, bool);
      return;
    }
    throw new IllegalStateException("Unbalanced enter/exit");
  }
  
  private static final class a
    extends Thread
  {
    a()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          try
          {
            a locala = a.e();
            if (locala == null) {}
            if (locala == a.b)
            {
              a.b = null;
              return;
            }
            locala.a();
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.a
 * JD-Core Version:    0.7.0.1
 */