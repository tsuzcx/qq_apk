package com.tencent.mobileqq.ark.vipreport;

import adtx;
import adty;
import adtz;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ArkVipReporter$1
  implements Runnable
{
  public ArkVipReporter$1(String paramString, adtz paramadtz) {}
  
  public void run()
  {
    synchronized ()
    {
      adtx localadtx = (adtx)adty.access$100().get(this.bvB);
      if ((localadtx != null) && (Math.abs(System.currentTimeMillis() - localadtx.startTime) >= this.a.timeOut))
      {
        QLog.i("ArkVipReporter", 1, "startSceneByEvent() find timeout scene and report:" + this.bvB);
        adty.access$200(this.bvB);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */