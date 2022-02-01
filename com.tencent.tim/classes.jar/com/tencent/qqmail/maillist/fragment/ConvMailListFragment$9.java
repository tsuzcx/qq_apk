package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ConvMailListFragment$9
  implements MailDeleteWatcher
{
  ConvMailListFragment$9(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    ConvMailListFragment.access$1800(this.this$0, new ConvMailListFragment.9.1(this, paramArrayOfLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.9
 * JD-Core Version:    0.7.0.1
 */