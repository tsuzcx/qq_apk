package com.tencent.mobileqq.ar;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$3
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.bMP));
    localHashMap.put("bind_time", String.valueOf(this.SG));
    localHashMap.put("got_config_time", String.valueOf(this.SH));
    localHashMap.put("resource_check_time", String.valueOf(this.SI));
    localHashMap.put("dependence_wait_time", String.valueOf(this.SJ));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_ar_init_pre", true, this.val$totalTime, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.3
 * JD-Core Version:    0.7.0.1
 */