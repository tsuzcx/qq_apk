package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$4
  implements AsyncResult
{
  OpenDataJsPlugin$4(OpenDataJsPlugin paramOpenDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage callback appid:").append(OpenDataJsPlugin.access$300(this.this$0).appId).append(", isSuc").append(paramBoolean).append(", ret:");
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      localGameLog.i("OpenDataJsPlugin", paramJSONObject);
      paramJSONObject = new JSONObject();
      if (!paramBoolean) {
        break;
      }
      try
      {
        paramJSONObject.put("state", "success");
        this.val$req.ok(paramJSONObject);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataJsPlugin", "setUserCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.fail();
      }
    }
    paramJSONObject.put("state", "fail");
    this.val$req.fail(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */