package com.tencent.token;

class ds
{
  int[] a;
  int b;
  int c;
  
  ds()
  {
    this.c = 0;
    this.a = new int[1];
    this.b = 0;
  }
  
  ds(int paramInt)
  {
    this.c = 0;
    this.a = new int[1];
    this.b = 1;
    this.a[0] = paramInt;
  }
  
  ds(dr paramdr)
  {
    this.c = 0;
    this.a = new int[paramdr.b.length];
    System.arraycopy(paramdr.b, 0, this.a, 0, paramdr.b.length);
    this.b = this.a.length;
  }
  
  ds(ds paramds)
  {
    int i = 0;
    this.c = 0;
    this.b = paramds.b;
    this.a = new int[this.b];
    while (i < this.b)
    {
      this.a[i] = paramds.a[(paramds.c + i)];
      i += 1;
    }
  }
  
  ds(int[] paramArrayOfInt)
  {
    this.c = 0;
    this.a = paramArrayOfInt;
    this.b = paramArrayOfInt.length;
  }
  
  private int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = paramArrayOfInt1.length - 1;
    long l1 = 0L;
    while (i >= 0)
    {
      long l2 = paramArrayOfInt1[i];
      int j = i + paramInt;
      l1 = (l2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[j]) + l1;
      paramArrayOfInt2[j] = ((int)l1);
      l1 >>>= 32;
      i -= 1;
    }
    return (int)l1;
  }
  
  private int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = paramInt1;
    paramInt1 = paramInt3 + paramInt2;
    paramInt2 -= 1;
    long l1 = 0L;
    while (paramInt2 >= 0)
    {
      l1 = (paramArrayOfInt2[paramInt2] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF) + l1;
      long l3 = paramArrayOfInt1[paramInt1] - l1;
      paramArrayOfInt1[paramInt1] = ((int)l3);
      if ((l3 & 0xFFFFFFFF) > (((int)l1 ^ 0xFFFFFFFF) & 0xFFFFFFFF)) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
      l1 = paramInt3 + (l1 >>> 32);
      paramInt2 -= 1;
      paramInt1 -= 1;
    }
    return (int)l1;
  }
  
  static ds a(ds paramds, int paramInt)
  {
    return a(new ds(1), new ds(paramds), paramInt);
  }
  
  static ds a(ds paramds1, ds paramds2, int paramInt)
  {
    ds localds = new ds();
    int j = -d(paramds2.a[(paramds2.c + paramds2.b - 1)]);
    int i = 0;
    while (i < paramInt >> 5)
    {
      paramds2.a(paramds1.a[(paramds1.c + paramds1.b - 1)] * j, localds);
      paramds1.c(localds);
      paramds1.b -= 1;
      i += 1;
    }
    paramInt &= 0x1F;
    if (paramInt != 0)
    {
      paramds2.a(j * paramds1.a[(paramds1.c + paramds1.b - 1)] & (1 << paramInt) - 1, localds);
      paramds1.c(localds);
      paramds1.a(paramInt);
    }
    while (paramds1.a(paramds2) >= 0) {
      paramds1.d(paramds2);
    }
    return paramds1;
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
    long l2 = (paramLong >>> 1) / (l4 >>> 1);
    long l1 = paramLong - l2 * l4;
    long l3;
    for (paramLong = l2;; paramLong -= 1L)
    {
      l2 = paramLong;
      l3 = l1;
      if (l1 >= 0L) {
        break;
      }
      l1 += l4;
    }
    while (l3 >= l4)
    {
      l3 -= l4;
      l2 += 1L;
    }
    paramArrayOfInt[0] = ((int)l2);
    paramArrayOfInt[1] = ((int)l3);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - -9223372036854775808L > paramLong2 - -9223372036854775808L;
  }
  
  static int d(int paramInt)
  {
    int i = (2 - paramInt * paramInt) * paramInt;
    i *= (2 - paramInt * i);
    i *= (2 - paramInt * i);
    return i * (2 - paramInt * i);
  }
  
  private ds f(ds paramds)
  {
    ds localds = new ds(paramds);
    Object localObject3 = new ds(this);
    Object localObject2 = new ds(localds);
    Object localObject1 = new dt(1);
    paramds = new dt();
    int i;
    if (((ds)localObject3).g())
    {
      i = ((ds)localObject3).i();
      ((ds)localObject3).a(i);
      paramds.b(i);
    }
    else
    {
      i = 0;
    }
    while (!((ds)localObject3).e()) {
      if (!((ds)localObject3).f())
      {
        Object localObject7 = localObject2;
        Object localObject6 = localObject1;
        Object localObject5 = paramds;
        Object localObject4 = localObject3;
        if (((ds)localObject3).a((ds)localObject2) < 0)
        {
          localObject4 = localObject2;
          localObject5 = localObject1;
          localObject6 = paramds;
          localObject7 = localObject3;
        }
        if (((localObject4.a[(localObject4.c + localObject4.b - 1)] ^ localObject7.a[(localObject7.c + localObject7.b - 1)]) & 0x3) == 0)
        {
          localObject4.d(localObject7);
          ((dt)localObject6).b((dt)localObject5);
        }
        else
        {
          localObject4.c(localObject7);
          ((dt)localObject6).a((dt)localObject5);
        }
        int j = localObject4.i();
        localObject4.a(j);
        ((dt)localObject5).b(j);
        i += j;
        localObject2 = localObject7;
        localObject1 = localObject6;
        paramds = (ds)localObject5;
        localObject3 = localObject4;
      }
      else
      {
        throw new ArithmeticException("BigInteger not invertible.");
      }
    }
    while (((dt)localObject1).d < 0) {
      ((dt)localObject1).f(localds);
    }
    return a((ds)localObject1, localds, i);
  }
  
  private final void f(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = this.c + this.b - 1;
    int k;
    for (int j = arrayOfInt[i];; j = k)
    {
      k = this.c;
      if (i <= k) {
        break;
      }
      k = arrayOfInt[(i - 1)];
      arrayOfInt[i] = (j >>> paramInt | k << 32 - paramInt);
      i -= 1;
    }
    arrayOfInt[k] >>>= paramInt;
  }
  
  private final void g(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int k = this.c;
    int j = arrayOfInt[k];
    int i1 = this.b;
    int i = k;
    while (i < i1 + k - 1)
    {
      int n = i + 1;
      int m = arrayOfInt[n];
      arrayOfInt[i] = (j << paramInt | m >>> 32 - paramInt);
      i = n;
      j = m;
    }
    i = this.c + this.b - 1;
    arrayOfInt[i] <<= paramInt;
  }
  
  private final int i()
  {
    int i = this.b;
    if (i == 0) {
      return -1;
    }
    i -= 1;
    while ((i > 0) && (this.a[(this.c + i)] == 0)) {
      i -= 1;
    }
    int j = this.a[(this.c + i)];
    if (j == 0) {
      return -1;
    }
    return (this.b - 1 - i << 5) + dr.f(j);
  }
  
  final int a(ds paramds)
  {
    int i = this.b;
    int j = paramds.b;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    i = 0;
    while (i < this.b)
    {
      j = this.a[(this.c + i)] - -2147483648;
      int k = paramds.a[(paramds.c + i)] - -2147483648;
      if (j < k) {
        return -1;
      }
      if (j > k) {
        return 1;
      }
      i += 1;
    }
    return 0;
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
    int i = this.b;
    if (i == 0) {
      return;
    }
    int j = paramInt & 0x1F;
    this.b = (i - (paramInt >>> 5));
    if (j == 0) {
      return;
    }
    if (j >= dr.d(this.a[this.c]))
    {
      g(32 - j);
      this.b -= 1;
      return;
    }
    f(j);
  }
  
  void a(int paramInt, ds paramds)
  {
    if (paramInt == 1)
    {
      paramds.b(this);
      return;
    }
    if (paramInt == 0)
    {
      paramds.a();
      return;
    }
    long l2 = paramInt;
    int[] arrayOfInt = paramds.a;
    paramInt = arrayOfInt.length;
    int i = this.b;
    if (paramInt < i + 1) {
      arrayOfInt = new int[i + 1];
    }
    paramInt = this.b - 1;
    long l1 = 0L;
    while (paramInt >= 0)
    {
      l1 = (this.a[(this.c + paramInt)] & 0xFFFFFFFF) * (l2 & 0xFFFFFFFF) + l1;
      arrayOfInt[(paramInt + 1)] = ((int)l1);
      l1 >>>= 32;
      paramInt -= 1;
    }
    if (l1 == 0L)
    {
      paramds.c = 1;
      paramds.b = this.b;
    }
    else
    {
      paramds.c = 0;
      this.b += 1;
      arrayOfInt[0] = ((int)l1);
    }
    paramds.a = arrayOfInt;
  }
  
  void a(ds paramds1, ds paramds2)
  {
    int n = this.b;
    int m = paramds1.b;
    int i = n + m;
    if (paramds2.a.length < i) {
      paramds2.a = new int[i];
    }
    paramds2.c = 0;
    paramds2.b = i;
    int j = m - 1;
    i -= 1;
    int k = j;
    long l1 = 0L;
    Object localObject;
    for (;;)
    {
      ds localds = paramds1;
      localObject = this;
      if (k < 0) {
        break;
      }
      l1 = (localds.a[(localds.c + k)] & 0xFFFFFFFF) * (localObject.a[(n - 1 + localObject.c)] & 0xFFFFFFFF) + l1;
      paramds2.a[i] = ((int)l1);
      l1 >>>= 32;
      k -= 1;
      i -= 1;
    }
    paramds2.a[(n - 1)] = ((int)l1);
    k = n - 2;
    i = m;
    while (k >= 0)
    {
      m = i + k;
      n = j;
      l1 = 0L;
      while (n >= 0)
      {
        long l2 = paramds1.a[(paramds1.c + n)];
        long l3 = this.a[(this.c + k)];
        localObject = paramds2.a;
        l1 = (l2 & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF) + (localObject[m] & 0xFFFFFFFF) + l1;
        localObject[m] = ((int)l1);
        l1 >>>= 32;
        n -= 1;
        m -= 1;
      }
      paramds2.a[k] = ((int)l1);
      k -= 1;
    }
    paramds2.c();
  }
  
  void a(ds paramds1, ds paramds2, ds paramds3)
  {
    if (paramds1.b != 0)
    {
      if (this.b == 0)
      {
        paramds3.c = 0;
        paramds3.b = 0;
        paramds2.c = 0;
        paramds2.b = 0;
        return;
      }
      int i = a(paramds1);
      if (i < 0)
      {
        paramds2.c = 0;
        paramds2.b = 0;
        paramds3.b(this);
        return;
      }
      if (i == 0)
      {
        paramds1 = paramds2.a;
        paramds2.b = 1;
        paramds1[0] = 1;
        paramds3.c = 0;
        paramds3.b = 0;
        paramds2.c = 0;
        return;
      }
      paramds2.a();
      i = paramds1.b;
      if (i == 1)
      {
        paramds3.b(this);
        paramds3.b(paramds1.a[paramds1.c], paramds2);
        return;
      }
      int[] arrayOfInt1 = new int[i];
      i = 0;
      int i1;
      for (;;)
      {
        i1 = paramds1.b;
        if (i >= i1) {
          break;
        }
        arrayOfInt1[i] = paramds1.a[(paramds1.c + i)];
        i += 1;
      }
      i = paramds3.a.length;
      int j = this.b;
      if (i < j + 1) {
        paramds3.a = new int[j + 1];
      }
      for (i = 0;; i = j)
      {
        j = this.b;
        if (i >= j) {
          break;
        }
        paramds1 = paramds3.a;
        j = i + 1;
        paramds1[j] = this.a[(i + this.c)];
      }
      paramds3.b = j;
      paramds3.c = 1;
      i = paramds3.b;
      int i2 = i - i1 + 1;
      if (paramds2.a.length < i2)
      {
        paramds2.a = new int[i2];
        paramds2.c = 0;
      }
      paramds2.b = i2;
      int[] arrayOfInt2 = paramds2.a;
      int i4 = 32 - dr.d(arrayOfInt1[0]);
      if (i4 > 0)
      {
        dr.b(arrayOfInt1, i1, i4);
        paramds3.b(i4);
      }
      j = paramds3.b;
      if (j == i)
      {
        paramds3.c = 0;
        paramds3.a[0] = 0;
        paramds3.b = (j + 1);
      }
      int i3 = arrayOfInt1[0];
      long l1 = i3 & 0xFFFFFFFF;
      i = arrayOfInt1[1];
      paramds1 = new int[2];
      int i5;
      for (int k = 0; k < i2; k = i5)
      {
        int[] arrayOfInt3 = paramds3.a;
        int m = paramds3.c;
        j = arrayOfInt3[(k + m)];
        int i6 = j - -2147483648;
        i5 = k + 1;
        m = arrayOfInt3[(i5 + m)];
        int n;
        long l2;
        if (j == i3)
        {
          n = j + m;
          if (n - -2147483648 < i6) {
            m = 1;
          } else {
            m = 0;
          }
          j = -1;
        }
        else
        {
          l2 = j << 32 | m & 0xFFFFFFFF;
          if (l2 >= 0L)
          {
            j = (int)(l2 / l1);
            n = (int)(l2 - j * l1);
            m = 0;
          }
          else
          {
            a(paramds1, l2, i3);
            j = paramds1[0];
            n = paramds1[1];
            m = 0;
          }
        }
        if (j != 0)
        {
          if (m == 0)
          {
            l2 = paramds3.a[(k + 2 + paramds3.c)] & 0xFFFFFFFF;
            long l4 = n & 0xFFFFFFFF;
            long l3 = i & 0xFFFFFFFF;
            if (a((j & 0xFFFFFFFF) * l3, l4 << 32 | l2))
            {
              m = j - 1;
              l4 = (int)(l4 + l1) & 0xFFFFFFFF;
              if (l4 >= l1)
              {
                j = m;
                if (a(l3 * (m & 0xFFFFFFFF), l4 << 32 | l2)) {
                  j = m - 1;
                }
              }
              else
              {
                j = m;
              }
            }
            else {}
          }
          arrayOfInt3 = paramds3.a;
          m = paramds3.c;
          arrayOfInt3[(k + m)] = 0;
          if (a(arrayOfInt3, arrayOfInt1, j, i1, k + m) - -2147483648 > i6)
          {
            a(arrayOfInt1, paramds3.a, i5 + paramds3.c);
            j -= 1;
          }
          arrayOfInt2[k] = j;
        }
      }
      if (i4 > 0) {
        paramds3.a(i4);
      }
      paramds3.c();
      paramds2.c();
      return;
    }
    throw new ArithmeticException("BigInteger divide by zero");
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
    if (this.b == 0) {
      return;
    }
    int m = paramInt & 0x1F;
    int n = 32 - dr.d(this.a[this.c]);
    if (paramInt <= n)
    {
      g(m);
      return;
    }
    int i = this.b + (paramInt >>> 5) + 1;
    paramInt = i;
    if (m <= n) {
      paramInt = i - 1;
    }
    int[] arrayOfInt = this.a;
    int j = arrayOfInt.length;
    i = 0;
    if (j < paramInt)
    {
      arrayOfInt = new int[paramInt];
      while (i < this.b)
      {
        arrayOfInt[i] = this.a[(this.c + i)];
        i += 1;
      }
      a(arrayOfInt, paramInt);
    }
    else
    {
      if (arrayOfInt.length - this.c >= paramInt)
      {
        i = 0;
        for (;;)
        {
          j = this.b;
          if (i >= paramInt - j) {
            break;
          }
          this.a[(this.c + j + i)] = 0;
          i += 1;
        }
      }
      i = 0;
      for (;;)
      {
        int k = this.b;
        j = k;
        if (i >= k) {
          break;
        }
        arrayOfInt = this.a;
        arrayOfInt[i] = arrayOfInt[(this.c + i)];
        i += 1;
      }
      while (j < paramInt)
      {
        this.a[j] = 0;
        j += 1;
      }
      this.c = 0;
    }
    this.b = paramInt;
    if (m == 0) {
      return;
    }
    if (m <= n)
    {
      g(m);
      return;
    }
    f(32 - m);
  }
  
  void b(int paramInt, ds paramds)
  {
    long l2 = paramInt & 0xFFFFFFFF;
    int j = this.b;
    int i = 1;
    if (j == 1)
    {
      l1 = 0xFFFFFFFF & this.a[this.c];
      arrayOfInt = paramds.a;
      arrayOfInt[0] = ((int)(l1 / l2));
      if (arrayOfInt[0] == 0) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      paramds.b = paramInt;
      paramds.c = 0;
      arrayOfInt = this.a;
      arrayOfInt[0] = ((int)(l1 - paramds.a[0] * l2));
      this.c = 0;
      paramInt = i;
      if (arrayOfInt[0] == 0) {
        paramInt = 0;
      }
      this.b = paramInt;
      return;
    }
    if (paramds.a.length < j) {
      paramds.a = new int[j];
    }
    paramds.c = 0;
    paramds.b = this.b;
    int k = dr.d(paramInt);
    i = this.a[this.c];
    long l1 = i & 0xFFFFFFFF;
    if (l1 < l2)
    {
      paramds.a[0] = 0;
    }
    else
    {
      arrayOfInt = paramds.a;
      arrayOfInt[0] = ((int)(l1 / l2));
      i = (int)(l1 - arrayOfInt[0] * l2);
      l1 = i & 0xFFFFFFFF;
    }
    j = this.b;
    int[] arrayOfInt = new int[2];
    for (;;)
    {
      j -= 1;
      if (j <= 0) {
        break;
      }
      l1 = this.a[(this.c + this.b - j)] & 0xFFFFFFFF | l1 << 32;
      if (l1 >= 0L)
      {
        arrayOfInt[0] = ((int)(l1 / l2));
        arrayOfInt[1] = ((int)(l1 - arrayOfInt[0] * l2));
      }
      else
      {
        a(arrayOfInt, l1, paramInt);
      }
      paramds.a[(this.b - j)] = arrayOfInt[0];
      i = arrayOfInt[1];
      l1 = i & 0xFFFFFFFF;
    }
    j = 0;
    if (32 - k > 0) {
      this.a[0] = (i % paramInt);
    } else {
      this.a[0] = i;
    }
    if (this.a[0] == 0) {
      paramInt = j;
    } else {
      paramInt = 1;
    }
    this.b = paramInt;
    paramds.c();
  }
  
  void b(ds paramds)
  {
    int j = paramds.b;
    if (this.a.length < j) {
      this.a = new int[j];
    }
    int i = 0;
    while (i < j)
    {
      this.a[i] = paramds.a[(paramds.c + i)];
      i += 1;
    }
    this.b = j;
    this.c = 0;
  }
  
  ds c(int paramInt)
  {
    if (!g())
    {
      if (paramInt > 64) {
        return e(paramInt);
      }
      int i = d(this.a[(this.c + this.b - 1)]);
      if (paramInt < 33)
      {
        if (paramInt == 32) {
          paramInt = i;
        } else {
          paramInt = i & (1 << paramInt) - 1;
        }
        return new ds(paramInt);
      }
      Object localObject = this.a;
      int j = this.c;
      int k = this.b;
      long l2 = localObject[(j + k - 1)] & 0xFFFFFFFF;
      long l1 = l2;
      if (k > 1) {
        l1 = l2 | localObject[(j + k - 2)] << 32;
      }
      l2 = i & 0xFFFFFFFF;
      l1 = l2 * (2L - l1 * l2);
      if (paramInt != 64) {
        l1 &= (1L << paramInt) - 1L;
      }
      localObject = new ds(new int[2]);
      int[] arrayOfInt = ((ds)localObject).a;
      arrayOfInt[0] = ((int)(l1 >>> 32));
      arrayOfInt[1] = ((int)l1);
      ((ds)localObject).b = 2;
      ((ds)localObject).c();
      return localObject;
    }
    throw new ArithmeticException("Non-invertible. (GCD != 1)");
  }
  
  final void c()
  {
    int n = this.b;
    int j = 0;
    if (n == 0)
    {
      this.c = 0;
      return;
    }
    int k = this.c;
    if (this.a[k] != 0) {
      return;
    }
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
    i = this.c;
    k = m - i;
    this.b -= k;
    if (this.b == 0) {
      i = j;
    } else {
      i += k;
    }
    this.c = i;
  }
  
  void c(ds paramds)
  {
    int n = this.b;
    int j = paramds.b;
    int i;
    if (n > j) {
      i = n;
    } else {
      i = j;
    }
    int[] arrayOfInt2 = this.a;
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2.length < i) {
      arrayOfInt1 = new int[i];
    }
    int k = arrayOfInt1.length - 1;
    long l2 = 0L;
    int i1;
    int m;
    long l1;
    for (;;)
    {
      i1 = n;
      m = k;
      l1 = l2;
      if (n <= 0) {
        break;
      }
      i1 = n;
      m = k;
      l1 = l2;
      if (j <= 0) {
        break;
      }
      n -= 1;
      j -= 1;
      l2 = (this.a[(this.c + n)] & 0xFFFFFFFF) + (paramds.a[(paramds.c + j)] & 0xFFFFFFFF) + (l2 >>> 32);
      arrayOfInt1[k] = ((int)l2);
      k -= 1;
    }
    for (;;)
    {
      n = j;
      k = m;
      l2 = l1;
      if (i1 <= 0) {
        break;
      }
      i1 -= 1;
      l1 = (this.a[(this.c + i1)] & 0xFFFFFFFF) + (l1 >>> 32);
      arrayOfInt1[m] = ((int)l1);
      m -= 1;
    }
    while (n > 0)
    {
      n -= 1;
      l2 = (paramds.a[(paramds.c + n)] & 0xFFFFFFFF) + (l2 >>> 32);
      arrayOfInt1[k] = ((int)l2);
      k -= 1;
    }
    j = i;
    paramds = arrayOfInt1;
    if (l2 >>> 32 > 0L)
    {
      j = i + 1;
      if (arrayOfInt1.length < j)
      {
        paramds = new int[j];
        i = j - 1;
        while (i > 0)
        {
          paramds[i] = arrayOfInt1[(i - 1)];
          i -= 1;
        }
        paramds[0] = 1;
      }
      else
      {
        arrayOfInt1[k] = 1;
        paramds = arrayOfInt1;
      }
    }
    this.a = paramds;
    this.b = j;
    this.c = (paramds.length - j);
  }
  
  int d(ds paramds)
  {
    int[] arrayOfInt2 = this.a;
    int i1 = a(paramds);
    if (i1 == 0)
    {
      b();
      return 0;
    }
    ds localds;
    if (i1 < 0)
    {
      localds = this;
    }
    else
    {
      localds = paramds;
      paramds = this;
    }
    int i2 = paramds.b;
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2.length < i2) {
      arrayOfInt1 = new int[i2];
    }
    long l1 = 0L;
    int j = paramds.b;
    int k = localds.b;
    int i = arrayOfInt1.length - 1;
    long l2;
    int m;
    int n;
    for (;;)
    {
      l2 = l1;
      m = j;
      n = i;
      if (k <= 0) {
        break;
      }
      j -= 1;
      k -= 1;
      l1 = (paramds.a[(paramds.c + j)] & 0xFFFFFFFF) - (localds.a[(localds.c + k)] & 0xFFFFFFFF) - (int)-(l1 >> 32);
      arrayOfInt1[i] = ((int)l1);
      i -= 1;
    }
    while (m > 0)
    {
      m -= 1;
      l2 = (paramds.a[(paramds.c + m)] & 0xFFFFFFFF) - (int)-(l2 >> 32);
      arrayOfInt1[n] = ((int)l2);
      n -= 1;
    }
    this.a = arrayOfInt1;
    this.b = i2;
    this.c = (this.a.length - i2);
    c();
    return i1;
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
  
  ds e(int paramInt)
  {
    Object localObject3 = new ds(1);
    ((ds)localObject3).b(paramInt);
    ds localds1 = new ds((ds)localObject3);
    Object localObject2 = new ds(this);
    ds localds2 = new ds();
    Object localObject1 = new ds();
    ((ds)localObject3).a((ds)localObject2, localds2, (ds)localObject1);
    ds localds3 = new ds(localds2);
    ds localds4 = new ds(1);
    ds localds5 = new ds();
    for (;;)
    {
      Object localObject4 = localObject3;
      if (((ds)localObject1).e()) {
        break label270;
      }
      ((ds)localObject2).a((ds)localObject1, localds2, localObject4);
      if (localObject4.b == 0) {
        break label260;
      }
      if (localds2.b == 1) {
        localds3.a(localds2.a[localds2.c], localds5);
      } else {
        localds2.a(localds3, localds5);
      }
      localds4.c(localds5);
      if (localObject4.e()) {
        return localds4;
      }
      ((ds)localObject1).a(localObject4, localds5, (ds)localObject2);
      if (((ds)localObject2).b == 0) {
        break;
      }
      if (localds5.b == 1) {
        localds4.a(localds5.a[localds5.c], localds2);
      } else {
        localds5.a(localds4, localds2);
      }
      localds3.c(localds2);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    throw new ArithmeticException("BigInteger not invertible.");
    label260:
    throw new ArithmeticException("BigInteger not invertible.");
    label270:
    localds1.d(localds3);
    return localds1;
  }
  
  ds e(ds paramds)
  {
    if (paramds.h()) {
      return f(paramds);
    }
    if (!g())
    {
      int i = paramds.i();
      ds localds1 = new ds(paramds);
      localds1.a(i);
      if (localds1.e()) {
        return c(i);
      }
      ds localds2 = f(localds1);
      ds localds3 = c(i);
      ds localds4 = a(localds1, i);
      ds localds5 = localds1.c(i);
      ds localds6 = new ds();
      ds localds7 = new ds();
      ds localds8 = new ds();
      localds2.b(i);
      localds2.a(localds4, localds8);
      localds3.a(localds1, localds6);
      localds6.a(localds5, localds7);
      localds8.c(localds7);
      localds8.a(paramds, localds6, localds7);
      return localds7;
    }
    throw new ArithmeticException("BigInteger not invertible.");
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
    int i = this.b;
    boolean bool = true;
    if (i != 0)
    {
      if ((this.a[(this.c + i - 1)] & 0x1) == 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  boolean h()
  {
    return (this.a[(this.c + this.b - 1)] & 0x1) == 1;
  }
  
  public String toString()
  {
    return new dr(this, 1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ds
 * JD-Core Version:    0.7.0.1
 */