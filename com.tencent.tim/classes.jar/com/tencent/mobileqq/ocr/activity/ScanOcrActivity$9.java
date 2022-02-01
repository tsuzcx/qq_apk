package com.tencent.mobileqq.ocr.activity;

import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

class ScanOcrActivity$9
  implements Runnable
{
  ScanOcrActivity$9(ScanOcrActivity paramScanOcrActivity, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.val$errCode));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_recog", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.9
 * JD-Core Version:    0.7.0.1
 */