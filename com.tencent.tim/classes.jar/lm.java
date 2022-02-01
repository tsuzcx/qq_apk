final class lm
{
  private final int[] ah;
  private final ll b;
  
  lm(ll paramll, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.b = paramll;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.ah = paramll.a().ah;
        return;
      }
      this.ah = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.ah, 0, this.ah.length);
      return;
    }
    this.ah = paramArrayOfInt;
  }
  
  int D(int paramInt)
  {
    return this.ah[(this.ah.length - 1 - paramInt)];
  }
  
  lm a(lm paramlm)
  {
    if (!this.b.equals(paramlm.b)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (isZero()) {
      return paramlm;
    }
    if (paramlm.isZero()) {
      return this;
    }
    Object localObject = this.ah;
    int[] arrayOfInt = paramlm.ah;
    if (localObject.length > arrayOfInt.length) {
      paramlm = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramlm.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = ll.j(paramlm[(i - j)], localObject[i]);
        i += 1;
      }
      return new lm(this.b, arrayOfInt);
      paramlm = (lm)localObject;
      localObject = arrayOfInt;
    }
  }
  
  lm[] a(lm paramlm)
  {
    if (!this.b.equals(paramlm.b)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramlm.isZero()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    lm locallm2 = this.b.a();
    int i = paramlm.D(paramlm.getDegree());
    i = this.b.C(i);
    lm locallm3;
    for (lm locallm1 = this; (locallm1.getDegree() >= paramlm.getDegree()) && (!locallm1.isZero()); locallm1 = locallm1.a(locallm3))
    {
      int j = locallm1.getDegree() - paramlm.getDegree();
      int k = this.b.k(locallm1.D(locallm1.getDegree()), i);
      locallm3 = paramlm.b(j, k);
      locallm2 = locallm2.a(this.b.a(j, k));
    }
    return new lm[] { locallm2, locallm1 };
  }
  
  lm b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.b.a();
    }
    int i = this.ah.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.b.k(this.ah[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new lm(this.b, arrayOfInt);
  }
  
  lm b(lm paramlm)
  {
    if (!this.b.equals(paramlm.b)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((isZero()) || (paramlm.isZero())) {
      return this.b.a();
    }
    int[] arrayOfInt1 = this.ah;
    int k = arrayOfInt1.length;
    paramlm = paramlm.ah;
    int m = paramlm.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = ll.j(arrayOfInt2[(i + j)], this.b.k(n, paramlm[j]));
        j += 1;
      }
      i += 1;
    }
    return new lm(this.b, arrayOfInt2);
  }
  
  int[] f()
  {
    return this.ah;
  }
  
  int getDegree()
  {
    return this.ah.length - 1;
  }
  
  boolean isZero()
  {
    boolean bool = false;
    if (this.ah[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getDegree() * 8);
    int i = getDegree();
    if (i >= 0)
    {
      int k = D(i);
      int j;
      if (k != 0)
      {
        if (k >= 0) {
          break label104;
        }
        localStringBuilder.append(" - ");
        j = -k;
        label50:
        if ((i == 0) || (j != 1))
        {
          j = this.b.B(j);
          if (j != 0) {
            break label127;
          }
          localStringBuilder.append('1');
        }
        label80:
        if (i != 0)
        {
          if (i != 1) {
            break label161;
          }
          localStringBuilder.append('x');
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label104:
        j = k;
        if (localStringBuilder.length() <= 0) {
          break label50;
        }
        localStringBuilder.append(" + ");
        j = k;
        break label50;
        label127:
        if (j == 1)
        {
          localStringBuilder.append('a');
          break label80;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(j);
        break label80;
        label161:
        localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lm
 * JD-Core Version:    0.7.0.1
 */