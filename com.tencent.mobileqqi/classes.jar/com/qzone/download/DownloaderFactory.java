package com.qzone.download;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.NetworkState;
import com.qzone.common.logging.Log;
import com.qzone.common.logging.QDLog;
import com.qzone.download.impl.DownloaderImpl;
import com.qzone.download.impl.ImageDownloaderInitializer;
import com.qzone.download.strategy.KeepAliveStrategy;
import com.qzone.download.uinterface.IDownloadConfig;
import com.qzone.utils.thread.ThreadPool;
import java.util.concurrent.Executor;

public class DownloaderFactory
{
  private static boolean inited = false;
  private static Context sContext;
  private static IDownloadConfig sDownloadConfig;
  private static Executor sGlobalExecutor;
  private static KeepAliveStrategy sKpStrategy;
  
  public static Downloader createDownloader(String paramString)
  {
    return createDownloader(paramString, null);
  }
  
  public static Downloader createDownloader(String paramString, Executor paramExecutor)
  {
    if ((sContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = new DownloaderImpl(sContext, paramString);
    paramString.setExecutor(paramExecutor);
    return paramString;
  }
  
  public static Downloader createImageDownloader(String paramString)
  {
    if ((sContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = new DownloaderImpl(sContext, paramString);
    ImageDownloaderInitializer.initImageDownloader(paramString);
    return paramString;
  }
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static IDownloadConfig getDownloadConfig()
  {
    return sDownloadConfig;
  }
  
  public static ThreadPool getGlobalThreadPool()
  {
    if (sGlobalExecutor != null) {
      return new ThreadPool(sGlobalExecutor);
    }
    return ThreadPool.getInstance();
  }
  
  public static KeepAliveStrategy getKeepAliveStrategy()
  {
    return sKpStrategy;
  }
  
  public static Log getLog()
  {
    return QDLog.getLog();
  }
  
  public static void init(Context paramContext, Executor paramExecutor)
  {
    if (inited) {
      return;
    }
    inited = true;
    sContext = paramContext.getApplicationContext();
    sGlobalExecutor = paramExecutor;
    NetworkManager.init(sContext);
    NetworkState.g().setContext(sContext);
  }
  
  public static void setDownloadConfig(IDownloadConfig paramIDownloadConfig)
  {
    sDownloadConfig = paramIDownloadConfig;
  }
  
  public static void setKeepAliveStrategy(KeepAliveStrategy paramKeepAliveStrategy)
  {
    sKpStrategy = paramKeepAliveStrategy;
  }
  
  public static void setLog(Log paramLog)
  {
    QDLog.setLog(paramLog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */