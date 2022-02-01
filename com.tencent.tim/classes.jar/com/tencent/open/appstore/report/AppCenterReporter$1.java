package com.tencent.open.appstore.report;

import arwk;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.DownloadStartLog;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$1
  implements Runnable
{
  public AppCenterReporter$1(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    arwt.i("AppCenterReporter", "[reportDownloadStart]");
    arwk.report(3004, arwk.c(this.f) + "|" + arwk.d(this.f));
    arwk.t(this.f);
    DownloadStartLog localDownloadStartLog = new DownloadStartLog();
    localDownloadStartLog.packageName = this.f.packageName;
    localDownloadStartLog.versionCode = this.f.versionCode;
    localDownloadStartLog.downloadUrl = this.f.urlStr;
    try
    {
      localDownloadStartLog.yybAppId = Long.parseLong(this.f.appId);
      localDownloadStartLog.yybApkId = Long.parseLong(this.f.cCL);
      label124:
      localDownloadStartLog.traceId = this.f.uniqueId;
      localDownloadStartLog.downloadStartTime = System.currentTimeMillis();
      localDownloadStartLog.externalParams = new HashMap();
      localDownloadStartLog.externalParams.put("via", this.f.via);
      localDownloadStartLog.doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label124;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.1
 * JD-Core Version:    0.7.0.1
 */