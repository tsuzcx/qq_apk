package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;

class ComposeMailActivity$64
  implements Runnable
{
  ComposeMailActivity$64(ComposeMailActivity paramComposeMailActivity, Account paramAccount) {}
  
  public void run()
  {
    QMComposeDataManager.sharedInstance().loadComposeDataThroughNetwork(this.val$account.getId(), ComposeMailActivity.access$7200(this.this$0), ComposeMailActivity.access$7300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.64
 * JD-Core Version:    0.7.0.1
 */