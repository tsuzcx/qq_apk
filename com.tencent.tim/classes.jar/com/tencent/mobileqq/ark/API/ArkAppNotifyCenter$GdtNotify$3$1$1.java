package com.tencent.mobileqq.ark.API;

import adoi;
import com.tencent.ark.ark;
import org.json.JSONException;
import org.json.JSONObject;
import tgc;
import tgc.b;
import tkv;

public class ArkAppNotifyCenter$GdtNotify$3$1$1
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$3$1$1(adoi paramadoi, tgc paramtgc) {}
  
  public void run()
  {
    Object localObject = tkv.pbToJson(this.jdField_a_of_type_Tgc.a().a);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("rsp", localObject);
      ark.arkNotify(this.jdField_a_of_type_Adoi.a.val$appName, "ad_req_callback", localJSONObject.toString(), "json");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3.1.1
 * JD-Core Version:    0.7.0.1
 */