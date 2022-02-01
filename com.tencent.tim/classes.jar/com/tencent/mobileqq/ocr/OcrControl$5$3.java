package com.tencent.mobileqq.ocr;

import aknf;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class OcrControl$5$3
  implements Runnable
{
  public OcrControl$5$3(aknf paramaknf, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ocr_sso_code", String.valueOf(this.dnK));
    localHashMap.put("ocr_code", String.valueOf(this.dnL));
    localHashMap.put("ret_code", String.valueOf(this.val$retCode));
    try
    {
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_server_fail", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("Q.ocr.control", 1, "collectPerformance exception: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.3
 * JD-Core Version:    0.7.0.1
 */