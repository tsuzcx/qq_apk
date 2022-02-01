package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class aoe
  implements anv
{
  public final ant a = new ant();
  public final aoj b;
  boolean c;
  
  aoe(aoj paramaoj)
  {
    if (paramaoj != null)
    {
      this.b = paramaoj;
      return;
    }
    throw new NullPointerException("source == null");
  }
  
  private long a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (!this.c)
    {
      if (paramLong2 >= 0L)
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
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(0L), Long.valueOf(paramLong2) }));
    }
    throw new IllegalStateException("closed");
  }
  
  private boolean b(long paramLong)
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
    throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
  }
  
  public final long a(ant paramant, long paramLong)
  {
    if (paramant != null)
    {
      if (paramLong >= 0L)
      {
        if (!this.c)
        {
          if ((this.a.b == 0L) && (this.b.a(this.a, 8192L) == -1L)) {
            return -1L;
          }
          paramLong = Math.min(paramLong, this.a.b);
          return this.a.a(paramant, paramLong);
        }
        throw new IllegalStateException("closed");
      }
      throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public final aok a()
  {
    return this.b.a();
  }
  
  public final void a(long paramLong)
  {
    if (b(paramLong)) {
      return;
    }
    throw new EOFException();
  }
  
  public final void a(byte[] paramArrayOfByte)
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
        ant localant = this.a;
        int j = localant.a(paramArrayOfByte, i, (int)localant.b);
        if (j != -1) {
          i += j;
        } else {
          throw new AssertionError();
        }
      }
      throw localEOFException;
    }
  }
  
  public final ant b()
  {
    return this.a;
  }
  
  public final anw c(long paramLong)
  {
    a(paramLong);
    return this.a.c(paramLong);
  }
  
  public final boolean c()
  {
    if (!this.c) {
      return (this.a.c()) && (this.b.a(this.a, 8192L) == -1L);
    }
    throw new IllegalStateException("closed");
  }
  
  public final void close()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b.close();
    this.a.p();
  }
  
  public final InputStream d()
  {
    new InputStream()
    {
      public final int available()
      {
        if (!aoe.this.c) {
          return (int)Math.min(aoe.this.a.b, 2147483647L);
        }
        throw new IOException("closed");
      }
      
      public final void close()
      {
        aoe.this.close();
      }
      
      public final int read()
      {
        if (!aoe.this.c)
        {
          if ((aoe.this.a.b == 0L) && (aoe.this.b.a(aoe.this.a, 8192L) == -1L)) {
            return -1;
          }
          return aoe.this.a.f() & 0xFF;
        }
        throw new IOException("closed");
      }
      
      public final int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (!aoe.this.c)
        {
          aol.a(paramAnonymousArrayOfByte.length, paramAnonymousInt1, paramAnonymousInt2);
          if ((aoe.this.a.b == 0L) && (aoe.this.b.a(aoe.this.a, 8192L) == -1L)) {
            return -1;
          }
          return aoe.this.a.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
        throw new IOException("closed");
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(aoe.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  public final String d(long paramLong)
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
        return this.a.e(l2);
      }
      if ((l1 < 9223372036854775807L) && (b(l1)) && (this.a.b(l1 - 1L) == 13) && (b(1L + l1)) && (this.a.b(l1) == 10)) {
        return this.a.e(l1);
      }
      ant localant = new ant();
      Object localObject = this.a;
      ((ant)localObject).a(localant, 0L, Math.min(32L, ((ant)localObject).b));
      localObject = new StringBuilder("\\n not found: limit=");
      ((StringBuilder)localObject).append(Math.min(this.a.b, paramLong));
      ((StringBuilder)localObject).append(" content=");
      ((StringBuilder)localObject).append(localant.l().e());
      ((StringBuilder)localObject).append('…');
      throw new EOFException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(paramLong)));
  }
  
  public final byte f()
  {
    a(1L);
    return this.a.f();
  }
  
  public final byte[] f(long paramLong)
  {
    a(paramLong);
    return this.a.f(paramLong);
  }
  
  public final short g()
  {
    a(2L);
    return this.a.g();
  }
  
  public final void g(long paramLong)
  {
    if (!this.c)
    {
      while (paramLong > 0L)
      {
        if ((this.a.b == 0L) && (this.b.a(this.a, 8192L) == -1L)) {
          throw new EOFException();
        }
        long l = Math.min(paramLong, this.a.b);
        this.a.g(l);
        paramLong -= l;
      }
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public final int h()
  {
    a(4L);
    return this.a.h();
  }
  
  public final short i()
  {
    a(2L);
    return aol.a(this.a.g());
  }
  
  public final boolean isOpen()
  {
    return !this.c;
  }
  
  public final int j()
  {
    a(4L);
    return aol.a(this.a.h());
  }
  
  public final long k()
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
    return this.a.k();
  }
  
  public final String n()
  {
    return d(9223372036854775807L);
  }
  
  public final long q()
  {
    return a((byte)0, 0L, 9223372036854775807L);
  }
  
  public final int read(ByteBuffer paramByteBuffer)
  {
    if ((this.a.b == 0L) && (this.b.a(this.a, 8192L) == -1L)) {
      return -1;
    }
    return this.a.read(paramByteBuffer);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("buffer(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoe
 * JD-Core Version:    0.7.0.1
 */