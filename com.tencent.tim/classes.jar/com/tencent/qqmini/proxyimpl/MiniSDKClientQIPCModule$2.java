package com.tencent.qqmini.proxyimpl;

import asvm;
import asvo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

public class MiniSDKClientQIPCModule$2
  implements Runnable
{
  public MiniSDKClientQIPCModule$2(asvm paramasvm, BaseRuntime paramBaseRuntime) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(asvo.a(this.a.getMiniAppInfo()), "share_fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.2
 * JD-Core Version:    0.7.0.1
 */