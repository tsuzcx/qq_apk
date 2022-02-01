package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SubscribeListFragment$3
  implements MailDeleteWatcher
{
  SubscribeListFragment$3(SubscribeListFragment paramSubscribeListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (SubscribeListFragment.access$900(this.this$0).canHandleDelete(paramArrayOfLong)) {
      SubscribeListFragment.access$1000(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.3
 * JD-Core Version:    0.7.0.1
 */