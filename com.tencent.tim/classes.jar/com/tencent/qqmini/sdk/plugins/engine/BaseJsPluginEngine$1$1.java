package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import java.util.List;
import org.json.JSONObject;

class BaseJsPluginEngine$1$1
  implements AsyncResult
{
  BaseJsPluginEngine$1$1(BaseJsPluginEngine.1 param1, boolean paramBoolean1, List paramList1, List paramList2, List paramList3, boolean paramBoolean2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (BaseJsPluginEngine.access$000(this.this$1.this$0) != null)) {
      if (this.val$isConfirm)
      {
        this.this$1.this$0.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$000(this.this$1.this$0), this.val$allSubMsg, this.val$subMsgNoMaintainAuth, this.val$subMsgIgnoreAuth, false);
        this.this$1.this$0.authDialog = null;
      }
    }
    while (BaseJsPluginEngine.access$000(this.this$1.this$0) == null)
    {
      return;
      if (this.val$isRefuse)
      {
        this.this$1.this$0.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$000(this.this$1.this$0), this.val$allSubMsg, this.val$subMsgNoMaintainAuth, this.val$subMsgIgnoreAuth, true);
        this.this$1.this$0.authDialog = null;
        return;
      }
      this.this$1.this$0.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$000(this.this$1.this$0), this.val$allSubMsg);
      this.this$1.this$0.authDialog = null;
      return;
    }
    this.this$1.this$0.onceSubMsgCallbackFail(BaseJsPluginEngine.access$000(this.this$1.this$0), "Request subscribe fail", 10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.1.1
 * JD-Core Version:    0.7.0.1
 */