package com.tencent.token;

import java.util.Arrays;

final class alm
  extends alb
{
  final transient byte[][] f;
  final transient int[] g;
  
  alm(aky paramaky, int paramInt)
  {
    super(null);
    alq.a(paramaky.b, 0L, paramInt);
    Object localObject = paramaky.a;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt) {
      if (((alk)localObject).c != ((alk)localObject).b)
      {
        j += ((alk)localObject).c - ((alk)localObject).b;
        i += 1;
        localObject = ((alk)localObject).f;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    this.f = new byte[i][];
    this.g = new int[i * 2];
    paramaky = paramaky.a;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.f[j] = paramaky.a;
      k = i + (paramaky.c - paramaky.b);
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      localObject = this.g;
      localObject[j] = i;
      localObject[(this.f.length + j)] = paramaky.b;
      paramaky.d = true;
      j += 1;
      paramaky = paramaky.f;
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
  
  private alb i()
  {
    return new alb(h());
  }
  
  public final byte a(int paramInt)
  {
    alq.a(this.g[(this.f.length - 1)], paramInt, 1L);
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
  
  public final alb a(int paramInt1, int paramInt2)
  {
    return i().a(paramInt1, paramInt2);
  }
  
  public final String a()
  {
    return i().a();
  }
  
  final void a(aky paramaky)
  {
    int m = this.f.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = this.g;
      int n = localObject[(m + i)];
      k = localObject[i];
      localObject = new alk(this.f[i], n, n + k - j);
      if (paramaky.a == null)
      {
        ((alk)localObject).g = ((alk)localObject);
        ((alk)localObject).f = ((alk)localObject);
        paramaky.a = ((alk)localObject);
      }
      else
      {
        paramaky.a.g.a((alk)localObject);
      }
      i += 1;
    }
    paramaky.b += j;
  }
  
  public final boolean a(int paramInt1, alb paramalb, int paramInt2, int paramInt3)
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
      if (!paramalb.a(paramInt2, arrayOfByte[paramInt1], i - j + m, k)) {
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
        if (!alq.a(arrayOfByte[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
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
  
  public final alb c()
  {
    return i().c();
  }
  
  public final alb d()
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
    if ((paramObject instanceof alb))
    {
      paramObject = (alb)paramObject;
      if ((paramObject.g() == g()) && (a(0, paramObject, 0, g()))) {
        return true;
      }
    }
    return false;
  }
  
  public final alb f()
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
 * Qualified Name:     com.tencent.token.alm
 * JD-Core Version:    0.7.0.1
 */