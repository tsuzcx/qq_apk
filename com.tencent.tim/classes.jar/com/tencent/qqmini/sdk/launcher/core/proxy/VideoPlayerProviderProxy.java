package com.tencent.qqmini.sdk.launcher.core.proxy;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;

public abstract interface VideoPlayerProviderProxy
{
  public abstract String getUrl(String paramString);
  
  public abstract ReliableVideoPlayer getVideoPlayer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy
 * JD-Core Version:    0.7.0.1
 */