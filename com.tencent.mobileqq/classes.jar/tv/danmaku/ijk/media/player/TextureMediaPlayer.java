package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;

@TargetApi(14)
public class TextureMediaPlayer
  extends MediaPlayerProxy
  implements IMediaPlayer, ISurfaceTextureHolder
{
  private SurfaceTexture mSurfaceTexture;
  private ISurfaceTextureHost mSurfaceTextureHost;
  
  public TextureMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    super(paramIMediaPlayer);
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.mSurfaceTexture;
  }
  
  public void release()
  {
    super.release();
    releaseSurfaceTexture();
  }
  
  public void releaseSurfaceTexture()
  {
    if (this.mSurfaceTexture != null)
    {
      if (this.mSurfaceTextureHost == null) {
        break label33;
      }
      this.mSurfaceTextureHost.releaseSurfaceTexture(this.mSurfaceTexture);
    }
    for (;;)
    {
      this.mSurfaceTexture = null;
      return;
      label33:
      this.mSurfaceTexture.release();
    }
  }
  
  public void reset()
  {
    super.reset();
    releaseSurfaceTexture();
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mSurfaceTexture == null) {
      super.setDisplay(paramSurfaceHolder);
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    if (this.mSurfaceTexture == null) {
      super.setSurface(paramSurface);
    }
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mSurfaceTexture == paramSurfaceTexture) {
      return;
    }
    releaseSurfaceTexture();
    this.mSurfaceTexture = paramSurfaceTexture;
    if (paramSurfaceTexture == null)
    {
      super.setSurface(null);
      return;
    }
    super.setSurface(new Surface(paramSurfaceTexture));
  }
  
  public void setSurfaceTextureHost(ISurfaceTextureHost paramISurfaceTextureHost)
  {
    this.mSurfaceTextureHost = paramISurfaceTextureHost;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.TextureMediaPlayer
 * JD-Core Version:    0.7.0.1
 */