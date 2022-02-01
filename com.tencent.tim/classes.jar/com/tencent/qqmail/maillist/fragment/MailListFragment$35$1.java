package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailManager;

class MailListFragment$35$1
  implements Runnable
{
  MailListFragment$35$1(MailListFragment.35 param35, long[] paramArrayOfLong) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().updateMailRencetOpTime(this.val$mailId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.35.1
 * JD-Core Version:    0.7.0.1
 */