package com.tencent.qqmail.ftn;

import com.tencent.moai.downloader.delegate.HandleErrorDelegate;
import com.tencent.moai.downloader.network.HttpRequest;
import com.tencent.moai.downloader.network.HttpResponse;
import com.tencent.qqmail.download.model.BigAttachDownloadError;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.ConcurrentHashMap;

final class FtnManagerImpl$4
  implements HandleErrorDelegate
{
  public void handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    if ((paramHttpResponse != null) && (paramHttpRequest != null))
    {
      String str = paramHttpResponse.getHeaderField("User-ReturnCode");
      paramHttpResponse = paramHttpResponse.getHeaderField("ServerIP");
      paramHttpRequest = paramHttpRequest.getRequestUrl();
      QMLog.log(4, "FtnManagerImpl", "url:" + paramHttpRequest + ", User-ReturnCode:" + str + ", svrIp:" + paramHttpResponse);
      FtnManagerImpl.access$600().put(paramHttpRequest, new BigAttachDownloadError(str, paramHttpResponse));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */