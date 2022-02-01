package com.tencent.biz.qqcircle.download;

import aqmb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;
import ozq;
import ozq.a;

public class QCircleResourceDownloadManager$1
  implements Runnable
{
  public QCircleResourceDownloadManager$1(ozq paramozq, String paramString, ozq.a parama) {}
  
  public void run()
  {
    String str = this.this$0.aY(this.val$downloadUrl);
    File localFile = new File(str);
    if (aqmb.Cg() == null)
    {
      QLog.i(ozq.TAG, 1, "getFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.b != null) {
        this.b.C(false, "");
      }
    }
    if (localFile.exists())
    {
      QLog.i(ozq.TAG, 1, "getFile success, the file is exist path:" + str);
      if (this.b != null) {
        this.b.C(true, str);
      }
      return;
    }
    if (this.b != null) {
      ozq.a(this.this$0, this.val$downloadUrl, this.b);
    }
    if (ozq.a(this.this$0).contains(this.val$downloadUrl))
    {
      QLog.i(ozq.TAG, 1, "getFile ..., file is downloading");
      return;
    }
    QLog.i(ozq.TAG, 1, "getFile ..., start download");
    ozq.a(this.this$0, this.val$downloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */