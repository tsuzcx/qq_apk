package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$5
  implements AsyncResult
{
  OpenDataJsPlugin$5(OpenDataJsPlugin paramOpenDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("OpenDataJsPlugin", "removeUserCloudStorage callback appid:" + OpenDataJsPlugin.access$400(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    paramJSONObject = new JSONObject();
    if (paramBoolean) {}
    try
    {
      paramJSONObject.put("state", "success");
      this.val$req.ok(paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "removeUserCloudStorage error " + paramJSONObject.getMessage());
      this.val$req.fail();
    }
    paramJSONObject.put("state", "fail");
    this.val$req.fail(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */