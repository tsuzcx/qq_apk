package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor;
import com.tencent.qqmail.model.mail.watcher.SubscribeMailWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SubscribeListFragment$1
  implements SubscribeMailWatcher
{
  SubscribeListFragment$1(SubscribeListFragment paramSubscribeListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkError = SubscribeListFragment.access$000(this.this$0);
    if (paramQMNetworkError != null) {
      paramQMNetworkError.releaseLock(true);
    }
    if ((paramQMNetworkError != null) && (!paramQMNetworkError.isLoading())) {
      SubscribeListFragment.access$600(this.this$0, new SubscribeListFragment.1.2(this, paramQMNetworkError));
    }
  }
  
  public void onSuccess(long paramLong)
  {
    QMSubscribeColumnCursor localQMSubscribeColumnCursor = SubscribeListFragment.access$000(this.this$0);
    if (localQMSubscribeColumnCursor != null) {
      localQMSubscribeColumnCursor.releaseLock(false);
    }
    if ((localQMSubscribeColumnCursor != null) && (!localQMSubscribeColumnCursor.isLoading())) {
      SubscribeListFragment.access$300(this.this$0, new SubscribeListFragment.1.1(this, localQMSubscribeColumnCursor));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.1
 * JD-Core Version:    0.7.0.1
 */