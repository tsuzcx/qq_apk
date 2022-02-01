package com.tencent.mobileqq.ar.ARRecord;

import adcg;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARRecordReport$3
  implements Runnable
{
  public ARRecordReport$3(adcg paramadcg, int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.cCh));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "ar_record_record_success", true, 0L, this.Sc, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.3
 * JD-Core Version:    0.7.0.1
 */