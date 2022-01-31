package com.google.zxing.common.reedsolomon;

import fp;

public final class ReedSolomonDecoder
{
  private final GenericGF a;
  
  public ReedSolomonDecoder(GenericGF paramGenericGF)
  {
    this.a = paramGenericGF;
  }
  
  private int[] a(fp paramfp)
  {
    int j = 0;
    int i = 1;
    int m = paramfp.a();
    if (m == 1) {
      return new int[] { paramfp.a(1) };
    }
    int[] arrayOfInt = new int[m];
    while ((i < this.a.a()) && (j < m))
    {
      int k = j;
      if (paramfp.b(i) == 0)
      {
        arrayOfInt[j] = this.a.c(i);
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j != m) {
      throw new ReedSolomonException("Error locator degree does not match number of roots");
    }
    return arrayOfInt;
  }
  
  private int[] a(fp paramfp, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int n = paramArrayOfInt.length;
    int[] arrayOfInt = new int[n];
    int j = 0;
    int i1;
    int i;
    int k;
    label39:
    int m;
    if (j < n)
    {
      i1 = this.a.c(paramArrayOfInt[j]);
      i = 1;
      k = 0;
      if (k < n)
      {
        if (j == k) {
          break label175;
        }
        m = this.a.b(paramArrayOfInt[k], i1);
        if ((m & 0x1) == 0)
        {
          m |= 0x1;
          label81:
          i = this.a.b(i, m);
        }
      }
    }
    label175:
    for (;;)
    {
      k += 1;
      break label39;
      m &= 0xFFFFFFFE;
      break label81;
      arrayOfInt[j] = this.a.b(paramfp.b(i1), this.a.c(i));
      if (paramBoolean) {
        arrayOfInt[j] = this.a.b(arrayOfInt[j], i1);
      }
      j += 1;
      break;
      return arrayOfInt;
    }
  }
  
  private fp[] a(fp paramfp1, fp paramfp2, int paramInt)
  {
    if (paramfp1.a() < paramfp2.a()) {}
    for (;;)
    {
      Object localObject = this.a.a();
      fp localfp1 = this.a.b();
      while (paramfp1.a() >= paramInt / 2)
      {
        if (paramfp1.a()) {
          throw new ReedSolomonException("r_{i-1} was zero");
        }
        fp localfp2 = this.a.a();
        int i = paramfp1.a(paramfp1.a());
        i = this.a.c(i);
        while ((paramfp2.a() >= paramfp1.a()) && (!paramfp2.a()))
        {
          int j = paramfp2.a() - paramfp1.a();
          int k = this.a.b(paramfp2.a(paramfp2.a()), i);
          localfp2 = localfp2.a(this.a.a(j, k));
          paramfp2 = paramfp2.a(paramfp1.a(j, k));
        }
        localObject = localfp2.b(localfp1).a((fp)localObject);
        localfp2 = paramfp1;
        paramfp1 = paramfp2;
        paramfp2 = (fp)localObject;
        localObject = localfp1;
        localfp1 = paramfp2;
        paramfp2 = localfp2;
      }
      paramInt = localfp1.a(0);
      if (paramInt == 0) {
        throw new ReedSolomonException("sigmaTilde(0) was zero");
      }
      paramInt = this.a.c(paramInt);
      return new fp[] { localfp1.a(paramInt), paramfp1.a(paramInt) };
      localfp1 = paramfp1;
      paramfp1 = paramfp2;
      paramfp2 = localfp1;
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    int m = 0;
    Object localObject1 = new fp(this.a, paramArrayOfInt);
    Object localObject2 = new int[paramInt];
    boolean bool = this.a.equals(GenericGF.f);
    int i = 0;
    int j = 1;
    int k;
    if (i < paramInt)
    {
      GenericGF localGenericGF = this.a;
      if (bool)
      {
        k = i + 1;
        label60:
        k = ((fp)localObject1).b(localGenericGF.a(k));
        localObject2[(localObject2.length - 1 - i)] = k;
        if (k == 0) {
          break label239;
        }
        j = 0;
      }
    }
    label239:
    for (;;)
    {
      i += 1;
      break;
      k = i;
      break label60;
      if (j != 0) {}
      for (;;)
      {
        return;
        localObject1 = new fp(this.a, (int[])localObject2);
        localObject2 = a(this.a.a(paramInt, 1), (fp)localObject1, paramInt);
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        localObject1 = a((fp)localObject1);
        localObject2 = a((fp)localObject2, (int[])localObject1, bool);
        paramInt = m;
        while (paramInt < localObject1.length)
        {
          i = paramArrayOfInt.length - 1 - this.a.b(localObject1[paramInt]);
          if (i < 0) {
            throw new ReedSolomonException("Bad error location");
          }
          paramArrayOfInt[i] = GenericGF.a(paramArrayOfInt[i], localObject2[paramInt]);
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonDecoder
 * JD-Core Version:    0.7.0.1
 */