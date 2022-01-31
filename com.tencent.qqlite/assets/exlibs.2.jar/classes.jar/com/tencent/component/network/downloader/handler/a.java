package com.tencent.component.network.downloader.handler;

import com.tencent.component.network.downloader.DownloadResult;
import org.apache.http.HttpResponse;

public abstract interface a<T>
{
  public abstract boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.handler.a
 * JD-Core Version:    0.7.0.1
 */