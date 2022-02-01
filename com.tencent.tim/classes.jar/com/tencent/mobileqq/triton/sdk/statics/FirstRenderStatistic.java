package com.tencent.mobileqq.triton.sdk.statics;

public class FirstRenderStatistic
{
  public final long drawCallCount;
  public final long firstRenderTimeMs;
  
  public FirstRenderStatistic(long paramLong1, long paramLong2)
  {
    this.firstRenderTimeMs = paramLong1;
    this.drawCallCount = paramLong2;
  }
  
  public String toString()
  {
    return "FirstRenderStatics{firstRenderTimeMs=" + this.firstRenderTimeMs + ", drawCallCount=" + this.drawCallCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.statics.FirstRenderStatistic
 * JD-Core Version:    0.7.0.1
 */