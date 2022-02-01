package com.tencent.mobileqq.richmedia.mediacodec.widget;

import com.tencent.qphone.base.util.QLog;

class HWVideoPlayView$2
  implements Runnable
{
  HWVideoPlayView$2(HWVideoPlayView paramHWVideoPlayView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "reStartPlaySolveDanceBlackScreen mHaveSurfaceChangedPlayStart=" + this.this$0.cBT);
    }
    try
    {
      if (!this.this$0.cBT)
      {
        this.this$0.startPlay();
        if (HWVideoPlayView.a(this.this$0)) {
          this.this$0.pausePlay();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DIDI", 1, "reStartPlaySolveDanceBlackScreen mHaveSurfaceChangedPlayStart=" + this.this$0.cBT, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView.2
 * JD-Core Version:    0.7.0.1
 */