package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailOperate;

class AggregateMailListFragment$33$2
  implements Runnable
{
  AggregateMailListFragment$33$2(AggregateMailListFragment.33 param33, Mail paramMail) {}
  
  public void run()
  {
    AggregateMailListFragment.access$3200(this.this$1.this$0).deleteMail(AggregateMailListFragment.access$2000(this.this$1.this$0), new long[] { this.val$mail.getInformation().getId() }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.33.2
 * JD-Core Version:    0.7.0.1
 */