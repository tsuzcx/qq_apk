package com.tencent.token;

public final class abb
  extends aaz
{
  private static final int[] d = { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
  private final int[] e;
  private final int[] f;
  
  public abb()
  {
    super("SHA-256");
    this.f = new int[8];
    this.e = new int[64];
    c();
  }
  
  private abb(abb paramabb)
  {
    super(paramabb);
    int[] arrayOfInt = paramabb.f;
    if (arrayOfInt == null)
    {
      this.f = null;
    }
    else
    {
      this.f = new int[arrayOfInt.length];
      paramabb = paramabb.f;
      arrayOfInt = this.f;
      System.arraycopy(paramabb, 0, arrayOfInt, 0, arrayOfInt.length);
    }
    this.e = new int[64];
  }
  
  private static int a(int paramInt)
  {
    int i = a(paramInt, 2);
    int j = a(paramInt, 13);
    return a(paramInt, 22) ^ i ^ j;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 - paramInt2 | paramInt1 >>> paramInt2;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 ^ 0xFFFFFFFF) & paramInt3 ^ paramInt2 & paramInt1;
  }
  
  private static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)paramInt1);
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt1 + 64)
    {
      paramArrayOfInt[i] = (paramArrayOfByte[(paramInt2 + 3)] & 0xFF | (paramArrayOfByte[(paramInt2 + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 16 | paramArrayOfByte[paramInt2] << 24);
      paramInt2 += 4;
      i += 1;
    }
  }
  
  private static int b(int paramInt)
  {
    int i = a(paramInt, 6);
    int j = a(paramInt, 11);
    return a(paramInt, 25) ^ i ^ j;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 ^ paramInt1 & paramInt2 ^ paramInt2 & paramInt3;
  }
  
  private static int c(int paramInt)
  {
    return paramInt >>> 3 ^ a(paramInt, 7) ^ a(paramInt, 18);
  }
  
  private static int d(int paramInt)
  {
    return paramInt >>> 10 ^ a(paramInt, 17) ^ a(paramInt, 19);
  }
  
  final void a(byte[] paramArrayOfByte)
  {
    long l = this.b << 3;
    int i = (int)this.b & 0x3F;
    if (i >= 56) {
      i = 120 - i;
    } else {
      i = 56 - i;
    }
    Object localObject = c;
    int j = 0;
    a((byte[])localObject, 0, i);
    a((int)(l >>> 32), this.a, 56);
    a((int)l, this.a, 60);
    a(this.a, 0);
    localObject = this.f;
    i = 0;
    while (j < 32)
    {
      int k = localObject[i];
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
  
  final void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte, paramInt, this.e, 0);
    paramInt = 16;
    while (paramInt < 64)
    {
      paramArrayOfByte = this.e;
      i = d(paramArrayOfByte[(paramInt - 2)]);
      int[] arrayOfInt = this.e;
      paramArrayOfByte[paramInt] = (i + arrayOfInt[(paramInt - 7)] + c(arrayOfInt[(paramInt - 15)]) + this.e[(paramInt - 16)]);
      paramInt += 1;
    }
    paramArrayOfByte = this.f;
    paramInt = paramArrayOfByte[0];
    int i = paramArrayOfByte[1];
    int j = paramArrayOfByte[2];
    int i1 = paramArrayOfByte[3];
    int m = paramArrayOfByte[4];
    int k = paramArrayOfByte[5];
    int n = paramArrayOfByte[6];
    int i3 = paramArrayOfByte[7];
    int i2 = 0;
    while (i2 < 64)
    {
      int i4 = i3 + b(m) + a(m, k, n) + d[i2] + this.e[i2];
      int i5 = a(paramInt);
      int i6 = b(paramInt, i, j);
      i2 += 1;
      i3 = n;
      n = k;
      k = m;
      m = i1 + i4;
      i1 = j;
      j = i;
      i = paramInt;
      paramInt = i4 + (i5 + i6);
    }
    paramArrayOfByte = this.f;
    paramArrayOfByte[0] += paramInt;
    paramArrayOfByte[1] += i;
    paramArrayOfByte[2] += j;
    paramArrayOfByte[3] += i1;
    paramArrayOfByte[4] += m;
    paramArrayOfByte[5] += k;
    paramArrayOfByte[6] += n;
    paramArrayOfByte[7] += i3;
  }
  
  final void c()
  {
    int[] arrayOfInt = this.f;
    arrayOfInt[0] = 1779033703;
    arrayOfInt[1] = -1150833019;
    arrayOfInt[2] = 1013904242;
    arrayOfInt[3] = -1521486534;
    arrayOfInt[4] = 1359893119;
    arrayOfInt[5] = -1694144372;
    arrayOfInt[6] = 528734635;
    arrayOfInt[7] = 1541459225;
  }
  
  public final Object clone()
  {
    return new abb(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abb
 * JD-Core Version:    0.7.0.1
 */