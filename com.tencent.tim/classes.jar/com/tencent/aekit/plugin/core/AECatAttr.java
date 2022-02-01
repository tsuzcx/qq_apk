package com.tencent.aekit.plugin.core;

import android.graphics.PointF;
import java.util.List;

public class AECatAttr
{
  public static final int CAT_TRIGGER_TYPE = 700;
  private float[] angles = { 0.0F, 0.0F, 0.0F };
  private List<PointF> catPointList = null;
  private int detectHeight;
  private long detectTime = 0L;
  private int detectWidth;
  
  public float[] getAngles()
  {
    return this.angles;
  }
  
  public List<PointF> getCatPointList()
  {
    return this.catPointList;
  }
  
  public int getDetectHeight()
  {
    return this.detectHeight;
  }
  
  public int getDetectWidth()
  {
    return this.detectWidth;
  }
  
  public void setAngles(float[] paramArrayOfFloat)
  {
    this.angles = paramArrayOfFloat;
  }
  
  public void setCatPointList(List<PointF> paramList)
  {
    this.catPointList = paramList;
  }
  
  public void setDetectHeight(int paramInt)
  {
    this.detectHeight = paramInt;
  }
  
  public void setDetectTime(long paramLong)
  {
    this.detectTime = paramLong;
  }
  
  public void setDetectWidth(int paramInt)
  {
    this.detectWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AECatAttr
 * JD-Core Version:    0.7.0.1
 */