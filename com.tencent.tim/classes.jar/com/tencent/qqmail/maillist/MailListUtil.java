package com.tencent.qqmail.maillist;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.trd.guava.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MailListUtil
{
  private static ArrayList<Object> convContact(List<MailContact> paramList)
  {
    ArrayList localArrayList = Lists.newArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add((MailContact)paramList.next());
      }
    }
    return localArrayList;
  }
  
  public static void relateContact(Cursor paramCursor, Mail paramMail)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return;
    }
    paramMail = paramMail.getInformation();
    paramCursor = QMMailSQLite.searchContactsFromCursor(paramCursor, paramMail.getId());
    paramMail.setCcList(convContact((List)paramCursor.get(Integer.valueOf(3))));
    paramMail.setBccList(convContact((List)paramCursor.get(Integer.valueOf(4))));
    paramMail.setToList(convContact((List)paramCursor.get(Integer.valueOf(2))));
  }
  
  public static abstract interface IDraftAlike
  {
    public abstract Cursor queryForRelativeContacts();
    
    public abstract void relateContact(Mail paramMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.MailListUtil
 * JD-Core Version:    0.7.0.1
 */