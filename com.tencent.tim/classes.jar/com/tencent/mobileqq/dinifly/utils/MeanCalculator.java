package com.tencent.mobileqq.dinifly.utils;

public class MeanCalculator
{
  private int n;
  private float sum;
  
  public void add(float paramFloat)
  {
    this.sum += paramFloat;
    this.n += 1;
    if (this.n == 2147483647)
    {
      this.sum /= 2.0F;
      this.n /= 2;
    }
  }
  
  public float getMean()
  {
    if (this.n == 0) {
      return 0.0F;
    }
    return this.sum / this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.MeanCalculator
 * JD-Core Version:    0.7.0.1
 */