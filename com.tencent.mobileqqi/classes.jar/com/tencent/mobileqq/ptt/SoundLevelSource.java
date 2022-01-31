package com.tencent.mobileqq.ptt;

import android.util.Log;

public class SoundLevelSource
{
  private static final String jdField_a_of_type_JavaLangString = "SoundLevelSource";
  private float jdField_a_of_type_Float = 75.0F;
  private volatile int jdField_a_of_type_Int = 0;
  
  private int a(float paramFloat)
  {
    int j = (int)(100.0F * (Math.min(Math.max(paramFloat, -2.0F), 10.0F) + 2.0F) / 12.0F);
    int i = 0;
    if (j >= 30) {
      i = j / 10 * 10;
    }
    Log.v("SoundLevelSource", "RmsDb:" + paramFloat + "-->Volume:" + i);
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    a(-1);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float < paramFloat) {}
    for (this.jdField_a_of_type_Float = (0.999F * this.jdField_a_of_type_Float + 0.001F * paramFloat);; this.jdField_a_of_type_Float = (0.95F * this.jdField_a_of_type_Float + 0.05F * paramFloat))
    {
      float f2 = -120.0F;
      float f1 = f2;
      if (this.jdField_a_of_type_Float > 0.0D)
      {
        f1 = f2;
        if (paramFloat / this.jdField_a_of_type_Float > 1.0E-006D) {
          f1 = 10.0F * (float)Math.log10(paramFloat / this.jdField_a_of_type_Float);
        }
      }
      a(a(f1));
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (((paramInt >= 0) && (paramInt <= 100)) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.SoundLevelSource
 * JD-Core Version:    0.7.0.1
 */