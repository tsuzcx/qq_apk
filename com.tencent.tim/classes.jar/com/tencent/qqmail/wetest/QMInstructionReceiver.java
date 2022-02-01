package com.tencent.qqmail.wetest;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.BaseBroadcastReceiver;

public class QMInstructionReceiver
  extends BaseBroadcastReceiver
{
  private static final String ARG_ACTION = "action";
  private static final String ARG_FOLDERID = "folderid";
  private static final String ARG_MAIL_REMOTEID = "mailremoteid";
  private static final String TAG = "QMInstructionReceiver";
  
  private void gotoAddAccount(Context paramContext, String paramString)
  {
    if ("qq".equals(paramString))
    {
      paramString = LoginFragmentActivity.createIntentToAddAccount(AccountType.qqmail.name());
      paramString.addFlags(268468224);
      paramContext.startActivity(paramString);
    }
    while (!"other".equals(paramString)) {
      return;
    }
    paramString = LoginFragmentActivity.createIntentToAddAccount(AccountType.other.name());
    paramString.addFlags(268468224);
    paramContext.startActivity(paramString);
  }
  
  private void gotoReadMailFragment(Context paramContext, int paramInt, String paramString)
  {
    int i = AccountManager.shareInstance().getAccountList().get(0).getId();
    paramString = MailFragmentActivity.createIntentToReadmailFromPush(i, paramInt, Mail.generateId(i, paramString), paramString, "", "", "", true, false, false);
    paramString.addFlags(268435456);
    paramContext.startActivity(paramString);
  }
  
  private void process(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("action");
    if ("login_to_readmail".equals(str)) {
      gotoReadMailFragment(paramContext, paramIntent.getIntExtra("folderid", 0), paramIntent.getStringExtra("mailremoteid"));
    }
    while (!"auto_login".equals(str)) {
      return;
    }
    gotoAddAccount(paramContext, paramIntent.getStringExtra("domain"));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    QMLog.log(4, "QMInstructionReceiver", "onReceive:false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.wetest.QMInstructionReceiver
 * JD-Core Version:    0.7.0.1
 */