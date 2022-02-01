package com.tencent.qqmail.popularize;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

public class PopularizeSQLiteDatabaseUpgradeManager
  extends QMSQLiteDatabaseUpgradeManager
{
  private static final String TAG = "PopularizeSQLiteDatabaseUpgradeManager";
  protected final int MIN_VERSION = 5210;
  protected final int VERSION = 5330;
  
  public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new PopularizeSQLiteDatabaseUpgradeManager.1(this, this));
    addVersion(localSparseArray, new PopularizeSQLiteDatabaseUpgradeManager.2(this, this));
    addVersion(localSparseArray, new PopularizeSQLiteDatabaseUpgradeManager.3(this, this));
    addVersion(localSparseArray, new PopularizeSQLiteDatabaseUpgradeManager.4(this, this));
    return localSparseArray;
  }
  
  public int getMinVersion()
  {
    return 5210;
  }
  
  public int getVersion()
  {
    return 5330;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteDatabaseUpgradeManager
 * JD-Core Version:    0.7.0.1
 */