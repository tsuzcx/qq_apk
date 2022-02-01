package com.tencent.qqlive.module.videoreport.report;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.util.HashMap;
import java.util.Map;

final class FinalDataTarget$1
  implements Runnable
{
  FinalDataTarget$1(Map paramMap, FinalData paramFinalData, String paramString, Object paramObject) {}
  
  public void run()
  {
    FinalDataTarget.access$000(this.val$publicParams);
    FinalDataTarget.access$100(this.val$publicParams);
    HashMap localHashMap = new HashMap();
    if (this.val$finalData.eventParams != null) {
      localHashMap.putAll(this.val$finalData.eventParams);
    }
    localHashMap.putAll(this.val$publicParams);
    if (!VideoReportInner.getInstance().isReportEnable())
    {
      FinalDataTarget.access$200(this.val$finalData);
      return;
    }
    if (TextUtils.isEmpty(this.val$appKey)) {
      FinalDataTarget.access$300(this.val$object, this.val$finalData.eventKey, localHashMap);
    }
    for (;;)
    {
      FinalDataTarget.access$200(this.val$finalData);
      return;
      FinalDataTarget.access$400(this.val$object, this.val$finalData.eventKey, localHashMap, this.val$appKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget.1
 * JD-Core Version:    0.7.0.1
 */