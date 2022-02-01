package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

public abstract class AbsVideoPlayer
{
  public static final int PLAYER_INFO_ENDOF_BUFFERING = 22;
  public static final int PLAYER_INFO_START_BUFFERING = 21;
  
  public abstract int captureImageInTime(int paramInt1, int paramInt2);
  
  public abstract View createVideoView(Context paramContext);
  
  public abstract long getCurrentPostion();
  
  public abstract long getDuration();
  
  public abstract boolean getOutputMute();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setOnCaptureImageListener(OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnControllerClickListener(OnControllerClickListener paramOnControllerClickListener);
  
  public abstract void setOnErrorListener(OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(OnInfoListener paramOnInfoListener);
  
  public abstract void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoPreparedListener(OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract boolean setOutputMute(boolean paramBoolean);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void start();
  
  public abstract void startPlayDanmu();
  
  public abstract void stop();
  
  public abstract void stopPlayDanmu();
  
  public static abstract interface OnCaptureImageListener
  {
    public abstract void onCaptureImageFailed(AbsVideoPlayer paramAbsVideoPlayer);
    
    public abstract void onCaptureImageSucceed(AbsVideoPlayer paramAbsVideoPlayer, Bitmap paramBitmap);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(AbsVideoPlayer paramAbsVideoPlayer);
  }
  
  public static abstract interface OnControllerClickListener
  {
    public abstract void onAttationClick(AbsVideoPlayer paramAbsVideoPlayer);
    
    public abstract void onBackClick(AbsVideoPlayer paramAbsVideoPlayer);
    
    public abstract void onBackOnFullScreenClick(AbsVideoPlayer paramAbsVideoPlayer);
    
    public abstract void onCacheClick(AbsVideoPlayer paramAbsVideoPlayer);
    
    public abstract void onFeedbackClick(AbsVideoPlayer paramAbsVideoPlayer);
    
    public abstract void onFullScreenClick(AbsVideoPlayer paramAbsVideoPlayer);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(AbsVideoPlayer paramAbsVideoPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(AbsVideoPlayer paramAbsVideoPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(AbsVideoPlayer paramAbsVideoPlayer);
  }
  
  public static abstract interface OnVideoPreparedListener
  {
    public abstract void onVideoPrepared(AbsVideoPlayer paramAbsVideoPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
 * JD-Core Version:    0.7.0.1
 */