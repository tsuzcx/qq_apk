package com.tencent.token;

import java.nio.ByteBuffer;

final class alj
  implements ala
{
  public final akz a = new akz();
  public final alo b;
  boolean c;
  
  alj(alo paramalo)
  {
    if (paramalo != null)
    {
      this.b = paramalo;
      return;
    }
    throw new NullPointerException("sink == null");
  }
  
  public final alq a()
  {
    return this.b.a();
  }
  
  public final void a_(akz paramakz, long paramLong)
  {
    if (!this.c)
    {
      this.a.a_(paramakz, paramLong);
      r();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public final akz b()
  {
    return this.a;
  }
  
  public final ala b(String paramString)
  {
    if (!this.c)
    {
      this.a.a(paramString);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final ala c(byte[] paramArrayOfByte)
  {
    if (!this.c)
    {
      this.a.b(paramArrayOfByte);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final ala c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.c)
    {
      this.a.b(paramArrayOfByte, paramInt1, paramInt2);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final void close()
  {
    if (this.c) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (this.a.b > 0L)
      {
        this.b.a_(this.a, this.a.b);
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable1) {}
    try
    {
      this.b.close();
      localObject2 = localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = localThrowable1;
      if (localThrowable1 == null) {
        localObject2 = localThrowable2;
      }
    }
    this.c = true;
    if (localObject2 != null) {
      alr.a(localObject2);
    }
  }
  
  public final ala f(int paramInt)
  {
    if (!this.c)
    {
      this.a.d(paramInt);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final void flush()
  {
    if (!this.c)
    {
      if (this.a.b > 0L)
      {
        alo localalo = this.b;
        akz localakz = this.a;
        localalo.a_(localakz, localakz.b);
      }
      this.b.flush();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public final ala g(int paramInt)
  {
    if (!this.c)
    {
      this.a.c(paramInt);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final ala h(int paramInt)
  {
    if (!this.c)
    {
      this.a.b(paramInt);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final boolean isOpen()
  {
    return !this.c;
  }
  
  public final ala j(long paramLong)
  {
    if (!this.c)
    {
      this.a.i(paramLong);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final ala k(long paramLong)
  {
    if (!this.c)
    {
      this.a.h(paramLong);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final ala r()
  {
    if (!this.c)
    {
      long l = this.a.e();
      if (l > 0L) {
        this.b.a_(this.a, l);
      }
      return this;
    }
    throw new IllegalStateException("closed");
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("buffer(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final int write(ByteBuffer paramByteBuffer)
  {
    if (!this.c)
    {
      int i = this.a.write(paramByteBuffer);
      r();
      return i;
    }
    throw new IllegalStateException("closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alj
 * JD-Core Version:    0.7.0.1
 */