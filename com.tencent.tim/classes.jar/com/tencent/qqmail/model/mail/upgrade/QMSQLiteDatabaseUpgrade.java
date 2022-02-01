package com.tencent.qqmail.model.mail.upgrade;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.utilities.log.QMLog;

public abstract class QMSQLiteDatabaseUpgrade
  implements ISQLIteDatabaseUpgrade
{
  private static final String TAG = "SQLiteDatabaseUpgrade";
  private QMSQLiteDatabaseUpgradeManager upgradeManager;
  
  public QMSQLiteDatabaseUpgrade(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    this.upgradeManager = paramQMSQLiteDatabaseUpgradeManager;
  }
  
  public abstract void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt);
  
  public abstract int getVersion();
  
  public final void onUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if (paramInt <= this.upgradeManager.getVersion())
    {
      long l = System.currentTimeMillis();
      doUpgrade(paramSQLiteOpenHelper, paramSQLiteDatabase, paramInt);
      QMLog.log(4, "SQLiteDatabaseUpgrade", "doUpgrade " + paramSQLiteDatabase.getPath() + " from " + paramInt + " to " + getVersion() + " ok, timed:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade
 * JD-Core Version:    0.7.0.1
 */