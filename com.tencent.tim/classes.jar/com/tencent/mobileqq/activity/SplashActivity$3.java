package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

class SplashActivity$3
  implements Runnable
{
  SplashActivity$3(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    boolean bool = SettingCloneUtil.readValue(this.this$0.app.getApp(), this.this$0.app.getAccount(), null, "pcactive_notice_key", false);
    if ((!SettingCloneUtil.readValue(this.this$0.app.getApp(), this.this$0.app.getAccount(), null, "pcactive_has_notice", false)) && (bool))
    {
      SettingCloneUtil.writeValue(this.this$0.app.getApp(), this.this$0.app.getAccount(), null, "pcactive_has_notice", true);
      Intent localIntent = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", this.this$0.app.getAccount());
      BaseApplicationImpl.getApplication().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.3
 * JD-Core Version:    0.7.0.1
 */