package com.tencent.mobileqq.ar.ARRecord;

import adcg;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARRecordReport$4
  implements Runnable
{
  public ARRecordReport$4(adcg paramadcg, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.cCi));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "ar_record_record_fail", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.4
 * JD-Core Version:    0.7.0.1
 */