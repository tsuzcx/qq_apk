package com.tencent.ttpic.filter;

import java.util.Arrays;

public class StrokeModel
{
  private String sid;
  private float[] strokeColor;
  private float strokeGap;
  private int strokeType;
  private float strokeWidth;
  
  public StrokeModel(StrokeInfo paramStrokeInfo)
  {
    this(paramStrokeInfo.name(), paramStrokeInfo.getStrokeType(), paramStrokeInfo.getStrokeWidth(), paramStrokeInfo.getStrokeGap(), paramStrokeInfo.getStrokeColor());
  }
  
  public StrokeModel(String paramString)
  {
    this(paramString, 0, 0.0F, 0.0F, new float[0]);
  }
  
  public StrokeModel(String paramString, int paramInt, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    this.sid = paramString;
    this.strokeType = paramInt;
    this.strokeWidth = paramFloat1;
    this.strokeGap = paramFloat2;
    this.strokeColor = paramArrayOfFloat;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof StrokeModel)) {
        paramObject = (StrokeModel)paramObject;
      }
    }
    else {
      return (this.sid.equals(paramObject.sid)) && (this.strokeType == paramObject.strokeType) && (Float.compare(this.strokeWidth, paramObject.strokeWidth) == 0) && (Float.compare(this.strokeGap, paramObject.strokeGap) == 0) && (Arrays.equals(this.strokeColor, paramObject.strokeColor));
    }
    return false;
  }
  
  public String getSid()
  {
    return this.sid;
  }
  
  public float[] getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public float getStrokeGap()
  {
    return this.strokeGap;
  }
  
  public int getStrokeType()
  {
    return this.strokeType;
  }
  
  public float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.sid;
    if (localObject != null) {}
    for (int i = ((String)localObject).hashCode();; i = 0)
    {
      int k = this.strokeType;
      int m = Float.floatToIntBits(this.strokeWidth);
      int n = Float.floatToIntBits(this.strokeGap);
      localObject = this.strokeColor;
      if (localObject != null) {
        j = Arrays.hashCode((float[])localObject);
      }
      return (((i * 31 + k) * 31 + m) * 31 + n) * 31 + j;
    }
  }
  
  public void setSid(String paramString)
  {
    this.sid = paramString;
  }
  
  public void setStrokeColor(float[] paramArrayOfFloat)
  {
    this.strokeColor = paramArrayOfFloat;
  }
  
  public void setStrokeGap(float paramFloat)
  {
    this.strokeGap = paramFloat;
  }
  
  public void setStrokeType(int paramInt)
  {
    this.strokeType = paramInt;
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.strokeWidth = paramFloat;
  }
  
  public String toString()
  {
    return "StrokeModel(sid=" + this.sid + ", strokeType=" + this.strokeType + ", strokeWidth=" + this.strokeWidth + ", strokeGap=" + this.strokeGap + ", strokeColor=" + Arrays.toString(this.strokeColor) + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.StrokeModel
 * JD-Core Version:    0.7.0.1
 */