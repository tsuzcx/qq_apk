package com.tencent.qqmail.card;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

public class QMCardSQLiteDatabaseUpgradeManager
  extends QMSQLiteDatabaseUpgradeManager
{
  private static final String TAG = "QMCardSQLiteDatabaseUpgradeManager";
  protected final int MIN_VERSION = 5100;
  protected final int VERSION = 5300;
  
  public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new QMCardSQLiteDatabaseUpgradeManager.1(this, this));
    addVersion(localSparseArray, new QMCardSQLiteDatabaseUpgradeManager.2(this, this));
    addVersion(localSparseArray, new QMCardSQLiteDatabaseUpgradeManager.3(this, this));
    return localSparseArray;
  }
  
  public int getMinVersion()
  {
    return 5100;
  }
  
  public int getVersion()
  {
    return 5300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardSQLiteDatabaseUpgradeManager
 * JD-Core Version:    0.7.0.1
 */