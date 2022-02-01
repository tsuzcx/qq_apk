package com.tencent.open.appstore.dl;

import arvv;
import arwt;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$15
  implements Runnable
{
  public DownloadManagerV2$15(arvv paramarvv, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.ddm)
      {
        arvv.a(this.this$0).deleteDownloadTask(this.val$url);
        return;
      }
      arvv.a(this.this$0).cancelDownloadTask(this.val$url);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.15
 * JD-Core Version:    0.7.0.1
 */