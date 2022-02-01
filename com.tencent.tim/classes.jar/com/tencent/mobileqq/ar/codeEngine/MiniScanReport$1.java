package com.tencent.mobileqq.ar.codeEngine;

import adjv;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$1
  implements Runnable
{
  public MiniScanReport$1(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void run()
  {
    anpc localanpc = anpc.a(BaseApplication.getContext());
    HashMap localHashMap;
    if ((this.cHr > 0) && (this.cHr < 180000))
    {
      localHashMap = new HashMap();
      localHashMap.put("report_key_scan_total", String.valueOf(this.Un));
      localHashMap.put("report_key_scan_cnt", String.valueOf(this.cHs));
      localHashMap.put("report_key_scan_avg", String.valueOf(this.cHr));
      localHashMap.put("report_key_scan_suc", String.valueOf(this.cHt));
      adjv.C(localHashMap);
      localanpc.collectPerformance("", "report_tag_scan_avg_qr", true, 0L, 0L, localHashMap, "");
    }
    if ((this.cHu > 0) && (this.cHv > 0) && (this.cHv < 180000))
    {
      localHashMap = new HashMap();
      localHashMap.put("report_key_scan_total", String.valueOf(this.Un));
      localHashMap.put("report_key_scan_cnt", String.valueOf(this.cHu));
      localHashMap.put("report_key_scan_avg", String.valueOf(this.cHv));
      localHashMap.put("report_key_scan_suc", String.valueOf(this.cHt));
      adjv.C(localHashMap);
      localanpc.collectPerformance("", "report_tag_scan_avg_minidecode", true, 0L, 0L, localHashMap, "");
    }
    if ((this.cHw > 0) && (this.cHx > 0) && (this.cHx < 180000))
    {
      localHashMap = new HashMap();
      localHashMap.put("report_key_scan_total", String.valueOf(this.Un));
      localHashMap.put("report_key_scan_cnt", String.valueOf(this.cHw));
      localHashMap.put("report_key_scan_avg", String.valueOf(this.cHx));
      localHashMap.put("report_key_scan_suc", String.valueOf(this.cHt));
      adjv.C(localHashMap);
      localanpc.collectPerformance("", "report_tag_scan_avg_minidetect", true, 0L, 0L, localHashMap, "");
    }
    if ((QLog.isColorLevel()) || (adjv.aeJ())) {
      QLog.i("MiniRecog.MiniScanReport", 1, String.format("base_test_scan markScanEnd [sucType,totalConsume,qrAvg,decodeAvg,detectAvg]=[%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(this.cHt), Long.valueOf(this.Un), Integer.valueOf(this.cHr), Integer.valueOf(this.cHv), Integer.valueOf(this.cHx) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.1
 * JD-Core Version:    0.7.0.1
 */