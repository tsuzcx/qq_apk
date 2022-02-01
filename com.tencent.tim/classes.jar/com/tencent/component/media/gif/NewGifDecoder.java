package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public abstract interface NewGifDecoder
{
  public abstract void changeFile(String paramString);
  
  public abstract GifFrame doRender(Bitmap paramBitmap);
  
  public abstract Bitmap.Config getAcceptableConfig();
  
  public abstract long getAllocationByteCount();
  
  public abstract String getComment();
  
  public abstract int getCurrentFrameIndex();
  
  public abstract int getCurrentLoop();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getError();
  
  public abstract int getFrameCount();
  
  public abstract int getFrameDuration(int paramInt);
  
  public abstract int getHeight();
  
  public abstract int getImageCount();
  
  public abstract int getLoopCount();
  
  public abstract long getSourceLength();
  
  public abstract int getWidth();
  
  public abstract boolean isAnimationCompleted();
  
  public abstract boolean isRecycled();
  
  public abstract GifFrame next(Bitmap paramBitmap);
  
  public abstract GifFrame nextForGifPlay(Bitmap paramBitmap, boolean paramBoolean);
  
  public abstract void prepareData();
  
  public abstract void recycle();
  
  public abstract boolean reset();
  
  public abstract Bitmap seekToFrame(int paramInt, Bitmap paramBitmap);
  
  public abstract GifFrame seekToFrameGetTime(int paramInt, Bitmap paramBitmap);
  
  public abstract Bitmap seekToTime(int paramInt, Bitmap paramBitmap);
  
  public abstract void setGifInfoHandler(GifInfoHandle paramGifInfoHandle);
  
  public abstract void setLoopCount(int paramInt);
  
  public abstract void setSpeed(float paramFloat);
  
  public abstract long start();
  
  public abstract void stop();
  
  public abstract void updateFile(String paramString);
  
  public static class GifFrame
  {
    public long delay;
    public Bitmap image;
    
    public GifFrame(Bitmap paramBitmap, long paramLong)
    {
      this.image = paramBitmap;
      this.delay = paramLong;
    }
  }
  
  public static class Options
  {
    public int inPreferHeight = 0;
    public int inPreferWidth = 0;
    public Bitmap.Config inPreferredConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDecoder
 * JD-Core Version:    0.7.0.1
 */