package com.tencent.qqmail;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

class QMAPPUpgradeManager$8
  extends QMAPPUpgrade
{
  QMAPPUpgradeManager$8(QMAPPUpgradeManager paramQMAPPUpgradeManager1, QMAPPUpgradeManager paramQMAPPUpgradeManager2)
  {
    super(paramQMAPPUpgradeManager2);
  }
  
  public void doUpgrade(int paramInt)
  {
    QMLog.log(4, "QMAppUpgradeManager", "upgrade 5300 reset query_domain version");
    SPManager.getEditor("user_info").putString("configtype_1", "").apply();
  }
  
  public int getVersion()
  {
    return 5300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.8
 * JD-Core Version:    0.7.0.1
 */