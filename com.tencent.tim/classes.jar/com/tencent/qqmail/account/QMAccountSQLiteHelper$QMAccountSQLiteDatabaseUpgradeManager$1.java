package com.tencent.qqmail.account;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAccountSQLiteHelper$QMAccountSQLiteDatabaseUpgradeManager$1
  extends QMSQLiteDatabaseUpgrade
{
  QMAccountSQLiteHelper$QMAccountSQLiteDatabaseUpgradeManager$1(QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager paramQMAccountSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMAccountSQLite", "doUpgrade for 3.1");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN folerlistsynckey VARCHAR");
    QMLog.log(4, "QMAccountSQLite", "doUpgrade for 3.1 ok");
  }
  
  public int getVersion()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */