package com.tencent.qqmail.utilities.sharedpreference;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSharedPreferenceSQLiteDatabaseUpgradeManager$2
  extends QMSharedPreferenceSQLiteUpgrade
{
  QMSharedPreferenceSQLiteDatabaseUpgradeManager$2(QMSharedPreferenceSQLiteDatabaseUpgradeManager paramQMSharedPreferenceSQLiteDatabaseUpgradeManager1, QMSharedPreferenceSQLiteDatabaseUpgradeManager paramQMSharedPreferenceSQLiteDatabaseUpgradeManager2)
  {
    super(paramQMSharedPreferenceSQLiteDatabaseUpgradeManager2);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMSharedPreferenceSQLiteUpgradeManager", "upgrade from " + paramInt + " to " + getVersion());
  }
  
  public int getVersion()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceSQLiteDatabaseUpgradeManager.2
 * JD-Core Version:    0.7.0.1
 */