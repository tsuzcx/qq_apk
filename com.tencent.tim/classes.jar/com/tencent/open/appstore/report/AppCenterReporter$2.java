package com.tencent.open.appstore.report;

import android.text.TextUtils;
import arvt;
import arwk;
import arwt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.DownloadFinishLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$2
  implements Runnable
{
  public AppCenterReporter$2(DownloadInfo paramDownloadInfo) {}
  
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
        arwt.i("AppCenterReporter", ">reportDownloadSucc " + ((DownloadInfo)localObject).cDI + "|" + this.f.cDI);
        this.f.cDI = ((DownloadInfo)localObject).cDI;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.f.cDI);
      arwt.i("AppCenterReporter", ">reportDownloadSucc " + bool + "|" + (String)localObject + "|" + this.f.cDI + "|");
    } while (!bool);
    arwt.i("AppCenterReporter", "[reportDownloadSucc]");
    arwk.report(3005, arwk.c(this.f) + "|" + arwk.d(this.f) + "|" + new File(this.f.filePath).length());
    Object localObject = new DownloadFinishLog();
    ((DownloadFinishLog)localObject).packageName = this.f.packageName;
    ((DownloadFinishLog)localObject).versionCode = this.f.versionCode;
    ((DownloadFinishLog)localObject).downloadUrl = this.f.urlStr;
    try
    {
      ((DownloadFinishLog)localObject).yybAppId = Long.parseLong(this.f.appId);
      ((DownloadFinishLog)localObject).yybApkId = Long.parseLong(this.f.cCL);
      label297:
      ((DownloadFinishLog)localObject).traceId = this.f.uniqueId;
      ((DownloadFinishLog)localObject).downloadFinishTime = System.currentTimeMillis();
      ((DownloadFinishLog)localObject).externalParams = new HashMap();
      ((DownloadFinishLog)localObject).externalParams.put("via", this.f.via);
      ((DownloadFinishLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label297;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.2
 * JD-Core Version:    0.7.0.1
 */