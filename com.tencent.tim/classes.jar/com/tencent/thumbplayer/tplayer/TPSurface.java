package com.tencent.thumbplayer.tplayer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.ITPSurfaceListener;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurface;

public class TPSurface
  implements ITPSurface
{
  private ITPNativePlayerSurfaceCallback mITPSurfaceCallback = new TPSurface.1(this);
  private ITPSurfaceListener mPlayerSurfaceListener = null;
  private TPNativePlayerSurface mTPNativePlayerSurface = null;
  
  public TPSurface(SurfaceTexture paramSurfaceTexture)
  {
    this.mTPNativePlayerSurface = new TPNativePlayerSurface(paramSurfaceTexture);
    this.mTPNativePlayerSurface.setTPSurfaceCallback(this.mITPSurfaceCallback);
  }
  
  protected void finalize()
    throws Throwable
  {
    this.mTPNativePlayerSurface.release();
    super.finalize();
  }
  
  public Surface getSurface()
  {
    return this.mTPNativePlayerSurface;
  }
  
  public void setSurfaceListener(ITPSurfaceListener paramITPSurfaceListener)
  {
    this.mPlayerSurfaceListener = paramITPSurfaceListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPSurface
 * JD-Core Version:    0.7.0.1
 */