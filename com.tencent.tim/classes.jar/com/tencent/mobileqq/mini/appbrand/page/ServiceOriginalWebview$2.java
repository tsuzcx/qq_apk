package com.tencent.mobileqq.mini.appbrand.page;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import java.io.File;
import java.io.IOException;

class ServiceOriginalWebview$2
  implements ValueCallback
{
  ServiceOriginalWebview$2(ServiceOriginalWebview paramServiceOriginalWebview, String paramString, ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("ServiceOriginalWebview", 2, "---end onWxConfigReady----");
    String str = this.val$appServiceStr;
    paramObject = str;
    try
    {
      if (TextUtils.isEmpty(str)) {
        paramObject = FileUtils.readFileToString(new File(this.val$apkgInfo.getAppServiceJsPath()));
      }
      ServiceOriginalWebview.access$000(this.this$0, paramObject, new ServiceOriginalWebview.2.1(this));
      return;
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        paramObject = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview.2
 * JD-Core Version:    0.7.0.1
 */