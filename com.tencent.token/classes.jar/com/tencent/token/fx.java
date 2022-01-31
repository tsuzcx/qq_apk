package com.tencent.token;

abstract class fx
  extends fy
{
  static final byte[] c;
  final byte[] a;
  long b;
  private final String d;
  private final int e;
  private final int f;
  private int g;
  
  static
  {
    byte[] arrayOfByte = new byte[''];
    c = arrayOfByte;
    arrayOfByte[0] = -128;
  }
  
  fx(fx paramfx)
  {
    this.d = paramfx.d;
    this.e = paramfx.e;
    this.f = paramfx.f;
    if (paramfx.a == null) {
      this.a = null;
    }
    for (;;)
    {
      this.g = paramfx.g;
      this.b = paramfx.b;
      return;
      this.a = new byte[paramfx.a.length];
      System.arraycopy(paramfx.a, 0, this.a, 0, this.a.length);
    }
  }
  
  fx(String paramString)
  {
    this.d = paramString;
    this.e = 32;
    this.f = 64;
    this.a = new byte[64];
  }
  
  private byte[] b()
  {
    byte[] arrayOfByte = new byte[this.e];
    try
    {
      int i = arrayOfByte.length;
      if (i < this.e) {
        throw new Exception("Length must be at least " + this.e + " for " + this.d + "digests");
      }
      if ((i < 0) || (arrayOfByte.length - i < 0)) {
        throw new Exception("Buffer too short to store digest");
      }
      if ((this.b < 0L) && (this.b != 0L))
      {
        a();
        this.g = 0;
        this.b = 0L;
      }
      a(arrayOfByte);
      this.b = -1L;
      return arrayOfByte;
    }
    catch (Exception localException) {}
    return null;
  }
  
  abstract void a();
  
  abstract void a(byte[] paramArrayOfByte);
  
  abstract void a(byte[] paramArrayOfByte, int paramInt);
  
  protected final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    int i;
    do
    {
      return;
      if ((paramInt2 < 0) || (paramArrayOfByte.length - paramInt2 < 0)) {
        throw new ArrayIndexOutOfBoundsException();
      }
      if ((this.b < 0L) && (this.b != 0L))
      {
        a();
        this.g = 0;
        this.b = 0L;
      }
      this.b += paramInt2;
      i = paramInt2;
      if (this.g != 0)
      {
        paramInt1 = Math.min(paramInt2, this.f - this.g);
        System.arraycopy(paramArrayOfByte, 0, this.a, this.g, paramInt1);
        this.g += paramInt1;
        int j = paramInt1 + 0;
        paramInt2 -= paramInt1;
        paramInt1 = j;
        i = paramInt2;
        if (this.g >= this.f)
        {
          a(this.a, 0);
          this.g = 0;
          i = paramInt2;
          paramInt1 = j;
        }
      }
      while (i >= this.f)
      {
        a(paramArrayOfByte, paramInt1);
        i -= this.f;
        paramInt1 += this.f;
      }
    } while (i <= 0);
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, 0, i);
    this.g = i;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fx
 * JD-Core Version:    0.7.0.1
 */