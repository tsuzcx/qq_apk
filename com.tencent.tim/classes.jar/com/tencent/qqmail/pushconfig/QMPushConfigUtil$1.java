package com.tencent.qqmail.pushconfig;

import java.util.ArrayList;

final class QMPushConfigUtil$1
  implements Runnable
{
  QMPushConfigUtil$1(QMPushConfigDialog paramQMPushConfigDialog, QMUpgradePushConfig paramQMUpgradePushConfig) {}
  
  public void run()
  {
    String str2 = "";
    String str1 = str2;
    if (this.val$dialog.getDespLines() != null)
    {
      str1 = str2;
      if (this.val$dialog.getDespLines().size() > 0) {
        str1 = (String)this.val$dialog.getDespLines().get(0);
      }
    }
    QMPushConfigUtil.triggerAppUpdateWatcher(this.val$upgrade.getUpgradeVersion(), str1, this.val$dialog.getTitle(), this.val$upgrade.getUrl(), this.val$upgrade.getForceType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfigUtil.1
 * JD-Core Version:    0.7.0.1
 */