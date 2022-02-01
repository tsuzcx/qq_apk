package com.tencent.mobileqq.ar.arengine;

import adix;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$9
  implements Runnable
{
  public ARReport$9(adix paramadix, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.TM));
    if (this.vf) {
      localHashMap.put("result", "0");
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance("", "ARCloudControlinit", true, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("result", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.9
 * JD-Core Version:    0.7.0.1
 */