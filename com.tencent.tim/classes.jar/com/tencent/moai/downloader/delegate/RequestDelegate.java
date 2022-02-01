package com.tencent.moai.downloader.delegate;

import com.tencent.moai.downloader.network.HttpRequest;

public abstract interface RequestDelegate
{
  public abstract void abort(HttpRequest paramHttpRequest);
  
  public abstract void start(HttpRequest paramHttpRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.delegate.RequestDelegate
 * JD-Core Version:    0.7.0.1
 */