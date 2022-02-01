package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import java.util.List;
import org.json.JSONObject;

class BaseJsPluginEngine$9$1
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$9$1(BaseJsPluginEngine.9 param9, boolean paramBoolean1, List paramList1, List paramList2, List paramList3, boolean paramBoolean2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (BaseJsPluginEngine.access$400(this.this$1.this$0) != null)) {
      if (this.val$isConfirm)
      {
        this.this$1.this$0.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$400(this.this$1.this$0), this.val$allSubMsg, this.val$subMsgNoMaintainAuth, this.val$subMsgIgnoreAuth, false, BaseJsPluginEngine.access$500(this.this$1.this$0));
        this.this$1.this$0.authDialog = null;
      }
    }
    while (BaseJsPluginEngine.access$400(this.this$1.this$0) == null)
    {
      return;
      if (this.val$isRefuse)
      {
        this.this$1.this$0.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$400(this.this$1.this$0), this.val$allSubMsg, this.val$subMsgNoMaintainAuth, this.val$subMsgIgnoreAuth, true, BaseJsPluginEngine.access$500(this.this$1.this$0));
        this.this$1.this$0.authDialog = null;
        return;
      }
      this.this$1.this$0.onceSubMsgCallbackSuc(BaseJsPluginEngine.access$400(this.this$1.this$0), this.val$allSubMsg, BaseJsPluginEngine.access$500(this.this$1.this$0));
      this.this$1.this$0.authDialog = null;
      return;
    }
    this.this$1.this$0.onceSubMsgCallbackFail(BaseJsPluginEngine.access$400(this.this$1.this$0), "Request subscribe fail", 10003, BaseJsPluginEngine.access$500(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.9.1
 * JD-Core Version:    0.7.0.1
 */