package com.tencent.token.utils.encrypt.random;

public final class b
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
    this.f = new byte[20];
    this.c = 1L;
    this.e = new byte[20];
    this.b = 1L;
  }
  
  private void a()
  {
    int j = 0;
    long l = this.b;
    this.b = (l + 1L);
    int i = 0;
    while (i != 8)
    {
      this.d.a((byte)(int)l);
      l >>>= 8;
      i += 1;
    }
    byte[] arrayOfByte = this.e;
    this.d.a(arrayOfByte, 0, arrayOfByte.length);
    arrayOfByte = this.f;
    this.d.a(arrayOfByte, 0, arrayOfByte.length);
    arrayOfByte = this.e;
    this.d.a(arrayOfByte);
    if (this.b % a == 0L)
    {
      arrayOfByte = this.f;
      this.d.a(arrayOfByte, 0, arrayOfByte.length);
      l = this.c;
      this.c = (l + 1L);
      i = j;
      while (i != 8)
      {
        this.d.a((byte)(int)l);
        l >>>= 8;
        i += 1;
      }
      arrayOfByte = this.f;
      this.d.a(arrayOfByte);
    }
  }
  
  public final void a(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      if (i != 8) {}
      byte[] arrayOfByte;
      try
      {
        this.d.a((byte)(int)paramLong);
        paramLong >>>= 8;
        i += 1;
      }
      finally {}
    }
    arrayOfByte = this.f;
    this.d.a(arrayOfByte, 0, arrayOfByte.length);
    arrayOfByte = this.f;
    this.d.a(arrayOfByte);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    try
    {
      this.d.a(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = this.f;
      this.d.a(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = this.f;
      this.d.a(paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    try
    {
      a();
      int j = 0;
      int k;
      for (int i = 0; j != m + 0; i = k + 1)
      {
        k = i;
        if (i == this.e.length)
        {
          a();
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
 * Qualified Name:     com.tencent.token.utils.encrypt.random.b
 * JD-Core Version:    0.7.0.1
 */