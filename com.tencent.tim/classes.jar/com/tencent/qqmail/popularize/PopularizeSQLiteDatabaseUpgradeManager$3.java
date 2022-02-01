package com.tencent.qqmail.popularize;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class PopularizeSQLiteDatabaseUpgradeManager$3
  extends QMSQLiteDatabaseUpgrade
{
  PopularizeSQLiteDatabaseUpgradeManager$3(PopularizeSQLiteDatabaseUpgradeManager paramPopularizeSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "PopularizeSQLiteDatabaseUpgradeManager", "upgrade table for 5270");
    if ((paramSQLiteOpenHelper instanceof PopularizeSQLiteHelper)) {
      ((PopularizeSQLiteHelper)paramSQLiteOpenHelper).upgradeForTableFor5270(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 5270;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteDatabaseUpgradeManager.3
 * JD-Core Version:    0.7.0.1
 */