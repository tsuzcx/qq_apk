package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import arlu;
import arlv;
import arlw;
import arlx;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import java.lang.ref.WeakReference;

public class VideoTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener;
  private a jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewVideoTextureView$a;
  public final Runnable eu = new VideoTextureView.6(this);
  private WeakReference<Context> mContext;
  private int mDuration;
  private MediaPlayer mMediaPlayer;
  private Surface mSurface;
  private String mVideoUrl = "https://www.w3schools.com/html/movie.mp4";
  
  public VideoTextureView(Context paramContext)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.mContext = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewVideoTextureView$a = new a(paramContext);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurface = new Surface(paramSurfaceTexture);
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    this.mMediaPlayer.setSurface(this.mSurface);
    play(this.mVideoUrl);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void play(String paramString)
  {
    if (this.mMediaPlayer == null) {
      return;
    }
    try
    {
      this.mMediaPlayer.setDataSource(paramString);
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setOnPreparedListener(new arlu(this));
      this.mMediaPlayer.prepareAsync();
      this.mMediaPlayer.setOnCompletionListener(new arlv(this));
      this.mMediaPlayer.setOnSeekCompleteListener(new arlw(this));
      this.mMediaPlayer.setOnErrorListener(new arlx(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setVideoPath(String paramString)
  {
    this.mVideoUrl = paramString;
  }
  
  public static class a
    extends Handler
  {
    WeakReference<Context> mContextReference;
    
    a(Context paramContext)
    {
      this.mContextReference = new WeakReference(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */