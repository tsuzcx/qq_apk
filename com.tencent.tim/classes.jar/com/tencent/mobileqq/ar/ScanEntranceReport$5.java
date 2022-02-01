package com.tencent.mobileqq.ar;

import adfx;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$5
  implements Runnable
{
  public ScanEntranceReport$5(adfx paramadfx, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_first_result", this.val$success, this.val$totalTime, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.5
 * JD-Core Version:    0.7.0.1
 */