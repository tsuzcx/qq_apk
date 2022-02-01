package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppBrandLaunchUI$1$2
  implements Runnable
{
  AppBrandLaunchUI$1$2(AppBrandLaunchUI.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str = "";
    long l = 0L;
    if (this.val$ret != null)
    {
      l = this.val$ret.optLong("retCode");
      str = this.val$ret.optString("errMsg");
    }
    QLog.e("miniapp-start_AppBrandLaunchUI", 1, "getAppInfoById failed. retCode=" + l + " errMsg=" + str);
    QQToast.a(BaseApplicationImpl.getContext(), 1, "" + str, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI.1.2
 * JD-Core Version:    0.7.0.1
 */