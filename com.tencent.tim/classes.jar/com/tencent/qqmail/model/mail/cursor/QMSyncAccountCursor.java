package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

public class QMSyncAccountCursor
  extends QMSyncFolderCursor
{
  private int accountId;
  private Cursor cursor;
  
  public QMSyncAccountCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int paramInt)
  {
    super(paramQMMailSQLiteHelper);
    this.accountId = paramInt;
    this.remoteIdOnly = true;
    this.cursor = queryRawCursor();
  }
  
  public Cursor getCursor()
  {
    return this.cursor;
  }
  
  public Cursor queryRawCursor()
  {
    return this.sqliteHelper.mail.getSyncAccountCursor(this.sqliteHelper.getReadableDatabase(), this.accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSyncAccountCursor
 * JD-Core Version:    0.7.0.1
 */