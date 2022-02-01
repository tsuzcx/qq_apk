package com.tencent.open.appstore.dl;

import arvv;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadManagerV2$24
  implements Runnable
{
  public DownloadManagerV2$24(arvv paramarvv, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = arvv.a(this.this$0, this.val$url, this.awF, this.awG);
    if (localDownloadInfo == null) {
      arwt.w("DownloadManagerV2", "OnDownloadSDKTaskProgressChanged info == null");
    }
    for (;;)
    {
      this.this$0.b(2, localDownloadInfo);
      return;
      arwt.v("DownloadManagerV2", "OnDownloadSDKTaskProgressChanged info state=" + localDownloadInfo.getState() + " progress=" + localDownloadInfo.progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.24
 * JD-Core Version:    0.7.0.1
 */