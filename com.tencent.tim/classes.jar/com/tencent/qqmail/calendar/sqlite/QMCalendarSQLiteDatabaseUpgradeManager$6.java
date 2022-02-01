package com.tencent.qqmail.calendar.sqlite;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

class QMCalendarSQLiteDatabaseUpgradeManager$6
  extends QMSQLiteDatabaseUpgrade
{
  QMCalendarSQLiteDatabaseUpgradeManager$6(QMCalendarSQLiteDatabaseUpgradeManager paramQMCalendarSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ((QMCalendarSQLiteHelper)paramSQLiteOpenHelper).upgradeTableFor5203(paramSQLiteDatabase);
  }
  
  public int getVersion()
  {
    return 5203;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteDatabaseUpgradeManager.6
 * JD-Core Version:    0.7.0.1
 */