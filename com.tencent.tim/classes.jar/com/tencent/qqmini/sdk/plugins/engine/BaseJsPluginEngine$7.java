package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import java.util.List;
import org.json.JSONObject;

class BaseJsPluginEngine$7
  implements AsyncResult
{
  BaseJsPluginEngine$7(BaseJsPluginEngine paramBaseJsPluginEngine, RequestEvent paramRequestEvent, List paramList) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      this.this$0.onceSubMsgCallbackSuc(this.val$req, this.val$allSubMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.7
 * JD-Core Version:    0.7.0.1
 */