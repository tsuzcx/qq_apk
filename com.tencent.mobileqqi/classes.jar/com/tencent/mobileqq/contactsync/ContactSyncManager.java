package com.tencent.mobileqq.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.AggregationExceptions;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fmy;
import fmz;
import fna;
import fnb;
import fnc;
import fne;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class ContactSyncManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 500;
  private static final long jdField_a_of_type_Long = 30000L;
  private static final String jdField_a_of_type_JavaLangString = "ContactSync.Manager";
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static String jdField_b_of_type_JavaLangString = Constants.e;
  private static final String jdField_c_of_type_JavaLangString = "contactsync";
  private static final String e = "pref_remove_account_prefix";
  private Account jdField_a_of_type_AndroidAccountsAccount = null;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public QQAppInterface a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new fmy(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new fna(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private volatile boolean jdField_c_of_type_Boolean;
  private final String jdField_d_of_type_JavaLangString = "pref_sync_contact";
  private volatile boolean jdField_d_of_type_Boolean = false;
  private String f = "com.android.contacts";
  
  public ContactSyncManager(QQAppInterface paramQQAppInterface)
  {
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "ContactSyncManager onCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences("contactsync", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_sync_contact", true);
    for (;;)
    {
      try
      {
        b();
        boolean bool = d();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "ContactSyncManager oncreate | support = " + bool);
        }
        if (!bool) {
          continue;
        }
        paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ContactSync.Manager", 2, "initSyncAccount | e = " + Log.getStackTraceString(localThrowable));
        continue;
      }
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_remove_account_prefix" + paramQQAppInterface.a(), false);
      return;
      c();
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public static String a(String paramString)
  {
    String str = paramString;
    if (Build.MANUFACTURER.contains("OPPO")) {
      str = paramString.replace("'", "").replace("%", "").replace("_", "-").replace("/", "").replace("[", "").replace("]", "").replace("&", "");
    }
    return str;
  }
  
  private List a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver();
    ((ContentResolver)localObject).delete(fne.a(c()), "deleted>0", null);
    Cursor localCursor = ((ContentResolver)localObject).query(fne.a(c()), fne.jdField_a_of_type_ArrayOfJavaLangString, null, null, null);
    localObject = new ArrayList();
    if (localCursor != null)
    {
      ((ArrayList)localObject).ensureCapacity(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        RawContact localRawContact = new RawContact();
        localRawContact.jdField_a_of_type_Long = localCursor.getLong(0);
        localRawContact.jdField_a_of_type_JavaLangString = localCursor.getString(1);
        localRawContact.jdField_a_of_type_Int = localCursor.getInt(2);
        ((ArrayList)localObject).add(localRawContact);
      }
    }
    try
    {
      localCursor.close();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "getRawContacts | contact list size = " + ((ArrayList)localObject).size());
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "getRawContacts | cursor close exception = " + Log.getStackTraceString(localThrowable));
        }
      }
    }
  }
  
  private Map a()
  {
    List localList = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    if (localList != null)
    {
      HashMap localHashMap = new HashMap(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        localHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "getQQContacts | allList.size = " + localList.size() + " | map.size=" + localHashMap.size());
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  private Set a()
  {
    AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getAccounts();
    Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[] { "_id" }, "account_type like ?", new String[] { "%.sim%" }, null);
    Object localObject = new HashSet();
    if (localCursor != null)
    {
      HashSet localHashSet = new HashSet(localCursor.getCount());
      for (;;)
      {
        localObject = localHashSet;
        if (!localCursor.moveToNext()) {
          break;
        }
        localHashSet.add(Long.valueOf(localCursor.getLong(0)));
      }
    }
    if (localCursor != null) {}
    try
    {
      localCursor.close();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "getLocalSIMContacts | count = " + ((Set)localObject).size());
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "getLocalSIMContacts | cursor close exception = " + Log.getStackTraceString(localThrowable));
        }
      }
    }
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | current authority = " + this.f);
    }
    if (this.f.equals("com.android.contacts"))
    {
      Object localObject = d();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | find substitute authority = " + (String)localObject);
        }
        this.f = ((String)localObject);
        localObject = this.jdField_a_of_type_AndroidAccountsAccount;
        if (localObject != null) {
          ContentResolver.setSyncAutomatically((Account)localObject, this.f, true);
        }
        b();
      }
    }
  }
  
  private void a(long paramLong, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", jdField_b_of_type_JavaLangString).build(), "_id = ?", new String[] { paramLong + "" });
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteRawContact | leave");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Account paramAccount)
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "markAccountDeleteByUser | accountSetIDel = " + jdField_a_of_type_JavaUtilSet + " | name = " + paramAccount.name + " | contain = " + jdField_a_of_type_JavaUtilSet.contains(paramAccount.name));
      }
      if (jdField_a_of_type_JavaUtilSet.remove(paramAccount.name)) {
        return;
      }
      paramQQAppInterface.a().getSharedPreferences("contactsync", 0).edit().putBoolean("pref_remove_account_prefix" + paramAccount.name, true).commit();
      ??? = (ContactSyncManager)paramQQAppInterface.getManager(39);
      if (??? != null)
      {
        if ((!TextUtils.isEmpty(paramQQAppInterface.a())) && (e(paramAccount.name).equals(paramQQAppInterface.a()))) {
          ((ContactSyncManager)???).jdField_b_of_type_Boolean = true;
        }
        ((ContactSyncManager)???).jdField_a_of_type_AndroidAccountsAccount = null;
        ((ContactSyncManager)???).jdField_d_of_type_Boolean = false;
        return;
      }
    }
  }
  
  private void a(List paramList, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("raw_contact_id1", Long.valueOf(paramLong1));
    localContentValues.put("raw_contact_id2", Long.valueOf(paramLong2));
    localContentValues.put("type", Integer.valueOf(1));
    paramList.add(ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI).withValues(localContentValues).withYieldAllowed(true).build());
  }
  
  private void a(List paramList, PhoneContact paramPhoneContact, long paramLong)
  {
    paramList = ContactOperation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramLong);
    Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver().query(fnc.jdField_a_of_type_AndroidNetUri, fnc.jdField_a_of_type_ArrayOfJavaLangString, "raw_contact_id=?", new String[] { String.valueOf(paramLong) }, null);
    if (localCursor != null) {
      while (localCursor.moveToNext()) {
        if (localCursor.getString(1).equals("vnd.android.cursor.item/name"))
        {
          Object localObject = localCursor.getString(2);
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(paramPhoneContact.name)))
          {
            paramLong = localCursor.getLong(0);
            localObject = ContentUris.withAppendedId(fnc.jdField_a_of_type_AndroidNetUri, paramLong);
            paramList.a(paramPhoneContact.name, (Uri)localObject);
          }
        }
      }
    }
    try
    {
      localCursor.close();
      return;
    }
    catch (Throwable paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ContactSync.Manager", 2, "updateRawContact | cursor close exception = " + Log.getStackTraceString(paramList));
    }
  }
  
  private void a(List paramList, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "insertRawContact | mobileNo " + paramPhoneContact.mobileNo + " pc.name " + paramPhoneContact.name);
    }
    paramList = ContactOperation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, c(), paramPhoneContact.mobileNo, paramPhoneContact.nationCode, paramPhoneContact.mobileCode, paramPhoneContact.ability, paramPhoneContact.contactID);
    paramList.b(paramPhoneContact.name);
    if (paramBoolean) {
      paramList.d(paramPhoneContact.mobileNo);
    }
    paramList.e(paramPhoneContact.mobileNo);
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "applyBatch | enter");
    }
    boolean bool = true;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().applyBatch(this.f, paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "applyBatch | result = " + bool + " | leave");
      }
      return bool;
    }
    catch (RemoteException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | RemoteException:" + Log.getStackTraceString(paramArrayList));
        }
        bool = false;
      }
    }
    catch (OperationApplicationException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | OperationApplicationException:" + Log.getStackTraceString(paramArrayList));
        }
        bool = false;
      }
    }
    catch (IllegalArgumentException paramArrayList)
    {
      for (;;)
      {
        String str = Log.getStackTraceString(paramArrayList);
        if ((!TextUtils.isEmpty(str)) && (str.contains("Unknown authority"))) {
          a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | IllegalArgumentException: " + Log.getStackTraceString(paramArrayList));
        }
        bool = false;
      }
    }
  }
  
  private boolean a(Map paramMap)
  {
    for (;;)
    {
      boolean bool;
      Object localObject3;
      ArrayList localArrayList;
      Object localObject2;
      Object localObject1;
      int i;
      RawContact localRawContact;
      String str;
      try
      {
        if (g())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = enter");
          }
          bool = false;
          return bool;
        }
        localObject3 = a();
        localArrayList = new ArrayList();
        localObject2 = new HashSet(paramMap.size());
        localObject1 = new HashSet();
        localObject3 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label338;
        }
        localRawContact = (RawContact)((Iterator)localObject3).next();
        if (g())
        {
          if (!QLog.isColorLevel()) {
            break label1166;
          }
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for1");
          break label1166;
        }
        str = localRawContact.jdField_a_of_type_JavaLangString;
        if ((paramMap == null) || (TextUtils.isEmpty(str)) || (!paramMap.containsKey(localRawContact.jdField_a_of_type_JavaLangString)))
        {
          a(localRawContact.jdField_a_of_type_Long, localArrayList);
          i += 1;
          continue;
        }
        if ((paramMap == null) || (TextUtils.isEmpty(str)) || (!paramMap.containsKey(str))) {
          continue;
        }
        if (((Set)localObject2).contains(Integer.valueOf(localRawContact.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ContactSync.Manager", 2, "doSyncContacts | error: duplicate contact id");
          }
          a(localRawContact.jdField_a_of_type_Long, localArrayList);
          paramMap.remove(str);
          continue;
        }
        ((Set)localObject2).add(Integer.valueOf(localRawContact.jdField_a_of_type_Int));
      }
      finally {}
      if (((PhoneContact)paramMap.get(str)).contactID != localRawContact.jdField_a_of_type_Int)
      {
        ((Set)localObject1).add(localRawContact.jdField_a_of_type_JavaLangString);
        a(localArrayList, (PhoneContact)paramMap.get(str), localRawContact.jdField_a_of_type_Long);
        continue;
        label338:
        paramMap = paramMap.values();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | delete count = " + i + " | reaggregate count = " + ((Set)localObject1).size() + " | will insert count = " + paramMap.size());
        }
        if ((localArrayList.size() > 0) && (!g()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply update ops | size = " + localArrayList.size());
          }
          a(localArrayList);
          localArrayList.clear();
        }
        paramMap = paramMap.iterator();
        label561:
        label707:
        while (paramMap.hasNext())
        {
          localObject3 = (PhoneContact)paramMap.next();
          if (g())
          {
            if (!QLog.isColorLevel()) {
              break label1171;
            }
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for2");
            break label1171;
          }
          if (!((Set)localObject2).contains(Integer.valueOf(((PhoneContact)localObject3).contactID))) {
            if (TextUtils.isEmpty(((PhoneContact)localObject3).uin))
            {
              a(localArrayList, (PhoneContact)localObject3, false);
              ((Set)localObject2).add(Integer.valueOf(((PhoneContact)localObject3).contactID));
              ((Set)localObject1).add(((PhoneContact)localObject3).mobileNo);
            }
          }
          for (;;)
          {
            if (localArrayList.size() <= 500) {
              break label707;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply insert ops  | size = " + localArrayList.size());
            }
            a(localArrayList);
            localArrayList.clear();
            break;
            a(localArrayList, (PhoneContact)localObject3, true);
            break label561;
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | contact " + ((PhoneContact)localObject3).contactID + " has two match phonenum");
            }
          }
        }
        if ((localArrayList.size() > 0) && (!g()))
        {
          bool = a(localArrayList);
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply insert ops  | size = " + localArrayList.size() + " | result = " + bool);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | aggregateMap.size = " + ((Set)localObject1).size());
        }
        if (((Set)localObject1).size() == 0)
        {
          bool = true;
        }
        else
        {
          localArrayList.clear();
          localArrayList.ensureCapacity(((Set)localObject1).size());
          localObject2 = a();
          paramMap = b();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RawContact)((Iterator)localObject2).next();
            if ((((Set)localObject1).contains(((RawContact)localObject3).jdField_a_of_type_JavaLangString)) && (paramMap.containsKey(((RawContact)localObject3).jdField_a_of_type_JavaLangString)))
            {
              a(localArrayList, ((RawContact)localObject3).jdField_a_of_type_Long, ((Long)paramMap.get(((RawContact)localObject3).jdField_a_of_type_JavaLangString)).longValue());
              ((Set)localObject1).remove(((RawContact)localObject3).jdField_a_of_type_JavaLangString);
            }
            if (localArrayList.size() > 500)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply aggregate batch | size = " + localArrayList.size());
              }
              a(localArrayList);
              localArrayList.clear();
            }
          }
          if (QLog.isColorLevel())
          {
            paramMap = ((Set)localObject1).iterator();
            while (paramMap.hasNext())
            {
              localObject1 = (String)paramMap.next();
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | remain source ID = " + c((String)localObject1));
            }
          }
          if ((localArrayList.size() > 0) && (!g()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply aggregate batch | size = " + localArrayList.size());
            }
            a(localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | leave");
          }
          bool = true;
          continue;
          label1166:
          bool = false;
          continue;
          label1171:
          bool = false;
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid uin";
    }
    return paramString.substring(0, 3);
  }
  
  private Map b()
  {
    return new HashMap();
  }
  
  private void b()
  {
    AccountManager localAccountManager = AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Account[] arrayOfAccount = localAccountManager.getAccountsByType("com.tencent.mobileqqi.account");
    if (arrayOfAccount.length > 0)
    {
      this.jdField_a_of_type_AndroidAccountsAccount = arrayOfAccount[0];
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "initSyncAccount | syncAccount = " + this.jdField_a_of_type_AndroidAccountsAccount);
      }
      int i = 1;
      while (i < arrayOfAccount.length)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "initSyncAccount | delAccount = " + arrayOfAccount[i]);
        }
        localAccountManager.removeAccount(arrayOfAccount[i], null, null);
        i += 1;
      }
    }
  }
  
  private String c()
  {
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    if (localAccount != null) {
      return localAccount.name;
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid phone num";
    }
    return paramString.substring(paramString.length() - 3);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidAccountsAccount = null;
    try
    {
      AccountManager localAccountManager = AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      Account[] arrayOfAccount = localAccountManager.getAccountsByType("com.tencent.mobileqqi.account");
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "removeSyncAccount | account.length = " + arrayOfAccount.length);
      }
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = arrayOfAccount[i];
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "removeSyncAccount | a.name = " + b(localAccount.name));
        }
        synchronized (jdField_a_of_type_JavaUtilSet)
        {
          jdField_a_of_type_JavaUtilSet.add(localAccount.name);
          localAccountManager.removeAccount(localAccount, new fnb(this), null);
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "removeSyncAccount | e = " + Log.getStackTraceString(localThrowable));
      }
    }
  }
  
  private String d()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageManager().getInstalledPackages(8).iterator();
    while (localIterator.hasNext())
    {
      ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)localIterator.next()).providers;
      if (arrayOfProviderInfo != null)
      {
        int j = arrayOfProviderInfo.length;
        int i = 0;
        while (i < j)
        {
          ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
          if ((localProviderInfo.authority.contains("contacts")) && (!localProviderInfo.authority.equals("com.android.contacts"))) {
            return localProviderInfo.authority;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    Object localObject;
    if ((paramString != null) && (paramString.length() > 4))
    {
      localObject = new StringBuilder();
      int j = paramString.length() - 4;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append("*");
        i += 1;
      }
      ((StringBuilder)localObject).append(paramString.substring(j));
      localObject = ((StringBuilder)localObject).toString();
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramString != null);
    return "";
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("pref_remove_account_prefix" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private static String e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("(");
      int j = paramString.lastIndexOf(")");
      if ((i != -1) && (j != -1)) {
        return paramString.substring(i + 1, j);
      }
    }
    return null;
  }
  
  private boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldAddAccount | is device support = " + d() + " | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean + " | hasIRemovedByUser = " + this.jdField_b_of_type_Boolean);
    }
    if ((d()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      Object localObject = a();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "couldAddAccount | syncUin = " + b((String)localObject) + " | currentUin = " + b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        return false;
      }
      localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("coundlAddAccount | pcm = ").append(localObject).append(" | bindState = ");
        if (localObject == null) {
          break label310;
        }
      }
      label310:
      for (int i = ((PhoneContactManager)localObject).b();; i = -1000)
      {
        QLog.d("ContactSync.Manager", 2, i);
        if ((localObject == null) || (!((PhoneContactManager)localObject).h())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "couldAddAccount | bind state = " + ((PhoneContactManager)localObject).b());
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldSyncContact | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean);
    }
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject = a();
        PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("couldSyncContact | bind state = ");
          if (localPhoneContactManager == null) {
            break label288;
          }
          i = 7;
          QLog.d("ContactSync.Manager", 2, i + " | account.name = " + b((String)localObject));
        }
        bool1 = bool2;
        if (localPhoneContactManager != null)
        {
          bool1 = bool2;
          if (localPhoneContactManager.h())
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))
            {
              localObject = this.jdField_a_of_type_AndroidAccountsAccount;
              if (localObject == null) {
                break label300;
              }
              bool2 = ContentResolver.getSyncAutomatically((Account)localObject, this.f);
              if (ContentResolver.getIsSyncable((Account)localObject, this.f) <= 0) {
                break label295;
              }
              bool1 = true;
              label226:
              bool3 = ContentResolver.getMasterSyncAutomatically();
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "couldSyncContact | isSystemSyncAutomatic = " + bool2 + " | isSystemSyncable = " + bool1 + " | isMasterSyncAutomatic = " + bool3);
      }
      bool1 = bool2;
      return bool1;
      label288:
      i = -100000;
      break;
      label295:
      bool1 = false;
      break label226;
      label300:
      bool1 = false;
      bool2 = false;
    }
  }
  
  private boolean g()
  {
    boolean bool2 = true;
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    boolean bool1;
    StringBuilder localStringBuilder;
    if ((localAccount == null) || (Thread.interrupted()))
    {
      bool1 = true;
      if ((bool1) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder().append("shouldStopSync | account = ");
        if (localAccount != null) {
          break label82;
        }
      }
    }
    for (;;)
    {
      QLog.d("ContactSync.Manager", 2, bool2 + " | interrupted = " + Thread.interrupted());
      return bool1;
      bool1 = false;
      break;
      label82:
      bool2 = false;
    }
  }
  
  private boolean h()
  {
    boolean bool = e();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "addSyncAccount | could add account = " + bool);
    }
    if (!bool) {
      return false;
    }
    try
    {
      AccountManager localAccountManager = AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      Account localAccount = new Account(a(String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() })), "com.tencent.mobileqqi.account");
      if (localAccountManager.addAccountExplicitly(localAccount, null, null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly success");
        }
        this.jdField_a_of_type_AndroidAccountsAccount = localAccount;
        ContentResolver.setIsSyncable(this.jdField_a_of_type_AndroidAccountsAccount, this.f, 1);
        ContentResolver.setSyncAutomatically(localAccount, this.f, true);
        b();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly fail");
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | e = " + Log.getStackTraceString(localThrowable));
      }
    }
    return true;
  }
  
  public SimplePhoneContact a(Uri paramUri)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver();
    paramUri = ((ContentResolver)localObject).query(paramUri, new String[] { "raw_contact_id" }, null, null, null);
    long l1 = -1L;
    long l2 = l1;
    if (paramUri != null) {
      if (!paramUri.moveToNext()) {}
    }
    for (l1 = paramUri.getLong(0);; l1 = l2) {
      try
      {
        paramUri.close();
        if (l1 != -1L) {
          break;
        }
        return null;
      }
      catch (Throwable paramUri)
      {
        l2 = l1;
        if (QLog.isColorLevel())
        {
          QLog.d("ContactSync.Manager", 2, "getSimplePhoneContactByJumpUri | cursor close exception1 = " + Log.getStackTraceString(paramUri));
          l2 = l1;
        }
      }
    }
    paramUri = new SimplePhoneContact();
    Cursor localCursor = ((ContentResolver)localObject).query(fnc.jdField_a_of_type_AndroidNetUri, fnc.jdField_a_of_type_ArrayOfJavaLangString, "raw_contact_id=?", new String[] { String.valueOf(l1) }, null);
    if (localCursor != null) {
      while (localCursor.moveToNext()) {
        if (localCursor.getString(1).equals("vnd.android.cursor.item/name")) {
          paramUri.jdField_a_of_type_JavaLangString = localCursor.getString(2);
        }
      }
    }
    try
    {
      localCursor.close();
      localObject = ((ContentResolver)localObject).query(ContactsContract.RawContacts.CONTENT_URI, fne.b, "_id=?", new String[] { String.valueOf(l1) }, null);
      if (localObject != null) {
        if (((Cursor)localObject).moveToNext())
        {
          paramUri.jdField_b_of_type_JavaLangString = ((Cursor)localObject).getString(0);
          paramUri.c = ((Cursor)localObject).getString(1);
          paramUri.jdField_a_of_type_Int = ((Cursor)localObject).getInt(2);
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        do
        {
          ((Cursor)localObject).close();
          return paramUri;
          localThrowable2 = localThrowable2;
        } while (!QLog.isColorLevel());
        QLog.d("ContactSync.Manager", 2, "getSimplePhoneContactByJumpUri | cursor close exception2 = " + Log.getStackTraceString(localThrowable2));
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "getSimplePhoneContactByJumpUri | cursor close exception3 = " + Log.getStackTraceString(localThrowable1));
          }
        }
      }
    }
  }
  
  public String a()
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      return e(str);
    }
    return null;
  }
  
  /* Error */
  public String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 194	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 162	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 847
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 216	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +230 -> 261
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 232 1 0
    //   42: ifeq +219 -> 261
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 245 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 260 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: new 117	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 849
    //   89: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   96: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +34 -> 149
    //   118: aload_1
    //   119: astore_2
    //   120: ldc 15
    //   122: iconst_2
    //   123: new 117	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 851
    //   133: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_3
    //   137: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_1
    //   150: ifnull +9 -> 159
    //   153: aload_1
    //   154: invokeinterface 260 1 0
    //   159: aconst_null
    //   160: areturn
    //   161: astore_1
    //   162: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +32 -> 197
    //   168: ldc 15
    //   170: iconst_2
    //   171: new 117	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 849
    //   181: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   188: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_2
    //   202: aload_2
    //   203: ifnull +9 -> 212
    //   206: aload_2
    //   207: invokeinterface 260 1 0
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -6 -> 212
    //   221: ldc 15
    //   223: iconst_2
    //   224: new 117	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 849
    //   234: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   241: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: goto -38 -> 212
    //   253: astore_1
    //   254: goto -52 -> 202
    //   257: astore_3
    //   258: goto -148 -> 110
    //   261: aconst_null
    //   262: astore_2
    //   263: goto -206 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	ContactSyncManager
    //   0	266	1	paramUri	Uri
    //   10	197	2	localObject1	Object
    //   214	24	2	localThrowable	Throwable
    //   262	1	2	localObject2	Object
    //   54	2	3	str	String
    //   107	30	3	localException1	java.lang.Exception
    //   257	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	107	java/lang/Exception
    //   153	159	161	java/lang/Throwable
    //   11	30	199	finally
    //   206	212	214	java/lang/Throwable
    //   36	45	253	finally
    //   47	55	253	finally
    //   112	118	253	finally
    //   120	149	253	finally
    //   36	45	257	java/lang/Exception
    //   47	55	257	java/lang/Exception
  }
  
  public String a(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    int j = 20;
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    boolean bool1;
    boolean bool2;
    label37:
    int k;
    int i;
    if (paramGetOnlineInfoResp.iTermType != 65793L)
    {
      bool1 = true;
      if (paramGetOnlineInfoResp.iTermType != 67586L) {
        break label143;
      }
      bool2 = true;
      k = (int)paramGetOnlineInfoResp.dwStatus;
      i = j;
      if (20 != k)
      {
        i = j;
        if (21 != k)
        {
          i = j;
          if (40 != k)
          {
            if (41 != k) {
              break label149;
            }
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      j = ContactUtils.a(i, k, bool1, 0, (int)paramGetOnlineInfoResp.iTermType);
      if ((j == 0) || (j == 6)) {
        break label166;
      }
      return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), i, k, bool1, 0, bool2, (int)paramGetOnlineInfoResp.iTermType, paramGetOnlineInfoResp.eNetworkType, false);
      bool1 = false;
      break;
      label143:
      bool2 = false;
      break label37;
      label149:
      if (bool2) {
        i = 11;
      } else {
        i = 10;
      }
    }
    label166:
    return null;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteSyncContact | mobileNo = " + c(paramString));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().delete(fne.a(c()), "sourceid=?", new String[] { paramString });
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "setSyncContactAllowed | allow = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("pref_sync_contact", paramBoolean).commit();
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = false;
      h();
      return;
    }
    if (this.c)
    {
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    c();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncAllContacts | isSyncing = " + this.c);
    }
    if ((this.c) || (!f())) {
      return false;
    }
    this.c = true;
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    boolean bool = a(a());
    if (this.jdField_d_of_type_Boolean)
    {
      c();
      this.jdField_d_of_type_Boolean = false;
    }
    this.c = false;
    return bool;
  }
  
  /* Error */
  public String b(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 194	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 162	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 908
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 216	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +230 -> 261
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 232 1 0
    //   42: ifeq +219 -> 261
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 245 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 260 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: new 117	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 910
    //   89: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   96: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +34 -> 149
    //   118: aload_1
    //   119: astore_2
    //   120: ldc 15
    //   122: iconst_2
    //   123: new 117	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 912
    //   133: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_3
    //   137: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_1
    //   150: ifnull +9 -> 159
    //   153: aload_1
    //   154: invokeinterface 260 1 0
    //   159: aconst_null
    //   160: areturn
    //   161: astore_1
    //   162: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +32 -> 197
    //   168: ldc 15
    //   170: iconst_2
    //   171: new 117	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 910
    //   181: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   188: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_2
    //   202: aload_2
    //   203: ifnull +9 -> 212
    //   206: aload_2
    //   207: invokeinterface 260 1 0
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -6 -> 212
    //   221: ldc 15
    //   223: iconst_2
    //   224: new 117	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 910
    //   234: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   241: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: goto -38 -> 212
    //   253: astore_1
    //   254: goto -52 -> 202
    //   257: astore_3
    //   258: goto -148 -> 110
    //   261: aconst_null
    //   262: astore_2
    //   263: goto -206 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	ContactSyncManager
    //   0	266	1	paramUri	Uri
    //   10	197	2	localObject1	Object
    //   214	24	2	localThrowable	Throwable
    //   262	1	2	localObject2	Object
    //   54	2	3	str	String
    //   107	30	3	localException1	java.lang.Exception
    //   257	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	107	java/lang/Exception
    //   153	159	161	java/lang/Throwable
    //   11	30	199	finally
    //   206	212	214	java/lang/Throwable
    //   36	45	253	finally
    //   47	55	253	finally
    //   112	118	253	finally
    //   120	149	253	finally
    //   36	45	257	java/lang/Exception
    //   47	55	257	java/lang/Exception
  }
  
  public String b(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    String str1 = "";
    String str2 = "";
    int i;
    switch (paramGetOnlineInfoResp.eNetworkType)
    {
    default: 
      i = 0;
      paramGetOnlineInfoResp = str2;
    }
    while (i != 0)
    {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getResources().getString(2131563041), new Object[] { str1, paramGetOnlineInfoResp });
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131562173);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131563398);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131562173);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131563399);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131562173);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131563400);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131563205);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131563401);
      i = 1;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncBindContactList");
    }
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (!this.c) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fmz(this));
    }
    for (;;)
    {
      return true;
      BaseApplicationImpl.a.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean d()
  {
    String str = Build.MANUFACTURER;
    return true;
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager
 * JD-Core Version:    0.7.0.1
 */