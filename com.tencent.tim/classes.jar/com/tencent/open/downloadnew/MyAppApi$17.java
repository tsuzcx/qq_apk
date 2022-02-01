package com.tencent.open.downloadnew;

import android.app.Activity;
import aqmj;
import arwo;
import arwt;
import aryq;
import arzk;
import arzk.d;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MyAppApi$17
  implements Runnable
{
  public MyAppApi$17(arzk paramarzk, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    arwt.d("MyAppApi", "---isAutoInstall:" + aryq.aHn() + " url:" + aryq.DB() + " interval:" + aryq.ie());
    if ((arwo.isNetworkAvailable(this.val$context)) && (arwo.cr(this.val$context)))
    {
      boolean bool1 = aryq.aHm();
      boolean bool2 = aryq.aHu();
      String str = aqmj.ac(this.val$context, "wifiAutoPreDown");
      if ((!arzk.aHx()) && (bool1) && (bool2) && ("true".equals(str)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.17.1(this));
        arwt.d("MyAppApi", "---startDownloadYYB---");
        this.this$0.a = new arzk.d(this.this$0);
        this.this$0.a.autoDownload = true;
        this.this$0.a.ddH = false;
        this.this$0.a.t = null;
        this.this$0.a.y = null;
        this.this$0.a.dix = -1;
        this.this$0.r(this.val$context, this.cCm, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.17
 * JD-Core Version:    0.7.0.1
 */