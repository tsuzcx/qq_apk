package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

public class QMAllTrashMailListCursor
  extends QMLocalHybirdMailListCursor
{
  public QMAllTrashMailListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    super(paramQMMailSQLiteHelper);
  }
  
  protected int getActualFolderId()
  {
    return -12;
  }
  
  protected int getActualFolderType()
  {
    return 5;
  }
  
  protected Cursor queryHybirdRawCursor()
  {
    return this.sqliteHelper.mail.getAllTrashMailListCursor(this.sqliteHelper.getReadableDatabase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMAllTrashMailListCursor
 * JD-Core Version:    0.7.0.1
 */