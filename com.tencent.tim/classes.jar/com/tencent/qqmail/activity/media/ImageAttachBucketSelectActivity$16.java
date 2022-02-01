package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.protocol.DataCollector;

class ImageAttachBucketSelectActivity$16
  implements View.OnClickListener
{
  ImageAttachBucketSelectActivity$16(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity, Attach paramAttach) {}
  
  public void onClick(View paramView)
  {
    ImageAttachBucketSelectActivity.access$2600(this.this$0, this.val$attach.getAccountId(), this.val$attach.getFolderId(), this.val$attach.getBelongMailId(), this.val$attach.getMailSubject(), this.val$attach.getMailSender(), this.val$attach.getMailSenderAddr(), this.val$attach.getRemoteId());
    DataCollector.logEvent("Event_Attach_BackToMail");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.16
 * JD-Core Version:    0.7.0.1
 */