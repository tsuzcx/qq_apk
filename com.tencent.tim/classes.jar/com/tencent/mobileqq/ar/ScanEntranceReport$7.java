package com.tencent.mobileqq.ar;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$7
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("select_image_avg_time", String.valueOf(this.SN));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_upload_count", true, this.cFb, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.7
 * JD-Core Version:    0.7.0.1
 */