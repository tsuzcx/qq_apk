package com.tencent.qqmail.model.contact;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;

public class ContactsHistoryMailSearchInfo
  extends SearchInfo
{
  private final String PARAM_SENDER_AND_RECEIVER = "&sender=$email$&receiver=$email$";
  private ArrayList<Account> accounts;
  private ArrayList<String> emails;
  
  public ContactsHistoryMailSearchInfo()
  {
    super(3);
    this.area = 16;
  }
  
  public ArrayList<Account> getAccounts()
  {
    return this.accounts;
  }
  
  public ArrayList<String> getEmails()
  {
    return this.emails;
  }
  
  public String getKeyword()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = this.emails.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      try
      {
        String str = StringExtention.urlEncode((String)localObject);
        localObject = str;
      }
      catch (Exception localException)
      {
        label47:
        break label47;
      }
      localStringBuilder.append("&sender=$email$&receiver=$email$".replace("$email$", (CharSequence)localObject));
    }
    return localStringBuilder.toString();
  }
  
  public void setAccounts(ArrayList<Account> paramArrayList)
  {
    this.accounts = paramArrayList;
  }
  
  public void setEmails(ArrayList<String> paramArrayList)
  {
    this.emails = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.ContactsHistoryMailSearchInfo
 * JD-Core Version:    0.7.0.1
 */