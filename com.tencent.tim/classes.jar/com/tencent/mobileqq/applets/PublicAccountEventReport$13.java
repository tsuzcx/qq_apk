package com.tencent.mobileqq.applets;

import awmt;
import awmu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$13
  implements Runnable
{
  public PublicAccountEventReport$13(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    awmu localawmu = new awmu();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localawmu.mAppId = "vab_push";
    localawmu.cNQ = "vab_push";
    localawmu.mTraceId = (str + "_" + l);
    localawmu.eBX = 1;
    localawmu.cNR = this.val$itemId;
    localawmu.cRG = "";
    localawmu.aBn = l;
    localawmu.mActionId = this.val$action;
    localawmu.cRI = Integer.toString(this.val$position);
    localawmu.eBB = 1;
    localawmu.eBZ = 1;
    awmt.a().a(localawmu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.13
 * JD-Core Version:    0.7.0.1
 */