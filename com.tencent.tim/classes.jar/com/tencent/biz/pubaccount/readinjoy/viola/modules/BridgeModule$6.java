package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;
import tkv;
import tkw;
import tlm;
import tlm.a;
import tlm.b;

class BridgeModule$6
  implements Runnable
{
  BridgeModule$6(BridgeModule paramBridgeModule, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Object localObject = BaseActivity.sTopActivity.getApplicationContext();
    JSONObject localJSONObject = new JSONObject();
    tlm.a locala = new tlm.a();
    locala.aJy = this.val$jsonObject.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject = tlm.a((Context)localObject, locala);
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (localObject == JSONObject.NULL)) {
        break label157;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("deviceInfo", localObject);
        if (!this.auX) {
          break label168;
        }
        this.this$0.invokeCallJS(this.val$callback, localJSONObject);
        return;
        localObject = ((tlm.b)localObject).b;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = tkv.pbToJson((PBField)localObject);
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        if (!(localObject instanceof JSONObject))
        {
          localObject = null;
          break;
        }
        localObject = (JSONObject)localObject;
      }
      catch (JSONException localJSONException)
      {
        tkw.e(BridgeModule.TAG, "handleJsCallRequest", localJSONException);
        continue;
      }
      label157:
      tkw.e(BridgeModule.TAG, "handleJsCallRequest error");
    }
    label168:
    ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getViolaInstance().getInstanceId(), this.this$0.getModuleName(), "callback", this.val$callback, localJSONObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.6
 * JD-Core Version:    0.7.0.1
 */