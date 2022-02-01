package com.tencent.mobileqq.mini.launch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniSdkLauncher$1$1
  implements MiniAppCmdInterface
{
  MiniSdkLauncher$1$1(MiniSdkLauncher.1 param1) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      QLog.d("MiniSdkLauncher", 1, "preLaunchMiniAppCheckinFromLeba onCmdListener" + MiniSdkLauncher.access$000());
      if (paramBoolean)
      {
        long l = paramJSONObject.optLong("retCode");
        String str = paramJSONObject.optString("errMsg");
        QLog.i("MiniSdkLauncher", 1, "preLaunchMiniAppCheckinFromLeba, retCode = " + l + ",errMsg = " + str);
        paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
        if (paramJSONObject != null)
        {
          MiniSdkLauncher.access$002(true);
          paramJSONObject = new MiniAppConfig(paramJSONObject);
          MiniSdkLauncher.preLaunchMiniApp(BaseApplicationImpl.getContext(), paramJSONObject);
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.i("MiniSdkLauncher", 1, "preLaunchMiniAppCheckinFromLeba", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniSdkLauncher.1.1
 * JD-Core Version:    0.7.0.1
 */