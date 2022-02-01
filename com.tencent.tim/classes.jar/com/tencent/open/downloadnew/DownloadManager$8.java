package com.tencent.open.downloadnew;

import arwt;
import aryy;
import asac;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$8
  implements Runnable
{
  public DownloadManager$8(aryy paramaryy, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      this.this$0.b().cancelDownloadTask(this.val$url);
      this.this$0.jn.remove(this.a.appId);
      asac.a().Xv(this.a.appId);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.8
 * JD-Core Version:    0.7.0.1
 */