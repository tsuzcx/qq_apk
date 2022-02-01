package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;

public class TNNStyleChild
{
  private long nativePtr;
  
  public native int addInitMat(Bitmap paramBitmap, boolean paramBoolean);
  
  public native int addPostMat(Bitmap paramBitmap, boolean paramBoolean);
  
  public native int addPreMat(Bitmap paramBitmap, boolean paramBoolean);
  
  public native float[] computeFaceCropTransform(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, float paramFloat, int paramInt2, int paramInt3);
  
  public native int convertBitmapToFloat(Bitmap paramBitmap, float[] paramArrayOfFloat);
  
  public native Bitmap convertFloatToBitmap(float[] paramArrayOfFloat);
  
  public native int deinit();
  
  public native Bitmap forward(Bitmap paramBitmap);
  
  public native int forward2(int paramInt1, int paramInt2);
  
  public native int forwardTwoOutput();
  
  public native Bitmap forwardWithAngle(Bitmap paramBitmap, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int init(String paramString1, String paramString2, String paramString3);
  
  public native int initProcess();
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native int setParams(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.TNNStyleChild
 * JD-Core Version:    0.7.0.1
 */