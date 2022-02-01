package com.tencent.qqmail.model.contact;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactBlackWhiteListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactComposeListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactGroupListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactHistoryCursor;
import com.tencent.qqmail.model.contact.cursor.ContactListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactMobileCursor;
import com.tencent.qqmail.model.contact.cursor.ContactSearchCursor;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.SearchExchangeAddressWatcher;
import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.NickNameCache;
import com.tencent.qqmail.model.qmdomain.NickNameCache.NickNameData;
import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import com.tencent.qqmail.protocol.ASContact;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Maps;
import com.tencent.qqmail.trd.guava.Splitter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class QMContactManager
{
  private static final long LOAD_CONTACT_INTERVAL = 180000L;
  private static final long MOBILE_CONTACT_IMPORT_INTERVAL = 600000L;
  private static final long SEARCH_CONTACT_CACHE_INTERVAL = 86400000L;
  private static final String TAG = "QMContactManager";
  private static QMContactManager _instance;
  private static Future<Void> _instanceWithCached;
  private static HashMap<Long, ArrayList<String>> contactEmailCountCache = ;
  private static HashMap<Long, ArrayList<String>> contactTelCache = Maps.newHashMap();
  private static int sAllContactsSize = 0;
  private static List<MailContact> sCachedContacts = Lists.newArrayList();
  private static NickNameCache sNickNameCache = new NickNameCache();
  private QMContactCGIManager cgiManager;
  private QMContactProtocolManager protocolManager;
  private QMMailSQLiteHelper sqliteHelper;
  
  private QMContactManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.cgiManager = new QMContactCGIManager(paramQMMailSQLiteHelper);
    this.protocolManager = new QMContactProtocolManager(paramQMMailSQLiteHelper);
    _instanceWithCached = Threads.submitTask(new QMContactManager.1(this));
  }
  
  private void createAndSyncVip(MailContact paramMailContact1, MailContact paramMailContact2)
  {
    Object localObject1;
    if ((paramMailContact1 != null) && (paramMailContact1.getType() == MailContact.ContactType.HistoryContact))
    {
      localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramMailContact1.getAccountId());
      if ((localObject1 == null) || (!((Account)localObject1).isQQMail())) {
        break label210;
      }
      deleteContact(paramMailContact1);
    }
    for (;;)
    {
      if (paramMailContact1.getType() == MailContact.ContactType.QQFriendContact)
      {
        String str = paramMailContact1.getName();
        if (!StringUtils.isEmpty(str))
        {
          Object localObject2 = paramMailContact2.getCustoms();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Lists.newArrayList();
          }
          localObject2 = new ContactCustom();
          ((ContactCustom)localObject2).setKey(QMApplicationContext.sharedInstance().getString(2131692069));
          ((ContactCustom)localObject2).setValue(str);
          ((ContactCustom)localObject2).setType(0);
          ((ArrayList)localObject1).add(localObject2);
          paramMailContact2.setCustoms((ArrayList)localObject1);
        }
      }
      localObject1 = this.sqliteHelper.getWritableDatabase();
      getNeedSyncContactByHash((SQLiteDatabase)localObject1, paramMailContact2, new QMContactManager.6(this, paramMailContact2));
      if ((paramMailContact1 != null) && (paramMailContact1.getHash() != 0)) {
        this.sqliteHelper.contact.rebuildContactHash((SQLiteDatabase)localObject1, new int[] { paramMailContact1.getHash() });
      }
      updateNickNameByContact(paramMailContact2.getAccountId(), paramMailContact2);
      clearContactEmailCountCache();
      clearContactTelCache();
      clearComposeContactCache();
      return;
      label210:
      deleteContactLocal(paramMailContact1);
    }
  }
  
  private String getCheckedAccountIdsSqlArg()
  {
    ArrayList localArrayList = getCheckedAccountIds();
    if (localArrayList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < localArrayList.size())
    {
      localStringBuilder.append(localArrayList.get(i)).append(",");
      i += 1;
    }
    if (localArrayList.size() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  private void getNeedSyncContactByHash(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, ContactConvWatcher paramContactConvWatcher)
  {
    Object localObject = new ArrayList();
    int i = paramMailContact.getHash();
    int j = paramMailContact.getHashType();
    if (j == 1) {
      ((ArrayList)localObject).addAll(this.sqliteHelper.contact.getOnlyChildContactByHash(paramSQLiteDatabase, new int[] { i }));
    }
    for (;;)
    {
      paramMailContact = ((ArrayList)localObject).iterator();
      while (paramMailContact.hasNext())
      {
        localObject = (MailContact)paramMailContact.next();
        boolean bool = isStranger(paramSQLiteDatabase, (MailContact)localObject);
        if (paramContactConvWatcher != null)
        {
          paramContactConvWatcher.onLocalSync(paramSQLiteDatabase, (MailContact)localObject, bool);
          paramContactConvWatcher.onRemoteSync(paramSQLiteDatabase, (MailContact)localObject, bool);
        }
      }
      if ((j == 0) || (j == -1)) {
        ((ArrayList)localObject).add(paramMailContact);
      }
    }
  }
  
  private ArrayList<MailContact> getOffLineOpt()
  {
    return this.sqliteHelper.contact.getOffLineOpt(this.sqliteHelper.getReadableDatabase());
  }
  
  private List<ASContact> getSearchGlobalAddressListCache(int paramInt, String paramString)
  {
    Object localObject1 = QMSettingManager.sharedInstance().getSearchExchangeAddress(paramInt, paramString);
    if (!StringUtils.isEmpty((CharSequence)localObject1))
    {
      ArrayList localArrayList = Lists.newArrayList();
      localObject1 = Lists.newArrayList(Splitter.on(",").omitEmptyStrings().split((String)localObject1));
      if (((List)localObject1).size() <= 1)
      {
        deleteSearchGlobalAddressListCache(paramInt, paramString);
        return null;
      }
      Object localObject2 = ((String)((List)localObject1).get(0)).split(":");
      if ((localObject2.length == 2) && (localObject2[0].contains("expire"))) {}
      for (;;)
      {
        try
        {
          if (Long.parseLong(localObject2[1]) + 86400000L < System.currentTimeMillis())
          {
            deleteSearchGlobalAddressListCache(paramInt, paramString);
            return null;
          }
          paramString = ((List)localObject1).subList(1, ((List)localObject1).size());
          paramString = paramString.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          localObject1 = (String)paramString.next();
          localObject1 = Lists.newArrayList(Splitter.on(":").split((String)localObject1));
          if ((localObject1 != null) && (((List)localObject1).size() == 2))
          {
            localObject2 = new ASContact();
            ((ASContact)localObject2).display_name_ = ((String)((List)localObject1).get(0));
            ((ASContact)localObject2).email_address_ = ((String)((List)localObject1).get(1));
            localArrayList.add(localObject2);
            continue;
            paramString = (String)localObject1;
          }
        }
        catch (Exception paramString)
        {
          QMLog.log(6, "QMContactManager", Log.getStackTraceString(paramString));
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private boolean isStranger(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMailContact != null)
    {
      paramSQLiteDatabase = this.sqliteHelper.contact.getContactById(paramSQLiteDatabase, paramMailContact.getId());
      if (paramSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (paramSQLiteDatabase.getType() != MailContact.ContactType.NormalContact)
        {
          bool1 = bool2;
          if (paramSQLiteDatabase.getType() == MailContact.ContactType.ProtocolContact) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private MailContact mergeParentContactToChildContact(MailContact paramMailContact1, MailContact paramMailContact2)
  {
    paramMailContact1 = paramMailContact1.clone();
    paramMailContact1.setId(paramMailContact2.getId());
    paramMailContact1.setCid(paramMailContact2.getCid());
    paramMailContact1.setAccountId(paramMailContact2.getAccountId());
    paramMailContact1.setType(paramMailContact2.getType());
    paramMailContact1.setHashType(paramMailContact2.getHashType());
    paramMailContact1.setOfflineType(paramMailContact2.getOfflineType());
    return paramMailContact1;
  }
  
  private void reSendOffLineOpt()
  {
    Iterator localIterator = getOffLineOpt().iterator();
    while (localIterator.hasNext())
    {
      MailContact localMailContact = (MailContact)localIterator.next();
      if (localMailContact.getOfflineType() == 3) {
        deleteContact(localMailContact);
      } else if ((localMailContact.getOfflineType() == 2) || (localMailContact.getOfflineType() == 1)) {
        syncContact(localMailContact, localMailContact);
      }
    }
  }
  
  private void setAndSyncVip(MailContact paramMailContact, boolean paramBoolean)
  {
    getNeedSyncContactByHash(this.sqliteHelper.getWritableDatabase(), paramMailContact, new QMContactManager.7(this, paramBoolean));
  }
  
  private void setOffLineType(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    try
    {
      this.sqliteHelper.contact.setOffLineOptType(paramSQLiteDatabase, paramLong, paramInt);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMContactManager", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  /* Error */
  @androidx.annotation.NonNull
  public static QMContactManager sharedInstance()
  {
    // Byte code:
    //   0: getstatic 493	com/tencent/qqmail/model/contact/QMContactManager:_instance	Lcom/tencent/qqmail/model/contact/QMContactManager;
    //   3: ifnonnull +31 -> 34
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 493	com/tencent/qqmail/model/contact/QMContactManager:_instance	Lcom/tencent/qqmail/model/contact/QMContactManager;
    //   12: ifnonnull +19 -> 31
    //   15: new 2	com/tencent/qqmail/model/contact/QMContactManager
    //   18: dup
    //   19: invokestatic 498	com/tencent/qqmail/model/mail/QMMailManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   22: invokevirtual 502	com/tencent/qqmail/model/mail/QMMailManager:getSqliteHelper	()Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   25: invokespecial 503	com/tencent/qqmail/model/contact/QMContactManager:<init>	(Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;)V
    //   28: putstatic 493	com/tencent/qqmail/model/contact/QMContactManager:_instance	Lcom/tencent/qqmail/model/contact/QMContactManager;
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 101	com/tencent/qqmail/model/contact/QMContactManager:_instanceWithCached	Ljava/util/concurrent/Future;
    //   37: invokeinterface 507 1 0
    //   42: pop
    //   43: getstatic 493	com/tencent/qqmail/model/contact/QMContactManager:_instance	Lcom/tencent/qqmail/model/contact/QMContactManager;
    //   46: areturn
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: astore_0
    //   54: bipush 6
    //   56: ldc 21
    //   58: aload_0
    //   59: invokestatic 425	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   62: invokestatic 431	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   65: goto -22 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject	Object
    //   53	6	0	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	31	47	finally
    //   31	34	47	finally
    //   48	51	47	finally
    //   34	43	53	java/lang/Exception
  }
  
  public void addCheckedAccountId(int paramInt)
  {
    ArrayList localArrayList = getCheckedAccountIds();
    if (!localArrayList.contains(Integer.valueOf(paramInt))) {
      localArrayList.add(Integer.valueOf(paramInt));
    }
    saveCheckedAccountIds(localArrayList);
  }
  
  public final void bindSearchExchangeAddressListener(SearchExchangeAddressWatcher paramSearchExchangeAddressWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramSearchExchangeAddressWatcher, paramBoolean);
  }
  
  public MailContact checkContacts(MailContact paramMailContact)
  {
    paramMailContact = paramMailContact.clone();
    Object localObject1 = AccountManager.shareInstance().getAccountList();
    if (isStranger(paramMailContact)) {
      paramMailContact.setCid(String.valueOf((int)(System.currentTimeMillis() / 1000L)));
    }
    if (TextUtils.isEmpty(paramMailContact.getCid())) {
      paramMailContact.setCid("0");
    }
    int j = paramMailContact.getAccountId();
    ArrayList localArrayList;
    Object localObject2;
    Object localObject3;
    if (j == 0)
    {
      localArrayList = sharedInstance().getCheckedAccountIds();
      localObject2 = ((AccountList)localObject1).getDefaultMailAccount();
      if (localObject2 == null) {
        break label443;
      }
      localObject3 = localArrayList.iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      } while (((Integer)((Iterator)localObject3).next()).intValue() != ((Account)localObject2).getId());
    }
    label294:
    label427:
    label440:
    label441:
    label443:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramMailContact.setAccountId(((Account)localObject2).getId());
      }
      for (;;)
      {
        if (paramMailContact.getAddress() == null) {
          paramMailContact.setAddress("");
        }
        if (paramMailContact.getName() == null) {
          paramMailContact.setName("");
        }
        if (paramMailContact.getNick() == null) {
          paramMailContact.setNick(paramMailContact.getName());
        }
        if (paramMailContact.getPinyin() == null) {
          paramMailContact.setPinyin("");
        }
        if (paramMailContact.getFullPinyin() == null) {
          paramMailContact.setFullPinyin("");
        }
        localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramMailContact.getAccountId());
        if ((localObject1 != null) && (((Account)localObject1).isQQMail()))
        {
          paramMailContact.setType(MailContact.ContactType.NormalContact);
          label241:
          paramMailContact.setGroup(null);
          paramMailContact.setHash(MailContact.generateHash(paramMailContact));
          paramMailContact.setOfflineType(0);
          if (paramMailContact.getHashType() != 1) {
            break label427;
          }
          paramMailContact.setId(MailContact.generateParentId(paramMailContact));
          return paramMailContact;
          if (localArrayList.size() == 0) {
            continue;
          }
          localObject2 = ((AccountList)localObject1).iterator();
          i = j;
          if (!((Iterator)localObject2).hasNext()) {
            break label440;
          }
          localObject3 = (Account)((Iterator)localObject2).next();
          Iterator localIterator = localArrayList.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              Integer localInteger = (Integer)localIterator.next();
              if (localInteger.intValue() == ((Account)localObject3).getId())
              {
                i = localInteger.intValue();
                label364:
                if (i != 0) {
                  paramMailContact.setAccountId(i);
                }
              }
            }
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label441;
          }
          if (((AccountList)localObject1).size() > 0)
          {
            paramMailContact.setAccountId(((AccountList)localObject1).get(0).getId());
            break;
            break label294;
          }
          QMLog.log(6, "QMContactManager", "account size == 0");
          break;
          paramMailContact.setType(MailContact.ContactType.ProtocolContact);
          break label241;
          paramMailContact.setId(MailContact.generateId(paramMailContact));
          return paramMailContact;
          break label364;
        }
      }
    }
  }
  
  public void clearComposeContactCache()
  {
    if (sCachedContacts != null) {
      sCachedContacts.clear();
    }
    sAllContactsSize = 0;
  }
  
  public void clearContactEmailCountCache()
  {
    contactEmailCountCache.clear();
  }
  
  public void clearContactTelCache()
  {
    contactTelCache.clear();
  }
  
  public void clearNickNameCache()
  {
    sNickNameCache.clearCache();
  }
  
  public void deleteAccountContact(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.sqliteHelper.contact.deleteAccountContact(paramSQLiteDatabase, paramInt);
    int[] arrayOfInt = this.sqliteHelper.contact.getOnlyChildContactHashes(paramSQLiteDatabase);
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
      this.sqliteHelper.contact.rebuildContactHash(paramSQLiteDatabase, arrayOfInt);
    }
  }
  
  public void deleteCheckedAccountId(int paramInt)
  {
    ArrayList localArrayList = getCheckedAccountIds();
    localArrayList.remove(Integer.valueOf(paramInt));
    saveCheckedAccountIds(localArrayList);
  }
  
  public void deleteContact(MailContact paramMailContact)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramMailContact.getId()));
    getNeedSyncContactByHash(this.sqliteHelper.getWritableDatabase(), paramMailContact, new QMContactManager.5(this));
    QMWatcherCenter.triggerDeleteContactListSuccess(paramMailContact.getAccountId(), localArrayList);
  }
  
  public void deleteContactLocal(MailContact paramMailContact)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramMailContact.getId()));
    this.sqliteHelper.contact.deleteContact(localSQLiteDatabase, paramMailContact.getId());
    this.sqliteHelper.contact.rebuildContactHash(localSQLiteDatabase, new int[] { paramMailContact.getHash() });
    QMWatcherCenter.triggerDeleteContactListSuccess(paramMailContact.getAccountId(), localArrayList);
  }
  
  public void deleteSearchGlobalAddressListCache(int paramInt, String paramString)
  {
    QMSettingManager.sharedInstance().removeSearchExchangeAddress(paramInt, paramString);
  }
  
  public List<NickNameCache.NickNameData> fetchAllNickNameData()
  {
    return this.sqliteHelper.contact.fetchAllNickNameData(this.sqliteHelper.getReadableDatabase());
  }
  
  public List<MailContact> fetchLocalCachingShowingContacts()
  {
    int j = 0;
    int k = this.sqliteHelper.contact.getAllContactSize(this.sqliteHelper.getReadableDatabase());
    if (k == sAllContactsSize) {
      return sCachedContacts;
    }
    ArrayList localArrayList1 = Lists.newArrayList();
    ArrayList localArrayList2 = Lists.newArrayList();
    try
    {
      ContactBaseListCursor localContactBaseListCursor = getComposeContactCursor();
      localContactBaseListCursor.refresh(false, null);
      int m = localContactBaseListCursor.getCount();
      int i;
      if (m > 0)
      {
        i = 0;
        while (i < m)
        {
          localArrayList1.add(localContactBaseListCursor.getItem(i));
          i += 1;
        }
      }
      localContactBaseListCursor.close();
      localContactBaseListCursor = getMobileContactCursor();
      localContactBaseListCursor.refresh(false, null);
      m = localContactBaseListCursor.getCount();
      if (m > 0)
      {
        i = j;
        while (i < m)
        {
          localArrayList2.add(localContactBaseListCursor.getItem(i));
          i += 1;
        }
      }
      localContactBaseListCursor.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMContactManager", Log.getStackTraceString(localException));
      }
    }
    sCachedContacts = Lists.newArrayList();
    sCachedContacts.addAll(localArrayList1);
    sCachedContacts.addAll(localArrayList2);
    sAllContactsSize = k;
    return localArrayList1;
  }
  
  public List<NickNameCache.NickNameData> fetchNickNameData(int paramInt, String paramString)
  {
    return this.sqliteHelper.contact.fetchNickNameData(this.sqliteHelper.getReadableDatabase(), paramInt, paramString);
  }
  
  public int[] getCheckedAccountArray()
  {
    ArrayList localArrayList = getCheckedAccountIds();
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public ArrayList<Integer> getCheckedAccountIds()
  {
    Object localObject2 = QMSettingManager.sharedInstance().getContactGroupCheckedAccountIds();
    Object localObject1 = new LinkedHashSet();
    localObject2 = ((String)localObject2).split(";");
    int i = 0;
    while (i < localObject2.length)
    {
      if (!localObject2[i].equals("")) {
        ((LinkedHashSet)localObject1).add(Integer.valueOf(Integer.parseInt(localObject2[i])));
      }
      i += 1;
    }
    localObject2 = AccountManager.shareInstance().getAccountList();
    ArrayList localArrayList = Lists.newArrayList();
    localObject1 = ((LinkedHashSet)localObject1).iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Account localAccount = ((AccountList)localObject2).getAccountById(((Integer)((Iterator)localObject1).next()).intValue());
      if (localAccount != null) {
        localArrayList.add(Integer.valueOf(localAccount.getId()));
      }
      for (;;)
      {
        break;
        i = 1;
      }
    }
    int j = i;
    if (localArrayList.size() == 0)
    {
      j = i;
      if (((AccountList)localObject2).size() == 1)
      {
        localArrayList.add(Integer.valueOf(((AccountList)localObject2).get(0).getId()));
        j = 1;
      }
    }
    if (j != 0) {
      saveCheckedAccountIds(localArrayList);
    }
    return localArrayList;
  }
  
  public ContactBaseListCursor getComposeContactCursor()
  {
    return new ContactComposeListCursor(this.sqliteHelper, getCheckedAccountArray());
  }
  
  public MailContact getContactByAccountAndEmail(int paramInt, String paramString)
  {
    Object localObject = null;
    ArrayList localArrayList = this.sqliteHelper.contact.getMailContactsByAccountAndEmail(this.sqliteHelper.getReadableDatabase(), paramInt, paramString);
    paramString = localObject;
    if (localArrayList != null)
    {
      paramString = localObject;
      if (localArrayList.size() > 0) {
        paramString = (MailContact)localArrayList.get(0);
      }
    }
    return paramString;
  }
  
  public MailContact getContactByAccountAndEmailAndName(int paramInt, String paramString1, String paramString2)
  {
    paramString2 = this.sqliteHelper.contact.getMailContactsByAccountAndEmailAndName(this.sqliteHelper.getReadableDatabase(), paramInt, paramString1, paramString2);
    if ((paramString2 != null) && (paramString2.size() > 0)) {
      return (MailContact)paramString2.get(0);
    }
    return getContactByAccountAndEmail(paramInt, paramString1);
  }
  
  public ArrayList<MailContact> getContactByAccountsAndTypes(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.sqliteHelper.contact.getContactByAccountsAndType(this.sqliteHelper.getReadableDatabase(), paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public MailContact getContactByEmailAndName(String paramString1, String paramString2)
  {
    Object localObject = null;
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      MailContact localMailContact = getContactByAccountAndEmailAndName(((Account)localIterator.next()).getId(), paramString1, paramString2);
      localObject = localMailContact;
      if (localMailContact != null) {
        localObject = localMailContact;
      }
    }
    return localObject;
  }
  
  public MailContact getContactById(long paramLong)
  {
    return this.sqliteHelper.contact.getContactById(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public ArrayList<String> getContactEmailCache(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (contactEmailCountCache.size() == 0) {
      contactEmailCountCache = this.sqliteHelper.contact.queryContactEmailCountMap(this.sqliteHelper.getReadableDatabase());
    }
    if (contactEmailCountCache.containsKey(Long.valueOf(paramLong))) {
      localArrayList = (ArrayList)contactEmailCountCache.get(Long.valueOf(paramLong));
    }
    return localArrayList;
  }
  
  public ArrayList<String> getContactEmailsByAccountAndDomain(int paramInt, String paramString)
  {
    return this.sqliteHelper.contact.queryContactEmailByAccountAndDomain(this.sqliteHelper.getReadableDatabase(), paramInt, paramString);
  }
  
  public ArrayList<ContactGroup> getContactGroupByAccountAndGGID(int paramInt1, int paramInt2)
  {
    return this.sqliteHelper.contact.getContactGroupByAccountAndGGID(this.sqliteHelper.getReadableDatabase(), paramInt1, paramInt2);
  }
  
  public ContactGroup getContactGroupById(int paramInt)
  {
    return this.sqliteHelper.contact.getContactGroupById(this.sqliteHelper.getReadableDatabase(), paramInt);
  }
  
  public ContactBaseListCursor getContactListCursor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((paramInt1 == 0) || (paramInt1 == 4)) {
      return getNormalContactCursor();
    }
    if (paramInt1 == 1) {
      return getMobileContactCursor();
    }
    if (paramInt1 == 2) {
      return new ContactHistoryCursor(this.sqliteHelper, new int[] { paramInt2 });
    }
    if (paramInt1 == 3) {
      return new ContactGroupListCursor(this.sqliteHelper, paramInt2, paramInt3);
    }
    if (paramInt1 == 5)
    {
      String str = AccountManager.shareInstance().getAccountList().getAccountById(paramInt2).getEmail();
      return new ContactBlackWhiteListCursor(this.sqliteHelper, new int[] { paramInt2 }, paramInt4, str, paramBoolean);
    }
    return null;
  }
  
  public ArrayList<String> getContactTelCache(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (contactTelCache.size() == 0) {
      contactTelCache = this.sqliteHelper.contact.queryContactTelMap(this.sqliteHelper.getReadableDatabase());
    }
    if (contactTelCache.containsKey(Long.valueOf(paramLong))) {
      localArrayList = (ArrayList)contactTelCache.get(Long.valueOf(paramLong));
    }
    return localArrayList;
  }
  
  public Set<Long> getEmailContactIdsMap(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.contact.selectContactIdInMergeByEmail(localSQLiteDatabase, paramString, getCheckedAccountIdsSqlArg());
  }
  
  public Set<String> getEmailsNeededByMerge()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.contact.fetchEmailsNeededByMerge(localSQLiteDatabase, getCheckedAccountIdsSqlArg());
  }
  
  public MailGroupContactList getGroupContacts(int paramInt)
  {
    return this.sqliteHelper.contact.getGroupContacts(this.sqliteHelper.getWritableDatabase(), paramInt);
  }
  
  public ContactBaseListCursor getMobileContactCursor()
  {
    return new ContactMobileCursor(this.sqliteHelper);
  }
  
  public ContactBaseListCursor getNormalContactCursor()
  {
    return new ContactListCursor(this.sqliteHelper, sharedInstance().getCheckedAccountArray());
  }
  
  public String getPossibleNickname(int paramInt, String paramString1, String paramString2, Mail paramMail)
  {
    if (StringUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if ((paramMail != null) && (paramMail.getStatus() != null)) {
      if (paramMail.getInformation() != null)
      {
        str = paramString2;
        if (!StringUtils.isEmpty(paramMail.getInformation().getGroupId())) {}
      }
      else
      {
        str = paramString2;
        if (!paramMail.getStatus().isGroupMail()) {
          if (!paramMail.getStatus().isNotAdByUser())
          {
            str = paramString2;
            if (paramMail.getStatus().isAdMail()) {}
          }
          else
          {
            str = paramString2;
            if (!paramMail.getStatus().isAdByUser())
            {
              str = paramString2;
              if (!paramMail.getStatus().isBookMail()) {
                if (!paramMail.getStatus().isSubscribeMail()) {
                  break label150;
                }
              }
            }
          }
        }
      }
    }
    label150:
    for (String str = paramString2;; str = sNickNameCache.getPossibleNickNameWithSendNick(paramInt, paramString1, paramString2))
    {
      paramString2 = str;
      if (!StringUtils.isEmpty(str)) {
        break;
      }
      return paramString1.replaceAll("@.*$", "");
    }
  }
  
  public List<MailContact> getSameEmailContactList()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.contact.fetchSameEmailContact(localSQLiteDatabase, getCheckedAccountIdsSqlArg());
  }
  
  public MailContact getSameEmailContactWhenSync(MailContact paramMailContact, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMailContact != null)
    {
      paramMailContact = paramMailContact.getEmails();
      localObject1 = localObject2;
      if (paramMailContact != null)
      {
        localObject1 = localObject2;
        if (!paramMailContact.isEmpty())
        {
          localObject1 = new ArrayList();
          int i = 0;
          while (i < paramMailContact.size())
          {
            ((ArrayList)localObject1).add(((ContactEmail)paramMailContact.get(i)).getEmail());
            i += 1;
          }
          localObject1 = this.sqliteHelper.contact.getSameEmailContactWhenSync(this.sqliteHelper.getReadableDatabase(), paramLong, (ArrayList)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public List<MailContact> getSameNameContactList()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.contact.fetchSameNameContact(localSQLiteDatabase, getCheckedAccountIdsSqlArg());
  }
  
  public ContactBaseListCursor getSearchComposeContactCursor(String paramString)
  {
    return new ContactSearchCursor(this.sqliteHelper, getCheckedAccountArray(), paramString);
  }
  
  public ContactBaseListCursor getSearchContactListCursor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if ((paramInt1 == 0) || (paramInt1 == 4)) {
      return new ContactSearchCursor(this.sqliteHelper, getCheckedAccountArray(), new int[] { MailContact.ContactType.NormalContact.ordinal(), MailContact.ContactType.ProtocolContact.ordinal(), MailContact.ContactType.PhoneContact.ordinal(), MailContact.ContactType.HistoryContact.ordinal(), MailContact.ContactType.QQFriendContact.ordinal(), MailContact.ContactType.DomainContact.ordinal() }, true, paramString);
    }
    QMMailSQLiteHelper localQMMailSQLiteHelper;
    if (paramInt1 == 1)
    {
      localQMMailSQLiteHelper = this.sqliteHelper;
      paramInt1 = MailContact.ContactType.PhoneContact.ordinal();
      return new ContactSearchCursor(localQMMailSQLiteHelper, new int[] { 0 }, new int[] { paramInt1 }, paramString);
    }
    if (paramInt1 == 2)
    {
      localQMMailSQLiteHelper = this.sqliteHelper;
      paramInt1 = MailContact.ContactType.HistoryContact.ordinal();
      return new ContactSearchCursor(localQMMailSQLiteHelper, new int[] { paramInt2 }, new int[] { paramInt1 }, paramString);
    }
    if (paramInt1 == 3) {
      return new ContactSearchCursor(this.sqliteHelper, new int[] { paramInt2 }, paramInt3, paramString);
    }
    if (paramInt1 == 5)
    {
      localQMMailSQLiteHelper = this.sqliteHelper;
      paramInt1 = MailContact.ContactType.NormalContact.ordinal();
      paramInt3 = MailContact.ContactType.ProtocolContact.ordinal();
      int i = MailContact.ContactType.PhoneContact.ordinal();
      int j = MailContact.ContactType.HistoryContact.ordinal();
      int k = MailContact.ContactType.QQFriendContact.ordinal();
      int m = MailContact.ContactType.DomainContact.ordinal();
      return new ContactSearchCursor(localQMMailSQLiteHelper, new int[] { paramInt2 }, new int[] { paramInt1, paramInt3, i, j, k, m }, paramInt4, paramString);
    }
    return null;
  }
  
  public ArrayList<MailContact> getVipLists()
  {
    return this.sqliteHelper.contact.getAllVipContacts(this.sqliteHelper.getWritableDatabase());
  }
  
  public boolean isStranger(MailContact paramMailContact)
  {
    return isStranger(this.sqliteHelper.getReadableDatabase(), paramMailContact);
  }
  
  public boolean isVipAddress(String paramString)
  {
    return this.sqliteHelper.contact.isVipAddress(this.sqliteHelper.getReadableDatabase(), paramString);
  }
  
  public boolean isVipAddressForAccount(int paramInt, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = StringUtils.trim(paramString).toLowerCase();
    } while (StringUtils.isEmpty(paramString));
    return this.sqliteHelper.contact.isVipAddressForAccount(this.sqliteHelper.getReadableDatabase(), paramInt, paramString);
  }
  
  public void loadAccountContacts(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = QMSettingManager.sharedInstance().getLastLoadContactTime(k);
      if (System.currentTimeMillis() - l > 180000L)
      {
        QMSettingManager.sharedInstance().setLastLoadContactTime(k);
        Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(k);
        if (localAccount != null)
        {
          if (!localAccount.isQQMail()) {
            break label116;
          }
          this.cgiManager.loadContacts(k, new MailContact.ContactType[] { MailContact.ContactType.NormalContact, MailContact.ContactType.HistoryContact, MailContact.ContactType.QQFriendContact, MailContact.ContactType.DomainContact });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label116:
        this.protocolManager.loadContacts(k);
      }
    }
  }
  
  public void loadAccountContactsByType(int[] paramArrayOfInt, MailContact.ContactType[] paramArrayOfContactType)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(k);
      if (localAccount != null)
      {
        if (!localAccount.isQQMail()) {
          break label60;
        }
        this.cgiManager.loadContacts(k, paramArrayOfContactType);
      }
      for (;;)
      {
        i += 1;
        break;
        label60:
        this.protocolManager.loadContacts(k);
      }
    }
  }
  
  public void loadGroupContacts(int paramInt)
  {
    this.cgiManager.loadGroupContacts(paramInt);
  }
  
  public void loadQQVipContacts(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localAccount != null) && (localAccount.isQQMail())) {
      this.cgiManager.loadVipContacts(paramInt);
    }
  }
  
  public ArrayList<MailContact> mergeContactsInfo(MailContact paramMailContact1, MailContact paramMailContact2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMailContact1 == null) || (paramMailContact2 == null)) {
      return localArrayList;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new ArrayList();
    LinkedHashSet localLinkedHashSet1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet2 = new LinkedHashSet();
    MailContact localMailContact1 = paramMailContact1.clone();
    MailContact localMailContact2 = paramMailContact2.clone();
    String str = localMailContact2.getName();
    paramMailContact2 = localMailContact2.getPinyin();
    paramMailContact1 = localMailContact2.getFullPinyin();
    if (StringExtention.isNullOrEmpty(str))
    {
      str = localMailContact1.getName();
      paramMailContact2 = localMailContact1.getPinyin();
      paramMailContact1 = localMailContact1.getFullPinyin();
    }
    for (;;)
    {
      if (!StringExtention.isNullOrEmpty(localMailContact2.getMark())) {
        ((ArrayList)localObject).add(localMailContact2.getMark());
      }
      if (!StringExtention.isNullOrEmpty(localMailContact1.getMark())) {
        ((ArrayList)localObject).add(localMailContact1.getMark());
      }
      int i;
      if (((ArrayList)localObject).size() > 0)
      {
        i = 0;
        if (i < ((ArrayList)localObject).size())
        {
          if (i == ((ArrayList)localObject).size() - 1) {
            localStringBuilder.append((String)((ArrayList)localObject).get(i));
          }
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append((String)((ArrayList)localObject).get(i) + ";");
          }
        }
      }
      int j;
      if ((localMailContact2.getCustoms() != null) && (localMailContact2.getCustoms().size() > 0))
      {
        localObject = localMailContact2.getCustoms().iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break label316;
        }
        if (((ContactCustom)((Iterator)localObject).next()).getType() != 3) {
          break label658;
        }
        i = 1;
      }
      label651:
      label658:
      for (;;)
      {
        break;
        j = 0;
        label316:
        if ((localMailContact1.getCustoms() != null) && (localMailContact1.getCustoms().size() > 0))
        {
          localObject = localMailContact1.getCustoms().iterator();
          while (((Iterator)localObject).hasNext())
          {
            ContactCustom localContactCustom = (ContactCustom)((Iterator)localObject).next();
            if ((localContactCustom.getType() == 3) && (j != 0)) {
              localContactCustom.setType(0);
            }
          }
        }
        localLinkedHashSet1.addAll(localMailContact2.getEmails());
        localLinkedHashSet1.addAll(localMailContact1.getEmails());
        localLinkedHashSet2.addAll(localMailContact2.getCustoms());
        localLinkedHashSet2.addAll(localMailContact1.getCustoms());
        localMailContact2.setMark(localStringBuilder.toString());
        localMailContact2.setEmails(new ArrayList(localLinkedHashSet1));
        localMailContact2.setCustoms(new ArrayList(localLinkedHashSet2));
        if (localMailContact2.getEmails().size() > 0)
        {
          localObject = ((ContactEmail)localMailContact2.getEmails().get(0)).getEmail();
          localMailContact2.setAddress((String)localObject);
          localMailContact2.setHash(MailContact.generateHash(localMailContact2));
          localMailContact1.setPinyin(paramMailContact2);
          localMailContact1.setFullPinyin(paramMailContact1);
          localMailContact1.setNick(str);
          localMailContact1.setName(str);
          localMailContact1.setMark(localStringBuilder.toString());
          localMailContact1.setEmails(new ArrayList(localLinkedHashSet1));
          localMailContact1.setCustoms(new ArrayList(localLinkedHashSet2));
          if (localMailContact1.getEmails().size() <= 0) {
            break label651;
          }
        }
        for (paramMailContact1 = ((ContactEmail)localMailContact1.getEmails().get(0)).getEmail();; paramMailContact1 = "")
        {
          localMailContact1.setAddress(paramMailContact1);
          localMailContact1.setHash(MailContact.generateHash(localMailContact1));
          localArrayList.add(localMailContact1);
          localArrayList.add(localMailContact2);
          return localArrayList;
          localObject = "";
          break;
        }
      }
    }
  }
  
  public void postAddComposeEmailNotification(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("address", paramString1);
    localHashMap.put("name", paramString2);
    localHashMap.put("mark", paramString3);
    localHashMap.put("contactId", String.valueOf(paramLong));
    QMNotification.postNotification("contact_detail_add_email", localHashMap);
  }
  
  public void postEditEmailNotification(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("oldAddress", paramString1);
    localHashMap.put("newAddress", paramString2);
    localHashMap.put("oldName", paramString3);
    localHashMap.put("newName", paramString4);
    localHashMap.put("newMark", paramString5);
    localHashMap.put("contactId", String.valueOf(paramLong));
    QMNotification.postNotification("contact_delete_modify_email", localHashMap);
  }
  
  public Observable<HashMap<String, Integer>> querySectionMap(ContactBaseListCursor paramContactBaseListCursor)
  {
    return Observable.create(new QMContactManager.2(this, paramContactBaseListCursor)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
  
  public Observable<HashMap<String, Integer>> querySectionMap(NameListBaseCursor paramNameListBaseCursor)
  {
    return Observable.create(new QMContactManager.3(this, paramNameListBaseCursor)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
  
  public void reindexMobileContact()
  {
    Threads.runInBackground(new QMContactManager.8(this));
  }
  
  public void saveCheckedAccountIds(List<Integer> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(paramList.get(i) + ";");
      i += 1;
    }
    QMSettingManager.sharedInstance().setContactGroupCheckedAccountIds(localStringBuilder.toString());
  }
  
  public void searchExchangeGlobalAddressList(int paramInt, String paramString)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localAccount != null) && ((localAccount.isExchangeMail()) || (localAccount.isActiveSyncMail())))
    {
      List localList = getSearchGlobalAddressListCache(paramInt, paramString);
      if ((localList != null) && (localList.size() > 0)) {
        triggerSearchExchangeAddressSuccess(paramString, localList);
      }
    }
    else
    {
      return;
    }
    this.protocolManager.searchExchangeGlobalAddressList(localAccount.getId(), paramString);
  }
  
  public void setSearchGlobalAddressListCache(int paramInt, String paramString, List<ASContact> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1))
    {
      deleteSearchGlobalAddressListCache(paramInt, paramString);
      return;
    }
    ArrayList localArrayList = Lists.newArrayList();
    localArrayList.add("expire:" + System.currentTimeMillis());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ASContact localASContact = (ASContact)paramList.next();
      localArrayList.add(localASContact.display_name_ + ":" + localASContact.email_address_);
    }
    paramList = StringUtils.join(localArrayList, ",");
    QMSettingManager.sharedInstance().setSearchExchangeAddress(paramInt, paramString, paramList);
  }
  
  public void setVip(List<MailContact> paramList, boolean paramBoolean)
  {
    QMLog.log(4, "QMContactManager", "set vip contactIds : " + paramList.toString() + " isVip: " + paramBoolean);
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MailContact localMailContact1 = (MailContact)paramList.next();
      if (paramBoolean)
      {
        DataCollector.logEvent("Event_Add_Vip_Contact");
        label84:
        localMailContact1 = getContactById(localMailContact1.getId());
        if (localMailContact1 == null) {
          continue;
        }
        if ((localMailContact1.getType() != MailContact.ContactType.NormalContact) && (localMailContact1.getType() != MailContact.ContactType.ProtocolContact)) {
          break label158;
        }
        setAndSyncVip(localMailContact1, paramBoolean);
      }
      for (;;)
      {
        localHashMap.put(Long.valueOf(localMailContact1.getId()), Boolean.valueOf(paramBoolean));
        break;
        DataCollector.logEvent("Event_Delete_Vip_Contact");
        break label84;
        label158:
        MailContact localMailContact2 = getSameEmailContactWhenSync(localMailContact1, localMailContact1.getId());
        if (localMailContact2 != null)
        {
          if (localMailContact2.isVip() != paramBoolean) {
            setAndSyncVip(localMailContact2, paramBoolean);
          }
        }
        else
        {
          localMailContact2 = checkContacts(localMailContact1);
          if (localMailContact2.getType() == MailContact.ContactType.NormalContact)
          {
            localMailContact2.setIsVip(paramBoolean);
            createAndSyncVip(localMailContact1, localMailContact2);
          }
          else if (localMailContact2.getType() == MailContact.ContactType.ProtocolContact)
          {
            localMailContact2.setIsVip(paramBoolean);
            createAndSyncVip(localMailContact1, localMailContact2);
          }
        }
      }
    }
    QMWatcherCenter.triggerVipContactSuccess(localHashMap);
  }
  
  public void syncBirthdayCalendarEvent(MailContact paramMailContact)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject4 = paramMailContact.getCustoms();
    if (localObject4 != null)
    {
      localObject4 = ((ArrayList)localObject4).iterator();
      localObject1 = localObject2;
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = (ContactCustom)((Iterator)localObject4).next();
        if (((ContactCustom)localObject1).getType() != 3) {
          break label616;
        }
      }
    }
    Object localObject3;
    label537:
    label616:
    for (localObject1 = ((ContactCustom)localObject1).getValue();; localObject1 = localObject3)
    {
      localObject2 = localObject1;
      break;
      if (!QMCalendarUtil.hasCalendarFolder()) {
        QMLog.log(6, "QMContactManager", "modify birthday calendarEvent but find no calendarFolder");
      }
      Calendar localCalendar;
      do
      {
        do
        {
          return;
          localObject4 = QMCalendarManager.getInstance().getEventByCid(paramMailContact.getId());
        } while ((localObject1 == null) || (((String)localObject1).equals("")));
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        localCalendar = Calendar.getInstance();
        int i = localCalendar.get(1);
        try
        {
          localCalendar.setTimeInMillis(localSimpleDateFormat.parse((String)localObject1).getTime());
          if (localObject4 == null)
          {
            localObject2 = localObject1;
            try
            {
              localObject4 = new QMCalendarEvent(localCalendar.getTimeInMillis(), localCalendar.getTimeInMillis() + QMCalendarManager.getInstance().getDefaultEventDuration() * 60000);
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setCid(paramMailContact.getId());
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setSvrId("");
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setPath("");
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setCreateTime(QMCalendarUtil.correctTimeToSecond(System.currentTimeMillis()));
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setSensivity(0);
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setReminder(QMCalendarManager.getInstance().getDefaultAllDayReminderTime());
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setRelateAccountId(paramMailContact.getAccountId());
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setAccountId(QMCalendarManager.getInstance().getDefaultAccountId());
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setCalderFolderId(QMCalendarManager.getInstance().getDefaultFolderId());
              localObject2 = localObject1;
              if (QMCalendarManager.getInstance().getDefaultAccountId() == 0)
              {
                localObject2 = localObject1;
                ((QMCalendarEvent)localObject4).setCategory(1);
              }
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setIsAllDay(true);
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setRecurrenceType(5);
              localObject2 = localObject1;
              ((QMCalendarEvent)localObject4).setTimezone(String.valueOf(QMCalendarManager.timeZone));
              localObject2 = localObject1;
              if (paramMailContact.getName().equals(""))
              {
                localObject2 = localObject1;
                paramMailContact = paramMailContact.getAddress();
                localObject2 = localObject1;
                ((QMCalendarEvent)localObject4).setSubject(String.format("%s的生日", new Object[] { paramMailContact }));
                localObject2 = localObject1;
                ((QMCalendarEvent)localObject4).setUid(QMCalendarEvent.generateUid((QMCalendarEvent)localObject4));
                localObject2 = localObject1;
                ((QMCalendarEvent)localObject4).setId(QMCalendarEvent.generateId((QMCalendarEvent)localObject4));
                localObject2 = localObject1;
                if (((QMCalendarEvent)localObject4).getCategory() != 1) {
                  break label537;
                }
                localObject2 = localObject1;
                CalendarProviderManager.sharedInstance().createLocalEvent((QMCalendarEvent)localObject4);
              }
            }
            catch (Exception paramMailContact)
            {
              QMLog.log(6, "QMContactManager", "create birthday calendarEvent fail " + localObject2);
              return;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject3 = localObject1;
            localObject1 = i + "-" + (String)localObject1;
            localObject3 = localObject1;
            localCalendar.setTimeInMillis(localSimpleDateFormat.parse((String)localObject1).getTime());
            continue;
            localObject3 = localObject1;
            paramMailContact = paramMailContact.getName();
          }
          localObject3 = localObject1;
          QMCalendarManager.getInstance().createEvent((QMCalendarEvent)localObject4);
          return;
        }
        localObject3 = localObject1;
      } while (((QMCalendarEvent)localObject4).getStartTime() == localCalendar.getTimeInMillis());
      localObject3 = localObject1;
      ((QMCalendarEvent)localObject4).setStartTime(localCalendar.getTimeInMillis());
      localObject3 = localObject1;
      ((QMCalendarEvent)localObject4).setEndTime(localCalendar.getTimeInMillis() + QMCalendarManager.getInstance().getDefaultEventDuration() * 60000);
      localObject3 = localObject1;
      QMCalendarManager.getInstance().updateCalenderEvent((QMCalendarEvent)localObject4);
      return;
    }
  }
  
  public void syncContact(MailContact paramMailContact1, MailContact paramMailContact2)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(paramMailContact2);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(Long.valueOf(paramMailContact2.getId()));
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    boolean bool = isStranger(localSQLiteDatabase, paramMailContact1);
    if ((bool) && (paramMailContact1 != null) && (paramMailContact1.getType() == MailContact.ContactType.HistoryContact))
    {
      if (AccountManager.shareInstance().getAccountList().getAccountById(paramMailContact1.getAccountId()).isQQMail()) {
        deleteContact(paramMailContact1);
      }
    }
    else
    {
      if (paramMailContact1.getType() == MailContact.ContactType.QQFriendContact)
      {
        String str = paramMailContact1.getName();
        if (!StringUtils.isEmpty(str))
        {
          Object localObject2 = paramMailContact2.getCustoms();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Lists.newArrayList();
          }
          localObject2 = new ContactCustom();
          ((ContactCustom)localObject2).setKey(QMApplicationContext.sharedInstance().getString(2131692069));
          ((ContactCustom)localObject2).setValue(str);
          ((ContactCustom)localObject2).setType(0);
          ((ArrayList)localObject1).add(localObject2);
          paramMailContact2.setCustoms((ArrayList)localObject1);
        }
      }
      if (bool) {
        break label292;
      }
    }
    label292:
    for (Object localObject1 = paramMailContact1;; localObject1 = paramMailContact2)
    {
      getNeedSyncContactByHash(localSQLiteDatabase, (MailContact)localObject1, new QMContactManager.4(this, paramMailContact2));
      if ((paramMailContact1 != null) && (paramMailContact1.getHash() != 0)) {
        this.sqliteHelper.contact.rebuildContactHash(localSQLiteDatabase, new int[] { paramMailContact1.getHash() });
      }
      updateNickNameByContact(paramMailContact2.getAccountId(), paramMailContact2);
      clearContactEmailCountCache();
      clearContactTelCache();
      clearComposeContactCache();
      if (!bool) {
        break label298;
      }
      QMWatcherCenter.triggerAddContactListSuccess(paramMailContact2.getAccountId(), localArrayList2, localArrayList1);
      return;
      deleteContactLocal(paramMailContact1);
      break;
    }
    label298:
    QMWatcherCenter.triggerEditContactListSuccess(paramMailContact2.getAccountId(), localArrayList1);
  }
  
  public void syncProtocolHistoryContact(MailInformation paramMailInformation)
  {
    if (paramMailInformation == null) {}
    for (;;)
    {
      return;
      int i = (int)(paramMailInformation.getDate().getTime() / 1000L);
      Object localObject1 = new ArrayList();
      if ((paramMailInformation.getToList() != null) && (paramMailInformation.getToList().size() != 0)) {
        ((ArrayList)localObject1).addAll(paramMailInformation.getToList());
      }
      if ((paramMailInformation.getCcList() != null) && (paramMailInformation.getCcList().size() != 0)) {
        ((ArrayList)localObject1).addAll(paramMailInformation.getCcList());
      }
      if ((paramMailInformation.getBccList() != null) && (paramMailInformation.getBccList().size() != 0)) {
        ((ArrayList)localObject1).addAll(paramMailInformation.getBccList());
      }
      int j = paramMailInformation.getAccountId();
      paramMailInformation = AccountManager.shareInstance().getAccountList().getAccountById(j);
      if ((paramMailInformation != null) && (!paramMailInformation.isQQMail()))
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          if ((localObject1 instanceof MailContact))
          {
            paramMailInformation = ((MailContact)localObject1).getAddress();
            Object localObject2 = ((MailContact)localObject1).getName();
            Object localObject3 = ((MailContact)localObject1).getNick();
            localObject1 = localObject2;
            if (StringExtention.isNullOrEmpty((String)localObject2)) {
              localObject1 = paramMailInformation;
            }
            localObject2 = localObject3;
            if (StringExtention.isNullOrEmpty((String)localObject3)) {
              localObject2 = paramMailInformation;
            }
            localObject3 = this.sqliteHelper.getWritableDatabase();
            Object localObject4 = this.sqliteHelper.contact.getContactIdByAccountAndTypeAndEmail((SQLiteDatabase)localObject3, j, MailContact.ContactType.HistoryContact.ordinal(), paramMailInformation);
            Object localObject5;
            if (!((ArrayList)localObject4).isEmpty())
            {
              localObject1 = ((ArrayList)localObject4).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = getContactById(((Long)((Iterator)localObject1).next()).longValue());
                localObject4 = ((MailContact)localObject2).getEmails();
                if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
                {
                  localObject4 = ((ArrayList)localObject4).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (ContactEmail)((Iterator)localObject4).next();
                    if (((ContactEmail)localObject5).getEmail().equals(paramMailInformation))
                    {
                      ((ContactEmail)localObject5).setFreq(((ContactEmail)localObject5).getFreq() + 1);
                      ((ContactEmail)localObject5).setFreqUpdateTime(i);
                    }
                  }
                }
                this.sqliteHelper.contact.updateContact((SQLiteDatabase)localObject3, (MailContact)localObject2);
              }
            }
            else
            {
              localObject4 = new ArrayList();
              ((ArrayList)localObject4).add(new ContactEmail(paramMailInformation, 1, i));
              localObject5 = new MailContact();
              ((MailContact)localObject5).setCid("0");
              ((MailContact)localObject5).setAccountId(j);
              ((MailContact)localObject5).setName((String)localObject1);
              ((MailContact)localObject5).setNick((String)localObject2);
              ((MailContact)localObject5).setType(MailContact.ContactType.HistoryContact);
              ((MailContact)localObject5).setAddress(paramMailInformation);
              ((MailContact)localObject5).setEmails((ArrayList)localObject4);
              ((MailContact)localObject5).setHashType(0);
              ((MailContact)localObject5).setHash(MailContact.generateHash((MailContact)localObject5));
              ((MailContact)localObject5).setOfflineType(0);
              ((MailContact)localObject5).setId(MailContact.generateProtocolHistoryContactId(((MailContact)localObject5).getAccountId(), ((MailContact)localObject5).getType().ordinal(), ((MailContact)localObject5).getCid(), ((MailContact)localObject5).getAddress()));
              this.sqliteHelper.contact.insertContact((SQLiteDatabase)localObject3, j, (MailContact)localObject5);
            }
          }
        }
      }
    }
  }
  
  public void triggerSearchExchangeAddressError(String paramString, QMProtocolError paramQMProtocolError)
  {
    ((SearchExchangeAddressWatcher)Watchers.of(SearchExchangeAddressWatcher.class)).onError(paramString, paramQMProtocolError);
  }
  
  public void triggerSearchExchangeAddressSuccess(String paramString, List<ASContact> paramList)
  {
    ((SearchExchangeAddressWatcher)Watchers.of(SearchExchangeAddressWatcher.class)).onSuccess(paramString, paramList);
  }
  
  public void updateNickNameByContact(int paramInt, MailContact paramMailContact)
  {
    sNickNameCache.updateNickNameByContact(paramInt, paramMailContact);
  }
  
  public void updateNickNameCacheByComposeData(ComposeData paramComposeData)
  {
    sNickNameCache.updateByComposeData(paramComposeData);
  }
  
  static abstract interface ContactConvWatcher
  {
    public abstract void onLocalSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean);
    
    public abstract void onRemoteSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager
 * JD-Core Version:    0.7.0.1
 */