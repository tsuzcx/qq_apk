package com.tencent.token;

class abp
{
  int[] a;
  int b;
  int c;
  
  abp()
  {
    this.c = 0;
    this.a = new int[1];
    this.b = 0;
  }
  
  abp(int paramInt)
  {
    this.c = 0;
    this.a = new int[1];
    this.b = 1;
    this.a[0] = paramInt;
  }
  
  abp(abo paramabo)
  {
    this.c = 0;
    this.a = new int[paramabo.b.length];
    System.arraycopy(paramabo.b, 0, this.a, 0, paramabo.b.length);
    this.b = this.a.length;
  }
  
  abp(abp paramabp)
  {
    int i = 0;
    this.c = 0;
    this.b = paramabp.b;
    this.a = new int[this.b];
    while (i < this.b)
    {
      this.a[i] = paramabp.a[(paramabp.c + i)];
      i += 1;
    }
  }
  
  abp(int[] paramArrayOfInt)
  {
    this.c = 0;
    this.a = paramArrayOfInt;
    this.b = paramArrayOfInt.length;
  }
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
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
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
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
  
  static abp a(abp paramabp1, abp paramabp2, int paramInt)
  {
    abp localabp = new abp();
    int j = -d(paramabp2.a[(paramabp2.c + paramabp2.b - 1)]);
    int i = 0;
    while (i < paramInt >> 5)
    {
      paramabp2.a(paramabp1.a[(paramabp1.c + paramabp1.b - 1)] * j, localabp);
      paramabp1.a(localabp);
      paramabp1.b -= 1;
      i += 1;
    }
    paramInt &= 0x1F;
    if (paramInt != 0)
    {
      paramabp2.a(j * paramabp1.a[(paramabp1.c + paramabp1.b - 1)] & (1 << paramInt) - 1, localabp);
      paramabp1.a(localabp);
      paramabp1.a(paramInt);
    }
    while (paramabp1.d(paramabp2) >= 0) {
      paramabp1.b(paramabp2);
    }
    return paramabp1;
  }
  
