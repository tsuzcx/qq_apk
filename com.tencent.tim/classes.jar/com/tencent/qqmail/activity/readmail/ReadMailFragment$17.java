package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$17
  implements MailPurgeDeleteWatcher
{
  ReadMailFragment$17(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleDelete(paramArrayOfLong)) {
      ReadMailFragment.access$6800(this.this$0, new ReadMailFragment.17.2(this));
    }
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleDelete(paramArrayOfLong)) {
      ReadMailFragment.access$6700(this.this$0, new ReadMailFragment.17.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.17
 * JD-Core Version:    0.7.0.1
 */