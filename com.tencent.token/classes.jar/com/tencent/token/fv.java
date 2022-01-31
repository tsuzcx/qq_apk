package com.tencent.token;

class fv
{
  int[] a;
  int b;
  int c = 0;
  
  fv()
  {
    this.a = new int[1];
    this.b = 0;
  }
  
  fv(int paramInt)
  {
    this.a = new int[1];
    this.b = 1;
    this.a[0] = paramInt;
  }
  
  fv(fu paramfu)
  {
    this.a = new int[paramfu.b.length];
    System.arraycopy(paramfu.b, 0, this.a, 0, paramfu.b.length);
    this.b = this.a.length;
  }
  
  private fv(fv paramfv)
  {
    this.b = paramfv.b;
    this.a = new int[this.b];
    while (i < this.b)
    {
      this.a[i] = paramfv.a[(paramfv.c + i)];
      i += 1;
    }
  }
  
  fv(int[] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramArrayOfInt.length;
  }
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
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
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
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
  
  private static fv a(fv paramfv1, fv paramfv2, int paramInt)
  {
    fv localfv = new fv();
    int i = paramfv2.a[(paramfv2.c + paramfv2.b - 1)];
    int j = (2 - i * i) * i;
    j *= (2 - i * j);
    j *= (2 - i * j);
    j = -((2 - i * j) * j);
    i = 0;
    while (i < paramInt >> 5)
    {
      paramfv2.a(paramfv1.a[(paramfv1.c + paramfv1.b - 1)] * j, localfv);
      paramfv1.a(localfv);
      paramfv1.b -= 1;
      i += 1;
    }
    paramInt &= 0x1F;
    if (paramInt != 0)
    {
      paramfv2.a(j * paramfv1.a[(paramfv1.c + paramfv1.b - 1)] & (1 << paramInt) - 1, localfv);
      paramfv1.a(localfv);
      paramfv1.b(paramInt);
    }
    while (paramfv1.d(paramfv2) >= 0) {
      paramfv1.b(paramfv2);
    }
    return paramfv1;
  }
  
  private void a()
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
  
