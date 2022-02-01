package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import androidx.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.maillist.MailListUtil;
import com.tencent.qqmail.maillist.MailListUtil.IDraftAlike;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.QMFolder;

public class QMDraftFolderCursor
  extends QMFolderCursor
  implements MailListUtil.IDraftAlike
{
  private Cursor mContactCursor = null;
  
  public QMDraftFolderCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, int paramInt)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramInt);
  }
  
  public void close()
  {
    super.close();
    QMCursorCollector.release(this.mContactCursor);
    this.mContactCursor = null;
  }
  
  @NonNull
  public Mail getItem(int paramInt)
  {
    Mail localMail = super.getItem(paramInt);
    relateContact(localMail);
    return localMail;
  }
  
  public boolean isOverdue()
  {
    if (this.folder.getType() == 3) {
      return super.isOverdue();
    }
    return true;
  }
  
  public Cursor queryForRelativeContacts()
  {
    if (this.folder == null) {
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.mail.queryForAllRelativeContacts(localSQLiteDatabase, new int[] { this.folder.getId() }, 0);
  }
  
  public Cursor queryRawCursor()
  {
    if (this.folder == null) {
      return null;
    }
    Object localObject = this.sqliteHelper.getReadableDatabase();
    localObject = this.sqliteHelper.mail.getFolderMailListCursor((SQLiteDatabase)localObject, this.folder);
    Cursor localCursor = this.mContactCursor;
    this.mContactCursor = queryForRelativeContacts();
    QMCursorCollector.retain(this.mContactCursor);
    QMCursorCollector.release(localCursor);
    return localObject;
  }
  
  public void relateContact(Mail paramMail)
  {
    Cursor localCursor = this.mContactCursor;
    QMCursorCollector.retain(localCursor);
    MailListUtil.relateContact(this.mContactCursor, paramMail);
    QMCursorCollector.release(localCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMDraftFolderCursor
 * JD-Core Version:    0.7.0.1
 */