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
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dci;
import dcj;
import dck;
import dcl;
import dcm;
import dcn;
import dco;
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
  private static String jdField_b_of_type_JavaLangString = Constants.jdField_d_of_type_JavaLangString;
  private static final String jdField_c_of_type_JavaLangString = "contactsync";
  private static final String e = "pref_remove_account_prefix";
  private Account jdField_a_of_type_AndroidAccountsAccount = null;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public QQAppInterface a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new dci(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new dck(this);
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
        QLog.d("ContactSync.Manager", 2, "initSyncAccount e = ", localThrowable);
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
    ((ContentResolver)localObject).delete(dco.a(c()), "deleted>0", null);
    Cursor localCursor = ((ContentResolver)localObject).query(dco.a(c()), dco.jdField_a_of_type_ArrayOfJavaLangString, null, null, null);
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
          QLog.d("ContactSync.Manager", 2, "getRawContacts | cursor close exception = ", localThrowable);
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
        if (!TextUtils.isEmpty(localPhoneContact.uin)) {
          localHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
        }
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
          QLog.d("ContactSync.Manager", 2, "getLocalSIMContacts | cursor close exception", localThrowable);
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
      ??? = (ContactSyncManager)paramQQAppInterface.getManager(37);
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
  
  private void a(List paramList, PhoneContact paramPhoneContact)
  {
    paramList = ContactOperation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, c(), paramPhoneContact.mobileNo, paramPhoneContact.nationCode, paramPhoneContact.mobileCode, paramPhoneContact.ability, paramPhoneContact.contactID);
    paramList.b(paramPhoneContact.name);
    paramList.d(paramPhoneContact.mobileNo);
  }
  
  private void a(List paramList, PhoneContact paramPhoneContact, long paramLong)
  {
    paramList = ContactOperation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramLong);
    Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver().query(dcm.jdField_a_of_type_AndroidNetUri, dcm.jdField_a_of_type_ArrayOfJavaLangString, "raw_contact_id=?", new String[] { String.valueOf(paramLong) }, null);
    if (localCursor != null) {
      while (localCursor.moveToNext()) {
        if (localCursor.getString(1).equals("vnd.android.cursor.item/name"))
        {
          Object localObject = localCursor.getString(2);
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(paramPhoneContact.name)))
          {
            paramLong = localCursor.getLong(0);
            localObject = ContentUris.withAppendedId(dcm.jdField_a_of_type_AndroidNetUri, paramLong);
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
      QLog.d("ContactSync.Manager", 2, "updateRawContact | cursor close exception = ", paramList);
    }
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
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | RemoteException:", paramArrayList);
        }
        bool = false;
      }
    }
    catch (OperationApplicationException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | OperationApplicationException:", paramArrayList);
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
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | IllegalArgumentException: ", paramArrayList);
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
            break label1142;
          }
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for1");
          break label1142;
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
        label683:
        while (paramMap.hasNext())
        {
          localObject3 = (PhoneContact)paramMap.next();
          if (g())
          {
            if (!QLog.isColorLevel()) {
              break label1147;
            }
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for2");
            break label1147;
          }
          if (!((Set)localObject2).contains(Integer.valueOf(((PhoneContact)localObject3).contactID)))
          {
            a(localArrayList, (PhoneContact)localObject3);
            ((Set)localObject2).add(Integer.valueOf(((PhoneContact)localObject3).contactID));
            ((Set)localObject1).add(((PhoneContact)localObject3).mobileNo);
          }
          for (;;)
          {
            if (localArrayList.size() <= 500) {
              break label683;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply insert ops  | size = " + localArrayList.size());
            }
            a(localArrayList);
            localArrayList.clear();
            break;
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
          label1142:
          bool = false;
          continue;
          label1147:
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
    Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().query(dcn.jdField_a_of_type_AndroidNetUri, dcn.jdField_a_of_type_ArrayOfJavaLangString, null, null, null);
    Object localObject = new HashMap();
    if (localCursor != null)
    {
      HashMap localHashMap = new HashMap(localCursor.getCount());
      for (;;)
      {
        localObject = localHashMap;
        if (!localCursor.moveToNext()) {
          break;
        }
        localHashMap.put(PhoneContactManagerImp.a(localCursor.getString(0)), Long.valueOf(localCursor.getLong(3)));
      }
    }
    if (localCursor != null) {}
    try
    {
      localCursor.close();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ContactSync.Manager", 2, "getLocalContacts | cursor close exception = ", localThrowable);
    }
    return localObject;
  }
  
  private void b()
  {
    AccountManager localAccountManager = AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Account[] arrayOfAccount = localAccountManager.getAccountsByType("com.tencent.mobileqq.account");
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
      Account[] arrayOfAccount = localAccountManager.getAccountsByType("com.tencent.mobileqq.account");
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
          localAccountManager.removeAccount(localAccount, new dcl(this), null);
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "removeSyncAccount | e = ", localThrowable);
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
        if ((localObject == null) || (!((PhoneContactManager)localObject).g())) {
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
          if (localPhoneContactManager.g())
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
      Account localAccount = new Account(a(String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() })), "com.tencent.mobileqq.account");
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
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | e = ", localThrowable);
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
          QLog.d("ContactSync.Manager", 2, "getSimplePhoneContactByJumpUri | cursor close exception1 = ", paramUri);
          l2 = l1;
        }
      }
    }
    paramUri = new SimplePhoneContact();
    Cursor localCursor = ((ContentResolver)localObject).query(dcm.jdField_a_of_type_AndroidNetUri, dcm.jdField_a_of_type_ArrayOfJavaLangString, "raw_contact_id=?", new String[] { String.valueOf(l1) }, null);
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
      localObject = ((ContentResolver)localObject).query(ContactsContract.RawContacts.CONTENT_URI, dco.b, "_id=?", new String[] { String.valueOf(l1) }, null);
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
        QLog.d("ContactSync.Manager", 2, "getSimplePhoneContactByJumpUri | cursor close exception2 = ", localThrowable2);
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "getSimplePhoneContactByJumpUri | cursor close exception3 = ", localThrowable1);
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
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 190	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 158	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 852
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 212	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 228 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 241 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 256 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: ldc_w 854
    //   82: aload_1
    //   83: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 15
    //   103: iconst_2
    //   104: ldc_w 856
    //   107: aload_3
    //   108: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 256 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 15
    //   132: iconst_2
    //   133: ldc_w 854
    //   136: aload_1
    //   137: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 256 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 15
    //   166: iconst_2
    //   167: ldc_w 854
    //   170: aload_2
    //   171: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	java.lang.Exception
    //   181	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
  }
  
  public String a(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    int i;
    int j;
    if ((paramGetOnlineInfoResp.iTermType == 65793L) || (paramGetOnlineInfoResp.iTermType == 67586L))
    {
      i = 1;
      j = (int)paramGetOnlineInfoResp.dwStatus;
      if ((20 != j) && (21 != j) && (40 != j) && (41 != j)) {
        break label90;
      }
    }
    for (;;)
    {
      i = ContactUtils.a(j, (int)paramGetOnlineInfoResp.iTermType);
      if ((i == 0) || (i == 6)) {
        break label97;
      }
      return paramGetOnlineInfoResp.strTermDesc;
      i = 0;
      break;
      label90:
      if (i == 0) {}
    }
    label97:
    return null;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteSyncContact | mobileNo = " + c(paramString));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().delete(dco.a(c()), "sourceid=?", new String[] { paramString });
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
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 190	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 158	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 906
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 212	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 228 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 241 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 256 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: ldc_w 908
    //   82: aload_1
    //   83: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 15
    //   103: iconst_2
    //   104: ldc_w 910
    //   107: aload_3
    //   108: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 256 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 15
    //   132: iconst_2
    //   133: ldc_w 908
    //   136: aload_1
    //   137: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 256 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 15
    //   166: iconst_2
    //   167: ldc_w 908
    //   170: aload_2
    //   171: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	java.lang.Exception
    //   181	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
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
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getResources().getString(2131364342), new Object[] { str1, paramGetOnlineInfoResp });
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364346);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364348);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364346);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364349);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364346);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364350);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364347);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131364351);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new dcj(this));
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
    return (!str.toLowerCase().contains("samsung")) && (!str.toLowerCase().contains("oppo"));
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager
 * JD-Core Version:    0.7.0.1
 */