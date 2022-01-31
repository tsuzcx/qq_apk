package com.tencent.mobileqq.pic.compress;

public abstract class PicQuality
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  protected PicType a;
  protected String a;
  
  PicQuality(PicType paramPicType)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_ComTencentMobileqqPicCompressPicType = paramPicType;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2);
  }
  
  abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicQuality
 * JD-Core Version:    0.7.0.1
 */