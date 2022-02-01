package com.tencent.token;

public final class du
  extends ds
{
  private static final int[] d = { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
  private final int[] e;
  private final int[] f;
  
  public du()
  {
    super("SHA-256", 32, 64);
    this.f = new int[8];
    this.e = new int[64];
    c();
  }
  
  private du(du paramdu)
  {
    super(paramdu);
    if (paramdu.f == null) {
      this.f = null;
    }
    for (;;)
    {
      this.e = new int[64];
      return;
      this.f = new int[paramdu.f.length];
      System.arraycopy(paramdu.f, 0, this.f, 0, this.f.length);
    }
  }
  
  private static int a(int paramInt)
  {
    return b(paramInt, 2) ^ b(paramInt, 13) ^ b(paramInt, 22);
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> paramInt2;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 ^ (paramInt1 ^ 0xFFFFFFFF) & paramInt3;
  }
  
  static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)paramInt1);
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    a(paramArrayOfByte, paramInt, paramArrayOfInt, 0, 64);
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt3 + paramInt1)
    {
      paramArrayOfInt[i] = (paramArrayOfByte[(paramInt2 + 3)] & 0xFF | (paramArrayOfByte[(paramInt2 + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 16 | paramArrayOfByte[paramInt2] << 24);
      paramInt2 += 4;
      i += 1;
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt3 + paramInt2)
    {
      int j = paramArrayOfInt[paramInt1];
      int k = i + 1;
      paramArrayOfByte[i] = ((byte)(j >> 24));
      i = k + 1;
      paramArrayOfByte[k] = ((byte)(j >> 16));
      k = i + 1;
      paramArrayOfByte[i] = ((byte)(j >> 8));
      i = k + 1;
      paramArrayOfByte[k] = ((byte)j);
      paramInt1 += 1;
    }
  }
  
  private static int b(int paramInt)
  {
    return b(paramInt, 6) ^ b(paramInt, 11) ^ b(paramInt, 25);
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> paramInt2 | paramInt1 << 32 - paramInt2;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 ^ paramInt1 & paramInt3 ^ paramInt2 & paramInt3;
  }
  
  private static int c(int paramInt)
  {
    return b(paramInt, 7) ^ b(paramInt, 18) ^ a(paramInt, 3);
  }
  
  private static int d(int paramInt)
  {
    return b(paramInt, 17) ^ b(paramInt, 19) ^ a(paramInt, 10);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte, paramInt, this.e);
    paramInt = 16;
    while (paramInt < 64)
    {
      this.e[paramInt] = (d(this.e[(paramInt - 2)]) + this.e[(paramInt - 7)] + c(this.e[(paramInt - 15)]) + this.e[(paramInt - 16)]);
      paramInt += 1;
    }
    paramInt = this.f[0];
    int i = this.f[1];
    int n = this.f[2];
    int i1 = this.f[3];
    int j = this.f[4];
    int k = this.f[5];
    int m = this.f[6];
    int i3 = this.f[7];
    int i2 = 0;
    while (i2 < 64)
    {
      int i4 = b(j);
      int i5 = a(j, k, m);
      int i6 = d[i2];
      i3 = this.e[i2] + (i3 + i4 + i5 + i6);
      i4 = a(paramInt);
      i5 = b(paramInt, i, n);
      i2 += 1;
      i1 += i3;
      i4 = i3 + (i5 + i4);
      i3 = m;
      m = k;
      k = j;
      j = i1;
      i1 = n;
      n = i;
      i = paramInt;
      paramInt = i4;
    }
    paramArrayOfByte = this.f;
    paramArrayOfByte[0] = (paramInt + paramArrayOfByte[0]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[1] = (i + paramArrayOfByte[1]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[2] = (n + paramArrayOfByte[2]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[3] = (i1 + paramArrayOfByte[3]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[4] = (j + paramArrayOfByte[4]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[5] = (k + paramArrayOfByte[5]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[6] = (m + paramArrayOfByte[6]);
    paramArrayOfByte = this.f;
    paramArrayOfByte[7] = (i3 + paramArrayOfByte[7]);
  }
  
  void b(byte[] paramArrayOfByte, int paramInt)
  {
    long l = this.b << 3;
    int i = (int)this.b & 0x3F;
    if (i >= 56) {}
    for (i = 120 - i;; i = 56 - i)
    {
      a(c, 0, i);
      a((int)(l >>> 32), this.a, 56);
      a((int)l, this.a, 60);
      a(this.a, 0);
      a(this.f, 0, paramArrayOfByte, paramInt, 32);
      return;
    }
  }
  
  void c()
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
  
  public Object clone()
  {
    return new du(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.du
 * JD-Core Version:    0.7.0.1
 */