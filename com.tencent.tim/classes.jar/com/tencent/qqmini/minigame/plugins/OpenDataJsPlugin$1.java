package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$1
  implements AsyncResult
{
  OpenDataJsPlugin$1(OpenDataJsPlugin paramOpenDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("OpenDataJsPlugin", "getUserCloudStorage callback appid:" + OpenDataJsPlugin.access$000(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.has("KVDataList"))) {
          localJSONObject.put("KVDataList", paramJSONObject.get("KVDataList"));
        }
        for (;;)
        {
          this.val$req.ok(localJSONObject);
          return;
          localJSONObject.put("KVDataList", "[]");
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataJsPlugin", "getUserCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.fail();
        return;
      }
    }
    this.val$req.fail(localJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */