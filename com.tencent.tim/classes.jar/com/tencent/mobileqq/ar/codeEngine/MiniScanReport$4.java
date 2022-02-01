package com.tencent.mobileqq.ar.codeEngine;

import adjv;
import android.os.Build;
import android.os.Build.VERSION;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$4
  implements Runnable
{
  public MiniScanReport$4(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l1 = adjv.h("report_tag_detect_support_easy", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("report_key_detect_support_type", String.valueOf(this.cHz));
      localHashMap.put("report_key_detect_support_type_strict", String.valueOf(this.cHA));
      adjv.C(localHashMap);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_support_easy", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectSupportEasyReport [model,sdkver]=[%s,%d]", new Object[] { Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT) }));
      }
      adjv.af("report_tag_detect_support_easy", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.4
 * JD-Core Version:    0.7.0.1
 */