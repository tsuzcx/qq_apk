package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class MailListFragment$5
  implements MailUnReadWatcher
{
  MailListFragment$5(MailListFragment paramMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (MailListFragment.access$2900(this.this$0).canHandleUnread(paramArrayOfLong)) {
      MailListFragment.access$5800(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.5
 * JD-Core Version:    0.7.0.1
 */