package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import moai.oss.OssHelper;

class ZipOnlinePreviewActivity$6
  implements QMCallback.IErrorCallback
{
  ZipOnlinePreviewActivity$6(ZipOnlinePreviewActivity paramZipOnlinePreviewActivity, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "ZipAttachmentActivity", "downloadJson error code: " + paramQMNetworkError.code + " desp: " + paramQMNetworkError.desp);
    ZipOnlinePreviewActivity.access$600(this.this$0).sendEmptyMessage(1);
    if (ZipOnlinePreviewActivity.access$100(this.this$0) == 1) {
      if (this.val$suffix == null)
      {
        paramQMNetworkRequest = "zip";
        OssHelper.attachDecompressFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramQMNetworkRequest, "" });
      }
    }
    do
    {
      return;
      paramQMNetworkRequest = this.val$suffix;
      break;
      if (ZipOnlinePreviewActivity.access$100(this.this$0) == 3)
      {
        if (this.val$suffix == null) {}
        for (paramQMNetworkRequest = "zip";; paramQMNetworkRequest = this.val$suffix)
        {
          OssHelper.ftnattachDecompressFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramQMNetworkRequest, "" });
          return;
        }
      }
    } while (ZipOnlinePreviewActivity.access$100(this.this$0) != 2);
    if (this.val$suffix == null) {}
    for (paramQMNetworkRequest = "zip";; paramQMNetworkRequest = this.val$suffix)
    {
      OssHelper.bigattachDecompressFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramQMNetworkRequest, "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity.6
 * JD-Core Version:    0.7.0.1
 */