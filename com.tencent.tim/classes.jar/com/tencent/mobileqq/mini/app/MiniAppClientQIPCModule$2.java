package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class MiniAppClientQIPCModule$2
  implements Runnable
{
  MiniAppClientQIPCModule$2(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(this.val$appBrandRuntime.getApkgInfo().appConfig, "share_success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.2
 * JD-Core Version:    0.7.0.1
 */