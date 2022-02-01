package com.tencent.androidqqmail.tim;

import android.content.Intent;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;

class MainActivity$2$1$2
  implements Runnable
{
  MainActivity$2$1$2(MainActivity.2.1 param1, String paramString) {}
  
  public void run()
  {
    Intent localIntent = LoginFragmentActivity.createIntentToAddAccount(AccountType.qqmail.name(), this.val$ssoAccount + "@qq.com");
    this.this$2.this$1.this$0.startActivity(localIntent);
    this.this$2.this$1.this$0.overridePendingTransition(17432576, 17432577);
    this.this$2.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MainActivity.2.1.2
 * JD-Core Version:    0.7.0.1
 */