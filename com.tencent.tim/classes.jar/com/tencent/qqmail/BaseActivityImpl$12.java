package com.tencent.qqmail;

import android.content.Intent;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;

class BaseActivityImpl$12
  implements Runnable
{
  BaseActivityImpl$12(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void run()
  {
    QMActivityManager.shareInstance().finishAllActivity();
    Intent localIntent = MailFragmentActivity.createIntentToAccountList();
    this.this$0.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.12
 * JD-Core Version:    0.7.0.1
 */