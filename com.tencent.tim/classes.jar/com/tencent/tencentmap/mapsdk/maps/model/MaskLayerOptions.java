package com.tencent.tencentmap.mapsdk.maps.model;

public class MaskLayerOptions
{
  private int a = 0;
  private long b = 0L;
  private int c = 0;
  
  public MaskLayerOptions animationDuration(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public MaskLayerOptions color(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public long getAnimationDuration()
  {
    return this.b;
  }
  
  public int getColor()
  {
    return this.a;
  }
  
  public int getZIndex()
  {
    return this.c;
  }
  
  public MaskLayerOptions zIndex(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MaskLayerOptions
 * JD-Core Version:    0.7.0.1
 */