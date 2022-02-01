package com.tencent.qqmail.download;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

class DownloadInfoSQLiteUpgradeManager$1
  extends QMSQLiteDatabaseUpgrade
{
  DownloadInfoSQLiteUpgradeManager$1(DownloadInfoSQLiteUpgradeManager paramDownloadInfoSQLiteUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if ((paramSQLiteOpenHelper instanceof DownloadInfoSQLiteHelper)) {
      ((DownloadInfoSQLiteHelper)paramSQLiteOpenHelper).upgradeTableFor5103(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 5103;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.DownloadInfoSQLiteUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */