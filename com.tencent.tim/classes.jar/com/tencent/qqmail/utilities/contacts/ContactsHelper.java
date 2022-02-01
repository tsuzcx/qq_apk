package com.tencent.qqmail.utilities.contacts;

import alld;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.addressparser.QMAddressParser;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

public class ContactsHelper
{
  private static final Uri CONTACTS_URI = ContactsContract.Contacts.CONTENT_URI;
  private static final String DISPLAY_NAME = "display_name";
  private static final String EMAIL_CONTACT_ID = "contact_id";
  private static final String EMAIL_DATA = "data1";
  private static final Uri EMAIL_URI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
  private static final String TAG = ContactsHelper.class.getSimpleName();
  private static final String _ID = "_id";
  
  public static String filterPhoneNum(String paramString)
  {
    String str1 = "";
    String str2 = paramString;
    if (paramString.endsWith("@qq.com"))
    {
      str2 = paramString.replace("@qq.com", "");
      str1 = "@qq.com";
    }
    if (str2.length() < 11)
    {
      Log.d("filterPhoneNum", "手机号码格式不对 : " + str2);
      return null;
    }
    str2 = str2.replace(" ", "").replace("-", "").replace("(", "").replace(")", "");
    if (str2.startsWith("+86")) {
      paramString = str2.substring(3);
    }
    while (paramString.length() != 11)
    {
      Log.d("filterPhoneNum", "手机号码长度不对 : " + paramString);
      return null;
      if (str2.startsWith("86"))
      {
        paramString = str2.substring(2);
      }
      else
      {
        paramString = str2;
        if (str2.startsWith("0086")) {
          paramString = str2.substring(4);
        }
      }
    }
    if (paramString.matches("^(1(([35][0-9])|(47)|[8][012356789]))\\d{8}$")) {
      return paramString + str1;
    }
    Log.d("filterPhoneNum", "手机号码格式不对 : " + paramString);
    return null;
  }
  
