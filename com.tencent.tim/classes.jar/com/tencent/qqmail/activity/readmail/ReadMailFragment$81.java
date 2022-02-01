package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.view.EnsureDialogUtil.Callback;
import moai.oss.KvHelper;

class ReadMailFragment$81
  implements EnsureDialogUtil.Callback
{
  ReadMailFragment$81(ReadMailFragment paramReadMailFragment) {}
  
  public void ensure(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      KvHelper.creditCardBillRemingdPopPermissionDialogAccept(new double[0]);
      ReadMailFragment.access$15600(this.this$0);
    }
    int j = ReadMailFragment.access$000(this.this$0).getInformation().getAccountId();
    SharedPreferenceUtil.setCreditCardDialogShown(j, true);
    SharedPreferenceUtil.setCreditCardDialogAccept(j, paramBoolean);
    QMMailManager localQMMailManager = QMMailManager.sharedInstance();
    if (paramBoolean) {
      i = 1;
    }
    localQMMailManager.setMailReminderRequestState(true, j, 1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.81
 * JD-Core Version:    0.7.0.1
 */