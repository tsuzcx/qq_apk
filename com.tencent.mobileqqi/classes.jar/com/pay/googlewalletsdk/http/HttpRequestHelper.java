package com.pay.googlewalletsdk.http;

import com.pay.googlewaletsdk.entity.DownloadInfo;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.entity.RequestInfo.changkeyType;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpRequestHelper
{
  private static Object lock = new Object();
  private static HttpRequestHelper requestHelper;
  private HashMap<String, BaseHttpClient> requestMap = new HashMap();
  ExecutorService resortThread = Executors.newFixedThreadPool(1);
  
  public static HttpRequestHelper getIntanceHttpRequestHelper()
  {
    if (requestHelper == null) {}
    synchronized (lock)
    {
      if (requestHelper == null) {
        requestHelper = new HttpRequestHelper();
      }
      return requestHelper;
    }
  }
  
  public void dispose()
  {
    this.requestMap.clear();
    this.requestMap = null;
    requestHelper = null;
    this.resortThread.shutdownNow();
    this.resortThread = null;
  }
  
  public void startRequestInfo(final DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      RequestInfo localRequestInfo = (RequestInfo)paramDownloadInfo;
      paramDownloadInfo = new Thread(new Runnable()
      {
        public void run()
        {
          BaseHttpClient localBaseHttpClient = NetWorkFactory.getInstanceFactory().createHttpClient(paramDownloadInfo);
          localBaseHttpClient.agency = NetWorkFactory.getInstanceFactory().createHttpResolve(paramDownloadInfo, HttpRequestHelper.this.requestMap);
          localBaseHttpClient.connect();
        }
      });
      if (localRequestInfo.changeKey == RequestInfo.changkeyType.Nonmal) {
        paramDownloadInfo.start();
      }
    }
    else
    {
      return;
    }
    this.resortThread.execute(paramDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.HttpRequestHelper
 * JD-Core Version:    0.7.0.1
 */