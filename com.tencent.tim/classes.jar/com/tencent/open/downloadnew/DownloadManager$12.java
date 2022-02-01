package com.tencent.open.downloadnew;

import arwt;
import aryy;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManager$12
  implements Runnable
{
  public DownloadManager$12(aryy paramaryy, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.b().pauseDownloadTask(this.val$url);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.12
 * JD-Core Version:    0.7.0.1
 */