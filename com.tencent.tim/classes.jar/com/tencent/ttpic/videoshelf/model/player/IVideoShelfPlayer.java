package com.tencent.ttpic.videoshelf.model.player;

import android.content.res.AssetManager;
import android.view.Surface;
import android.view.SurfaceHolder;

public abstract interface IVideoShelfPlayer
{
  public static final int PAG_VIDEO_SHELF = 1;
  public static final int WESEE_VIDEO_SHELF = 0;
  
  public abstract void flush();
  
  public abstract int getCurrentPosition();
  
  public abstract long getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setDataSource(AssetManager paramAssetManager, String paramString);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDisplay(SurfaceHolder paramSurfaceHolder);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setParam(String paramString, Object... paramVarArgs);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVideoShelfPlayerListener(IVideoShelfPlayerListener paramIVideoShelfPlayerListener);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void surfaceUpdateSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
 * JD-Core Version:    0.7.0.1
 */