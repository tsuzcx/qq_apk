package com.tencent.token;

public final class atc
{
  public static float a(float paramFloat)
  {
    if (paramFloat <= 0.0031308F) {
      return paramFloat * 12.92F;
    }
    return (float)(Math.pow(paramFloat, 0.416666656732559D) * 1.054999947547913D - 0.05499999970197678D);
  }
  
  public static float b(float paramFloat)
  {
    if (paramFloat <= 0.04045F) {
      return paramFloat / 12.92F;
    }
    return (float)Math.pow((paramFloat + 0.055F) / 1.055F, 2.400000095367432D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atc
 * JD-Core Version:    0.7.0.1
 */