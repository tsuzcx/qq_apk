package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.LinkedHashMap;

public class ContactSearchCursor
  extends ContactBaseListCursor
{
  private static int SEARCH_ACCOUNT_AND_TYPE;
  private static int SEARCH_ALL_CONTACT = 3;
  private static int SEARCH_BLACK_WHITE = 4;
  private static int SEARCH_COMPOSE = 0;
  private static int SEARCH_GROUP;
  private int groupId;
  private int nameListType;
  private String searchKey;
  private int searchType = SEARCH_ACCOUNT_AND_TYPE;
  private int[] types;
  
  static
  {
    SEARCH_ACCOUNT_AND_TYPE = 1;
    SEARCH_GROUP = 2;
  }
  
  public ContactSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt, int paramInt, String paramString)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt);
    this.groupId = paramInt;
    this.searchKey = paramString;
  }
  
  public ContactSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt, String paramString)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt);
    this.searchKey = paramString;
  }
  
  public ContactSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, String paramString)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt1);
    this.types = paramArrayOfInt2;
    this.searchKey = paramString;
    this.nameListType = paramInt;
  }
  
  public ContactSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt1);
    this.types = paramArrayOfInt2;
    this.searchKey = paramString;
  }
  
  public ContactSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean, String paramString)
  {
    this(paramQMMailSQLiteHelper, paramArrayOfInt1, paramArrayOfInt2, paramString);
    if (paramBoolean) {
      this.searchType = SEARCH_ALL_CONTACT;
    }
  }
  
  private int[] getAccoutIdWithZero()
  {
    int[] arrayOfInt1 = new int[getAccountIds().length + 1];
    int[] arrayOfInt2 = getAccountIds();
    int k = arrayOfInt2.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      arrayOfInt1[i] = arrayOfInt2[j];
      j += 1;
      i += 1;
    }
    arrayOfInt1[i] = 0;
    return arrayOfInt1;
  }
  
  public String getCategory(MailContact paramMailContact)
  {
    String str1 = null;
    if (this.searchType == SEARCH_ALL_CONTACT) {
      if ((paramMailContact.getType() == MailContact.ContactType.NormalContact) || (paramMailContact.getType() == MailContact.ContactType.ProtocolContact)) {
        str1 = QMApplicationContext.sharedInstance().getString(2131692076);
      }
    }
    for (;;)
    {
      String str2 = str1;
      if (this.searchType == SEARCH_COMPOSE) {
        if (paramMailContact.getFreq() <= 0)
        {
          str2 = str1;
          if (paramMailContact.getFreqUpdateTime() <= 0) {}
        }
        else
        {
          str2 = QMApplicationContext.sharedInstance().getString(2131692071);
        }
      }
      paramMailContact = str2;
      if (str2 == null) {
        paramMailContact = "#";
      }
      return paramMailContact;
      str1 = QMApplicationContext.sharedInstance().getString(2131692065);
      continue;
      if (!StringExtention.isNullOrEmpty(paramMailContact.getPinyin())) {
        str1 = paramMailContact.getPinyin().substring(0, 1).toUpperCase();
      }
    }
  }
  
  protected MailContact getItem(Cursor paramCursor)
  {
    if (this.searchType == SEARCH_COMPOSE) {
      return QMContactSQLite.fillEmailContact(paramCursor, this.cacheColumnIndex);
    }
    if (this.searchType == SEARCH_BLACK_WHITE)
    {
      paramCursor = QMContactSQLite.fillContact(paramCursor, this.cacheColumnIndex);
      return this.sqliteHelper.contact.getContactById(this.sqliteHelper.getReadableDatabase(), paramCursor.getId());
    }
    return super.getItem(paramCursor);
  }
  
  protected Cursor queryRawCursor()
  {
    if (this.searchType == SEARCH_COMPOSE) {
      return this.sqliteHelper.contact.querySearchComposeContact(this.sqliteHelper.getReadableDatabase(), getAccoutIdWithZero(), this.searchKey);
    }
    if (this.searchType == SEARCH_ACCOUNT_AND_TYPE) {
      return this.sqliteHelper.contact.querySearchContactByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), this.types, this.searchKey);
    }
    if (this.searchType == SEARCH_GROUP) {
      return this.sqliteHelper.contact.querySearchContactByGid(this.sqliteHelper.getReadableDatabase(), getAccountIds(), this.groupId, this.searchKey);
    }
    if (this.searchType == SEARCH_BLACK_WHITE)
    {
      String str = AccountManager.shareInstance().getAccountList().getAccountById(getAccountIds()[0]).getEmail();
      return this.sqliteHelper.contact.querySearchBlackWhiteListAddContact(this.sqliteHelper.getReadableDatabase(), getAccountIds(), this.nameListType, this.searchKey, str);
    }
    if (this.searchType == SEARCH_ALL_CONTACT) {
      return this.sqliteHelper.contact.querySearchContactByTypesOrderByType(this.sqliteHelper.getReadableDatabase(), getAccoutIdWithZero(), this.types, this.searchKey);
    }
    return null;
  }
  
  protected LinkedHashMap<String, Integer> querySectionMap()
  {
    if (this.searchType == SEARCH_COMPOSE) {
      return this.sqliteHelper.contact.getComposeContactSectionMap(this.sqliteHelper.getReadableDatabase(), getAccoutIdWithZero(), this.searchKey);
    }
    if (this.searchType == SEARCH_ACCOUNT_AND_TYPE) {
      return this.sqliteHelper.contact.querySearchAccountSectionsByTypes(this.sqliteHelper.getReadableDatabase(), getAccountIds(), this.types, this.searchKey);
    }
    if (this.searchType == SEARCH_GROUP) {
      return this.sqliteHelper.contact.querySearchSectionByGid(this.sqliteHelper.getReadableDatabase(), this.groupId, this.searchKey);
    }
    if (this.searchType == SEARCH_ALL_CONTACT) {
      return this.sqliteHelper.contact.querySearchAccountSectionsByTypesOrderByType(this.sqliteHelper.getReadableDatabase(), getAccoutIdWithZero(), this.types, this.searchKey);
    }
    return null;
  }
  
  protected void reload() {}
  
  public void setSearchKey(String paramString)
  {
    this.searchKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactSearchCursor
 * JD-Core Version:    0.7.0.1
 */