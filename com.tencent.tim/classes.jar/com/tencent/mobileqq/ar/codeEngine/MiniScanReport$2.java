package com.tencent.mobileqq.ar.codeEngine;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$2
  implements Runnable
{
  public MiniScanReport$2(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    label53:
    boolean bool;
    int i;
    if (this.bgh)
    {
      str = "1";
      localHashMap.put("report_key_so_suc", str);
      localHashMap.put("report_key_so_version", String.valueOf(this.Un));
      if (this.val$md5 != null) {
        break label168;
      }
      str = "";
      localHashMap.put("report_key_so_md5", str);
      localHashMap.put("report_key_qq_version", "0");
      localHashMap.put("report_key_qq_subversion", "3058");
      anpc.a(BaseApplication.getContext()).collectPerformance("", "report_tag_so_cover", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel())
      {
        bool = this.bgh;
        i = this.Un;
        if (this.val$md5 != null) {
          break label176;
        }
      }
    }
    label168:
    label176:
    for (String str = "";; str = this.val$md5)
    {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onSoCoverReport [suc,ver,md5]=[%b,%d,%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str }));
      return;
      str = "0";
      break;
      str = this.val$md5;
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.2
 * JD-Core Version:    0.7.0.1
 */