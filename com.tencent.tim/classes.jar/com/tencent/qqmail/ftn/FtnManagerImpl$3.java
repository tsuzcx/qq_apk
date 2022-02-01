package com.tencent.qqmail.ftn;

import com.tencent.moai.downloader.interceptor.RequestInterceptor;
import com.tencent.moai.downloader.network.HttpRequest;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Map;

final class FtnManagerImpl$3
  implements RequestInterceptor
{
  FtnManagerImpl$3(String paramString1, String paramString2) {}
  
  public HttpRequest intercept(HttpRequest paramHttpRequest)
  {
    Map localMap = paramHttpRequest.getRequestHeader();
    localMap.put("Cookie", this.val$cookie_key + "=" + this.val$cookie_val);
    QMLog.log(3, "FtnManagerImpl", "fileDownload, headers: " + localMap);
    return paramHttpRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */