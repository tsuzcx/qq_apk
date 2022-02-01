package com.tencent.open.downloadnew;

import android.app.Activity;
import arwt;
import aryq;
import arzk;
import arzk.d;

public class MyAppApi$19
  implements Runnable
{
  public MyAppApi$19(arzk paramarzk, boolean paramBoolean, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    arwt.d("MyAppApi", "---isAutoInstall:" + aryq.aHn() + " url:" + aryq.DB() + " interval:" + aryq.ie());
    boolean bool = aryq.aHm();
    if ((!arzk.aHx()) && (bool))
    {
      arwt.d("MyAppApi", "---startDownloadYYB---");
      this.this$0.a = new arzk.d(this.this$0);
      this.this$0.a.autoDownload = true;
      this.this$0.a.ddH = false;
      this.this$0.a.t = null;
      this.this$0.a.y = null;
      this.this$0.a.dix = -1;
      if (this.sT) {
        this.this$0.r(this.val$context, this.cCm, 0);
      }
    }
    else
    {
      return;
    }
    this.this$0.r(this.val$context, this.cCm, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.19
 * JD-Core Version:    0.7.0.1
 */