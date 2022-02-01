package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.HashMap;

class MailListFragment$MailListOnRightViewClickListener$1$1
  implements Runnable
{
  MailListFragment$MailListOnRightViewClickListener$1$1(MailListFragment.MailListOnRightViewClickListener.1 param1) {}
  
  public void run()
  {
    QMLog.log(4, "MailListFragment", "onRightViewClick begin Delete, mAccountId:" + MailListFragment.access$2200(this.this$2.this$1.this$0) + ", mailIds:" + this.this$2.val$mail.getInformation().getId());
    MailListFragment.access$400(this.this$2.this$1.this$0).put(Integer.valueOf(this.this$2.val$position), Long.valueOf(this.this$2.val$mail.getInformation().getId()));
    MailListFragment.access$2900(this.this$2.this$1.this$0).deleteMail(MailListFragment.access$2200(this.this$2.this$1.this$0), this.this$2.val$mail.getInformation().getId(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.MailListOnRightViewClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */