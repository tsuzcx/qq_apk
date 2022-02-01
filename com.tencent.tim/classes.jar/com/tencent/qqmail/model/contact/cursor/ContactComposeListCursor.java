package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.LinkedHashMap;

public class ContactComposeListCursor
  extends ContactBaseListCursor
{
  public ContactComposeListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt);
  }
  
  public String getCategory(MailContact paramMailContact)
  {
    String str = null;
    if (!StringExtention.isNullOrEmpty(paramMailContact.getPinyin())) {
      str = paramMailContact.getPinyin().substring(0, 1).toUpperCase();
    }
    if ((paramMailContact.getFreq() > 0) || (paramMailContact.getFreqUpdateTime() > 0)) {
      str = QMApplicationContext.sharedInstance().getString(2131692071);
    }
    paramMailContact = str;
    if (str == null) {
      paramMailContact = "#";
    }
    return paramMailContact;
  }
  
  public int getHistoryContactCount()
  {
    int i = 0;
    int j = 0;
    Cursor localCursor = this.sqliteHelper.contact.queryComposeHistoryContactCount(this.sqliteHelper.getReadableDatabase(), getAccountIds());
    if (localCursor != null)
    {
      i = j;
      if (localCursor.moveToFirst()) {
        i = localCursor.getInt(0);
      }
      localCursor.close();
    }
    return i;
  }
  
  protected MailContact getItem(Cursor paramCursor)
  {
    return QMContactSQLite.fillEmailContact(paramCursor, this.cacheColumnIndex);
  }
  
  protected Cursor queryRawCursor()
  {
    return this.sqliteHelper.contact.queryComposeContact(this.sqliteHelper.getReadableDatabase(), getAccountIds());
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    return this.sqliteHelper.contact.getComposeContactSectionMap(this.sqliteHelper.getReadableDatabase(), getAccountIds());
  }
  
  protected void reload()
  {
    QMContactManager.sharedInstance().loadAccountContactsByType(getAccountIds(), new MailContact.ContactType[] { MailContact.ContactType.NormalContact, MailContact.ContactType.HistoryContact, MailContact.ContactType.QQFriendContact, MailContact.ContactType.DomainContact });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactComposeListCursor
 * JD-Core Version:    0.7.0.1
 */