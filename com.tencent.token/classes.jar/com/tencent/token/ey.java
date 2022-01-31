package com.tencent.token;

class ey
{
  int[] a;
  int b;
  int c = 0;
  
  ey()
  {
    this.a = new int[1];
    this.b = 0;
  }
  
  ey(int paramInt)
  {
    this.a = new int[1];
    this.b = 1;
    this.a[0] = paramInt;
  }
  
  ey(ex paramex)
  {
    this.a = new int[paramex.b.length];
    System.arraycopy(paramex.b, 0, this.a, 0, paramex.b.length);
    this.b = this.a.length;
  }
  
  ey(ey paramey)
  {
    this.b = paramey.b;
    this.a = new int[this.b];
    while (i < this.b)
    {
      this.a[i] = paramey.a[(paramey.c + i)];
      i += 1;
    }
  }
  
  ey(int[] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramArrayOfInt.length;
  }
  
  private int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    long l = 0L;
    int i = paramArrayOfInt1.length - 1;
    while (i >= 0)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) + (paramArrayOfInt2[(i + paramInt)] & 0xFFFFFFFF);
      paramArrayOfInt2[(i + paramInt)] = ((int)l);
      l >>>= 32;
      i -= 1;
    }
    return (int)l;
  }
  
  private int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = paramInt1;
    long l1 = 0L;
    paramInt1 = paramInt3 + paramInt2;
    paramInt2 -= 1;
    if (paramInt2 >= 0)
    {
      l1 += (paramArrayOfInt2[paramInt2] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF);
      long l3 = paramArrayOfInt1[paramInt1] - l1;
      paramArrayOfInt1[paramInt1] = ((int)l3);
      if ((l3 & 0xFFFFFFFF) > (((int)l1 ^ 0xFFFFFFFF) & 0xFFFFFFFF)) {}
      for (paramInt3 = 1;; paramInt3 = 0)
      {
        l1 = paramInt3 + (l1 >>> 32);
        paramInt2 -= 1;
        paramInt1 -= 1;
        break;
      }
    }
    return (int)l1;
  }
  
  static ey a(ey paramey, int paramInt)
  {
    return a(new ey(1), new ey(paramey), paramInt);
  }
  
  static ey a(ey paramey1, ey paramey2, int paramInt)
  {
    ey localey = new ey();
    int j = -d(paramey2.a[(paramey2.c + paramey2.b - 1)]);
    int i = 0;
    while (i < paramInt >> 5)
    {
      paramey2.a(paramey1.a[(paramey1.c + paramey1.b - 1)] * j, localey);
      paramey1.c(localey);
      paramey1.b -= 1;
      i += 1;
    }
    paramInt &= 0x1F;
    if (paramInt != 0)
    {
      paramey2.a(j * paramey1.a[(paramey1.c + paramey1.b - 1)] & (1 << paramInt) - 1, localey);
      paramey1.c(localey);
      paramey1.a(paramInt);
    }
    while (paramey1.a(paramey2) >= 0) {
      paramey1.d(paramey2);
    }
    return paramey1;
  }
  
  private void a(int[] paramArrayOfInt, long paramLong, int paramInt)
  {
    long l4 = paramInt & 0xFFFFFFFF;
    if (l4 == 1L)
    {
      paramArrayOfInt[0] = ((int)paramLong);
      paramArrayOfInt[1] = 0;
      return;
    }
    long l1 = (paramLong >>> 1) / (l4 >>> 1);
    long l2 = paramLong - l1 * l4;
    paramLong = l1;
    l1 = l2;
    long l3;
    for (;;)
    {
      l2 = l1;
      l3 = paramLong;
      if (l1 >= 0L) {
        break;
      }
      l1 += l4;
      paramLong -= 1L;
    }
    while (l2 >= l4)
    {
      l2 -= l4;
      l3 += 1L;
    }
    paramArrayOfInt[0] = ((int)l3);
    paramArrayOfInt[1] = ((int)l2);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - -9223372036854775808L > -9223372036854775808L + paramLong2;
  }
  
  static int d(int paramInt)
  {
    int i = (2 - paramInt * paramInt) * paramInt;
    i *= (2 - paramInt * i);
    i *= (2 - paramInt * i);
    return i * (2 - paramInt * i);
  }
  
  private ey f(ey paramey)
  {
    ey localey2 = new ey(paramey);
    Object localObject1 = new ey(this);
    Object localObject3 = new ey(localey2);
    paramey = new ez(1);
    Object localObject2 = new ez();
    int i;
    if (((ey)localObject1).g())
    {
      i = ((ey)localObject1).i();
      ((ey)localObject1).a(i);
      ((ez)localObject2).b(i);
    }
    for (;;)
    {
      if (!((ey)localObject1).e())
      {
        if (((ey)localObject1).f()) {
          throw new ArithmeticException("BigInteger not invertible.");
        }
        if (((ey)localObject1).a((ey)localObject3) >= 0) {
          break label255;
        }
      }
      for (;;)
      {
        if (((localObject3.a[(localObject3.c + localObject3.b - 1)] ^ localObject1.a[(localObject1.c + localObject1.b - 1)]) & 0x3) == 0)
        {
          ((ey)localObject3).d((ey)localObject1);
          ((ez)localObject2).b(paramey);
        }
        for (;;)
        {
          int j = ((ey)localObject3).i();
          ((ey)localObject3).a(j);
          paramey.b(j);
          i += j;
          localey1 = paramey;
          localObject4 = localObject1;
          paramey = (ey)localObject2;
          localObject2 = localey1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
          ((ey)localObject3).c((ey)localObject1);
          ((ez)localObject2).a(paramey);
        }
        while (paramey.d < 0) {
          paramey.f(localey2);
        }
        return a(paramey, localey2, i);
        label255:
        ey localey1 = paramey;
        paramey = (ey)localObject2;
        Object localObject4 = localObject1;
        localObject1 = localObject3;
        localObject2 = localey1;
        localObject3 = localObject4;
      }
      i = 0;
    }
  }
  
  private final void f(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int j = this.c + this.b - 1;
    int k;
    for (int i = arrayOfInt[j]; j > this.c; i = k)
    {
      k = arrayOfInt[(j - 1)];
      arrayOfInt[j] = (i >>> paramInt | k << 32 - paramInt);
      j -= 1;
    }
    i = this.c;
    arrayOfInt[i] >>>= paramInt;
  }
  
  private final void g(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int k = this.c;
    int i = arrayOfInt[k];
    int n = this.b;
    int j = k;
    while (j < n + k - 1)
    {
      int m = arrayOfInt[(j + 1)];
      arrayOfInt[j] = (i << paramInt | m >>> 32 - paramInt);
      j += 1;
      i = m;
    }
    i = this.c + this.b - 1;
    arrayOfInt[i] <<= paramInt;
  }
  
  private final int i()
  {
    if (this.b == 0) {}
    int i;
    int j;
    do
    {
      return -1;
      i = this.b - 1;
      while ((i > 0) && (this.a[(this.c + i)] == 0)) {
        i -= 1;
      }
      j = this.a[(this.c + i)];
    } while (j == 0);
    return (this.b - 1 - i << 5) + ex.f(j);
  }
  
  final int a(ey paramey)
  {
    int k = 0;
    int j;
    if (this.b < paramey.b)
    {
      j = -1;
      return j;
    }
    if (this.b > paramey.b) {
      return 1;
    }
    int i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.b) {
        break;
      }
      j = this.a[(this.c + i)] - -2147483648;
      int m = paramey.a[(paramey.c + i)] - -2147483648;
      if (j < m) {
        return -1;
      }
      if (j > m) {
        return 1;
      }
      i += 1;
    }
  }
  
  void a()
  {
    this.b = 0;
    this.c = 0;
    int j = this.a.length;
    int i = 0;
    while (i < j)
    {
      this.a[i] = 0;
      i += 1;
    }
  }
  
  void a(int paramInt)
  {
    if (this.b == 0) {}
    int i;
    do
    {
      return;
      i = paramInt & 0x1F;
      this.b -= (paramInt >>> 5);
    } while (i == 0);
    if (i >= ex.d(this.a[this.c]))
    {
      g(32 - i);
      this.b -= 1;
      return;
    }
    f(i);
  }
  
  void a(int paramInt, ey paramey)
  {
    if (paramInt == 1)
    {
      paramey.b(this);
      return;
    }
    if (paramInt == 0)
    {
      paramey.a();
      return;
    }
    long l2 = paramInt;
    if (paramey.a.length < this.b + 1) {}
    long l1;
    for (int[] arrayOfInt = new int[this.b + 1];; arrayOfInt = paramey.a)
    {
      l1 = 0L;
      paramInt = this.b - 1;
      while (paramInt >= 0)
      {
        l1 += (this.a[(this.c + paramInt)] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF);
        arrayOfInt[(paramInt + 1)] = ((int)l1);
        l1 >>>= 32;
        paramInt -= 1;
      }
    }
    if (l1 == 0L)
    {
      paramey.c = 1;
      paramey.b = this.b;
    }
    for (;;)
    {
      paramey.a = arrayOfInt;
      return;
      paramey.c = 0;
      this.b += 1;
      arrayOfInt[0] = ((int)l1);
    }
  }
  
  void a(ey paramey1, ey paramey2)
  {
    int k = this.b;
    int m = paramey1.b;
    int i = k + m;
    if (paramey2.a.length < i) {
      paramey2.a = new int[i];
    }
    paramey2.c = 0;
    paramey2.b = i;
    long l = 0L;
    int j = m - 1;
    i = m + k - 1;
    while (j >= 0)
    {
      l += (paramey1.a[(paramey1.c + j)] & 0xFFFFFFFF) * (this.a[(k - 1 + this.c)] & 0xFFFFFFFF);
      paramey2.a[i] = ((int)l);
      l >>>= 32;
      j -= 1;
      i -= 1;
    }
    paramey2.a[(k - 1)] = ((int)l);
    i = k - 2;
    while (i >= 0)
    {
      l = 0L;
      k = m - 1;
      j = m + i;
      while (k >= 0)
      {
        l += (paramey1.a[(paramey1.c + k)] & 0xFFFFFFFF) * (this.a[(this.c + i)] & 0xFFFFFFFF) + (paramey2.a[j] & 0xFFFFFFFF);
        paramey2.a[j] = ((int)l);
        l >>>= 32;
        k -= 1;
        j -= 1;
      }
      paramey2.a[i] = ((int)l);
      i -= 1;
    }
    paramey2.c();
  }
  
  void a(ey paramey1, ey paramey2, ey paramey3)
  {
    if (paramey1.b == 0) {
      throw new ArithmeticException("BigInteger divide by zero");
    }
    if (this.b == 0)
    {
      paramey3.c = 0;
      paramey3.b = 0;
      paramey2.c = 0;
      paramey2.b = 0;
      return;
    }
    int i = a(paramey1);
    if (i < 0)
    {
      paramey2.c = 0;
      paramey2.b = 0;
      paramey3.b(this);
      return;
    }
    if (i == 0)
    {
      paramey1 = paramey2.a;
      paramey2.b = 1;
      paramey1[0] = 1;
      paramey3.c = 0;
      paramey3.b = 0;
      paramey2.c = 0;
      return;
    }
    paramey2.a();
    if (paramey1.b == 1)
    {
      paramey3.b(this);
      paramey3.b(paramey1.a[paramey1.c], paramey2);
      return;
    }
    int[] arrayOfInt1 = new int[paramey1.b];
    i = 0;
    while (i < paramey1.b)
    {
      arrayOfInt1[i] = paramey1.a[(paramey1.c + i)];
      i += 1;
    }
    int i1 = paramey1.b;
    if (paramey3.a.length < this.b + 1) {
      paramey3.a = new int[this.b + 1];
    }
    i = 0;
    while (i < this.b)
    {
      paramey3.a[(i + 1)] = this.a[(this.c + i)];
      i += 1;
    }
    paramey3.b = this.b;
    paramey3.c = 1;
    i = paramey3.b;
    int i2 = i - i1 + 1;
    if (paramey2.a.length < i2)
    {
      paramey2.a = new int[i2];
      paramey2.c = 0;
    }
    paramey2.b = i2;
    paramey1 = paramey2.a;
    int i3 = 32 - ex.d(arrayOfInt1[0]);
    if (i3 > 0)
    {
      ex.b(arrayOfInt1, i1, i3);
      paramey3.b(i3);
    }
    if (paramey3.b == i)
    {
      paramey3.c = 0;
      paramey3.a[0] = 0;
      paramey3.b += 1;
    }
    int i4 = arrayOfInt1[0];
    long l1 = 0xFFFFFFFF & i4;
    int i5 = arrayOfInt1[1];
    int[] arrayOfInt2 = new int[2];
    int n = 0;
    if (n < i2)
    {
      int k = 0;
      i = paramey3.a[(paramey3.c + n)];
      int i6 = i - -2147483648;
      int m = paramey3.a[(n + 1 + paramey3.c)];
      int j;
      if (i == i4)
      {
        j = -1;
        m = i + m;
        if (-2147483648 + m < i6)
        {
          k = 1;
          label491:
          if (j != 0) {
            break label582;
          }
        }
      }
      for (;;)
      {
        n += 1;
        break;
        k = 0;
        break label491;
        long l2 = i << 32 | m & 0xFFFFFFFF;
        if (l2 >= 0L)
        {
          j = (int)(l2 / l1);
          m = (int)(l2 - j * l1);
          break label491;
        }
        a(arrayOfInt2, l2, i4);
        j = arrayOfInt2[0];
        m = arrayOfInt2[1];
        break label491;
        label582:
        i = j;
        if (k == 0)
        {
          l2 = paramey3.a[(n + 2 + paramey3.c)] & 0xFFFFFFFF;
          long l3 = m;
          i = j;
          if (a((i5 & 0xFFFFFFFF) * (j & 0xFFFFFFFF), (l3 & 0xFFFFFFFF) << 32 | l2))
          {
            j -= 1;
            k = (int)((m & 0xFFFFFFFF) + l1);
            i = j;
            if ((k & 0xFFFFFFFF) >= l1)
            {
              i = j;
              if (a((i5 & 0xFFFFFFFF) * (j & 0xFFFFFFFF), (k & 0xFFFFFFFF) << 32 | l2)) {
                i = j - 1;
              }
            }
          }
        }
        paramey3.a[(paramey3.c + n)] = 0;
        j = i;
        if (a(paramey3.a, arrayOfInt1, i, i1, n + paramey3.c) - -2147483648 > i6)
        {
          a(arrayOfInt1, paramey3.a, n + 1 + paramey3.c);
          j = i - 1;
        }
        paramey1[n] = j;
      }
    }
    if (i3 > 0) {
      paramey3.a(i3);
    }
    paramey3.c();
    paramey2.c();
  }
  
  void a(int[] paramArrayOfInt, int paramInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramInt;
    this.c = 0;
  }
  
  void b()
  {
    this.b = 0;
    this.c = 0;
  }
  
  void b(int paramInt)
  {
    int i = 0;
    if (this.b == 0) {
      return;
    }
    int k = paramInt & 0x1F;
    int m = ex.d(this.a[this.c]);
    if (paramInt <= 32 - m)
    {
      g(k);
      return;
    }
    int j = (paramInt >>> 5) + this.b + 1;
    paramInt = j;
    if (k <= 32 - m) {
      paramInt = j - 1;
    }
    if (this.a.length < paramInt)
    {
      int[] arrayOfInt = new int[paramInt];
      while (i < this.b)
      {
        arrayOfInt[i] = this.a[(this.c + i)];
        i += 1;
      }
      a(arrayOfInt, paramInt);
    }
    for (;;)
    {
      this.b = paramInt;
      if (k == 0) {
        break;
      }
      if (k > 32 - m) {
        break label267;
      }
      g(k);
      return;
      if (this.a.length - this.c >= paramInt)
      {
        i = 0;
        while (i < paramInt - this.b)
        {
          this.a[(this.c + this.b + i)] = 0;
          i += 1;
        }
      }
      else
      {
        i = 0;
        while (i < this.b)
        {
          this.a[i] = this.a[(this.c + i)];
          i += 1;
        }
        i = this.b;
        while (i < paramInt)
        {
          this.a[i] = 0;
          i += 1;
        }
        this.c = 0;
      }
    }
    label267:
    f(32 - k);
  }
  
  void b(int paramInt, ey paramey)
  {
    long l2 = paramInt & 0xFFFFFFFF;
    if (this.b == 1)
    {
      l1 = 0xFFFFFFFF & this.a[this.c];
      paramey.a[0] = ((int)(l1 / l2));
      if (paramey.a[0] == 0)
      {
        paramInt = 0;
        paramey.b = paramInt;
        paramey.c = 0;
        this.a[0] = ((int)(l1 - l2 * paramey.a[0]));
        this.c = 0;
        if (this.a[0] != 0) {
          break label112;
        }
      }
      label112:
      for (paramInt = 0;; paramInt = 1)
      {
        this.b = paramInt;
        return;
        paramInt = 1;
        break;
      }
    }
    if (paramey.a.length < this.b) {
      paramey.a = new int[this.b];
    }
    paramey.c = 0;
    paramey.b = this.b;
    int k = ex.d(paramInt);
    int i = this.a[this.c];
    long l1 = i & 0xFFFFFFFF;
    int j;
    int[] arrayOfInt;
    if (l1 < l2)
    {
      paramey.a[0] = 0;
      j = this.b;
      arrayOfInt = new int[2];
      label202:
      j -= 1;
      if (j <= 0) {
        break label358;
      }
      l1 = l1 << 32 | this.a[(this.c + this.b - j)] & 0xFFFFFFFF;
      if (l1 < 0L) {
        break label346;
      }
      arrayOfInt[0] = ((int)(l1 / l2));
      arrayOfInt[1] = ((int)(l1 - arrayOfInt[0] * l2));
    }
    for (;;)
    {
      paramey.a[(this.b - j)] = arrayOfInt[0];
      i = arrayOfInt[1];
      l1 = i & 0xFFFFFFFF;
      break label202;
      paramey.a[0] = ((int)(l1 / l2));
      i = (int)(l1 - paramey.a[0] * l2);
      l1 = i & 0xFFFFFFFF;
      break;
      label346:
      a(arrayOfInt, l1, paramInt);
    }
    label358:
    if (32 - k > 0)
    {
      this.a[0] = (i % paramInt);
      if (this.a[0] != 0) {
        break label406;
      }
    }
    label406:
    for (paramInt = 0;; paramInt = 1)
    {
      this.b = paramInt;
      paramey.c();
      return;
      this.a[0] = i;
      break;
    }
  }
  
  void b(ey paramey)
  {
    int j = paramey.b;
    if (this.a.length < j) {
      this.a = new int[j];
    }
    int i = 0;
    while (i < j)
    {
      this.a[i] = paramey.a[(paramey.c + i)];
      i += 1;
    }
    this.b = j;
    this.c = 0;
  }
  
  ey c(int paramInt)
  {
    if (g()) {
      throw new ArithmeticException("Non-invertible. (GCD != 1)");
    }
    if (paramInt > 64) {
      return e(paramInt);
    }
    int i = d(this.a[(this.c + this.b - 1)]);
    if (paramInt < 33)
    {
      if (paramInt == 32) {}
      for (paramInt = i;; paramInt = i & (1 << paramInt) - 1) {
        return new ey(paramInt);
      }
    }
    long l2 = this.a[(this.c + this.b - 1)] & 0xFFFFFFFF;
    long l1 = l2;
    if (this.b > 1) {
      l1 = l2 | this.a[(this.c + this.b - 2)] << 32;
    }
    l2 = i & 0xFFFFFFFF;
    l1 = l2 * (2L - l1 * l2);
    if (paramInt == 64) {}
    for (;;)
    {
      ey localey = new ey(new int[2]);
      localey.a[0] = ((int)(l1 >>> 32));
      localey.a[1] = ((int)l1);
      localey.b = 2;
      localey.c();
      return localey;
      l1 &= (1L << paramInt) - 1L;
    }
  }
  
  final void c()
  {
    int j = 0;
    if (this.b == 0) {
      this.c = 0;
    }
    int k;
    do
    {
      return;
      k = this.c;
    } while (this.a[k] != 0);
    int n = this.b;
    int i = k;
    int m;
    do
    {
      m = i + 1;
      if (m >= n + k) {
        break;
      }
      i = m;
    } while (this.a[m] == 0);
    i = m - this.c;
    this.b -= i;
    if (this.b == 0) {}
    for (i = j;; i = this.c + i)
    {
      this.c = i;
      return;
    }
  }
  
  void c(ey paramey)
  {
    int n = this.b;
    int j = paramey.b;
    int i;
    if (this.b > paramey.b)
    {
      i = this.b;
      if (this.a.length >= i) {
        break label161;
      }
    }
    int k;
    long l2;
    long l1;
    int m;
    int i1;
    label161:
    for (int[] arrayOfInt = new int[i];; arrayOfInt = this.a)
    {
      k = arrayOfInt.length - 1;
      l2 = 0L;
      for (;;)
      {
        l1 = l2;
        m = k;
        i1 = n;
        if (n <= 0) {
          break;
        }
        l1 = l2;
        m = k;
        i1 = n;
        if (j <= 0) {
          break;
        }
        n -= 1;
        j -= 1;
        l2 = (l2 >>> 32) + ((this.a[(this.c + n)] & 0xFFFFFFFF) + (paramey.a[(paramey.c + j)] & 0xFFFFFFFF));
        arrayOfInt[k] = ((int)l2);
        k -= 1;
      }
      i = paramey.b;
      break;
    }
    for (;;)
    {
      l2 = l1;
      k = m;
      n = j;
      if (i1 <= 0) {
        break;
      }
      i1 -= 1;
      l1 = (l1 >>> 32) + (this.a[(this.c + i1)] & 0xFFFFFFFF);
      arrayOfInt[m] = ((int)l1);
      m -= 1;
    }
    while (n > 0)
    {
      n -= 1;
      l2 = (l2 >>> 32) + (paramey.a[(paramey.c + n)] & 0xFFFFFFFF);
      arrayOfInt[k] = ((int)l2);
      k -= 1;
    }
    j = i;
    paramey = arrayOfInt;
    if (l2 >>> 32 > 0L)
    {
      i += 1;
      if (arrayOfInt.length >= i) {
        break label366;
      }
      paramey = new int[i];
      j = i - 1;
      while (j > 0)
      {
        paramey[j] = arrayOfInt[(j - 1)];
        j -= 1;
      }
      paramey[0] = 1;
      j = i;
    }
    for (;;)
    {
      this.a = paramey;
      this.b = j;
      this.c = (paramey.length - j);
      return;
      label366:
      arrayOfInt[k] = 1;
      j = i;
      paramey = arrayOfInt;
    }
  }
  
  int d(ey paramey)
  {
    int[] arrayOfInt = this.a;
    int m = a(paramey);
    if (m == 0)
    {
      b();
      return 0;
    }
    Object localObject;
    ey localey;
    if (m < 0)
    {
      localObject = this;
      localey = paramey;
      paramey = (ey)localObject;
    }
    for (;;)
    {
      int n = localey.b;
      localObject = arrayOfInt;
      if (arrayOfInt.length < n) {
        localObject = new int[n];
      }
      long l = 0L;
      int j = localey.b;
      int k = paramey.b;
      int i = localObject.length - 1;
      while (k > 0)
      {
        j -= 1;
        k -= 1;
        l = (localey.a[(localey.c + j)] & 0xFFFFFFFF) - (paramey.a[(paramey.c + k)] & 0xFFFFFFFF) - (int)-(l >> 32);
        localObject[i] = ((int)l);
        i -= 1;
      }
      for (;;)
      {
        if (j > 0)
        {
          j -= 1;
          l = (localey.a[(localey.c + j)] & 0xFFFFFFFF) - (int)-(l >> 32);
          localObject[i] = ((int)l);
          i -= 1;
        }
        else
        {
          this.a = ((int[])localObject);
          this.b = n;
          this.c = (this.a.length - n);
          c();
          return m;
        }
      }
      localey = this;
    }
  }
  
  int[] d()
  {
    int[] arrayOfInt = new int[this.b];
    int i = 0;
    while (i < this.b)
    {
      arrayOfInt[i] = this.a[(this.c + i)];
      i += 1;
    }
    return arrayOfInt;
  }
  
  ey e(int paramInt)
  {
    Object localObject1 = new ey(1);
    ((ey)localObject1).b(paramInt);
    ey localey1 = new ey((ey)localObject1);
    Object localObject2 = new ey(this);
    ey localey2 = new ey();
    Object localObject3 = new ey();
    ((ey)localObject1).a((ey)localObject2, localey2, (ey)localObject3);
    ey localey3 = new ey(localey2);
    ey localey4 = new ey(1);
    ey localey5 = new ey();
    if (!((ey)localObject3).e())
    {
      ((ey)localObject2).a((ey)localObject3, localey2, (ey)localObject1);
      if (((ey)localObject1).b == 0) {
        throw new ArithmeticException("BigInteger not invertible.");
      }
      if (localey2.b == 1) {
        localey3.a(localey2.a[localey2.c], localey5);
      }
      for (;;)
      {
        localey4.c(localey5);
        if (!((ey)localObject1).e()) {
          break;
        }
        return localey4;
        localey2.a(localey3, localey5);
      }
      ((ey)localObject3).a((ey)localObject1, localey5, (ey)localObject2);
      if (((ey)localObject2).b == 0) {
        throw new ArithmeticException("BigInteger not invertible.");
      }
      if (localey5.b == 1) {
        localey4.a(localey5.a[localey5.c], localey2);
      }
      for (;;)
      {
        localey3.c(localey2);
        Object localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        break;
        localey5.a(localey4, localey2);
      }
    }
    localey1.d(localey3);
    return localey1;
  }
  
  ey e(ey paramey)
  {
    if (paramey.h()) {
      return f(paramey);
    }
    if (g()) {
      throw new ArithmeticException("BigInteger not invertible.");
    }
    int i = paramey.i();
    ey localey1 = new ey(paramey);
    localey1.a(i);
    if (localey1.e()) {
      return c(i);
    }
    ey localey2 = f(localey1);
    ey localey3 = c(i);
    ey localey4 = a(localey1, i);
    ey localey5 = localey1.c(i);
    ey localey6 = new ey();
    ey localey7 = new ey();
    ey localey8 = new ey();
    localey2.b(i);
    localey2.a(localey4, localey8);
    localey3.a(localey1, localey6);
    localey6.a(localey5, localey7);
    localey8.c(localey7);
    localey8.a(paramey, localey6, localey7);
    return localey7;
  }
  
  boolean e()
  {
    return (this.b == 1) && (this.a[this.c] == 1);
  }
  
  boolean f()
  {
    return this.b == 0;
  }
  
  boolean g()
  {
    return (this.b == 0) || ((this.a[(this.c + this.b - 1)] & 0x1) == 0);
  }
  
  boolean h()
  {
    return (this.a[(this.c + this.b - 1)] & 0x1) == 1;
  }
  
  public String toString()
  {
    return new ex(this, 1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ey
 * JD-Core Version:    0.7.0.1
 */