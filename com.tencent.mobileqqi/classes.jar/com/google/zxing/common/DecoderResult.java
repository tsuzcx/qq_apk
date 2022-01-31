package com.google.zxing.common;

import java.util.List;

public final class DecoderResult
{
  private final String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final String b;
  
  public DecoderResult(byte[] paramArrayOfByte, String paramString1, List paramList, String paramString2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.DecoderResult
 * JD-Core Version:    0.7.0.1
 */