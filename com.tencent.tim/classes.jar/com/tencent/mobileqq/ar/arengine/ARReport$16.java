package com.tencent.mobileqq.ar.arengine;

import adix;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$16
  implements Runnable
{
  public ARReport$16(adix paramadix, long paramLong, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.TM));
    localHashMap.put("result", this.val$result + "");
    anpc.a(BaseApplication.getContext()).collectPerformance("", "AREngineinitAR", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.16
 * JD-Core Version:    0.7.0.1
 */