  public static List<String> generatePinyin(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.length();
      i = 0;
    }
    for (;;)
    {
      char c;
      if (i < j)
      {
        c = paramString.charAt(i);
        if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {}
        try
        {
          localStringBuilder1.append(c);
          localStringBuilder2.append(c);
        }
        catch (Exception localException)
        {
          Object localObject;
          QMLog.log(6, TAG, c + " : " + localException.getMessage());
        }
        localObject = PinyinHelper.toHanyuPinyinStringArray(c);
        if ((localObject != null) && (localObject.length > 0))
        {
          localObject = localObject[0].replaceAll("[^a-z]", "");
          if (!StringUtils.isEmpty((CharSequence)localObject))
          {
            localStringBuilder2.append(String.valueOf(localObject));
            localStringBuilder1.append(String.valueOf(((String)localObject).charAt(0)));
          }
        }
      }
      else
      {
        return Lists.newArrayList(new String[] { localStringBuilder1.toString().toUpperCase(Locale.getDefault()), localStringBuilder2.toString().toUpperCase(Locale.getDefault()) });
      }
      i += 1;
    }
  }
  
  public static int getMobileContactCount()
  {
    Cursor localCursor = alld.query(QMApplicationContext.sharedInstance().getContentResolver(), EMAIL_URI, new String[] { "contact_id" }, null, null, "");
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      localCursor.close();
      return i;
    }
    return 0;
  }
  
  public static int getMobileContactCount(ArrayList<MailContact> paramArrayList)
  {
    int j = 0;
    int i = j;
    if (paramArrayList != null)
    {
      i = j;
      if (paramArrayList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        i = 0;
        if (paramArrayList.hasNext())
        {
          if (((MailContact)paramArrayList.next()).getType() != MailContact.ContactType.PhoneContact) {
            break label60;
          }
          i += 1;
        }
      }
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static List<MailContact> getMobileContacts()
  {
    Object localObject9 = QMApplicationContext.sharedInstance().getContentResolver();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Cursor localCursor = alld.query((ContentResolver)localObject9, EMAIL_URI, new String[] { "contact_id", "data1" }, null, null, "contact_id ASC");
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          localObject7 = null;
          localObject1 = null;
          localObject8 = getStringFromField(localCursor, "contact_id");
          String str = getStringFromField(localCursor, "data1");
          localObject4 = localObject1;
          if (!((String)localObject8).equals(localObject1))
          {
            localArrayList2.add(localObject8);
            localObject7 = new ArrayList();
            localObject1 = new MailContact();
            ((MailContact)localObject1).setCid("0");
            ((MailContact)localObject1).setAccountId(0);
            ((MailContact)localObject1).setAddress(str);
            ((MailContact)localObject1).setType(MailContact.ContactType.PhoneContact);
            ((MailContact)localObject1).setEmails((ArrayList)localObject7);
            ((MailContact)localObject1).setHashType(0);
            ((MailContact)localObject1).setHash(MailContact.generateHash((MailContact)localObject1));
            ((MailContact)localObject1).setOfflineType(0);
            ((MailContact)localObject1).setId(MailContact.generateMobileContactId(((MailContact)localObject1).getAccountId(), ((MailContact)localObject1).getType().ordinal(), ((MailContact)localObject1).getCid(), ((MailContact)localObject1).getAddress()));
            localArrayList1.add(localObject1);
            localObject4 = localObject8;
          }
          ((ArrayList)localObject7).add(new ContactEmail(str));
          boolean bool = localCursor.moveToNext();
          localObject1 = localObject4;
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject1;
        Object localObject4;
        QMLog.log(6, TAG, "emailCursor exec err:" + localException2.getStackTrace());
        try
        {
          localCursor.close();
        }
        catch (Exception localException3)
        {
          QMLog.log(6, TAG, "emailCursor close err:" + localException3.getStackTrace());
        }
        continue;
      }
      finally
      {
        Object localObject7;
        Object localObject8;
        try
        {
          localCursor.close();
          throw localObject2;
        }
        catch (Exception localException7)
        {
          QMLog.log(6, TAG, "emailCursor close err:" + localException7.getStackTrace());
          continue;
        }
        Object localObject3 = ",";
        continue;
        localObject3 = CONTACTS_URI;
        Object localObject5 = localException7.toString();
        localObject3 = alld.query((ContentResolver)localObject9, (Uri)localObject3, new String[] { "_id", "display_name" }, (String)localObject5, null, null);
        if (localObject3 == null) {
          continue;
        }
        int i = 0;
        try
        {
          if (i < ((Cursor)localObject3).getCount())
          {
            ((Cursor)localObject3).moveToPosition(i);
            localObject5 = getStringFromField((Cursor)localObject3, "_id");
            localObject7 = getStringFromField((Cursor)localObject3, "display_name");
            int j = 0;
            if (j < localArrayList2.size())
            {
              if ((localObject5 != null) && (((String)localObject5).equals(localArrayList2.get(j))))
              {
                localObject8 = (MailContact)localArrayList1.get(j);
                ((MailContact)localObject8).setName((String)localObject7);
                ((MailContact)localObject8).setNick((String)localObject7);
                localObject9 = generatePinyin((String)localObject7);
                ((MailContact)localObject8).setPinyin((String)((List)localObject9).get(0));
                ((MailContact)localObject8).setFullPinyin((String)((List)localObject9).get(1));
              }
              j += 1;
              continue;
            }
            i += 1;
            continue;
          }
        }
        catch (Exception localException8)
        {
          QMLog.log(6, TAG, "contactCursor exec err:" + localException8.getStackTrace());
          try
          {
            localException4.close();
          }
          catch (Exception localException5)
          {
            QMLog.log(6, TAG, "contactCursor close err:" + localException5.getStackTrace());
          }
          continue;
        }
        finally
        {
          try
          {
            localException5.close();
            throw localObject6;
          }
          catch (Exception localException6)
          {
            for (;;)
            {
              QMLog.log(6, TAG, "contactCursor close err:" + localException6.getStackTrace());
            }
          }
        }
        try
        {
          ((Cursor)localObject3).close();
          localObject3 = localArrayList1.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label901;
          }
          localObject5 = (MailContact)((Iterator)localObject3).next();
          ((MailContact)localObject5).setHash(MailContact.generateHash((MailContact)localObject5));
          continue;
        }
        catch (Exception localException4)
        {
          QMLog.log(6, TAG, "contactCursor close err:" + localException4.getStackTrace());
          continue;
        }
      }
      try
      {
        localCursor.close();
        if (!localArrayList2.isEmpty())
        {
          localObject4 = new StringBuilder("_id in (");
          i = 0;
          if (i < localArrayList2.size())
          {
            localObject7 = ((StringBuilder)localObject4).append((String)localArrayList2.get(i));
            if (i == localArrayList2.size() - 1)
            {
              localObject1 = ")";
              ((StringBuilder)localObject7).append((String)localObject1);
              i += 1;
              continue;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        QMLog.log(6, TAG, "emailCursor close err:" + localException1.getStackTrace());
      }
    }
    label901:
    return localArrayList1;
  }
  
  public static int getOtherContactCount(ArrayList<MailContact> paramArrayList)
  {
    int j = 0;
    int i = j;
    if (paramArrayList != null)
    {
      i = j;
      if (paramArrayList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        i = 0;
        if (paramArrayList.hasNext())
        {
          MailContact localMailContact = (MailContact)paramArrayList.next();
          if ((localMailContact.getType() == MailContact.ContactType.NormalContact) || (localMailContact.getType() == MailContact.ContactType.ProtocolContact)) {
            break label72;
          }
          i += 1;
        }
      }
    }
    label72:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private static String getStringFromField(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex(paramString));
  }
  
  public static ArrayList<Object> parseAddrs(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = paramString.replaceAll("​", "").replaceAll("‌", "").replaceAll("‍", "").replaceAll("⁠", "").replaceAll("﻿", "").split(";");
    ArrayList localArrayList2 = Lists.newArrayList();
    int j = localObject2.length;
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = localObject2[i];
      paramString = (String)localObject1;
      if (Pattern.compile("\\)\\s*<").matcher((CharSequence)localObject1).find())
      {
        paramString = (String)localObject1;
        if (Pattern.matches("\\s*[^\"'\\(\\)<>@]*\\([^\"'<>@]+?\\)\\s*<[^@]+@[^@]+>[\\s\\t;,]*", (CharSequence)localObject1)) {
          paramString = ((String)localObject1).replaceAll("([^\"'\\s@\\t;,<>]+)\\s*(<[^@]+@[^@]+>)", "\"$1\"$2");
        }
      }
      localArrayList2.add(paramString);
      i += 1;
    }
    paramString = QMAddressParser.parseAddr(Joiner.on(";").join(localArrayList2)).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (HashMap)paramString.next();
      if (StringUtils.equalsIgnoreCase((CharSequence)((HashMap)localObject1).get("valid"), "true"))
      {
        localObject2 = new MailContact();
        ((MailContact)localObject2).setName((String)((HashMap)localObject1).get("nick"));
        ((MailContact)localObject2).setNick((String)((HashMap)localObject1).get("nick"));
        ((MailContact)localObject2).setAddress((String)((HashMap)localObject1).get("addr"));
        ((MailContact)localObject2).setEmails(Lists.newArrayList(new ContactEmail[] { new ContactEmail(((MailContact)localObject2).getAddress(), 0, 0) }));
        localArrayList1.add(localObject2);
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.contacts.ContactsHelper
 * JD-Core Version:    0.7.0.1
 */