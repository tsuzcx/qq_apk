package com.tencent.mobileqq.ar.codeEngine;

import adju;
import adjv;
import anpc;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$3
  implements Runnable
{
  public MiniScanReport$3(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_detect_support_type", String.valueOf(this.cHy));
    localHashMap.put("report_key_detect_init_stauts", String.valueOf(this.cHk));
    localHashMap.put("report_key_qq_version", "0");
    localHashMap.put("report_key_qq_subversion", "3058");
    int i = RecogUtil.getProcessId();
    localHashMap.put("report_key_detect_init_process", String.valueOf(i));
    String str2 = adju.jP("QMCF_qr");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localHashMap.put("report_key_so_md5", str1);
    adjv.C(localHashMap);
    anpc.a(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_supporttype", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectSupportReport [supportType,initStatus]=[%d,%d] pid=%d", new Object[] { Integer.valueOf(this.cHy), Integer.valueOf(this.cHk), Integer.valueOf(i) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.3
 * JD-Core Version:    0.7.0.1
 */