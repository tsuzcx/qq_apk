package com.tencent.moai.downloader.delegate;

import com.tencent.moai.downloader.network.HttpRequest;
import com.tencent.moai.downloader.network.HttpResponse;

public abstract interface HandleErrorDelegate
{
  public abstract void handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.delegate.HandleErrorDelegate
 * JD-Core Version:    0.7.0.1
 */