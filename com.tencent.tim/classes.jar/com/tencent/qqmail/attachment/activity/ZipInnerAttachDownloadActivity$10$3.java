package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class ZipInnerAttachDownloadActivity$10$3
  implements Runnable
{
  ZipInnerAttachDownloadActivity$10$3(ZipInnerAttachDownloadActivity.10 param10) {}
  
  public void run()
  {
    if (!QMNetworkUtils.isNetworkConnected(this.this$1.this$0)) {
      ZipInnerAttachDownloadActivity.access$1600(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipInnerAttachDownloadActivity.10.3
 * JD-Core Version:    0.7.0.1
 */