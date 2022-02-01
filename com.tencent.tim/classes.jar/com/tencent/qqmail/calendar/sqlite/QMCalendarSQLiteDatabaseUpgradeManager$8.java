package com.tencent.qqmail.calendar.sqlite;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

class QMCalendarSQLiteDatabaseUpgradeManager$8
  extends QMSQLiteDatabaseUpgrade
{
  QMCalendarSQLiteDatabaseUpgradeManager$8(QMCalendarSQLiteDatabaseUpgradeManager paramQMCalendarSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ((QMCalendarSQLiteHelper)paramSQLiteOpenHelper).upgradeTableFor5202(paramSQLiteDatabase);
  }
  
  public int getVersion()
  {
    return 5330;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteDatabaseUpgradeManager.8
 * JD-Core Version:    0.7.0.1
 */