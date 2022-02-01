package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.MailUI;

class ReadMailFragment$95$1
  implements Runnable
{
  ReadMailFragment$95$1(ReadMailFragment.95 param95) {}
  
  public void run()
  {
    if (this.this$1.val$isMoveOut) {
      ReadMailFragment.access$5000(this.this$1.this$0).moveOutOfAdvertise(ReadMailFragment.access$200(this.this$1.this$0), ReadMailFragment.access$000(this.this$1.this$0));
    }
    for (;;)
    {
      ReadMailFragment.access$16500(this.this$1.this$0, this.this$1.val$isConvMail);
      return;
      ReadMailFragment.access$5000(this.this$1.this$0).moveIntoAdvertise(ReadMailFragment.access$200(this.this$1.this$0), ReadMailFragment.access$000(this.this$1.this$0));
      if (!this.this$1.val$isConvMail) {
        ReadMailFragment.access$16400(this.this$1.this$0, ReadMailFragment.access$000(this.this$1.this$0).getInformation().getId());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.95.1
 * JD-Core Version:    0.7.0.1
 */