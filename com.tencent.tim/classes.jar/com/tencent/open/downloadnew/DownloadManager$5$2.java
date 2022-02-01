package com.tencent.open.downloadnew;

import arwt;
import aryy;
import arze;

public class DownloadManager$5$2
  implements Runnable
{
  public DownloadManager$5$2(arze paramarze, long paramLong1, long paramLong2, String paramString) {}
  
  public void run()
  {
    int i = (int)((float)this.awF * 100.0F / (float)this.awG);
    DownloadInfo localDownloadInfo = this.a.this$0.c(this.val$url, i);
    if (localDownloadInfo == null) {
      arwt.w("DownloadManager_", "OnDownloadSDKTaskProgressChanged info == null");
    }
    for (;;)
    {
      this.a.this$0.b(2, localDownloadInfo);
      return;
      arwt.v("DownloadManager_", "OnDownloadSDKTaskProgressChanged info state=" + localDownloadInfo.getState() + " progress=" + localDownloadInfo.progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.2
 * JD-Core Version:    0.7.0.1
 */