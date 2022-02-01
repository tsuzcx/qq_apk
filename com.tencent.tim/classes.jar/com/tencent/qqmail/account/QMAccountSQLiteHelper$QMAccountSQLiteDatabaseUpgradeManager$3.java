package com.tencent.qqmail.account;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAccountSQLiteHelper$QMAccountSQLiteDatabaseUpgradeManager$3
  extends QMSQLiteDatabaseUpgrade
{
  QMAccountSQLiteHelper$QMAccountSQLiteDatabaseUpgradeManager$3(QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager paramQMAccountSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMAccountSQLite", "doUpgrade for 4.0.3");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN accesstoken VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN refreshtoken VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN tokentype VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN expirein INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN idtoken VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE AccountInfo ADD COLUMN lasttokentime INTEGER DEFAULT 0");
    QMLog.log(4, "QMAccountSQLite", "doUpgrade for 4.0.3 ok");
  }
  
  public int getVersion()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.QMAccountSQLiteHelper.QMAccountSQLiteDatabaseUpgradeManager.3
 * JD-Core Version:    0.7.0.1
 */