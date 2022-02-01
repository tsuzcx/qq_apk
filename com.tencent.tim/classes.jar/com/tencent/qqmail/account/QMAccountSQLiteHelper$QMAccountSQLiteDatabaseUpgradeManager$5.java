package com.tencent.qqmail.account;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAccountSQLiteHelper$QMAccountSQLiteDatabaseUpgradeManager$5
  extends QMSQLiteDatabaseUpgrade
{
  QMAccountSQLiteHelper$QMAccountSQLiteDatabaseUpgradeManager$5(QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager paramQMAccountSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMAccountSQLite", "doUpgrade for 5.3.3");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN deviceid VARCHAR");
    paramSQLiteDatabase.execSQL("update AccountInfo set deviceid='" + Aes.getPureDeviceToken() + "'");
    QMLog.log(4, "QMAccountSQLite", "doUpgrade for 5.3.3");
  }
  
  public int getVersion()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.5
 * JD-Core Version:    0.7.0.1
 */