package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;

class MailListFragment$3
  implements Runnable
{
  MailListFragment$3(MailListFragment paramMailListFragment, Runnable paramRunnable) {}
  
  public void run()
  {
    MailListFragment.access$200(this.this$0).refresh(true, new MailListFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.3
 * JD-Core Version:    0.7.0.1
 */