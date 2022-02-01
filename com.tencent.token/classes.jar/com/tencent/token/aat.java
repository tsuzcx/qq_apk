package com.tencent.token;

public final class aat
{
  public static final aat c;
  public static final aat d;
  public static final aat e;
  static int[] f;
  static final byte[] g;
  private static long[] m = { 0L, 0L, 1024L, 1624L, 2048L, 2378L, 2648L, 2875L, 3072L, 3247L, 3402L, 3543L, 3672L, 3790L, 3899L, 4001L, 4096L, 4186L, 4271L, 4350L, 4426L, 4498L, 4567L, 4633L, 4696L, 4756L, 4814L, 4870L, 4923L, 4975L, 5025L, 5074L, 5120L, 5166L, 5210L, 5253L, 5295L };
  private static final aat n = a(152125131763605L);
  private static aat[] o = new aat[17];
  private static aat[] p = new aat[17];
  private static final aat q;
  private static String[] r;
  private static int[] s = { 0, 0, 62, 39, 31, 27, 24, 22, 20, 19, 18, 18, 17, 17, 16, 16, 15, 15, 15, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12 };
  private static aat[] t = { null, null, a(4611686018427387904L), a(4052555153018976267L), a(4611686018427387904L), a(7450580596923828125L), a(4738381338321616896L), a(3909821048582988049L), a(1152921504606846976L), a(1350851717672992089L), a(1000000000000000000L), a(5559917313492231481L), a(2218611106740436992L), a(8650415919381337933L), a(2177953337809371136L), a(6568408355712890625L), a(1152921504606846976L), a(2862423051509815793L), a(6746640616477458432L), a(799006685782884121L), a(1638400000000000000L), a(3243919932521508681L), a(6221821273427820544L), a(504036361936467383L), a(876488338465357824L), a(1490116119384765625L), a(2481152873203736576L), a(4052555153018976267L), a(6502111422497947648L), a(353814783205469041L), a(531441000000000000L), a(787662783788549761L), a(1152921504606846976L), a(1667889514952984961L), a(2386420683693101056L), a(3379220508056640625L), a(4738381338321616896L) };
  private static int[] u = { 0, 0, 30, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5 };
  private static int[] v = { 0, 0, 1073741824, 1162261467, 1073741824, 1220703125, 362797056, 1977326743, 1073741824, 387420489, 1000000000, 214358881, 429981696, 815730721, 1475789056, 170859375, 268435456, 410338673, 612220032, 893871739, 1280000000, 1801088541, 113379904, 148035889, 191102976, 244140625, 308915776, 387420489, 481890304, 594823321, 729000000, 887503681, 1073741824, 1291467969, 1544804416, 1838265625, 60466176 };
  int a;
  int[] b;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  static
  {
    int i1 = 1;
    while (i1 <= 16)
    {
      localObject = new int[1];
      localObject[0] = i1;
      o[i1] = new aat((int[])localObject, 1);
      p[i1] = new aat((int[])localObject, -1);
      i1 += 1;
    }
    c = new aat(new int[0], 0);
    d = a(1L);
    q = a(2L);
    e = a(10L);
    f = new int[] { 7, 25, 81, 241, 673, 1793, 2147483647 };
    g = new byte[] { -25, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 6, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 7, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 6, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 5, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 0 };
    Object localObject = new String[64];
    r = (String[])localObject;
    localObject[63] = "000000000000000000000000000000000000000000000000000000000000000";
    i1 = 0;
    while (i1 < 63)
    {
      localObject = r;
      localObject[i1] = localObject[63].substring(0, i1);
      i1 += 1;
    }
  }
  
  private aat(long paramLong)
  {
    this.h = -1;
    this.i = -1;
    this.j = -2;
    this.k = -2;
    this.l = -2;
    if (paramLong < 0L)
    {
      this.a = -1;
      paramLong = -paramLong;
    }
    else
    {
      this.a = 1;
    }
    int i1 = (int)(paramLong >>> 32);
    if (i1 == 0)
    {
      this.b = new int[1];
      this.b[0] = ((int)paramLong);
      return;
    }
    this.b = new int[2];
    int[] arrayOfInt = this.b;
    arrayOfInt[0] = i1;
    arrayOfInt[1] = ((int)paramLong);
  }
  
  aat(aau paramaau, int paramInt)
  {
    this.h = -1;
    this.i = -1;
    this.j = -2;
    this.k = -2;
    this.l = -2;
    if ((paramaau.c <= 0) && (paramaau.a.length == paramaau.b))
    {
      this.b = paramaau.a;
    }
    else
    {
      this.b = new int[paramaau.b];
      int i1 = 0;
      while (i1 < paramaau.b)
      {
        this.b[i1] = paramaau.a[(paramaau.c + i1)];
        i1 += 1;
      }
    }
    if (paramaau.b == 0) {
      paramInt = 0;
    }
    this.a = paramInt;
  }
  
  public aat(String paramString)
  {
    this(paramString, 10);
  }
  
