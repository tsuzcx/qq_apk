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
  public boolean b;
  public byte c;
  public int c;
  public int d;
  
  public FaceInfo(int paramInt1, String paramString1, boolean paramBoolean1, byte paramByte, int paramInt2, String paramString2, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.jdField_c_of_type_Byte = 0;
    if (paramInt1 == 100)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_c_of_type_Byte = 1;
    }
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 100) {
      return 1 + paramString;
    }
    if (paramInt1 == 32) {
      return paramInt1 + "" + paramInt2 + paramString;
    }
    return paramInt1 + paramString;
  }
  
  public String a()
  {
    return a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceInfo
 * JD-Core Version:    0.7.0.1
 */