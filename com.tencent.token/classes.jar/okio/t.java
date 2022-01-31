package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class t
  implements i
{
  public final f a = new f();
  public final y b;
  boolean c;
  
  t(y paramy)
  {
    if (paramy == null) {
      throw new NullPointerException("source == null");
    }
    this.b = paramy;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L, 9223372036854775807L);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((paramLong1 < 0L) || (paramLong2 < paramLong1))
    {
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      Object localObject;
      paramLong1 = Math.max(paramLong1, localObject);
    }
    for (;;)
    {
      if (paramLong1 < paramLong2)
      {
        long l = this.a.a(paramByte, paramLong1, paramLong2);
        if (l != -1L) {
          return l;
        }
        l = this.a.b;
        if ((l < paramLong2) && (this.b.a(this.a, 8192L) != -1L)) {
          break;
        }
        return -1L;
      }
      return -1L;
    }
  }
  
  public long a(f paramf, long paramLong)
  {
    if (paramf == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((this.a.b == 0L) && (this.b.a(this.a, 8192L) == -1L)) {
      return -1L;
    }
    paramLong = Math.min(paramLong, this.a.b);
    return this.a.a(paramf, paramLong);
  }
  
  public z a()
  {
    return this.b.a();
  }
  
  public void a(long paramLong)
  {
    if (!b(paramLong)) {
      throw new EOFException();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      a(paramArrayOfByte.length);
      this.a.a(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.a.b > 0L)
      {
        int j = this.a.a(paramArrayOfByte, i, (int)this.a.b);
        if (j == -1) {
          throw new AssertionError();
        }
        i += j;
      }
      throw localEOFException;
    }
  }
  
  public boolean b(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    while (this.a.b < paramLong) {
      if (this.b.a(this.a, 8192L) == -1L) {
        return false;
      }
    }
    return true;
  }
  
  public ByteString c(long paramLong)
  {
    a(paramLong);
    return this.a.c(paramLong);
  }
  
  public f c()
  {
    return this.a;
  }
  
  public void close()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b.close();
    this.a.r();
  }
  
  public String e(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("limit < 0: " + paramLong);
    }
    if (paramLong == 9223372036854775807L) {}
    for (long l1 = 9223372036854775807L;; l1 = paramLong + 1L)
    {
      long l2 = a((byte)10, 0L, l1);
      if (l2 == -1L) {
        break;
      }
      return this.a.f(l2);
    }
    if ((l1 < 9223372036854775807L) && (b(l1)) && (this.a.b(l1 - 1L) == 13) && (b(1L + l1)) && (this.a.b(l1) == 10)) {
      return this.a.f(l1);
    }
    f localf = new f();
    this.a.a(localf, 0L, Math.min(32L, this.a.b()));
    throw new EOFException("\\n not found: limit=" + Math.min(this.a.b(), paramLong) + " content=" + localf.n().e() + '…');
  }
  
  public boolean e()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    return (this.a.e()) && (this.b.a(this.a, 8192L) == -1L);
  }
  
  public InputStream f()
  {
    return new u(this);
  }
  
  public byte[] g(long paramLong)
  {
    a(paramLong);
    return this.a.g(paramLong);
  }
  
  public byte h()
  {
    a(1L);
    return this.a.h();
  }
  
  public void h(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      long l = Math.min(paramLong, this.a.b());
      this.a.h(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.a.b != 0L) || (this.b.a(this.a, 8192L) != -1L));
    throw new EOFException();
  }
  
  public short i()
  {
    a(2L);
    return this.a.i();
  }
  
  public boolean isOpen()
  {
    return !this.c;
  }
  
  public int j()
  {
    a(4L);
    return this.a.j();
  }
  
  public short k()
  {
    a(2L);
    return this.a.k();
  }
  
  public int l()
  {
    a(4L);
    return this.a.l();
  }
  
  public long m()
  {
    a(1L);
    int i = 0;
    while (b(i + 1))
    {
      byte b1 = this.a.b(i);
      if (((b1 < 48) || (b1 > 57)) && ((b1 < 97) || (b1 > 102)) && ((b1 < 65) || (b1 > 70)))
      {
        if (i != 0) {
          break;
        }
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b1) }));
      }
      i += 1;
    }
    return this.a.m();
  }
  
  public String p()
  {
    return e(9223372036854775807L);
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    if ((this.a.b == 0L) && (this.b.a(this.a, 8192L) == -1L)) {
      return -1;
    }
    return this.a.read(paramByteBuffer);
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.t
 * JD-Core Version:    0.7.0.1
 */