package com.tencent.oskplayer.proxy;

class VideoProxy$4
  implements Runnable
{
  VideoProxy$4(VideoProxy paramVideoProxy, VideoProxy.PreloadInfo paramPreloadInfo, long paramLong, PreloadListener paramPreloadListener, String paramString) {}
  
  public void run()
  {
    VideoProxy.access$100(this.this$0, this.val$info.localUrl, this.val$cacheMaxBytes, this.val$listener, this.val$logTag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.4
 * JD-Core Version:    0.7.0.1
 */