package com.microrapid.opencv;

import android.graphics.Bitmap;

public class ImageAutoProcessor
{
  public static ImageStatisticsData getImageStatistics(Bitmap paramBitmap, String paramString)
  {
    return new ImageStatisticsData(nativeGetImageStatistics(paramBitmap, paramString));
  }
  
  public static native void nativeContrastAuto(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native void nativeDenoiseBEEPS(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native double[] nativeGetImageStatistics(Bitmap paramBitmap, String paramString);
  
  public static native void nativeLightnessAuto(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native double nativeTemperatureFromUIColor(String paramString, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.microrapid.opencv.ImageAutoProcessor
 * JD-Core Version:    0.7.0.1
 */