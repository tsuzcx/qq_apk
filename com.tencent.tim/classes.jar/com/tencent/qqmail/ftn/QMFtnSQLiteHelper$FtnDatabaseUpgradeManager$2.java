package com.tencent.qqmail.ftn;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMFtnSQLiteHelper$FtnDatabaseUpgradeManager$2
  extends QMSQLiteDatabaseUpgrade
{
  QMFtnSQLiteHelper$FtnDatabaseUpgradeManager$2(QMFtnSQLiteHelper.FtnDatabaseUpgradeManager paramFtnDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMFtnBaseSQLite", "3. add column usage and storage");
    paramSQLiteDatabase.execSQL("ALTER TABLE QMFtnUserProf ADD COLUMN usage INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QMFtnUserProf ADD COLUMN storage INTEGER");
  }
  
  public int getVersion()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.QMFtnSQLiteHelper.FtnDatabaseUpgradeManager.2
 * JD-Core Version:    0.7.0.1
 */