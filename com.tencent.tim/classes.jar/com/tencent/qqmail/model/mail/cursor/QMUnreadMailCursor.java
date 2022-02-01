package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

public class QMUnreadMailCursor
  extends QMQQMailFlagHybridMailListCursor
{
  public QMUnreadMailCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, AccountList paramAccountList)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramAccountList);
  }
  
  protected int getActualFolderId()
  {
    return -9;
  }
  
  protected int getFolderType()
  {
    return 18;
  }
  
  protected int getQQMailFolderId(int paramInt)
  {
    return QMFolderManager.sharedInstance().getQQMailUnreadFolderId(paramInt);
  }
  
  protected Cursor queryHybirdRawCursor()
  {
    if (isQQMailOnly()) {
      return this.sqliteHelper.mail.getQQUnreadedMailListCursor(this.sqliteHelper.getReadableDatabase(), this.accounts.get(0).getId());
    }
    if (this.accounts.size() == 1) {
      return this.sqliteHelper.mail.getProtocolUnreadedMailListCursor(this.sqliteHelper.getReadableDatabase(), this.accounts.get(0).getId());
    }
    return this.sqliteHelper.mail.getUnreadedMailListCursor(this.sqliteHelper.getReadableDatabase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMUnreadMailCursor
 * JD-Core Version:    0.7.0.1
 */