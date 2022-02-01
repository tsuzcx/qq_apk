package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class GenericNewGifDecoder
  implements NewGifDecoder
{
  private static final String TAG = "GenericNewGifDecoder";
  private NewGifDecoder.GifFrame mCurFrame;
  private GifInfoHandle mNativeInfoHandle;
  
  public GenericNewGifDecoder(GifInfoHandle paramGifInfoHandle)
  {
    this.mNativeInfoHandle = paramGifInfoHandle;
  }
  
  public void changeFile(String paramString)
  {
    this.mNativeInfoHandle.changeFile(paramString);
  }
  
  public NewGifDecoder.GifFrame doRender(Bitmap paramBitmap)
  {
    try
    {
      this.mCurFrame = new NewGifDecoder.GifFrame(paramBitmap, this.mNativeInfoHandle.doRender(paramBitmap));
      NewGifDecoder.GifFrame localGifFrame = this.mCurFrame;
      return localGifFrame;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("GenericNewGifDecoder", new Object[] { "catch an exception:", Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return new NewGifDecoder.GifFrame(paramBitmap, -1L);
  }
  
  public Bitmap.Config getAcceptableConfig()
  {
    int i = this.mNativeInfoHandle.getPreferConfig();
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    switch (i)
    {
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    default: 
      localConfig = Bitmap.Config.ARGB_8888;
    }
    for (;;)
    {
      ImageManagerEnv.getLogger().d("GenericNewGifDecoder", new Object[] { "index GifInfoHandle: preferBmpFormat--" + i });
      return localConfig;
      localConfig = Bitmap.Config.ARGB_8888;
      continue;
      localConfig = Bitmap.Config.RGB_565;
      continue;
      localConfig = Bitmap.Config.ARGB_4444;
      continue;
      localConfig = Bitmap.Config.ALPHA_8;
    }
  }
  
  public long getAllocationByteCount()
  {
    return this.mNativeInfoHandle.getAllocationByteCount();
  }
  
  public String getComment()
  {
    return this.mNativeInfoHandle.getComment();
  }
  
  public int getCurrentFrameIndex()
  {
    return this.mNativeInfoHandle.getCurrentFrameIndex();
  }
  
  public int getCurrentLoop()
  {
    return this.mNativeInfoHandle.getCurrentLoop();
  }
  
  public int getCurrentPosition()
  {
    return this.mNativeInfoHandle.getCurrentPosition();
  }
  
  public int getDuration()
  {
    return this.mNativeInfoHandle.getDuration();
  }
  
  public int getError()
  {
    return this.mNativeInfoHandle.getNativeErrorCode();
  }
  
  public int getFrameCount()
  {
    return this.mNativeInfoHandle.frameCount;
  }
  
  public int getFrameDuration(int paramInt)
  {
    return this.mNativeInfoHandle.getFrameDuration(paramInt);
  }
  
  public int getHeight()
  {
    return this.mNativeInfoHandle.height;
  }
  
  public int getImageCount()
  {
    return this.mNativeInfoHandle.getImageCount();
  }
  
  public int getLoopCount()
  {
    return this.mNativeInfoHandle.getLoopCount();
  }
  
  public long getSourceLength()
  {
    return this.mNativeInfoHandle.getSourceLength();
  }
  
  public int getWidth()
  {
    return this.mNativeInfoHandle.width;
  }
  
  public boolean isAnimationCompleted()
  {
    return this.mNativeInfoHandle.isAnimationCompleted();
  }
  
  public boolean isRecycled()
  {
    if (this.mNativeInfoHandle != null) {
      return this.mNativeInfoHandle.isRecycled();
    }
    return true;
  }
  
  public NewGifDecoder.GifFrame next(Bitmap paramBitmap)
  {
    this.mCurFrame = new NewGifDecoder.GifFrame(paramBitmap, this.mNativeInfoHandle.renderFrame(paramBitmap));
    return this.mCurFrame;
  }
  
  public NewGifDecoder.GifFrame nextForGifPlay(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.mCurFrame = new NewGifDecoder.GifFrame(paramBitmap, this.mNativeInfoHandle.renderFrameForGifPlay(paramBitmap, paramBoolean));
    return this.mCurFrame;
  }
  
  public void prepareData()
  {
    try
    {
      this.mNativeInfoHandle.prepareData();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("GenericNewGifDecoder", new Object[] { "catch an exception:", Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
  }
  
  public void recycle()
  {
    this.mNativeInfoHandle.recycle();
  }
  
  public boolean reset()
  {
    try
    {
      boolean bool = this.mNativeInfoHandle.reset();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("GenericNewGifDecoder", new Object[] { "reset failed,catch an exception:", Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return false;
  }
  
  public Bitmap seekToFrame(int paramInt, Bitmap paramBitmap)
  {
    this.mNativeInfoHandle.seekToFrame(paramInt, paramBitmap);
    return paramBitmap;
  }
  
  public NewGifDecoder.GifFrame seekToFrameGetTime(int paramInt, Bitmap paramBitmap)
  {
    this.mCurFrame = new NewGifDecoder.GifFrame(paramBitmap, this.mNativeInfoHandle.seekToFrameGetTime(paramInt, paramBitmap));
    return this.mCurFrame;
  }
  
  public Bitmap seekToTime(int paramInt, Bitmap paramBitmap)
  {
    this.mNativeInfoHandle.seekToTime(paramInt, paramBitmap);
    return paramBitmap;
  }
  
  public void setGifInfoHandler(GifInfoHandle paramGifInfoHandle)
  {
    this.mNativeInfoHandle = paramGifInfoHandle;
  }
  
  public void setLoopCount(int paramInt)
  {
    this.mNativeInfoHandle.setLoopCount(paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    this.mNativeInfoHandle.setSpeedFactor(paramFloat);
  }
  
  public long start()
  {
    return this.mNativeInfoHandle.restoreRemainder();
  }
  
  public void stop()
  {
    this.mNativeInfoHandle.saveRemainder();
  }
  
  public void updateFile(String paramString)
  {
    this.mNativeInfoHandle.updateFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.GenericNewGifDecoder
 * JD-Core Version:    0.7.0.1
 */