package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import androidx.annotation.NonNull;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;

public class QMGroupFolderCursor
  extends QMFolderCursor
{
  private Cursor mGroupContactsInfo = null;
  
  public QMGroupFolderCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, int paramInt)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramInt);
  }
  
  @NonNull
  public Mail getItem(int paramInt)
  {
    Mail localMail = super.getItem(paramInt);
    if (this.mGroupContactsInfo == null) {
      this.mGroupContactsInfo = this.sqliteHelper.mail.queryForRelativeGroupContact(this.sqliteHelper.getReadableDatabase());
    }
    Object localObject = this.sqliteHelper.mail;
    localObject = QMMailSQLite.searchGroupContactFromCursor(this.mGroupContactsInfo, localMail.getInformation().getId());
    if (localObject != null) {
      localMail.getInformation().setGroupContact((MailGroupContact)localObject);
    }
    return localMail;
  }
  
  public Cursor queryRawCursor()
  {
    this.mGroupContactsInfo = this.sqliteHelper.mail.queryForRelativeGroupContact(this.sqliteHelper.getReadableDatabase());
    return super.queryRawCursor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMGroupFolderCursor
 * JD-Core Version:    0.7.0.1
 */