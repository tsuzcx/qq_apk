package com.tencent.ttpic.openapi;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

public class PTHairAttr
{
  private int faceBright;
  private int hairBright;
  private PointF[] hairRect;
  private Bitmap maskBitmap;
  private Frame maskFrame;
  private PointF[] maskYYAnchor;
  private float materialCrop;
  
  public int getFaceBright()
  {
    return this.faceBright;
  }
  
  public int getHairBright()
  {
    return this.hairBright;
  }
  
  public PointF[] getHairRect()
  {
    return this.hairRect;
  }
  
  public Bitmap getMaskBitmap()
  {
    return this.maskBitmap;
  }
  
  public Frame getMaskFrame()
  {
    return this.maskFrame;
  }
  
  public PointF[] getMaskYYAnchor()
  {
    return this.maskYYAnchor;
  }
  
  public float getMaterialCrop()
  {
    return this.materialCrop;
  }
  
  public boolean isReady()
  {
    return BitmapUtils.isLegal(this.maskBitmap);
  }
  
  public void setFaceBright(int paramInt)
  {
    this.faceBright = paramInt;
  }
  
  public void setHairBright(int paramInt)
  {
    this.hairBright = paramInt;
  }
  
  public void setHairRect(PointF[] paramArrayOfPointF)
  {
    this.hairRect = paramArrayOfPointF;
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    this.maskBitmap = paramBitmap;
  }
  
  public void setMaskFrame(Frame paramFrame)
  {
    this.maskFrame = paramFrame;
  }
  
  public void setMaskYYAnchor(PointF[] paramArrayOfPointF)
  {
    this.maskYYAnchor = paramArrayOfPointF;
  }
  
  public void setMaterialCrop(float paramFloat)
  {
    this.materialCrop = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTHairAttr
 * JD-Core Version:    0.7.0.1
 */