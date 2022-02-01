package com.tencent.moai.downloader.interceptor;

import com.tencent.moai.downloader.network.HttpRequest;

public abstract interface RequestInterceptor
{
  public abstract HttpRequest intercept(HttpRequest paramHttpRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.interceptor.RequestInterceptor
 * JD-Core Version:    0.7.0.1
 */