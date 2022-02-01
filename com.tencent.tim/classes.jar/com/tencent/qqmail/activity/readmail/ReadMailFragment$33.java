package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailModifySendUtcWatcher;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$33
  implements MailModifySendUtcWatcher
{
  ReadMailFragment$33(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getInformation() != null) && (ReadMailFragment.access$000(this.this$0).getInformation().getId() == paramLong)) {
      ReadMailFragment.access$10000(this.this$0, new ReadMailFragment.33.3(this));
    }
  }
  
  public void onProcess(long paramLong)
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getInformation() != null) && (ReadMailFragment.access$000(this.this$0).getInformation().getId() == paramLong)) {
      ReadMailFragment.access$9800(this.this$0, new ReadMailFragment.33.1(this));
    }
  }
  
  public void onSuccess(long paramLong)
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getInformation() != null) && (ReadMailFragment.access$000(this.this$0).getInformation().getId() == paramLong))
    {
      ReadMailFragment.access$9900(this.this$0, new ReadMailFragment.33.2(this));
      DataCollector.logEvent("Event_Change_Timer_Mail_Success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.33
 * JD-Core Version:    0.7.0.1
 */