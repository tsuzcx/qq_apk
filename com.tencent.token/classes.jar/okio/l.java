package okio;

import java.nio.ByteBuffer;

final class l
  implements d
{
  public final c a = new c();
  public final p b;
  boolean c;
  
  l(p paramp)
  {
    if (paramp != null)
    {
      this.b = paramp;
      return;
    }
    throw new NullPointerException("sink == null");
  }
  
  public r a()
  {
    return this.b.a();
  }
  
  public void a_(c paramc, long paramLong)
  {
    if (!this.c)
    {
      this.a.a_(paramc, paramLong);
      u();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public d b(String paramString)
  {
    if (!this.c)
    {
      this.a.a(paramString);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public c c()
  {
    return this.a;
  }
  
  public d c(byte[] paramArrayOfByte)
  {
    if (!this.c)
    {
      this.a.b(paramArrayOfByte);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public d c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.c)
    {
      this.a.b(paramArrayOfByte, paramInt1, paramInt2);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public void close()
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
      s.a(localObject2);
    }
  }
  
  public void flush()
  {
    if (!this.c)
    {
      if (this.a.b > 0L)
      {
        p localp = this.b;
        c localc = this.a;
        localp.a_(localc, localc.b);
      }
      this.b.flush();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public d g(int paramInt)
  {
    if (!this.c)
    {
      this.a.d(paramInt);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public d h(int paramInt)
  {
    if (!this.c)
    {
      this.a.c(paramInt);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public d i(int paramInt)
  {
    if (!this.c)
    {
      this.a.b(paramInt);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public boolean isOpen()
  {
    return this.c ^ true;
  }
  
  public d k(long paramLong)
  {
    if (!this.c)
    {
      this.a.j(paramLong);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public d l(long paramLong)
  {
    if (!this.c)
    {
      this.a.i(paramLong);
      return u();
    }
    throw new IllegalStateException("closed");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public d u()
  {
    if (!this.c)
    {
      long l = this.a.g();
      if (l > 0L) {
        this.b.a_(this.a, l);
      }
      return this;
    }
    throw new IllegalStateException("closed");
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    if (!this.c)
    {
      int i = this.a.write(paramByteBuffer);
      u();
      return i;
    }
    throw new IllegalStateException("closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.l
 * JD-Core Version:    0.7.0.1
 */