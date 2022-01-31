package com.tencent.mobileqq.util;

public class FetchInfoReq
{
  public static final int a = 1;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 4;
  public Object a;
  public String a;
  public String b;
  public int g;
  
  public FetchInfoReq() {}
  
  public FetchInfoReq(int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    this.g = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    this.g = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public boolean a()
  {
    if ((this.g < 1) || (this.g > 4)) {}
    while ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim())) || ((this.g == 3) && ((this.b == null) || ("".equals(this.b))) && ((this.jdField_a_of_type_JavaLangObject == null) || ("".equals(this.jdField_a_of_type_JavaLangObject))))) {
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof FetchInfoReq))
    {
      paramObject = (FetchInfoReq)paramObject;
      if ((paramObject.g == this.g) && (Utils.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && ((3 != this.g) || ((Utils.a(this.b, paramObject.b)) && (Utils.a(this.jdField_a_of_type_JavaLangObject, paramObject.jdField_a_of_type_JavaLangObject))))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.g;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      i = 0;
      if (this.b != null) {
        break label53;
      }
      j = 0;
      label26:
      if (this.jdField_a_of_type_JavaLangObject != null) {
        break label64;
      }
    }
    for (;;)
    {
      return j + (m + i) + k;
      i = this.jdField_a_of_type_JavaLangString.hashCode();
      break;
      label53:
      j = this.b.hashCode();
      break label26;
      label64:
      k = this.jdField_a_of_type_JavaLangObject.hashCode();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[iType = ").append(this.g).append(", strKey = ").append(this.jdField_a_of_type_JavaLangString).append(", strSubKey = ").append(this.b).append(", obj = ").append(this.jdField_a_of_type_JavaLangObject).append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchInfoReq
 * JD-Core Version:    0.7.0.1
 */