package com.tencent.ttpic.filter.aifilter;

import com.google.gson.annotations.SerializedName;

public final class FaceRect
{
  @SerializedName("h")
  private final double h;
  @SerializedName("w")
  private final double w;
  @SerializedName("x")
  private final double x;
  @SerializedName("y")
  private final double y;
  
  public FaceRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
    this.w = paramDouble3;
    this.h = paramDouble4;
  }
  
  public final double getH()
  {
    return this.h;
  }
  
  public final double getW()
  {
    return this.w;
  }
  
  public final double getX()
  {
    return this.x;
  }
  
  public final double getY()
  {
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FaceRect
 * JD-Core Version:    0.7.0.1
 */