package dov.com.qq.im.ae.gif.preview;

import android.content.Context;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import axfl.a;
import axfm;

public class VideoPlayView
  extends GLSurfaceView
{
  private static final String TAG = VideoPlayView.class.getSimpleName();
  private final axfm a;
  private MediaPlayer player;
  
  public VideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    this.a = new axfm(this);
    setRenderer(this.a);
    setRenderMode(0);
  }
  
  public VideoPlayView a(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {
      return this;
    }
    if (this.player != null)
    {
      this.player.release();
      this.player = null;
    }
    this.player = paramMediaPlayer;
    this.a.d(paramMediaPlayer);
    return this;
  }
  
  public void clear()
  {
    queueEvent(new VideoPlayView.1(this));
  }
  
  public void setFrameRenderCallback(axfl.a parama)
  {
    if (this.a != null) {
      this.a.setFrameRenderCallback(parama);
    }
  }
  
  public void setNeedComposeAlpha(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setNeedComposeAlpha(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.preview.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */