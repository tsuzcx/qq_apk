package com.tencent.mobileqq.ar;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$10
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_name", this.Fj);
    localHashMap.put("memory_size", String.valueOf(this.cCy));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_average_fps", true, this.val$fps, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.10
 * JD-Core Version:    0.7.0.1
 */