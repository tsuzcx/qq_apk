package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailSpamWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$19
  implements MailSpamWatcher
{
  ReadMailFragment$19(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    ReadMailFragment.access$7300(this.this$0, new ReadMailFragment.19.2(this));
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    ReadMailFragment.access$7200(this.this$0, new ReadMailFragment.19.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.19
 * JD-Core Version:    0.7.0.1
 */