package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$3
  implements AsyncResult
{
  OpenDataJsPlugin$3(OpenDataJsPlugin paramOpenDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage callback appid:").append(OpenDataJsPlugin.access$200(this.this$0).appId).append(", isSuc:").append(paramBoolean).append(", ret:");
    Object localObject;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    }
    for (;;)
    {
      localGameLog.i("OpenDataJsPlugin", (String)localObject);
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
            this.val$req.ok((JSONObject)localObject);
            return;
            localObject = "";
            break;
            ((JSONObject)localObject).put("data", paramJSONObject);
          }
          ((JSONObject)localObject).put("state", "fail");
        }
        catch (Throwable paramJSONObject)
        {
          GameLog.getInstance().e("OpenDataJsPlugin", "getFriendCloudStorage error " + paramJSONObject.getMessage());
          this.val$req.fail();
          return;
        }
      }
    }
    this.val$req.fail((JSONObject)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */