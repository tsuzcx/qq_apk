package com.tencent.open.downloadnew;

import aewh;
import android.app.Activity;
import aqap;
import aqma;
import arwo;
import arwt;
import aryq;
import arzk;
import arzk.d;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.a;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;

public class MyAppApi$18
  implements Runnable
{
  public MyAppApi$18(arzk paramarzk, Activity paramActivity) {}
  
  public void run()
  {
    arwt.d("MyAppApi", "---isAutoInstall:" + aryq.aHn() + " url:" + aryq.DB() + " interval:" + aryq.ie());
    boolean bool4;
    boolean bool5;
    UpgradeDetailWrapper localUpgradeDetailWrapper;
    if ((arwo.isNetworkAvailable(this.val$context)) && (arwo.cr(this.val$context)))
    {
      bool4 = aewh.g("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      bool5 = aryq.aHm();
      localUpgradeDetailWrapper = aqap.a().b();
      if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.b == null) || (localUpgradeDetailWrapper.b.dialog == null)) {
        break label383;
      }
    }
    label378:
    label383:
    for (boolean bool1 = localUpgradeDetailWrapper.b.dialog.cTi;; bool1 = false)
    {
      boolean bool3 = aqma.aEV();
      boolean bool2 = bool3;
      int j;
      if (bool3)
      {
        j = aqma.getVersionCode();
        if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.a == null)) {
          break label378;
        }
      }
      for (int i = localUpgradeDetailWrapper.a.dYn;; i = 0)
      {
        bool2 = bool3;
        if (i != j)
        {
          aqma.SJ(false);
          aqma.XA(i);
          bool2 = false;
        }
        arwt.d("NewUpgradeDialog", "predownload flags:isInstalled=" + bool4 + " needDownloadYYB = " + bool5 + " allowPreDownload=" + bool1 + " hasPreDownloadSucc=" + bool2);
        if ((!bool4) && (!arzk.aHx()) && (bool5) && (bool1) && (!bool2))
        {
          arwt.d("NewUpgradeDialog", "---start pre Download YYB---");
          this.this$0.a = new arzk.d(this.this$0);
          this.this$0.a.autoDownload = true;
          this.this$0.a.ddH = false;
          this.this$0.a.t = null;
          this.this$0.a.y = null;
          this.this$0.a.dix = -1;
          arzk.b(this.this$0, true);
          this.this$0.r(this.val$context, "ANDROIDQQ.NEWYYB.QQUPDATE", 1);
          return;
        }
        arwt.d("NewUpgradeDialog", "don't need preDownload return");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */