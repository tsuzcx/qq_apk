package com.tencent.mobileqq.ocr;

import akmz;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class OcrCamera$5
  implements Runnable
{
  public OcrCamera$5(akmz paramakmz, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("costTime", String.valueOf(this.val$costTime));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_select_pic", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.5
 * JD-Core Version:    0.7.0.1
 */