  private void a(int paramInt, abp paramabp)
  {
    if (paramInt == 1)
    {
      paramabp.e(this);
      return;
    }
    if (paramInt == 0)
    {
      paramabp.d();
      return;
    }
    long l2 = paramInt;
    int[] arrayOfInt = paramabp.a;
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
      paramabp.c = 1;
      paramabp.b = this.b;
    }
    else
    {
      paramabp.c = 0;
      this.b += 1;
      arrayOfInt[0] = ((int)l1);
    }
    paramabp.a = arrayOfInt;
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
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - -9223372036854775808L > paramLong2 - -9223372036854775808L;
  }
  
  private void b(int paramInt, abp paramabp)
  {
    long l2 = paramInt & 0xFFFFFFFF;
    int j = this.b;
    int i = 1;
    if (j == 1)
    {
      l1 = 0xFFFFFFFF & this.a[this.c];
      arrayOfInt = paramabp.a;
      arrayOfInt[0] = ((int)(l1 / l2));
      if (arrayOfInt[0] == 0) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      paramabp.b = paramInt;
      paramabp.c = 0;
      arrayOfInt = this.a;
      arrayOfInt[0] = ((int)(l1 - paramabp.a[0] * l2));
      this.c = 0;
      paramInt = i;
      if (arrayOfInt[0] == 0) {
        paramInt = 0;
      }
      this.b = paramInt;
      return;
    }
    if (paramabp.a.length < j) {
      paramabp.a = new int[j];
    }
    paramabp.c = 0;
    paramabp.b = this.b;
    int k = abo.a(paramInt);
    i = this.a[this.c];
    long l1 = i & 0xFFFFFFFF;
    if (l1 < l2)
    {
      paramabp.a[0] = 0;
    }
    else
    {
      arrayOfInt = paramabp.a;
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
      paramabp.a[(this.b - j)] = arrayOfInt[0];
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
    paramabp.e();
  }
  
  static int d(int paramInt)
  {
    int i = (2 - paramInt * paramInt) * paramInt;
    i *= (2 - paramInt * i);
    i *= (2 - paramInt * i);
    return i * (2 - paramInt * i);
  }
  
  private int d(abp paramabp)
  {
    int i = this.b;
    int j = paramabp.b;
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
      int k = paramabp.a[(paramabp.c + i)] - -2147483648;
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
  
  private void d()
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
  
  private void e()
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
  
  private final void e(int paramInt)
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
  
  private void e(abp paramabp)
  {
    int j = paramabp.b;
    if (this.a.length < j) {
      this.a = new int[j];
    }
    int i = 0;
    while (i < j)
    {
      this.a[i] = paramabp.a[(paramabp.c + i)];
      i += 1;
    }
    this.b = j;
    this.c = 0;
  }
  
  private final void f(int paramInt)
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
  
  private abp g(int paramInt)
  {
    Object localObject3 = new abp(1);
    ((abp)localObject3).b(paramInt);
    abp localabp1 = new abp((abp)localObject3);
    Object localObject2 = new abp(this);
    abp localabp2 = new abp();
    Object localObject1 = new abp();
    ((abp)localObject3).a((abp)localObject2, localabp2, (abp)localObject1);
    abp localabp3 = new abp(localabp2);
    abp localabp4 = new abp(1);
    abp localabp5 = new abp();
    for (;;)
    {
      Object localObject4 = localObject3;
      if (((abp)localObject1).b()) {
        break label270;
      }
      ((abp)localObject2).a((abp)localObject1, localabp2, localObject4);
      if (localObject4.b == 0) {
        break label260;
      }
      if (localabp2.b == 1) {
        localabp3.a(localabp2.a[localabp2.c], localabp5);
      } else {
        localabp2.a(localabp3, localabp5);
      }
      localabp4.a(localabp5);
      if (localObject4.b()) {
        return localabp4;
      }
      ((abp)localObject1).a(localObject4, localabp5, (abp)localObject2);
      if (((abp)localObject2).b == 0) {
        break;
      }
      if (localabp5.b == 1) {
        localabp4.a(localabp5.a[localabp5.c], localabp2);
      } else {
        localabp5.a(localabp4, localabp2);
      }
      localabp3.a(localabp2);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    throw new ArithmeticException("BigInteger not invertible.");
    label260:
    throw new ArithmeticException("BigInteger not invertible.");
    label270:
    localabp1.b(localabp3);
    return localabp1;
  }
  
  final int a()
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
    return (this.b - 1 - i << 5) + abo.b(j);
  }
  
  final void a(int paramInt)
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
    if (j >= abo.a(this.a[this.c]))
    {
      f(32 - j);
      this.b -= 1;
      return;
    }
    e(j);
  }
  
  final void a(abp paramabp)
  {
    int n = this.b;
    int j = paramabp.b;
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
      l2 = (this.a[(this.c + n)] & 0xFFFFFFFF) + (paramabp.a[(paramabp.c + j)] & 0xFFFFFFFF) + (l2 >>> 32);
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
      l2 = (paramabp.a[(paramabp.c + n)] & 0xFFFFFFFF) + (l2 >>> 32);
      arrayOfInt1[k] = ((int)l2);
      k -= 1;
    }
    j = i;
    paramabp = arrayOfInt1;
    if (l2 >>> 32 > 0L)
    {
      j = i + 1;
      if (arrayOfInt1.length < j)
      {
        paramabp = new int[j];
        i = j - 1;
        while (i > 0)
        {
          paramabp[i] = arrayOfInt1[(i - 1)];
          i -= 1;
        }
        paramabp[0] = 1;
      }
      else
      {
        arrayOfInt1[k] = 1;
        paramabp = arrayOfInt1;
      }
    }
    this.a = paramabp;
    this.b = j;
    this.c = (paramabp.length - j);
  }
  
  final void a(abp paramabp1, abp paramabp2)
  {
    int n = this.b;
    int m = paramabp1.b;
    int i = n + m;
    if (paramabp2.a.length < i) {
      paramabp2.a = new int[i];
    }
    paramabp2.c = 0;
    paramabp2.b = i;
    int j = m - 1;
    i -= 1;
    int k = j;
    long l1 = 0L;
    Object localObject;
    for (;;)
    {
      abp localabp = paramabp1;
      localObject = this;
      if (k < 0) {
        break;
      }
      l1 = (localabp.a[(localabp.c + k)] & 0xFFFFFFFF) * (localObject.a[(n - 1 + localObject.c)] & 0xFFFFFFFF) + l1;
      paramabp2.a[i] = ((int)l1);
      l1 >>>= 32;
      k -= 1;
      i -= 1;
    }
    paramabp2.a[(n - 1)] = ((int)l1);
    k = n - 2;
    i = m;
    while (k >= 0)
    {
      m = i + k;
      n = j;
      l1 = 0L;
      while (n >= 0)
      {
        long l2 = paramabp1.a[(paramabp1.c + n)];
        long l3 = this.a[(this.c + k)];
        localObject = paramabp2.a;
        l1 = (l2 & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF) + (localObject[m] & 0xFFFFFFFF) + l1;
        localObject[m] = ((int)l1);
        l1 >>>= 32;
        n -= 1;
        m -= 1;
      }
      paramabp2.a[k] = ((int)l1);
      k -= 1;
    }
    paramabp2.e();
  }
  
  final void a(abp paramabp1, abp paramabp2, abp paramabp3)
  {
    if (paramabp1.b != 0)
    {
      if (this.b == 0)
      {
        paramabp3.c = 0;
        paramabp3.b = 0;
        paramabp2.c = 0;
        paramabp2.b = 0;
        return;
      }
      int i = d(paramabp1);
      if (i < 0)
      {
        paramabp2.c = 0;
        paramabp2.b = 0;
        paramabp3.e(this);
        return;
      }
      if (i == 0)
      {
        paramabp1 = paramabp2.a;
        paramabp2.b = 1;
        paramabp1[0] = 1;
        paramabp3.c = 0;
        paramabp3.b = 0;
        paramabp2.c = 0;
        return;
      }
      paramabp2.d();
      i = paramabp1.b;
      if (i == 1)
      {
        paramabp3.e(this);
        paramabp3.b(paramabp1.a[paramabp1.c], paramabp2);
        return;
      }
      int[] arrayOfInt3 = new int[i];
      i = 0;
      int k;
      for (;;)
      {
        k = paramabp1.b;
        if (i >= k) {
          break;
        }
        arrayOfInt3[i] = paramabp1.a[(paramabp1.c + i)];
        i += 1;
      }
      i = paramabp3.a.length;
      int j = this.b;
      if (i < j + 1) {
        paramabp3.a = new int[j + 1];
      }
      for (i = 0;; i = j)
      {
        j = this.b;
        if (i >= j) {
          break;
        }
        paramabp1 = paramabp3.a;
        j = i + 1;
        paramabp1[j] = this.a[(i + this.c)];
      }
      paramabp3.b = j;
      paramabp3.c = 1;
      i = paramabp3.b;
      int i3 = i - k + 1;
      if (paramabp2.a.length < i3)
      {
        paramabp2.a = new int[i3];
        paramabp2.c = 0;
      }
      paramabp2.b = i3;
      int[] arrayOfInt1 = paramabp2.a;
      int i2 = 32 - abo.a(arrayOfInt3[0]);
      if (i2 > 0)
      {
        abo.a(arrayOfInt3, k, i2);
        paramabp3.b(i2);
      }
      j = paramabp3.b;
      if (j == i)
      {
        paramabp3.c = 0;
        paramabp3.a[0] = 0;
        paramabp3.b = (j + 1);
      }
      int i4 = arrayOfInt3[0];
      long l1 = i4 & 0xFFFFFFFF;
      int m = arrayOfInt3[1];
      int[] arrayOfInt2 = new int[2];
      j = 0;
      paramabp1 = arrayOfInt3;
      while (j < i3)
      {
        arrayOfInt3 = paramabp3.a;
        int n = paramabp3.c;
        i = arrayOfInt3[(j + n)];
        int i6 = i - -2147483648;
        int i5 = j + 1;
        n = arrayOfInt3[(i5 + n)];
        int i1;
        long l2;
        if (i == i4)
        {
          i1 = i + n;
          if (i1 - -2147483648 < i6) {
            i = 1;
          } else {
            i = 0;
          }
          n = i;
          i = -1;
        }
        else
        {
          l2 = i;
          l2 = n & 0xFFFFFFFF | l2 << 32;
          if (l2 >= 0L)
          {
            i = (int)(l2 / l1);
            i1 = (int)(l2 - i * l1);
            n = 0;
          }
          else
          {
            a(arrayOfInt2, l2, i4);
            i = arrayOfInt2[0];
            i1 = arrayOfInt2[1];
            n = 0;
          }
        }
        if (i != 0)
        {
          if (n == 0)
          {
            l2 = paramabp3.a[(j + 2 + paramabp3.c)] & 0xFFFFFFFF;
            long l4 = i1 & 0xFFFFFFFF;
            long l3 = m & 0xFFFFFFFF;
            if (a((i & 0xFFFFFFFF) * l3, l4 << 32 | l2))
            {
              n = i - 1;
              l4 = (int)(l4 + l1) & 0xFFFFFFFF;
              if (l4 >= l1)
              {
                i = n;
                if (a(l3 * (n & 0xFFFFFFFF), l4 << 32 | l2)) {
                  i = n - 1;
                }
              }
              else
              {
                i = n;
              }
            }
            else {}
          }
          n = j;
          arrayOfInt3 = paramabp3.a;
          i1 = paramabp3.c;
          arrayOfInt3[(n + i1)] = 0;
          j = i;
          if (a(arrayOfInt3, paramabp1, i, k, n + i1) - -2147483648 > i6)
          {
            a(paramabp1, paramabp3.a, i5 + paramabp3.c);
            j = i - 1;
          }
          arrayOfInt1[n] = j;
        }
        j = i5;
      }
      if (i2 > 0) {
        paramabp3.a(i2);
      }
      paramabp3.e();
      paramabp2.e();
      return;
    }
    throw new ArithmeticException("BigInteger divide by zero");
  }
  
  final int b(abp paramabp)
  {
    int[] arrayOfInt2 = this.a;
    int i1 = d(paramabp);
    if (i1 == 0)
    {
      this.b = 0;
      this.c = 0;
      return 0;
    }
    abp localabp;
    if (i1 < 0)
    {
      localabp = this;
    }
    else
    {
      localabp = paramabp;
      paramabp = this;
    }
    int i2 = paramabp.b;
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2.length < i2) {
      arrayOfInt1 = new int[i2];
    }
    long l1 = 0L;
    int j = paramabp.b;
    int k = localabp.b;
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
      l1 = (paramabp.a[(paramabp.c + j)] & 0xFFFFFFFF) - (localabp.a[(localabp.c + k)] & 0xFFFFFFFF) - (int)-(l1 >> 32);
      arrayOfInt1[i] = ((int)l1);
      i -= 1;
    }
    while (m > 0)
    {
      m -= 1;
      l2 = (paramabp.a[(paramabp.c + m)] & 0xFFFFFFFF) - (int)-(l2 >> 32);
      arrayOfInt1[n] = ((int)l2);
      n -= 1;
    }
    this.a = arrayOfInt1;
    this.b = i2;
    this.c = (this.a.length - i2);
    e();
    return i1;
  }
  
  final void b(int paramInt)
  {
    if (this.b == 0) {
      return;
    }
    int m = paramInt & 0x1F;
    int n = 32 - abo.a(this.a[this.c]);
    if (paramInt <= n)
    {
      f(m);
      return;
    }
    int i = this.b + (paramInt >>> 5) + 1;
    paramInt = i;
    if (m <= n) {
      paramInt = i - 1;
    }
    int[] arrayOfInt = this.a;
    if (arrayOfInt.length < paramInt)
    {
      arrayOfInt = new int[paramInt];
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
    else
    {
      int j;
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
      f(m);
      return;
    }
    e(32 - m);
  }
  
  final boolean b()
  {
    return (this.b == 1) && (this.a[this.c] == 1);
  }
  
  final abp c(int paramInt)
  {
    if (!c())
    {
      if (paramInt > 64) {
        return g(paramInt);
      }
      int i = d(this.a[(this.c + this.b - 1)]);
      if (paramInt < 33)
      {
        if (paramInt == 32) {
          paramInt = i;
        } else {
          paramInt = i & (1 << paramInt) - 1;
        }
        return new abp(paramInt);
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
      localObject = new abp(new int[2]);
      int[] arrayOfInt = ((abp)localObject).a;
      arrayOfInt[0] = ((int)(l1 >>> 32));
      arrayOfInt[1] = ((int)l1);
      ((abp)localObject).b = 2;
      ((abp)localObject).e();
      return localObject;
    }
    throw new ArithmeticException("Non-invertible. (GCD != 1)");
  }
  
  final abp c(abp paramabp)
  {
    abp localabp = new abp(paramabp);
    Object localObject3 = new abp(this);
    Object localObject2 = new abp(localabp);
    Object localObject1 = new abq((byte)0);
    paramabp = new abq();
    int i;
    if (((abp)localObject3).c())
    {
      i = ((abp)localObject3).a();
      ((abp)localObject3).a(i);
      paramabp.b(i);
    }
    else
    {
      i = 0;
    }
    while (!((abp)localObject3).b())
    {
      int j;
      if (((abp)localObject3).b == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0)
      {
        Object localObject7 = localObject2;
        Object localObject6 = localObject1;
        Object localObject5 = paramabp;
        Object localObject4 = localObject3;
        if (((abp)localObject3).d((abp)localObject2) < 0)
        {
          localObject4 = localObject2;
          localObject5 = localObject1;
          localObject6 = paramabp;
          localObject7 = localObject3;
        }
        if (((localObject4.a[(localObject4.c + localObject4.b - 1)] ^ localObject7.a[(localObject7.c + localObject7.b - 1)]) & 0x3) == 0)
        {
          localObject4.b(localObject7);
          if (((abq)localObject6).d != ((abq)localObject5).d)
          {
            ((abq)localObject6).a((abp)localObject5);
            break label269;
          }
        }
        else
        {
          localObject4.a(localObject7);
          if (((abq)localObject6).d == ((abq)localObject5).d)
          {
            ((abq)localObject6).a((abp)localObject5);
            break label269;
          }
        }
        ((abq)localObject6).d *= ((abq)localObject6).b((abp)localObject5);
        label269:
        j = localObject4.a();
        localObject4.a(j);
        ((abq)localObject5).b(j);
        i += j;
        localObject2 = localObject7;
        localObject1 = localObject6;
        paramabp = (abp)localObject5;
        localObject3 = localObject4;
      }
      else
      {
        throw new ArithmeticException("BigInteger not invertible.");
      }
    }
    while (((abq)localObject1).d < 0) {
      if (((abq)localObject1).d == 1) {
        ((abq)localObject1).a(localabp);
      } else {
        ((abq)localObject1).d *= ((abq)localObject1).b(localabp);
      }
    }
    return a((abp)localObject1, localabp, i);
  }
  
  final boolean c()
  {
    int i = this.b;
    if (i != 0) {
      return (this.a[(this.c + i - 1)] & 0x1) == 0;
    }
    return true;
  }
  
  public String toString()
  {
    return new abo(this, 1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abp
 * JD-Core Version:    0.7.0.1
 */