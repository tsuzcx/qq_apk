package com.tencent.qqmail.model;

public class ImageSizeInfo
{
  public long highSize;
  public long lowSize;
  public long middleSize;
  public long realSize;
  
  public void reset()
  {
    this.lowSize = 0L;
    this.middleSize = 0L;
    this.highSize = 0L;
    this.realSize = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.ImageSizeInfo
 * JD-Core Version:    0.7.0.1
 */