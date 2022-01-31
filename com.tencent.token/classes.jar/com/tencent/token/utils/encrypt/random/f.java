package com.tencent.token.utils.encrypt.random;

public class f
  extends d
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int[] f = new int[80];
  private int g;
  
  public f()
  {
    c();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 | (paramInt1 ^ 0xFFFFFFFF) & paramInt3;
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 24));
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >>> 16));
    i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[i] = ((byte)paramInt1);
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private int c(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 | paramInt1 & paramInt3 | paramInt2 & paramInt3;
  }
  
  public int a()
  {
    return 20;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    b();
    a(this.a, paramArrayOfByte, paramInt);
    a(this.b, paramArrayOfByte, paramInt + 4);
    a(this.c, paramArrayOfByte, paramInt + 8);
    a(this.d, paramArrayOfByte, paramInt + 12);
    a(this.e, paramArrayOfByte, paramInt + 16);
    c();
    return 20;
  }
  
  protected void a(long paramLong)
  {
    if (this.g > 14) {
      d();
    }
    this.f[14] = ((int)(paramLong >>> 32));
    this.f[15] = ((int)(0xFFFFFFFF & paramLong));
  }
  
  protected void b(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.f;
    int i = this.g;
    this.g = (i + 1);
    arrayOfInt[i] = ((paramArrayOfByte[paramInt] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF);
    if (this.g == 16) {
      d();
    }
  }
  
  public void c()
  {
    super.c();
    this.a = 1732584193;
    this.b = -271733879;
    this.c = -1732584194;
    this.d = 271733878;
    this.e = -1009589776;
    this.g = 0;
    int i = 0;
    while (i != this.f.length)
    {
      this.f[i] = 0;
      i += 1;
    }
  }
  
  protected void d()
  {
    int i = 16;
    while (i < 80)
    {
      j = this.f[(i - 3)] ^ this.f[(i - 8)] ^ this.f[(i - 14)] ^ this.f[(i - 16)];
      this.f[i] = (j >>> 31 | j << 1);
      i += 1;
    }
    int m = this.a;
    int i1 = this.b;
    i = this.c;
    int j = this.d;
    int n = this.e;
    int k = 0;
    int i2 = 0;
    int i4;
    int[] arrayOfInt;
    while (i2 < 4)
    {
      i4 = a(i1, i, j);
      arrayOfInt = this.f;
      i3 = k + 1;
      n = arrayOfInt[k] + ((m << 5 | m >>> 27) + i4) + 1518500249 + n;
      k = i1 >>> 2 | i1 << 30;
      i4 = a(m, k, i);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] + 1518500249;
      m = m >>> 2 | m << 30;
      i4 = a(n, m, k);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] + 1518500249;
      n = n << 30 | n >>> 2;
      i1 = a(j, n, m);
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((i << 5 | i >>> 27) + i1 + arrayOfInt[i3] + 1518500249);
      j = j >>> 2 | j << 30;
      i3 = a(i, j, n);
      arrayOfInt = this.f;
      k = i4 + 1;
      m += i3 + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] + 1518500249;
      i = i >>> 2 | i << 30;
      i2 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      i4 = b(i1, i, j);
      arrayOfInt = this.f;
      i3 = k + 1;
      n = arrayOfInt[k] + ((m << 5 | m >>> 27) + i4) + 1859775393 + n;
      k = i1 >>> 2 | i1 << 30;
      i4 = b(m, k, i);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] + 1859775393;
      m = m >>> 2 | m << 30;
      i4 = b(n, m, k);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] + 1859775393;
      n = n << 30 | n >>> 2;
      i1 = b(j, n, m);
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((i << 5 | i >>> 27) + i1 + arrayOfInt[i3] + 1859775393);
      j = j >>> 2 | j << 30;
      i3 = b(i, j, n);
      arrayOfInt = this.f;
      k = i4 + 1;
      m += i3 + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] + 1859775393;
      i = i >>> 2 | i << 30;
      i2 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      i4 = c(i1, i, j);
      arrayOfInt = this.f;
      i3 = k + 1;
      n = arrayOfInt[k] + ((m << 5 | m >>> 27) + i4) - 1894007588 + n;
      k = i1 >>> 2 | i1 << 30;
      i4 = c(m, k, i);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] - 1894007588;
      m = m >>> 2 | m << 30;
      i4 = c(n, m, k);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] - 1894007588;
      n = n << 30 | n >>> 2;
      i1 = c(j, n, m);
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((i << 5 | i >>> 27) + i1 + arrayOfInt[i3] - 1894007588);
      j = j >>> 2 | j << 30;
      i3 = c(i, j, n);
      arrayOfInt = this.f;
      k = i4 + 1;
      m += i3 + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] - 1894007588;
      i = i >>> 2 | i << 30;
      i2 += 1;
    }
    int i3 = 0;
    i2 = m;
    m = i;
    i = i3;
    while (i <= 3)
    {
      i4 = b(i1, m, j);
      arrayOfInt = this.f;
      i3 = k + 1;
      n = arrayOfInt[k] + ((i2 << 5 | i2 >>> 27) + i4) - 899497514 + n;
      k = i1 >>> 2 | i1 << 30;
      i4 = b(i2, k, m);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] - 899497514;
      i2 = i2 >>> 2 | i2 << 30;
      i4 = b(n, i2, k);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      m += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] - 899497514;
      n = n << 30 | n >>> 2;
      i1 = b(j, n, i2);
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((m << 5 | m >>> 27) + i1 + arrayOfInt[i3] - 899497514);
      j = j >>> 2 | j << 30;
      i3 = b(m, j, n);
      arrayOfInt = this.f;
      k = i4 + 1;
      i2 += i3 + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] - 899497514;
      m = m >>> 2 | m << 30;
      i += 1;
    }
    this.a += i2;
    this.b += i1;
    this.c += m;
    this.d += j;
    this.e += n;
    this.g = 0;
    i = 0;
    while (i < 16)
    {
      this.f[i] = 0;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.f
 * JD-Core Version:    0.7.0.1
 */