package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailActivity$JsCover
  extends JsBridge.JsHandler
{
  protected UpgradeDetailActivity$JsCover(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public String getApkName()
  {
    return UpgradeDetailActivity.a(this.a);
  }
  
  public long getApkSize()
  {
    return UpgradeDetailActivity.a(this.a);
  }
  
  public String getApkVersion()
  {
    return UpgradeDetailActivity.b(this.a);
  }
  
  public int getDownloadState()
  {
    return UpgradeController.a().a();
  }
  
  public long getUpgradeTime()
  {
    return UpgradeDetailActivity.a(this.a).a.iNewTimeStamp;
  }
  
  public int installApk()
  {
    UpgradeController.a().a(this.a);
    return 0;
  }
  
  public int pauseDownload()
  {
    UpgradeController.a().e();
    return 0;
  }
  
  public int resumeDownload()
  {
    UpgradeController.a().d();
    return 0;
  }
  
  public int startDownload()
  {
    UpgradeController.a().b(false);
    return 0;
  }
  
  public int stopDownload()
  {
    UpgradeController.a().c();
    return 0;
  }
  
  public int tipsLoadComplete()
  {
    QLog.d("Hyim", 2, "loadTipsComplete");
    this.a.a = true;
    int i = getDownloadState();
    this.a.a(i, UpgradeController.a());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeDetailActivity.JsCover
 * JD-Core Version:    0.7.0.1
 */