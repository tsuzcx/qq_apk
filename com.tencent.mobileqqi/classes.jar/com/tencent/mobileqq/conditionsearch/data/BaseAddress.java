package com.tencent.mobileqq.conditionsearch.data;

import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BaseAddress
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public String a;
  public LinkedHashMap a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public int e;
  
  public BaseAddress(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.e = paramInt;
    if (paramInt == 0)
    {
      this.jdField_c_of_type_JavaLangString = ChnToSpell.a(paramString1, 1);
      this.d = String.valueOf(this.jdField_c_of_type_JavaLangString.charAt(0)).toUpperCase();
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(15);
  }
  
  public int a()
  {
    int j = 0;
    if (this.jdField_a_of_type_Boolean) {
      j = 1;
    }
    int i = j;
    if (this.jdField_b_of_type_Boolean) {
      i = j + 1;
    }
    j = i;
    if (this.jdField_c_of_type_Boolean) {
      j = i + 1;
    }
    return j;
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
      return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.values());
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null) {
      return ((BaseAddress)paramObject).jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_b_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.BaseAddress
 * JD-Core Version:    0.7.0.1
 */