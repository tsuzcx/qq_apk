package com.tencent.qqmail.calendar.sqlite;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

public class QMCalendarSQLiteDatabaseUpgradeManager
  extends QMSQLiteDatabaseUpgradeManager
{
  protected final int MIN_VERSION = 3500;
  protected final int VERSION = 5330;
  
  public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.1(this, this));
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.2(this, this));
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.3(this, this));
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.4(this, this));
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.5(this, this));
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.6(this, this));
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.7(this, this));
    addVersion(localSparseArray, new QMCalendarSQLiteDatabaseUpgradeManager.8(this, this));
    return localSparseArray;
  }
  
  public int getMinVersion()
  {
    return 3500;
  }
  
  public int getVersion()
  {
    return 5330;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteDatabaseUpgradeManager
 * JD-Core Version:    0.7.0.1
 */