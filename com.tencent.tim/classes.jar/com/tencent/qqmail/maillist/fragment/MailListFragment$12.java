package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailRejectWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class MailListFragment$12
  implements MailRejectWatcher
{
  MailListFragment$12(MailListFragment paramMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    MailListFragment.access$6100(this.this$0, new MailListFragment.12.1(this));
    MailListFragment.access$5800(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.12
 * JD-Core Version:    0.7.0.1
 */