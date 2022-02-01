package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$15
  implements MailMoveWatcher
{
  ReadMailFragment$15(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    ReadMailFragment.access$6000(this.this$0, new ReadMailFragment.15.1(this));
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    ReadMailFragment.access$5900(this.this$0);
    QMLog.log(4, "ReadMailFragment", "move mail success");
    NameListManager.sharedInstance().addNameList(ReadMailFragment.access$200(this.this$0), NameListContact.NameListContactType.WHITE.ordinal(), new String[] { ReadMailFragment.access$000(this.this$0).getInformation().getFrom().getAddress() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.15
 * JD-Core Version:    0.7.0.1
 */