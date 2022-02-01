package com.tencent.mobileqq.ar.codeEngine;

import adju;
import adjv;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$5
  implements Runnable
{
  public MiniScanReport$5(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    long l1 = adjv.h("report_tag_aio_minicode_result", 0L);
    long l2 = System.currentTimeMillis();
    HashMap localHashMap;
    if (l2 - l1 > 10800000L)
    {
      localHashMap = new HashMap();
      if (!this.bNW) {
        break label195;
      }
      localObject = "1";
      localHashMap.put("report_key_aio_decode_suc", localObject);
      if (!this.bNX) {
        break label202;
      }
    }
    label195:
    label202:
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap.put("report_key_aio_detect_suc", localObject);
      localHashMap.put("report_key_qq_version", "0");
      localHashMap.put("report_key_qq_subversion", "3058");
      String str = adju.jP("QMCF_qr");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("report_key_so_md5", localObject);
      adjv.C(localHashMap);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "report_tag_aio_minicode_result", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanReport", 2, String.format("onAIOMiniCodeResultReport [decodeSuc,detectSuc]=[%b,%b]", new Object[] { Boolean.valueOf(this.bNW), Boolean.valueOf(this.bNX) }));
      }
      adjv.af("report_tag_aio_minicode_result", l2);
      return;
      localObject = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.5
 * JD-Core Version:    0.7.0.1
 */