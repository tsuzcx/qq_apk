package com.tencent.androidqqmail.tim;

import android.content.Intent;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.utilities.log.QMLog;

class MainActivity$2$1$1
  implements Runnable
{
  MainActivity$2$1$1(MainActivity.2.1 param1, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    QMLog.log(4, "MainActivity", "MainActivity_from_tim finish");
    Intent localIntent = LoginFragmentActivity.createIntentForA2AddAccount(AccountType.qqmail.name(), this.val$ssoAccount, this.val$a2, this.val$skey);
    this.this$2.this$1.this$0.startActivity(localIntent);
    this.this$2.this$1.this$0.overridePendingTransition(17432576, 17432577);
    this.this$2.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MainActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */