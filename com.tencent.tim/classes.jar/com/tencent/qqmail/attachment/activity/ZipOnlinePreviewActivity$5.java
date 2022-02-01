package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachmentUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import moai.oss.OssHelper;

class ZipOnlinePreviewActivity$5
  implements QMCallback.ISuccessCallback
{
  ZipOnlinePreviewActivity$5(ZipOnlinePreviewActivity paramZipOnlinePreviewActivity, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "ZipAttachmentActivity", "compress preview json success");
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    ZipOnlinePreviewActivity.access$800(this.this$0, paramQMNetworkRequest, ZipOnlinePreviewActivity.access$300(this.this$0));
    if (ZipOnlinePreviewActivity.access$300(this.this$0) != null)
    {
      paramQMNetworkRequest = StringExtention.MD5With32Charactor(ZipOnlinePreviewActivity.access$900(this.this$0) + ZipOnlinePreviewActivity.access$1000(this.this$0).getName() + ZipOnlinePreviewActivity.access$1000(this.this$0).getSize() + "zip");
      ZipOnlinePreviewActivity.access$300(this.this$0).setKeyName(paramQMNetworkRequest);
    }
    ZipOnlinePreviewActivity.access$600(this.this$0).sendEmptyMessage(0);
    if (ZipOnlinePreviewActivity.access$100(this.this$0) == 1) {
      if (this.val$suffix == null)
      {
        paramQMNetworkRequest = "zip";
        OssHelper.attachDecompressSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramQMNetworkRequest, "" });
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
          OssHelper.ftnattachDecompressSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramQMNetworkRequest, "" });
          return;
        }
      }
    } while (ZipOnlinePreviewActivity.access$100(this.this$0) != 2);
    if (this.val$suffix == null) {}
    for (paramQMNetworkRequest = "zip";; paramQMNetworkRequest = this.val$suffix)
    {
      OssHelper.bigattachDecompressSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramQMNetworkRequest, "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity.5
 * JD-Core Version:    0.7.0.1
 */