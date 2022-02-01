package com.tencent.qqmail;

import android.content.Intent;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.utilities.cacheclear.ClearCacheService;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAPPUpgradeManager$5
  extends QMAPPUpgrade
{
  QMAPPUpgradeManager$5(QMAPPUpgradeManager paramQMAPPUpgradeManager1, QMAPPUpgradeManager paramQMAPPUpgradeManager2)
  {
    super(paramQMAPPUpgradeManager2);
  }
  
  public void doUpgrade(int paramInt)
  {
    QMLog.log(4, "QMAppUpgradeManager", "upgrade for clear old cache");
    Intent localIntent = ClearCacheService.createIntentForUpgrade();
    QMApplicationContext.sharedInstance().startService(localIntent);
    boolean bool = NoteManager.getSharedInstance().fixNoteData();
    QMLog.log(4, "QMAppUpgradeManager", "fixNoteData: " + bool);
  }
  
  public int getVersion()
  {
    return 5110;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.5
 * JD-Core Version:    0.7.0.1
 */