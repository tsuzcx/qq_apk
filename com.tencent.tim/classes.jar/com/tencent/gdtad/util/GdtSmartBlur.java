package com.tencent.gdtad.util;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import imm;

public class GdtSmartBlur
{
  public boolean isLoaded;
  
  private GdtSmartBlur()
  {
    init();
  }
  
  public static GdtSmartBlur a()
  {
    return a.a;
  }
  
  private native void blurBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  private void init()
  {
    try
    {
      System.loadLibrary("smart-blur");
      this.isLoaded = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtSmartBlur", 1, "load library error", localThrowable);
      this.isLoaded = false;
    }
  }
  
  public void c(Bitmap paramBitmap, int paramInt)
  {
    int j = imm.getNumCores();
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    blurBitmap(paramBitmap, paramInt, i);
  }
  
  static class a
  {
    public static GdtSmartBlur a = new GdtSmartBlur(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtSmartBlur
 * JD-Core Version:    0.7.0.1
 */