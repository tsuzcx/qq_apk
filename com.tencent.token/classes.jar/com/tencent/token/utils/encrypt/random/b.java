package com.tencent.token.utils.encrypt.random;

public class b
  implements e
{
  private static long a = 10L;
  private long b;
  private long c;
  private a d;
  private byte[] e;
  private byte[] f;
  
  public b(a parama)
  {
    this.d = parama;
    this.f = new byte[parama.a()];
    this.c = 1L;
    this.e = new byte[parama.a()];
    this.b = 1L;
  }
  
  private void a()
  {
    c(this.f);
    long l = this.c;
    this.c = (1L + l);
    b(l);
    d(this.f);
  }
  
  private void b()
  {
    long l = this.b;
    this.b = (1L + l);
    b(l);
    c(this.e);
    c(this.f);
    d(this.e);
    if (this.b % a == 0L) {
      a();
    }
  }
  
  private void b(long paramLong)
  {
    int i = 0;
    while (i != 8)
    {
      this.d.a((byte)(int)paramLong);
      paramLong >>>= 8;
      i += 1;
    }
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    this.d.a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void d(byte[] paramArrayOfByte)
  {
    this.d.a(paramArrayOfByte, 0);
  }
  
  public void a(long paramLong)
  {
    try
    {
      b(paramLong);
      c(this.f);
      d(this.f);
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      c(paramArrayOfByte);
      c(this.f);
      d(this.f);
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      b();
      int i = 0;
      int k;
      for (int j = paramInt1;; j = k)
      {
        k = j;
        if (k == paramInt1 + paramInt2) {
          break;
        }
        j = i;
        if (i == this.e.length)
        {
          b();
          j = 0;
        }
        paramArrayOfByte[k] = this.e[j];
        k += 1;
        i = j + 1;
      }
      return;
    }
    finally {}
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.b
 * JD-Core Version:    0.7.0.1
 */