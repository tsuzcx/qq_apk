package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.text.TextUtils;
import awit;
import com.tencent.qphone.base.util.QLog;
import nue;
import org.json.JSONObject;

public class ViolaReportDelegate$1
  implements Runnable
{
  public ViolaReportDelegate$1(nue paramnue, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = awit.Hb();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = new JSONObject((String)localObject);; localObject = new JSONObject())
      {
        JSONObject localJSONObject = nue.a(this.this$0, this.anH);
        if (localJSONObject == null) {
          break;
        }
        ((JSONObject)localObject).put("" + this.val$key, localJSONObject);
        awit.abI(((JSONObject)localObject).toString());
        awit.Xl(true);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(nue.TAG, 2, "cachePageOpenData Exception:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.1
 * JD-Core Version:    0.7.0.1
 */