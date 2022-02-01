package com.tencent.qqmail.card;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCardSQLiteDatabaseUpgradeManager$1
  extends QMSQLiteDatabaseUpgrade
{
  QMCardSQLiteDatabaseUpgradeManager$1(QMCardSQLiteDatabaseUpgradeManager paramQMCardSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMCardSQLiteDatabaseUpgradeManager", "doUpgrade for 5.1.0.0");
    QMCardSQLiteHelper.upgradeTableFor5101(paramSQLiteDatabase);
    QMLog.log(4, "QMCardSQLiteDatabaseUpgradeManager", "doUpgrade for 5.1.0.1 ok");
  }
  
  public int getVersion()
  {
    return 5101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardSQLiteDatabaseUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */