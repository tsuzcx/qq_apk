package com.tencent.qqmini.miniapp.proxy;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;

class VideoJsProxyDefault$6
  implements Runnable
{
  VideoJsProxyDefault$6(VideoJsProxyDefault paramVideoJsProxyDefault, String paramString, LocalMediaInfo paramLocalMediaInfo, long paramLong, VideoJsProxyDefault.BridgeInfo paramBridgeInfo) {}
  
  public void run()
  {
    VideoJsProxyDefault.access$800(this.this$0, "正在获取视频封面，请稍后");
    boolean bool = VideoJsProxyDefault.access$1000(this.this$0, VideoJsProxyDefault.access$900(this.this$0, this.val$path), this.val$info);
    QMLog.d("VideoJsProxyImpl", "saveThumbnail : " + bool);
    VideoJsProxyDefault.access$1100(this.this$0);
    VideoJsProxyDefault.access$1200(this.this$0, this.val$path, this.val$size, this.val$info, this.val$bridgeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.6
 * JD-Core Version:    0.7.0.1
 */