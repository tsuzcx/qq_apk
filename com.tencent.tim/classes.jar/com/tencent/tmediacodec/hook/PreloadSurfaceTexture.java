package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;

public final class PreloadSurfaceTexture
  extends SurfaceTexture
{
  @Nullable
  private ActionCallback actionCallback;
  
  public PreloadSurfaceTexture(int paramInt)
  {
    super(paramInt);
  }
  
  public void release()
  {
    super.release();
    if (this.actionCallback != null) {
      this.actionCallback.onReleased();
    }
  }
  
  public final void setActionCallback(@Nullable ActionCallback paramActionCallback)
  {
    this.actionCallback = paramActionCallback;
  }
  
  public static abstract interface ActionCallback
  {
    public abstract void onReleased();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.PreloadSurfaceTexture
 * JD-Core Version:    0.7.0.1
 */