package com.tencent.mobileqq.ar;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$2
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.bMP));
    localHashMap.put("init_delay", String.valueOf(this.SE));
    localHashMap.put("init_time", String.valueOf(this.SF));
    localHashMap.put("download_resource", String.valueOf(this.bMQ));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_ar_init", true, this.val$totalTime, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.2
 * JD-Core Version:    0.7.0.1
 */