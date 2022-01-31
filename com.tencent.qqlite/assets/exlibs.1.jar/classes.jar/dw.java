import com.google.zxing.common.reedsolomon.GenericGF;

public final class dw
{
  private final GenericGF jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  public dw(GenericGF paramGenericGF, int[] paramArrayOfInt)
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
  
  public dw a(int paramInt1, int paramInt2)
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
    return new dw(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
  }
  
  dw a(dw paramdw)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramdw.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramdw;
    }
    if (paramdw.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramdw.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramdw = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramdw.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = GenericGF.a(paramdw[(i - j)], localObject[i]);
        i += 1;
      }
      return new dw(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
      paramdw = (dw)localObject;
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
  
  public dw[] a(dw paramdw)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramdw.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramdw.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    dw localdw2 = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    int i = paramdw.a(paramdw.a());
    i = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.c(i);
    dw localdw3;
    for (dw localdw1 = this; (localdw1.a() >= paramdw.a()) && (!localdw1.a()); localdw1 = localdw1.a(localdw3))
    {
      int j = localdw1.a() - paramdw.a();
      int k = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(localdw1.a(localdw1.a()), i);
      localdw3 = paramdw.a(j, k);
      localdw2 = localdw2.a(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a(j, k));
    }
    return new dw[] { localdw2, localdw1 };
  }
  
  public dw b(dw paramdw)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramdw.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramdw.a())) {
      return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt1.length;
    paramdw = paramdw.jdField_a_of_type_ArrayOfInt;
    int m = paramdw.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = GenericGF.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(n, paramdw[j]));
        j += 1;
      }
      i += 1;
    }
    return new dw(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dw
 * JD-Core Version:    0.7.0.1
 */