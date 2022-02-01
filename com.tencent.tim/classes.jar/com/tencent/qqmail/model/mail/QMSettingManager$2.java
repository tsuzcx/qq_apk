package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;

class QMSettingManager$2
  implements Runnable
{
  QMSettingManager$2(QMSettingManager paramQMSettingManager) {}
  
  public void run()
  {
    QMWatcherCenter.triggerBottleOpenNotifyWatcher(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingManager.2
 * JD-Core Version:    0.7.0.1
 */