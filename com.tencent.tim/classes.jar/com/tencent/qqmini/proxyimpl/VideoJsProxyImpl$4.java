package com.tencent.qqmini.proxyimpl;

import asxf;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;

public class VideoJsProxyImpl$4
  implements Runnable
{
  public VideoJsProxyImpl$4(asxf paramasxf, String paramString, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt) {}
  
  public void run()
  {
    asxf.a(this.this$0, "正在获取视频封面，请稍后");
    boolean bool = asxf.a(this.this$0, asxf.a(this.this$0, this.val$path), this.val$info);
    QLog.d("VideoJsPlugin", 2, "saveThumbnail : " + bool);
    asxf.a(this.this$0);
    asxf.a(this.this$0, this.val$path, this.val$size, this.val$info, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */