package com.tencent.mobileqq.ar;

import adfx;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$4
  implements Runnable
{
  public ScanEntranceReport$4(adfx paramadfx, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.bMP));
    localHashMap.put("start_delay", String.valueOf(this.SK));
    localHashMap.put("first_select_time", String.valueOf(this.SL));
    localHashMap.put("first_upload_delay", String.valueOf(this.SM));
    localHashMap.put("neon_opened", String.valueOf(this.cFc));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_first_upload", true, this.val$totalTime, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.4
 * JD-Core Version:    0.7.0.1
 */