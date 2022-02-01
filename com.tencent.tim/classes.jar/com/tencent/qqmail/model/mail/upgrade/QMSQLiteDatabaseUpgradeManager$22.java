package com.tencent.qqmail.model.mail.upgrade;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.folderlist.FolderDataSQLite;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSQLiteDatabaseUpgradeManager$22
  extends QMSQLiteDatabaseUpgrade
{
  QMSQLiteDatabaseUpgradeManager$22(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager1, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager2)
  {
    super(paramQMSQLiteDatabaseUpgradeManager2);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if ((paramSQLiteOpenHelper instanceof QMMailSQLiteHelper))
    {
      QMLog.log(4, "QMSQLiteDatabaseUpgradeManager", "5000. update contact");
      paramSQLiteOpenHelper = (QMMailSQLiteHelper)paramSQLiteOpenHelper;
      paramSQLiteOpenHelper.contact.upgradeTableFor5000(paramSQLiteDatabase);
      QMLog.log(4, "QMSQLiteDatabaseUpgradeManager", "5000. upgrade popularize relateId");
      paramSQLiteOpenHelper.mail.upgradeTableFor5000(paramSQLiteDatabase);
      paramSQLiteOpenHelper.folderData.upgradeTableFor5000(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 5000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager.22
 * JD-Core Version:    0.7.0.1
 */