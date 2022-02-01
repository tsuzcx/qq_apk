package com.tencent.qqmail.ftn;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMFtnSQLiteHelper$FtnDatabaseUpgradeManager$3
  extends QMSQLiteDatabaseUpgrade
{
  QMFtnSQLiteHelper$FtnDatabaseUpgradeManager$3(QMFtnSQLiteHelper.FtnDatabaseUpgradeManager paramFtnDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMFtnBaseSQLite", "4. delete all from downloadInfo");
    paramSQLiteDatabase.execSQL("DELETE FROM QMFtnDownloadInfo");
  }
  
  public int getVersion()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.QMFtnSQLiteHelper.FtnDatabaseUpgradeManager.3
 * JD-Core Version:    0.7.0.1
 */