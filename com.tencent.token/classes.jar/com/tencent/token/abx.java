package com.tencent.token;

public abstract class abx
  implements abw
{
  private byte[] a = new byte[4];
  private int b = 0;
  private long c;
  
  public final void a()
  {
    long l = this.c;
    a((byte)-128);
    while (this.b != 0) {
      a((byte)0);
    }
    a(l << 3);
    c();
  }
  
  public final void a(byte paramByte)
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = paramByte;
    if (this.b == arrayOfByte.length)
    {
      a(arrayOfByte, 0);
      this.b = 0;
    }
    this.c += 1L;
  }
  
  protected abstract void a(long paramLong);
  
  protected abstract void a(byte[] paramArrayOfByte, int paramInt);
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    int j = paramInt1;
    for (;;)
    {
      paramInt1 = j;
      paramInt2 = i;
      if (this.b == 0) {
        break;
      }
      paramInt1 = j;
      paramInt2 = i;
      if (i <= 0) {
        break;
      }
      a(paramArrayOfByte[j]);
      j += 1;
      i -= 1;
    }
    for (;;)
    {
      i = paramInt1;
      j = paramInt2;
      if (paramInt2 <= this.a.length) {
        break;
      }
      a(paramArrayOfByte, paramInt1);
      byte[] arrayOfByte = this.a;
      paramInt1 += arrayOfByte.length;
      paramInt2 -= arrayOfByte.length;
      this.c += arrayOfByte.length;
    }
    while (j > 0)
    {
      a(paramArrayOfByte[i]);
      i += 1;
      j -= 1;
    }
  }
  
  public void b()
  {
    this.c = 0L;
    this.b = 0;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.a;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
  }
  
  protected abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abx
 * JD-Core Version:    0.7.0.1
 */