  public aat(String paramString, int paramInt)
  {
    this.h = -1;
    this.i = -1;
    this.j = -2;
    this.k = -2;
    this.l = -2;
    int i2 = paramString.length();
    if ((paramInt >= 2) && (paramInt <= 36))
    {
      if (paramString.length() != 0)
      {
        this.a = 1;
        int i1 = paramString.lastIndexOf('-');
        if (i1 != -1)
        {
          if (i1 == 0)
          {
            if (paramString.length() != 1)
            {
              this.a = -1;
              i1 = 1;
            }
            else
            {
              throw new NumberFormatException("Zero length BigInteger");
            }
          }
          else {
            throw new NumberFormatException("Illegal embedded minus sign");
          }
        }
        else {
          i1 = 0;
        }
        while ((i1 < i2) && (Character.digit(paramString.charAt(i1), paramInt) == 0)) {
          i1 += 1;
        }
        if (i1 == i2)
        {
          this.a = 0;
          this.b = c.b;
          return;
        }
        i2 -= i1;
        this.b = new int[((int)((i2 * m[paramInt] >>> 10) + 1L) + 31) / 32];
        Object localObject = u;
        int i3 = i2 % localObject[paramInt];
        i2 = i3;
        if (i3 == 0) {
          i2 = localObject[paramInt];
        }
        i2 += i1;
        localObject = paramString.substring(i1, i2);
        int[] arrayOfInt = this.b;
        arrayOfInt[(arrayOfInt.length - 1)] = Integer.parseInt((String)localObject, paramInt);
        localObject = this.b;
        if (localObject[(localObject.length - 1)] >= 0)
        {
          i3 = v[paramInt];
          i1 = i2;
          while (i1 < paramString.length())
          {
            i2 = u[paramInt] + i1;
            i1 = Integer.parseInt(paramString.substring(i1, i2), paramInt);
            if (i1 >= 0)
            {
              b(this.b, i3, i1);
              i1 = i2;
            }
            else
            {
              throw new NumberFormatException("Illegal digit");
            }
          }
          this.b = c(this.b);
          return;
        }
        throw new NumberFormatException("Illegal digit");
      }
      throw new NumberFormatException("Zero length BigInteger");
    }
    throw new NumberFormatException("Radix out of range");
  }
  
