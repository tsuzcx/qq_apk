package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.qphone.base.util.QLog;

public class UpgradeTipsDialog$JsCover
  extends JsBridge.JsHandler
{
  protected UpgradeTipsDialog$JsCover(UpgradeTipsDialog paramUpgradeTipsDialog) {}
  
  public int tipsLoadComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "loadTipsComplete");
    }
    UpgradeTipsDialog.a(this.a, true);
    if (UpgradeTipsDialog.a(this.a) != null) {
      UpgradeTipsDialog.a(this.a).a(this.a);
    }
    for (;;)
    {
      return 0;
      try
      {
        this.a.show();
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeTipsDialog.JsCover
 * JD-Core Version:    0.7.0.1
 */