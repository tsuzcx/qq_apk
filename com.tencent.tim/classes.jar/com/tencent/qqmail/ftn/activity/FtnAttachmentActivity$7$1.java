package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.ui.FtnFileInformationView;
import java.util.Date;

class FtnAttachmentActivity$7$1
  implements Runnable
{
  FtnAttachmentActivity$7$1(FtnAttachmentActivity.7 param7) {}
  
  public void run()
  {
    FtnAttachmentActivity.access$1600(this.this$1.this$0);
    int i = FtnAttachmentActivity.access$1700(this.this$1.this$0).expiretime;
    int j = FtnCommonUtils.getExpireTimeFromNowSecond(FtnAttachmentActivity.access$1800(this.this$1.this$0));
    if (i <= j)
    {
      FtnManager.sharedInstance().updateFtn(FtnAttachmentActivity.access$000(this.this$1.this$0).getFid(), "expiretime", j + "");
      i = FtnCommonUtils.getExpireTimeFromNowSecond(FtnAttachmentActivity.access$1800(this.this$1.this$0));
      FtnAttachmentActivity.access$000(this.this$1.this$0).setExpire(i * 1000);
      Date localDate = new Date(i * 1000L);
      FtnAttachmentActivity.access$1900(this.this$1.this$0).setFileValidTime(FtnCommonUtils.getExpireTimeString(localDate));
      return;
    }
    FtnAttachmentActivity.access$000(this.this$1.this$0).setExpire(i * 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.7.1
 * JD-Core Version:    0.7.0.1
 */