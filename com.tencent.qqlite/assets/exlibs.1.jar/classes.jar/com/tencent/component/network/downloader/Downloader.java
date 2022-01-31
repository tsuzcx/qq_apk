package com.tencent.component.network.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class Downloader
{
  protected Context mContext = null;
  protected IPConfigStrategy pBackupIPConfig;
  protected com.tencent.component.network.downloader.handler.a pContentHandler;
  protected IPConfigStrategy pDirectIPConfig;
  protected DownloadMode pDownloadMode = DownloadMode.FastMode;
  protected ReportHandler pExternalReportHandler;
  protected PriorityThreadPool pExternalThreadPool;
  protected com.tencent.component.network.downloader.handler.b pFileHandler;
  protected KeepAliveStrategy pKeepAliveStrategy;
  protected String pName;
  protected NetworkFlowStatistics pNetworkFlowStatistics;
  protected PortConfigStrategy pPortConfigStrategy;
  protected DownloadPreprocessStrategy pProcessStrategy;
  protected ReportHandler pReportHandler;
  protected ResumeTransfer pResumeTransfer;
  protected com.tencent.component.network.module.cache.a.b pTmpFileCache;
  protected a pUrlKeyGenerator;
  
  public Downloader(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.pName = paramString;
    this.pTmpFileCache = com.tencent.component.network.module.cache.a.a(this.mContext);
  }
  
  public abstract void abort(String paramString, DownloadListener paramDownloadListener);
  
  public abstract void cancel(String paramString, DownloadListener paramDownloadListener);
  
  public abstract boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean);
  
  public final boolean download(String paramString1, String paramString2, DownloadListener paramDownloadListener)
  {
    return download(paramString1, paramString2, true, paramDownloadListener);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return download(paramString1, paramString2, paramBoolean, paramDownloadListener, this.pDownloadMode);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, DownloadListener paramDownloadListener, DownloadMode paramDownloadMode)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return download(paramString1, new String[] { paramString2 }, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean, DownloadListener paramDownloadListener)
  {
    return download(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, this.pDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean, DownloadListener paramDownloadListener, DownloadMode paramDownloadMode)
  {
    return download(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, DownloadListener paramDownloadListener, DownloadMode paramDownloadMode)
  {
    if ((!Const.a(paramString)) || (paramArrayOfString == null)) {
      return false;
    }
    paramString = new DownloadRequest(paramString, paramArrayOfString, paramBoolean1, paramDownloadListener);
    paramString.mode = paramDownloadMode;
    return download(paramString, paramBoolean2);
  }
  
  public void enableResumeTransfer()
  {
    this.pResumeTransfer = new QzoneResumeTransfer(this.mContext, "tmp_" + Const.b(this.mContext) + "_" + this.pName, this.pTmpFileCache);
  }
  
  protected String generateStorageName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return UUID.randomUUID().toString();
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public String generateUrlKey(String paramString)
  {
    Object localObject = this.pUrlKeyGenerator;
    if (localObject == null) {
      localObject = paramString;
    }
    while (TextUtils.isEmpty((CharSequence)localObject))
    {
      return paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = paramString;
      } else if (!NetworkUtils.isNetworkUrl(paramString)) {
        localObject = paramString;
      } else {
        localObject = ((a)localObject).a(paramString);
      }
    }
    return localObject;
  }
  
  public KeepAliveStrategy getKeepAliveStrategy()
  {
    return this.pKeepAliveStrategy;
  }
  
  public void setBackupIPConfigStrategy(IPConfigStrategy paramIPConfigStrategy)
  {
    this.pBackupIPConfig = paramIPConfigStrategy;
  }
  
  public void setContentHandler(com.tencent.component.network.downloader.handler.a parama)
  {
    this.pContentHandler = parama;
  }
  
  public void setDirectIPConfigStrategy(IPConfigStrategy paramIPConfigStrategy)
  {
    this.pDirectIPConfig = paramIPConfigStrategy;
  }
  
  public void setDownloadMode(DownloadMode paramDownloadMode)
  {
    this.pDownloadMode = paramDownloadMode;
  }
  
  public void setExecutor(Executor paramExecutor)
  {
    if (paramExecutor == null)
    {
      this.pExternalThreadPool = null;
      return;
    }
    this.pExternalThreadPool = new PriorityThreadPool(paramExecutor);
  }
  
  public void setExternalReportHandler(ReportHandler paramReportHandler)
  {
    this.pExternalReportHandler = paramReportHandler;
  }
  
  public void setFileHandler(com.tencent.component.network.downloader.handler.b paramb)
  {
    this.pFileHandler = paramb;
  }
  
  public void setKeepAliveStrategy(KeepAliveStrategy paramKeepAliveStrategy)
  {
    this.pKeepAliveStrategy = paramKeepAliveStrategy;
  }
  
  public void setNetworkFlowStatistics(NetworkFlowStatistics paramNetworkFlowStatistics)
  {
    this.pNetworkFlowStatistics = paramNetworkFlowStatistics;
  }
  
  public void setPortConfigStrategy(PortConfigStrategy paramPortConfigStrategy)
  {
    this.pPortConfigStrategy = paramPortConfigStrategy;
    DownloaderFactory.getInstance(this.mContext).setPortStrategy(this.pPortConfigStrategy);
  }
  
  public void setPreprocessStrategy(DownloadPreprocessStrategy paramDownloadPreprocessStrategy)
  {
    this.pProcessStrategy = paramDownloadPreprocessStrategy;
  }
  
  public void setReportHandler(ReportHandler paramReportHandler)
  {
    this.pReportHandler = paramReportHandler;
  }
  
  public void setUrlKeyGenerator(a parama)
  {
    this.pUrlKeyGenerator = parama;
  }
  
  public static abstract interface DownloadListener
  {
    public abstract void onDownloadCanceled(String paramString);
    
    public abstract void onDownloadFailed(String paramString, DownloadResult paramDownloadResult);
    
    public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
    
    public abstract void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult);
  }
  
  public static enum DownloadMode {}
  
  public static abstract interface NetworkFlowStatistics
  {
    public abstract void onDownloadFlow(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onUploadFlow(String paramString, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.Downloader
 * JD-Core Version:    0.7.0.1
 */