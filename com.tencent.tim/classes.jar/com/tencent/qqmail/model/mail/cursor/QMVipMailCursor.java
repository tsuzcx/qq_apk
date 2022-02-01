package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

public class QMVipMailCursor
  extends QMQQMailFlagHybridMailListCursor
{
  public QMVipMailCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, AccountList paramAccountList)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramAccountList);
  }
  
  protected int getActualFolderId()
  {
    return -3;
  }
  
  protected int getFolderType()
  {
    return 17;
  }
  
  protected int getQQMailFolderId(int paramInt)
  {
    return QMFolderManager.sharedInstance().getQQMailVipFolderId(paramInt);
  }
  
  protected Cursor queryHybirdRawCursor()
  {
    return this.sqliteHelper.mail.getVipMailListCursor(this.sqliteHelper.getReadableDatabase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMVipMailCursor
 * JD-Core Version:    0.7.0.1
 */