package com.tencent.mobileqq.maproam.data;

public class LocationDetail
  implements Cloneable
{
  public double a;
  public String a;
  public double b;
  public String b;
  public String c = "";
  public String d = "";
  
  public LocationDetail()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.data.LocationDetail
 * JD-Core Version:    0.7.0.1
 */