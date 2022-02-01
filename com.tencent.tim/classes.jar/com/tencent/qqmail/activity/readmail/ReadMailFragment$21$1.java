package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class ReadMailFragment$21$1
  implements Runnable
{
  ReadMailFragment$21$1(ReadMailFragment.21 param21, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.val$type == NameListContact.NameListContactType.BLACK.ordinal()) {
      if (!SharedPreferenceUtil.isBlackNameListTipsHasShow())
      {
        ReadMailFragment.access$7800(this.this$1.this$0, ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFrom().getAddress());
        SharedPreferenceUtil.setBlackNameListTipsHasShow(true);
      }
    }
    Account localAccount;
    do
    {
      do
      {
        return;
      } while (SharedPreferenceUtil.isWhiteNameListTipsHasShow());
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.val$accountId);
    } while ((localAccount == null) || (!localAccount.isQQMail()));
    ReadMailFragment.access$7900(this.this$1.this$0, ReadMailFragment.access$000(this.this$1.this$0).getInformation().getFrom().getAddress());
    SharedPreferenceUtil.setWhiteNameListTipsHasShow(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.21.1
 * JD-Core Version:    0.7.0.1
 */