package com.tencent.qqmini.proxyimpl;

import asxf;
import awcf;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import cooperation.qzone.util.QZLog;
import java.io.File;

public class VideoJsProxyImpl$5
  implements Runnable
{
  public VideoJsProxyImpl$5(asxf paramasxf, LocalMediaInfo paramLocalMediaInfo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    QZLog.i("VideoJsPlugin", 1, "start copy from " + this.val$info.path);
    String str = ((IMiniAppFileManager)asxf.a(this.this$0).getManager(IMiniAppFileManager.class)).getTmpPath(this.val$suffix);
    if (str.contains(" "))
    {
      QLog.w("VideoJsPlugin", 1, "wrong copy path " + str);
      str = ((IMiniAppFileManager)asxf.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.val$info.path);
      asxf.a(this.this$0, str, this.val$info.fileSize, this.val$info);
      return;
    }
    File localFile = new File(str);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (awcf.copyFile(new File(this.val$info.path), localFile))
    {
      this.val$info.path = str;
      asxf.a(this.this$0, this.val$info, this.val$changeSize);
      return;
    }
    QLog.w("VideoJsPlugin", 1, "copy file failed");
    str = ((IMiniAppFileManager)asxf.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.val$info.path);
    asxf.a(this.this$0, str, this.val$info.fileSize, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */