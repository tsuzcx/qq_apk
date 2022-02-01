package com.tencent.qqmini.sdk.core.manager;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.ui.ShareTransitiveFragment;
import org.json.JSONObject;

class ShareManager$1
  implements AsyncResult
{
  ShareManager$1(ShareManager paramShareManager, InnerShareData paramInnerShareData) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    String str;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      str = paramJSONObject.optString("jump_url");
      paramBoolean = paramJSONObject.optBoolean("needShareCallBack");
      this.val$shareData.needShareCallback = paramBoolean;
      this.val$shareData.targetUrl = str;
      this.val$shareData.jsonObject = paramJSONObject;
      if (!paramBoolean) {
        this.val$shareData.notifyShareResult(this.val$shareData.fromActivity, 0, true);
      }
      if (((ShareProxy)ProxyManager.get(ShareProxy.class)).isShareTargetAvailable(this.val$shareData.fromActivity, this.val$shareData.shareTarget))
      {
        if (this.val$shareData.shareInMiniProcess) {
          ((ShareProxy)ProxyManager.get(ShareProxy.class)).share(this.val$shareData.fromActivity, this.val$shareData);
        }
      }
      else {
        return;
      }
      ShareTransitiveFragment.launch(this.val$shareData.fromActivity, this.val$shareData);
      return;
    }
    long l;
    if (paramJSONObject != null)
    {
      paramBoolean = paramJSONObject.optBoolean("needShareCallBack");
      l = paramJSONObject.optLong("retCode");
      str = paramJSONObject.optString("errMsg");
    }
    for (;;)
    {
      this.val$shareData.needShareCallback = paramBoolean;
      if (!paramBoolean) {
        this.val$shareData.notifyShareResult(this.val$shareData.fromActivity, 0, true);
      }
      for (;;)
      {
        QMLog.e("ShareManager", "Failed to getShareInfo, result: " + paramJSONObject);
        ThreadManager.getUIHandler().post(new ShareManager.1.1(this, l, str));
        return;
        this.val$shareData.notifyShareResult(this.val$shareData.fromActivity, 1);
      }
      l = -1L;
      str = null;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.1
 * JD-Core Version:    0.7.0.1
 */