  public aat(byte[] paramArrayOfByte)
  {
    int i1 = -1;
    this.h = -1;
    this.i = -1;
    this.j = -2;
    this.k = -2;
    this.l = -2;
    if (paramArrayOfByte[0] < 0)
    {
      this.b = b(paramArrayOfByte);
    }
    else
    {
      this.b = a(paramArrayOfByte);
      if (this.b.length == 0) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    this.a = i1;
  }
  
  private aat(int[] paramArrayOfInt)
  {
    this.h = -1;
    this.i = -1;
    this.j = -2;
    this.k = -2;
    this.l = -2;
    this.b = b(paramArrayOfInt);
    if (this.b.length == 0)
    {
      this.a = 0;
      return;
    }
    this.a = 1;
  }
  
  private aat(int[] paramArrayOfInt, int paramInt)
  {
    this.h = -1;
    this.i = -1;
    this.j = -2;
    this.k = -2;
    this.l = -2;
    if (paramArrayOfInt.length == 0) {
      paramInt = 0;
    }
    this.a = paramInt;
    this.b = paramArrayOfInt;
  }
  
  static int a(int paramInt)
  {
    if (paramInt < 32768)
    {
      if (paramInt < 128)
      {
        if (paramInt < 8)
        {
          if (paramInt < 2)
          {
            if (paramInt <= 0)
            {
              if (paramInt < 0) {
                return 32;
              }
              return 0;
            }
            return 1;
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
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = paramArrayOfInt.length - 1 - paramInt2 - paramInt1;
    long l1 = (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + (0xFFFFFFFF & paramInt3);
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
    int i1 = 0;
    while (i1 < paramInt)
    {
      long l1 = paramArrayOfInt1[i1] & 0xFFFFFFFF;
      long l2 = 0xFFFFFFFF & paramArrayOfInt2[i1];
      if (l1 < l2) {
        return -1;
      }
      if (l1 > l2) {
        return 1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = paramInt3;
    paramInt1 = paramArrayOfInt1.length - paramInt1 - 1;
    paramInt2 -= 1;
    long l1 = 0L;
    while (paramInt2 >= 0)
    {
      l1 = (paramArrayOfInt2[paramInt2] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF) + (paramArrayOfInt1[paramInt1] & 0xFFFFFFFF) + l1;
      paramArrayOfInt1[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    return (int)l1;
  }
  
  private static aat a(long paramLong)
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
    return new aat(paramLong);
  }
  
  private aat a(aat paramaat)
  {
    int i1 = paramaat.a;
    if (i1 == 0) {
      return this;
    }
    int i2 = this.a;
    if (i2 == 0) {
      return paramaat;
    }
    if (i1 == i2) {
      return new aat(a(this.b, paramaat.b), this.a);
    }
    i1 = c(this.b, paramaat.b);
    if (i1 == 0) {
      return c;
    }
    if (i1 > 0) {
      paramaat = b(this.b, paramaat.b);
    } else {
      paramaat = b(paramaat.b, this.b);
    }
    return new aat(c(paramaat), i1 * this.a);
  }
  
  private aat a(aat paramaat, int paramInt)
  {
    Object localObject1 = a(1L);
    aat localaat2 = c(paramInt);
    int i4 = paramaat.e();
    int i3 = 0;
    Object localObject2 = localObject1;
    aat localaat1 = localaat2;
    int i2 = i4;
    int i1 = i3;
    if (f(0))
    {
      int i5 = paramInt - 1;
      localObject2 = localObject1;
      localaat1 = localaat2;
      i2 = i4;
      i1 = i3;
      if (i5 < i4)
      {
        i2 = i5;
        i1 = i3;
        localaat1 = localaat2;
        localObject2 = localObject1;
      }
    }
    while (i1 < i2)
    {
      localObject1 = localObject2;
      if (paramaat.f(i1)) {
        localObject1 = ((aat)localObject2).b(localaat1).c(paramInt);
      }
      i3 = i1 + 1;
      localObject2 = localObject1;
      i1 = i3;
      if (i3 < i2)
      {
        if (localaat1.a == 0)
        {
          localObject2 = c;
        }
        else
        {
          localObject2 = localaat1.b;
          localObject2 = new aat(c(a((int[])localObject2, localObject2.length, null)), 1);
        }
        localaat1 = ((aat)localObject2).c(paramInt);
        localObject2 = localObject1;
        i1 = i3;
      }
    }
    return localObject2;
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      int i1 = 0;
      int i3;
      for (int i2 = paramArrayOfInt[0]; i1 < paramInt1 + 0 - 1; i2 = i3)
      {
        int i4 = i1 + 1;
        i3 = paramArrayOfInt[i4];
        paramArrayOfInt[i1] = (i2 << paramInt2 | i3 >>> 32 - paramInt2);
        i1 = i4;
      }
      paramInt1 -= 1;
      paramArrayOfInt[paramInt1] <<= paramInt2;
      return;
    }
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
    i1 -= 1;
    i3 -= 1;
    while (i3 >= 0)
    {
      int i4 = i1 - 1;
      paramArrayOfByte[i1] &= 0xFF;
      int i5 = Math.min(3, i4 - i2 + 1);
      i1 = i4;
      i4 = 8;
      while (i4 <= i5 * 8)
      {
        int i6 = arrayOfInt[i3];
        arrayOfInt[i3] = ((paramArrayOfByte[i1] & 0xFF) << i4 | i6);
        i4 += 8;
        i1 -= 1;
      }
      i3 -= 1;
    }
    return arrayOfInt;
  }
  
  private static int[] a(int[] paramArrayOfInt)
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
  
  private static final int[] a(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
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
    int i2 = 0;
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
    i2 = paramInt;
    i1 = 1;
    while (i2 > 0)
    {
      i3 = i2 - 1;
      a(arrayOfInt, i1 - 1, i2, a(arrayOfInt, paramArrayOfInt1, i1, i3, paramArrayOfInt1[i3]));
      i2 -= 1;
      i1 += 2;
    }
    a(arrayOfInt, i4, 1);
    i1 = i4 - 1;
    i2 = arrayOfInt[i1];
    arrayOfInt[i1] = (paramArrayOfInt1[(paramInt - 1)] & 0x1 | i2);
    return arrayOfInt;
  }
  
  private static int[] a(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3)
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
    int i3 = i1 + 1;
    paramInt1 = i3 + i2;
    long l1 = 0L;
    paramInt2 = i1;
    while (paramInt2 >= 0)
    {
      l1 = (paramArrayOfInt2[paramInt2] & 0xFFFFFFFF) * (paramArrayOfInt1[i2] & 0xFFFFFFFF) + l1;
      arrayOfInt[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    arrayOfInt[i2] = ((int)l1);
    paramInt1 = i2 - 1;
    while (paramInt1 >= 0)
    {
      paramInt2 = i3 + paramInt1;
      l1 = 0L;
      i2 = i1;
      while (i2 >= 0)
      {
        long l2 = l1;
        if (paramInt2 >= 0)
        {
          l1 = (paramArrayOfInt2[i2] & 0xFFFFFFFF) * (paramArrayOfInt1[paramInt1] & 0xFFFFFFFF) + (arrayOfInt[paramInt2] & 0xFFFFFFFF) + l1;
          arrayOfInt[paramInt2] = ((int)l1);
          l2 = l1 >>> 32;
        }
        i2 -= 1;
        paramInt2 -= 1;
        l1 = l2;
      }
      arrayOfInt[paramInt1] = ((int)l1);
      paramInt1 -= 1;
    }
    return arrayOfInt;
  }
  
  private static int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length;
    int[] arrayOfInt2 = paramArrayOfInt1;
    int[] arrayOfInt1 = paramArrayOfInt2;
    if (i1 < paramArrayOfInt2.length)
    {
      arrayOfInt1 = paramArrayOfInt1;
      arrayOfInt2 = paramArrayOfInt2;
    }
    int i2 = arrayOfInt2.length;
    i1 = arrayOfInt1.length;
    paramArrayOfInt1 = new int[i2];
    long l1 = 0L;
    while (i1 > 0)
    {
      i2 -= 1;
      long l2 = arrayOfInt2[i2];
      i1 -= 1;
      l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (0xFFFFFFFF & arrayOfInt1[i1]));
      paramArrayOfInt1[i2] = ((int)l1);
    }
    if (l1 >>> 32 != 0L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i3;
    for (;;)
    {
      i3 = i2;
      if (i2 <= 0) {
        break;
      }
      i3 = i2;
      if (i1 == 0) {
        break;
      }
      i2 -= 1;
      i1 = arrayOfInt2[i2] + 1;
      paramArrayOfInt1[i2] = i1;
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    while (i3 > 0)
    {
      i3 -= 1;
      paramArrayOfInt1[i3] = arrayOfInt2[i3];
    }
    if (i1 != 0)
    {
      i2 = paramArrayOfInt1.length + 1;
      paramArrayOfInt2 = new int[i2];
      i1 = 1;
      while (i1 < i2)
      {
        paramArrayOfInt2[i1] = paramArrayOfInt1[(i1 - 1)];
        i1 += 1;
      }
      paramArrayOfInt2[0] = 1;
      return paramArrayOfInt2;
    }
    return paramArrayOfInt1;
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
      i2 = i3;
      i1 = i5;
    } while (i5 > 0);
    while (i3 > 0) {
      i3 += b(paramArrayOfInt1, paramArrayOfInt2, paramInt1);
    }
    while (a(paramArrayOfInt1, paramArrayOfInt2, paramInt1) >= 0) {
      b(paramArrayOfInt1, paramArrayOfInt2, paramInt1);
    }
    return paramArrayOfInt1;
  }
  
  static int b(int paramInt)
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
  
  private static int b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    long l1 = 0L;
    for (;;)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      l1 = (l1 >> 32) + ((paramArrayOfInt1[paramInt] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt2[paramInt]));
      paramArrayOfInt1[paramInt] = ((int)l1);
    }
    return (int)(l1 >> 32);
  }
  
  private aat b()
  {
    if (this.a >= 0) {
      return this;
    }
    return c();
  }
  
  private aat b(aat paramaat)
  {
    if ((this.a != 0) && (paramaat.a != 0))
    {
      int[] arrayOfInt1 = this.b;
      int i1 = arrayOfInt1.length;
      int[] arrayOfInt2 = paramaat.b;
      return new aat(c(a(arrayOfInt1, i1, arrayOfInt2, arrayOfInt2.length, null)), this.a * paramaat.a);
    }
    return c;
  }
  
  private aat b(aat paramaat1, aat paramaat2)
  {
    if (paramaat1.equals(d)) {
      return this;
    }
    if (this.a == 0) {
      return c;
    }
    int[] arrayOfInt1 = this.b;
    Object localObject = new int[arrayOfInt1.length];
    System.arraycopy(arrayOfInt1, 0, localObject, 0, arrayOfInt1.length);
    int[] arrayOfInt2 = paramaat1.b;
    int[] arrayOfInt3 = paramaat2.b;
    int i13 = arrayOfInt3.length;
    int i1 = arrayOfInt2.length;
    int i2;
    if (i1 == 0) {
      i2 = 0;
    } else {
      i2 = (i1 - 1 << 5) + a(arrayOfInt2[0]);
    }
    int i7;
    if ((i2 == 17) && (arrayOfInt2[0] == 65537))
    {
      i7 = 0;
    }
    else
    {
      i1 = 0;
      for (;;)
      {
        i7 = i1;
        if (i2 <= f[i1]) {
          break;
        }
        i1 += 1;
      }
    }
    int i14 = 1 << i7;
    int[][] arrayOfInt = new int[i14][];
    i1 = 0;
    while (i1 < i14)
    {
      arrayOfInt[i1] = new int[i13];
      i1 += 1;
    }
    int i15 = -aau.d(arrayOfInt3[(i13 - 1)]);
    int i4 = localObject.length;
    i1 = i13 << 5;
    int i5 = i1 >>> 5;
    int i3 = i1 & 0x1F;
    int i6 = 32 - a(localObject[0]);
    if (i1 <= i6)
    {
      a((int[])localObject, i4, i3);
    }
    else if (i3 <= i6)
    {
      paramaat1 = new int[i5 + i4];
      i1 = 0;
      while (i1 < i4)
      {
        paramaat1[i1] = localObject[i1];
        i1 += 1;
      }
      a(paramaat1, paramaat1.length, i3);
      localObject = paramaat1;
    }
    else
    {
      paramaat1 = new int[i5 + i4 + 1];
      i1 = 0;
      while (i1 < i4)
      {
        paramaat1[i1] = localObject[i1];
        i1 += 1;
      }
      i1 = paramaat1.length;
      i5 = 32 - i3;
      i1 -= 1;
      for (i3 = paramaat1[i1]; i1 > 0; i3 = i4)
      {
        i4 = paramaat1[(i1 - 1)];
        paramaat1[i1] = (i4 << 32 - i5 | i3 >>> i5);
        i1 -= 1;
      }
      paramaat1[0] >>>= i5;
      localObject = paramaat1;
    }
    paramaat2 = new aau();
    paramaat1 = new aau();
    new aau((int[])localObject).a(new aau(arrayOfInt3), paramaat2, paramaat1);
    paramaat2 = new int[paramaat1.b];
    i1 = 0;
    while (i1 < paramaat1.b)
    {
      paramaat2[i1] = paramaat1.a[(paramaat1.c + i1)];
      i1 += 1;
    }
    arrayOfInt[0] = paramaat2;
    if (arrayOfInt[0].length < i13)
    {
      i3 = arrayOfInt[0].length;
      paramaat1 = new int[i13];
      i1 = 0;
      while (i1 < arrayOfInt[0].length)
      {
        paramaat1[(i1 + (i13 - i3))] = arrayOfInt[0][i1];
        i1 += 1;
      }
      arrayOfInt[0] = paramaat1;
    }
    paramaat1 = a(a(arrayOfInt[0], i13, null), arrayOfInt3, i13, i15);
    paramaat2 = new int[i13];
    i1 = 0;
    while (i1 < i13)
    {
      paramaat2[i1] = paramaat1[i1];
      i1 += 1;
    }
    i1 = 1;
    while (i1 < i14)
    {
      arrayOfInt[i1] = a(a(paramaat2, i13, arrayOfInt[(i1 - 1)], i13, null), arrayOfInt3, i13, i15);
      i1 += 1;
    }
    i3 = arrayOfInt2.length;
    i5 = 1 << (i2 - 1 & 0x1F);
    i6 = 0;
    i1 = 0;
    i4 = 0;
    int i8;
    int i10;
    int i9;
    while (i6 <= i7)
    {
      if ((arrayOfInt2[i4] & i5) != 0) {
        i8 = 1;
      } else {
        i8 = 0;
      }
      i1 = i1 << 1 | i8;
      i10 = i5 >>> 1;
      i9 = i4;
      i5 = i10;
      i8 = i3;
      if (i10 == 0)
      {
        i9 = i4 + 1;
        i8 = i3 - 1;
        i5 = -2147483648;
      }
      i6 += 1;
      i4 = i9;
      i3 = i8;
    }
    int i11 = i2 - 1;
    i6 = i11 - i7;
    while ((i1 & 0x1) == 0)
    {
      i1 >>>= 1;
      i6 += 1;
    }
    paramaat2 = arrayOfInt[(i1 >>> 1)];
    if (i6 == i11)
    {
      i1 = 0;
      i2 = 0;
      i10 = i5;
      i9 = i3;
    }
    else
    {
      i1 = 0;
      i2 = 1;
      i9 = i3;
      i10 = i5;
    }
    for (;;)
    {
      i11 -= 1;
      int i12 = i1 << 1;
      i1 = i12;
      i8 = i4;
      i3 = i10;
      i5 = i9;
      if (i9 != 0)
      {
        if ((arrayOfInt2[i4] & i10) != 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        i12 |= i1;
        i10 >>>= 1;
        i1 = i12;
        i8 = i4;
        i3 = i10;
        i5 = i9;
        if (i10 == 0)
        {
          i8 = i4 + 1;
          i5 = i9 - 1;
          i3 = -2147483648;
          i1 = i12;
        }
      }
      if ((i1 & i14) != 0)
      {
        i4 = i11 - i7;
        while ((i1 & 0x1) == 0)
        {
          i1 >>>= 1;
          i4 += 1;
        }
        paramaat2 = arrayOfInt[(i1 >>> 1)];
        i1 = 0;
      }
      else
      {
        i4 = i6;
      }
      if (i11 == i4) {
        if (i2 != 0)
        {
          paramaat1 = new int[paramaat2.length];
          System.arraycopy(paramaat2, 0, paramaat1, 0, paramaat2.length);
          i2 = 0;
        }
        else
        {
          arrayOfInt1 = a(a(paramaat1, i13, paramaat2, i13, (int[])localObject), arrayOfInt3, i13, i15);
          localObject = paramaat1;
          paramaat1 = arrayOfInt1;
        }
      }
      i6 = 0;
      if (i11 == 0) {
        break;
      }
      if (i2 == 0)
      {
        arrayOfInt1 = a(a(paramaat1, i13, (int[])localObject), arrayOfInt3, i13, i15);
        localObject = paramaat1;
        paramaat1 = arrayOfInt1;
        i6 = i4;
        i4 = i8;
        i10 = i3;
        i9 = i5;
      }
      else
      {
        i6 = i4;
        i4 = i8;
        i10 = i3;
        i9 = i5;
      }
    }
    paramaat2 = new int[i13 * 2];
    i1 = 0;
    while (i1 < i13)
    {
      paramaat2[(i1 + i13)] = paramaat1[i1];
      i1 += 1;
    }
    paramaat1 = a(paramaat2, arrayOfInt3, i13, i15);
    paramaat2 = new int[i13];
    i1 = i6;
    while (i1 < i13)
    {
      paramaat2[i1] = paramaat1[i1];
      i1 += 1;
    }
    return new aat(paramaat2);
  }
  
  private static void b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    long l2 = paramInt1;
    long l3 = paramInt2;
    int i1 = paramArrayOfInt.length;
    paramInt2 = i1 - 1;
    long l1 = 0L;
    paramInt1 = paramInt2;
    while (paramInt1 >= 0)
    {
      l1 = (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF) + l1;
      paramArrayOfInt[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt1 -= 1;
    }
    l1 = (paramArrayOfInt[paramInt2] & 0xFFFFFFFF) + (l3 & 0xFFFFFFFF);
    paramArrayOfInt[paramInt2] = ((int)l1);
    l1 >>>= 32;
    paramInt1 = i1 - 2;
    while (paramInt1 >= 0)
    {
      l1 = (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + l1;
      paramArrayOfInt[paramInt1] = ((int)l1);
      l1 >>>= 32;
      paramInt1 -= 1;
    }
  }
  
  private static int[] b(byte[] paramArrayOfByte)
  {
    int i3 = paramArrayOfByte.length;
    int i1 = 0;
    while ((i1 < i3) && (paramArrayOfByte[i1] == -1)) {
      i1 += 1;
    }
    int i2 = i1;
    while ((i2 < i3) && (paramArrayOfByte[i2] == 0)) {
      i2 += 1;
    }
    if (i2 == i3) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i4 = (i3 - i1 + i2 + 3) / 4;
    int[] arrayOfInt = new int[i4];
    i2 = i3 - 1;
    i3 = i4 - 1;
    while (i3 >= 0)
    {
      int i5 = i2 - 1;
      paramArrayOfByte[i2] &= 0xFF;
      i2 = Math.min(3, i5 - i1 + 1);
      i4 = i2;
      if (i2 < 0) {
        i4 = 0;
      }
      i2 = i5;
      i5 = 8;
      while (i5 <= i4 * 8)
      {
        int i6 = arrayOfInt[i3];
        arrayOfInt[i3] = ((paramArrayOfByte[i2] & 0xFF) << i5 | i6);
        i5 += 8;
        i2 -= 1;
      }
      arrayOfInt[i3] = (-1 >>> (3 - i4) * 8 & (arrayOfInt[i3] ^ 0xFFFFFFFF));
      i3 -= 1;
    }
    i1 = arrayOfInt.length - 1;
    while (i1 >= 0)
    {
      arrayOfInt[i1] = ((int)((arrayOfInt[i1] & 0xFFFFFFFF) + 1L));
      if (arrayOfInt[i1] != 0) {
        break;
      }
      i1 -= 1;
    }
    return arrayOfInt;
  }
  
  private static int[] b(int[] paramArrayOfInt)
  {
    int i2 = 0;
    int i1 = 0;
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
    int i2 = paramArrayOfInt1.length;
    int[] arrayOfInt = new int[i2];
    int i1 = paramArrayOfInt2.length;
    long l1 = 0L;
    while (i1 > 0)
    {
      i2 -= 1;
      long l2 = paramArrayOfInt1[i2];
      i1 -= 1;
      l1 = (l1 >> 32) + ((l2 & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt2[i1]));
      arrayOfInt[i2] = ((int)l1);
    }
    if (l1 >> 32 != 0L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i3;
    for (;;)
    {
      i3 = i2;
      if (i2 <= 0) {
        break;
      }
      i3 = i2;
      if (i1 == 0) {
        break;
      }
      i2 -= 1;
      i1 = paramArrayOfInt1[i2] - 1;
      arrayOfInt[i2] = i1;
      if (i1 == -1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    while (i3 > 0)
    {
      i3 -= 1;
      arrayOfInt[i3] = paramArrayOfInt1[i3];
    }
    return arrayOfInt;
  }
  
  private static int c(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length < paramArrayOfInt2.length) {
      return -1;
    }
    if (paramArrayOfInt1.length > paramArrayOfInt2.length) {
      return 1;
    }
    int i1 = 0;
    while (i1 < paramArrayOfInt1.length)
    {
      long l1 = paramArrayOfInt1[i1] & 0xFFFFFFFF;
      long l2 = 0xFFFFFFFF & paramArrayOfInt2[i1];
      if (l1 < l2) {
        return -1;
      }
      if (l1 > l2) {
        return 1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private aat c()
  {
    return new aat(this.b, -this.a);
  }
  
  private aat c(int paramInt)
  {
    if (e() <= paramInt) {
      return this;
    }
    int i2 = (paramInt + 31) / 32;
    int[] arrayOfInt1 = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      int[] arrayOfInt2 = this.b;
      arrayOfInt1[i1] = arrayOfInt2[(arrayOfInt2.length - i2 + i1)];
      i1 += 1;
    }
    arrayOfInt1[0] = ((int)(arrayOfInt1[0] & (1L << 32 - ((i2 << 5) - paramInt)) - 1L));
    if (arrayOfInt1[0] == 0) {
      return new aat(arrayOfInt1);
    }
    return new aat(arrayOfInt1, 1);
  }
  
  private aat c(aat paramaat)
  {
    if (paramaat.a > 0)
    {
      Object localObject = new aau();
      aau localaau = new aau();
      new aau(this.b).a(new aau(paramaat.b), (aau)localObject, localaau);
      localObject = new aat(localaau, this.a);
      if (((aat)localObject).a >= 0) {
        return localObject;
      }
      return ((aat)localObject).a(paramaat);
    }
    throw new ArithmeticException("BigInteger: modulus not positive");
  }
  
  private static int[] c(int[] paramArrayOfInt)
  {
    int i2 = 0;
    int i1 = 0;
    while ((i1 < paramArrayOfInt.length) && (paramArrayOfInt[i1] == 0)) {
      i1 += 1;
    }
    if (i1 > 0)
    {
      int[] arrayOfInt = new int[paramArrayOfInt.length - i1];
      while (i2 < paramArrayOfInt.length - i1)
      {
        arrayOfInt[i2] = paramArrayOfInt[(i1 + i2)];
        i2 += 1;
      }
      return arrayOfInt;
    }
    return paramArrayOfInt;
  }
  
  private int d()
  {
    if (this.j == -2) {
      if (this.a == 0)
      {
        this.j = -1;
      }
      else
      {
        int i1 = 0;
        int i2;
        for (;;)
        {
          i2 = i(i1);
          if (i2 != 0) {
            break;
          }
          i1 += 1;
        }
        this.j = ((i1 << 5) + b(i2));
      }
    }
    return this.j;
  }
  
  private aat d(int paramInt)
  {
    if (this.a == 0) {
      return c;
    }
    if (paramInt == 0) {
      return this;
    }
    if (paramInt < 0) {
      return e(-paramInt);
    }
    int i2 = paramInt >>> 5;
    int i4 = paramInt & 0x1F;
    Object localObject = this.b;
    int i3 = localObject.length;
    int i1 = 0;
    paramInt = 0;
    int[] arrayOfInt;
    if (i4 == 0)
    {
      arrayOfInt = new int[i2 + i3];
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
    paramInt = localObject[0] >>> i5;
    if (paramInt != 0)
    {
      localObject = new int[i2 + i3 + 1];
      localObject[0] = paramInt;
      paramInt = 1;
    }
    else
    {
      localObject = new int[i2 + i3];
      paramInt = 0;
    }
    while (i1 < i3 - 1)
    {
      arrayOfInt = this.b;
      i2 = i1 + 1;
      localObject[paramInt] = (arrayOfInt[i1] << i4 | arrayOfInt[i2] >>> i5);
      paramInt += 1;
      i1 = i2;
    }
    localObject[paramInt] = (this.b[i1] << i4);
    return new aat((int[])localObject, this.a);
  }
  
  private aat d(aat paramaat)
  {
    if (paramaat.a == 1)
    {
      if (paramaat.equals(d)) {
        return c;
      }
      if ((this.a >= 0) && (c(this.b, paramaat.b) < 0)) {
        localObject = this;
      } else {
        localObject = c(paramaat);
      }
      if (((aat)localObject).equals(d)) {
        return d;
      }
      aau localaau3 = new aau((aat)localObject);
      Object localObject = new aau(paramaat);
      int i1;
      if ((localObject.a[(localObject.c + localObject.b - 1)] & 0x1) == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        paramaat = localaau3.c((aau)localObject);
      }
      else
      {
        if (localaau3.c()) {
          break label311;
        }
        i1 = ((aau)localObject).a();
        aau localaau1 = new aau((aau)localObject);
        localaau1.a(i1);
        if (localaau1.b())
        {
          paramaat = localaau3.c(i1);
        }
        else
        {
          aau localaau2 = localaau3.c(localaau1);
          localaau3 = localaau3.c(i1);
          aau localaau4 = aau.a(new aau(1), new aau(localaau1), i1);
          aau localaau5 = localaau1.c(i1);
          aau localaau6 = new aau();
          paramaat = new aau();
          aau localaau7 = new aau();
          localaau2.b(i1);
          localaau2.a(localaau4, localaau7);
          localaau3.a(localaau1, localaau6);
          localaau6.a(localaau5, paramaat);
          localaau7.a(paramaat);
          localaau7.a((aau)localObject, localaau6, paramaat);
        }
      }
      return new aat(paramaat, 1);
      label311:
      throw new ArithmeticException("BigInteger not invertible.");
    }
    throw new ArithmeticException("BigInteger: modulus not positive");
  }
  
  private int e()
  {
    if (this.i == -1) {
      if (this.a == 0)
      {
        this.i = 0;
      }
      else
      {
        int[] arrayOfInt = this.b;
        int i3 = (arrayOfInt.length - 1 << 5) + a(arrayOfInt[0]);
        if (this.a < 0)
        {
          int i1;
          if (g(this.b[0]) == 1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          int i2 = 1;
          for (;;)
          {
            arrayOfInt = this.b;
            if ((i2 >= arrayOfInt.length) || (i1 == 0)) {
              break;
            }
            if (arrayOfInt[i2] == 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            i2 += 1;
          }
          i2 = i3;
          if (i1 != 0) {
            i2 = i3 - 1;
          }
          this.i = i2;
        }
        else
        {
          this.i = i3;
        }
      }
    }
    return this.i;
  }
  
  private int e(aat paramaat)
  {
    int i1 = this.a;
    int i2 = paramaat.a;
    if (i1 == i2) {
      return i1 * c(this.b, paramaat.b);
    }
    if (i1 > i2) {
      return 1;
    }
    return -1;
  }
  
  private aat e(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    if (paramInt < 0) {
      return d(-paramInt);
    }
    int i4 = paramInt >>> 5;
    int i3 = paramInt & 0x1F;
    Object localObject1 = this.b;
    int i5 = localObject1.length;
    if (i4 >= i5)
    {
      if (this.a >= 0) {
        return c;
      }
      return p[1];
    }
    if (i3 == 0)
    {
      i1 = i5 - i4;
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
    paramInt = localObject1[0] >>> i3;
    if (paramInt != 0)
    {
      localObject2 = new int[i5 - i4];
      localObject2[0] = paramInt;
      paramInt = 1;
    }
    else
    {
      localObject2 = new int[i5 - i4 - 1];
      paramInt = 0;
    }
    int i2 = 0;
    int i1 = paramInt;
    for (paramInt = i2;; paramInt = i2)
    {
      localObject1 = localObject2;
      if (paramInt >= i5 - i4 - 1) {
        break;
      }
      localObject1 = this.b;
      i2 = paramInt + 1;
      localObject2[i1] = (localObject1[paramInt] << 32 - i3 | localObject1[i2] >>> i3);
      i1 += 1;
    }
    Object localObject2 = localObject1;
    if (this.a < 0)
    {
      i1 = i5 - 1;
      i2 = i5 - i4;
      paramInt = 0;
      while ((i1 >= i2) && (paramInt == 0))
      {
        if (this.b[i1] != 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        i1 -= 1;
      }
      i1 = paramInt;
      if (paramInt == 0)
      {
        i1 = paramInt;
        if (i3 != 0) {
          if (this.b[(i2 - 1)] << 32 - i3 != 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
        }
      }
      localObject2 = localObject1;
      if (i1 != 0) {
        localObject2 = a((int[])localObject1);
      }
    }
    return new aat((int[])localObject2, this.a);
  }
  
  private long f()
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
  
  private boolean f(int paramInt)
  {
    if (paramInt >= 0) {
      return (1 << paramInt % 32 & i(paramInt / 32)) != 0;
    }
    throw new ArithmeticException("Negative bit address");
  }
  
  private int g()
  {
    if (this.a < 0) {
      return -1;
    }
    return 0;
  }
  
  private static int g(int paramInt)
  {
    paramInt -= ((0xAAAAAAAA & paramInt) >>> 1);
    paramInt = (paramInt & 0x33333333) + (paramInt >>> 2 & 0x33333333);
    paramInt = 0xF0F0F0F & paramInt + (paramInt >>> 4);
    paramInt += (paramInt >>> 8);
    return paramInt + (paramInt >>> 16) & 0xFF;
  }
  
  private int h()
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
  
  private String h(int paramInt)
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
    Object localObject1 = b();
    paramInt = 0;
    while (((aat)localObject1).a != 0)
    {
      aat localaat = t[i1];
      Object localObject2 = new aau();
      aau localaau = new aau();
      new aau(((aat)localObject1).b).a(new aau(localaat.b), (aau)localObject2, localaau);
      localObject2 = new aat((aau)localObject2, ((aat)localObject1).a * localaat.a);
      arrayOfString[paramInt] = Long.toString(new aat(localaau, ((aat)localObject1).a * localaat.a).f(), i1);
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
  
  private int i(int paramInt)
  {
    if (paramInt < 0) {
      return 0;
    }
    int[] arrayOfInt = this.b;
    if (paramInt >= arrayOfInt.length) {
      return g();
    }
    int i1 = arrayOfInt[(arrayOfInt.length - paramInt - 1)];
    if (this.a >= 0) {
      return i1;
    }
    if (paramInt <= h()) {
      return -i1;
    }
    return i1 ^ 0xFFFFFFFF;
  }
  
  public final aat a(aat paramaat1, aat paramaat2)
  {
    if (paramaat2.a > 0)
    {
      if (paramaat1.a == 0)
      {
        if (paramaat2.equals(d)) {
          return c;
        }
        return d;
      }
      if (equals(d))
      {
        if (paramaat2.equals(d)) {
          return c;
        }
        return d;
      }
      if ((equals(c)) && (paramaat1.a >= 0)) {
        return c;
      }
      Object localObject = p;
      int i1 = 1;
      if ((equals(localObject[1])) && (!paramaat1.f(0)))
      {
        if (paramaat2.equals(d)) {
          return c;
        }
        return d;
      }
      if (paramaat1.a >= 0) {
        i1 = 0;
      }
      localObject = paramaat1;
      if (i1 != 0) {
        localObject = paramaat1.c();
      }
      if ((this.a >= 0) && (e(paramaat2) < 0)) {
        paramaat1 = this;
      } else {
        paramaat1 = c(paramaat2);
      }
      if (paramaat2.f(0))
      {
        paramaat1 = paramaat1.b((aat)localObject, paramaat2);
      }
      else
      {
        int i2 = paramaat2.d();
        aat localaat2 = paramaat2.e(i2);
        aat localaat3 = d.d(i2);
        aat localaat1;
        if ((this.a >= 0) && (e(localaat2) < 0)) {
          localaat1 = this;
        } else {
          localaat1 = c(localaat2);
        }
        if (localaat2.equals(d)) {
          localaat1 = c;
        } else {
          localaat1 = localaat1.b((aat)localObject, localaat2);
        }
        paramaat1 = paramaat1.a((aat)localObject, i2);
        localObject = localaat3.d(localaat2);
        aat localaat4 = localaat2.d(localaat3);
        paramaat1 = localaat1.b(localaat3).b((aat)localObject).a(paramaat1.b(localaat2).b(localaat4)).c(paramaat2);
      }
      localObject = paramaat1;
      if (i1 != 0) {
        localObject = paramaat1.d(paramaat2);
      }
      return localObject;
    }
    throw new ArithmeticException("BigInteger: modulus not positive");
  }
  
  public final String a()
  {
    String str2 = h(16);
    String str1 = str2;
    if (str2.length() % 2 != 0) {
      str1 = "0".concat(String.valueOf(str2));
    }
    return str1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof aat)) {
      return false;
    }
    paramObject = (aat)paramObject;
    if (paramObject.a == this.a)
    {
      if (paramObject.b.length != this.b.length) {
        return false;
      }
      int i1 = 0;
      for (;;)
      {
        int[] arrayOfInt = this.b;
        if (i1 >= arrayOfInt.length) {
          break;
        }
        if (paramObject.b[i1] != arrayOfInt[i1]) {
          return false;
        }
        i1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    int i2 = 0;
    for (;;)
    {
      int[] arrayOfInt = this.b;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      i2 = (int)(i2 * 31 + (arrayOfInt[i1] & 0xFFFFFFFF));
      i1 += 1;
    }
    return i2 * this.a;
  }
  
  public final String toString()
  {
    return h(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aat
 * JD-Core Version:    0.7.0.1
 */