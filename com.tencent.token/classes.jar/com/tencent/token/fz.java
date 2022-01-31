package com.tencent.token;

public final class fz
  extends fx
{
  private static final int[] d = { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
  private final int[] e;
  private final int[] f;
  
  public fz()
  {
    super("SHA-256");
    this.f = new int[8];
    this.e = new int[64];
    a();
  }
  
  private fz(fz paramfz)
  {
    super(paramfz);
    if (paramfz.f == null) {
      this.f = null;
    }
    for (;;)
    {
      this.e = new int[64];
      return;
      this.f = new int[paramfz.f.length];
      System.arraycopy(paramfz.f, 0, this.f, 0, this.f.length);
    }
  }
  
  private static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)paramInt1);
  }
  
  final void a()
  {
    this.f[0] = 1779033703;
    this.f[1] = -1150833019;
    this.f[2] = 1013904242;
    this.f[3] = -1521486534;
    this.f[4] = 1359893119;
    this.f[5] = -1694144372;
    this.f[6] = 528734635;
    this.f[7] = 1541459225;
  }
  
  final void a(byte[] paramArrayOfByte)
  {
    int j = 0;
    long l = this.b << 3;
    int i = (int)this.b & 0x3F;
    if (i >= 56) {}
    for (i = 120 - i;; i = 56 - i)
    {
      a(c, 0, i);
      a((int)(l >>> 32), this.a, 56);
      a((int)l, this.a, 60);
      a(this.a, 0);
      int[] arrayOfInt = this.f;
      int k = 0;
      i = j;
      j = k;
      while (j < 32)
      {
        k = arrayOfInt[i];
        int m = j + 1;
        paramArrayOfByte[j] = ((byte)(k >> 24));
        j = m + 1;
        paramArrayOfByte[m] = ((byte)(k >> 16));
        m = j + 1;
        paramArrayOfByte[j] = ((byte)(k >> 8));
        j = m + 1;
        paramArrayOfByte[m] = ((byte)k);
        i += 1;
      }
    }
  }
  
  final void a(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.e;
    int j = 0;
    int i = paramInt;
    while (i < paramInt + 64)
    {
      arrayOfInt[j] = (paramArrayOfByte[(i + 3)] & 0xFF | (paramArrayOfByte[(i + 2)] & 0xFF) << 8 | (paramArrayOfByte[(i + 1)] & 0xFF) << 16 | paramArrayOfByte[i] << 24);
      i += 4;
      j += 1;
    }
    paramInt = 16;
    while (paramInt < 64)
    {
      paramArrayOfByte = this.e;
      i = this.e[(paramInt - 2)];
      j = this.e[(paramInt - 7)];
      k = this.e[(paramInt - 15)];
      paramArrayOfByte[paramInt] = ((i >>> 10 ^ (i >>> 17 | i << 15) ^ (i >>> 19 | i << 13)) + j + (k >>> 3 ^ (k >>> 7 | k << 25) ^ (k >>> 18 | k << 14)) + this.e[(paramInt - 16)]);
      paramInt += 1;
    }
    paramInt = this.f[0];
    int n = this.f[1];
    int m = this.f[2];
    int i1 = this.f[3];
    i = this.f[4];
    j = this.f[5];
    int k = this.f[6];
    int i3 = this.f[7];
    int i2 = 0;
    while (i2 < 64)
    {
      int i4 = d[i2];
      i3 = this.e[i2] + (i3 + ((i >>> 6 | i << 26) ^ (i >>> 11 | i << 21) ^ (i >>> 25 | i << 7)) + (i & j ^ (i ^ 0xFFFFFFFF) & k) + i4);
      i2 += 1;
      i1 += i3;
      int i5 = n;
      i4 = paramInt;
      paramInt = i3 + ((paramInt & n ^ paramInt & m ^ n & m) + ((paramInt >>> 2 | paramInt << 30) ^ (paramInt >>> 13 | paramInt << 19) ^ (paramInt >>> 22 | paramInt << 10)));
      i3 = k;
      k = j;
      j = i;
      i = i1;
      i1 = m;
      m = i5;
      n = i4;
    }
    paramArrayOfByte = this.f;
    paramArrayOfByte[0] = (paramInt + paramArrayOfByte[0]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[1] = (n + paramArrayOfByte[1]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[2] = (m + paramArrayOfByte[2]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[3] = (i1 + paramArrayOfByte[3]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[4] = (i + paramArrayOfByte[4]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[5] = (j + paramArrayOfByte[5]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[6] = (k + paramArrayOfByte[6]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[7] = (i3 + paramArrayOfByte[7]);
  }
  
  public final Object clone()
  {
    return new fz(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fz
 * JD-Core Version:    0.7.0.1
 */