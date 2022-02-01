package com.tencent.mobileqq.mini.activity;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class LoadingFragment$3
  implements MiniAppCmdInterface
{
  LoadingFragment$3(LoadingFragment paramLoadingFragment, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      QLog.i("LoadingActivity", 1, "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        localObject = new MiniAppConfig(paramJSONObject);
        if (this.val$param != null)
        {
          ((MiniAppConfig)localObject).launchParam = this.val$param;
          ((MiniAppConfig)localObject).launchParam.miniAppId = paramJSONObject.appId;
        }
        if ((paramJSONObject.verType != 3) && (paramJSONObject.verType != 1)) {
          ((MiniAppConfig)localObject).forceReroad = 3;
        }
        LoadingFragment.access$002(this.this$0, (MiniAppConfig)localObject);
        this.this$0.getArgumentBundle().putParcelable("CONFIG", LoadingFragment.access$000(this.this$0));
        MiniAppUtils.notityPullDownEntryInMainProcess(LoadingFragment.access$000(this.this$0));
        LoadingFragment.access$100(this.this$0);
        return;
      }
      ThreadManager.getUIHandler().post(new LoadingFragment.3.1(this, (String)localObject, l));
      return;
    }
    ThreadManager.getUIHandler().post(new LoadingFragment.3.2(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.3
 * JD-Core Version:    0.7.0.1
 */