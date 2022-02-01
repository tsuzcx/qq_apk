package com.tencent.qqmail.model.mail.upgrade;

import android.util.SparseArray;
import java.util.concurrent.Callable;

class QMSQLiteDatabaseUpgradeManager$1
  implements Callable<SparseArray<ISQLIteDatabaseUpgrade>>
{
  QMSQLiteDatabaseUpgradeManager$1(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager) {}
  
  public SparseArray<ISQLIteDatabaseUpgrade> call()
    throws Exception
  {
    return this.this$0.addVersions();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */