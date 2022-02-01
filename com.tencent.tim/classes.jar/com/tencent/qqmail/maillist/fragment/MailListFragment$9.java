package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.watcher.MailSentWatcher;

class MailListFragment$9
  implements MailSentWatcher
{
  MailListFragment$9(MailListFragment paramMailListFragment) {}
  
  public void onSendMailSuccess(int paramInt)
  {
    if ((MailListFragment.access$2800(this.this$0) != 3) || (MailListFragment.access$200(this.this$0) == null)) {
      return;
    }
    MailListFragment.access$200(this.this$0).refresh(new MailListFragment.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.9
 * JD-Core Version:    0.7.0.1
 */