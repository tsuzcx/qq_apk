package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import com.tencent.qqmail.attachment.model.AttachmentUI;
import com.tencent.qqmail.ftn.Ftn.ItemRarDownloadInfo;
import com.tencent.qqmail.ftn.Ftn.ItemRarPreviewOutput;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;
import moai.oss.OssHelper;

class ZipOnlinePreviewActivity$1
  extends IObserver
{
  ZipOnlinePreviewActivity$1(ZipOnlinePreviewActivity paramZipOnlinePreviewActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(4, "ZipAttachmentActivity", "compress file online preview success");
    paramObservable = "zip";
    if (ZipOnlinePreviewActivity.access$000(this.this$0) != null) {
      paramObservable = FileUtil.getFileNameSuffix(ZipOnlinePreviewActivity.access$000(this.this$0).getName());
    }
    Object localObject;
    if (ZipOnlinePreviewActivity.access$100(this.this$0) == 1)
    {
      localObject = paramObservable;
      if (paramObservable == null) {
        localObject = "zip";
      }
      OssHelper.attachDecompressSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", localObject, "" });
    }
    for (;;)
    {
      paramObservable = (ItemRarPreviewOutput)((HashMap)paramObject).get("actiongetfilerarpreviewprvdata");
      paramObject = paramObservable.info;
      localObject = paramObject.downloadhost;
      int i = ((String)localObject).lastIndexOf("/cgi-bin/");
      if (i > 0) {
        ZipOnlinePreviewActivity.access$202(this.this$0, ((String)localObject).substring(0, i));
      }
      ZipOnlinePreviewActivity.access$400(this.this$0, paramObservable, ZipOnlinePreviewActivity.access$000(this.this$0).getName(), ZipOnlinePreviewActivity.access$000(this.this$0).getSize(), ZipOnlinePreviewActivity.access$300(this.this$0));
      ZipOnlinePreviewActivity.access$300(this.this$0).setvKey(paramObject.vkey);
      ZipOnlinePreviewActivity.access$300(this.this$0).setDownHost(paramObject.downloadhost);
      ZipOnlinePreviewActivity.access$500(this.this$0);
      ZipOnlinePreviewActivity.access$600(this.this$0).sendEmptyMessage(0);
      return;
      if (ZipOnlinePreviewActivity.access$100(this.this$0) == 3)
      {
        localObject = paramObservable;
        if (paramObservable == null) {
          localObject = "zip";
        }
        OssHelper.ftnattachDecompressSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", localObject, "" });
      }
      else if (ZipOnlinePreviewActivity.access$100(this.this$0) == 2)
      {
        localObject = paramObservable;
        if (paramObservable == null) {
          localObject = "zip";
        }
        OssHelper.bigattachDecompressSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ZipAttachmentActivity", localObject, "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */