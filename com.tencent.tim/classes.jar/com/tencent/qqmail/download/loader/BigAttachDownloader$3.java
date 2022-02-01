package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BigAttachDownloader$3
  implements QMCallback.ISuccessCallback
{
  BigAttachDownloader$3(BigAttachDownloader paramBigAttachDownloader) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    BigAttachDownloader.access$502(this.this$0, paramQMNetworkResponse.getResponseString());
    BigAttachDownloader.access$502(this.this$0, BigAttachDownloader.access$500(this.this$0).trim());
    this.this$0.getInfoFromCGIDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.BigAttachDownloader.3
 * JD-Core Version:    0.7.0.1
 */