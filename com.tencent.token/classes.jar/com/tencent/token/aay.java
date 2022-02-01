package com.tencent.token;

abstract class aay
  extends aaz
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
  
  aay(aay paramaay)
  {
    this.d = paramaay.d;
    this.e = paramaay.e;
    this.f = paramaay.f;
    byte[] arrayOfByte1 = paramaay.a;
    if (arrayOfByte1 == null)
    {
      this.a = null;
    }
    else
    {
      this.a = new byte[arrayOfByte1.length];
      arrayOfByte1 = paramaay.a;
      byte[] arrayOfByte2 = this.a;
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    }
    this.g = paramaay.g;
    this.b = paramaay.b;
  }
  
  aay(String paramString)
  {
    this.d = paramString;
    this.e = 32;
    this.f = 64;
    this.a = new byte[64];
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
  
  abstract void a(byte[] paramArrayOfByte);
  
  abstract void a(byte[] paramArrayOfByte, int paramInt);
  
  protected final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    if ((paramInt2 >= 0) && (paramArrayOfByte.length - paramInt2 >= 0))
    {
      if (this.b < 0L) {
        a();
      }
      this.b += paramInt2;
      int j = this.g;
      int i = paramInt2;
      if (j != 0)
      {
        paramInt1 = Math.min(paramInt2, this.f - j);
        System.arraycopy(paramArrayOfByte, 0, this.a, this.g, paramInt1);
        this.g += paramInt1;
        i = paramInt2 - paramInt1;
        if (this.g >= this.f)
        {
          a(this.a, 0);
          this.g = 0;
        }
        paramInt1 += 0;
      }
      while (i >= this.f)
      {
        a(paramArrayOfByte, paramInt1);
        paramInt2 = this.f;
        i -= paramInt2;
        paramInt1 += paramInt2;
      }
      if (i > 0)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.a, 0, i);
        this.g = i;
      }
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  protected final byte[] b()
  {
    int i = this.e;
    Object localObject = new byte[i];
    try
    {
      int j = localObject.length;
      if (j >= i)
      {
        if (j >= 0)
        {
          if (this.b < 0L) {
            a();
          }
          a((byte[])localObject);
          this.b = -1L;
          return localObject;
        }
        throw new Exception("Buffer too short to store digest");
      }
      localObject = new StringBuffer("Length must be at least ");
      ((StringBuffer)localObject).append(this.e);
      ((StringBuffer)localObject).append(" for ");
      ((StringBuffer)localObject).append(this.d);
      ((StringBuffer)localObject).append("digests");
      throw new Exception(((StringBuffer)localObject).toString());
    }
    catch (Exception localException)
    {
      label112:
      break label112;
    }
    return null;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return b();
  }
  
  abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aay
 * JD-Core Version:    0.7.0.1
 */