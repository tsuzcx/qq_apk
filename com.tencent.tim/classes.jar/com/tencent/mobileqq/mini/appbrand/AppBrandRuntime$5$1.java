package com.tencent.mobileqq.mini.appbrand;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StBatchQueryAppInfoRsp;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class AppBrandRuntime$5$1
  implements MiniAppCmdInterface
{
  AppBrandRuntime$5$1(AppBrandRuntime.5 param5) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = paramJSONObject.opt("batch_query_app_info");
      if (paramJSONObject != null)
      {
        paramJSONObject = ((INTERFACE.StBatchQueryAppInfoRsp)paramJSONObject).appInfos.get();
        if (paramJSONObject.size() == 1)
        {
          paramJSONObject = MiniAppInfo.from((INTERFACE.StApiAppInfo)paramJSONObject.get(0));
          paramBoolean = AppBrandUtil.needUpdate(this.this$1.this$0.apkgInfo.appConfig.config, paramJSONObject);
        }
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          if (!paramBoolean) {
            continue;
          }
          localJSONObject.put("state", "updating");
          this.this$1.this$0.evaluateServiceSubcribeJS("onUpdateStatusChange", localJSONObject.toString());
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject;
          QLog.e("AppBrandRuntime", 1, "updateJSONObject error." + localException);
          continue;
        }
        if (paramBoolean)
        {
          paramJSONObject = new MiniAppConfig(paramJSONObject);
          ApkgManager.getInstance().getApkgInfoByConfig(paramJSONObject, false, new AppBrandRuntime.5.1.1(this), null);
        }
        return;
        localJSONObject.put("state", "noUpdate");
      }
    }
    QLog.e("AppBrandRuntime", 1, "setBatchQueryAppInfoRequest, onCmdListener, isSuc = " + paramBoolean);
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("state", "noUpdate");
      this.this$1.this$0.evaluateServiceSubcribeJS("onUpdateStatusChange", paramJSONObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("AppBrandRuntime", 1, "updateJSONObject error." + paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.5.1
 * JD-Core Version:    0.7.0.1
 */