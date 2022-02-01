package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$9
  implements AccountLoginWatcher
{
  ReadMailFragment$9(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    ReadMailFragment.access$2700(this.this$0, new ReadMailFragment.9.2(this, paramInt1));
  }
  
  public void onProcess(int paramInt, long paramLong) {}
  
  public void onSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    ReadMailFragment.access$2600(this.this$0, new ReadMailFragment.9.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.9
 * JD-Core Version:    0.7.0.1
 */