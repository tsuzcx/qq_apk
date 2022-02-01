package com.tencent.mobileqq.minigame.manager;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import asum;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class FileDownloadManager
{
  private static final String TAG = "FileDownloadManager";
  private static boolean enableDownloader;
  private static ConcurrentHashMap<String, Call> taskMap;
  
  static
  {
    boolean bool = true;
    taskMap = new ConcurrentHashMap();
    if (QzoneConfig.getInstance().getConfig("qqtriton", "minigamesdkenabledownloader", 1) > 0) {}
    for (;;)
    {
      enableDownloader = bool;
      return;
      bool = false;
    }
  }
  
  public static void abort(String paramString)
  {
    if (enableDownloader)
    {
      MiniappDownloadUtil.getInstance().abort(paramString);
      return;
    }
    Call localCall = (Call)taskMap.get(paramString);
    if (localCall != null) {
      localCall.cancel();
    }
    taskMap.remove(paramString);
  }
  
  @NonNull
  private static DownloaderProxy.DownloadListener.DownloadResult convertDownloadResult(DownloadResult paramDownloadResult, Map<String, List<String>> paramMap)
  {
    DownloadReport localDownloadReport = paramDownloadResult.getReport();
    return new DownloaderProxy.DownloadListener.DownloadResult(paramDownloadResult.getUrl(), localDownloadReport.httpStatus, localDownloadReport.isSucceed, paramDownloadResult.getDescInfo(), false, localDownloadReport.t_wait, localDownloadReport.t_prepare, localDownloadReport.t_conn, localDownloadReport.t_recvdata, localDownloadReport.totaltime, localDownloadReport.fileSize, paramMap);
  }
  
  public static boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    if (enableDownloader) {
      return downloadWithDownloader(paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
    }
    return downloadWithOkhttp(paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
  }
  
  private static boolean downloadWithDownloader(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    MiniappDownloadUtil.getInstance().download(paramString1, paramString2, false, new FileDownloadManager.2(paramDownloadListener, paramString1), Downloader.DownloadMode.OkHttpMode, asum.b(paramMap));
    return true;
  }
  
  private static boolean downloadWithOkhttp(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    paramMap = MiniOkHttpClientFactory.getDownloadClient(true).newCall(asum.a(paramString1, paramMap, "GET", null, null));
    paramMap.enqueue(new FileDownloadManager.1(paramString1, paramDownloadListener, paramString2, SystemClock.uptimeMillis()));
    taskMap.put(paramString1, paramMap);
    return true;
  }
  
  public static void preConnectDownloader()
  {
    if (enableDownloader) {
      GamePreConnectManager.preConnectDownloaderForSDK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager
 * JD-Core Version:    0.7.0.1
 */