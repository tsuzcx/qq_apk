package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$16
  implements MailDeleteWatcher
{
  ReadMailFragment$16(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleDelete(paramArrayOfLong)) {
      ReadMailFragment.access$6600(this.this$0, new ReadMailFragment.16.2(this));
    }
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleDelete(paramArrayOfLong)) {
      ReadMailFragment.access$6400(this.this$0, new ReadMailFragment.16.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.16
 * JD-Core Version:    0.7.0.1
 */