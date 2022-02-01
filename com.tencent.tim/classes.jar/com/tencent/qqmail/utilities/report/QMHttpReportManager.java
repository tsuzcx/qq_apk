package com.tencent.qqmail.utilities.report;

import com.tencent.qqmail.utilities.log.QMLog;
import java.net.MalformedURLException;
import java.net.URL;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

public class QMHttpReportManager
{
  private static final String HTTP_TAG = "HttpRequest";
  
  public static void connect(long paramLong, String paramString, boolean paramBoolean, Throwable paramThrowable)
  {
    if (QMReportManager.ReportType.HTTP_OSS_WATCH.enable())
    {
      if (paramBoolean) {
        KvHelper.httpConnectSuccess(new double[0]);
      }
    }
    else {
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 3;; i = 5)
    {
      logHttpRequest(i, paramLong, paramString, "http connect, success: " + paramBoolean, paramThrowable);
      return;
      KvHelper.httpConnectFail(new double[0]);
      break;
    }
  }
  
  public static void handleData(long paramLong, String paramString, boolean paramBoolean, Throwable paramThrowable)
  {
    int i = 3;
    try
    {
      URL localURL = new URL(paramString);
      String str = localURL.getPath();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (str.startsWith("/cgi-bin/")) {
          localObject1 = str.substring("/cgi-bin/".length());
        }
      }
      OssHelper.handleDataFail(new Object[] { localURL.getHost(), localObject1, paramThrowable });
      if (paramBoolean) {}
      for (;;)
      {
        logHttpRequest(i, paramLong, paramString, "http handle data, success: " + paramBoolean, paramThrowable);
        return;
        i = 5;
      }
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  private static void logHttpRequest(int paramInt, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.log(paramInt, "HttpRequest", paramString2 + ", elapse: " + paramLong + "ms, url: " + paramString1 + ", network: " + QMReportManager.getNetwork() + ", operator: " + QMReportManager.getOperator(), paramThrowable);
  }
  
  public static void openConnection(long paramLong, String paramString, boolean paramBoolean, Throwable paramThrowable)
  {
    if (paramBoolean) {}
    for (int i = 3;; i = 5)
    {
      logHttpRequest(i, paramLong, paramString, "http openConnect success: " + paramBoolean, paramThrowable);
      return;
    }
  }
  
  public static void post(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, Throwable paramThrowable)
  {
    if (QMReportManager.ReportType.HTTP_OSS_WATCH.enable())
    {
      if (paramBoolean2) {
        KvHelper.httpPostSuccess(new double[0]);
      }
    }
    else {
      if (!paramBoolean2) {
        break label76;
      }
    }
    label76:
    for (int i = 3;; i = 5)
    {
      logHttpRequest(i, paramLong, paramString, "http post, success: " + paramBoolean2 + ", isMulti: " + paramBoolean1, paramThrowable);
      return;
      KvHelper.httpPostFail(new double[0]);
      break;
    }
  }
  
  public static void read(long paramLong, String paramString, boolean paramBoolean, Throwable paramThrowable)
  {
    if (QMReportManager.ReportType.HTTP_OSS_WATCH.enable())
    {
      if (paramBoolean) {
        KvHelper.httpReadSuccess(new double[0]);
      }
    }
    else {
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 3;; i = 5)
    {
      logHttpRequest(i, paramLong, paramString, "http read, success: " + paramBoolean, paramThrowable);
      return;
      KvHelper.httpReadFail(new double[0]);
      break;
    }
  }
  
  public static void response(long paramLong, String paramString, boolean paramBoolean, int paramInt, Throwable paramThrowable)
  {
    if ((paramString != null) && (paramString.contains("uma_photo_sync_content")) && ((paramInt == 404) || (paramInt == 304))) {
      return;
    }
    if (QMReportManager.ReportType.HTTP_OSS_WATCH.enable())
    {
      if (paramBoolean) {
        KvHelper.httpResponseSuccess(new double[0]);
      }
    }
    else {
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i = 3;; i = 5)
    {
      logHttpRequest(i, paramLong, paramString, "http getResponse, success: " + paramBoolean + ", code: " + paramInt, paramThrowable);
      return;
      KvHelper.httpResponseFail(new double[0]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.report.QMHttpReportManager
 * JD-Core Version:    0.7.0.1
 */