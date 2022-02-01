package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.watcher.SearchMailWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SearchListFragment$1
  implements SearchMailWatcher
{
  SearchListFragment$1(SearchListFragment paramSearchListFragment) {}
  
  public void onComplete()
  {
    QMLog.log(4, "SearchListFragment", "SearchMailWatcher onComplete reset!");
    SearchListFragment.access$400(this.this$0, new SearchListFragment.1.3(this));
  }
  
  public void onError(QMNetworkError paramQMNetworkError, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SearchMailWatcher onError: ");
    if (paramQMNetworkError != null) {}
    for (paramQMNetworkError = paramQMNetworkError.toString();; paramQMNetworkError = "null")
    {
      QMLog.log(4, "SearchListFragment", paramQMNetworkError + ", isRunning:" + paramBoolean);
      SearchListFragment.access$300(this.this$0, new SearchListFragment.1.2(this, paramBoolean));
      return;
    }
  }
  
  public void onLock(int paramInt1, int paramInt2)
  {
    QMLog.log(4, "SearchListFragment", "SearchMailWatcher onLock accountId:" + paramInt1 + ", personalCnt:" + paramInt2);
    if (paramInt2 <= 0) {
      return;
    }
    SearchListFragment.access$1000(this.this$0, new SearchListFragment.1.4(this, paramInt1, paramInt2));
  }
  
  public void onProcess(long paramLong) {}
  
  public void onSuccess(long[] paramArrayOfLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SearchMailWatcher onSuccess length:");
    if (paramArrayOfLong != null) {}
    for (Object localObject = Integer.valueOf(paramArrayOfLong.length);; localObject = "null")
    {
      QMLog.log(4, "SearchListFragment", localObject + ", isRunning:" + paramBoolean);
      SearchListFragment.access$200(this.this$0, new SearchListFragment.1.1(this, paramArrayOfLong, paramBoolean));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.1
 * JD-Core Version:    0.7.0.1
 */