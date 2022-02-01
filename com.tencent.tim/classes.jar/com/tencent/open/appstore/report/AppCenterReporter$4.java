package com.tencent.open.appstore.report;

import android.text.TextUtils;
import arvt;
import arwk;
import arwt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.InstallStartLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$4
  implements Runnable
{
  public AppCenterReporter$4(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.f == null) {}
    boolean bool;
    do
    {
      return;
      localObject = arvt.a().d(this.f.ticket);
      if (localObject != null)
      {
        arwt.i("AppCenterReporter", ">reportInstallStart " + ((DownloadInfo)localObject).cDI + "|" + this.f.cDI);
        this.f.cDI = ((DownloadInfo)localObject).cDI;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.f.cDI);
      arwt.i("AppCenterReporter", ">reportInstallStart " + bool + "|" + (String)localObject + "|" + this.f.cDI + "|");
    } while (!bool);
    arwt.i("AppCenterReporter", "[reportInstallStart]");
    arwk.report(3007, arwk.c(this.f) + "|" + arwk.d(this.f) + "|" + new File(this.f.filePath).length());
    Object localObject = new InstallStartLog();
    ((InstallStartLog)localObject).packageName = this.f.packageName;
    ((InstallStartLog)localObject).versionCode = this.f.versionCode;
    ((InstallStartLog)localObject).downloadUrl = this.f.urlStr;
    try
    {
      ((InstallStartLog)localObject).yybAppId = Long.parseLong(this.f.appId);
      ((InstallStartLog)localObject).yybApkId = Long.parseLong(this.f.cCL);
      label297:
      ((InstallStartLog)localObject).traceId = this.f.uniqueId;
      ((InstallStartLog)localObject).installStartTime = System.currentTimeMillis();
      ((InstallStartLog)localObject).externalParams = new HashMap();
      ((InstallStartLog)localObject).externalParams.put("via", this.f.via);
      ((InstallStartLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label297;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.4
 * JD-Core Version:    0.7.0.1
 */