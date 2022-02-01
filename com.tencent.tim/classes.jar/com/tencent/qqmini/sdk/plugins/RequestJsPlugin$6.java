package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class RequestJsPlugin$6
  implements AsyncResult
{
  RequestJsPlugin$6(RequestJsPlugin paramRequestJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      RequestJsPlugin.access$2300(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    if (paramJSONObject != null)
    {
      RequestJsPlugin.access$2400(this.this$0, this.val$req, paramJSONObject, null);
      return;
    }
    RequestJsPlugin.access$2400(this.this$0, this.val$req, null, "do not support getGroupAppStatus!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */