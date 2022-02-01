package com.tencent.superplayer.api;

import android.app.Activity;

public abstract interface ISPlayerPreLoader
{
  public abstract void release();
  
  public abstract int startPreloadTask(Activity paramActivity, SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
  
  public abstract void stopPreloadTask(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerPreLoader
 * JD-Core Version:    0.7.0.1
 */