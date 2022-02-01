package com.tencent.biz.qqcircle.download;

import aqmb;
import com.tencent.qphone.base.util.QLog;
import ozq;
import ozq.a;
import ozs;

public class QCircleResourceDownloadManager$3
  implements Runnable
{
  public void run()
  {
    if (aqmb.Cg() == null)
    {
      QLog.i(ozq.TAG, 1, "downloadOrUpdateFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.b != null) {
        this.b.C(false, "");
      }
    }
    if (this.b != null) {
      ozq.a(this.this$0, this.val$downloadUrl, this.b);
    }
    this.this$0.a(this.val$downloadUrl, new ozs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */