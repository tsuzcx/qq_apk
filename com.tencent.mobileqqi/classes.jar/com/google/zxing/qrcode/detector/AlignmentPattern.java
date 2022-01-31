package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern
  extends ResultPoint
{
  private final float a;
  
  public AlignmentPattern(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
  }
  
  public AlignmentPattern a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new AlignmentPattern((a() + paramFloat2) / 2.0F, (b() + paramFloat1) / 2.0F, (this.a + paramFloat3) / 2.0F);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramFloat2 - b()) <= paramFloat1)
    {
      bool1 = bool2;
      if (Math.abs(paramFloat3 - a()) <= paramFloat1)
      {
        paramFloat1 = Math.abs(paramFloat1 - this.a);
        if (paramFloat1 > 1.0F)
        {
          bool1 = bool2;
          if (paramFloat1 > this.a) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.AlignmentPattern
 * JD-Core Version:    0.7.0.1
 */