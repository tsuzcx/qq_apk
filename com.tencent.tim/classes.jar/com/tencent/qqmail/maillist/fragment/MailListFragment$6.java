package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.QMTips;

class MailListFragment$6
  implements MailDeleteWatcher
{
  MailListFragment$6(MailListFragment paramMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    if (MailListFragment.access$5900(this.this$0)) {
      this.this$0.getTips().hide();
    }
    MailListFragment.access$5902(this.this$0, false);
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    MailListFragment.access$6000(this.this$0, new MailListFragment.6.1(this, paramArrayOfLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.6
 * JD-Core Version:    0.7.0.1
 */