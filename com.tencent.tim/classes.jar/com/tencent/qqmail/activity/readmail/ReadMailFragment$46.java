package com.tencent.qqmail.activity.readmail;

import android.content.Intent;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadMailFragment$46
  implements Runnable
{
  ReadMailFragment$46(ReadMailFragment paramReadMailFragment, Intent paramIntent) {}
  
  public void run()
  {
    long[] arrayOfLong;
    if (this.val$data != null)
    {
      int i = this.val$data.getIntExtra("arg_tagmail_confirm", -1);
      arrayOfLong = this.val$data.getLongArrayExtra("arg_tagmail_mailids");
      if (i != 1) {
        break label73;
      }
      QMMailManager.sharedInstance().updateMailInfo(ReadMailFragment.access$000(this.this$0), ReadMailFragment.access$100(this.this$0));
      ReadMailFragment.access$5100(this.this$0);
      this.this$0.getTips().showSuccess(2131695670);
    }
    label73:
    while (!ReadMailFragment.access$5000(this.this$0).canHandleMove(arrayOfLong)) {
      return;
    }
    ReadMailFragment.access$6500(this.this$0);
    this.this$0.getTips().showError(2131695665);
    QMLog.log(5, "ReadMailFragment", "tagWatcher onError onactivityresult");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.46
 * JD-Core Version:    0.7.0.1
 */