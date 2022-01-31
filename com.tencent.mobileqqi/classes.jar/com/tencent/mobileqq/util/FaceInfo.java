package com.tencent.mobileqq.util;

import android.text.TextUtils;

public class FaceInfo
{
  public byte a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public byte b;
  public int b;
  public String b;
  public byte c;
  
  public FaceInfo(int paramInt1, String paramString1, boolean paramBoolean, byte paramByte, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = 0;
    if (paramInt1 == 100)
    {
      this.jdField_a_of_type_Int = 1;
      this.c = 1;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (paramInt == 100) {
      return 1 + paramString;
    }
    return paramInt + paramString;
  }
  
  public String a()
  {
    return a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (FaceInfo)paramObject;
    return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString));
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int | this.jdField_a_of_type_JavaLangString.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceInfo
 * JD-Core Version:    0.7.0.1
 */