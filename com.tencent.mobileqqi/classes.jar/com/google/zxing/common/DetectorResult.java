package com.google.zxing.common;

import com.google.zxing.ResultPoint;

public class DetectorResult
{
  private final BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  private final ResultPoint[] jdField_a_of_type_ArrayOfComGoogleZxingResultPoint;
  
  public DetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint)
  {
    this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramBitMatrix;
    this.jdField_a_of_type_ArrayOfComGoogleZxingResultPoint = paramArrayOfResultPoint;
  }
  
  public final BitMatrix a()
  {
    return this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  }
  
  public final ResultPoint[] a()
  {
    return this.jdField_a_of_type_ArrayOfComGoogleZxingResultPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.DetectorResult
 * JD-Core Version:    0.7.0.1
 */