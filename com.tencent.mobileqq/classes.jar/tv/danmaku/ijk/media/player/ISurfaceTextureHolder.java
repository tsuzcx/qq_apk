package tv.danmaku.ijk.media.player;

import android.graphics.SurfaceTexture;

public abstract interface ISurfaceTextureHolder
{
  public abstract SurfaceTexture getSurfaceTexture();
  
  public abstract void setSurfaceTexture(SurfaceTexture paramSurfaceTexture);
  
  public abstract void setSurfaceTextureHost(ISurfaceTextureHost paramISurfaceTextureHost);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.ISurfaceTextureHolder
 * JD-Core Version:    0.7.0.1
 */