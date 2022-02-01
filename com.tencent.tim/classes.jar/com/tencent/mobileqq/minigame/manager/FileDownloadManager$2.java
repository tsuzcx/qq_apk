package com.tencent.mobileqq.minigame.manager;

import android.os.SystemClock;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.MiniDownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import java.util.List;
import java.util.Map;

final class FileDownloadManager$2
  implements Downloader.MiniDownloadListener
{
  private long beginEnqueue = SystemClock.uptimeMillis();
  Map<String, List<String>> headers;
  
  FileDownloadManager$2(DownloaderProxy.DownloadListener paramDownloadListener, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadFailed(-5, "abort");
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadFailed(paramDownloadResult.getStatus().httpStatus, paramDownloadResult.getStatus().getErrorMessage());
    }
  }
  
  public void onDownloadHeadersReceived(String paramString, int paramInt, Map<String, List<String>> paramMap)
  {
    this.headers = paramMap;
    if (this.val$listener != null) {
      this.val$listener.onDownloadHeadersReceived(paramInt, paramMap);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadProgress(paramFloat, ((float)paramLong * paramFloat), paramLong);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.val$listener != null) {
      this.val$listener.onDownloadSucceed(paramDownloadResult.getStatus().httpStatus, paramDownloadResult.getPath(), FileDownloadManager.access$100(paramDownloadResult, this.headers));
    }
    QLog.e("FileDownloadManager", 1, "downloadWithDownloader [timecost=" + (SystemClock.uptimeMillis() - this.beginEnqueue) + "][receiveData=" + paramDownloadResult.getReport().t_recvdata + "][connect=" + paramDownloadResult.getReport().t_conn + "][duration=" + paramDownloadResult.getProcess().duration + "][totalDuration=" + paramDownloadResult.getProcess().totalDuration + "][wait=" + paramDownloadResult.getReport().t_wait + "][url=" + this.val$url + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */