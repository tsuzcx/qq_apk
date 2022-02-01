package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.List;
import java.util.Map;

class BaseLibManager$3
  implements DownloaderProxy.DownloadListener
{
  BaseLibManager$3(BaseLibManager paramBaseLibManager, BaseLibManager.UpdateListener paramUpdateListener, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.i("miniapp-process_BaseLibManager", "ApkgManager--onDownloadFailed");
    if (this.val$listener != null) {
      this.val$listener.onUpdateResult(1101);
    }
    for (;;)
    {
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 617, null, null, null, 1101);
      return;
      BaseLibManager.access$200(this.this$0, 1101);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    QMLog.i("miniapp-process_BaseLibManager", "ApkgManager--onDownloadSucceed");
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, null, null, null, 0);
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, null, null, null, 0);
    for (;;)
    {
      try
      {
        paramString = this.this$0.getBaseLibDir(this.val$url, this.val$version);
        paramDownloadResult = new File(paramString);
        if (this.this$0.isBaseLibDirValid(paramDownloadResult))
        {
          QMLog.i("miniapp-process_BaseLibManager", "unZipPath has downloaded and unziped!");
          if (BaseLibInfo.needUpdateVersion(this.val$version, this.val$oldVersion))
          {
            QMLog.i("miniapp-process_BaseLibManager", "update baselib local version from:" + this.val$oldVersion + " to:" + this.val$version);
            StorageUtil.getPreference().edit().putString("downloadUrl", this.val$url).commit();
            StorageUtil.getPreference().edit().putString("version", this.val$version).commit();
          }
          if (this.val$listener != null)
          {
            this.val$listener.onUpdateResult(0);
            return;
          }
          BaseLibManager.access$200(this.this$0, 0);
          continue;
        }
        QMLog.e("miniapp-process_BaseLibManager", "unZipFolder failed, read last path.");
      }
      catch (Exception paramString)
      {
        QMLog.e("miniapp-start", "ApkgManager--unZipFolder exception.", paramString);
        if (this.val$listener == null) {
          break label634;
        }
        this.val$listener.onUpdateResult(1103);
        return;
        if (paramDownloadResult.exists()) {
          FileUtils.delete(paramString, false);
        }
        paramDownloadResult.mkdir();
        paramInt = ZipUtil.unZipFolder(this.val$downloadZipPath, paramString);
        if (paramInt != 0) {
          break label647;
        }
        bool = BaseLibManager.verifyBaselib(paramDownloadResult);
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 7, null, null, null, 0);
        if ((paramInt == 0) && (bool))
        {
          QMLog.i("miniapp-process_BaseLibManager", "unZipFolder succeed.url:" + this.val$url + ",version:" + this.val$version);
          StorageUtil.getPreference().edit().putString("downloadUrl", this.val$url).apply();
          StorageUtil.getPreference().edit().putString("version", this.val$version).apply();
          if ((!TextUtils.isEmpty(this.val$oldUrl)) && (!TextUtils.isEmpty(this.val$oldVersion)) && (!TextUtils.equals(this.val$oldUrl, this.val$url)) && (!TextUtils.equals(this.val$oldVersion, this.val$version)))
          {
            QMLog.i("miniapp-process_BaseLibManager", "delete last path.");
            paramDownloadResult = this.this$0.getBaseLibDir(this.val$oldUrl, this.val$oldVersion);
            if (!paramDownloadResult.equals(paramString))
            {
              QMLog.i("miniapp-start", "delete last path. oldUrl : " + this.val$oldUrl + "; version : " + this.val$version);
              FileUtils.delete(paramDownloadResult, false);
            }
          }
          if (this.val$listener != null)
          {
            this.val$listener.onUpdateResult(0);
            return;
          }
          BaseLibManager.access$200(this.this$0, 0);
          continue;
        }
      }
      finally
      {
        FileUtils.delete(this.val$downloadZipPath, true);
      }
      FileUtils.delete(paramString, false);
      if (this.val$listener != null) {
        this.val$listener.onUpdateResult(1102);
      }
      for (;;)
      {
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 618, null, null, null, 1102);
        break;
        BaseLibManager.access$200(this.this$0, 1102);
      }
      label634:
      BaseLibManager.access$200(this.this$0, 1103);
      continue;
      label647:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.3
 * JD-Core Version:    0.7.0.1
 */