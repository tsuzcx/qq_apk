package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import okio.f;
import okio.i;
import okio.y;

final class ab
  implements y
{
  boolean a;
  boolean b;
  private final f e = new f();
  private final f f = new f();
  private final long g;
  
  static
  {
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  ab(z paramz, long paramLong)
  {
    this.g = paramLong;
  }
  
  private void a(long paramLong)
  {
    if ((!c) && (Thread.holdsLock(this.d))) {
      throw new AssertionError();
    }
    this.d.d.a(paramLong);
  }
  
  private void b()
  {
    this.d.f.c();
    try
    {
      if (this.f.b() == 0L) {
        if ((!this.b) && (!this.a) && (this.d.h == null)) {
          this.d.l();
        }
      }
      return;
    }
    finally
    {
      this.d.f.b();
    }
  }
  
  public long a(f paramf, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    synchronized (this.d)
    {
      b();
      if (this.a) {
        throw new IOException("stream closed");
      }
    }
    ErrorCode localErrorCode = this.d.h;
    if (this.f.b() > 0L)
    {
      paramLong = this.f.a(paramf, Math.min(paramLong, this.f.b()));
      paramf = this.d;
      paramf.a += paramLong;
    }
    for (;;)
    {
      if ((localErrorCode == null) && (this.d.a >= this.d.d.k.d() / 2))
      {
        this.d.d.a(this.d.c, this.d.a);
        this.d.a = 0L;
      }
      if (paramLong != -1L)
      {
        a(paramLong);
        return paramLong;
      }
      if (localErrorCode != null) {
        throw new StreamResetException(localErrorCode);
      }
      return -1L;
      paramLong = -1L;
    }
  }
  
  public okio.z a()
  {
    return this.d.f;
  }
  
  void a(i parami, long paramLong)
  {
    long l = paramLong;
    if (!c)
    {
      l = paramLong;
      if (Thread.holdsLock(this.d)) {
        throw new AssertionError();
      }
    }
    for (;;)
    {
      l -= paramLong;
      synchronized (this.d)
      {
        if (this.f.b() == 0L)
        {
          i = 1;
          this.f.a(this.e);
          if (i != 0) {
            this.d.notifyAll();
          }
          if (l > 0L) {}
          boolean bool;
          synchronized (this.d)
          {
            bool = this.b;
            if (this.f.b() + l > this.g)
            {
              i = 1;
              if (i != 0)
              {
                parami.h(l);
                this.d.b(ErrorCode.FLOW_CONTROL_ERROR);
              }
            }
            else
            {
              i = 0;
            }
          }
          if (bool)
          {
            parami.h(l);
            return;
          }
          paramLong = parami.a(this.e, l);
          if (paramLong != -1L) {
            continue;
          }
          throw new EOFException();
        }
        int i = 0;
      }
    }
  }
  
  public void close()
  {
    synchronized (this.d)
    {
      this.a = true;
      long l = this.f.b();
      this.f.r();
      this.d.notifyAll();
      if (l > 0L) {
        a(l);
      }
      this.d.j();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.ab
 * JD-Core Version:    0.7.0.1
 */