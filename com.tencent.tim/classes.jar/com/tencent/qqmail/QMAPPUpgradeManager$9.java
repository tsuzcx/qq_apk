package com.tencent.qqmail;

import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.QMMailManager;

class QMAPPUpgradeManager$9
  implements Runnable
{
  QMAPPUpgradeManager$9(QMAPPUpgradeManager paramQMAPPUpgradeManager, QQMailAccount paramQQMailAccount) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().initSync(this.val$account);
    QMAPPUpgradeManager.access$300(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.9
 * JD-Core Version:    0.7.0.1
 */