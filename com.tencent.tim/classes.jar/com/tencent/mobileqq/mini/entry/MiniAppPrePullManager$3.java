package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

class MiniAppPrePullManager$3
  implements MiniAppCmdInterface
{
  MiniAppPrePullManager$3(MiniAppPrePullManager paramMiniAppPrePullManager, String paramString, boolean paramBoolean, MiniAppPrePullManager.IPrePullListener paramIPrePullListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("retCode");
    ??? = paramJSONObject.optString("errMsg");
    if (paramBoolean) {
      synchronized (MiniAppPrePullManager.access$100())
      {
        MiniAppPrePullManager.MiniAppInfoPrePullWrapper localMiniAppInfoPrePullWrapper = new MiniAppPrePullManager.MiniAppInfoPrePullWrapper();
        localMiniAppInfoPrePullWrapper.setLink(this.val$finalLink);
        localMiniAppInfoPrePullWrapper.setPullTimeStamp(System.currentTimeMillis());
        MiniAppPrePullManager.access$200().put(this.val$finalLink, localMiniAppInfoPrePullWrapper);
        if (this.val$withPackageAndCachePreload)
        {
          ??? = (MiniAppInfo)paramJSONObject.opt("appInfo");
          if (??? != null)
          {
            MiniAppController.preloadPackage((MiniAppInfo)???);
            MiniAppUtils.preFetchAppCacheData(BaseApplicationImpl.getApplication(), (MiniAppInfo)???);
          }
        }
        if (this.val$prePullListener != null) {
          this.val$prePullListener.onPrePullCallback(true, paramJSONObject);
        }
        QLog.d("MiniAppPrePullManager", 1, "prePullAppinfoByLink suc");
        return;
      }
    }
    if (this.val$prePullListener != null) {
      this.val$prePullListener.onPrePullCallback(false, paramJSONObject);
    }
    QLog.e("MiniAppPrePullManager", 1, "prePullAppinfoByLink failed. retCode=" + l + " errMsg=" + (String)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.3
 * JD-Core Version:    0.7.0.1
 */