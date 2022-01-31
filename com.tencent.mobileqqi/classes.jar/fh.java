import com.google.zxing.common.reedsolomon.GenericGF;

public final class fh
{
  private final GenericGF jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  public fh(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF = paramGenericGF;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.jdField_a_of_type_ArrayOfInt = paramGenericGF.a().jdField_a_of_type_ArrayOfInt;
        return;
      }
      this.jdField_a_of_type_ArrayOfInt = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
      return;
    }
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfInt.length - 1;
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1 - paramInt)];
  }
  
  public fh a(int paramInt)
  {
    if (paramInt == 0) {
      localObject = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
    do
    {
      return localObject;
      localObject = this;
    } while (paramInt == 1);
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    Object localObject = new int[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(this.jdField_a_of_type_ArrayOfInt[i], paramInt);
      i += 1;
    }
    return new fh(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, (int[])localObject);
  }
  
  public fh a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
    int i = this.jdField_a_of_type_ArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(this.jdField_a_of_type_ArrayOfInt[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new fh(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
  }
  
  public fh a(fh paramfh)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramfh.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramfh;
    }
    if (paramfh.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramfh.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramfh = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramfh.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = GenericGF.a(paramfh[(i - j)], localObject[i]);
        i += 1;
      }
      return new fh(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
      paramfh = (fh)localObject;
      localObject = arrayOfInt;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ArrayOfInt[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public fh[] a(fh paramfh)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramfh.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramfh.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    fh localfh2 = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    int i = paramfh.a(paramfh.a());
    i = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.c(i);
    fh localfh3;
    for (fh localfh1 = this; (localfh1.a() >= paramfh.a()) && (!localfh1.a()); localfh1 = localfh1.a(localfh3))
    {
      int j = localfh1.a() - paramfh.a();
      int k = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(localfh1.a(localfh1.a()), i);
      localfh3 = paramfh.a(j, k);
      localfh2 = localfh2.a(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a(j, k));
    }
    return new fh[] { localfh2, localfh1 };
  }
  
  public int b(int paramInt)
  {
    int j = 0;
    int i;
    if (paramInt == 0)
    {
      i = a(0);
      return i;
    }
    int m = this.jdField_a_of_type_ArrayOfInt.length;
    if (paramInt == 1)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      k = arrayOfInt.length;
      paramInt = 0;
      for (;;)
      {
        i = paramInt;
        if (j >= k) {
          break;
        }
        paramInt = GenericGF.a(paramInt, arrayOfInt[j]);
        j += 1;
      }
    }
    j = this.jdField_a_of_type_ArrayOfInt[0];
    int k = 1;
    for (;;)
    {
      i = j;
      if (k >= m) {
        break;
      }
      j = GenericGF.a(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(paramInt, j), this.jdField_a_of_type_ArrayOfInt[k]);
      k += 1;
    }
  }
  
  public fh b(fh paramfh)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramfh.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramfh.a())) {
      return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt1.length;
    paramfh = paramfh.jdField_a_of_type_ArrayOfInt;
    int m = paramfh.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = GenericGF.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(n, paramfh[j]));
        j += 1;
      }
      i += 1;
    }
    return new fh(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(a() * 8);
    int i = a();
    if (i >= 0)
    {
      int k = a(i);
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
          j = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fh
 * JD-Core Version:    0.7.0.1
 */