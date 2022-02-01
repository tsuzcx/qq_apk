package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class InternalJSPlugin$2$1
  implements AsyncResult
{
  InternalJSPlugin$2$1(InternalJSPlugin.2 param2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      InternalJSPlugin.access$400(InternalJSPlugin.access$200(this.this$1.this$0), InternalJSPlugin.access$300(this.this$1.this$0).appId, "", paramJSONObject.optString("data"));
      this.this$1.val$req.ok(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */