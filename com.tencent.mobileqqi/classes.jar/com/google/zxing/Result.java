package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class Result
{
  private final long jdField_a_of_type_Long;
  private final BarcodeFormat jdField_a_of_type_ComGoogleZxingBarcodeFormat;
  private final String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private ResultPoint[] jdField_a_of_type_ArrayOfComGoogleZxingResultPoint;
  
  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat)
  {
    this(paramString, paramArrayOfByte, paramArrayOfResultPoint, paramBarcodeFormat, System.currentTimeMillis());
  }
  
  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ArrayOfComGoogleZxingResultPoint = paramArrayOfResultPoint;
    this.jdField_a_of_type_ComGoogleZxingBarcodeFormat = paramBarcodeFormat;
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public BarcodeFormat a()
  {
    return this.jdField_a_of_type_ComGoogleZxingBarcodeFormat;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(ResultMetadataType paramResultMetadataType, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new EnumMap(ResultMetadataType.class);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramResultMetadataType, paramObject);
  }
  
  public void a(Map paramMap)
  {
    if (paramMap != null)
    {
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = paramMap;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
  }
  
  public void a(ResultPoint[] paramArrayOfResultPoint)
  {
    ResultPoint[] arrayOfResultPoint1 = this.jdField_a_of_type_ArrayOfComGoogleZxingResultPoint;
    if (arrayOfResultPoint1 == null) {
      this.jdField_a_of_type_ArrayOfComGoogleZxingResultPoint = paramArrayOfResultPoint;
    }
    while ((paramArrayOfResultPoint == null) || (paramArrayOfResultPoint.length <= 0)) {
      return;
    }
    ResultPoint[] arrayOfResultPoint2 = new ResultPoint[arrayOfResultPoint1.length + paramArrayOfResultPoint.length];
    System.arraycopy(arrayOfResultPoint1, 0, arrayOfResultPoint2, 0, arrayOfResultPoint1.length);
    System.arraycopy(paramArrayOfResultPoint, 0, arrayOfResultPoint2, arrayOfResultPoint1.length, paramArrayOfResultPoint.length);
    this.jdField_a_of_type_ArrayOfComGoogleZxingResultPoint = arrayOfResultPoint2;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public ResultPoint[] a()
  {
    return this.jdField_a_of_type_ArrayOfComGoogleZxingResultPoint;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.Result
 * JD-Core Version:    0.7.0.1
 */