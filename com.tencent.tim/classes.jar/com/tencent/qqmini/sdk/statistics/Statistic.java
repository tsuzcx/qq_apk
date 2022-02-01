package com.tencent.qqmini.sdk.statistics;

public abstract interface Statistic
{
  public abstract void addSample(float paramFloat);
  
  public abstract float calculate();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.statistics.Statistic
 * JD-Core Version:    0.7.0.1
 */