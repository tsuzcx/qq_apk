package com.tencent.qqmail.model.qmnote.storage;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

class QMNoteSQLiteUpgradeManager$1
  extends QMSQLiteDatabaseUpgrade
{
  QMNoteSQLiteUpgradeManager$1(QMNoteSQLiteUpgradeManager paramQMNoteSQLiteUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMNoteSQLite.upgradeTableFor5210(paramSQLiteDatabase);
  }
  
  public int getVersion()
  {
    return 5210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmnote.storage.QMNoteSQLiteUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */