package com.tencent.qqprotect.singleupdate;

import hum;

public class QPSinlgeUpdInfo
{
  public int a;
  public String a;
  public hum[] a;
  public int b;
  public String b;
  public int c = 0;
  
  public QPSinlgeUpdInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfHum = null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ArrayOfHum = new hum[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.jdField_a_of_type_ArrayOfHum[i] = new hum(this);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSinlgeUpdInfo
 * JD-Core Version:    0.7.0.1
 */