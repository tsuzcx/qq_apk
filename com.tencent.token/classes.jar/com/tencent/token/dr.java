package com.tencent.token;

class dr
{
  int[] a;
  int b;
  int c = 0;
  
  dr()
  {
    this.a = new int[1];
    this.b = 0;
  }
  
  dr(int paramInt)
  {
    this.a = new int[1];
    this.b = 1;
    this.a[0] = paramInt;
  }
  
  dr(dq paramdq)
  {
    this.a = new int[paramdq.b.length];
    System.arraycopy(paramdq.b, 0, this.a, 0, paramdq.b.length);
    this.b = this.a.length;
  }
  
  dr(dr paramdr)
  {
    this.b = paramdr.b;
    this.a = new int[this.b];
    while (i < this.b)
    {
      this.a[i] = paramdr.a[(paramdr.c + i)];
      i += 1;
    }
  }
  
  dr(int[] paramArrayOfInt)
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
  
  static dr a(dr paramdr, int paramInt)
  {
    return a(new dr(1), new dr(paramdr), paramInt);
  }
  
  static dr a(dr paramdr1, dr paramdr2, int paramInt)
  {
    dr localdr = new dr();
    int j = -d(paramdr2.a[(paramdr2.c + paramdr2.b - 1)]);
    int i = 0;
    while (i < paramInt >> 5)
    {
      paramdr2.a(paramdr1.a[(paramdr1.c + paramdr1.b - 1)] * j, localdr);
      paramdr1.c(localdr);
      paramdr1.b -= 1;
      i += 1;
    }
    paramInt &= 0x1F;
    if (paramInt != 0)
    {
      paramdr2.a(j * paramdr1.a[(paramdr1.c + paramdr1.b - 1)] & (1 << paramInt) - 1, localdr);
      paramdr1.c(localdr);
      paramdr1.a(paramInt);
    }
    while (paramdr1.a(paramdr2) >= 0) {
      paramdr1.d(paramdr2);
    }
    return paramdr1;
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
  
  private dr f(dr paramdr)
  {
    dr localdr2 = new dr(paramdr);
    Object localObject1 = new dr(this);
    Object localObject3 = new dr(localdr2);
    paramdr = new ds(1);
    Object localObject2 = new ds();
    int i;
    if (((dr)localObject1).g())
    {
      i = ((dr)localObject1).i();
      ((dr)localObject1).a(i);
      ((ds)localObject2).b(i);
    }
    for (;;)
    {
      if (!((dr)localObject1).e())
      {
        if (((dr)localObject1).f()) {
          throw new ArithmeticException("BigInteger not invertible.");
        }
        if (((dr)localObject1).a((dr)localObject3) >= 0) {
          break label255;
        }
      }
      for (;;)
      {
        if (((localObject3.a[(localObject3.c + localObject3.b - 1)] ^ localObject1.a[(localObject1.c + localObject1.b - 1)]) & 0x3) == 0)
        {
          ((dr)localObject3).d((dr)localObject1);
          ((ds)localObject2).b(paramdr);
        }
        for (;;)
        {
          int j = ((dr)localObject3).i();
          ((dr)localObject3).a(j);
          paramdr.b(j);
          i += j;
          localdr1 = paramdr;
          localObject4 = localObject1;
          paramdr = (dr)localObject2;
          localObject2 = localdr1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
          ((dr)localObject3).c((dr)localObject1);
          ((ds)localObject2).a(paramdr);
        }
        while (paramdr.d < 0) {
          paramdr.f(localdr2);
        }
        return a(paramdr, localdr2, i);
        label255:
        dr localdr1 = paramdr;
        paramdr = (dr)localObject2;
        Object localObject4 = localObject1;
        localObject1 = localObject3;
        localObject2 = localdr1;
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
    return (this.b - 1 - i << 5) + dq.f(j);
  }
  
  final int a(dr paramdr)
  {
    int k = 0;
    int j;
    if (this.b < paramdr.b)
    {
      j = -1;
      return j;
    }
    if (this.b > paramdr.b) {
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
      int m = paramdr.a[(paramdr.c + i)] - -2147483648;
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
    if (i >= dq.d(this.a[this.c]))
    {
      g(32 - i);
      this.b -= 1;
      return;
    }
    f(i);
  }
  
  void a(int paramInt, dr paramdr)
  {
    if (paramInt == 1)
    {
      paramdr.b(this);
      return;
    }
    if (paramInt == 0)
    {
      paramdr.a();
      return;
    }
    long l2 = paramInt;
    if (paramdr.a.length < this.b + 1) {}
    long l1;
    for (int[] arrayOfInt = new int[this.b + 1];; arrayOfInt = paramdr.a)
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
      paramdr.c = 1;
      paramdr.b = this.b;
    }
    for (;;)
    {
      paramdr.a = arrayOfInt;
      return;
      paramdr.c = 0;
      this.b += 1;
      arrayOfInt[0] = ((int)l1);
    }
  }
  
  void a(dr paramdr1, dr paramdr2)
  {
    int k = this.b;
    int m = paramdr1.b;
    int i = k + m;
    if (paramdr2.a.length < i) {
      paramdr2.a = new int[i];
    }
    paramdr2.c = 0;
    paramdr2.b = i;
    long l = 0L;
    int j = m - 1;
    i = m + k - 1;
    while (j >= 0)
    {
      l += (paramdr1.a[(paramdr1.c + j)] & 0xFFFFFFFF) * (this.a[(k - 1 + this.c)] & 0xFFFFFFFF);
      paramdr2.a[i] = ((int)l);
      l >>>= 32;
      j -= 1;
      i -= 1;
    }
    paramdr2.a[(k - 1)] = ((int)l);
    i = k - 2;
    while (i >= 0)
    {
      l = 0L;
      k = m - 1;
      j = m + i;
      while (k >= 0)
      {
        l += (paramdr1.a[(paramdr1.c + k)] & 0xFFFFFFFF) * (this.a[(this.c + i)] & 0xFFFFFFFF) + (paramdr2.a[j] & 0xFFFFFFFF);
        paramdr2.a[j] = ((int)l);
        l >>>= 32;
        k -= 1;
        j -= 1;
      }
      paramdr2.a[i] = ((int)l);
      i -= 1;
    }
    paramdr2.c();
  }
  
  void a(dr paramdr1, dr paramdr2, dr paramdr3)
  {
    if (paramdr1.b == 0) {
      throw new ArithmeticException("BigInteger divide by zero");
    }
    if (this.b == 0)
    {
      paramdr3.c = 0;
      paramdr3.b = 0;
      paramdr2.c = 0;
      paramdr2.b = 0;
      return;
    }
    int i = a(paramdr1);
    if (i < 0)
    {
      paramdr2.c = 0;
      paramdr2.b = 0;
      paramdr3.b(this);
      return;
    }
    if (i == 0)
    {
      paramdr1 = paramdr2.a;
      paramdr2.b = 1;
      paramdr1[0] = 1;
      paramdr3.c = 0;
      paramdr3.b = 0;
      paramdr2.c = 0;
      return;
    }
    paramdr2.a();
    if (paramdr1.b == 1)
    {
      paramdr3.b(this);
      paramdr3.b(paramdr1.a[paramdr1.c], paramdr2);
      return;
    }
    int[] arrayOfInt1 = new int[paramdr1.b];
    i = 0;
    while (i < paramdr1.b)
    {
      arrayOfInt1[i] = paramdr1.a[(paramdr1.c + i)];
      i += 1;
    }
    int i1 = paramdr1.b;
    if (paramdr3.a.length < this.b + 1) {
      paramdr3.a = new int[this.b + 1];
    }
    i = 0;
    while (i < this.b)
    {
      paramdr3.a[(i + 1)] = this.a[(this.c + i)];
      i += 1;
    }
    paramdr3.b = this.b;
    paramdr3.c = 1;
    i = paramdr3.b;
    int i2 = i - i1 + 1;
    if (paramdr2.a.length < i2)
    {
      paramdr2.a = new int[i2];
      paramdr2.c = 0;
    }
    paramdr2.b = i2;
    paramdr1 = paramdr2.a;
    int i3 = 32 - dq.d(arrayOfInt1[0]);
    if (i3 > 0)
    {
      dq.b(arrayOfInt1, i1, i3);
      paramdr3.b(i3);
    }
    if (paramdr3.b == i)
    {
      paramdr3.c = 0;
      paramdr3.a[0] = 0;
      paramdr3.b += 1;
    }
    int i4 = arrayOfInt1[0];
    long l1 = 0xFFFFFFFF & i4;
    int i5 = arrayOfInt1[1];
    int[] arrayOfInt2 = new int[2];
    int n = 0;
    if (n < i2)
    {
      int k = 0;
      i = paramdr3.a[(paramdr3.c + n)];
      int i6 = i - -2147483648;
      int m = paramdr3.a[(n + 1 + paramdr3.c)];
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
          l2 = paramdr3.a[(n + 2 + paramdr3.c)] & 0xFFFFFFFF;
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
        paramdr3.a[(paramdr3.c + n)] = 0;
        j = i;
        if (a(paramdr3.a, arrayOfInt1, i, i1, n + paramdr3.c) - -2147483648 > i6)
        {
          a(arrayOfInt1, paramdr3.a, n + 1 + paramdr3.c);
          j = i - 1;
        }
        paramdr1[n] = j;
      }
    }
    if (i3 > 0) {
      paramdr3.a(i3);
    }
    paramdr3.c();
    paramdr2.c();
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
    int m = dq.d(this.a[this.c]);
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
  
  void b(int paramInt, dr paramdr)
  {
    long l2 = paramInt & 0xFFFFFFFF;
    if (this.b == 1)
    {
      l1 = 0xFFFFFFFF & this.a[this.c];
      paramdr.a[0] = ((int)(l1 / l2));
      if (paramdr.a[0] == 0)
      {
        paramInt = 0;
        paramdr.b = paramInt;
        paramdr.c = 0;
        this.a[0] = ((int)(l1 - l2 * paramdr.a[0]));
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
    if (paramdr.a.length < this.b) {
      paramdr.a = new int[this.b];
    }
    paramdr.c = 0;
    paramdr.b = this.b;
    int k = dq.d(paramInt);
    int i = this.a[this.c];
    long l1 = i & 0xFFFFFFFF;
    int j;
    int[] arrayOfInt;
    if (l1 < l2)
    {
      paramdr.a[0] = 0;
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
      paramdr.a[(this.b - j)] = arrayOfInt[0];
      i = arrayOfInt[1];
      l1 = i & 0xFFFFFFFF;
      break label202;
      paramdr.a[0] = ((int)(l1 / l2));
      i = (int)(l1 - paramdr.a[0] * l2);
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
      paramdr.c();
      return;
      this.a[0] = i;
      break;
    }
  }
  
  void b(dr paramdr)
  {
    int j = paramdr.b;
    if (this.a.length < j) {
      this.a = new int[j];
    }
    int i = 0;
    while (i < j)
    {
      this.a[i] = paramdr.a[(paramdr.c + i)];
      i += 1;
    }
    this.b = j;
    this.c = 0;
  }
  
  dr c(int paramInt)
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
        return new dr(paramInt);
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
      dr localdr = new dr(new int[2]);
      localdr.a[0] = ((int)(l1 >>> 32));
      localdr.a[1] = ((int)l1);
      localdr.b = 2;
      localdr.c();
      return localdr;
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
  
  void c(dr paramdr)
  {
    int n = this.b;
    int j = paramdr.b;
    int i;
    if (this.b > paramdr.b)
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
        l2 = (l2 >>> 32) + ((this.a[(this.c + n)] & 0xFFFFFFFF) + (paramdr.a[(paramdr.c + j)] & 0xFFFFFFFF));
        arrayOfInt[k] = ((int)l2);
        k -= 1;
      }
      i = paramdr.b;
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
      l2 = (l2 >>> 32) + (paramdr.a[(paramdr.c + n)] & 0xFFFFFFFF);
      arrayOfInt[k] = ((int)l2);
      k -= 1;
    }
    j = i;
    paramdr = arrayOfInt;
    if (l2 >>> 32 > 0L)
    {
      i += 1;
      if (arrayOfInt.length >= i) {
        break label366;
      }
      paramdr = new int[i];
      j = i - 1;
      while (j > 0)
      {
        paramdr[j] = arrayOfInt[(j - 1)];
        j -= 1;
      }
      paramdr[0] = 1;
      j = i;
    }
    for (;;)
    {
      this.a = paramdr;
      this.b = j;
      this.c = (paramdr.length - j);
      return;
      label366:
      arrayOfInt[k] = 1;
      j = i;
      paramdr = arrayOfInt;
    }
  }
  
  int d(dr paramdr)
  {
    int[] arrayOfInt = this.a;
    int m = a(paramdr);
    if (m == 0)
    {
      b();
      return 0;
    }
    Object localObject;
    dr localdr;
    if (m < 0)
    {
      localObject = this;
      localdr = paramdr;
      paramdr = (dr)localObject;
    }
    for (;;)
    {
      int n = localdr.b;
      localObject = arrayOfInt;
      if (arrayOfInt.length < n) {
        localObject = new int[n];
      }
      long l = 0L;
      int j = localdr.b;
      int k = paramdr.b;
      int i = localObject.length - 1;
      while (k > 0)
      {
        j -= 1;
        k -= 1;
        l = (localdr.a[(localdr.c + j)] & 0xFFFFFFFF) - (paramdr.a[(paramdr.c + k)] & 0xFFFFFFFF) - (int)-(l >> 32);
        localObject[i] = ((int)l);
        i -= 1;
      }
      for (;;)
      {
        if (j > 0)
        {
          j -= 1;
          l = (localdr.a[(localdr.c + j)] & 0xFFFFFFFF) - (int)-(l >> 32);
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
      localdr = this;
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
  
  dr e(int paramInt)
  {
    Object localObject1 = new dr(1);
    ((dr)localObject1).b(paramInt);
    dr localdr1 = new dr((dr)localObject1);
    Object localObject2 = new dr(this);
    dr localdr2 = new dr();
    Object localObject3 = new dr();
    ((dr)localObject1).a((dr)localObject2, localdr2, (dr)localObject3);
    dr localdr3 = new dr(localdr2);
    dr localdr4 = new dr(1);
    dr localdr5 = new dr();
    if (!((dr)localObject3).e())
    {
      ((dr)localObject2).a((dr)localObject3, localdr2, (dr)localObject1);
      if (((dr)localObject1).b == 0) {
        throw new ArithmeticException("BigInteger not invertible.");
      }
      if (localdr2.b == 1) {
        localdr3.a(localdr2.a[localdr2.c], localdr5);
      }
      for (;;)
      {
        localdr4.c(localdr5);
        if (!((dr)localObject1).e()) {
          break;
        }
        return localdr4;
        localdr2.a(localdr3, localdr5);
      }
      ((dr)localObject3).a((dr)localObject1, localdr5, (dr)localObject2);
      if (((dr)localObject2).b == 0) {
        throw new ArithmeticException("BigInteger not invertible.");
      }
      if (localdr5.b == 1) {
        localdr4.a(localdr5.a[localdr5.c], localdr2);
      }
      for (;;)
      {
        localdr3.c(localdr2);
        Object localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        break;
        localdr5.a(localdr4, localdr2);
      }
    }
    localdr1.d(localdr3);
    return localdr1;
  }
  
  dr e(dr paramdr)
  {
    if (paramdr.h()) {
      return f(paramdr);
    }
    if (g()) {
      throw new ArithmeticException("BigInteger not invertible.");
    }
    int i = paramdr.i();
    dr localdr1 = new dr(paramdr);
    localdr1.a(i);
    if (localdr1.e()) {
      return c(i);
    }
    dr localdr2 = f(localdr1);
    dr localdr3 = c(i);
    dr localdr4 = a(localdr1, i);
    dr localdr5 = localdr1.c(i);
    dr localdr6 = new dr();
    dr localdr7 = new dr();
    dr localdr8 = new dr();
    localdr2.b(i);
    localdr2.a(localdr4, localdr8);
    localdr3.a(localdr1, localdr6);
    localdr6.a(localdr5, localdr7);
    localdr8.c(localdr7);
    localdr8.a(paramdr, localdr6, localdr7);
    return localdr7;
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
    return new dq(this, 1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dr
 * JD-Core Version:    0.7.0.1
 */