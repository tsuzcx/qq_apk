package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class m
  implements e
{
  public final c a = new c();
  public final q b;
  boolean c;
  
  m(q paramq)
  {
    if (paramq != null)
    {
      this.b = paramq;
      return;
    }
    throw new NullPointerException("source == null");
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L, 9223372036854775807L);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (!this.c)
    {
      if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
      {
        while (paramLong1 < paramLong2)
        {
          long l = this.a.a(paramByte, paramLong1, paramLong2);
          if (l != -1L) {
            return l;
          }
          l = this.a.b;
          if (l < paramLong2)
          {
            if (this.b.a(this.a, 8192L) == -1L) {
              return -1L;
            }
            paramLong1 = Math.max(paramLong1, l);
          }
          else
          {
            return -1L;
          }
        }
        return -1L;
      }
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    throw new IllegalStateException("closed");
  }
  
  public long a(c paramc, long paramLong)
  {
    if (paramc != null)
    {
      if (paramLong >= 0L)
      {
        if (!this.c)
        {
          if ((this.a.b == 0L) && (this.b.a(this.a, 8192L) == -1L)) {
            return -1L;
          }
          paramLong = Math.min(paramLong, this.a.b);
          return this.a.a(paramc, paramLong);
        }
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public r a()
  {
    return this.b.a();
  }
  
  public void a(long paramLong)
  {
    if (b(paramLong)) {
      return;
    }
    throw new EOFException();
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
        c localc = this.a;
        int j = localc.a(paramArrayOfByte, i, (int)localc.b);
        if (j != -1) {
          i += j;
        } else {
          throw new AssertionError();
        }
      }
      throw localEOFException;
    }
  }
  
  public boolean b(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (!this.c)
      {
        while (this.a.b < paramLong) {
          if (this.b.a(this.a, 8192L) == -1L) {
            return false;
          }
        }
        return true;
      }
      throw new IllegalStateException("closed");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("byteCount < 0: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ByteString c(long paramLong)
  {
    a(paramLong);
    return this.a.c(paramLong);
  }
  
  public c c()
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
    if (paramLong >= 0L)
    {
      long l1;
      if (paramLong == 9223372036854775807L) {
        l1 = 9223372036854775807L;
      } else {
        l1 = paramLong + 1L;
      }
      long l2 = a((byte)10, 0L, l1);
      if (l2 != -1L) {
        return this.a.f(l2);
      }
      if ((l1 < 9223372036854775807L) && (b(l1)) && (this.a.b(l1 - 1L) == 13) && (b(1L + l1)) && (this.a.b(l1) == 10)) {
        return this.a.f(l1);
      }
      localObject1 = new c();
      Object localObject2 = this.a;
      ((c)localObject2).a((c)localObject1, 0L, Math.min(32L, ((c)localObject2).b()));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("\\n not found: limit=");
      ((StringBuilder)localObject2).append(Math.min(this.a.b(), paramLong));
      ((StringBuilder)localObject2).append(" content=");
      ((StringBuilder)localObject2).append(((c)localObject1).n().e());
      ((StringBuilder)localObject2).append('…');
      throw new EOFException(((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("limit < 0: ");
    ((StringBuilder)localObject1).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public boolean e()
  {
    if (!this.c) {
      return (this.a.e()) && (this.b.a(this.a, 8192L) == -1L);
    }
    throw new IllegalStateException("closed");
  }
  
  public InputStream f()
  {
    new InputStream()
    {
      public int available()
      {
        if (!m.this.c) {
          return (int)Math.min(m.this.a.b, 2147483647L);
        }
        throw new IOException("closed");
      }
      
      public void close()
      {
        m.this.close();
      }
      
      public int read()
      {
        if (!m.this.c)
        {
          if ((m.this.a.b == 0L) && (m.this.b.a(m.this.a, 8192L) == -1L)) {
            return -1;
          }
          return m.this.a.h() & 0xFF;
        }
        throw new IOException("closed");
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (!m.this.c)
        {
          s.a(paramAnonymousArrayOfByte.length, paramAnonymousInt1, paramAnonymousInt2);
          if ((m.this.a.b == 0L) && (m.this.b.a(m.this.a, 8192L) == -1L)) {
            return -1;
          }
          return m.this.a.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
        throw new IOException("closed");
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(m.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
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
    if (!this.c)
    {
      while (paramLong > 0L)
      {
        if ((this.a.b == 0L) && (this.b.a(this.a, 8192L) == -1L)) {
          throw new EOFException();
        }
        long l = Math.min(paramLong, this.a.b());
        this.a.h(l);
        paramLong -= l;
      }
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public short i()
  {
    a(2L);
    return this.a.i();
  }
  
  public boolean isOpen()
  {
    return this.c ^ true;
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
    int j;
    byte b1;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!b(j)) {
        break label105;
      }
      b1 = this.a.b(i);
      if (((b1 < 48) || (b1 > 57)) && ((b1 < 97) || (b1 > 102)) && ((b1 < 65) || (b1 > 70))) {
        break;
      }
    }
    if (i == 0) {
      throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b1) }));
    }
    label105:
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.m
 * JD-Core Version:    0.7.0.1
 */