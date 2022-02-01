package com.tencent.token;

public final class abz
  extends abx
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int[] f = new int[80];
  private int g;
  
  public abz()
  {
    b();
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 ^ 0xFFFFFFFF) & paramInt3 | paramInt2 & paramInt1;
  }
  
  private static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 24));
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)paramInt1);
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  public final int a(byte[] paramArrayOfByte)
  {
    a();
    a(this.a, paramArrayOfByte, 0);
    a(this.b, paramArrayOfByte, 4);
    a(this.c, paramArrayOfByte, 8);
    a(this.d, paramArrayOfByte, 12);
    a(this.e, paramArrayOfByte, 16);
    b();
    return 20;
  }
  
  protected final void a(long paramLong)
  {
    if (this.g > 14) {
      c();
    }
    int[] arrayOfInt = this.f;
    arrayOfInt[14] = ((int)(paramLong >>> 32));
    arrayOfInt[15] = ((int)(paramLong & 0xFFFFFFFF));
  }
  
  protected final void a(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.f;
    int i = this.g;
    this.g = (i + 1);
    int j = paramArrayOfByte[paramInt];
    int k = paramArrayOfByte[(paramInt + 1)];
    int m = paramArrayOfByte[(paramInt + 2)];
    arrayOfInt[i] = (paramArrayOfByte[(paramInt + 3)] & 0xFF | (j & 0xFF) << 24 | (k & 0xFF) << 16 | (m & 0xFF) << 8);
    if (this.g == 16) {
      c();
    }
  }
  
  public final void b()
  {
    super.b();
    this.a = 1732584193;
    this.b = -271733879;
    this.c = -1732584194;
    this.d = 271733878;
    this.e = -1009589776;
    this.g = 0;
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.f;
      if (i == arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  protected final void c()
  {
    int i = 16;
    int[] arrayOfInt;
    while (i < 80)
    {
      arrayOfInt = this.f;
      j = arrayOfInt[(i - 3)] ^ arrayOfInt[(i - 8)] ^ arrayOfInt[(i - 14)] ^ arrayOfInt[(i - 16)];
      arrayOfInt[i] = (j >>> 31 | j << 1);
      i += 1;
    }
    int j = this.a;
    int k = this.b;
    i = this.c;
    int m = this.d;
    int n = this.e;
    int i1 = 0;
    int i2 = 0;
    int i4;
    while (i2 < 4)
    {
      i4 = a(k, i, m);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      n += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] + 1518500249;
      k = k >>> 2 | k << 30;
      i4 = a(j, k, i);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      m += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] + 1518500249;
      j = j >>> 2 | j << 30;
      i4 = a(n, j, k);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (m << 5 | m >>> 27) + i4 + arrayOfInt[i1] + 1518500249;
      n = n >>> 2 | n << 30;
      i4 = a(m, n, j);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      k += (i << 5 | i >>> 27) + i4 + arrayOfInt[i3] + 1518500249;
      m = m >>> 2 | m << 30;
      j += (k << 5 | k >>> 27) + a(i, m, n) + this.f[i1] + 1518500249;
      i = i >>> 2 | i << 30;
      i2 += 1;
      i1 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      arrayOfInt = this.f;
      i3 = i1 + 1;
      n += (j << 5 | j >>> 27) + (k ^ i ^ m) + arrayOfInt[i1] + 1859775393;
      k = k >>> 2 | k << 30;
      i1 = i3 + 1;
      m += (n << 5 | n >>> 27) + (j ^ k ^ i) + arrayOfInt[i3] + 1859775393;
      j = j >>> 2 | j << 30;
      i3 = i1 + 1;
      i += (m << 5 | m >>> 27) + (n ^ j ^ k) + arrayOfInt[i1] + 1859775393;
      n = n >>> 2 | n << 30;
      i1 = i3 + 1;
      k += (i << 5 | i >>> 27) + (m ^ n ^ j) + arrayOfInt[i3] + 1859775393;
      m = m >>> 2 | m << 30;
      j += (k << 5 | k >>> 27) + (i ^ m ^ n) + arrayOfInt[i1] + 1859775393;
      i = i >>> 2 | i << 30;
      i2 += 1;
      i1 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      i4 = b(k, i, m);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      n += (j << 5 | j >>> 27) + i4 + arrayOfInt[i1] - 1894007588;
      k = k >>> 2 | k << 30;
      i4 = b(j, k, i);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      m += (n << 5 | n >>> 27) + i4 + arrayOfInt[i3] - 1894007588;
      j = j >>> 2 | j << 30;
      i4 = b(n, j, k);
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (m << 5 | m >>> 27) + i4 + arrayOfInt[i1] - 1894007588;
      n = n >>> 2 | n << 30;
      i4 = b(m, n, j);
      arrayOfInt = this.f;
      i1 = i3 + 1;
      k += (i << 5 | i >>> 27) + i4 + arrayOfInt[i3] - 1894007588;
      m = m >>> 2 | m << 30;
      j += (k << 5 | k >>> 27) + b(i, m, n) + this.f[i1] - 1894007588;
      i = i >>> 2 | i << 30;
      i2 += 1;
      i1 += 1;
    }
    int i3 = 0;
    i2 = i1;
    i1 = m;
    m = i;
    i = i3;
    while (i <= 3)
    {
      arrayOfInt = this.f;
      i3 = i2 + 1;
      n += (j << 5 | j >>> 27) + (k ^ m ^ i1) + arrayOfInt[i2] - 899497514;
      k = k >>> 2 | k << 30;
      i2 = i3 + 1;
      i1 += (n << 5 | n >>> 27) + (j ^ k ^ m) + arrayOfInt[i3] - 899497514;
      j = j >>> 2 | j << 30;
      i3 = i2 + 1;
      m += (i1 << 5 | i1 >>> 27) + (n ^ j ^ k) + arrayOfInt[i2] - 899497514;
      n = n >>> 2 | n << 30;
      i2 = i3 + 1;
      k += (m << 5 | m >>> 27) + (i1 ^ n ^ j) + arrayOfInt[i3] - 899497514;
      i1 = i1 >>> 2 | i1 << 30;
      j += (k << 5 | k >>> 27) + (m ^ i1 ^ n) + arrayOfInt[i2] - 899497514;
      m = m >>> 2 | m << 30;
      i += 1;
      i2 += 1;
    }
    this.a += j;
    this.b += k;
    this.c += m;
    this.d += i1;
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
 * Qualified Name:     com.tencent.token.abz
 * JD-Core Version:    0.7.0.1
 */