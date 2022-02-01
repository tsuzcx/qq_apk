package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import java.util.LinkedHashMap;

public class ContactListCursor
  extends ContactBaseListCursor
{
  public ContactListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt);
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqliteHelper.contact.queryAccountContactsByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), new int[] { MailContact.ContactType.NormalContact.ordinal(), MailContact.ContactType.ProtocolContact.ordinal() });
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    return this.sqliteHelper.contact.queryAccountSectionsByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), new int[] { MailContact.ContactType.NormalContact.ordinal(), MailContact.ContactType.ProtocolContact.ordinal() });
  }
  
  protected void reload()
  {
    QMContactManager.sharedInstance().loadAccountContactsByType(getAccountIds(), new MailContact.ContactType[] { MailContact.ContactType.NormalContact, MailContact.ContactType.HistoryContact, MailContact.ContactType.QQFriendContact, MailContact.ContactType.DomainContact });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactListCursor
 * JD-Core Version:    0.7.0.1
 */