package com.tencent.qqmail.model.mail.upgrade;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.attachment.QMAttachSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class QMSQLiteDatabaseUpgradeManager$4
  extends QMSQLiteDatabaseUpgrade
{
  QMSQLiteDatabaseUpgradeManager$4(QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager1, QMSQLiteDatabaseUpgradeManager paramQMSQLiteDatabaseUpgradeManager2)
  {
    super(paramQMSQLiteDatabaseUpgradeManager2);
  }
  
  public void doUpgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if ((paramSQLiteOpenHelper instanceof QMMailSQLiteHelper))
    {
      QMLog.log(4, "QMSQLiteDatabaseUpgradeManager", "3003. upgrade wtlogin for 3.1. set not wtlogin");
      SharedPreferenceUtil.setWtlogin(false);
      paramSQLiteOpenHelper = (QMMailSQLiteHelper)paramSQLiteOpenHelper;
      paramSQLiteOpenHelper.mail.upgradeTableFor3003(paramSQLiteDatabase);
      paramSQLiteOpenHelper.attach.upgradeTableFor3003(paramSQLiteDatabase);
    }
  }
  
  public int getVersion()
  {
    return 3003;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager.4
 * JD-Core Version:    0.7.0.1
 */