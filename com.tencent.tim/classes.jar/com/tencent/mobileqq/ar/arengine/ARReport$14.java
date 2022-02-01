package com.tencent.mobileqq.ar.arengine;

import adix;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$14
  implements Runnable
{
  public ARReport$14(adix paramadix, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.TM));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "SensorTrackManagerInit", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.14
 * JD-Core Version:    0.7.0.1
 */