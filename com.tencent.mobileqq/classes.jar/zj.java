import com.google.zxing.common.reedsolomon.GenericGF;

public final class zj
{
  private final GenericGF jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  public zj(GenericGF paramGenericGF, int[] paramArrayOfInt)
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
  
  int a()
  {
    return this.jdField_a_of_type_ArrayOfInt.length - 1;
  }
  
  int a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1 - paramInt)];
  }
  
  public zj a(int paramInt1, int paramInt2)
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
    return new zj(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
  }
  
  zj a(zj paramzj)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramzj.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramzj;
    }
    if (paramzj.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramzj.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramzj = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramzj.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = GenericGF.a(paramzj[(i - j)], localObject[i]);
        i += 1;
      }
      return new zj(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
      paramzj = (zj)localObject;
      localObject = arrayOfInt;
    }
  }
  
  boolean a()
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
  
  public zj[] a(zj paramzj)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramzj.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramzj.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    zj localzj2 = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    int i = paramzj.a(paramzj.a());
    i = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.c(i);
    zj localzj3;
    for (zj localzj1 = this; (localzj1.a() >= paramzj.a()) && (!localzj1.a()); localzj1 = localzj1.a(localzj3))
    {
      int j = localzj1.a() - paramzj.a();
      int k = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(localzj1.a(localzj1.a()), i);
      localzj3 = paramzj.a(j, k);
      localzj2 = localzj2.a(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a(j, k));
    }
    return new zj[] { localzj2, localzj1 };
  }
  
  public zj b(zj paramzj)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramzj.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramzj.a())) {
      return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt1.length;
    paramzj = paramzj.jdField_a_of_type_ArrayOfInt;
    int m = paramzj.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = GenericGF.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(n, paramzj[j]));
        j += 1;
      }
      i += 1;
    }
    return new zj(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zj
 * JD-Core Version:    0.7.0.1
 */