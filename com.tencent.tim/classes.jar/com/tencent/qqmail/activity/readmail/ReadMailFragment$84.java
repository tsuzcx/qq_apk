package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.view.EnsureDialogUtil.Callback;

class ReadMailFragment$84
  implements EnsureDialogUtil.Callback
{
  ReadMailFragment$84(ReadMailFragment paramReadMailFragment) {}
  
  public void ensure(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReadMailFragment.access$15700(this.this$0);
    }
    int j = ReadMailFragment.access$000(this.this$0).getInformation().getAccountId();
    SharedPreferenceUtil.setJourneyDialogShown(j, true);
    SharedPreferenceUtil.setJourneyDialogAccept(j, paramBoolean);
    QMMailManager localQMMailManager = QMMailManager.sharedInstance();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localQMMailManager.setMailReminderRequestState(false, j, 1, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.84
 * JD-Core Version:    0.7.0.1
 */