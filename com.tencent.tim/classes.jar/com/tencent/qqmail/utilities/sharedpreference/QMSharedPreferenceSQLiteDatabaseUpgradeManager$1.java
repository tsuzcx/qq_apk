package com.tencent.qqmail.utilities.sharedpreference;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import java.util.concurrent.Callable;

class QMSharedPreferenceSQLiteDatabaseUpgradeManager$1
  implements Callable<SparseArray<ISQLIteDatabaseUpgrade>>
{
  QMSharedPreferenceSQLiteDatabaseUpgradeManager$1(QMSharedPreferenceSQLiteDatabaseUpgradeManager paramQMSharedPreferenceSQLiteDatabaseUpgradeManager) {}
  
  public SparseArray<ISQLIteDatabaseUpgrade> call()
    throws Exception
  {
    return QMSharedPreferenceSQLiteDatabaseUpgradeManager.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceSQLiteDatabaseUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */