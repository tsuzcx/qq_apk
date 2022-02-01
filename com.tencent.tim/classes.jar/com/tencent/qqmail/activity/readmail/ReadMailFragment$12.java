package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailTopWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$12
  implements MailTopWatcher
{
  ReadMailFragment$12(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleTop(paramArrayOfLong)) {
      ReadMailFragment.access$5300(this.this$0, new ReadMailFragment.12.2(this));
    }
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleTop(paramArrayOfLong)) {
      ReadMailFragment.access$5200(this.this$0, new ReadMailFragment.12.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.12
 * JD-Core Version:    0.7.0.1
 */