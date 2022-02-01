package com.tencent.qqmail.model.mail.upgrade;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSQLiteDatabaseUpgradeManager$20
  extends QMSQLiteDatabaseUpgrade
{
  QMSQLiteDatabaseUpgradeManager$20(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager1, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager2)
  {
    super(paramQMSQLiteDatabaseUpgradeManager2);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if ((paramSQLiteOpenHelper instanceof QMMailSQLiteHelper))
    {
      QMLog.log(4, "QMSQLiteDatabaseUpgradeManager", "4015. update popularize weight and popularizeSubItem");
      ((QMMailSQLiteHelper)paramSQLiteOpenHelper).mail.upgradeTableFor4015(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 4015;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager.20
 * JD-Core Version:    0.7.0.1
 */