package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;
import moai.oss.OssHelper;

class ZipOnlinePreviewActivity$2
  extends IObserver
{
  ZipOnlinePreviewActivity$2(ZipOnlinePreviewActivity paramZipOnlinePreviewActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(5, "ZipAttachmentActivity", "compress file online preview fail");
    if (ZipOnlinePreviewActivity.access$000(this.this$0) != null) {}
    for (paramObservable = FileUtil.getFileNameSuffix(ZipOnlinePreviewActivity.access$000(this.this$0).getName());; paramObservable = "zip")
    {
      paramObject = (HashMap)paramObject;
      if ((paramObject != null) && (paramObject.get("paramerrordescription") != null))
      {
        paramObject = (String)paramObject.get("paramerrordescription");
        if ("desc:" + paramObject != null) {
          QMLog.log(5, "ZipAttachmentActivity", paramObject);
        }
      }
      else
      {
        if (ZipOnlinePreviewActivity.access$100(this.this$0) != 1) {
          break label194;
        }
        paramObject = paramObservable;
        if (paramObservable == null) {
          paramObject = "zip";
        }
        OssHelper.attachDecompressFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramObject, "" });
      }
      for (;;)
      {
        ZipOnlinePreviewActivity.access$600(this.this$0).sendEmptyMessage(2);
        return;
        paramObject = "";
        break;
        label194:
        if (ZipOnlinePreviewActivity.access$100(this.this$0) == 3)
        {
          paramObject = paramObservable;
          if (paramObservable == null) {
            paramObject = "zip";
          }
          OssHelper.ftnattachDecompressFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramObject, "" });
        }
        else if (ZipOnlinePreviewActivity.access$100(this.this$0) == 2)
        {
          paramObject = paramObservable;
          if (paramObservable == null) {
            paramObject = "zip";
          }
          OssHelper.bigattachDecompressFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", paramObject, "" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */