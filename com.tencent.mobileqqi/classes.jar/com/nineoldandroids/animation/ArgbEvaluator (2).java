package com.nineoldandroids.animation;

public class ArgbEvaluator
  implements TypeEvaluator
{
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    int m = ((Integer)paramObject1).intValue();
    int i = m >> 24;
    int j = m >> 16 & 0xFF;
    int k = m >> 8 & 0xFF;
    m &= 0xFF;
    int n = ((Integer)paramObject2).intValue();
    return Integer.valueOf((int)(((n >> 24) - i) * paramFloat) + i << 24 | (int)(((n >> 16 & 0xFF) - j) * paramFloat) + j << 16 | (int)(((n >> 8 & 0xFF) - k) * paramFloat) + k << 8 | (int)(((n & 0xFF) - m) * paramFloat) + m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.nineoldandroids.animation.ArgbEvaluator
 * JD-Core Version:    0.7.0.1
 */