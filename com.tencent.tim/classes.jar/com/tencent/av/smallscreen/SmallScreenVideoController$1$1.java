package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import ivz;

class SmallScreenVideoController$1$1
  implements Runnable
{
  SmallScreenVideoController$1$1(SmallScreenVideoController.1 param1, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.a.this$0.a == null)
    {
      igd.aL("SmallScreenVideoController", "mVideoController is null");
      return;
    }
    iiv localiiv = this.a.this$0.a.b();
    if (localiiv != null)
    {
      QLog.d("SmallScreenVideoController", 1, "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.on + ", lLastTick=" + this.oo + ", mCurrentVideoGlassWaitTime=" + localiiv.ann + ", mCurrentDefaultTimeOutRule=" + localiiv.ano + ", mCurrentVideoGlassSwitch=" + this.a.this$0.auF);
      this.a.this$0.ct(localiiv.ano);
      return;
    }
    igd.aL("SmallScreenVideoController", "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.on + ", lLastTick=" + this.oo + ", sessionInfo is null, mCurrentVideoGlassSwitch=" + this.a.this$0.auF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1.1
 * JD-Core Version:    0.7.0.1
 */