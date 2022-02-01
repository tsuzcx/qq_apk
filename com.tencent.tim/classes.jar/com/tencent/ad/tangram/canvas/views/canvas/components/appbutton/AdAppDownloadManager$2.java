package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;

class AdAppDownloadManager$2
  implements Runnable
{
  AdAppDownloadManager$2(AdAppDownloadManager paramAdAppDownloadManager) {}
  
  public void run()
  {
    int i;
    long l1;
    int j;
    long l2;
    if (this.this$0.ad != null)
    {
      b localb = new b();
      i = 0;
      l1 = System.currentTimeMillis();
      j = i + 1;
      if (!TextUtils.isEmpty(this.this$0.ad.getAppId()))
      {
        AdAppBtnData localAdAppBtnData = localb.loadGdtAppBtnData(this.this$0.ad.getAppId(), this.this$0.ad.getAppChannelId(), j);
        if ((localAdAppBtnData != null) && (localAdAppBtnData.isValid()))
        {
          localAdAppBtnData.mGdtAd_appId = this.this$0.ad.getAppId();
          AdAppDownloadManager.access$100(this.this$0, localAdAppBtnData);
        }
      }
      if (AdAppDownloadManager.access$200(this.this$0) == null) {
        break label193;
      }
      AdLog.w("AdCanvasAppBtnUIAdapter", "loader sucess!!!");
      l2 = System.currentTimeMillis();
      AdAppDownloadManager.access$300(this.this$0, true, l2 - l1);
      AdAppDownloadManager.access$400(this.this$0);
      AdAppDownloadManager.access$500(this.this$0);
    }
    for (;;)
    {
      if (AdAppDownloadManager.access$200(this.this$0) == null)
      {
        i = j;
        if (j < 3) {
          break;
        }
      }
      AdAppDownloadManager.access$602(this.this$0, false);
      return;
      label193:
      AdLog.w("AdCanvasAppBtnUIAdapter", "loader failed!!!");
      l2 = System.currentTimeMillis();
      AdAppDownloadManager.access$300(this.this$0, false, l2 - l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */