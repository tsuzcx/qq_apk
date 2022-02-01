package com.tencent.open.appstore.dl;

import arvv;
import arwt;
import arzg;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadManagerV2$21
  implements Runnable
{
  public DownloadManagerV2$21(arvv paramarvv, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      arwt.i("DownloadManagerV2", "[getApkCodeAsync]" + this.a.packageName + " begin getApkCode ......");
      arvv.a(this.this$0).a(this.a.ticket, this.a.packageName, this.a.versionCode, arvv.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "[getApkCodeAsync] >>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.21
 * JD-Core Version:    0.7.0.1
 */