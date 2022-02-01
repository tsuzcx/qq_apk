package com.tencent.qqmail.model.task;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

public class QMTaskSQLiteDatabaseUpgradeManager
  extends QMSQLiteDatabaseUpgradeManager
{
  protected final int MIN_VERSION = 3;
  protected final int VERSION = 5310;
  
  public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new QMTaskSQLiteDatabaseUpgradeManager.1(this, this));
    addVersion(localSparseArray, new QMTaskSQLiteDatabaseUpgradeManager.2(this, this));
    addVersion(localSparseArray, new QMTaskSQLiteDatabaseUpgradeManager.3(this, this));
    return localSparseArray;
  }
  
  public int getMinVersion()
  {
    return 3;
  }
  
  public int getVersion()
  {
    return 5310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMTaskSQLiteDatabaseUpgradeManager
 * JD-Core Version:    0.7.0.1
 */