package com.tencent.qqmail.model.mail.upgrade;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.QMFolderSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSQLiteDatabaseUpgradeManager$2
  extends QMSQLiteDatabaseUpgrade
{
  QMSQLiteDatabaseUpgradeManager$2(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager1, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager2)
  {
    super(paramQMSQLiteDatabaseUpgradeManager2);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    QMLog.log(4, "QMSQLiteDatabaseUpgradeManager", "3001");
    if ((paramSQLiteOpenHelper instanceof QMMailSQLiteHelper)) {
      ((QMMailSQLiteHelper)paramSQLiteOpenHelper).folder.upgradeTableFor3001(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 3001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager.2
 * JD-Core Version:    0.7.0.1
 */