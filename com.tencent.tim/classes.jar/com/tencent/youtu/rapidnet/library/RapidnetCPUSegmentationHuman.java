package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;

public class RapidnetCPUSegmentationHuman
{
  private long nativePtr;
  
  public native int deinit();
  
  public native Bitmap forward(Bitmap paramBitmap);
  
  public native Bitmap forwardWithAngle(Bitmap paramBitmap, int paramInt);
  
  public native Bitmap forwardWithBox(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native float[] getHairSegMaskBox(Bitmap paramBitmap);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native void hairSegSetIntervalFrames(int paramInt);
  
  public native void hairSegSetMode(int paramInt);
  
  public native int init(String paramString1, String paramString2);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native void setSegGaussianBlurMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.RapidnetCPUSegmentationHuman
 * JD-Core Version:    0.7.0.1
 */