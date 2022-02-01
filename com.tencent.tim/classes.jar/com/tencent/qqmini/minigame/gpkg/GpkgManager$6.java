package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.List;
import java.util.Map;

final class GpkgManager$6
  implements DownloaderProxy.DownloadListener
{
  GpkgManager$6(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString1, String paramString2, MiniGamePkg paramMiniGamePkg, int paramInt) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    MiniReportManager.reportEventType(this.val$gameInfo, 614, null, null, null, paramInt, "1", 0L, null);
    if (this.val$listener != null)
    {
      this.val$listener.onInitGpkgInfo(2010, null, "download sub pkg fail", null);
      QMLog.d("[minigame] GpkgManager", "onDownloadFailed() called with: s = [" + paramInt + "], downloadResult = [" + paramString + "]");
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (this.val$listener != null)
    {
      float f = paramFloat;
      long l = paramLong2;
      if (paramLong2 == 0L)
      {
        f = paramFloat;
        l = paramLong2;
        if (this.val$fileSize > 0)
        {
          paramLong2 = this.val$fileSize;
          f = paramFloat;
          l = paramLong2;
          if (paramLong2 > paramLong1)
          {
            f = (float)paramLong1 * 1.0F / (float)paramLong2;
            l = paramLong2;
          }
        }
      }
      this.val$listener.onDownloadGpkgProgress(this.val$gameInfo, f, l);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    MiniReportManager.reportEventType(this.val$gameInfo, 614, "1");
    paramDownloadResult = GpkgManager.access$100(this.val$savePath);
    paramString = ApkgManager.getApkgFolderPath(this.val$gameInfo);
    paramDownloadResult = new File(paramDownloadResult);
    MiniReportManager.reportEventType(this.val$gameInfo, 615, "1");
    boolean bool = WxapkgUnpacker.unpackSync(paramDownloadResult.getAbsolutePath(), paramString, this.val$subRoot, true);
    paramDownloadResult = this.val$gameInfo;
    if (bool)
    {
      paramInt = 0;
      MiniReportManager.reportEventType(paramDownloadResult, 616, null, null, null, paramInt, "1", 0L, null);
      QMLog.d("[minigame] GpkgManager", "downloadSubPack | getResPath :hasUnpack=" + bool + "; folderPath=" + paramString + "; subRoot=" + this.val$subRoot);
      if (!bool) {
        break label172;
      }
      if (this.val$listener != null) {
        this.val$listener.onInitGpkgInfo(0, this.val$miniGamePkg, "download sub pkg and unpack succeed", null);
      }
    }
    label172:
    while (this.val$listener == null)
    {
      return;
      paramInt = 1;
      break;
    }
    this.val$listener.onInitGpkgInfo(2011, null, "download sub pkg succeed, but unpack sub pkg fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.6
 * JD-Core Version:    0.7.0.1
 */