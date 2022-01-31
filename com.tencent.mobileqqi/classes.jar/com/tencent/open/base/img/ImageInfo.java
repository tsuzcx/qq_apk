package com.tencent.open.base.img;

public class ImageInfo
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  
  public ImageInfo()
  {
    this.jdField_a_of_type_Long = 259200L;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ImageInfo)paramObject;
    if (paramObject != null) {
      return paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.img.ImageInfo
 * JD-Core Version:    0.7.0.1
 */