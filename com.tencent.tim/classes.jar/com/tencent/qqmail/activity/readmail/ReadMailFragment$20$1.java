package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$20$1
  implements Runnable
{
  ReadMailFragment$20$1(ReadMailFragment.20 param20) {}
  
  public void run()
  {
    if (!ReadMailFragment.access$7100(this.this$1.this$0, ReadMailFragment.access$200(this.this$1.this$0))) {
      ReadMailFragment.access$5900(this.this$1.this$0);
    }
    if (ReadMailFragment.access$7400(this.this$1.this$0) == 3)
    {
      ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131695614));
      NameListManager.sharedInstance().addNameList(ReadMailFragment.access$200(this.this$1.this$0), NameListContact.NameListContactType.WHITE.ordinal(), new String[] { ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFrom().getAddress() });
    }
    for (;;)
    {
      if (ReadMailFragment.access$7400(this.this$1.this$0) == 1) {
        NameListManager.sharedInstance().addNameList(ReadMailFragment.access$200(this.this$1.this$0), NameListContact.NameListContactType.BLACK.ordinal(), new String[] { ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFrom().getAddress() });
      }
      QMLog.log(4, "ReadMailFragment", "rejectWatcher onSuccess");
      return;
      if (ReadMailFragment.access$7400(this.this$1.this$0) == 2)
      {
        ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131695616));
        NameListManager.sharedInstance().addNameList(ReadMailFragment.access$200(this.this$1.this$0), NameListContact.NameListContactType.BLACK.ordinal(), new String[] { ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFrom().getAddress() });
      }
      else if (ReadMailFragment.access$7500(this.this$1.this$0) == 3)
      {
        ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131695603));
      }
      else
      {
        ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131695615));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.20.1
 * JD-Core Version:    0.7.0.1
 */