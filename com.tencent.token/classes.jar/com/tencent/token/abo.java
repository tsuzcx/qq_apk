package com.tencent.token;

public final class abo
  implements abr
{
  private static long a = 10L;
  private long b;
  private long c;
  private abn d;
  private byte[] e;
  private byte[] f;
  
  public abo(abn paramabn)
  {
    this.d = paramabn;
    this.f = new byte[20];
    this.c = 1L;
    this.e = new byte[20];
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
    this.d.a(paramArrayOfByte);
  }
  
  public final void a(long paramLong)
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
  
  public final void a(byte[] paramArrayOfByte)
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
  
  public final void b(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    try
    {
      b();
      int j = 0;
      int k;
      for (int i = 0; j != m + 0; i = k + 1)
      {
        k = i;
        if (i == this.e.length)
        {
          b();
          k = 0;
        }
        paramArrayOfByte[j] = this.e[k];
        j += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abo
 * JD-Core Version:    0.7.0.1
 */