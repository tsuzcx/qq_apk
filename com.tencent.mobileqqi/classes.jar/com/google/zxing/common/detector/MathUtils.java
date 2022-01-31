package com.google.zxing.common.detector;

public final class MathUtils
{
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 -= paramInt3;
    paramInt2 -= paramInt4;
    return (float)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
  }
  
  public static int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.detector.MathUtils
 * JD-Core Version:    0.7.0.1
 */