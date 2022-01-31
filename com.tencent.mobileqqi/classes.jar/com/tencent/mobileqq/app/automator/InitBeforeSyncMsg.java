package com.tencent.mobileqq.app.automator;

import android.util.Log;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public class InitBeforeSyncMsg
  extends AsyncStep
{
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    if (this.h == 13)
    {
      this.a.a.a(this.a.a.a());
      this.a.a.a().b();
    }
    MessageHandler localMessageHandler = this.a.a.a();
    if (this.h == 14) {}
    for (int i = 2;; i = 1)
    {
      localMessageHandler.a(i);
      if (this.h != 14) {
        this.a.a.a().a();
      }
      long l2 = System.currentTimeMillis();
      Log.i("AutoMonitor", "STEP_DOSOMETHING, cost=" + (l2 - l1));
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */