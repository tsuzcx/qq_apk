package com.tencent.open.appstore.report;

import android.text.TextUtils;
import arvt;
import arwk;
import arwt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

public final class AppCenterReporter$3
  implements Runnable
{
  public AppCenterReporter$3(DownloadInfo paramDownloadInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.f == null) {}
    boolean bool;
    do
    {
      return;
      Object localObject = arvt.a().d(this.f.ticket);
      if (localObject != null)
      {
        arwt.i("AppCenterReporter", ">reportDownloadError " + ((DownloadInfo)localObject).cDI + "|" + this.f.cDI);
        this.f.cDI = ((DownloadInfo)localObject).cDI;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.f.cDI);
      arwt.i("AppCenterReporter", ">reportDownloadError " + bool + "|" + (String)localObject + "|" + this.f.cDI + "|");
    } while (!bool);
    arwt.i("AppCenterReporter", "[reportDownloadError] errorCode=" + this.val$errorCode + ",errorMsg=" + this.val$errorMsg);
    arwk.report(3006, arwk.c(this.f) + "|" + arwk.d(this.f) + "|" + this.val$errorCode + "|" + this.val$errorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.3
 * JD-Core Version:    0.7.0.1
 */