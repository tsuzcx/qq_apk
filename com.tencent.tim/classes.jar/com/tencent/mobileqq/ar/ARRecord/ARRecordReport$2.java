package com.tencent.mobileqq.ar.ARRecord;

import adcg;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARRecordReport$2
  implements Runnable
{
  public ARRecordReport$2(adcg paramadcg, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "ar_record_active_record_start", this.bLl, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.2
 * JD-Core Version:    0.7.0.1
 */