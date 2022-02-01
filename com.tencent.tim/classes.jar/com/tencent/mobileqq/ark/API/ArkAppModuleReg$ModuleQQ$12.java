package com.tencent.mobileqq.ark.API;

import adnq.c;
import adqr;
import ahgq;
import android.content.Intent;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppModuleReg$ModuleQQ$12
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$12(adnq.c paramc, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      Intent localIntent = ArkFullScreenAppActivity.a(localBaseActivity, this.val$view, this.this$0.mAppName, this.aWN, this.val$config, adqr.getDensity());
      if (localIntent != null) {
        ahgq.P(localBaseActivity, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.12
 * JD-Core Version:    0.7.0.1
 */