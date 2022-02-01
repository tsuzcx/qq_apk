package com.tencent.qqmail.model.mail.upgrade;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.attachment.QMAttachSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSQLiteDatabaseUpgradeManager$43
  extends QMSQLiteDatabaseUpgrade
{
  QMSQLiteDatabaseUpgradeManager$43(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager1, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager2)
  {
    super(paramQMSQLiteDatabaseUpgradeManager2);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if ((paramSQLiteOpenHelper instanceof QMMailSQLiteHelper))
    {
      QMLog.log(4, "QMSQLiteDatabaseUpgradeManager", "5301. upgrade attach table");
      ((QMMailSQLiteHelper)paramSQLiteOpenHelper).attach.upgradeTableFor5301(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 5301;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager.43
 * JD-Core Version:    0.7.0.1
 */