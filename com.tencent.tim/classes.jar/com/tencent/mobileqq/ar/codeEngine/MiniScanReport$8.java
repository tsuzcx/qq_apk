package com.tencent.mobileqq.ar.codeEngine;

import adjv;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$8
  implements Runnable
{
  public MiniScanReport$8(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_detect_support_type", String.valueOf(this.cHy));
    localHashMap.put("report_key_detect_init_cost", String.valueOf(this.cHC));
    localHashMap.put("report_key_qq_version", "3.4.43058");
    adjv.C(localHashMap);
    anpc.a(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_init_internal_cost", true, 0L, 0L, localHashMap, "");
    if ((QLog.isColorLevel()) || (adjv.aeJ())) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("base_test_scan onDetectInitInternalCost [supportType,timeCost]=[%d,%d]", new Object[] { Integer.valueOf(this.cHy), Integer.valueOf(this.cHC) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.8
 * JD-Core Version:    0.7.0.1
 */