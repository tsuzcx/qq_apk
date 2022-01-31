package com.tencent.component.network;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.handler.a;
import com.tencent.component.network.downloader.impl.ipc.Const;
import org.apache.http.HttpResponse;

class DownloaderFactory$2
  implements a
{
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    paramDownloadResult = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty(paramDownloadResult)) {}
    while (!Const.f(paramDownloadResult, "image")) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.DownloaderFactory.2
 * JD-Core Version:    0.7.0.1
 */