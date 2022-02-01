package com.tencent.qqmail.model.task;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;

class QMTaskSQLiteDatabaseUpgradeManager$1
  extends QMSQLiteDatabaseUpgrade
{
  QMTaskSQLiteDatabaseUpgradeManager$1(QMTaskSQLiteDatabaseUpgradeManager paramQMTaskSQLiteDatabaseUpgradeManager, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager)
  {
    super(paramQMSQLiteDatabaseUpgradeManager);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if ((paramSQLiteOpenHelper instanceof QMTaskSQLiteHelper)) {
      ((QMTaskSQLiteHelper)paramSQLiteOpenHelper).upgradeTableFor4(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMTaskSQLiteDatabaseUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */