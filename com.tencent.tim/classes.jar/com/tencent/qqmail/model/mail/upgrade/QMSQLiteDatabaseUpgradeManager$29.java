package com.tencent.qqmail.model.mail.upgrade;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.namelist.NameListSQLite;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSQLiteDatabaseUpgradeManager$29
  extends QMSQLiteDatabaseUpgrade
{
  QMSQLiteDatabaseUpgradeManager$29(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager1, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager2)
  {
    super(paramQMSQLiteDatabaseUpgradeManager2);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if ((paramSQLiteOpenHelper instanceof QMMailSQLiteHelper))
    {
      QMLog.log(4, "QMSQLiteDatabaseUpgradeManager", "5007. create black_white_name_list table");
      ((QMMailSQLiteHelper)paramSQLiteOpenHelper).nameList.upgradeTableFor5007(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 5007;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager.29
 * JD-Core Version:    0.7.0.1
 */