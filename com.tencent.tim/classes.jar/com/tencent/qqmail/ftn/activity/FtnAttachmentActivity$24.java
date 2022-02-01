package com.tencent.qqmail.ftn.activity;

import android.content.res.Resources;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareLinkDialogHelper;

class FtnAttachmentActivity$24
  implements Runnable
{
  FtnAttachmentActivity$24(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void run()
  {
    new QMShareLinkDialogHelper(this.this$0, this.this$0.getResources().getString(2131692325), FtnAttachmentActivity.access$000(this.this$0).getPreview().getDownloadUrl(), FtnAttachmentActivity.access$000(this.this$0).getName()).createDialog().show();
    DataCollector.logEvent("Event_Share_Big_Attach_From_Ftn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.24
 * JD-Core Version:    0.7.0.1
 */