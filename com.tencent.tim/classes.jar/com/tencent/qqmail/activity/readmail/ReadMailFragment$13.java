package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailStartWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$13
  implements MailStartWatcher
{
  ReadMailFragment$13(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleStar(paramArrayOfLong)) {
      ReadMailFragment.access$5500(this.this$0, new ReadMailFragment.13.2(this));
    }
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (ReadMailFragment.access$5000(this.this$0).canHandleStar(paramArrayOfLong)) {
      ReadMailFragment.access$5400(this.this$0, new ReadMailFragment.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.13
 * JD-Core Version:    0.7.0.1
 */