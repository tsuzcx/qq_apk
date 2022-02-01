package com.tencent.qqmail;

import android.content.Intent;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;

class BaseActivityImpl$11
  implements Runnable
{
  BaseActivityImpl$11(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void run()
  {
    QMActivityManager.shareInstance().finishAllActivity();
    this.this$0.finishWithNoCheck();
    Intent localIntent = AccountTypeListActivity.createIntent();
    this.this$0.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.11
 * JD-Core Version:    0.7.0.1
 */