package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public final class BinaryBitmap
{
  private final Binarizer jdField_a_of_type_ComGoogleZxingBinarizer;
  private BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  
  public BinaryBitmap(Binarizer paramBinarizer)
  {
    if (paramBinarizer == null) {
      throw new IllegalArgumentException("Binarizer must be non-null.");
    }
    this.jdField_a_of_type_ComGoogleZxingBinarizer = paramBinarizer;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComGoogleZxingBinarizer.a();
  }
  
  public BinaryBitmap a()
  {
    LuminanceSource localLuminanceSource = this.jdField_a_of_type_ComGoogleZxingBinarizer.a().a();
    return new BinaryBitmap(this.jdField_a_of_type_ComGoogleZxingBinarizer.a(localLuminanceSource));
  }
  
  public BinaryBitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LuminanceSource localLuminanceSource = this.jdField_a_of_type_ComGoogleZxingBinarizer.a().a(paramInt1, paramInt2, paramInt3, paramInt4);
    return new BinaryBitmap(this.jdField_a_of_type_ComGoogleZxingBinarizer.a(localLuminanceSource));
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray)
  {
    return this.jdField_a_of_type_ComGoogleZxingBinarizer.a(paramInt, paramBitArray);
  }
  
  public BitMatrix a()
  {
    if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
      this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = this.jdField_a_of_type_ComGoogleZxingBinarizer.a();
    }
    return this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComGoogleZxingBinarizer.a().a();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComGoogleZxingBinarizer.b();
  }
  
  public BinaryBitmap b()
  {
    LuminanceSource localLuminanceSource = this.jdField_a_of_type_ComGoogleZxingBinarizer.a().b();
    return new BinaryBitmap(this.jdField_a_of_type_ComGoogleZxingBinarizer.a(localLuminanceSource));
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComGoogleZxingBinarizer.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.BinaryBitmap
 * JD-Core Version:    0.7.0.1
 */