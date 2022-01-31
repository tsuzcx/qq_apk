package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpRequest;

public abstract interface KeepAliveStrategy
{
  public abstract KeepAlive keepAlive(String paramString, HttpRequest paramHttpRequest);
  
  public abstract boolean supportKeepAlive(String paramString);
  
  public static enum KeepAlive {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.KeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */