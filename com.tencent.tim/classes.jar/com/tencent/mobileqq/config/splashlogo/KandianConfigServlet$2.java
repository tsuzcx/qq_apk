package com.tencent.mobileqq.config.splashlogo;

import awit;
import com.tencent.qphone.base.util.QLog;
import kbp;
import org.json.JSONObject;

public final class KandianConfigServlet$2
  implements Runnable
{
  public KandianConfigServlet$2(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      awit.cj(localJSONObject);
      kbp.a(null, null, this.bCf, this.bCf, 0, 0, this.bCg, this.adA, null, localJSONObject.toString(), false);
      QLog.d("KandianConfigServlet", 1, "reportID:" + this.bCf + " reportKDConfigFailed  isAll:" + this.bCg + "  errorCode:" + this.adA);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("KandianConfigServlet", 1, "reportKDConfigFailed ecception:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.KandianConfigServlet.2
 * JD-Core Version:    0.7.0.1
 */