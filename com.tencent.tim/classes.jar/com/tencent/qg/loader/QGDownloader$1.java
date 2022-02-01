package com.tencent.qg.loader;

import android.os.Handler;
import asge;
import asgf;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class QGDownloader$1
  implements Runnable
{
  public QGDownloader$1(asge paramasge, String paramString) {}
  
  public void run()
  {
    boolean bool = asgf.loadSo("QGDownloader.onSuccess");
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGDownloader", 2, "onSoDownload. loadSo fail. set status to fail.");
      }
      this.this$0.mStatus = 2;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QGDownloader.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.loader.QGDownloader.1
 * JD-Core Version:    0.7.0.1
 */