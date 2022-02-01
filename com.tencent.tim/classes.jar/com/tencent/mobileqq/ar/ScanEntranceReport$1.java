package com.tencent.mobileqq.ar;

import adfx;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$1
  implements Runnable
{
  public ScanEntranceReport$1(adfx paramadfx, long paramLong1, long paramLong2, String paramString, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("proc_exist", String.valueOf(adfx.a(this.this$0)));
    localHashMap.put("proc_restart", String.valueOf(adfx.b(this.this$0)));
    localHashMap.put("proc_load_time", String.valueOf(this.SA));
    localHashMap.put("activity_launch_time", String.valueOf(this.SB));
    localHashMap.put("entry_source", this.arC);
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_activity_launch", true, this.SC, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.1
 * JD-Core Version:    0.7.0.1
 */