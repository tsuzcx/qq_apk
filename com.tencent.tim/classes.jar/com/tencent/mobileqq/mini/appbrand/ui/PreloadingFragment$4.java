package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreloadingFragment$4
  implements MiniAppCmdInterface
{
  PreloadingFragment$4(PreloadingFragment paramPreloadingFragment) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if ((l != 0L) || (paramJSONObject != null))
      {
        if (paramJSONObject == null) {
          QLog.e("miniapp-db", 1, "getAppInfoById  onCmdListener appinfo==null retCode= " + l + "; errMsg : " + str);
        }
      }
      else {
        return;
      }
      QLog.e("miniapp-db", 1, "getAppInfoById  onCmdListener retCode= " + l + " appid=" + paramJSONObject.appId + "; errMsg : " + str);
      return;
    }
    QLog.e("miniapp-db", 1, "launchMiniAppById cmd fail." + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.4
 * JD-Core Version:    0.7.0.1
 */