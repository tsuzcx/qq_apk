package com.tencent.qqmail.download;

import com.tencent.moai.downloader.interceptor.RequestInterceptor;
import com.tencent.moai.downloader.network.HttpRequest;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Map;

class ImageDownloadManager$3
  implements RequestInterceptor
{
  ImageDownloadManager$3(ImageDownloadManager paramImageDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public HttpRequest intercept(HttpRequest paramHttpRequest)
  {
    Map localMap = paramHttpRequest.getRequestHeader();
    if ((this.val$info.getCookies() != null) && (this.val$info.getCookies().size() > 0)) {
      localMap.put("Cookie", DownloadUtil.formatCookie(this.val$info.getCookies()));
    }
    paramHttpRequest.setRequestHeader(localMap);
    return paramHttpRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */