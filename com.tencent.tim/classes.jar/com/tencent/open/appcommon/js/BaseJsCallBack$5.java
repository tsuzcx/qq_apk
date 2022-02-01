package com.tencent.open.appcommon.js;

import android.os.Bundle;
import avgx;
import cooperation.qappcenter.remote.SendMsg;
import org.json.JSONException;
import org.json.JSONObject;

class BaseJsCallBack$5
  implements Runnable
{
  BaseJsCallBack$5(BaseJsCallBack paramBaseJsCallBack, String paramString) {}
  
  public void run()
  {
    try
    {
      if (BaseJsCallBack.access$000(this.this$0) != null)
      {
        JSONObject localJSONObject = new JSONObject(this.cCx);
        SendMsg localSendMsg = new SendMsg("setActionButton");
        localSendMsg.extraData.putString("iconType", localJSONObject.optString("iconType"));
        localSendMsg.extraData.putString("visible", localJSONObject.optString("visible"));
        localSendMsg.extraData.putString("callBackKey", localJSONObject.optString("callBackKey"));
        localSendMsg.extraData.putString("rightText", localJSONObject.optString("text"));
        BaseJsCallBack.access$000(this.this$0).a(localSendMsg);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseJsCallBack.5
 * JD-Core Version:    0.7.0.1
 */