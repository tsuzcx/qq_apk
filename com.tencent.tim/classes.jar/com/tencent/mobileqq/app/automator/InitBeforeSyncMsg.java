package com.tencent.mobileqq.app.automator;

import acoh;
import android.util.Log;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import kec;

public class InitBeforeSyncMsg
  extends AsyncStep
{
  protected int od()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (this.cyx == 14)
    {
      this.a.app.a(this.a.app.getCurrentAccountUin());
      this.a.app.getManager(60);
      this.a.app.a().start();
      this.a.app.a().init();
      localObject = (kec)this.a.app.getBusinessHandler(88);
      this.a.app.addObserver(((kec)localObject).c, true);
      localObject = this.a.app.a();
      if (this.cyx != 15) {
        break label232;
      }
    }
    label232:
    for (int i = 2;; i = 1)
    {
      ((MessageHandler)localObject).Jr(i);
      if (this.cyx != 15)
      {
        this.a.app.a().cJZ();
        this.a.app.a().bIm = false;
      }
      long l2 = System.currentTimeMillis();
      Log.i("AutoMonitor", "STEP_DOSOMETHING, cost=" + (l2 - l1));
      return 7;
      if (this.cyx != 15) {
        break;
      }
      this.a.app.a().cKf();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */