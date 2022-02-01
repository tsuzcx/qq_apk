package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

public class QMAllSelfMailListCursor
  extends QMLocalHybirdMailListCursor
{
  public QMAllSelfMailListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    super(paramQMMailSQLiteHelper);
  }
  
  protected int getActualFolderId()
  {
    return -14;
  }
  
  protected int getActualFolderType()
  {
    return 0;
  }
  
  protected Cursor queryHybirdRawCursor()
  {
    return this.sqliteHelper.mail.getAllSelfMailListCursor(this.sqliteHelper.getReadableDatabase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMAllSelfMailListCursor
 * JD-Core Version:    0.7.0.1
 */