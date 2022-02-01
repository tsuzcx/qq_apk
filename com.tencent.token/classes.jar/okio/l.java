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
    if (paramp == null) {
      throw new NullPointerException("sink == null");
    }
    this.b = paramp;
  }
  
  public r a()
  {
    return this.b.a();
  }
  
  public void a_(c paramc, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a_(paramc, paramLong);
    u();
  }
  
  public d b(String paramString)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramString);
    return u();
  }
  
  public c c()
  {
    return this.a;
  }
  
  public d c(byte[] paramArrayOfByte)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte);
    return u();
  }
  
  public d c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return u();
  }
  
  public void close()
  {
    if (this.c) {}
    do
    {
      return;
      localObject2 = null;
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          if (this.a.b > 0L)
          {
            this.b.a_(this.a, this.a.b);
            localObject1 = localObject2;
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        try
        {
          this.b.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable2)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            continue;
          }
          localObject2 = localThrowable2;
        }
      }
      this.c = true;
    } while (localObject2 == null);
    s.a(localObject2);
  }
  
  public void flush()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (this.a.b > 0L) {
      this.b.a_(this.a, this.a.b);
    }
    this.b.flush();
  }
  
  public d g(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.d(paramInt);
    return u();
  }
  
  public d h(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.c(paramInt);
    return u();
  }
  
  public d i(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramInt);
    return u();
  }
  
  public boolean isOpen()
  {
    return !this.c;
  }
  
  public d k(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.j(paramLong);
    return u();
  }
  
  public d l(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.i(paramLong);
    return u();
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
  
  public d u()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.g();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    int i = this.a.write(paramByteBuffer);
    u();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.l
 * JD-Core Version:    0.7.0.1
 */