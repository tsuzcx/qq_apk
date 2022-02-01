package com.tencent.qqmini.miniapp.proxy;

import com.tencent.qqmini.miniapp.util.VideoCompress.Listener;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;
import java.io.File;

class VideoCompressProxyDefault$1
  implements Runnable
{
  VideoCompressProxyDefault$1(VideoCompressProxyDefault paramVideoCompressProxyDefault) {}
  
  public void run()
  {
    QMLog.i("VideoCompress", "start compress " + VideoCompressProxyDefault.access$000(this.this$0).path);
    VideoCompressProxyDefault.access$100(this.this$0).onStart();
    File localFile1 = new File(VideoCompressProxyDefault.access$200(this.this$0).path);
    File localFile2 = new File(VideoCompressProxyDefault.access$300(this.this$0));
    int i = 1;
    boolean bool = false;
    for (;;)
    {
      if (i <= 100) {}
      try
      {
        Thread.sleep(Math.round(Math.random() * 200.0D));
        label102:
        if (i == 50) {
          bool = FileUtils.copyFile(localFile1, localFile2);
        }
        VideoCompressProxyDefault.access$400(this.this$0).onProgress(String.format("progress:%s", new Object[] { Integer.valueOf(i) }), i / 100.0F);
        i += 1;
        continue;
        if (bool) {
          VideoCompressProxyDefault.access$500(this.this$0).onSuccess("compress success");
        }
        for (;;)
        {
          VideoCompressProxyDefault.access$700(this.this$0).onFinish(bool);
          return;
          VideoCompressProxyDefault.access$600(this.this$0).onFailure("compress failed");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label102;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoCompressProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */