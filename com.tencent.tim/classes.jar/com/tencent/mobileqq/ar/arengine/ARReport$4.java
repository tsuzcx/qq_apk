package com.tencent.mobileqq.ar.arengine;

import adix;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$4
  implements Runnable
{
  public ARReport$4(adix paramadix, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (adix.a(this.this$0, this.TZ)) {
      localHashMap.put("local_load_feature_time", String.valueOf(this.TZ));
    }
    if (this.Ua > 0L) {
      localHashMap.put("local_load_feature_count", String.valueOf(this.Ua));
    }
    if (adix.a(this.this$0, this.Ub)) {
      localHashMap.put("local_recognize_time", String.valueOf(this.Ub));
    }
    if (this.Uc > 0L) {
      localHashMap.put("local_recognize_times", String.valueOf(this.Uc));
    }
    if (this.Ud > 0L) {
      localHashMap.put("local_recognize_quality", String.valueOf(this.Ud));
    }
    if (!this.btv.equals("")) {
      localHashMap.put("local_recognize_featureid", this.btv);
    }
    anpc.a(BaseApplication.getContext()).collectPerformance("", "AndroidactARLocal", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.4
 * JD-Core Version:    0.7.0.1
 */