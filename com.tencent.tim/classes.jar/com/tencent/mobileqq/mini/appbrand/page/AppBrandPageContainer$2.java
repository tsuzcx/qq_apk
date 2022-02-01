package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;

class AppBrandPageContainer$2
  implements Runnable
{
  AppBrandPageContainer$2(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void run()
  {
    MiniReportManager.reportEventType(this.this$0.appBrandRuntime.apkgInfo.appConfig, 607, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.this$0.appBrandRuntime), null, null, 0);
    this.this$0.reportPageViewHide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer.2
 * JD-Core Version:    0.7.0.1
 */