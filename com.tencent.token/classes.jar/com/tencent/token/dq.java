package com.tencent.token;

class dq
{
  int[] a;
  int b;
  int c = 0;
  
  dq()
  {
    this.a = new int[1];
    this.b = 0;
  }
  
  dq(int paramInt)
  {
    this.a = new int[1];
    this.b = 1;
    this.a[0] = paramInt;
  }
  
  dq(dp paramdp)
  {
    this.a = new int[paramdp.b.length];
    System.arraycopy(paramdp.b, 0, this.a, 0, paramdp.b.length);
    this.b = this.a.length;
  }
  
  dq(dq paramdq)
  {
    this.b = paramdq.b;
    this.a = new int[this.b];
    while (i < this.b)
    {
      this.a[i] = paramdq.a[(paramdq.c + i)];
      i += 1;
    }
  }
  
  dq(int[] paramArrayOfInt)
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
  
  static dq a(dq paramdq, int paramInt)
  {
    return a(new dq(1), new dq(paramdq), paramInt);
  }
  
  static dq a(dq paramdq1, dq paramdq2, int paramInt)
  {
    dq localdq = new dq();
    int j = -d(paramdq2.a[(paramdq2.c + paramdq2.b - 1)]);
    int i = 0;
    while (i < paramInt >> 5)
    {
      paramdq2.a(paramdq1.a[(paramdq1.c + paramdq1.b - 1)] * j, localdq);
      paramdq1.c(localdq);
      paramdq1.b -= 1;
      i += 1;
    }
    paramInt &= 0x1F;
    if (paramInt != 0)
    {
      paramdq2.a(j * paramdq1.a[(paramdq1.c + paramdq1.b - 1)] & (1 << paramInt) - 1, localdq);
      paramdq1.c(localdq);
      paramdq1.a(paramInt);
    }
    while (paramdq1.a(paramdq2) >= 0) {
      paramdq1.d(paramdq2);
    }
    return paramdq1;
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
  
  private dq f(dq paramdq)
  {
    dq localdq2 = new dq(paramdq);
    Object localObject1 = new dq(this);
    Object localObject3 = new dq(localdq2);
    paramdq = new dr(1);
    Object localObject2 = new dr();
    int i;
    if (((dq)localObject1).g())
    {
      i = ((dq)localObject1).i();
      ((dq)localObject1).a(i);
      ((dr)localObject2).b(i);
    }
    for (;;)
    {
      if (!((dq)localObject1).e())
      {
        if (((dq)localObject1).f()) {
          throw new ArithmeticException("BigInteger not invertible.");
        }
        if (((dq)localObject1).a((dq)localObject3) >= 0) {
          break label255;
        }
      }
      for (;;)
      {
        if (((localObject3.a[(localObject3.c + localObject3.b - 1)] ^ localObject1.a[(localObject1.c + localObject1.b - 1)]) & 0x3) == 0)
        {
          ((dq)localObject3).d((dq)localObject1);
          ((dr)localObject2).b(paramdq);
        }
        for (;;)
        {
          int j = ((dq)localObject3).i();
          ((dq)localObject3).a(j);
          paramdq.b(j);
          i += j;
          localdq1 = paramdq;
          localObject4 = localObject1;
          paramdq = (dq)localObject2;
          localObject2 = localdq1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
          ((dq)localObject3).c((dq)localObject1);
          ((dr)localObject2).a(paramdq);
        }
        while (paramdq.d < 0) {
          paramdq.f(localdq2);
        }
        return a(paramdq, localdq2, i);
        label255:
        dq localdq1 = paramdq;
        paramdq = (dq)localObject2;
        Object localObject4 = localObject1;
        localObject1 = localObject3;
        localObject2 = localdq1;
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
    return (this.b - 1 - i << 5) + dp.f(j);
  }
  
  final int a(dq paramdq)
  {
    int k = 0;
    int j;
    if (this.b < paramdq.b)
    {
      j = -1;
      return j;
    }
    if (this.b > paramdq.b) {
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
      int m = paramdq.a[(paramdq.c + i)] - -2147483648;
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
    if (i >= dp.d(this.a[this.c]))
    {
      g(32 - i);
      this.b -= 1;
      return;
    }
    f(i);
  }
  
  void a(int paramInt, dq paramdq)
  {
    if (paramInt == 1)
    {
      paramdq.b(this);
      return;
    }
    if (paramInt == 0)
    {
      paramdq.a();
      return;
    }
    long l2 = paramInt;
    if (paramdq.a.length < this.b + 1) {}
    long l1;
    for (int[] arrayOfInt = new int[this.b + 1];; arrayOfInt = paramdq.a)
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
      paramdq.c = 1;
      paramdq.b = this.b;
    }
    for (;;)
    {
      paramdq.a = arrayOfInt;
      return;
      paramdq.c = 0;
      this.b += 1;
      arrayOfInt[0] = ((int)l1);
    }
  }
  
  void a(dq paramdq1, dq paramdq2)
  {
    int k = this.b;
    int m = paramdq1.b;
    int i = k + m;
    if (paramdq2.a.length < i) {
      paramdq2.a = new int[i];
    }
    paramdq2.c = 0;
    paramdq2.b = i;
    long l = 0L;
    int j = m - 1;
    i = m + k - 1;
    while (j >= 0)
    {
      l += (paramdq1.a[(paramdq1.c + j)] & 0xFFFFFFFF) * (this.a[(k - 1 + this.c)] & 0xFFFFFFFF);
      paramdq2.a[i] = ((int)l);
      l >>>= 32;
      j -= 1;
      i -= 1;
    }
    paramdq2.a[(k - 1)] = ((int)l);
    i = k - 2;
    while (i >= 0)
    {
      l = 0L;
      k = m - 1;
      j = m + i;
      while (k >= 0)
      {
        l += (paramdq1.a[(paramdq1.c + k)] & 0xFFFFFFFF) * (this.a[(this.c + i)] & 0xFFFFFFFF) + (paramdq2.a[j] & 0xFFFFFFFF);
        paramdq2.a[j] = ((int)l);
        l >>>= 32;
        k -= 1;
        j -= 1;
      }
      paramdq2.a[i] = ((int)l);
      i -= 1;
    }
    paramdq2.c();
  }
  
  void a(dq paramdq1, dq paramdq2, dq paramdq3)
  {
    if (paramdq1.b == 0) {
      throw new ArithmeticException("BigInteger divide by zero");
    }
    if (this.b == 0)
    {
      paramdq3.c = 0;
      paramdq3.b = 0;
      paramdq2.c = 0;
      paramdq2.b = 0;
      return;
    }
    int i = a(paramdq1);
    if (i < 0)
    {
      paramdq2.c = 0;
      paramdq2.b = 0;
      paramdq3.b(this);
      return;
    }
    if (i == 0)
    {
      paramdq1 = paramdq2.a;
      paramdq2.b = 1;
      paramdq1[0] = 1;
      paramdq3.c = 0;
      paramdq3.b = 0;
      paramdq2.c = 0;
      return;
    }
    paramdq2.a();
    if (paramdq1.b == 1)
    {
      paramdq3.b(this);
      paramdq3.b(paramdq1.a[paramdq1.c], paramdq2);
      return;
    }
    int[] arrayOfInt1 = new int[paramdq1.b];
    i = 0;
    while (i < paramdq1.b)
    {
      arrayOfInt1[i] = paramdq1.a[(paramdq1.c + i)];
      i += 1;
    }
    int i1 = paramdq1.b;
    if (paramdq3.a.length < this.b + 1) {
      paramdq3.a = new int[this.b + 1];
    }
    i = 0;
    while (i < this.b)
    {
      paramdq3.a[(i + 1)] = this.a[(this.c + i)];
      i += 1;
    }
    paramdq3.b = this.b;
    paramdq3.c = 1;
    i = paramdq3.b;
    int i2 = i - i1 + 1;
    if (paramdq2.a.length < i2)
    {
      paramdq2.a = new int[i2];
      paramdq2.c = 0;
    }
    paramdq2.b = i2;
    paramdq1 = paramdq2.a;
    int i3 = 32 - dp.d(arrayOfInt1[0]);
    if (i3 > 0)
    {
      dp.b(arrayOfInt1, i1, i3);
      paramdq3.b(i3);
    }
    if (paramdq3.b == i)
    {
      paramdq3.c = 0;
      paramdq3.a[0] = 0;
      paramdq3.b += 1;
    }
    int i4 = arrayOfInt1[0];
    long l1 = 0xFFFFFFFF & i4;
    int i5 = arrayOfInt1[1];
    int[] arrayOfInt2 = new int[2];
    int n = 0;
    if (n < i2)
    {
      int k = 0;
      i = paramdq3.a[(paramdq3.c + n)];
      int i6 = i - -2147483648;
      int m = paramdq3.a[(n + 1 + paramdq3.c)];
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
          l2 = paramdq3.a[(n + 2 + paramdq3.c)] & 0xFFFFFFFF;
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
        paramdq3.a[(paramdq3.c + n)] = 0;
        j = i;
        if (a(paramdq3.a, arrayOfInt1, i, i1, n + paramdq3.c) - -2147483648 > i6)
        {
          a(arrayOfInt1, paramdq3.a, n + 1 + paramdq3.c);
          j = i - 1;
        }
        paramdq1[n] = j;
      }
    }
    if (i3 > 0) {
      paramdq3.a(i3);
    }
    paramdq3.c();
    paramdq2.c();
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
    int m = dp.d(this.a[this.c]);
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
  
  void b(int paramInt, dq paramdq)
  {
    long l2 = paramInt & 0xFFFFFFFF;
    if (this.b == 1)
    {
      l1 = 0xFFFFFFFF & this.a[this.c];
      paramdq.a[0] = ((int)(l1 / l2));
      if (paramdq.a[0] == 0)
      {
        paramInt = 0;
        paramdq.b = paramInt;
        paramdq.c = 0;
        this.a[0] = ((int)(l1 - l2 * paramdq.a[0]));
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
    if (paramdq.a.length < this.b) {
      paramdq.a = new int[this.b];
    }
    paramdq.c = 0;
    paramdq.b = this.b;
    int k = dp.d(paramInt);
    int i = this.a[this.c];
    long l1 = i & 0xFFFFFFFF;
    int j;
    int[] arrayOfInt;
    if (l1 < l2)
    {
      paramdq.a[0] = 0;
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
      paramdq.a[(this.b - j)] = arrayOfInt[0];
      i = arrayOfInt[1];
      l1 = i & 0xFFFFFFFF;
      break label202;
      paramdq.a[0] = ((int)(l1 / l2));
      i = (int)(l1 - paramdq.a[0] * l2);
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
      paramdq.c();
      return;
      this.a[0] = i;
      break;
    }
  }
  
  void b(dq paramdq)
  {
    int j = paramdq.b;
    if (this.a.length < j) {
      this.a = new int[j];
    }
    int i = 0;
    while (i < j)
    {
      this.a[i] = paramdq.a[(paramdq.c + i)];
      i += 1;
    }
    this.b = j;
    this.c = 0;
  }
  
  dq c(int paramInt)
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
        return new dq(paramInt);
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
      dq localdq = new dq(new int[2]);
      localdq.a[0] = ((int)(l1 >>> 32));
      localdq.a[1] = ((int)l1);
      localdq.b = 2;
      localdq.c();
      return localdq;
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
  
  void c(dq paramdq)
  {
    int n = this.b;
    int j = paramdq.b;
    int i;
    if (this.b > paramdq.b)
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
        l2 = (l2 >>> 32) + ((this.a[(this.c + n)] & 0xFFFFFFFF) + (paramdq.a[(paramdq.c + j)] & 0xFFFFFFFF));
        arrayOfInt[k] = ((int)l2);
        k -= 1;
      }
      i = paramdq.b;
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
      l2 = (l2 >>> 32) + (paramdq.a[(paramdq.c + n)] & 0xFFFFFFFF);
      arrayOfInt[k] = ((int)l2);
      k -= 1;
    }
    j = i;
    paramdq = arrayOfInt;
    if (l2 >>> 32 > 0L)
    {
      i += 1;
      if (arrayOfInt.length >= i) {
        break label366;
      }
      paramdq = new int[i];
      j = i - 1;
      while (j > 0)
      {
        paramdq[j] = arrayOfInt[(j - 1)];
        j -= 1;
      }
      paramdq[0] = 1;
      j = i;
    }
    for (;;)
    {
      this.a = paramdq;
      this.b = j;
      this.c = (paramdq.length - j);
      return;
      label366:
      arrayOfInt[k] = 1;
      j = i;
      paramdq = arrayOfInt;
    }
  }
  
  int d(dq paramdq)
  {
    int[] arrayOfInt = this.a;
    int m = a(paramdq);
    if (m == 0)
    {
      b();
      return 0;
    }
    Object localObject;
    dq localdq;
    if (m < 0)
    {
      localObject = this;
      localdq = paramdq;
      paramdq = (dq)localObject;
    }
    for (;;)
    {
      int n = localdq.b;
      localObject = arrayOfInt;
      if (arrayOfInt.length < n) {
        localObject = new int[n];
      }
      long l = 0L;
      int j = localdq.b;
      int k = paramdq.b;
      int i = localObject.length - 1;
      while (k > 0)
      {
        j -= 1;
        k -= 1;
        l = (localdq.a[(localdq.c + j)] & 0xFFFFFFFF) - (paramdq.a[(paramdq.c + k)] & 0xFFFFFFFF) - (int)-(l >> 32);
        localObject[i] = ((int)l);
        i -= 1;
      }
      for (;;)
      {
        if (j > 0)
        {
          j -= 1;
          l = (localdq.a[(localdq.c + j)] & 0xFFFFFFFF) - (int)-(l >> 32);
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
      localdq = this;
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
  
  dq e(int paramInt)
  {
    Object localObject1 = new dq(1);
    ((dq)localObject1).b(paramInt);
    dq localdq1 = new dq((dq)localObject1);
    Object localObject2 = new dq(this);
    dq localdq2 = new dq();
    Object localObject3 = new dq();
    ((dq)localObject1).a((dq)localObject2, localdq2, (dq)localObject3);
    dq localdq3 = new dq(localdq2);
    dq localdq4 = new dq(1);
    dq localdq5 = new dq();
    if (!((dq)localObject3).e())
    {
      ((dq)localObject2).a((dq)localObject3, localdq2, (dq)localObject1);
      if (((dq)localObject1).b == 0) {
        throw new ArithmeticException("BigInteger not invertible.");
      }
      if (localdq2.b == 1) {
        localdq3.a(localdq2.a[localdq2.c], localdq5);
      }
      for (;;)
      {
        localdq4.c(localdq5);
        if (!((dq)localObject1).e()) {
          break;
        }
        return localdq4;
        localdq2.a(localdq3, localdq5);
      }
      ((dq)localObject3).a((dq)localObject1, localdq5, (dq)localObject2);
      if (((dq)localObject2).b == 0) {
        throw new ArithmeticException("BigInteger not invertible.");
      }
      if (localdq5.b == 1) {
        localdq4.a(localdq5.a[localdq5.c], localdq2);
      }
      for (;;)
      {
        localdq3.c(localdq2);
        Object localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        break;
        localdq5.a(localdq4, localdq2);
      }
    }
    localdq1.d(localdq3);
    return localdq1;
  }
  
  dq e(dq paramdq)
  {
    if (paramdq.h()) {
      return f(paramdq);
    }
    if (g()) {
      throw new ArithmeticException("BigInteger not invertible.");
    }
    int i = paramdq.i();
    dq localdq1 = new dq(paramdq);
    localdq1.a(i);
    if (localdq1.e()) {
      return c(i);
    }
    dq localdq2 = f(localdq1);
    dq localdq3 = c(i);
    dq localdq4 = a(localdq1, i);
    dq localdq5 = localdq1.c(i);
    dq localdq6 = new dq();
    dq localdq7 = new dq();
    dq localdq8 = new dq();
    localdq2.b(i);
    localdq2.a(localdq4, localdq8);
    localdq3.a(localdq1, localdq6);
    localdq6.a(localdq5, localdq7);
    localdq8.c(localdq7);
    localdq8.a(paramdq, localdq6, localdq7);
    return localdq7;
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
    return new dp(this, 1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dq
 * JD-Core Version:    0.7.0.1
 */