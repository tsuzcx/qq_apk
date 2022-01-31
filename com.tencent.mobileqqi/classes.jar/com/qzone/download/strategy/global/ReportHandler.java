package com.qzone.download.strategy.global;

import com.qzone.download.DownloadReport;
import com.qzone.download.DownloadResult;
import com.qzone.report.DownloadImageReport.DownloadReportObject;
import org.apache.http.HttpResponse;

public abstract interface ReportHandler
{
  public abstract boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
  
  public abstract void handleReport(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport);
  
  public abstract DownloadImageReport.DownloadReportObject obtainReportObj(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport);
  
  public abstract void uploadReport(DownloadImageReport.DownloadReportObject paramDownloadReportObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.strategy.global.ReportHandler
 * JD-Core Version:    0.7.0.1
 */