package com.tencent.open.downloadnew;

import arwt;
import aryy;
import arzg;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(aryy paramaryy, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      arwt.d("DownloadManager_", this.a.packageName + " begin getApkCode ......");
      aryy.a(this.this$0).a(this.a.packageName, this.a.versionCode, aryy.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */