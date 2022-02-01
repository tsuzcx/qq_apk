package com.tencent.ttpic.openapi.model;

public class FaceActionCounter
{
  public int count;
  public long updateTime;
  
  public FaceActionCounter(int paramInt, long paramLong)
  {
    this.count = paramInt;
    this.updateTime = paramLong;
  }
  
  public void clear()
  {
    this.count = 0;
    this.updateTime = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceActionCounter
 * JD-Core Version:    0.7.0.1
 */