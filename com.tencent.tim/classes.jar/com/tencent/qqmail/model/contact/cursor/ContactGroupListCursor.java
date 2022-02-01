package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import java.util.LinkedHashMap;

public class ContactGroupListCursor
  extends ContactBaseListCursor
{
  private int groupId;
  
  public ContactGroupListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int paramInt1, int paramInt2)
  {
    super(paramQMMailSQLiteHelper, new int[] { paramInt1 });
    this.groupId = paramInt2;
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqliteHelper.contact.queryContactsByGid(this.sqliteHelper.getReadableDatabase(), this.groupId);
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    return this.sqliteHelper.contact.querySectionsByGid(this.sqliteHelper.getReadableDatabase(), this.groupId);
  }
  
  protected void reload()
  {
    QMContactManager.sharedInstance().loadAccountContactsByType(getAccountIds(), new MailContact.ContactType[] { MailContact.ContactType.QQFriendContact, MailContact.ContactType.DomainContact });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactGroupListCursor
 * JD-Core Version:    0.7.0.1
 */