package com.tencent.mobileqq.mini.appbrand.ui;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class PreloadingFragment$7
  implements MiniAppCmdInterface
{
  PreloadingFragment$7(PreloadingFragment paramPreloadingFragment) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
      if ((l == 0L) && (paramJSONObject != null))
      {
        if (paramJSONObject.clearAuths == 1)
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          if (!TextUtils.isEmpty(str)) {
            AuthorizeCenter.clearAuth(paramJSONObject.appId, str);
          }
        }
        return;
      }
      if (paramJSONObject == null)
      {
        QLog.e("miniapp-db", 1, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l + "; errMsg : " + str);
        return;
      }
      QLog.e("miniapp-db", 1, "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + paramJSONObject.appId + "; errMsg : " + str);
      return;
    }
    QLog.e("miniapp-db", 1, "launchMiniAppByLink cmd fail." + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7
 * JD-Core Version:    0.7.0.1
 */