package com.tencent.token;

abstract class dt
  extends du
{
  static final byte[] c = new byte[''];
  final byte[] a;
  long b;
  private final String d;
  private final int e;
  private final int f;
  private int g;
  
  static
  {
    c[0] = -128;
  }
  
  dt(dt paramdt)
  {
    this.d = paramdt.d;
    this.e = paramdt.e;
    this.f = paramdt.f;
    if (paramdt.a == null) {
      this.a = null;
    }
    for (;;)
    {
      this.g = paramdt.g;
      this.b = paramdt.b;
      return;
      this.a = new byte[paramdt.a.length];
      System.arraycopy(paramdt.a, 0, this.a, 0, this.a.length);
    }
  }
  
  dt(String paramString, int paramInt1, int paramInt2)
  {
    this.d = paramString;
    this.e = paramInt1;
    this.f = paramInt2;
    this.a = new byte[paramInt2];
  }
  
  protected final void a()
  {
    if (this.b == 0L) {
      return;
    }
    c();
    this.g = 0;
    this.b = 0L;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt);
  
  protected final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    int i;
    int j;
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramArrayOfByte.length - paramInt2)) {
        throw new ArrayIndexOutOfBoundsException();
      }
      if (this.b < 0L) {
        a();
      }
      this.b += paramInt2;
      i = paramInt1;
      j = paramInt2;
      if (this.g != 0)
      {
        i = Math.min(paramInt2, this.f - this.g);
        System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.g, i);
        this.g += i;
        paramInt1 += i;
        paramInt2 -= i;
        i = paramInt1;
        j = paramInt2;
        if (this.g >= this.f)
        {
          a(this.a, 0);
          this.g = 0;
          j = paramInt2;
          i = paramInt1;
        }
      }
      while (j >= this.f)
      {
        a(paramArrayOfByte, i);
        j -= this.f;
        i += this.f;
      }
    } while (j <= 0);
    System.arraycopy(paramArrayOfByte, i, this.a, 0, j);
    this.g = j;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return b();
  }
  
  protected final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < this.e) {
      throw new Exception("Length must be at least " + this.e + " for " + this.d + "digests");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramArrayOfByte.length - paramInt2)) {
      throw new Exception("Buffer too short to store digest");
    }
    if (this.b < 0L) {
      a();
    }
    b(paramArrayOfByte, paramInt1);
    this.b = -1L;
    return this.e;
  }
  
  abstract void b(byte[] paramArrayOfByte, int paramInt);
  
  protected final byte[] b()
  {
    byte[] arrayOfByte = new byte[this.e];
    try
    {
      b(arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    catch (Exception localException) {}
    return null;
  }
  
  abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dt
 * JD-Core Version:    0.7.0.1
 */