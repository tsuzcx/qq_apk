package com.tencent.mobileqq.webview.swift.utils;

import aqqj;
import arcn;
import arcp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SwiftWebAccelerator$6
  implements Runnable
{
  public SwiftWebAccelerator$6(arcn paramarcn, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers.run cost " + (l - this.val$startTime) + "ms.");
    l = System.currentTimeMillis();
    if (!VipWebViewReportLog.isInited())
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
      VipWebViewReportLog.a(BaseApplicationImpl.sApplication.getApplicationContext(), localAppRuntime);
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load http core data config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    arcp.ehu();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load cdn cache config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    aqqj.k(BaseApplicationImpl.sApplication.getRuntime());
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load Individuation url config, cost " + (System.currentTimeMillis() - l) + "ms.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.6
 * JD-Core Version:    0.7.0.1
 */