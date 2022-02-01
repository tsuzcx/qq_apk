package com.tencent.qqmail.model.contact;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class QMContactCGIManager
{
  private static final String ADDRID = "AddrID";
  private static final String DATA_TYPE = "datatype";
  private static final String DATA_TYPE_DOMAIN = "domain";
  private static final String DATA_TYPE_HISTORY = "history";
  private static final String DATA_TYPE_NORMAL = "normal";
  private static final String DATA_TYPE_QQ = "qq";
  private static final long GROUP_CONTACT_UPDATE_INTERVAL = 3600000L;
  private static final String LIST_DOMAIN = "domainlist";
  private static final String LIST_HISTORY = "historylist";
  private static final String LIST_NORMAL = "normallist";
  private static final String LIST_QQ = "qqlist";
  private static final String PARAM_ADR = "adr";
  private static final String PARAM_BIRTHDAY = "birthday";
  private static final String PARAM_CUSTOM = "custom";
  private static final String PARAM_EMAIL = "email";
  private static final String PARAM_ID = "id";
  private static final String PARAM_IM = "IM";
  private static final String PARAM_NAME = "name";
  private static final String PARAM_NOTE = "note";
  private static final String PARAM_TEL = "tel";
  private static final String SYNC_KEY_DOMAIN = "domainsynckey";
  private static final String SYNC_KEY_HISTORY = "historysynckey";
  private static final String SYNC_KEY_NORMAL = "normalsynckey";
  private static final String SYNC_KEY_QQ = "qqsynckey";
  public static final String TAG = "QMContactCGIManager";
  private QMMailSQLiteHelper sqliteHelper;
  
  public QMContactCGIManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  private String appendAddEditContactParams(String paramString, MailContact paramMailContact, boolean paramBoolean)
  {
    paramString = new StringBuilder(paramString);
    paramString.append(StringExtention.replaceWithEncodeURIValue("&name=$name$", "name", paramMailContact.getName()));
    paramString.append(StringExtention.replaceWithEncodeURIValue("&note=$note$", "note", paramMailContact.getMark()));
    Object localObject1 = paramMailContact.getEmails();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ContactEmail)((Iterator)localObject1).next();
        paramString.append(StringExtention.replaceWithEncodeURIValue("&email=$email$", "email", "邮箱:" + ((ContactEmail)localObject2).getEmail()));
      }
    }
    localObject1 = paramMailContact.getCustoms();
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ContactCustom)((Iterator)localObject1).next();
        int i = ((ContactCustom)localObject2).getType();
        if (i == 0) {
          paramString.append(StringExtention.replaceWithEncodeURIValue("&custom=$custom$", "custom", ((ContactCustom)localObject2).getKey() + ":" + ((ContactCustom)localObject2).getValue()));
        } else if (i == 2) {
          paramString.append(StringExtention.replaceWithEncodeURIValue("&adr=$adr$", "adr", ((ContactCustom)localObject2).getKey() + ":" + ((ContactCustom)localObject2).getValue()));
        } else if (i == 3) {
          paramString.append(StringExtention.replaceWithEncodeURIValue("&birthday=$birthday$", "birthday", ((ContactCustom)localObject2).getKey() + ":" + ((ContactCustom)localObject2).getValue()));
        } else if (i == 1) {
          paramString.append(StringExtention.replaceWithEncodeURIValue("&tel=$tel$", "tel", ((ContactCustom)localObject2).getKey() + ":" + ((ContactCustom)localObject2).getValue()));
        } else if (i == 5) {
          paramString.append(StringExtention.replaceWithEncodeURIValue("&IM=$IM$", "IM", ((ContactCustom)localObject2).getKey() + ":" + ((ContactCustom)localObject2).getValue()));
        }
      }
    }
    if (!paramBoolean) {
      paramString.append(StringExtention.replaceWithEncodeURIValue("&id=$id$", "id", paramMailContact.getCid()));
    }
    return paramString.toString();
  }
  
  private String appendCreateAndSyncVipParams(MailContact paramMailContact)
  {
    return String.format("&addr=\"%s\"<%s>", new Object[] { StringExtention.encodeURI(paramMailContact.getNick()), paramMailContact.getAddress() });
  }
  
  private String appendSyncVipParams(MailContact paramMailContact)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramMailContact.getCid())) {
      i = Integer.parseInt(paramMailContact.getCid());
    }
    return "&id=" + i;
  }
  
  private int getGGidByContactType(MailContact.ContactType paramContactType)
  {
    if (paramContactType == MailContact.ContactType.QQFriendContact) {}
    while (paramContactType != MailContact.ContactType.DomainContact) {
      return 1;
    }
    return 2;
  }
  
  private boolean isContainContact(ArrayList<MailContact> paramArrayList, MailContact paramMailContact)
  {
    if (paramMailContact != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MailContact localMailContact = (MailContact)paramArrayList.next();
        if ((localMailContact.getCid() != null) && (paramMailContact.getCid() != null) && (localMailContact.getAccountId() == paramMailContact.getAccountId()) && (localMailContact.getCid().equals(paramMailContact.getCid()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean isGroupContactsOutdated(int paramInt)
  {
    return QMSettingManager.sharedInstance().getLastUpdateGroupContactTime(paramInt) + 3600000L < System.currentTimeMillis();
  }
  
  private void parseContactInGroup(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailContact.ContactType paramContactType, JSONObject paramJSONObject)
  {
    int k = getGGidByContactType(paramContactType);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    if ((paramJSONObject.containsKey("match")) && (!paramJSONObject.getBoolean("match").booleanValue()))
    {
      if (paramJSONObject.containsKey("groups"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("groups");
        if (paramJSONObject.containsKey("group"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("group");
          int i = 0;
          while (i < paramJSONObject.size())
          {
            Object localObject2 = paramJSONObject.getJSONObject(i);
            ContactGroup localContactGroup = new ContactGroup();
            localContactGroup.parseWithDictionary((JSONObject)localObject2);
            localContactGroup.setId(ContactGroup.generateId(localContactGroup.getGid(), k, paramInt));
            localContactGroup.setGgid(k);
            localContactGroup.setAccountId(paramInt);
            ((ArrayList)localObject1).add(localContactGroup);
            localObject2 = ((JSONObject)localObject2).getJSONArray("item");
            int j = 0;
            while (j < ((JSONArray)localObject2).size())
            {
              JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
              MailContact localMailContact = new MailContact();
              localMailContact.parseWithDictionary(localJSONObject);
              localMailContact.setAccountId(paramInt);
              localMailContact.setType(paramContactType);
              localMailContact.setGroup(localContactGroup);
              localMailContact.setHashType(0);
              localMailContact.setHash(MailContact.generateHash(localMailContact));
              localMailContact.setOfflineType(0);
              localMailContact.setId(MailContact.generateId(localMailContact));
              localArrayList.add(localMailContact);
              j += 1;
            }
            i += 1;
          }
        }
      }
      QMLog.log(4, "QMContactCGIManager", "parseContacts type:" + paramContactType.ordinal() + " group size:" + ((ArrayList)localObject1).size() + " contact size:" + localArrayList.size());
      this.sqliteHelper.contact.deleteContactGroupByAccountAndGGID(paramSQLiteDatabase, paramInt, k);
      paramJSONObject = ((ArrayList)localObject1).iterator();
      while (paramJSONObject.hasNext())
      {
        localObject1 = (ContactGroup)paramJSONObject.next();
        this.sqliteHelper.contact.insertContactGroup(paramSQLiteDatabase, (ContactGroup)localObject1);
      }
      parseContactsWithOffline(paramSQLiteDatabase, paramInt, paramContactType, localArrayList);
    }
  }
  
  private void parseContactSyncKey(int paramInt, JSONObject paramJSONObject)
  {
    String str;
    if (paramJSONObject.containsKey("normalsynckey"))
    {
      str = paramJSONObject.getString("normalsynckey");
      QMSettingManager.sharedInstance().setContactSyncKey(paramInt, MailContact.ContactType.NormalContact, str);
    }
    if (paramJSONObject.containsKey("historysynckey"))
    {
      str = paramJSONObject.getString("historysynckey");
      QMSettingManager.sharedInstance().setContactSyncKey(paramInt, MailContact.ContactType.HistoryContact, str);
    }
    if (paramJSONObject.containsKey("qqsynckey"))
    {
      str = paramJSONObject.getString("qqsynckey");
      QMSettingManager.sharedInstance().setContactSyncKey(paramInt, MailContact.ContactType.QQFriendContact, str);
    }
    if (paramJSONObject.containsKey("domainsynckey"))
    {
      paramJSONObject = paramJSONObject.getString("domainsynckey");
      QMSettingManager.sharedInstance().setContactSyncKey(paramInt, MailContact.ContactType.DomainContact, paramJSONObject);
    }
  }
  
  private void parseContactSyncKey(int paramInt, MailContact.ContactType paramContactType, JSONObject paramJSONObject)
  {
    if (paramJSONObject.containsKey("synckey"))
    {
      paramJSONObject = paramJSONObject.getString("synckey");
      if (!StringUtils.isBlank(paramJSONObject))
      {
        QMLog.log(4, "QMContactCGIManager", "parseContactSyncKey contactType:" + paramContactType.ordinal() + " syncKey:" + paramJSONObject);
        QMSettingManager.sharedInstance().setContactSyncKey(paramInt, paramContactType, paramJSONObject);
      }
    }
  }
  
  private void parseContacts(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailContact.ContactType paramContactType, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONObject.containsKey("match")) && (!paramJSONObject.getBoolean("match").booleanValue()))
    {
      if (paramJSONObject.containsKey("items"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("items");
        if (paramJSONObject.containsKey("item"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("item");
          int i = 0;
          while (i < paramJSONObject.size())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            MailContact localMailContact = new MailContact();
            localMailContact.parseWithDictionary(localJSONObject);
            localMailContact.setAccountId(paramInt);
            localMailContact.setType(paramContactType);
            localMailContact.setGroup(null);
            localMailContact.setHashType(0);
            localMailContact.setHash(MailContact.generateHash(localMailContact));
            localMailContact.setOfflineType(0);
            localMailContact.setId(MailContact.generateId(localMailContact));
            localArrayList.add(localMailContact);
            i += 1;
          }
        }
      }
      QMLog.log(4, "QMContactCGIManager", "parseContacts type:" + paramContactType.ordinal() + " contact size:" + localArrayList.size());
      parseContactsWithOffline(paramSQLiteDatabase, paramInt, paramContactType, localArrayList);
    }
  }
  
  private void parseContactsWithOffline(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailContact.ContactType paramContactType, ArrayList<MailContact> paramArrayList)
  {
    Object localObject = this.sqliteHelper.contact.getOffLineOptByAccountIdAndContactType(paramSQLiteDatabase, paramInt, paramContactType);
    ArrayList localArrayList = new ArrayList();
    this.sqliteHelper.contact.deleteAccountContactByType(paramSQLiteDatabase, paramInt, paramContactType);
    paramContactType = paramArrayList.iterator();
    while (paramContactType.hasNext())
    {
      MailContact localMailContact = (MailContact)paramContactType.next();
      this.sqliteHelper.contact.insertContact(paramSQLiteDatabase, paramInt, localMailContact);
      localArrayList.add(Integer.valueOf(localMailContact.getHash()));
    }
    paramContactType = ((ArrayList)localObject).iterator();
    while (paramContactType.hasNext())
    {
      localObject = (MailContact)paramContactType.next();
      boolean bool = isContainContact(paramArrayList, (MailContact)localObject);
      if (((MailContact)localObject).getOfflineType() == 3)
      {
        if (bool) {
          this.sqliteHelper.contact.setOffLineOptType(paramSQLiteDatabase, ((MailContact)localObject).getId(), 3);
        }
      }
      else if (((MailContact)localObject).getOfflineType() == 1)
      {
        if (bool)
        {
          this.sqliteHelper.contact.updateContact(paramSQLiteDatabase, (MailContact)localObject);
          localArrayList.add(Integer.valueOf(((MailContact)localObject).getHash()));
        }
        else
        {
          this.sqliteHelper.contact.insertContact(paramSQLiteDatabase, ((MailContact)localObject).getAccountId(), (MailContact)localObject);
          localArrayList.add(Integer.valueOf(((MailContact)localObject).getHash()));
        }
      }
      else if ((((MailContact)localObject).getOfflineType() == 2) && (!bool))
      {
        this.sqliteHelper.contact.insertContact(paramSQLiteDatabase, paramInt, (MailContact)localObject);
        localArrayList.add(Integer.valueOf(((MailContact)localObject).getHash()));
      }
    }
    if (!localArrayList.isEmpty())
    {
      paramContactType = new int[localArrayList.size()];
      paramInt = 0;
      while (paramInt < localArrayList.size())
      {
        paramContactType[paramInt] = ((Integer)localArrayList.get(paramInt)).intValue();
        paramInt += 1;
      }
      this.sqliteHelper.contact.rebuildContactHash(paramSQLiteDatabase, paramContactType);
    }
  }
  
  private MailContact parsePartialContactInformation(JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.get("id").toString();
    String str2 = paramJSONObject.get("nick").toString();
    paramJSONObject = paramJSONObject.getJSONArray("email");
    ArrayList localArrayList = Lists.newArrayList();
    int i = 0;
    while (i < paramJSONObject.size())
    {
      localArrayList.add(new ContactEmail(paramJSONObject.getString(i), 0, 0));
      i += 1;
    }
    MailContact localMailContact = new MailContact();
    localMailContact.setCid(str1);
    localMailContact.setAccountId(paramInt);
    localMailContact.setAddress(paramJSONObject.getString(0));
    localMailContact.setPinyin("");
    localMailContact.setFullPinyin("");
    localMailContact.setName(str2);
    localMailContact.setNick(str2);
    localMailContact.setUin("");
    localMailContact.setType(MailContact.ContactType.NormalContact);
    localMailContact.setMark("");
    localMailContact.setIsVip(true);
    localMailContact.setIsHistory(false);
    localMailContact.setEmails(localArrayList);
    localMailContact.setCustoms(new ArrayList());
    localMailContact.setGroup(null);
    localMailContact.setHashType(0);
    localMailContact.setHash(MailContact.generateHash(localMailContact));
    localMailContact.setOfflineType(0);
    localMailContact.setId(MailContact.generateId(localMailContact));
    return localMailContact;
  }
  
  public void addAndSyncVip(int paramInt, MailContact paramMailContact)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ef=js&action=add&t=laddr_detail.json&error=app&f=xhtml");
    localStringBuffer.append(appendSyncVipParams(paramMailContact));
    HashMap localHashMap = new HashMap();
    localHashMap.put(Long.valueOf(paramMailContact.getId()), Boolean.valueOf(true));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMContactCGIManager.12(this, paramMailContact, localHashMap));
    localQMCallback.setOnError(new QMContactCGIManager.13(this, localHashMap));
    CGIManager.httpGet(paramInt, "vip_addr", localStringBuffer.toString(), localQMCallback);
  }
  
  public void addContact(int paramInt, MailContact paramMailContact)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(paramMailContact);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(Long.valueOf(paramMailContact.getId()));
    String str = appendAddEditContactParams(MailManagerDefines.PARAM_PREFIX_LADDR_ADDEDIT, paramMailContact, true);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMContactCGIManager.4(this, paramInt, paramMailContact, localArrayList2));
    localQMCallback.setOnError(new QMContactCGIManager.5(this, paramInt, localArrayList2, localArrayList1));
    CGIManager.httpGet(paramInt, "laddr_addedit", str, localQMCallback);
  }
  
  public void createContactAndSyncVip(int paramInt, MailContact paramMailContact)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ef=js&action=add&t=laddr_detail.json&error=app&f=xhtml");
    localStringBuffer.append(appendCreateAndSyncVipParams(paramMailContact));
    HashMap localHashMap = new HashMap();
    localHashMap.put(Long.valueOf(paramMailContact.getId()), Boolean.valueOf(true));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMContactCGIManager.10(this, paramMailContact, paramInt, localHashMap));
    localQMCallback.setOnError(new QMContactCGIManager.11(this, localHashMap));
    CGIManager.httpGet(paramInt, "vip_addr", localStringBuffer.toString(), localQMCallback);
  }
  
  public void deleteContact(int paramInt, ArrayList<Long> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_LADDR_DEL);
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext()) {
      localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&AddrID=$AddrID$", "AddrID", String.valueOf((Integer)paramArrayList1.next())));
    }
    paramArrayList1 = new QMCallback();
    paramArrayList1.setOnSuccess(new QMContactCGIManager.8(this, paramInt, paramArrayList));
    paramArrayList1.setOnError(new QMContactCGIManager.9(this, paramInt, paramArrayList));
    CGIManager.httpGet(paramInt, "laddr_del", localStringBuilder.toString(), paramArrayList1);
  }
  
  public void editContact(MailContact paramMailContact)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMailContact);
    String str = appendAddEditContactParams(MailManagerDefines.PARAM_PREFIX_LADDR_ADDEDIT, paramMailContact, false);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMContactCGIManager.6(this, paramMailContact, localArrayList));
    localQMCallback.setOnError(new QMContactCGIManager.7(this, paramMailContact, localArrayList));
    CGIManager.httpGet(paramMailContact.getAccountId(), "laddr_addedit", str, localQMCallback);
  }
  
  public void loadContacts(int paramInt, MailContact.ContactType[] paramArrayOfContactType)
  {
    String str = "load_contact" + paramInt;
    if (RequestFilter.isRequestOnRunning(str)) {
      return;
    }
    RequestFilter.setRequestRunningState(str);
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_LADDR_LIST);
    int j = paramArrayOfContactType.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfContactType[i];
      if (localObject == MailContact.ContactType.NormalContact)
      {
        localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&datatype=$datatype$", "datatype", "normal"));
        localObject = QMSettingManager.sharedInstance().getContactSyncKey(paramInt, (MailContact.ContactType)localObject);
        if (!((String)localObject).isEmpty()) {
          localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&normalsynckey=$normalsynckey$", "normalsynckey", (String)localObject));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localObject == MailContact.ContactType.HistoryContact)
        {
          localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&datatype=$datatype$", "datatype", "history"));
          localObject = QMSettingManager.sharedInstance().getContactSyncKey(paramInt, (MailContact.ContactType)localObject);
          if (!((String)localObject).isEmpty()) {
            localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&historysynckey=$historysynckey$", "historysynckey", (String)localObject));
          }
        }
        else if (localObject == MailContact.ContactType.QQFriendContact)
        {
          localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&datatype=$datatype$", "datatype", "qq"));
          localObject = QMSettingManager.sharedInstance().getContactSyncKey(paramInt, (MailContact.ContactType)localObject);
          if (!((String)localObject).isEmpty()) {
            localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&qqsynckey=$qqsynckey$", "qqsynckey", (String)localObject));
          }
        }
        else if (localObject == MailContact.ContactType.DomainContact)
        {
          localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&datatype=$datatype$", "datatype", "domain"));
          localObject = QMSettingManager.sharedInstance().getContactSyncKey(paramInt, (MailContact.ContactType)localObject);
          if (!((String)localObject).isEmpty()) {
            localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&domainsynckey=$domainsynckey$", "domainsynckey", (String)localObject));
          }
        }
      }
    }
    QMLog.log(3, "QMContactCGIManager", "loadContacts accountId:" + paramInt + " params" + localStringBuilder.toString());
    paramArrayOfContactType = new QMCallback();
    paramArrayOfContactType.setOnSuccess(new QMContactCGIManager.1(this, str, paramInt));
    paramArrayOfContactType.setOnError(new QMContactCGIManager.2(this, str, paramInt));
    paramArrayOfContactType.setOnComplete(new QMContactCGIManager.3(this, str));
    CGIManager.httpGet(paramInt, "laddr_list", localStringBuilder.toString(), paramArrayOfContactType);
  }
  
  public void loadGroupContacts(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (!isGroupContactsOutdated(paramInt))
    {
      localObject = this.sqliteHelper.contact.getGroupContacts(localSQLiteDatabase, paramInt);
      if ((localObject != null) && (((MailGroupContactList)localObject).getGroupContacts() != null))
      {
        QMWatcherCenter.triggerLoadGroupContactListSuccess(paramInt, (MailGroupContactList)localObject);
        return;
      }
    }
    Object localObject = new QMCallback();
    ((QMCallback)localObject).setOnSuccess(new QMContactCGIManager.18(this, localSQLiteDatabase, paramInt));
    ((QMCallback)localObject).setOnError(new QMContactCGIManager.19(this, paramInt));
    CGIManager.httpGet(paramInt, "grouplist", "&t=grouplist_json", (QMCallback)localObject);
  }
  
  public void loadVipContacts(int paramInt)
  {
    String str = "load_vip__" + paramInt;
    if (RequestFilter.isRequestOnRunning(str)) {
      return;
    }
    RequestFilter.setRequestRunningState(str);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMContactCGIManager.16(this, str, paramInt));
    localQMCallback.setOnError(new QMContactCGIManager.17(this, str, paramInt));
    CGIManager.httpGet(paramInt, "vip_addr", "ef=js&action=list&t=vip_addr.json&error=app&f=xhtml", localQMCallback);
  }
  
  public void removeAndSyncVip(int paramInt, MailContact paramMailContact)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ef=js&action=del&t=laddr_detail.json&error=app&f=xhtml");
    localStringBuffer.append(appendSyncVipParams(paramMailContact));
    HashMap localHashMap = new HashMap();
    localHashMap.put(Long.valueOf(paramMailContact.getId()), Boolean.valueOf(false));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMContactCGIManager.14(this, paramMailContact, localHashMap));
    localQMCallback.setOnError(new QMContactCGIManager.15(this, localHashMap));
    CGIManager.httpGet(paramInt, "vip_addr", localStringBuffer.toString(), localQMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager
 * JD-Core Version:    0.7.0.1
 */