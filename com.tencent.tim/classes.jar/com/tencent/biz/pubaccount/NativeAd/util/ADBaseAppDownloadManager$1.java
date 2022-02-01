package com.tencent.biz.pubaccount.NativeAd.util;

import aqiw;
import arvv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import jzg;
import jzk;
import mrm;

public class ADBaseAppDownloadManager$1
  implements Runnable
{
  public ADBaseAppDownloadManager$1(jzg paramjzg, mrm parammrm) {}
  
  public void run()
  {
    if ((this.this$0.b(this.a)) && (jzk.C(this.this$0.mContext, this.a.mPackageName)))
    {
      QLog.d("ADBaseAppDownloadManager", 1, "already installed." + this.a.mPackageName);
      this.this$0.a(this.a, 1, 100);
    }
    do
    {
      return;
      if ((this.this$0.c(this.a)) && (jzg.a(this.this$0.mContext, this.a)))
      {
        QLog.d("ADBaseAppDownloadManager", 1, "already finishDownload." + this.a.mPackageName);
        this.this$0.a(this.a, 5, 100);
        DownloadInfo localDownloadInfo = arvv.a().f(this.a.mAppID);
        arvv.a().d(localDownloadInfo);
        return;
      }
      if (this.a.anA)
      {
        jzg.a(this.this$0, this.a);
        return;
      }
      if (aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
      {
        this.this$0.a(this.a, 0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADBaseAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */