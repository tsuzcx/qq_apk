package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BigAttachDownloader$4
  implements QMCallback.IErrorCallback
{
  BigAttachDownloader$4(BigAttachDownloader paramBigAttachDownloader) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if (BigAttachDownloader.access$000(this.this$0) != null) {
      BigAttachDownloader.access$000(this.this$0).handleError(paramQMNetworkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.BigAttachDownloader.4
 * JD-Core Version:    0.7.0.1
 */