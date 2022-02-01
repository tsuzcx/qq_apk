package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class TroopNativeUtils
{
  public boolean isLoaded;
  
  private TroopNativeUtils()
  {
    init();
  }
  
  protected native void blurBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  protected native void doBlur(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public void init()
  {
    try
    {
      System.loadLibrary("qq_troop");
      this.isLoaded = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopNativeUtils", 2, "load library error", localThrowable);
      }
      this.isLoaded = false;
    }
  }
  
  public native void yuv420spToArgb(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNativeUtils
 * JD-Core Version:    0.7.0.1
 */