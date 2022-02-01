package com.tencent.image;

import android.graphics.Bitmap;

public class RoundRectBitmap
{
  public final Bitmap mBitmap;
  public final int mBoardColor;
  public final float mBorderWidth;
  public final float mCornerRadius;
  public int mDisplayHeight;
  public int mDisplayWidth;
  
  public RoundRectBitmap(Bitmap paramBitmap, float paramFloat)
  {
    this(paramBitmap, paramFloat, -16777216, 0.0F);
  }
  
  public RoundRectBitmap(Bitmap paramBitmap, float paramFloat1, int paramInt, float paramFloat2)
  {
    this.mBitmap = paramBitmap;
    this.mCornerRadius = paramFloat1;
    this.mBoardColor = paramInt;
    this.mBorderWidth = paramFloat2;
  }
  
  public int getByteSize()
  {
    return Utils.getBitmapSize(this.mBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.RoundRectBitmap
 * JD-Core Version:    0.7.0.1
 */