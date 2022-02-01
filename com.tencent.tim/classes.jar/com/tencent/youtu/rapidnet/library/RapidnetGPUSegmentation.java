package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;

public class RapidnetGPUSegmentation
{
  public static int HAIR_GENDER_SWITCH = 1;
  public static int HAIR_SEG_MODEL = 0;
  private long nativePtr;
  
  public native int deinit();
  
  public native Bitmap forward(Bitmap paramBitmap);
  
  public native int forward2(int paramInt1, int paramInt2);
  
  public native Bitmap forwardWithAngle(Bitmap paramBitmap, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int init(String paramString1, String paramString2, int paramInt);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native void setSegGaussianBlurMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.RapidnetGPUSegmentation
 * JD-Core Version:    0.7.0.1
 */