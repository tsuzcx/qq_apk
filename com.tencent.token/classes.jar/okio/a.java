package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a
  extends z
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
    for (;;)
    {
      try
      {
        if (b == null)
        {
          b = new a();
          new d().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          parama.g = (Math.min(paramLong, parama.d() - l) + l);
          paramLong = parama.b(l);
          locala = b;
          if ((locala.f != null) && (paramLong >= locala.f.b(l))) {
            break label175;
          }
          parama.f = locala.f;
          locala.f = parama;
          if (locala == b) {
            a.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          parama.g = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label167;
        }
      }
      finally {}
      parama.g = parama.d();
      continue;
      label167:
      throw new AssertionError();
      label175:
      a locala = locala.f;
    }
  }
  
  /* Error */
  private static boolean a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 45	okio/a:b	Lokio/a;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +39 -> 47
    //   11: aload_2
    //   12: getfield 72	okio/a:f	Lokio/a;
    //   15: aload_0
    //   16: if_acmpne +23 -> 39
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 72	okio/a:f	Lokio/a;
    //   24: putfield 72	okio/a:f	Lokio/a;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 72	okio/a:f	Lokio/a;
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: aload_2
    //   40: getfield 72	okio/a:f	Lokio/a;
    //   43: astore_2
    //   44: goto -37 -> 7
    //   47: iconst_1
    //   48: istore_1
    //   49: goto -15 -> 34
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	parama	a
    //   33	16	1	bool	boolean
    //   6	38	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   11	32	52	finally
    //   39	44	52	finally
  }
  
  private long b(long paramLong)
  {
    return this.g - paramLong;
  }
  
  @Nullable
  static a e()
  {
    Object localObject2 = null;
    Object localObject1 = b.f;
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
  
  public final x a(x paramx)
  {
    return new b(this, paramx);
  }
  
  public final y a(y paramy)
  {
    return new c(this, paramy);
  }
  
  protected void a() {}
  
  final void a(boolean paramBoolean)
  {
    if ((b_()) && (paramBoolean)) {
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
    if (this.e) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = c_();
    boolean bool = d_();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.e = true;
    a(this, l, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.a
 * JD-Core Version:    0.7.0.1
 */