package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.qphone.base.util.QLog;
import lgk;
import lgl;
import noz;

public final class RIJImageOptMonitor$1
  implements Runnable
{
  public RIJImageOptMonitor$1(noz paramnoz) {}
  
  public void run()
  {
    if ((this.b != null) && (this.b.startTime > 0L) && ((this.b.endTime == 0L) || ((!this.b.mIsCancel) && (this.b.failCode != 0))))
    {
      QLog.d("RIJImageOptMonitor", 1, "image load too slow: " + this.b);
      lgl.d(this.b);
      lgk.aMb();
      lgk.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.1
 * JD-Core Version:    0.7.0.1
 */