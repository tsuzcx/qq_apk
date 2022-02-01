package com.tencent.av.video.effect.process;

import android.os.Handler;
import android.os.HandlerThread;

public class OffscreenGLContext
{
  private Handler mHandler;
  private OffscreenSurface mOffscreenSurface;
  
  public OffscreenGLContext()
  {
    HandlerThread localHandlerThread = new HandlerThread("MyOffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new OffscreenGLContext.1(this));
  }
  
  public void destroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(new OffscreenGLContext.2(this));
    }
  }
  
  public void post(Runnable paramRunnable)
  {
    if ((this.mHandler != null) && (paramRunnable != null)) {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.process.OffscreenGLContext
 * JD-Core Version:    0.7.0.1
 */