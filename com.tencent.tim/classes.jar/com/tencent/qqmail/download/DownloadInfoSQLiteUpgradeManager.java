package com.tencent.qqmail.download;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

public class DownloadInfoSQLiteUpgradeManager
  extends QMSQLiteDatabaseUpgradeManager
{
  private static final String TAG = "DownloadInfoSQLiteUpgradeManager";
  protected final int MIN_VERSION = 5102;
  protected final int VERSION = 5103;
  
  public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new DownloadInfoSQLiteUpgradeManager.1(this, this));
    return localSparseArray;
  }
  
  public int getMinVersion()
  {
    return 5102;
  }
  
  public int getVersion()
  {
    return 5103;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.DownloadInfoSQLiteUpgradeManager
 * JD-Core Version:    0.7.0.1
 */