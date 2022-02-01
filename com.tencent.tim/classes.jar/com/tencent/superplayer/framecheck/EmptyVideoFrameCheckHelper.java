package com.tencent.superplayer.framecheck;

import com.tencent.superplayer.view.ISPlayerVideoView;

public class EmptyVideoFrameCheckHelper
  implements IVideoFrameCheckHelper
{
  private static EmptyVideoFrameCheckHelper mInstance = null;
  
  public static EmptyVideoFrameCheckHelper getInstance()
  {
    if (mInstance == null) {
      mInstance = new EmptyVideoFrameCheckHelper();
    }
    return mInstance;
  }
  
  public void onFirstFrameRendered() {}
  
  public void onPlayerRelease() {}
  
  public void onPlayerReset() {}
  
  public void onPlayerStart() {}
  
  public void onPlayerStop() {}
  
  public void setOnVideoFrameCheckListener(FrameComparePipeLine.OnVideoFrameCheckListener paramOnVideoFrameCheckListener) {}
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.EmptyVideoFrameCheckHelper
 * JD-Core Version:    0.7.0.1
 */