package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ParcelableUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreCacheManager$3
  implements MiniAppCmdInterface
{
  PreCacheManager$3(PreCacheManager paramPreCacheManager, String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig, String paramString3, PreCacheManager.OnCacheListener paramOnCacheListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    do
    {
      try
      {
        Object localObject = (PreCacheManager.ContentAccelerateRsp)paramJSONObject.get("mini_rsp_data");
        QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " fetch PreCache succful. CacheType:" + this.val$cacheType + " httpCode=" + ((PreCacheManager.ContentAccelerateRsp)localObject).httpReturnCode + " length=" + ((PreCacheManager.ContentAccelerateRsp)localObject).cacheData.length);
        if ((((PreCacheManager.ContentAccelerateRsp)localObject).httpReturnCode == 200) && (((PreCacheManager.ContentAccelerateRsp)localObject).cacheData.length <= PreCacheManager.access$200(this.this$0)))
        {
          paramJSONObject = new PreCacheManager.PreCacheDescData();
          paramJSONObject.appid = this.val$miniAppConfig.config.appId;
          paramJSONObject.url = this.val$origUrl;
          paramJSONObject.scene = this.val$miniAppConfig.launchParam.scene;
          paramJSONObject.path = this.val$miniAppConfig.launchParam.entryPath;
          paramJSONObject.timeStamp = System.currentTimeMillis();
          MiniAppFileManager.getInstance();
          String str = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.config.appId, this.val$cacheType, paramJSONObject.getCacheKey());
          FileUtils.writeFile(((PreCacheManager.ContentAccelerateRsp)localObject).cacheData, str);
          paramJSONObject.filePath = str;
          MiniAppFileManager.getInstance();
          localObject = MiniAppFileManager.getPreCacheFilePath(this.val$miniAppConfig.config.appId, this.val$cacheType, paramJSONObject.getCacheKey() + "_index");
          ParcelableUtil.writeParcelableToFile(paramJSONObject, (String)localObject);
          QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " save PreCache info. index=" + (String)localObject + " content=" + str);
          if (this.val$listener != null) {
            this.val$listener.onCacheUpdated(true, true);
          }
        }
        return;
      }
      catch (Throwable paramJSONObject)
      {
        do
        {
          QLog.e("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " request PreCache exception!", paramJSONObject);
        } while (this.val$listener == null);
        this.val$listener.onCacheUpdated(false, false);
        return;
      }
      int i = paramJSONObject.optInt("retCode");
      paramJSONObject = paramJSONObject.optString("errMsg");
      QLog.i("miniapp-start_PreCacheManager", 1, this.val$logPrefix + " fetch PreCache failed! retCode=" + i + " msg=" + paramJSONObject);
    } while (this.val$listener == null);
    this.val$listener.onCacheUpdated(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.3
 * JD-Core Version:    0.7.0.1
 */