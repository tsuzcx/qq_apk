package com.tencent.qqmail.model.mail;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

public class QMSettingSQLiteDatabaseUpgradeManager
  extends QMSQLiteDatabaseUpgradeManager
{
  protected final int MIN_VERSION = 5210;
  protected final int VERSION = 5210;
  
  public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new QMSettingSQLiteDatabaseUpgradeManager.1(this, this));
    return localSparseArray;
  }
  
  public int getMinVersion()
  {
    return 5210;
  }
  
  public int getVersion()
  {
    return 5210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingSQLiteDatabaseUpgradeManager
 * JD-Core Version:    0.7.0.1
 */