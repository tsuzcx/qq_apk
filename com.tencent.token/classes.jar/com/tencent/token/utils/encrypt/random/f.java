package com.tencent.token.utils.encrypt.random;

public final class f
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
    b();
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
    this.f[14] = ((int)(paramLong >>> 32));
    this.f[15] = ((int)(0xFFFFFFFF & paramLong));
  }
  
  protected final void a(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.f;
    int i = this.g;
    this.g = (i + 1);
    arrayOfInt[i] = ((paramArrayOfByte[paramInt] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF);
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
    while (i != this.f.length)
    {
      this.f[i] = 0;
      i += 1;
    }
  }
  
  protected final void c()
  {
    int i = 16;
    while (i < 80)
    {
      j = this.f[(i - 3)] ^ this.f[(i - 8)] ^ this.f[(i - 14)] ^ this.f[(i - 16)];
      this.f[i] = (j >>> 31 | j << 1);
      i += 1;
    }
    int n = this.a;
    int i1 = this.b;
    i = this.c;
    int j = this.d;
    int m = this.e;
    int k = 0;
    int i2 = 0;
    int[] arrayOfInt;
    int i4;
    while (i2 < 4)
    {
      arrayOfInt = this.f;
      i3 = k + 1;
      m = arrayOfInt[k] + ((n << 5 | n >>> 27) + (i1 & i | (i1 ^ 0xFFFFFFFF) & j)) + 1518500249 + m;
      k = i1 >>> 2 | i1 << 30;
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (m << 5 | m >>> 27) + (n & k | (n ^ 0xFFFFFFFF) & i) + arrayOfInt[i3] + 1518500249;
      n = n >>> 2 | n << 30;
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (j << 5 | j >>> 27) + (m & n | (m ^ 0xFFFFFFFF) & k) + arrayOfInt[i1] + 1518500249;
      m = m << 30 | m >>> 2;
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((i << 5 | i >>> 27) + (j & m | (j ^ 0xFFFFFFFF) & n) + arrayOfInt[i3] + 1518500249);
      j = j >>> 2 | j << 30;
      arrayOfInt = this.f;
      k = i4 + 1;
      n += (i & j | (i ^ 0xFFFFFFFF) & m) + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] + 1518500249;
      i = i >>> 2 | i << 30;
      i2 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      arrayOfInt = this.f;
      i3 = k + 1;
      m = arrayOfInt[k] + ((n << 5 | n >>> 27) + (i1 ^ i ^ j)) + 1859775393 + m;
      k = i1 >>> 2 | i1 << 30;
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (m << 5 | m >>> 27) + (n ^ k ^ i) + arrayOfInt[i3] + 1859775393;
      n = n >>> 2 | n << 30;
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (j << 5 | j >>> 27) + (m ^ n ^ k) + arrayOfInt[i1] + 1859775393;
      m = m << 30 | m >>> 2;
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((i << 5 | i >>> 27) + (j ^ m ^ n) + arrayOfInt[i3] + 1859775393);
      j = j >>> 2 | j << 30;
      arrayOfInt = this.f;
      k = i4 + 1;
      n += (i ^ j ^ m) + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] + 1859775393;
      i = i >>> 2 | i << 30;
      i2 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      arrayOfInt = this.f;
      i3 = k + 1;
      m = arrayOfInt[k] + ((n << 5 | n >>> 27) + (i1 & i | i1 & j | i & j)) - 1894007588 + m;
      k = i1 >>> 2 | i1 << 30;
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (m << 5 | m >>> 27) + (n & k | n & i | k & i) + arrayOfInt[i3] - 1894007588;
      n = n >>> 2 | n << 30;
      arrayOfInt = this.f;
      i3 = i1 + 1;
      i += (j << 5 | j >>> 27) + (m & n | m & k | n & k) + arrayOfInt[i1] - 1894007588;
      m = m << 30 | m >>> 2;
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((i << 5 | i >>> 27) + (j & m | j & n | m & n) + arrayOfInt[i3] - 1894007588);
      j = j >>> 2 | j << 30;
      arrayOfInt = this.f;
      k = i4 + 1;
      n += (i & j | i & m | j & m) + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] - 1894007588;
      i = i >>> 2 | i << 30;
      i2 += 1;
    }
    int i3 = 0;
    i2 = n;
    n = i;
    i = i3;
    while (i <= 3)
    {
      arrayOfInt = this.f;
      i3 = k + 1;
      m = arrayOfInt[k] + ((i2 << 5 | i2 >>> 27) + (i1 ^ n ^ j)) - 899497514 + m;
      k = i1 >>> 2 | i1 << 30;
      arrayOfInt = this.f;
      i1 = i3 + 1;
      j += (m << 5 | m >>> 27) + (i2 ^ k ^ n) + arrayOfInt[i3] - 899497514;
      i2 = i2 >>> 2 | i2 << 30;
      arrayOfInt = this.f;
      i3 = i1 + 1;
      n += (j << 5 | j >>> 27) + (m ^ i2 ^ k) + arrayOfInt[i1] - 899497514;
      m = m << 30 | m >>> 2;
      arrayOfInt = this.f;
      i4 = i3 + 1;
      i1 = k + ((n << 5 | n >>> 27) + (j ^ m ^ i2) + arrayOfInt[i3] - 899497514);
      j = j >>> 2 | j << 30;
      arrayOfInt = this.f;
      k = i4 + 1;
      i2 += (n ^ j ^ m) + (i1 << 5 | i1 >>> 27) + arrayOfInt[i4] - 899497514;
      n = n >>> 2 | n << 30;
      i += 1;
    }
    this.a += i2;
    this.b += i1;
    this.c += n;
    this.d += j;
    this.e += m;
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