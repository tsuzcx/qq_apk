package com.tencent.qqmail.ftn.activity;

import android.content.Intent;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.ui.QMTips;

class FtnAttachmentActivity$5$1
  implements Runnable
{
  FtnAttachmentActivity$5$1(FtnAttachmentActivity.5 param5) {}
  
  public void run()
  {
    FtnAttachmentActivity.access$1300(this.this$1.this$0).hide();
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "delete");
    localIntent.putExtra("fid", FtnAttachmentActivity.access$000(this.this$1.this$0).getFid());
    this.this$1.this$0.setResult(9, localIntent);
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.5.1
 * JD-Core Version:    0.7.0.1
 */