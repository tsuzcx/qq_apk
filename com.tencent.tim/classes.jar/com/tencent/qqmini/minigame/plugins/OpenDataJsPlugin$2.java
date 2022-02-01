package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$2
  implements AsyncResult
{
  OpenDataJsPlugin$2(OpenDataJsPlugin paramOpenDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("OpenDataJsPlugin", "getGroupCloudStorage callback appid:" + OpenDataJsPlugin.access$100(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.get("data") != null)) {
          localJSONObject.put("data", paramJSONObject.get("data"));
        }
        for (;;)
        {
          this.val$req.ok(localJSONObject);
          return;
          localJSONObject.put("data", paramJSONObject);
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.fail();
        return;
      }
    }
    this.val$req.fail(localJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */