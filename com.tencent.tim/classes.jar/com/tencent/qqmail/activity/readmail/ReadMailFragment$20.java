package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailRejectWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$20
  implements MailRejectWatcher
{
  ReadMailFragment$20(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    ReadMailFragment.access$7700(this.this$0, new ReadMailFragment.20.2(this));
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    ReadMailFragment.access$7600(this.this$0, new ReadMailFragment.20.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.20
 * JD-Core Version:    0.7.0.1
 */