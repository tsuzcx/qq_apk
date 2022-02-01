package com.tencent.open.appstore.dl;

import arvv;
import arwt;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$14
  implements Runnable
{
  public DownloadManagerV2$14(arvv paramarvv, String paramString) {}
  
  public void run()
  {
    try
    {
      arvv.a(this.this$0).pauseDownloadTask(this.val$url);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.14
 * JD-Core Version:    0.7.0.1
 */