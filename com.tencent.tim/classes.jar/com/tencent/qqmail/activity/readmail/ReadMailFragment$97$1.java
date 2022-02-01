package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.MailUI;

class ReadMailFragment$97$1
  implements Runnable
{
  ReadMailFragment$97$1(ReadMailFragment.97 param97) {}
  
  public void run()
  {
    if (this.this$1.val$mustBeAd)
    {
      ReadMailFragment.access$5000(this.this$1.this$0).mustBeAdvertise(ReadMailFragment.access$200(this.this$1.this$0), ReadMailFragment.access$000(this.this$1.this$0));
      if (!this.this$1.val$isConvMail) {
        ReadMailFragment.access$16400(this.this$1.this$0, ReadMailFragment.access$000(this.this$1.this$0).getInformation().getId());
      }
    }
    for (;;)
    {
      ReadMailFragment.access$16500(this.this$1.this$0, this.this$1.val$isConvMail);
      return;
      ReadMailFragment.access$5000(this.this$1.this$0).mustNotBeAdvertise(ReadMailFragment.access$200(this.this$1.this$0), ReadMailFragment.access$000(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.97.1
 * JD-Core Version:    0.7.0.1
 */