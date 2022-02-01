package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import awit;
import com.tencent.qphone.base.util.QLog;
import nue;
import org.json.JSONObject;

public class ViolaReportDelegate$2
  implements Runnable
{
  public ViolaReportDelegate$2(nue paramnue) {}
  
  public void run()
  {
    try
    {
      String str = awit.Hb();
      if ((!TextUtils.isEmpty(str)) && (new JSONObject(str) != null))
      {
        awit.abI("");
        awit.Xl(false);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(nue.TAG, 2, "clearCachePageOpenData Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */