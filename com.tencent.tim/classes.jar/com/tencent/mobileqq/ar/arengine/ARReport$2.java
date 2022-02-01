package com.tencent.mobileqq.ar.arengine;

import adix;
import anpc;
import aqiw;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$2
  implements Runnable
{
  public ARReport$2(adix paramadix, String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5, int paramInt3, long paramLong6, long paramLong7, int paramInt4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (this.btu != null) {
      localHashMap.put("cloud_download_imgId", String.valueOf(this.btu));
    }
    if (this.TN > 0L) {
      localHashMap.put("cloud_download_feature_size", String.valueOf(this.TN));
    }
    if (adix.a(this.this$0, this.TO)) {
      localHashMap.put("cloud_download_feature_time", String.valueOf(this.TO));
    }
    if (this.cHd > -1) {
      localHashMap.put("cloud_download_feature_code", String.valueOf(this.cHd));
    }
    if (this.TP > 0L) {
      localHashMap.put("cloud_download_model_size", String.valueOf(this.TP));
    }
    if (adix.a(this.this$0, this.TQ)) {
      localHashMap.put("cloud_download_model_time", String.valueOf(this.TQ));
    }
    if (this.cHe > -1) {
      localHashMap.put("cloud_download_model_code", String.valueOf(this.cHe));
    }
    if (this.TR > 0L) {
      localHashMap.put("cloud_download_unzip_time", String.valueOf(this.TR));
    }
    if (this.ael > -1) {
      localHashMap.put("cloud_download_type", String.valueOf(this.ael));
    }
    localHashMap.put("cloud_download_net_type", String.valueOf(aqiw.getSystemNetwork(BaseApplication.getContext())));
    if (adix.a(this.this$0, this.val$totalTime)) {
      localHashMap.put("cloud_download_all_time", String.valueOf(this.val$totalTime));
    }
    if (this.TS > 0L) {
      localHashMap.put("cloud_download_net_size", String.valueOf(this.TS));
    }
    if (this.cHf > -1) {
      localHashMap.put("cloud_download_all_result", String.valueOf(this.cHf));
    }
    localHashMap.put("cloud_download_type", "0");
    anpc.a(BaseApplication.getContext()).collectPerformance("", "AndroidactARCloudDownLoad", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.2
 * JD-Core Version:    0.7.0.1
 */