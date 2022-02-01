package com.tencent.qqmini.sdk.core.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;
import org.json.JSONObject;

class PreCacheManager$2
  implements AsyncResult
{
  PreCacheManager$2(PreCacheManager paramPreCacheManager, String paramString1, MiniAppInfo paramMiniAppInfo, PreCacheInfo paramPreCacheInfo, String paramString2, String paramString3, PreCacheManager.OnCacheListener paramOnCacheListener) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QMLog.d("minisdk-start_PreCacheManager", this.val$logPrefix + "call API_LOGIN  code:" + paramJSONObject.toString());
      paramJSONObject = paramJSONObject.optString("code");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        PreCacheManager.access$100(this.this$0, this.val$miniAppConfig, this.val$preCacheInfo, this.val$cacheType, this.val$queryParam + "&code=" + paramJSONObject, this.val$listener);
      }
      return;
    }
    QMLog.e("minisdk-start_PreCacheManager", "call API_LOGIN failed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.2
 * JD-Core Version:    0.7.0.1
 */