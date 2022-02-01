package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;

class MailRecallListFragment$3
  implements Runnable
{
  MailRecallListFragment$3(MailRecallListFragment paramMailRecallListFragment) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().queryRecallMail(MailRecallListFragment.access$1700(this.this$0).getInformation().getAccountId(), MailRecallListFragment.access$1700(this.this$0).getInformation().getId(), MailRecallListFragment.access$900(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailRecallListFragment.3
 * JD-Core Version:    0.7.0.1
 */