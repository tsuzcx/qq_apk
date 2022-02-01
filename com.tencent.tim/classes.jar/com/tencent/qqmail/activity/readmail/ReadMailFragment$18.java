package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailTagWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$18
  implements MailTagWatcher
{
  ReadMailFragment$18(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleMove(paramArrayOfLong)) {
      ReadMailFragment.access$7000(this.this$0, new ReadMailFragment.18.2(this));
    }
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    ReadMailFragment.access$6900(this.this$0, new ReadMailFragment.18.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.18
 * JD-Core Version:    0.7.0.1
 */