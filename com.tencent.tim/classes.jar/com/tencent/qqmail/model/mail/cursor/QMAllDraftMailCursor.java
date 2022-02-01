package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import androidx.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.maillist.MailListUtil;
import com.tencent.qqmail.maillist.MailListUtil.IDraftAlike;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;

public class QMAllDraftMailCursor
  extends QMLocalHybirdMailListCursor
  implements MailListUtil.IDraftAlike
{
  private Cursor mContactCursor = null;
  
  public QMAllDraftMailCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    super(paramQMMailSQLiteHelper);
  }
  
  public void beforeRefresh()
  {
    this.mContactCursor = queryForRelativeContacts();
  }
  
  public void close()
  {
    super.close();
    QMCursorCollector.release(this.mContactCursor);
    this.mContactCursor = null;
  }
  
  protected int getActualFolderId()
  {
    return -11;
  }
  
  protected int getActualFolderType()
  {
    return 4;
  }
  
  @NonNull
  public Mail getItem(int paramInt)
  {
    Mail localMail = super.getItem(paramInt);
    relateContact(localMail);
    return localMail;
  }
  
  public Cursor queryForRelativeContacts()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    return this.sqliteHelper.mail.queryForRelativeContacts(localSQLiteDatabase, null, 4);
  }
  
  protected Cursor queryHybirdRawCursor()
  {
    return this.sqliteHelper.mail.getAllDraftMailListCursor(this.sqliteHelper.getReadableDatabase());
  }
  
  public void relateContact(Mail paramMail)
  {
    MailListUtil.relateContact(this.mContactCursor, paramMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMAllDraftMailCursor
 * JD-Core Version:    0.7.0.1
 */