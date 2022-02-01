package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aeks;
import aekt;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.List;

class BaseJsPluginEngine$5
  implements Runnable
{
  BaseJsPluginEngine$5(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString) {}
  
  public void run()
  {
    aeks localaeks = aekt.a();
    if ((localaeks != null) && (localaeks.er() != null) && (localaeks.er().contains(this.val$eventName))) {
      MiniProgramLpReportDC04239.reportApiInvoke(this.this$0.appBrandRuntime.getApkgInfo().appConfig, this.val$eventName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.5
 * JD-Core Version:    0.7.0.1
 */