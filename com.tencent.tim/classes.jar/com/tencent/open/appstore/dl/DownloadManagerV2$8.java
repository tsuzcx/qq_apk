package com.tencent.open.appstore.dl;

import arvv;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$8
  implements Runnable
{
  public DownloadManagerV2$8(arvv paramarvv, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      arvv.a(this.this$0).cancelDownloadTask(this.val$url);
      arvv.a(this.this$0, this.a);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.8
 * JD-Core Version:    0.7.0.1
 */