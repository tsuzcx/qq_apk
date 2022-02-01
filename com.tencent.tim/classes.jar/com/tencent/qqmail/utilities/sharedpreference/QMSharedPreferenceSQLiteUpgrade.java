package com.tencent.qqmail.utilities.sharedpreference;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.utilities.log.QMLog;

public abstract class QMSharedPreferenceSQLiteUpgrade
  implements ISQLIteDatabaseUpgrade
{
  private static final String TAG = "QMSharedPreferenceSQLiteUpgrade";
  private QMSharedPreferenceSQLiteDatabaseUpgradeManager upgradeManager;
  
  public QMSharedPreferenceSQLiteUpgrade(QMSharedPreferenceSQLiteDatabaseUpgradeManager paramQMSharedPreferenceSQLiteDatabaseUpgradeManager)
  {
    this.upgradeManager = paramQMSharedPreferenceSQLiteDatabaseUpgradeManager;
  }
  
  public abstract void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt);
  
  public abstract int getVersion();
  
  public final void onUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if (paramInt <= this.upgradeManager.getVersion())
    {
      doUpgrade(paramSQLiteOpenHelper, paramSQLiteDatabase, paramInt);
      QMLog.log(4, "QMSharedPreferenceSQLiteUpgrade", "doUpgrade " + paramSQLiteDatabase.getPath() + " from " + paramInt + " to " + getVersion() + " ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceSQLiteUpgrade
 * JD-Core Version:    0.7.0.1
 */