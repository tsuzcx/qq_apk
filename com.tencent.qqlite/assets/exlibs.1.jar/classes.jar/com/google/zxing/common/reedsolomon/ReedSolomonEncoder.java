package com.google.zxing.common.reedsolomon;

import dt;
import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder
{
  private final GenericGF jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF;
  private final List jdField_a_of_type_JavaUtilList;
  
  public ReedSolomonEncoder(GenericGF paramGenericGF)
  {
    if (!GenericGF.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramGenericGF)) {
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    }
    this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF = paramGenericGF;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new dt(paramGenericGF, new int[] { 1 }));
  }
  
  private dt a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      dt localdt = (dt)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
      int i = this.jdField_a_of_type_JavaUtilList.size();
      while (i <= paramInt)
      {
        localdt = localdt.b(new dt(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, new int[] { 1, this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a(i - 1) }));
        this.jdField_a_of_type_JavaUtilList.add(localdt);
        i += 1;
      }
    }
    return (dt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("No error correction bytes");
    }
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0) {
      throw new IllegalArgumentException("No data bytes provided");
    }
    Object localObject = a(paramInt);
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    localObject = new dt(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt).a(paramInt, 1).a(localObject)[1].a();
    int j = paramInt - localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      paramArrayOfInt[(i + paramInt)] = 0;
      paramInt += 1;
    }
    System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonEncoder
 * JD-Core Version:    0.7.0.1
 */