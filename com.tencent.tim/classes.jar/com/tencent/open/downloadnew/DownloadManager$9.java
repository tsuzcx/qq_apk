package com.tencent.open.downloadnew;

import arwt;
import aryy;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManager$9
  implements Runnable
{
  public DownloadManager$9(aryy paramaryy, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.ddm)
      {
        this.this$0.b().deleteDownloadTask(this.val$url);
        return;
      }
      this.this$0.b().cancelDownloadTask(this.val$url);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.9
 * JD-Core Version:    0.7.0.1
 */