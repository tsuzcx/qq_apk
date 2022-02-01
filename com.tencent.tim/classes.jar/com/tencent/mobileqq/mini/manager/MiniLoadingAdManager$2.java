package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class MiniLoadingAdManager$2
  implements MiniAppCmdInterface
{
  MiniLoadingAdManager$2(String paramString, MiniAppConfig paramMiniAppConfig) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniLoadingAdManager", 1, "yuki requestPreloadLoadingAd receive isSuc= " + paramBoolean);
    if (paramBoolean) {}
    try
    {
      Object localObject = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
      int i = paramJSONObject.getInt("retCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      localObject = ((MiniAppAd.StGetAdRsp)localObject).strAdsJson.get();
      QLog.d("MiniLoadingAdManager", 1, "yuki requestPreloadLoadingAd receive retCode= " + i + " errMsg=" + paramJSONObject + " adJson=" + (String)localObject);
      if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        MiniLoadingAdManager.downloadAndSaveLoadingAd((String)localObject, this.val$uin, this.val$miniAppConfig.config.appId);
        MiniLoadingAdManager.access$200(this.val$miniAppConfig.config.appId, this.val$uin, 1);
        MiniLoadingAdManager.access$300(this.val$miniAppConfig.config.appId, this.val$uin);
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.2
 * JD-Core Version:    0.7.0.1
 */