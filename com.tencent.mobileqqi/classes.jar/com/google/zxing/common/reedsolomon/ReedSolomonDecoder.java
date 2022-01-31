package com.google.zxing.common.reedsolomon;

import fh;

public final class ReedSolomonDecoder
{
  private final GenericGF a;
  
  public ReedSolomonDecoder(GenericGF paramGenericGF)
  {
    this.a = paramGenericGF;
  }
  
  private int[] a(fh paramfh)
  {
    int j = 0;
    int i = 1;
    int m = paramfh.a();
    if (m == 1) {
      return new int[] { paramfh.a(1) };
    }
    int[] arrayOfInt = new int[m];
    while ((i < this.a.a()) && (j < m))
    {
      int k = j;
      if (paramfh.b(i) == 0)
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
  
  private int[] a(fh paramfh, int[] paramArrayOfInt, boolean paramBoolean)
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
      arrayOfInt[j] = this.a.b(paramfh.b(i1), this.a.c(i));
      if (paramBoolean) {
        arrayOfInt[j] = this.a.b(arrayOfInt[j], i1);
      }
      j += 1;
      break;
      return arrayOfInt;
    }
  }
  
  private fh[] a(fh paramfh1, fh paramfh2, int paramInt)
  {
    if (paramfh1.a() < paramfh2.a()) {}
    for (;;)
    {
      Object localObject = this.a.a();
      fh localfh1 = this.a.b();
      while (paramfh1.a() >= paramInt / 2)
      {
        if (paramfh1.a()) {
          throw new ReedSolomonException("r_{i-1} was zero");
        }
        fh localfh2 = this.a.a();
        int i = paramfh1.a(paramfh1.a());
        i = this.a.c(i);
        while ((paramfh2.a() >= paramfh1.a()) && (!paramfh2.a()))
        {
          int j = paramfh2.a() - paramfh1.a();
          int k = this.a.b(paramfh2.a(paramfh2.a()), i);
          localfh2 = localfh2.a(this.a.a(j, k));
          paramfh2 = paramfh2.a(paramfh1.a(j, k));
        }
        localObject = localfh2.b(localfh1).a((fh)localObject);
        localfh2 = paramfh1;
        paramfh1 = paramfh2;
        paramfh2 = (fh)localObject;
        localObject = localfh1;
        localfh1 = paramfh2;
        paramfh2 = localfh2;
      }
      paramInt = localfh1.a(0);
      if (paramInt == 0) {
        throw new ReedSolomonException("sigmaTilde(0) was zero");
      }
      paramInt = this.a.c(paramInt);
      return new fh[] { localfh1.a(paramInt), paramfh1.a(paramInt) };
      localfh1 = paramfh1;
      paramfh1 = paramfh2;
      paramfh2 = localfh1;
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    int m = 0;
    Object localObject1 = new fh(this.a, paramArrayOfInt);
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
        k = ((fh)localObject1).b(localGenericGF.a(k));
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
        localObject1 = new fh(this.a, (int[])localObject2);
        localObject2 = a(this.a.a(paramInt, 1), (fh)localObject1, paramInt);
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        localObject1 = a((fh)localObject1);
        localObject2 = a((fh)localObject2, (int[])localObject1, bool);
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