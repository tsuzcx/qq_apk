package com.tencent.token;

import java.nio.ByteBuffer;

final class anf
  implements amw
{
  public final amv a = new amv();
  public final ank b;
  boolean c;
  
  anf(ank paramank)
  {
    if (paramank != null)
    {
      this.b = paramank;
      return;
    }
    throw new NullPointerException("sink == null");
  }
  
  public final anm a()
  {
    return this.b.a();
  }
  
  public final void a_(amv paramamv, long paramLong)
  {
    if (!this.c)
    {
      this.a.a_(paramamv, paramLong);
      r();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public final amv b()
  {
    return this.a;
  }
  
  public final amw b(String paramString)
  {
    if (!this.c)
    {
      this.a.a(paramString);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final amw c(byte[] paramArrayOfByte)
  {
    if (!this.c)
    {
      this.a.b(paramArrayOfByte);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final amw c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
      ann.a(localObject2);
    }
  }
  
  public final amw f(int paramInt)
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
        ank localank = this.b;
        amv localamv = this.a;
        localank.a_(localamv, localamv.b);
      }
      this.b.flush();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public final amw g(int paramInt)
  {
    if (!this.c)
    {
      this.a.c(paramInt);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final amw h(int paramInt)
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
  
  public final amw j(long paramLong)
  {
    if (!this.c)
    {
      this.a.i(paramLong);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final amw k(long paramLong)
  {
    if (!this.c)
    {
      this.a.h(paramLong);
      return r();
    }
    throw new IllegalStateException("closed");
  }
  
  public final amw r()
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
 * Qualified Name:     com.tencent.token.anf
 * JD-Core Version:    0.7.0.1
 */