package com.tencent.mobileqq.ark.API;

import adnq.c;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ArkAppModuleReg$ModuleQQ$22
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$22(adnq.c paramc, String paramString) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null) {
      QQToast.a(BaseActivity.sTopActivity, this.buL, 0).show();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ArkApp", 2, "IsMute() activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.22
 * JD-Core Version:    0.7.0.1
 */