  private void a(int paramInt, fv paramfv)
  {
    if (paramInt == 1)
    {
      paramfv.e(this);
      return;
    }
    if (paramInt == 0)
    {
      paramfv.a();
      return;
    }
    long l2 = paramInt;
    if (paramfv.a.length < this.b + 1) {}
    long l1;
    for (int[] arrayOfInt = new int[this.b + 1];; arrayOfInt = paramfv.a)
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
      paramfv.c = 1;
      paramfv.b = this.b;
    }
    for (;;)
    {
      paramfv.a = arrayOfInt;
      return;
      paramfv.c = 0;
      this.b += 1;
      arrayOfInt[0] = ((int)l1);
    }
  }
  
  private void a(fv paramfv1, fv paramfv2)
  {
    int k = this.b;
    int m = paramfv1.b;
    int i = k + m;
    if (paramfv2.a.length < i) {
      paramfv2.a = new int[i];
    }
    paramfv2.c = 0;
    paramfv2.b = i;
    long l = 0L;
    int j = m - 1;
    i = m + k - 1;
    while (j >= 0)
    {
      l += (paramfv1.a[(paramfv1.c + j)] & 0xFFFFFFFF) * (this.a[(k - 1 + this.c)] & 0xFFFFFFFF);
      paramfv2.a[i] = ((int)l);
      l >>>= 32;
      j -= 1;
      i -= 1;
    }
    paramfv2.a[(k - 1)] = ((int)l);
    i = k - 2;
    while (i >= 0)
    {
      l = 0L;
      k = m - 1;
      j = m + i;
      while (k >= 0)
      {
        l += (paramfv1.a[(paramfv1.c + k)] & 0xFFFFFFFF) * (this.a[(this.c + i)] & 0xFFFFFFFF) + (paramfv2.a[j] & 0xFFFFFFFF);
        paramfv2.a[j] = ((int)l);
        l >>>= 32;
        k -= 1;
        j -= 1;
      }
      paramfv2.a[i] = ((int)l);
      i -= 1;
    }
    paramfv2.c();
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong, int paramInt)
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
  
  private final int b()
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
    return (this.b - 1 - i << 5) + fu.b(j);
  }
  
  private void b(int paramInt)
  {
    if (this.b == 0) {}
    int i;
    do
    {
      return;
      i = paramInt & 0x1F;
      this.b -= (paramInt >>> 5);
    } while (i == 0);
    if (i >= fu.a(this.a[this.c]))
    {
      d(32 - i);
      this.b -= 1;
      return;
    }
    c(i);
  }
  
  private void b(int paramInt, fv paramfv)
  {
    long l2 = paramInt & 0xFFFFFFFF;
    if (this.b == 1)
    {
      l1 = this.a[this.c] & 0xFFFFFFFF;
      paramfv.a[0] = ((int)(l1 / l2));
      if (paramfv.a[0] == 0)
      {
        paramInt = 0;
        paramfv.b = paramInt;
        paramfv.c = 0;
        this.a[0] = ((int)(l1 - l2 * paramfv.a[0]));
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
    if (paramfv.a.length < this.b) {
      paramfv.a = new int[this.b];
    }
    paramfv.c = 0;
    paramfv.b = this.b;
    int k = fu.a(paramInt);
    int i = this.a[this.c];
    long l1 = i & 0xFFFFFFFF;
    int j;
    int[] arrayOfInt;
    if (l1 < l2)
    {
      paramfv.a[0] = 0;
      j = this.b;
      arrayOfInt = new int[2];
      label202:
      j -= 1;
      if (j <= 0) {
        break label357;
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
      paramfv.a[(this.b - j)] = arrayOfInt[0];
      i = arrayOfInt[1];
      l1 = i & 0xFFFFFFFF;
      break label202;
      paramfv.a[0] = ((int)(l1 / l2));
      i = (int)(l1 - paramfv.a[0] * l2);
      l1 = i & 0xFFFFFFFF;
      break;
      label346:
      a(arrayOfInt, l1, paramInt);
    }
    label357:
    if (32 - k > 0)
    {
      this.a[0] = (i % paramInt);
      if (this.a[0] != 0) {
        break label405;
      }
    }
    label405:
    for (paramInt = 0;; paramInt = 1)
    {
      this.b = paramInt;
      paramfv.c();
      return;
      this.a[0] = i;
      break;
    }
  }
  
  private void c()
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
  
  private final void c(int paramInt)
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
  
  private int d(fv paramfv)
  {
    int k = 0;
    int j;
    if (this.b < paramfv.b)
    {
      j = -1;
      return j;
    }
    if (this.b > paramfv.b) {
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
      int m = paramfv.a[(paramfv.c + i)] - -2147483648;
      if (j < m) {
        return -1;
      }
      if (j > m) {
        return 1;
      }
      i += 1;
    }
  }
  
  private final void d(int paramInt)
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
  
  private fv e(int paramInt)
  {
    if ((this.b == 0) || ((this.a[(this.c + this.b - 1)] & 0x1) == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      throw new ArithmeticException("Non-invertible. (GCD != 1)");
    }
    if (paramInt > 64) {
      return f(paramInt);
    }
    i = this.a[(this.c + this.b - 1)];
    int j = (2 - i * i) * i;
    j *= (2 - i * j);
    j *= (2 - i * j);
    i = (2 - i * j) * j;
    if (paramInt < 33)
    {
      if (paramInt == 32) {}
      for (paramInt = i;; paramInt = i & (1 << paramInt) - 1) {
        return new fv(paramInt);
      }
    }
    long l2 = this.a[(this.c + this.b - 1)] & 0xFFFFFFFF;
    long l1 = l2;
    if (this.b > 1) {
      l1 = l2 | this.a[(this.c + this.b - 2)] << 32;
    }
    l2 = i & 0xFFFFFFFF;
    l1 = (2L - l1 * l2) * l2;
    if (paramInt == 64) {}
    for (;;)
    {
      fv localfv = new fv(new int[2]);
      localfv.a[0] = ((int)(l1 >>> 32));
      localfv.a[1] = ((int)l1);
      localfv.b = 2;
      localfv.c();
      return localfv;
      l1 &= (1L << paramInt) - 1L;
    }
  }
  
  private void e(fv paramfv)
  {
    int j = paramfv.b;
    if (this.a.length < j) {
      this.a = new int[j];
    }
    int i = 0;
    while (i < j)
    {
      this.a[i] = paramfv.a[(paramfv.c + i)];
      i += 1;
    }
    this.b = j;
    this.c = 0;
  }
  
  private fv f(int paramInt)
  {
    Object localObject1 = new fv(1);
    ((fv)localObject1).a(paramInt);
    fv localfv1 = new fv((fv)localObject1);
    Object localObject2 = new fv(this);
    fv localfv2 = new fv();
    Object localObject3 = new fv();
    ((fv)localObject1).a((fv)localObject2, localfv2, (fv)localObject3);
    fv localfv3 = new fv(localfv2);
    fv localfv4 = new fv(1);
    fv localfv5 = new fv();
    if ((((fv)localObject3).b == 1) && (localObject3.a[localObject3.c] == 1)) {
      paramInt = 1;
    }
    while (paramInt == 0)
    {
      ((fv)localObject2).a((fv)localObject3, localfv2, (fv)localObject1);
      if (((fv)localObject1).b == 0)
      {
        throw new ArithmeticException("BigInteger not invertible.");
        paramInt = 0;
      }
      else
      {
        if (localfv2.b == 1)
        {
          localfv3.a(localfv2.a[localfv2.c], localfv5);
          localfv4.a(localfv5);
          if ((((fv)localObject1).b != 1) || (localObject1.a[localObject1.c] != 1)) {
            break label227;
          }
        }
        label227:
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label232;
          }
          return localfv4;
          localfv2.a(localfv3, localfv5);
          break;
        }
        label232:
        ((fv)localObject3).a((fv)localObject1, localfv5, (fv)localObject2);
        if (((fv)localObject2).b == 0) {
          throw new ArithmeticException("BigInteger not invertible.");
        }
        if (localfv5.b == 1) {
          localfv4.a(localfv5.a[localfv5.c], localfv2);
        }
        for (;;)
        {
          localfv3.a(localfv2);
          Object localObject4 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
          localfv5.a(localfv4, localfv2);
        }
      }
    }
    localfv1.b(localfv3);
    return localfv1;
  }
  
  private fv f(fv paramfv)
  {
    fv localfv = new fv(paramfv);
    paramfv = new fv(this);
    Object localObject1 = new fv(localfv);
    Object localObject2 = new fw();
    Object localObject3 = new fw((byte)0);
    int i;
    if ((paramfv.b == 0) || ((paramfv.a[(paramfv.c + paramfv.b - 1)] & 0x1) == 0))
    {
      i = 1;
      if (i == 0) {
        break label425;
      }
      i = paramfv.b();
      paramfv.b(i);
      ((fw)localObject3).a(i);
    }
    for (;;)
    {
      if ((paramfv.b == 1) && (paramfv.a[paramfv.c] == 1))
      {
        j = 1;
        label122:
        if (j != 0) {
          break label368;
        }
        if (paramfv.b != 0) {
          break label159;
        }
      }
      label159:
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label164;
        }
        throw new ArithmeticException("BigInteger not invertible.");
        i = 0;
        break;
        j = 0;
        break label122;
      }
      label164:
      Object localObject7 = localObject3;
      Object localObject6 = localObject2;
      Object localObject5 = localObject1;
      Object localObject4 = paramfv;
      if (paramfv.d((fv)localObject1) < 0)
      {
        localObject4 = localObject1;
        localObject5 = paramfv;
        localObject6 = localObject3;
        localObject7 = localObject2;
      }
      if (((localObject4.a[(localObject4.c + localObject4.b - 1)] ^ localObject5.a[(localObject5.c + localObject5.b - 1)]) & 0x3) == 0)
      {
        ((fv)localObject4).b((fv)localObject5);
        if (localObject6.d == localObject7.d) {
          break label345;
        }
        localObject6.a(localObject7);
      }
      for (;;)
      {
        j = ((fv)localObject4).b();
        ((fv)localObject4).b(j);
        localObject7.a(j);
        i += j;
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
        paramfv = (fv)localObject4;
        break;
        ((fv)localObject4).a((fv)localObject5);
        if (localObject6.d == localObject7.d)
        {
          localObject6.a(localObject7);
        }
        else
        {
          label345:
          j = localObject6.d;
          localObject6.d = (localObject6.b(localObject7) * j);
        }
      }
      label368:
      while (((fw)localObject2).d < 0) {
        if (((fw)localObject2).d == 1) {
          ((fw)localObject2).a(localfv);
        } else {
          ((fw)localObject2).d *= ((fw)localObject2).b(localfv);
        }
      }
      return a((fv)localObject2, localfv, i);
      label425:
      i = 0;
    }
  }
  
  final void a(int paramInt)
  {
    if (this.b == 0) {
      return;
    }
    int j = paramInt & 0x1F;
    int k = fu.a(this.a[this.c]);
    if (paramInt <= 32 - k)
    {
      d(j);
      return;
    }
    int i = (paramInt >>> 5) + this.b + 1;
    paramInt = i;
    if (j <= 32 - k) {
      paramInt = i - 1;
    }
    if (this.a.length < paramInt)
    {
      int[] arrayOfInt = new int[paramInt];
      i = 0;
      while (i < this.b)
      {
        arrayOfInt[i] = this.a[(this.c + i)];
        i += 1;
      }
      this.a = arrayOfInt;
      this.b = paramInt;
      this.c = 0;
    }
    for (;;)
    {
      this.b = paramInt;
      if (j == 0) {
        break;
      }
      if (j > 32 - k) {
        break label270;
      }
      d(j);
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
    label270:
    c(32 - j);
  }
  
  final void a(fv paramfv)
  {
    int n = this.b;
    int j = paramfv.b;
    int i;
    if (this.b > paramfv.b)
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
        l2 = (l2 >>> 32) + ((this.a[(this.c + n)] & 0xFFFFFFFF) + (paramfv.a[(paramfv.c + j)] & 0xFFFFFFFF));
        arrayOfInt[k] = ((int)l2);
        k -= 1;
      }
      i = paramfv.b;
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
      l2 = (l2 >>> 32) + (paramfv.a[(paramfv.c + n)] & 0xFFFFFFFF);
      arrayOfInt[k] = ((int)l2);
      k -= 1;
    }
    j = i;
    paramfv = arrayOfInt;
    if (l2 >>> 32 > 0L)
    {
      i += 1;
      if (arrayOfInt.length >= i) {
        break label366;
      }
      paramfv = new int[i];
      j = i - 1;
      while (j > 0)
      {
        paramfv[j] = arrayOfInt[(j - 1)];
        j -= 1;
      }
      paramfv[0] = 1;
      j = i;
    }
    for (;;)
    {
      this.a = paramfv;
      this.b = j;
      this.c = (paramfv.length - j);
      return;
      label366:
      arrayOfInt[k] = 1;
      j = i;
      paramfv = arrayOfInt;
    }
  }
  
  final void a(fv paramfv1, fv paramfv2, fv paramfv3)
  {
    if (paramfv1.b == 0) {
      throw new ArithmeticException("BigInteger divide by zero");
    }
    if (this.b == 0)
    {
      paramfv3.c = 0;
      paramfv3.b = 0;
      paramfv2.c = 0;
      paramfv2.b = 0;
      return;
    }
    int i = d(paramfv1);
    if (i < 0)
    {
      paramfv2.c = 0;
      paramfv2.b = 0;
      paramfv3.e(this);
      return;
    }
    if (i == 0)
    {
      paramfv1 = paramfv2.a;
      paramfv2.b = 1;
      paramfv1[0] = 1;
      paramfv3.c = 0;
      paramfv3.b = 0;
      paramfv2.c = 0;
      return;
    }
    paramfv2.a();
    if (paramfv1.b == 1)
    {
      paramfv3.e(this);
      paramfv3.b(paramfv1.a[paramfv1.c], paramfv2);
      return;
    }
    int[] arrayOfInt1 = new int[paramfv1.b];
    i = 0;
    while (i < paramfv1.b)
    {
      arrayOfInt1[i] = paramfv1.a[(paramfv1.c + i)];
      i += 1;
    }
    int i1 = paramfv1.b;
    if (paramfv3.a.length < this.b + 1) {
      paramfv3.a = new int[this.b + 1];
    }
    i = 0;
    while (i < this.b)
    {
      paramfv3.a[(i + 1)] = this.a[(this.c + i)];
      i += 1;
    }
    paramfv3.b = this.b;
    paramfv3.c = 1;
    i = paramfv3.b;
    int i2 = i - i1 + 1;
    if (paramfv2.a.length < i2)
    {
      paramfv2.a = new int[i2];
      paramfv2.c = 0;
    }
    paramfv2.b = i2;
    paramfv1 = paramfv2.a;
    int i3 = 32 - fu.a(arrayOfInt1[0]);
    if (i3 > 0)
    {
      fu.a(arrayOfInt1, i1, i3);
      paramfv3.a(i3);
    }
    if (paramfv3.b == i)
    {
      paramfv3.c = 0;
      paramfv3.a[0] = 0;
      paramfv3.b += 1;
    }
    int i4 = arrayOfInt1[0];
    long l1 = i4 & 0xFFFFFFFF;
    int i5 = arrayOfInt1[1];
    int[] arrayOfInt2 = new int[2];
    int n = 0;
    if (n < i2)
    {
      i = paramfv3.a[(paramfv3.c + n)];
      int i6 = i - -2147483648;
      int j = paramfv3.a[(n + 1 + paramfv3.c)];
      int k;
      label485:
      int m;
      label496:
      long l2;
      if (i == i4)
      {
        k = i + j;
        if (-2147483648 + k < i6)
        {
          i = 1;
          j = -1;
          m = i;
          i = j;
          if (i != 0)
          {
            j = i;
            if (m == 0)
            {
              l2 = paramfv3.a[(n + 2 + paramfv3.c)] & 0xFFFFFFFF;
              long l3 = k;
              if ((i5 & 0xFFFFFFFF) * (i & 0xFFFFFFFF) - -9223372036854775808L <= ((l3 & 0xFFFFFFFF) << 32 | l2) - -9223372036854775808L) {
                break label852;
              }
              m = 1;
              label578:
              j = i;
              if (m != 0)
              {
                m = i - 1;
                i = (int)((k & 0xFFFFFFFF) + l1);
                j = m;
                if ((i & 0xFFFFFFFF) >= l1) {
                  if (-9223372036854775808L + (i5 & 0xFFFFFFFF) * (m & 0xFFFFFFFF) <= ((i & 0xFFFFFFFF) << 32 | l2) - -9223372036854775808L) {
                    break label858;
                  }
                }
              }
            }
          }
        }
      }
      label852:
      label858:
      for (i = 1;; i = 0)
      {
        j = m;
        if (i != 0) {
          j = m - 1;
        }
        paramfv3.a[(paramfv3.c + n)] = 0;
        i = j;
        if (a(paramfv3.a, arrayOfInt1, j, i1, paramfv3.c + n) - -2147483648 > i6)
        {
          a(arrayOfInt1, paramfv3.a, n + 1 + paramfv3.c);
          i = j - 1;
        }
        paramfv1[n] = i;
        n += 1;
        break;
        i = 0;
        break label485;
        l2 = i;
        l2 = j & 0xFFFFFFFF | l2 << 32;
        if (l2 >= 0L)
        {
          i = (int)(l2 / l1);
          k = (int)(l2 - i * l1);
          m = 0;
          break label496;
        }
        a(arrayOfInt2, l2, i4);
        i = arrayOfInt2[0];
        k = arrayOfInt2[1];
        m = 0;
        break label496;
        m = 0;
        break label578;
      }
    }
    if (i3 > 0) {
      paramfv3.b(i3);
    }
    paramfv3.c();
    paramfv2.c();
  }
  
  final int b(fv paramfv)
  {
    int[] arrayOfInt = this.a;
    int m = d(paramfv);
    if (m == 0)
    {
      this.b = 0;
      this.c = 0;
      return 0;
    }
    Object localObject;
    fv localfv;
    if (m < 0)
    {
      localObject = this;
      localfv = paramfv;
      paramfv = (fv)localObject;
    }
    for (;;)
    {
      int n = localfv.b;
      localObject = arrayOfInt;
      if (arrayOfInt.length < n) {
        localObject = new int[n];
      }
      int j = localfv.b;
      int k = paramfv.b;
      int i = localObject.length - 1;
      long l = 0L;
      while (k > 0)
      {
        j -= 1;
        k -= 1;
        l = (localfv.a[(localfv.c + j)] & 0xFFFFFFFF) - (paramfv.a[(paramfv.c + k)] & 0xFFFFFFFF) - (int)-(l >> 32);
        localObject[i] = ((int)l);
        i -= 1;
      }
      for (;;)
      {
        if (j > 0)
        {
          j -= 1;
          l = (localfv.a[(localfv.c + j)] & 0xFFFFFFFF) - (int)-(l >> 32);
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
      localfv = this;
    }
  }
  
  final fv c(fv paramfv)
  {
    int j = 0;
    if ((paramfv.a[(paramfv.c + paramfv.b - 1)] & 0x1) == 1) {}
    for (int i = 1; i != 0; i = 0) {
      return f(paramfv);
    }
    if ((this.b == 0) || ((this.a[(this.c + this.b - 1)] & 0x1) == 0)) {}
    for (i = 1; i != 0; i = 0) {
      throw new ArithmeticException("BigInteger not invertible.");
    }
    int k = paramfv.b();
    fv localfv1 = new fv(paramfv);
    localfv1.b(k);
    i = j;
    if (localfv1.b == 1)
    {
      i = j;
      if (localfv1.a[localfv1.c] == 1) {
        i = 1;
      }
    }
    if (i != 0) {
      return e(k);
    }
    fv localfv2 = f(localfv1);
    fv localfv3 = e(k);
    fv localfv4 = a(new fv(1), new fv(localfv1), k);
    fv localfv5 = localfv1.e(k);
    fv localfv6 = new fv();
    fv localfv7 = new fv();
    fv localfv8 = new fv();
    localfv2.a(k);
    localfv2.a(localfv4, localfv8);
    localfv3.a(localfv1, localfv6);
    localfv6.a(localfv5, localfv7);
    localfv8.a(localfv7);
    localfv8.a(paramfv, localfv6, localfv7);
    return localfv7;
  }
  
  public String toString()
  {
    return new fu(this, 1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fv
 * JD-Core Version:    0.7.0.1
 */