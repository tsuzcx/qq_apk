package com.tencent.superplayer.framecheck;

import com.tencent.superplayer.view.ISPlayerVideoView;

public abstract interface IVideoFrameCheckHelper
{
  public abstract void onFirstFrameRendered();
  
  public abstract void onPlayerRelease();
  
  public abstract void onPlayerReset();
  
  public abstract void onPlayerStart();
  
  public abstract void onPlayerStop();
  
  public abstract void setOnVideoFrameCheckListener(FrameComparePipeLine.OnVideoFrameCheckListener paramOnVideoFrameCheckListener);
  
  public abstract void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
 * JD-Core Version:    0.7.0.1
 */