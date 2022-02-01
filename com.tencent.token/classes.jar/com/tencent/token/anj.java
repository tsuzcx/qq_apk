package com.tencent.token;

import java.util.Arrays;

final class anj
  extends amy
{
  final transient byte[][] f;
  final transient int[] g;
  
  anj(amv paramamv, int paramInt)
  {
    super(null);
    ann.a(paramamv.b, 0L, paramInt);
    Object localObject = paramamv.a;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt) {
      if (((anh)localObject).c != ((anh)localObject).b)
      {
        j += ((anh)localObject).c - ((anh)localObject).b;
        i += 1;
        localObject = ((anh)localObject).f;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    this.f = new byte[i][];
    this.g = new int[i * 2];
    paramamv = paramamv.a;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.f[j] = paramamv.a;
      k = i + (paramamv.c - paramamv.b);
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      localObject = this.g;
      localObject[j] = i;
      localObject[(this.f.length + j)] = paramamv.b;
      paramamv.d = true;
      j += 1;
      paramamv = paramamv.f;
    }
  }
  
  private int b(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.g, 0, this.f.length, paramInt + 1);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private amy i()
  {
    return new amy(h());
  }
  
  public final byte a(int paramInt)
  {
    ann.a(this.g[(this.f.length - 1)], paramInt, 1L);
    int j = b(paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = this.g[(j - 1)];
    }
    int[] arrayOfInt = this.g;
    byte[][] arrayOfByte = this.f;
    int k = arrayOfInt[(arrayOfByte.length + j)];
    return arrayOfByte[j][(paramInt - i + k)];
  }
  
  public final amy a(int paramInt1, int paramInt2)
  {
    return i().a(paramInt1, paramInt2);
  }
  
  public final String a()
  {
    return i().a();
  }
  
  final void a(amv paramamv)
  {
    int m = this.f.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = this.g;
      int n = localObject[(m + i)];
      k = localObject[i];
      localObject = new anh(this.f[i], n, n + k - j);
      if (paramamv.a == null)
      {
        ((anh)localObject).g = ((anh)localObject);
        ((anh)localObject).f = ((anh)localObject);
        paramamv.a = ((anh)localObject);
      }
      else
      {
        paramamv.a.g.a((anh)localObject);
      }
      i += 1;
    }
    paramamv.b += j;
  }
  
  public final boolean a(int paramInt1, amy paramamy, int paramInt2, int paramInt3)
  {
    if (g() - paramInt3 < 0) {
      return false;
    }
    int j = b(0);
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt3 > 0)
    {
      if (paramInt1 == 0) {
        j = 0;
      } else {
        j = this.g[(paramInt1 - 1)];
      }
      int k = Math.min(paramInt3, this.g[paramInt1] - j + j - i);
      int[] arrayOfInt = this.g;
      byte[][] arrayOfByte = this.f;
      int m = arrayOfInt[(arrayOfByte.length + paramInt1)];
      if (!paramamy.a(paramInt2, arrayOfByte[paramInt1], i - j + m, k)) {
        return false;
      }
      i += k;
      paramInt2 += k;
      paramInt3 -= k;
      paramInt1 += 1;
    }
    return true;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= g() - paramInt3) && (paramInt2 >= 0))
    {
      if (paramInt2 > paramArrayOfByte.length - paramInt3) {
        return false;
      }
      int j = b(paramInt1);
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt3 > 0)
      {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.g[(paramInt1 - 1)];
        }
        int k = Math.min(paramInt3, this.g[paramInt1] - j + j - i);
        int[] arrayOfInt = this.g;
        byte[][] arrayOfByte = this.f;
        int m = arrayOfInt[(arrayOfByte.length + paramInt1)];
        if (!ann.a(arrayOfByte[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          return false;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public final String b()
  {
    return i().b();
  }
  
  public final amy c()
  {
    return i().c();
  }
  
  public final amy d()
  {
    return i().d();
  }
  
  public final String e()
  {
    return i().e();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof amy))
    {
      paramObject = (amy)paramObject;
      if ((paramObject.g() == g()) && (a(0, paramObject, 0, g()))) {
        return true;
      }
    }
    return false;
  }
  
  public final amy f()
  {
    return i().f();
  }
  
  public final int g()
  {
    return this.g[(this.f.length - 1)];
  }
  
  public final byte[] h()
  {
    Object localObject2 = this.g;
    Object localObject1 = this.f;
    localObject2 = new byte[localObject2[(localObject1.length - 1)]];
    int m = localObject1.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      localObject1 = this.g;
      int n = localObject1[(m + i)];
      k = localObject1[i];
      System.arraycopy(this.f[i], n, localObject2, j, k - j);
      i += 1;
    }
    return localObject2;
  }
  
  public final int hashCode()
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    int i2 = this.f.length;
    int k = 0;
    int m = 1;
    int n;
    for (int j = 0; k < i2; j = n)
    {
      byte[] arrayOfByte = this.f[k];
      int[] arrayOfInt = this.g;
      int i1 = arrayOfInt[(i2 + k)];
      n = arrayOfInt[k];
      i = i1;
      while (i < n - j + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      k += 1;
    }
    this.d = m;
    return m;
  }
  
  public final String toString()
  {
    return i().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anj
 * JD-Core Version:    0.7.0.1
 */