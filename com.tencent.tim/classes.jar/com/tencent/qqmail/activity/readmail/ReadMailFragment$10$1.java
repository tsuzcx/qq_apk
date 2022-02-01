package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$10$1
  implements Runnable
{
  ReadMailFragment$10$1(ReadMailFragment.10 param10) {}
  
  public void run()
  {
    if (ReadMailFragment.access$000(this.this$1.this$0) != null)
    {
      if (!ReadMailFragment.access$2800(this.this$1.this$0)) {
        break label62;
      }
      QMLog.log(4, "ReadMailFragment", "load delete pop mail to show delete");
    }
    for (;;)
    {
      ReadMailFragment.access$000(this.this$1.this$0).getStatus().setLoaded(true);
      ReadMailFragment.access$3100(this.this$1.this$0);
      return;
      label62:
      if ((ReadMailFragment.access$2900(this.this$1.this$0, true)) && (QMMailManager.sharedInstance().isImapNeedReload(ReadMailFragment.access$000(this.this$1.this$0))))
      {
        QMLog.log(4, "ReadMailFragment", "imap mail need reload:" + ReadMailFragment.access$000(this.this$1.this$0).getInformation().getId());
        QMMailManager.sharedInstance().loadRemoteMail(ReadMailFragment.access$000(this.this$1.this$0), ReadMailFragment.access$3000(this.this$1.this$0));
      }
      else if (!ReadMailFragment.access$000(this.this$1.this$0).getStatus().isLoaded())
      {
        QMLog.log(4, "ReadMailFragment", "load local mail success, but isloaded is false : " + ReadMailFragment.access$2900(this.this$1.this$0, true));
        QMMailManager.sharedInstance().tryLoadMail(ReadMailFragment.access$000(this.this$1.this$0), ReadMailFragment.access$3000(this.this$1.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.10.1
 * JD-Core Version:    0.7.0.1
 */