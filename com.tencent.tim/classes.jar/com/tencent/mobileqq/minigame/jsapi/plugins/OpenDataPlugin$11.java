package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONObject;

class OpenDataPlugin$11
  implements MiniAppCmdInterface
{
  OpenDataPlugin$11(OpenDataPlugin paramOpenDataPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage callback appid:").append(this.val$appid).append(", isSuc:").append(paramBoolean).append(", ret:");
    Object localObject;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    }
    for (;;)
    {
      localGameLog.i("OpenDataPlugin", (String)localObject);
      localObject = new JSONObject();
      if (paramBoolean) {
        try
        {
          ((JSONObject)localObject).put("state", "success");
          if ((paramJSONObject != null) && (paramJSONObject.get("data") != null)) {
            ((JSONObject)localObject).put("data", paramJSONObject.get("data"));
          }
          for (;;)
          {
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "getFriendCloudStorage", (JSONObject)localObject, this.val$callbackId);
            return;
            localObject = "";
            break;
            ((JSONObject)localObject).put("data", paramJSONObject);
          }
          ((JSONObject)localObject).put("state", "fail");
        }
        catch (Throwable paramJSONObject)
        {
          GameLog.getInstance().e("OpenDataPlugin", "getFriendCloudStorage error " + paramJSONObject.getMessage());
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getFriendCloudStorage", null, this.val$callbackId);
          return;
        }
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getFriendCloudStorage", (JSONObject)localObject, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.11
 * JD-Core Version:    0.7.0.1
 */