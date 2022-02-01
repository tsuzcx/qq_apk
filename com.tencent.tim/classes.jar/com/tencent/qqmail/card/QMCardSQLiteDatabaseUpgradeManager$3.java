package com.tencent.qqmail.card;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCardSQLiteDatabaseUpgradeManager$3
  extends QMSQLiteDatabaseUpgrade
{
  QMCardSQLiteDatabaseUpgradeManager$3(QMCardSQLiteDatabaseUpgradeManager paramQMCardSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMCardSQLiteDatabaseUpgradeManager", "5300. create pageType for card data table");
    QMCardSQLiteHelper.upgradeTableFor5300(paramSQLiteDatabase);
  }
  
  public int getVersion()
  {
    return 5300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardSQLiteDatabaseUpgradeManager.3
 * JD-Core Version:    0.7.0.1
 */