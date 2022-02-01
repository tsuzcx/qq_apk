package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.protocol.QMSyncManager;

class SettingSyncMethodActivity$2
  implements Runnable
{
  SettingSyncMethodActivity$2(SettingSyncMethodActivity paramSettingSyncMethodActivity) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().setNewMailPushWay(SettingSyncMethodActivity.access$100(this.this$0), QMSyncManager.sharedInstance().transformSyncMethodToServer(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncMethodActivity.2
 * JD-Core Version:    0.7.0.1
 */