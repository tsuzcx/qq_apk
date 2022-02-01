package com.tencent.mobileqq.ar;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$12
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("last_total_time", String.valueOf(this.SD));
    localHashMap.put("upload_count", String.valueOf(this.cFb));
    localHashMap.put("session_ids", this.bsH);
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_first_ar_recog", true, this.val$totalTime, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.12
 * JD-Core Version:    0.7.0.1
 */