package com.tencent.mobileqq.activity;

import android.content.IntentFilter;
import aneo;
import ausb;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import vvr;

public class SplashActivity$1
  implements Runnable
{
  SplashActivity$1(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("SplashActivity", 241);
      aneo localaneo = (aneo)this.this$0.app.getManager(10);
      if (localaneo != null) {
        localaneo.an(1, 0);
      }
      localQQNotificationManager.cancel("SplashActivity", 265);
      localQQNotificationManager.cancel("SplashActivity", 267);
      localQQNotificationManager.cancel("SplashActivity", 274);
      localQQNotificationManager.cancel("SplashActivity", 236);
      localQQNotificationManager.cancel("SplashActivity", 271);
      localQQNotificationManager.cancel("SplashActivity", 273);
      localQQNotificationManager.cancel("SplashActivity", 269);
      localQQNotificationManager.cancel("SplashActivity", 239);
      localQQNotificationManager.cancel("SplashActivity", 527);
      ausb.a(this.this$0.app).ewB();
      SplashActivity.a(this.this$0, new vvr(this));
      this.this$0.registerReceiver(SplashActivity.a(this.this$0), new IntentFilter("before_account_change"));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.1
 * JD-Core Version:    0.7.0.1
 */