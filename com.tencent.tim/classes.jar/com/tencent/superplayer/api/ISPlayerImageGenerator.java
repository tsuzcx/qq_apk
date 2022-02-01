package com.tencent.superplayer.api;

import android.graphics.Bitmap;

public abstract interface ISPlayerImageGenerator
{
  public abstract void generateImageAsyncAtTime(long paramLong, ImageGeneratorParams paramImageGeneratorParams, Listener paramListener);
  
  public abstract void release();
  
  public static class ImageGeneratorParams
  {
    public int height = 0;
    public long requestedTimeMsToleranceAfter = 0L;
    public long requestedTimeMsToleranceBefore = 0L;
    public int width = 0;
  }
  
  public static abstract interface Listener
  {
    public abstract void onCaptureVideoFailed(int paramInt);
    
    public abstract void onCaptureVideoSuccess(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerImageGenerator
 * JD-Core Version:    0.7.0.1
 */