package com.tencent.jni;

public class LiveRectInfo
{
  int mHeight;
  int mWidth;
  int mX;
  int mY;
  
  public int height()
  {
    return this.mHeight;
  }
  
  public void reset()
  {
    this.mX = 0;
    this.mY = 0;
    this.mWidth = 0;
    this.mHeight = 0;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public void setX(int paramInt)
  {
    this.mX = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.mY = paramInt;
  }
  
  public int width()
  {
    return this.mWidth;
  }
  
  public int x()
  {
    return this.mX;
  }
  
  public int y()
  {
    return this.mY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.jni.LiveRectInfo
 * JD-Core Version:    0.7.0.1
 */