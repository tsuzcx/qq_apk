package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.UpdateFtnExpireTimeWatcher;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;

class ReadMailFragment$34
  implements UpdateFtnExpireTimeWatcher
{
  ReadMailFragment$34(ReadMailFragment paramReadMailFragment) {}
  
  public void onSuccess(int paramInt1, MailBigAttach paramMailBigAttach, int paramInt2)
  {
    ReadMailFragment.access$10300(this.this$0, new ReadMailFragment.34.1(this, paramInt2, paramMailBigAttach));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.34
 * JD-Core Version:    0.7.0.1
 */