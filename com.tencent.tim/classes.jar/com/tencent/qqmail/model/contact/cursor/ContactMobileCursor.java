package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import java.util.LinkedHashMap;

public class ContactMobileCursor
  extends ContactBaseListCursor
{
  public ContactMobileCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    super(paramQMMailSQLiteHelper, new int[] { 0 });
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqliteHelper.contact.queryAccountContactsByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), new int[] { MailContact.ContactType.PhoneContact.ordinal() });
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    return this.sqliteHelper.contact.queryAccountSectionsByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), new int[] { MailContact.ContactType.PhoneContact.ordinal() });
  }
  
  protected void reload()
  {
    QMContactManager.sharedInstance().reindexMobileContact();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactMobileCursor
 * JD-Core Version:    0.7.0.1
 */