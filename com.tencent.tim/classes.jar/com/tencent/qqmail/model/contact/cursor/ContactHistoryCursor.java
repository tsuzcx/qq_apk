package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import java.util.LinkedHashMap;

public class ContactHistoryCursor
  extends ContactBaseListCursor
{
  public ContactHistoryCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt);
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqliteHelper.contact.queryAccountContactsByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), new int[] { MailContact.ContactType.HistoryContact.ordinal() });
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    return this.sqliteHelper.contact.queryAccountSectionsByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), new int[] { MailContact.ContactType.HistoryContact.ordinal() });
  }
  
  protected void reload()
  {
    QMContactManager.sharedInstance().loadAccountContactsByType(getAccountIds(), new MailContact.ContactType[] { MailContact.ContactType.HistoryContact });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactHistoryCursor
 * JD-Core Version:    0.7.0.1
 */