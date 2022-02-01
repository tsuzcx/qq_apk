package com.tencent.mobileqq.ar.arengine;

import adix;
import anpc;
import aqiw;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$3
  implements Runnable
{
  public ARReport$3(adix paramadix, long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString, int paramInt2, long paramLong4, long paramLong5, long paramLong6, int paramInt3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (adix.a(this.this$0, this.TT)) {
      localHashMap.put("cloud_choose_time", String.valueOf(this.TT));
    }
    if (adix.a(this.this$0, this.TU)) {
      localHashMap.put("cloud_upload_time", String.valueOf(this.TU));
    }
    if (adix.a(this.this$0, this.TV)) {
      localHashMap.put("cloud_upload_size", String.valueOf(this.TV));
    }
    if (adix.a(this.this$0, this.cHg)) {
      localHashMap.put("cloud_upload_times", String.valueOf(this.cHg));
    }
    if (this.btu != null) {
      localHashMap.put("cloud_upload_imgid", this.btu);
    }
    if (adix.a(this.this$0, this.cHh)) {
      localHashMap.put("cloud_recognize_time", String.valueOf(this.cHh));
    }
    if (adix.a(this.this$0, this.TW)) {
      localHashMap.put("cloud_all_size", String.valueOf(this.TW));
    }
    if (adix.a(this.this$0, this.TX)) {
      localHashMap.put("cloud_time", String.valueOf(this.TX));
    }
    localHashMap.put("cloud_net_type", String.valueOf(aqiw.getSystemNetwork(BaseApplication.getContext())));
    if (adix.a(this.this$0, this.TY)) {
      localHashMap.put("cloud_all_time", String.valueOf(this.TY));
    }
    localHashMap.put("cloud_all_result", String.valueOf(this.cHf));
    localHashMap.put("cloud_type", "0");
    anpc.a(BaseApplication.getContext()).collectPerformance("", "AndroidactARCloud", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.3
 * JD-Core Version:    0.7.0.1
 */