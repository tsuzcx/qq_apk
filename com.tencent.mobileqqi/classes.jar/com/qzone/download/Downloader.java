package com.qzone.download;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.download.strategy.DownloadProcessStrategy;
import com.qzone.download.strategy.IPConfigStrategy;
import com.qzone.download.strategy.PortConfigStrategy;
import com.qzone.download.strategy.global.ReportHandler;
import com.qzone.report.BusinessReport;
import com.qzone.report.DownloadImageReport.DownloadReportObject;
import com.qzone.report.ImageDownloadReporter;
import java.util.Map;

public abstract class Downloader
{
  protected IPConfigStrategy pBackupIPConfigStrategy;
  protected IPConfigStrategy pDirectIPConfigStrategy;
  protected DownloadMode pDownloadMode = DownloadMode.FastMode;
  protected NetworkFlowStatistics pNetworkFlowStatistics;
  protected PortConfigStrategy pPortConfigStrategy;
  protected DownloadProcessStrategy pProcessStrategy;
  protected ReportHandler pReportHandler;
  
  public Downloader(Context paramContext) {}
  
  public abstract void abort(String paramString, DownloadListener paramDownloadListener, boolean paramBoolean);
  
  public abstract void cancel();
  
  public abstract void cancel(String paramString1, String paramString2, DownloadListener paramDownloadListener);
  
  public abstract boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean);
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, DownloadListener paramDownloadListener)
  {
    return download(paramString1, paramString2, paramBoolean, null, paramDownloadListener);
  }
  
  public abstract boolean download(String paramString1, String paramString2, boolean paramBoolean, Map<String, Object> paramMap, DownloadListener paramDownloadListener);
  
  public void enableReport()
  {
    if (this.pReportHandler == null)
    {
      BusinessReport.init();
      this.pReportHandler = new ImageDownloadReporter();
    }
  }
  
  public abstract void enableResumeDownload();
  
  public String generateUrlKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    return paramString;
  }
  
  public void report(DownloadImageReport.DownloadReportObject paramDownloadReportObject, int paramInt1, int paramInt2)
  {
    BusinessReport.init();
    BusinessReport.uploadReport(paramDownloadReportObject, paramInt1, paramInt2);
  }
  
  public void setBackupIPConfigStrategy(IPConfigStrategy paramIPConfigStrategy)
  {
    this.pBackupIPConfigStrategy = paramIPConfigStrategy;
  }
  
  public void setDirectIPConfigStrategy(IPConfigStrategy paramIPConfigStrategy)
  {
    this.pDirectIPConfigStrategy = paramIPConfigStrategy;
  }
  
  public void setDownloadMode(DownloadMode paramDownloadMode)
  {
    this.pDownloadMode = paramDownloadMode;
  }
  
  public void setNetworkFlowStatistics(NetworkFlowStatistics paramNetworkFlowStatistics)
  {
    this.pNetworkFlowStatistics = paramNetworkFlowStatistics;
  }
  
  public void setPortConfigStrategy(PortConfigStrategy paramPortConfigStrategy)
  {
    this.pPortConfigStrategy = paramPortConfigStrategy;
  }
  
  public void setProcessStrategy(DownloadProcessStrategy paramDownloadProcessStrategy)
  {
    this.pProcessStrategy = paramDownloadProcessStrategy;
  }
  
  public static enum DownloadMode
  {
    FastMode,  StrictMode;
  }
  
  public class DownloadParams
  {
    public static final String Range = "range";
    
    public DownloadParams() {}
  }
  
  public static abstract interface NetworkFlowStatistics
  {
    public abstract void onDownloadFlow(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onUploadFlow(String paramString, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.Downloader
 * JD-Core Version:    0.7.0.1
 */