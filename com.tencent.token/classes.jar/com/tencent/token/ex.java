package com.tencent.token;

import [I;

public class ex
{
  public static final ex c;
  public static final ex d;
  public static final ex e;
  static int[] f;
  static final byte[] g;
  private static long[] m = { 0L, 0L, 1024L, 1624L, 2048L, 2378L, 2648L, 2875L, 3072L, 3247L, 3402L, 3543L, 3672L, 3790L, 3899L, 4001L, 4096L, 4186L, 4271L, 4350L, 4426L, 4498L, 4567L, 4633L, 4696L, 4756L, 4814L, 4870L, 4923L, 4975L, 5025L, 5074L, 5120L, 5166L, 5210L, 5253L, 5295L };
  private static final ex n = a(152125131763605L);
  private static ex[] o = new ex[17];
  private static ex[] p = new ex[17];
  private static final ex q;
  private static String[] r;
  private static int[] s = { 0, 0, 62, 39, 31, 27, 24, 22, 20, 19, 18, 18, 17, 17, 16, 16, 15, 15, 15, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12 };
  private static ex[] t = { null, null, a(4611686018427387904L), a(4052555153018976267L), a(4611686018427387904L), a(7450580596923828125L), a(4738381338321616896L), a(3909821048582988049L), a(1152921504606846976L), a(1350851717672992089L), a(1000000000000000000L), a(5559917313492231481L), a(2218611106740436992L), a(8650415919381337933L), a(2177953337809371136L), a(6568408355712890625L), a(1152921504606846976L), a(2862423051509815793L), a(6746640616477458432L), a(799006685782884121L), a(1638400000000000000L), a(3243919932521508681L), a(6221821273427820544L), a(504036361936467383L), a(876488338465357824L), a(1490116119384765625L), a(2481152873203736576L), a(4052555153018976267L), a(6502111422497947648L), a(353814783205469041L), a(531441000000000000L), a(787662783788549761L), a(1152921504606846976L), a(1667889514952984961L), a(2386420683693101056L), a(3379220508056640625L), a(4738381338321616896L) };
  private static int[] u = { 0, 0, 30, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5 };
  private static int[] v = { 0, 0, 1073741824, 1162261467, 1073741824, 1220703125, 362797056, 1977326743, 1073741824, 387420489, 1000000000, 214358881, 429981696, 815730721, 1475789056, 170859375, 268435456, 410338673, 612220032, 893871739, 1280000000, 1801088541, 113379904, 148035889, 191102976, 244140625, 308915776, 387420489, 481890304, 594823321, 729000000, 887503681, 1073741824, 1291467969, 1544804416, 1838265625, 60466176 };
  int a;
  int[] b;
  private int h = -1;
  private int i = -1;
  private int j = -2;
  private int k = -2;
  private int l = -2;
  
  static
  {
    int i1 = 1;
    while (i1 <= 16)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = i1;
      o[i1] = new ex(arrayOfInt, 1);
      p[i1] = new ex(arrayOfInt, -1);
      i1 += 1;
    }
    c = new ex(new int[0], 0);
    d = a(1L);
    q = a(2L);
    e = a(10L);
    f = new int[] { 7, 25, 81, 241, 673, 1793, 2147483647 };
    g = new byte[] { -25, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 6, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 7, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 6, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0 };
    r = new String[64];
    r[63] = "000000000000000000000000000000000000000000000000000000000000000";
    i1 = 0;
    while (i1 < 63)
    {
      r[i1] = r[63].substring(0, i1);
      i1 += 1;
    }
  }
  
  private ex(int paramInt, int[] paramArrayOfInt)
  {
    this.b = b(paramArrayOfInt);
    if ((paramInt < -1) || (paramInt > 1)) {
      throw new NumberFormatException("Invalid signum value");
    }
    if (this.b.length == 0)
    {
      this.a = 0;
      return;
    }
    if (paramInt == 0) {
      throw new NumberFormatException("signum-magnitude mismatch");
    }
    this.a = paramInt;
  }
  
  private ex(long paramLong)
  {
    if (paramLong < 0L)
    {
      this.a = -1;
      paramLong = -paramLong;
    }
    int i1;
    for (;;)
    {
      i1 = (int)(paramLong >>> 32);
      if (i1 != 0) {
        break;
      }
      this.b = new int[1];
      this.b[0] = ((int)paramLong);
      return;
      this.a = 1;
    }
    this.b = new int[2];
    this.b[0] = i1;
    this.b[1] = ((int)paramLong);
  }
  
  ex(ey paramey, int paramInt)
  {
    int i1;
    if ((paramey.c > 0) || (paramey.a.length != paramey.b))
    {
      this.b = new int[paramey.b];
      i1 = 0;
    }
    while (i1 < paramey.b)
    {
      this.b[i1] = paramey.a[(paramey.c + i1)];
      i1 += 1;
      continue;
      this.b = paramey.a;
    }
    if (paramey.b == 0) {
      paramInt = i2;
    }
    for (;;)
    {
      this.a = paramInt;
      return;
    }
  }
  
  public ex(String paramString)
  {
    this(paramString, 10);
  }
  
  public ex(String paramString, int paramInt)
  {
    int i2 = paramString.length();
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new NumberFormatException("Radix out of range");
    }
    if (paramString.length() == 0) {
      throw new NumberFormatException("Zero length BigInteger");
    }
    this.a = 1;
    int i1 = paramString.lastIndexOf('-');
    if (i1 != -1) {
      if (i1 == 0)
      {
        if (paramString.length() == 1) {
          throw new NumberFormatException("Zero length BigInteger");
        }
        this.a = -1;
        i1 = 1;
      }
    }
    for (;;)
    {
      if ((i1 < i2) && (Character.digit(paramString.charAt(i1), paramInt) == 0))
      {
        i1 += 1;
        continue;
        throw new NumberFormatException("Illegal embedded minus sign");
      }
      else
      {
        if (i1 == i2)
        {
          this.a = 0;
          this.b = c.b;
          return;
        }
        i2 -= i1;
        this.b = new int[((int)((i2 * m[paramInt] >>> 10) + 1L) + 31) / 32];
        int i3 = i2 % u[paramInt];
        i2 = i3;
        if (i3 == 0) {
          i2 = u[paramInt];
        }
        i2 += i1;
        String str = paramString.substring(i1, i2);
        this.b[(this.b.length - 1)] = Integer.parseInt(str, paramInt);
        if (this.b[(this.b.length - 1)] < 0) {
          throw new NumberFormatException("Illegal digit");
        }
        i3 = v[paramInt];
        for (i1 = i2; i1 < paramString.length(); i1 = i2)
        {
          i2 = u[paramInt] + i1;
          i1 = Integer.parseInt(paramString.substring(i1, i2), paramInt);
          if (i1 < 0) {
            throw new NumberFormatException("Illegal digit");
          }
          c(this.b, i3, i1);
        }
        this.b = c(this.b);
        return;
        i1 = 0;
      }
    }
  }
  
  public ex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {
      throw new NumberFormatException("Zero length BigInteger");
    }
    if (paramArrayOfByte[0] < 0)
    {
      this.b = b(paramArrayOfByte);
      this.a = -1;
      return;
    }
    this.b = a(paramArrayOfByte);
    if (this.b.length == 0) {}
    for (;;)
    {
      this.a = i1;
      return;
      i1 = 1;
    }
  }
  
  private ex(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt.length == 0) {
      paramInt = 0;
    }
    this.a = paramInt;
    this.b = paramArrayOfInt;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return d(paramArrayOfInt[0]) + (paramInt - 1 << 5);
  }
  
  static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = paramArrayOfInt.length - 1 - paramInt2 - paramInt1;
    long l1 = (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + (paramInt3 & 0xFFFFFFFF);
    paramArrayOfInt[paramInt1] = ((int)l1);
    if (l1 >>> 32 == 0L) {
      return 0;
    }
    do
    {
      paramInt2 -= 1;
      if (paramInt2 < 0) {
        break;
      }
      paramInt3 = paramInt1 - 1;
      if (paramInt3 < 0) {
        return 1;
      }
      paramArrayOfInt[paramInt3] += 1;
      paramInt1 = paramInt3;
    } while (paramArrayOfInt[paramInt3] == 0);
    return 0;
    return 1;
  }
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      int i2 = i3;
      long l1;
      long l2;
      if (i1 < paramInt)
      {
        l1 = paramArrayOfInt1[i1] & 0xFFFFFFFF;
        l2 = paramArrayOfInt2[i1] & 0xFFFFFFFF;
        if (l1 < l2) {
          i2 = -1;
        }
      }
      else
      {
        return i2;
      }
      if (l1 > l2) {
        return 1;
      }
      i1 += 1;
    }
  }
  
  static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = paramInt3;
    long l1 = 0L;
    paramInt1 = paramArrayOfInt1.length - paramInt1 - 1;
    paramInt2 -= 1;
    while (paramInt2 >= 0)
    {
      l1 += (paramArrayOfInt2[paramInt2] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF) + (paramArrayOfInt1[paramInt1] & 0xFFFFFFFF);
      paramArrayOfInt1[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    return (int)l1;
  }
  
  public static ex a(long paramLong)
  {
    if (paramLong == 0L) {
      return c;
    }
    if ((paramLong > 0L) && (paramLong <= 16L)) {
      return o[((int)paramLong)];
    }
    if ((paramLong < 0L) && (paramLong >= -16L)) {
      return p[((int)-paramLong)];
    }
    return new ex(paramLong);
  }
  
  private ex a(ex paramex, int paramInt)
  {
    Object localObject2 = a(1L);
    Object localObject1 = h(paramInt);
    int i2 = paramex.d();
    int i1;
    Object localObject3;
    int i3;
    if (c(0))
    {
      i1 = i2;
      if (paramInt - 1 < i2) {
        i1 = paramInt - 1;
      }
      localObject3 = localObject2;
      i3 = 0;
      i2 = i1;
      localObject2 = localObject1;
      i1 = i3;
      localObject1 = localObject3;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        localObject3 = localObject1;
        if (paramex.c(i1)) {
          localObject3 = ((ex)localObject1).b((ex)localObject2).h(paramInt);
        }
        i3 = i1 + 1;
        localObject1 = localObject3;
        i1 = i3;
        if (i3 < i2)
        {
          localObject2 = ((ex)localObject2).g().h(paramInt);
          localObject1 = localObject3;
          i1 = i3;
        }
      }
      else
      {
        return localObject1;
        localObject3 = localObject1;
        i1 = 0;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 - 1;
    int i2;
    for (paramInt1 = paramArrayOfInt[i1]; i1 > 0; paramInt1 = i2)
    {
      i2 = paramArrayOfInt[(i1 - 1)];
      paramArrayOfInt[i1] = (paramInt1 >>> paramInt2 | i2 << 32 - paramInt2);
      i1 -= 1;
    }
    paramArrayOfInt[0] >>>= paramInt2;
  }
  
  private static int[] a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    int i2 = 0;
    while ((i2 < paramArrayOfByte.length) && (paramArrayOfByte[i2] == 0)) {
      i2 += 1;
    }
    int i3 = (i1 - i2 + 3) / 4;
    int[] arrayOfInt = new int[i3];
    i3 -= 1;
    i1 -= 1;
    while (i3 >= 0)
    {
      int i4 = i1 - 1;
      paramArrayOfByte[i1] &= 0xFF;
      int i6 = Math.min(3, i4 - i2 + 1);
      int i5 = 8;
      i1 = i4;
      i4 = i5;
      while (i4 <= i6 * 8)
      {
        i5 = arrayOfInt[i3];
        arrayOfInt[i3] = ((paramArrayOfByte[i1] & 0xFF) << i4 | i5);
        i4 += 8;
        i1 -= 1;
      }
      i3 -= 1;
    }
    return arrayOfInt;
  }
  
  private static final int[] a(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int i2 = 0;
    int i4 = paramInt << 1;
    int[] arrayOfInt;
    if (paramArrayOfInt2 != null)
    {
      arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length >= i4) {}
    }
    else
    {
      arrayOfInt = new int[i4];
    }
    int i1 = 0;
    int i3 = 0;
    while (i1 < paramInt)
    {
      long l1 = paramArrayOfInt1[i1] & 0xFFFFFFFF;
      l1 *= l1;
      arrayOfInt[i2] = ((int)(l1 >>> 33));
      arrayOfInt[i2] &= 0x7FFFFFFF;
      arrayOfInt[i2] = (i3 << 31 | arrayOfInt[i2]);
      i2 += 1;
      arrayOfInt[i2] = ((int)(l1 >>> 1));
      i2 += 1;
      i3 = (int)l1;
      i1 += 1;
    }
    i1 = 1;
    i2 = paramInt;
    while (i2 > 0)
    {
      a(arrayOfInt, i1 - 1, i2, a(arrayOfInt, paramArrayOfInt1, i1, i2 - 1, paramArrayOfInt1[(i2 - 1)]));
      i2 -= 1;
      i1 += 2;
    }
    b(arrayOfInt, i4, 1);
    i1 = i4 - 1;
    arrayOfInt[i1] |= paramArrayOfInt1[(paramInt - 1)] & 0x1;
    return arrayOfInt;
  }
  
  private int[] a(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3)
  {
    int i2 = paramInt1 - 1;
    int i1 = paramInt2 - 1;
    int[] arrayOfInt;
    if (paramArrayOfInt3 != null)
    {
      arrayOfInt = paramArrayOfInt3;
      if (paramArrayOfInt3.length >= paramInt1 + paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + paramInt2];
    }
    long l1 = 0L;
    paramInt1 = i1 + 1 + i2;
    paramInt2 = i1;
    while (paramInt2 >= 0)
    {
      l1 += (paramArrayOfInt2[paramInt2] & 0xFFFFFFFF) * (paramArrayOfInt1[i2] & 0xFFFFFFFF);
      arrayOfInt[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    arrayOfInt[i2] = ((int)l1);
    paramInt1 = i2 - 1;
    while (paramInt1 >= 0)
    {
      l1 = 0L;
      i2 = i1;
      paramInt2 = i1 + 1 + paramInt1;
      if (i2 >= 0)
      {
        if (paramInt2 < 0) {}
        for (;;)
        {
          i2 -= 1;
          paramInt2 -= 1;
          break;
          l1 += (paramArrayOfInt2[i2] & 0xFFFFFFFF) * (paramArrayOfInt1[paramInt1] & 0xFFFFFFFF) + (arrayOfInt[paramInt2] & 0xFFFFFFFF);
          arrayOfInt[paramInt2] = ((int)l1);
          l1 >>>= 32;
        }
      }
      arrayOfInt[paramInt1] = ((int)l1);
      paramInt1 -= 1;
    }
    return arrayOfInt;
  }
  
  private static int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length < paramArrayOfInt2.length) {}
    for (;;)
    {
      int i1 = paramArrayOfInt2.length;
      int i2 = paramArrayOfInt1.length;
      int[] arrayOfInt = new int[i1];
      long l1 = 0L;
      while (i2 > 0)
      {
        i1 -= 1;
        long l2 = paramArrayOfInt2[i1];
        i2 -= 1;
        l1 = (l2 & 0xFFFFFFFF) + (paramArrayOfInt1[i2] & 0xFFFFFFFF) + (l1 >>> 32);
        arrayOfInt[i1] = ((int)l1);
      }
      int i3;
      if (l1 >>> 32 != 0L)
      {
        i2 = 1;
        i3 = i1;
        if (i1 <= 0) {
          break label140;
        }
        i3 = i1;
        if (i2 == 0) {
          break label140;
        }
        i2 = i1 - 1;
        i1 = paramArrayOfInt2[i2] + 1;
        arrayOfInt[i2] = i1;
        if (i1 != 0) {
          break label135;
        }
      }
      label135:
      for (i1 = 1;; i1 = 0)
      {
        i3 = i1;
        i1 = i2;
        i2 = i3;
        break;
        i2 = 0;
        break;
      }
      label140:
      while (i3 > 0)
      {
        i3 -= 1;
        arrayOfInt[i3] = paramArrayOfInt2[i3];
      }
      if (i2 != 0)
      {
        i2 = arrayOfInt.length + 1;
        paramArrayOfInt1 = new int[i2];
        i1 = 1;
        while (i1 < i2)
        {
          paramArrayOfInt1[i1] = arrayOfInt[(i1 - 1)];
          i1 += 1;
        }
        paramArrayOfInt1[0] = 1;
        return paramArrayOfInt1;
      }
      return arrayOfInt;
      arrayOfInt = paramArrayOfInt1;
      paramArrayOfInt1 = paramArrayOfInt2;
      paramArrayOfInt2 = arrayOfInt;
    }
  }
  
  private static int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    int i4 = 0;
    int i1 = paramInt1;
    int i2 = 0;
    int i3;
    int i5;
    do
    {
      i3 = i2 + a(paramArrayOfInt1, i4, paramInt1, a(paramArrayOfInt1, paramArrayOfInt2, i4, paramInt1, paramArrayOfInt1[(paramArrayOfInt1.length - 1 - i4)] * paramInt2));
      i4 += 1;
      i5 = i1 - 1;
      i1 = i5;
      i2 = i3;
    } while (i5 > 0);
    while (i3 > 0) {
      i3 += b(paramArrayOfInt1, paramArrayOfInt2, paramInt1);
    }
    while (a(paramArrayOfInt1, paramArrayOfInt2, paramInt1) >= 0) {
      b(paramArrayOfInt1, paramArrayOfInt2, paramInt1);
    }
    return paramArrayOfInt1;
  }
  
  private static int b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    long l1 = 0L;
    for (;;)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      l1 = (l1 >> 32) + ((paramArrayOfInt1[paramInt] & 0xFFFFFFFF) - (paramArrayOfInt2[paramInt] & 0xFFFFFFFF));
      paramArrayOfInt1[paramInt] = ((int)l1);
    }
    return (int)(l1 >> 32);
  }
  
  private ex b(ex paramex1, ex paramex2)
  {
    if (paramex1.equals(d)) {
      return this;
    }
    if (this.a == 0) {
      return c;
    }
    Object localObject1 = new int[this.b.length];
    System.arraycopy(this.b, 0, localObject1, 0, this.b.length);
    int[] arrayOfInt1 = paramex1.b;
    int[] arrayOfInt2 = paramex2.b;
    int i12 = arrayOfInt2.length;
    int i8 = 0;
    int i2 = 0;
    int i11 = a(arrayOfInt1, arrayOfInt1.length);
    int i1 = i2;
    if (i11 == 17)
    {
      if (arrayOfInt1[0] != 65537) {
        i1 = i2;
      }
    }
    else {
      for (;;)
      {
        i8 = i1;
        if (i11 <= f[i1]) {
          break;
        }
        i1 += 1;
      }
    }
    int i13 = 1 << i8;
    int[][] arrayOfInt = new int[i13][];
    i1 = 0;
    while (i1 < i13)
    {
      arrayOfInt[i1] = new int[i12];
      i1 += 1;
    }
    int i14 = -ey.d(arrayOfInt2[(i12 - 1)]);
    paramex1 = d((int[])localObject1, localObject1.length, i12 << 5);
    paramex2 = new ey();
    localObject1 = new ey();
    new ey(paramex1).a(new ey(arrayOfInt2), paramex2, (ey)localObject1);
    arrayOfInt[0] = ((ey)localObject1).d();
    if (arrayOfInt[0].length < i12)
    {
      i2 = arrayOfInt[0].length;
      paramex2 = new int[i12];
      i1 = 0;
      while (i1 < arrayOfInt[0].length)
      {
        paramex2[(i1 + (i12 - i2))] = arrayOfInt[0][i1];
        i1 += 1;
      }
      arrayOfInt[0] = paramex2;
    }
    paramex2 = a(a(arrayOfInt[0], i12, null), arrayOfInt2, i12, i14);
    localObject1 = new int[i12];
    i1 = 0;
    while (i1 < i12)
    {
      localObject1[i1] = paramex2[i1];
      i1 += 1;
    }
    i1 = 1;
    while (i1 < i13)
    {
      arrayOfInt[i1] = a(a((int[])localObject1, i12, arrayOfInt[(i1 - 1)], i12, null), arrayOfInt2, i12, i14);
      i1 += 1;
    }
    i2 = 1 << (i11 - 1 & 0x1F);
    i1 = arrayOfInt1.length;
    int i3 = 0;
    int i5 = 0;
    int i4 = 0;
    int i7;
    if (i4 <= i8)
    {
      if ((arrayOfInt1[i3] & i2) != 0) {}
      for (i6 = 1;; i6 = 0)
      {
        i10 = i2 >>> 1;
        i9 = i3;
        i7 = i1;
        i2 = i10;
        if (i10 == 0)
        {
          i9 = i3 + 1;
          i2 = -2147483648;
          i7 = i1 - 1;
        }
        i4 += 1;
        i5 = i5 << 1 | i6;
        i3 = i9;
        i1 = i7;
        break;
      }
    }
    int i6 = i11 - 1;
    int i9 = 1;
    i4 = i6 - i8;
    while ((i5 & 0x1) == 0)
    {
      i5 >>>= 1;
      i4 += 1;
    }
    [I local[I = arrayOfInt[(i5 >>> 1)];
    int i10 = 0;
    if (i4 == i6)
    {
      i11 = 0;
      localObject1 = paramex1;
      i9 = i4;
      paramex1 = paramex2;
      i5 = i2;
      i7 = i10;
      i4 = i1;
      i1 = i11;
      paramex2 = (ex)localObject1;
      localObject1 = local[I;
      i2 = i9;
    }
    for (;;)
    {
      i9 = i6 - 1;
      i10 = i7 << 1;
      i6 = i10;
      i7 = i5;
      if (i4 != 0) {
        if ((arrayOfInt1[i3] & i5) != 0)
        {
          i6 = 1;
          i10 |= i6;
          i5 >>>= 1;
          i6 = i10;
          i7 = i5;
          if (i5 != 0) {
            break label980;
          }
          i5 = i4 - 1;
          i4 = -2147483648;
          i7 = i3 + 1;
          i6 = i10;
          i3 = i5;
          i5 = i7;
        }
      }
      for (;;)
      {
        if ((i6 & i13) != 0)
        {
          i2 = i9 - i8;
          for (;;)
          {
            if ((i6 & 0x1) == 0)
            {
              i6 >>>= 1;
              i2 += 1;
              continue;
              i6 = 0;
              break;
            }
          }
          localObject1 = arrayOfInt[(i6 >>> 1)];
          i6 = 0;
        }
        for (;;)
        {
          if (i9 == i2) {
            if (i1 != 0)
            {
              paramex1 = new int[localObject1.length];
              System.arraycopy(localObject1, 0, paramex1, 0, localObject1.length);
              i1 = 0;
            }
          }
          for (;;)
          {
            if (i9 == 0)
            {
              paramex2 = new int[i12 * 2];
              i1 = 0;
              while (i1 < i12)
              {
                paramex2[(i1 + i12)] = paramex1[i1];
                i1 += 1;
              }
              localObject2 = a(a(paramex1, i12, (int[])localObject1, i12, paramex2), arrayOfInt2, i12, i14);
              paramex2 = paramex1;
              paramex1 = (ex)localObject2;
            }
            else
            {
              if (i1 == 0)
              {
                localObject2 = a(a(paramex1, i12, paramex2), arrayOfInt2, i12, i14);
                paramex2 = paramex1;
                paramex1 = (ex)localObject2;
                i10 = i5;
                i7 = i3;
                i5 = i4;
                i3 = i10;
                i4 = i7;
                i7 = i6;
                i6 = i9;
                break;
                paramex1 = a(paramex2, arrayOfInt2, i12, i14);
                paramex2 = new int[i12];
                i1 = 0;
                while (i1 < i12)
                {
                  paramex2[i1] = paramex1[i1];
                  i1 += 1;
                }
                return new ex(1, paramex2);
              }
              i7 = i5;
              i5 = i4;
              i4 = i3;
              i3 = i7;
              i7 = i6;
              i6 = i9;
              break;
            }
          }
        }
        label980:
        i5 = i3;
        i3 = i4;
        i4 = i7;
      }
      Object localObject2 = paramex1;
      i7 = i4;
      i4 = i1;
      paramex1 = paramex2;
      i5 = i2;
      i2 = i7;
      localObject1 = local[I;
      paramex2 = (ex)localObject2;
      i1 = i9;
      i7 = i10;
    }
  }
  
  static void b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    int i1 = paramArrayOfInt[0];
    int i2 = 0;
    while (i2 < 0 + paramInt1 - 1)
    {
      int i3 = paramArrayOfInt[(i2 + 1)];
      paramArrayOfInt[i2] = (i1 << paramInt2 | i3 >>> 32 - paramInt2);
      i2 += 1;
      i1 = i3;
    }
    paramInt1 -= 1;
    paramArrayOfInt[paramInt1] <<= paramInt2;
  }
  
  private static int[] b(byte[] paramArrayOfByte)
  {
    int i4 = paramArrayOfByte.length;
    int i1 = 0;
    while ((i1 < i4) && (paramArrayOfByte[i1] == -1)) {
      i1 += 1;
    }
    int i2 = i1;
    while ((i2 < i4) && (paramArrayOfByte[i2] == 0)) {
      i2 += 1;
    }
    int[] arrayOfInt;
    int i3;
    if (i2 == i4)
    {
      i2 = 1;
      i2 = (i2 + (i4 - i1) + 3) / 4;
      arrayOfInt = new int[i2];
      i3 = i2 - 1;
      i2 = i4 - 1;
    }
    for (;;)
    {
      if (i3 < 0) {
        break label211;
      }
      int i5 = i2 - 1;
      paramArrayOfByte[i2] &= 0xFF;
      i2 = Math.min(3, i5 - i1 + 1);
      i4 = i2;
      if (i2 < 0) {
        i4 = 0;
      }
      int i6 = 8;
      i2 = i5;
      i5 = i6;
      for (;;)
      {
        if (i5 <= i4 * 8)
        {
          i6 = arrayOfInt[i3];
          arrayOfInt[i3] = ((paramArrayOfByte[i2] & 0xFF) << i5 | i6);
          i5 += 8;
          i2 -= 1;
          continue;
          i2 = 0;
          break;
        }
      }
      arrayOfInt[i3] = (-1 >>> (3 - i4) * 8 & (arrayOfInt[i3] ^ 0xFFFFFFFF));
      i3 -= 1;
    }
    label211:
    i1 = arrayOfInt.length - 1;
    for (;;)
    {
      if (i1 >= 0)
      {
        arrayOfInt[i1] = ((int)((arrayOfInt[i1] & 0xFFFFFFFF) + 1L));
        if (arrayOfInt[i1] == 0) {}
      }
      else
      {
        return arrayOfInt;
      }
      i1 -= 1;
    }
  }
  
  private static int[] b(int[] paramArrayOfInt)
  {
    int i2 = 0;
    int i1 = paramArrayOfInt.length;
    i1 = 0;
    while ((i1 < paramArrayOfInt.length) && (paramArrayOfInt[i1] == 0)) {
      i1 += 1;
    }
    int[] arrayOfInt = new int[paramArrayOfInt.length - i1];
    while (i2 < paramArrayOfInt.length - i1)
    {
      arrayOfInt[i2] = paramArrayOfInt[(i1 + i2)];
      i2 += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length;
    int[] arrayOfInt = new int[i1];
    int i2 = paramArrayOfInt2.length;
    long l1 = 0L;
    while (i2 > 0)
    {
      i1 -= 1;
      long l2 = paramArrayOfInt1[i1];
      i2 -= 1;
      l1 = (l2 & 0xFFFFFFFF) - (paramArrayOfInt2[i2] & 0xFFFFFFFF) + (l1 >> 32);
      arrayOfInt[i1] = ((int)l1);
    }
    int i3;
    if (l1 >> 32 != 0L)
    {
      i2 = 1;
      i3 = i1;
      if (i1 <= 0) {
        break label134;
      }
      i3 = i1;
      if (i2 == 0) {
        break label134;
      }
      i2 = i1 - 1;
      i1 = paramArrayOfInt1[i2] - 1;
      arrayOfInt[i2] = i1;
      if (i1 != -1) {
        break label129;
      }
    }
    label129:
    for (i1 = 1;; i1 = 0)
    {
      i3 = i1;
      i1 = i2;
      i2 = i3;
      break;
      i2 = 0;
      break;
    }
    label134:
    while (i3 > 0)
    {
      i3 -= 1;
      arrayOfInt[i3] = paramArrayOfInt1[i3];
    }
    return arrayOfInt;
  }
  
  private static int c(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i3 = 0;
    int i1;
    if (paramArrayOfInt1.length < paramArrayOfInt2.length)
    {
      i1 = -1;
      return i1;
    }
    if (paramArrayOfInt1.length > paramArrayOfInt2.length) {
      return 1;
    }
    int i2 = 0;
    for (;;)
    {
      i1 = i3;
      if (i2 >= paramArrayOfInt1.length) {
        break;
      }
      long l1 = paramArrayOfInt1[i2] & 0xFFFFFFFF;
      long l2 = paramArrayOfInt2[i2] & 0xFFFFFFFF;
      if (l1 < l2) {
        return -1;
      }
      if (l1 > l2) {
        return 1;
      }
      i2 += 1;
    }
  }
  
  private static void c(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    long l2 = paramInt1;
    long l3 = paramInt2;
    paramInt2 = paramArrayOfInt.length;
    long l1 = 0L;
    paramInt1 = paramInt2 - 1;
    while (paramInt1 >= 0)
    {
      l1 += (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF);
      paramArrayOfInt[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt1 -= 1;
    }
    l1 = (paramArrayOfInt[(paramInt2 - 1)] & 0xFFFFFFFF) + (l3 & 0xFFFFFFFF);
    paramArrayOfInt[(paramInt2 - 1)] = ((int)l1);
    l1 >>>= 32;
    paramInt1 = paramInt2 - 2;
    while (paramInt1 >= 0)
    {
      l1 += (paramArrayOfInt[paramInt1] & 0xFFFFFFFF);
      paramArrayOfInt[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt1 -= 1;
    }
  }
  
  private static int[] c(int[] paramArrayOfInt)
  {
    int i2 = 0;
    int i1 = paramArrayOfInt.length;
    i1 = 0;
    while ((i1 < paramArrayOfInt.length) && (paramArrayOfInt[i1] == 0)) {
      i1 += 1;
    }
    int[] arrayOfInt = paramArrayOfInt;
    if (i1 > 0)
    {
      arrayOfInt = new int[paramArrayOfInt.length - i1];
      while (i2 < paramArrayOfInt.length - i1)
      {
        arrayOfInt[i2] = paramArrayOfInt[(i1 + i2)];
        i2 += 1;
      }
    }
    return arrayOfInt;
  }
  
  static int d(int paramInt)
  {
    int i1 = 1;
    if (paramInt < 32768)
    {
      if (paramInt < 128)
      {
        if (paramInt < 8)
        {
          if (paramInt < 2)
          {
            if (paramInt < 1)
            {
              if (paramInt < 0) {
                i1 = 32;
              }
            }
            else {
              return i1;
            }
            return 0;
          }
          if (paramInt < 4) {
            return 2;
          }
          return 3;
        }
        if (paramInt < 32)
        {
          if (paramInt < 16) {
            return 4;
          }
          return 5;
        }
        if (paramInt < 64) {
          return 6;
        }
        return 7;
      }
      if (paramInt < 2048)
      {
        if (paramInt < 512)
        {
          if (paramInt < 256) {
            return 8;
          }
          return 9;
        }
        if (paramInt < 1024) {
          return 10;
        }
        return 11;
      }
      if (paramInt < 8192)
      {
        if (paramInt < 4096) {
          return 12;
        }
        return 13;
      }
      if (paramInt < 16384) {
        return 14;
      }
      return 15;
    }
    if (paramInt < 8388608)
    {
      if (paramInt < 524288)
      {
        if (paramInt < 131072)
        {
          if (paramInt < 65536) {
            return 16;
          }
          return 17;
        }
        if (paramInt < 262144) {
          return 18;
        }
        return 19;
      }
      if (paramInt < 2097152)
      {
        if (paramInt < 1048576) {
          return 20;
        }
        return 21;
      }
      if (paramInt < 4194304) {
        return 22;
      }
      return 23;
    }
    if (paramInt < 134217728)
    {
      if (paramInt < 33554432)
      {
        if (paramInt < 16777216) {
          return 24;
        }
        return 25;
      }
      if (paramInt < 67108864) {
        return 26;
      }
      return 27;
    }
    if (paramInt < 536870912)
    {
      if (paramInt < 268435456) {
        return 28;
      }
      return 29;
    }
    if (paramInt < 1073741824) {
      return 30;
    }
    return 31;
  }
  
  private static int[] d(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1 = 0;
    int i4 = paramInt2 >>> 5;
    int i3 = paramInt2 & 0x1F;
    int i5 = d(paramArrayOfInt[0]);
    if (paramInt2 <= 32 - i5)
    {
      b(paramArrayOfInt, paramInt1, i3);
      return paramArrayOfInt;
    }
    if (i3 <= 32 - i5)
    {
      arrayOfInt = new int[i4 + paramInt1];
      paramInt2 = i1;
      while (paramInt2 < paramInt1)
      {
        arrayOfInt[paramInt2] = paramArrayOfInt[paramInt2];
        paramInt2 += 1;
      }
      b(arrayOfInt, arrayOfInt.length, i3);
      return arrayOfInt;
    }
    int[] arrayOfInt = new int[i4 + paramInt1 + 1];
    paramInt2 = i2;
    while (paramInt2 < paramInt1)
    {
      arrayOfInt[paramInt2] = paramArrayOfInt[paramInt2];
      paramInt2 += 1;
    }
    a(arrayOfInt, arrayOfInt.length, 32 - i3);
    return arrayOfInt;
  }
  
  static int e(int paramInt)
  {
    paramInt -= ((0xAAAAAAAA & paramInt) >>> 1);
    paramInt = (paramInt >>> 2 & 0x33333333) + (paramInt & 0x33333333);
    paramInt = paramInt + (paramInt >>> 4) & 0xF0F0F0F;
    paramInt += (paramInt >>> 8);
    return paramInt + (paramInt >>> 16) & 0xFF;
  }
  
  static int f(int paramInt)
  {
    int i1 = paramInt & 0xFF;
    if (i1 != 0) {
      return g[i1];
    }
    i1 = paramInt >>> 8 & 0xFF;
    if (i1 != 0) {
      return g[i1] + 8;
    }
    i1 = paramInt >>> 16 & 0xFF;
    if (i1 != 0) {
      return g[i1] + 16;
    }
    return g[(paramInt >>> 24 & 0xFF)] + 24;
  }
  
  private ex g()
  {
    if (this.a == 0) {
      return c;
    }
    return new ex(c(a(this.b, this.b.length, null)), 1);
  }
  
  private int h()
  {
    if (this.a < 0) {
      return -1;
    }
    return 0;
  }
  
  private ex h(int paramInt)
  {
    if (d() <= paramInt) {
      return this;
    }
    int i2 = (paramInt + 31) / 32;
    Object localObject = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      localObject[i1] = this.b[(this.b.length - i2 + i1)];
      i1 += 1;
    }
    localObject[0] = ((int)(localObject[0] & (1L << 32 - ((i2 << 5) - paramInt)) - 1L));
    if (localObject[0] == 0) {}
    for (localObject = new ex(1, (int[])localObject);; localObject = new ex((int[])localObject, 1)) {
      return localObject;
    }
  }
  
  private int i()
  {
    if (this.l == -2)
    {
      int i1 = this.b.length - 1;
      while ((i1 >= 0) && (this.b[i1] == 0)) {
        i1 -= 1;
      }
      this.l = (this.b.length - i1 - 1);
    }
    return this.l;
  }
  
  private int i(int paramInt)
  {
    int i1;
    if (paramInt < 0) {
      i1 = 0;
    }
    int i2;
    do
    {
      return i1;
      if (paramInt >= this.b.length) {
        return h();
      }
      i2 = this.b[(this.b.length - paramInt - 1)];
      i1 = i2;
    } while (this.a >= 0);
    if (paramInt <= i()) {
      return -i2;
    }
    return i2 ^ 0xFFFFFFFF;
  }
  
  public ex a()
  {
    if (this.a >= 0) {
      return this;
    }
    return b();
  }
  
  public ex a(int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    Object localObject;
    if (this.a == 0) {
      localObject = c;
    }
    do
    {
      return localObject;
      localObject = this;
    } while (paramInt == 0);
    if (paramInt < 0) {
      return b(-paramInt);
    }
    int i6 = paramInt >>> 5;
    int i4 = paramInt & 0x1F;
    int i3 = this.b.length;
    int[] arrayOfInt;
    if (i4 == 0)
    {
      arrayOfInt = new int[i6 + i3];
      paramInt = i2;
      for (;;)
      {
        localObject = arrayOfInt;
        if (paramInt >= i3) {
          break;
        }
        arrayOfInt[paramInt] = this.b[paramInt];
        paramInt += 1;
      }
    }
    int i5 = 32 - i4;
    i2 = this.b[0] >>> i5;
    if (i2 != 0)
    {
      localObject = new int[i6 + i3 + 1];
      paramInt = 1;
      localObject[0] = i2;
    }
    while (i1 < i3 - 1)
    {
      arrayOfInt = this.b;
      i2 = i1 + 1;
      localObject[paramInt] = (arrayOfInt[i1] << i4 | this.b[i2] >>> i5);
      i1 = i2;
      paramInt += 1;
      continue;
      localObject = new int[i6 + i3];
      paramInt = 0;
    }
    localObject[paramInt] = (this.b[i1] << i4);
    return new ex((int[])localObject, this.a);
  }
  
  public ex a(ex paramex)
  {
    if (paramex.a == 0) {
      return this;
    }
    if (this.a == 0) {
      return paramex;
    }
    if (paramex.a == this.a) {
      return new ex(a(this.b, paramex.b), this.a);
    }
    int i1 = c(this.b, paramex.b);
    if (i1 == 0) {
      return c;
    }
    if (i1 > 0) {}
    for (paramex = b(this.b, paramex.b);; paramex = b(paramex.b, this.b)) {
      return new ex(c(paramex), i1 * this.a);
    }
  }
  
  public ex a(ex paramex1, ex paramex2)
  {
    if (paramex2.a <= 0) {
      throw new ArithmeticException("BigInteger: modulus not positive");
    }
    ex localex1;
    if (paramex1.a == 0)
    {
      if (paramex2.equals(d))
      {
        localex1 = c;
        return localex1;
      }
      return d;
    }
    if (equals(d))
    {
      if (paramex2.equals(d)) {
        return c;
      }
      return d;
    }
    if ((equals(c)) && (paramex1.a >= 0)) {
      return c;
    }
    if ((equals(p[1])) && (!paramex1.c(0)))
    {
      if (paramex2.equals(d)) {
        return c;
      }
      return d;
    }
    int i1;
    if (paramex1.a < 0)
    {
      i1 = 1;
      label143:
      localex1 = paramex1;
      if (i1 != 0) {
        localex1 = paramex1.b();
      }
      if ((this.a >= 0) && (f(paramex2) < 0)) {
        break label211;
      }
    }
    label211:
    for (paramex1 = c(paramex2);; paramex1 = this)
    {
      if (!paramex2.c(0)) {
        break label216;
      }
      paramex1 = paramex1.b(localex1, paramex2);
      localex1 = paramex1;
      if (i1 == 0) {
        break;
      }
      return paramex1.e(paramex2);
      i1 = 0;
      break label143;
    }
    label216:
    int i2 = paramex2.c();
    ex localex3 = paramex2.b(i2);
    ex localex4 = d.a(i2);
    if (this.a >= 0)
    {
      localex2 = this;
      if (f(localex3) < 0) {}
    }
    else
    {
      localex2 = c(localex3);
    }
    if (localex3.equals(d)) {}
    for (ex localex2 = c;; localex2 = localex2.b(localex1, localex3))
    {
      paramex1 = paramex1.a(localex1, i2);
      localex1 = localex4.e(localex3);
      ex localex5 = localex3.e(localex4);
      paramex1 = localex2.b(localex4).b(localex1).a(paramex1.b(localex3).b(localex5)).c(paramex2);
      break;
    }
  }
  
  int[] a(int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt.length - 1;
    int i2 = 0;
    while ((i1 >= 0) && (i2 == 0))
    {
      i2 = paramArrayOfInt[i1] + 1;
      paramArrayOfInt[i1] = i2;
      i1 -= 1;
    }
    int[] arrayOfInt = paramArrayOfInt;
    if (i2 == 0)
    {
      arrayOfInt = new int[paramArrayOfInt.length + 1];
      arrayOfInt[0] = 1;
    }
    return arrayOfInt;
  }
  
  public ex b()
  {
    return new ex(this.b, -this.a);
  }
  
  public ex b(int paramInt)
  {
    int i2 = 1;
    if (paramInt == 0) {
      return this;
    }
    if (paramInt < 0) {
      return a(-paramInt);
    }
    int i4 = paramInt >>> 5;
    int i5 = paramInt & 0x1F;
    int i6 = this.b.length;
    Object localObject1;
    if (i4 >= i6)
    {
      if (this.a >= 0) {}
      for (localObject1 = c;; localObject1 = p[1]) {
        return localObject1;
      }
    }
    int i1;
    if (i5 == 0)
    {
      i1 = i6 - i4;
      localObject2 = new int[i1];
      paramInt = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramInt >= i1) {
          break;
        }
        localObject2[paramInt] = this.b[paramInt];
        paramInt += 1;
      }
    }
    paramInt = this.b[0] >>> i5;
    if (paramInt != 0)
    {
      localObject2 = new int[i6 - i4];
      localObject2[0] = paramInt;
    }
    for (paramInt = 1;; paramInt = 0)
    {
      i1 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= i6 - i4 - 1) {
          break;
        }
        localObject1 = this.b;
        int i3 = i1 + 1;
        localObject2[paramInt] = (localObject1[i1] << 32 - i5 | this.b[i3] >>> i5);
        i1 = i3;
        paramInt += 1;
      }
      localObject2 = new int[i6 - i4 - 1];
    }
    Object localObject2 = localObject1;
    if (this.a < 0)
    {
      i1 = i6 - 1;
      paramInt = 0;
      if ((i1 >= i6 - i4) && (paramInt == 0))
      {
        if (this.b[i1] != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          i1 -= 1;
          break;
        }
      }
      if ((paramInt != 0) || (i5 == 0)) {
        break label343;
      }
      if (this.b[(i6 - i4 - 1)] << 32 - i5 == 0) {
        break label338;
      }
      paramInt = i2;
    }
    label338:
    label343:
    for (;;)
    {
      localObject2 = localObject1;
      if (paramInt != 0) {
        localObject2 = a((int[])localObject1);
      }
      return new ex((int[])localObject2, this.a);
      paramInt = 0;
    }
  }
  
  public ex b(ex paramex)
  {
    if ((this.a == 0) || (paramex.a == 0)) {
      return c;
    }
    return new ex(c(a(this.b, this.b.length, paramex.b, paramex.b.length, null)), this.a * paramex.a);
  }
  
  public int c()
  {
    if (this.j == -2) {
      if (this.a != 0) {
        break label26;
      }
    }
    label26:
    int i1;
    int i2;
    for (this.j = -1;; this.j = ((i1 << 5) + f(i2)))
    {
      return this.j;
      i1 = 0;
      for (;;)
      {
        i2 = i(i1);
        if (i2 != 0) {
          break;
        }
        i1 += 1;
      }
    }
  }
  
  public ex c(ex paramex)
  {
    if (paramex.a <= 0) {
      throw new ArithmeticException("BigInteger: modulus not positive");
    }
    ex localex = d(paramex);
    if (localex.a >= 0) {
      return localex;
    }
    return localex.a(paramex);
  }
  
  public boolean c(int paramInt)
  {
    if (paramInt < 0) {
      throw new ArithmeticException("Negative bit address");
    }
    return (i(paramInt / 32) & 1 << paramInt % 32) != 0;
  }
  
  public int d()
  {
    if (this.i == -1)
    {
      if (this.a != 0) {
        break label25;
      }
      this.i = 0;
    }
    for (;;)
    {
      return this.i;
      label25:
      int i3 = (this.b.length - 1 << 5) + d(this.b[0]);
      if (this.a < 0)
      {
        int i2;
        if (e(this.b[0]) == 1)
        {
          i1 = 1;
          i2 = 1;
          label69:
          if ((i2 >= this.b.length) || (i1 == 0)) {
            break label110;
          }
          if (this.b[i2] != 0) {
            break label105;
          }
        }
        label105:
        for (int i1 = 1;; i1 = 0)
        {
          i2 += 1;
          break label69;
          i1 = 0;
          break;
        }
        label110:
        if (i1 != 0) {}
        for (i1 = i3 - 1;; i1 = i3)
        {
          this.i = i1;
          break;
        }
      }
      this.i = i3;
    }
  }
  
  public ex d(ex paramex)
  {
    ey localey1 = new ey();
    ey localey2 = new ey();
    new ey(this.b).a(new ey(paramex.b), localey1, localey2);
    return new ex(localey2, this.a);
  }
  
  public ex e(ex paramex)
  {
    if (paramex.a != 1) {
      throw new ArithmeticException("BigInteger: modulus not positive");
    }
    if (paramex.equals(d)) {
      return c;
    }
    ex localex;
    if (this.a >= 0)
    {
      localex = this;
      if (c(this.b, paramex.b) < 0) {}
    }
    else
    {
      localex = c(paramex);
    }
    if (localex.equals(d)) {
      return d;
    }
    return new ex(new ey(localex).e(new ey(paramex)), 1);
  }
  
  public String e()
  {
    String str2 = g(16);
    String str1 = str2;
    if (str2.length() % 2 != 0) {
      str1 = "0" + str2;
    }
    return str1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof ex));
        paramObject = (ex)paramObject;
        bool1 = bool2;
      } while (paramObject.a != this.a);
      bool1 = bool2;
    } while (paramObject.b.length != this.b.length);
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.b.length) {
        break label93;
      }
      bool1 = bool2;
      if (paramObject.b[i1] != this.b[i1]) {
        break;
      }
      i1 += 1;
    }
    label93:
    return true;
  }
  
  public int f(ex paramex)
  {
    if (this.a == paramex.a) {
      return this.a * c(this.b, paramex.b);
    }
    if (this.a > paramex.a) {
      return 1;
    }
    return -1;
  }
  
  public long f()
  {
    long l1 = 0L;
    int i1 = 1;
    while (i1 >= 0)
    {
      l1 = (l1 << 32) + (i(i1) & 0xFFFFFFFF);
      i1 -= 1;
    }
    return l1;
  }
  
  public String g(int paramInt)
  {
    if (this.a == 0) {
      return "0";
    }
    int i1;
    if (paramInt >= 2)
    {
      i1 = paramInt;
      if (paramInt <= 36) {}
    }
    else
    {
      i1 = 10;
    }
    String[] arrayOfString = new String[(this.b.length * 4 + 6) / 7];
    Object localObject1 = a();
    paramInt = 0;
    while (((ex)localObject1).a != 0)
    {
      ex localex = t[i1];
      Object localObject2 = new ey();
      ey localey = new ey();
      new ey(((ex)localObject1).b).a(new ey(localex.b), (ey)localObject2, localey);
      localObject2 = new ex((ey)localObject2, ((ex)localObject1).a * localex.a);
      arrayOfString[paramInt] = Long.toString(new ex(localey, ((ex)localObject1).a * localex.a).f(), i1);
      paramInt += 1;
      localObject1 = localObject2;
    }
    localObject1 = new StringBuffer(s[i1] * paramInt + 1);
    if (this.a < 0) {
      ((StringBuffer)localObject1).append('-');
    }
    ((StringBuffer)localObject1).append(arrayOfString[(paramInt - 1)]);
    paramInt -= 2;
    while (paramInt >= 0)
    {
      int i2 = s[i1] - arrayOfString[paramInt].length();
      if (i2 != 0) {
        ((StringBuffer)localObject1).append(r[i2]);
      }
      ((StringBuffer)localObject1).append(arrayOfString[paramInt]);
      paramInt -= 1;
    }
    return ((StringBuffer)localObject1).toString();
  }
  
  public int hashCode()
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.b.length)
    {
      i2 = (int)(i2 * 31 + (this.b[i1] & 0xFFFFFFFF));
      i1 += 1;
    }
    return this.a * i2;
  }
  
  public String toString()
  {
    return g(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ex
 * JD-Core Version:    0.7.0.1
 */