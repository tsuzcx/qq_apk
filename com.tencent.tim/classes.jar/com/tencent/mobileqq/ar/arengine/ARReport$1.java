package com.tencent.mobileqq.ar.arengine;

import adix;
import android.os.Build;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$1
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (adix.a(this.this$0, this.TK)) {
      localHashMap.put("total_render_all_time", String.valueOf(this.TK));
    }
    if (adix.a(this.this$0, this.TL)) {
      localHashMap.put("total_render_success_time", String.valueOf(this.TL));
    }
    localHashMap.put("buildmodel", Build.MODEL);
    localHashMap.put("cpuNumber", String.valueOf(adix.getNumberOfCPUCores()));
    localHashMap.put("totalram", adix.aA(BaseApplication.getContext()));
    localHashMap.put("cpuname", this.this$0.getCpuName());
    anpc.a(BaseApplication.getContext()).collectPerformance("", "AndroidactARTotal", true, this.TK, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.1
 * JD-Core Version:    0.7.0.1
 */