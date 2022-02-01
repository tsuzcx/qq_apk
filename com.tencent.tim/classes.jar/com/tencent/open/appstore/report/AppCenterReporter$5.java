package com.tencent.open.appstore.report;

import android.text.TextUtils;
import arvt;
import arwk;
import arwt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.InstallFinishLog;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$5
  implements Runnable
{
  public AppCenterReporter$5(DownloadInfo paramDownloadInfo, int paramInt) {}
  
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
        arwt.i("AppCenterReporter", ">reportInstallComplete " + ((DownloadInfo)localObject).cDI + "|" + this.f.cDI);
        this.f.cDI = ((DownloadInfo)localObject).cDI;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.f.cDI);
      arwt.i("AppCenterReporter", ">reportInstallComplete " + bool + "|" + (String)localObject + "|" + this.f.cDI + "|");
    } while (!bool);
    arwt.i("AppCenterReporter", "[reportInstallComplete]");
    arwk.report(3008, arwk.c(this.f) + "|" + arwk.d(this.f) + "|" + this.eld + "|" + arwk.bl(this.f.packageName));
    Object localObject = new InstallFinishLog();
    ((InstallFinishLog)localObject).packageName = this.f.packageName;
    ((InstallFinishLog)localObject).versionCode = this.f.versionCode;
    ((InstallFinishLog)localObject).downloadUrl = this.f.urlStr;
    try
    {
      ((InstallFinishLog)localObject).yybAppId = Long.parseLong(this.f.appId);
      ((InstallFinishLog)localObject).yybApkId = Long.parseLong(this.f.cCL);
      label302:
      ((InstallFinishLog)localObject).traceId = this.f.uniqueId;
      ((InstallFinishLog)localObject).installEndTime = System.currentTimeMillis();
      ((InstallFinishLog)localObject).externalParams = new HashMap();
      ((InstallFinishLog)localObject).externalParams.put("via", this.f.via);
      ((InstallFinishLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label302;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.5
 * JD-Core Version:    0.7.0.1
 */