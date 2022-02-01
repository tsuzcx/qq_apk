package com.tencent.biz.pubaccount.readinjoy.video;

import arvv;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import jzk;
import mrm;
import tll;

class ADVideoAppDownloadManager$3
  implements Runnable
{
  ADVideoAppDownloadManager$3(ADVideoAppDownloadManager paramADVideoAppDownloadManager, mrm parammrm) {}
  
  public void run()
  {
    if (jzk.C(ADVideoAppDownloadManager.a(this.this$0), this.a.mPackageName))
    {
      QLog.d("ADVideoAppDownloadManager", 1, "already installed." + this.a.mPackageName);
      this.this$0.a(this.a, 1, 100);
    }
    do
    {
      int i;
      do
      {
        return;
        if (ADVideoAppDownloadManager.a(this.this$0, ADVideoAppDownloadManager.a(this.this$0), this.a))
        {
          QLog.d("ADVideoAppDownloadManager", 1, "already finishDownload." + this.a.mPackageName);
          this.this$0.a(this.a, 5, 100);
          DownloadInfo localDownloadInfo = arvv.a().f(this.a.mAppID);
          arvv.a().d(localDownloadInfo);
          return;
        }
        i = ADVideoAppDownloadManager.a(this.this$0, ADVideoAppDownloadManager.a(this.this$0), this.a);
        if (i < 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading.isPkgDownloading." + this.a.mPackageName + " " + i);
      return;
      if (tll.isWifiConnected())
      {
        this.this$0.a(this.a, 0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */