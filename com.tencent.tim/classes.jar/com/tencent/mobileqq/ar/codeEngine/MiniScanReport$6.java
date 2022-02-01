package com.tencent.mobileqq.ar.codeEngine;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$6
  implements Runnable
{
  public MiniScanReport$6(int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_aio_scan_recog_type", String.valueOf(this.cHB));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "report_tag_aio_scan_recog_type", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onAIOScanRecogTypeReport %d", new Object[] { Integer.valueOf(this.cHB) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.6
 * JD-Core Version:    0.7.0.1
 */