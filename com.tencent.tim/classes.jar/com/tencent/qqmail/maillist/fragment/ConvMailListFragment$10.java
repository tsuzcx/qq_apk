package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ConvMailListFragment$10
  implements MailPurgeDeleteWatcher
{
  ConvMailListFragment$10(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (ConvMailListFragment.access$1400(this.this$0).canHandleDelete(paramArrayOfLong)) {
      ConvMailListFragment.access$1500(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.10
 * JD-Core Version:    0.7.0.1
 */