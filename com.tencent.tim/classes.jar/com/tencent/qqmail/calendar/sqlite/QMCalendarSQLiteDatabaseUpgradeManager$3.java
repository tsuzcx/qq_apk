package com.tencent.qqmail.calendar.sqlite;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

class QMCalendarSQLiteDatabaseUpgradeManager$3
  extends QMSQLiteDatabaseUpgrade
{
  QMCalendarSQLiteDatabaseUpgradeManager$3(QMCalendarSQLiteDatabaseUpgradeManager paramQMCalendarSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ((QMCalendarSQLiteHelper)paramSQLiteOpenHelper).upgradeTableFor5200(paramSQLiteDatabase);
  }
  
  public int getVersion()
  {
    return 5200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteDatabaseUpgradeManager.3
 * JD-Core Version:    0.7.0.1
 */