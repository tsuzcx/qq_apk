package com.tencent.mobileqq.shortvideo.mtveffects;

public class RandomTime
{
  public long mEndPos = -1L;
  public boolean mLoop = true;
  public long mStartPos = -1L;
  
  public RandomTime() {}
  
  public RandomTime(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  public boolean isLoop()
  {
    return this.mLoop;
  }
  
  public void reset()
  {
    this.mStartPos = -1L;
    this.mEndPos = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.RandomTime
 * JD-Core Version:    0.7.0.1
 */