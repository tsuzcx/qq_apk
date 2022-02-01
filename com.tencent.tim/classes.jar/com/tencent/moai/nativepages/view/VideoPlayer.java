package com.tencent.moai.nativepages.view;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class VideoPlayer
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, SurfaceHolder.Callback
{
  private static final String TAG = "VideoPlayer";
  private int currentSeek;
  private boolean isSurfaceDestroy = false;
  private MediaPlayer mediaPlayer;
  private boolean pendingPlay = false;
  private boolean prepared = false;
  private boolean soundOn = false;
  private SurfaceHolder surfaceHolder;
  private Timer timer;
  private TimerTask timerTask;
  private String url;
  private int videoHeight;
  private VideoStateCallback videoStateCallback;
  private int videoWidth;
  
  public VideoPlayer(SurfaceView paramSurfaceView)
  {
    this.surfaceHolder = paramSurfaceView.getHolder();
    this.surfaceHolder.addCallback(this);
    this.surfaceHolder.setType(3);
  }
  
  private void startTimer()
  {
    this.timer = new Timer();
    this.timerTask = new VideoPlayer.1(this);
    this.timer.schedule(this.timerTask, 0L, 500L);
  }
  
  public boolean isStop()
  {
    return this.mediaPlayer == null;
  }
  
  public boolean isSurfaceDestroy()
  {
    return this.isSurfaceDestroy;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    Log.i("VideoPlayer", "onBufferingUpdate bufferingProgress = " + paramInt);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.videoStateCallback != null) {
      this.videoStateCallback.finishedVideo();
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.videoWidth = paramMediaPlayer.getVideoWidth();
    this.videoHeight = paramMediaPlayer.getVideoHeight();
    int i = paramMediaPlayer.getDuration();
    if (this.videoStateCallback != null)
    {
      this.videoStateCallback.setDuration(i);
      this.videoStateCallback.preparedVideo();
    }
    if ((this.videoHeight != 0) && (this.videoWidth != 0))
    {
      this.prepared = true;
      paramMediaPlayer.start();
      resume();
      toggleSound(this.soundOn);
      startTimer();
    }
  }
  
  public void pause()
  {
    if ((this.mediaPlayer == null) || (!this.prepared)) {
      return;
    }
    this.mediaPlayer.pause();
    this.currentSeek = this.mediaPlayer.getCurrentPosition();
  }
  
  public void play(String paramString)
  {
    this.url = paramString;
    if (this.mediaPlayer == null) {
      this.pendingPlay = true;
    }
    for (;;)
    {
      return;
      try
      {
        this.mediaPlayer.reset();
        this.mediaPlayer.setDataSource(paramString);
        this.prepared = false;
        this.mediaPlayer.prepareAsync();
        if (this.videoStateCallback != null)
        {
          this.videoStateCallback.startPrepareAsync();
          return;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void resume()
  {
    if ((this.mediaPlayer == null) || (!this.prepared)) {
      return;
    }
    this.mediaPlayer.start();
    this.mediaPlayer.seekTo(this.currentSeek);
  }
  
  public void seekTo(int paramInt)
  {
    if ((this.mediaPlayer == null) || (!this.prepared)) {
      return;
    }
    pause();
    this.currentSeek = paramInt;
    resume();
  }
  
  public void setVideoStateCallback(VideoStateCallback paramVideoStateCallback)
  {
    this.videoStateCallback = paramVideoStateCallback;
  }
  
  public void stop()
  {
    if ((this.mediaPlayer == null) || (!this.prepared)) {
      return;
    }
    this.mediaPlayer.stop();
    this.mediaPlayer.release();
    this.mediaPlayer = null;
    this.timer.cancel();
    this.timer = null;
    this.timerTask.cancel();
    this.timerTask = null;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.i("VideoPlayer", "surfaceChanged");
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      Log.i("VideoPlayer", "surfaceCreated");
      this.mediaPlayer = new MediaPlayer();
      this.mediaPlayer.setDisplay(this.surfaceHolder);
      this.mediaPlayer.setAudioStreamType(3);
      this.mediaPlayer.setOnBufferingUpdateListener(this);
      this.mediaPlayer.setOnPreparedListener(this);
      this.mediaPlayer.setOnCompletionListener(this);
      if ((this.isSurfaceDestroy) || (this.pendingPlay))
      {
        play(this.url);
        this.pendingPlay = false;
      }
      this.isSurfaceDestroy = false;
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.i("VideoPlayer", "surfaceDestroyed");
    this.isSurfaceDestroy = true;
  }
  
  public void toggleSound(boolean paramBoolean)
  {
    this.soundOn = paramBoolean;
    if ((this.mediaPlayer == null) || (!this.prepared)) {
      return;
    }
    if (paramBoolean)
    {
      this.mediaPlayer.setVolume(1.0F, 1.0F);
      return;
    }
    this.mediaPlayer.setVolume(0.0F, 0.0F);
  }
  
  public static abstract interface VideoStateCallback
  {
    public abstract void finishedVideo();
    
    public abstract void preparedVideo();
    
    public abstract void setDuration(long paramLong);
    
    public abstract void setPosition(long paramLong);
    
    public abstract void startPrepareAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoPlayer
 * JD-Core Version:    0.7.0.1
 */