package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.watcher.MailRejectWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ConvMailListFragment$2
  implements MailRejectWatcher
{
  ConvMailListFragment$2(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    ConvMailListFragment.access$500(this.this$0).refresh(new ConvMailListFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.2
 * JD-Core Version:    0.7.0.1
 */