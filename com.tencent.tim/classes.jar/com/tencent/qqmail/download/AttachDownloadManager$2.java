package com.tencent.qqmail.download;

import com.tencent.moai.downloader.delegate.HandleErrorDelegate;
import com.tencent.moai.downloader.network.HttpRequest;
import com.tencent.moai.downloader.network.HttpResponse;
import com.tencent.qqmail.download.model.BigAttachDownloadError;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.ConcurrentHashMap;

class AttachDownloadManager$2
  implements HandleErrorDelegate
{
  AttachDownloadManager$2(AttachDownloadManager paramAttachDownloadManager) {}
  
  public void handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    if ((paramHttpResponse != null) && (paramHttpRequest != null))
    {
      String str = paramHttpResponse.getHeaderField("User-ReturnCode");
      paramHttpResponse = paramHttpResponse.getHeaderField("ServerIP");
      paramHttpRequest = paramHttpRequest.getRequestUrl();
      QMLog.log(4, "AttachDownloadManager", "url:" + paramHttpRequest + ", User-ReturnCode:" + str + ", svrIp:" + paramHttpResponse);
      AttachDownloadManager.access$000(this.this$0).put(paramHttpRequest, new BigAttachDownloadError(str, paramHttpResponse));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.AttachDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */