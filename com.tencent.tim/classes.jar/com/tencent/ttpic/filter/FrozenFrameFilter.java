package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;

public class FrozenFrameFilter
  implements AEFilterI
{
  private boolean mIsFreezeFrameMode = false;
  private Frame mSnapShotFrame;
  
  public Frame RenderProcess(Frame paramFrame)
  {
    Frame localFrame;
    if (this.mIsFreezeFrameMode)
    {
      if (this.mSnapShotFrame == null) {
        this.mSnapShotFrame = paramFrame;
      }
      localFrame = this.mSnapShotFrame;
    }
    do
    {
      return localFrame;
      localFrame = paramFrame;
    } while (this.mSnapShotFrame == null);
    this.mSnapShotFrame.clear();
    this.mSnapShotFrame = null;
    return paramFrame;
  }
  
  public void clear() {}
  
  public void updatePreview(Object paramObject)
  {
    if (this.mIsFreezeFrameMode) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FrozenFrameFilter
 * JD-Core Version:    0.7.0.1
 */