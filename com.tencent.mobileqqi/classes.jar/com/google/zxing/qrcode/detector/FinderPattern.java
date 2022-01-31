package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern
  extends ResultPoint
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramFloat1, paramFloat2, paramFloat3, 1);
  }
  
  private FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  FinderPattern a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = this.jdField_a_of_type_Int + 1;
    return new FinderPattern((this.jdField_a_of_type_Int * a() + paramFloat2) / i, (this.jdField_a_of_type_Int * b() + paramFloat1) / i, (this.jdField_a_of_type_Int * this.jdField_a_of_type_Float + paramFloat3) / i, i);
  }
  
  void a()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramFloat2 - b()) <= paramFloat1)
    {
      bool1 = bool2;
      if (Math.abs(paramFloat3 - a()) <= paramFloat1)
      {
        paramFloat1 = Math.abs(paramFloat1 - this.jdField_a_of_type_Float);
        if (paramFloat1 > 1.0F)
        {
          bool1 = bool2;
          if (paramFloat1 > this.jdField_a_of_type_Float) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public float c()
  {
    return this.jdField_a_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPattern
 * JD-Core Version:    0.7.0.1
 */