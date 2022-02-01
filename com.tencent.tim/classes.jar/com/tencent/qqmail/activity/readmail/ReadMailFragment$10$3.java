package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$10$3
  implements Runnable
{
  ReadMailFragment$10$3(ReadMailFragment.10 param10, long paramLong, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if ((ReadMailFragment.access$000(this.this$1.this$0) != null) && (ReadMailFragment.access$000(this.this$1.this$0).getStatus().isLocalMail()))
    {
      QMLog.log(6, "ReadMailFragment", "local mail load error:" + this.val$mailId + "; " + ReadMailFragment.access$000(this.this$1.this$0).getInformation().getRemoteId());
      return;
    }
    if ((ReadMailFragment.access$000(this.this$1.this$0) != null) && (ReadMailFragment.access$000(this.this$1.this$0).getStatus() != null) && (ReadMailFragment.access$000(this.this$1.this$0).getContent() != null) && (!ReadMailFragment.access$000(this.this$1.this$0).getStatus().isLoaded()) && (!ReadMailFragment.access$2900(this.this$1.this$0, true)))
    {
      QMLog.log(6, "ReadMailFragment", "load delete pop mail");
      ReadMailFragment.access$000(this.this$1.this$0).getStatus().setLoaded(true);
      ReadMailFragment.access$3100(this.this$1.this$0);
    }
    if ((this.val$error.code == -10011) || (this.val$error.code == 21))
    {
      ReadMailFragment.access$4200(this.this$1.this$0);
      return;
    }
    if ((this.val$error instanceof QMCGIError))
    {
      QMCGIError localQMCGIError = (QMCGIError)this.val$error;
      if ((localQMCGIError.appCode == -203) || (localQMCGIError.appCode == -202) || (localQMCGIError.appCode == -201) || (localQMCGIError.appCode == -200))
      {
        ReadMailFragment.access$4300(this.this$1.this$0);
        ReadMailFragment.access$4400(this.this$1.this$0, localQMCGIError.desp);
        return;
      }
      ReadMailFragment.access$4500(this.this$1.this$0);
      return;
    }
    ReadMailFragment.access$4500(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.10.3
 * JD-Core Version:    0.7.0.1
 */