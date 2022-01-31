package com.tencent.mobileqq.app;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.CircleFriendInfo;
import SecurityAccountServer.MobileContactsDetailInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ContentUris;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.ContactsContract.Contacts;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.activity.voip.VoipContact;
import com.tencent.mobileqq.activity.voip.VoipPhoneNumber;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.data.RecommendContact;
import com.tencent.mobileqq.data.RecommendContactMsg;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.RecommendMessage;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fei;
import fek;
import fel;
import fem;
import fen;
import feo;
import fep;
import feq;
import fer;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class PhoneContactManagerImp
  implements PhoneContactManager
{
  static final long jdField_a_of_type_Long = 120000L;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "data1", "display_name", "contact_id" };
  public static boolean c = false;
  private static final boolean f = true;
  public volatile int a;
  public SharedPreferences a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new fei(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Hashtable jdField_a_of_type_JavaUtilHashtable = null;
  private List jdField_a_of_type_JavaUtilList;
  public Vector a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public long b;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private String jdField_b_of_type_JavaLangString;
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private List jdField_b_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_b_of_type_Boolean;
  public long c;
  private String jdField_c_of_type_JavaLangString = "";
  private Hashtable jdField_c_of_type_JavaUtilHashtable = new Hashtable();
  private List jdField_c_of_type_JavaUtilList = null;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public long d;
  private Hashtable jdField_d_of_type_JavaUtilHashtable = new Hashtable();
  private List jdField_d_of_type_JavaUtilList = null;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean d;
  private Hashtable jdField_e_of_type_JavaUtilHashtable = new Hashtable();
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_e_of_type_Boolean = false;
  
  static
  {
    jdField_c_of_type_Boolean = false;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info_global", 0);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("session_id", "").getBytes();
    this.jdField_b_of_type_JavaLangString = d();
    this.jdField_a_of_type_Int = a(a());
    paramQQAppInterface = (ContactSyncManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
  
  private int a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "getSelfBindState : " + this.jdField_b_of_type_JavaLangString + " " + paramRespondQueryQQBindingStat.mobileNo + " " + paramRespondQueryQQBindingStat.originBinder + " " + paramRespondQueryQQBindingStat.MobileUniqueNo + " " + paramRespondQueryQQBindingStat.lastUsedFlag + " " + paramRespondQueryQQBindingStat.isRecommend + " " + paramRespondQueryQQBindingStat.bindingTime);
      }
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo)) {
        return 1;
      }
      if ((paramRespondQueryQQBindingStat.originBinder == 2L) || (paramRespondQueryQQBindingStat.originBinder == 3L)) {
        return 2;
      }
    } while (paramRespondQueryQQBindingStat.originBinder != 1L);
    if (paramRespondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
      paramRespondQueryQQBindingStat.MobileUniqueNo = null;
    }
    if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 4;
    }
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 7;
    }
    return 3;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if ((c1 == ' ') || (c1 == '-')) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c1);
      }
    }
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 22);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("getRecommendedTimeStamp", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L));
    localNewIntent.putExtra("session_id", new byte[0]);
    localNewIntent.putExtra("recommend_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("queryContactTimeStamp", paramLong).commit();
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = paramArrayList;
    if (paramArrayList == null) {
      localArrayList = new ArrayList(0);
    }
    paramArrayList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    paramArrayList.putExtra("req_type", 14);
    paramArrayList.putExtra("unique_phone_no", paramString);
    paramArrayList.putExtra("next_flag", 0L);
    paramArrayList.putExtra("upload_package_no", 0);
    paramArrayList.putExtra("contact_list", localArrayList);
    paramArrayList.putExtra("session_id", new byte[0]);
    paramArrayList.putExtra("is_resend", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramArrayList);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  private boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i = a(paramRespondQueryQQBindingStat);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "syncBindState newState = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = i;
      }
      return bool1;
      if (this.jdField_a_of_type_Int != i) {
        r();
      }
      this.jdField_a_of_type_Int = i;
      continue;
      if (paramRespondQueryQQBindingStat.lastUsedFlag == 2L) {
        bool1 = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = i;
        break;
        bool1 = bool2;
        if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L)
        {
          r();
          bool1 = bool2;
        }
      }
      this.jdField_a_of_type_Int = i;
    }
  }
  
  private Hashtable b()
  {
    Hashtable localHashtable = new Hashtable();
    Iterator localIterator = ((List)c().get(0)).iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      localHashtable.put(localPhoneContact.mobileCode, localPhoneContact);
    }
    return localHashtable;
  }
  
  private Hashtable c()
  {
    Hashtable localHashtable = new Hashtable();
    Object localObject1 = c();
    Object localObject2 = (List)((List)localObject1).get(0);
    localObject1 = (List)((List)localObject1).get(1);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
      localHashtable.put(localPhoneContact.mobileNo, localPhoneContact);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PhoneContact)((Iterator)localObject1).next();
      localHashtable.put(((PhoneContact)localObject2).mobileNo, localObject2);
    }
    return localHashtable;
  }
  
  private void c(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fer(this, paramList));
  }
  
  private String d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contact_bind_info_unique", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return localObject1;
    }
    Object localObject2 = e();
    localObject1 = localObject2;
    if (((String)localObject2).equals("|")) {
      localObject1 = e();
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("|"))
    {
      localObject1 = new Random();
      localObject2 = ((Random)localObject1).nextLong() + "|" + ((Random)localObject1).nextLong();
    }
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putString("contact_bind_info_unique", (String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    return localObject2;
  }
  
  private static String d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = "#";; paramString = String.valueOf(paramString.charAt(0)).toUpperCase())
    {
      String str = paramString;
      if (!StringUtil.c(paramString.charAt(0))) {
        str = "#";
      }
      return str;
    }
  }
  
  private String e()
  {
    try
    {
      str1 = ((TelephonyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("phone")).getDeviceId();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str1;
          String str2 = ((WifiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("wifi")).getConnectionInfo().getMacAddress();
          return str1 + "|" + str2;
          localException1 = localException1;
          Object localObject1 = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  private List e()
  {
    if (this.jdField_a_of_type_JavaUtilVector == null) {}
    while (this.jdField_a_of_type_JavaUtilVector.size() <= 0) {
      return null;
    }
    Object localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilVector.size());
    Object localObject1 = this.jdField_a_of_type_JavaUtilVector.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (RecommendContact)((Iterator)localObject1).next();
      if (!((RecommendContact)localObject3).isRead) {
        ((ArrayList)localObject2).add(localObject3);
      }
    }
    localObject1 = new ArrayList(((ArrayList)localObject2).size());
    ((ArrayList)localObject1).addAll((Collection)localObject2);
    int i = ((ArrayList)localObject1).size() - 1;
    if (i >= 0)
    {
      localObject2 = (RecommendContact)((ArrayList)localObject1).get(i);
      if (((RecommendContact)localObject2).type == 0)
      {
        localObject3 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((RecommendContact)localObject2).key);
        if ((localObject3 != null) && (((PhoneContact)localObject3).uin != null)) {
          break label161;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label161:
        ((RecommendContact)localObject2).nationCode = ((PhoneContact)localObject3).nationCode;
        ((RecommendContact)localObject2).mobileCode = ((PhoneContact)localObject3).mobileCode;
        ((RecommendContact)localObject2).contactName = ((PhoneContact)localObject3).name;
        ((RecommendContact)localObject2).uin = ((PhoneContact)localObject3).uin;
        ((RecommendContact)localObject2).nickName = ((PhoneContact)localObject3).nickName;
        ((RecommendContact)localObject2).originBinder = ((PhoneContact)localObject3).originBinder;
        localObject3 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(((PhoneContact)localObject3).uin);
        if ((localObject3 != null) && (((Friends)localObject3).groupid >= 0))
        {
          if ((((Friends)localObject3).remark != null) && (((Friends)localObject3).remark.length() > 0)) {
            ((RecommendContact)localObject2).nickName = ((Friends)localObject3).remark;
          } else if ((((Friends)localObject3).name != null) && (((Friends)localObject3).name.length() > 0)) {
            ((RecommendContact)localObject2).nickName = ((Friends)localObject3).name;
          }
        }
        else {
          ((RecommendContact)localObject2).uin = "0";
        }
      }
    }
    return localObject1;
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    a(0L);
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      h();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_a_of_type_Int = 9;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 18);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("time_stamp", this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L));
    localNewIntent.putExtra("session_id", new byte[0]);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_JavaUtilHashtable != null)
    {
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      this.jdField_a_of_type_JavaUtilHashtable = null;
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "updateRecommandList " + this.jdField_a_of_type_JavaUtilVector.size());
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_JavaUtilVector.size() - 1;
    if (i >= 0)
    {
      RecommendContact localRecommendContact = (RecommendContact)this.jdField_a_of_type_JavaUtilVector.get(i);
      String str;
      if (localRecommendContact.type == 0)
      {
        str = localRecommendContact.key;
        if ((str != null) && (str.length() > 0))
        {
          PhoneContact localPhoneContact = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if ((localPhoneContact != null) && (!TextUtils.isEmpty(localPhoneContact.uin)) && (!localHashSet.contains(str))) {
            break label175;
          }
          localArrayList.add(localRecommendContact);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localRecommendContact);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label175:
        localHashSet.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "updateRecommandList delList size :" + localArrayList.size());
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilVector.removeAll(localArrayList);
      b(false);
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "initRecommendList");
    }
    if ((this.jdField_a_of_type_JavaUtilVector == null) || (!this.jdField_a_of_type_JavaUtilVector.isEmpty())) {}
    List localList;
    do
    {
      return;
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class);
    } while ((localList == null) || (localList.isEmpty()));
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.addAll(localList);
        if (NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
        {
          bool = true;
          b(bool);
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("contact_bind_info_upload", false).commit();
    s();
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.jdField_b_of_type_Boolean = false;
    a(0L);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    d();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      h();
      o();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilVector.size();
  }
  
  public RespondQueryQQBindingStat a()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences == null) {}
    do
    {
      return null;
      localRespondQueryQQBindingStat.nationCode = localSharedPreferences.getString("contact_bind_info_nation", null);
    } while (localRespondQueryQQBindingStat.nationCode == null);
    localRespondQueryQQBindingStat.mobileNo = localSharedPreferences.getString("contact_bind_info_mobile", "");
    localRespondQueryQQBindingStat.MobileUniqueNo = localSharedPreferences.getString("contact_bind_info_imei", "");
    localRespondQueryQQBindingStat.isRecommend = localSharedPreferences.getLong("contact_bind_info_recommend", 0L);
    localRespondQueryQQBindingStat.originBinder = localSharedPreferences.getLong("contact_bind_info_origin", 0L);
    localRespondQueryQQBindingStat.bindingTime = localSharedPreferences.getLong("contact_bind_info_time", 0L);
    localRespondQueryQQBindingStat.lastUsedFlag = localSharedPreferences.getLong("contact_bind_info_flag", 0L);
    return localRespondQueryQQBindingStat;
  }
  
  public VoipContact a(String paramString1, String paramString2, String paramString3)
  {
    return new VoipContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramString3);
  }
  
  public PhoneContact a(int paramInt)
  {
    String str = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jdField_b_of_type_JavaUtilHashtable.isEmpty()) {
      b();
    }
    if ((this.jdField_b_of_type_JavaUtilHashtable != null) && (this.jdField_b_of_type_JavaUtilHashtable.size() > 0)) {
      return (PhoneContact)this.jdField_b_of_type_JavaUtilHashtable.get(str);
    }
    return null;
  }
  
  public PhoneContact a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    PhoneContact localPhoneContact;
    do
    {
      return localObject;
      if (this.jdField_c_of_type_JavaUtilHashtable.isEmpty()) {
        b();
      }
      if (this.jdField_c_of_type_JavaUtilHashtable.size() <= 0) {
        break;
      }
      localPhoneContact = (PhoneContact)this.jdField_c_of_type_JavaUtilHashtable.get(paramString);
      localObject = localPhoneContact;
    } while (localPhoneContact != null);
    paramString = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, paramString);
    paramString = ContactsContract.Contacts.lookupContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver(), paramString);
    if (paramString == null) {
      return null;
    }
    return a((int)ContentUris.parseId(paramString));
    return null;
  }
  
  public RecommendContact a()
  {
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0) {
      return (RecommendContact)this.jdField_a_of_type_JavaUtilVector.get(this.jdField_a_of_type_JavaUtilVector.size() - 1);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public Hashtable a()
  {
    if (this.jdField_b_of_type_JavaUtilHashtable.isEmpty()) {
      b();
    }
    return this.jdField_b_of_type_JavaUtilHashtable;
  }
  
  public List a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactManager", 2, localException.toString());
        }
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
          if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.nationCode)) {
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.nationCode + localPhoneContact.mobileCode, localPhoneContact);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "No contacts.");
      }
      this.jdField_b_of_type_Boolean = true;
      d();
      q();
      o();
    }
  }
  
  public void a(long paramLong1, long paramLong2, List paramList1, List paramList2)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          this.jdField_a_of_type_JavaUtilList = paramList1;
          if (this.jdField_b_of_type_JavaUtilList == null)
          {
            this.jdField_b_of_type_JavaUtilList = paramList2;
            if (paramLong1 == 4294967295L) {
              break label76;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
          continue;
        }
        this.jdField_b_of_type_JavaUtilList.addAll(paramList2);
      }
      finally {}
      continue;
      label76:
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "saveContactFromServer(" + this.jdField_a_of_type_JavaUtilList.size() + ", " + this.jdField_b_of_type_JavaUtilList.size() + ")");
      }
      paramLong1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
      a(paramLong2);
      Object localObject1;
      if ((paramLong1 != 0L) && (paramLong1 != paramLong2))
      {
        this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        paramList1.a();
        try
        {
          paramList2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.elements();
          while (paramList2.hasMoreElements())
          {
            localObject1 = (PhoneContact)paramList2.nextElement();
            if ((((PhoneContact)localObject1).uin != null) && (((PhoneContact)localObject1).uin.length() > 0))
            {
              ((PhoneContact)localObject1).bindingDate = 0L;
              ((PhoneContact)localObject1).isRecommend = 0;
              ((PhoneContact)localObject1).uin = "";
              ((PhoneContact)localObject1).originBinder = 0L;
              ((PhoneContact)localObject1).ability = 0;
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
            }
          }
        }
        finally
        {
          paramList1.b();
        }
        paramList1.b();
      }
      if (((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) || ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0)))
      {
        paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        paramList2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        try
        {
          paramList1.a();
          if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
          {
            localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (MobileContactsDetailInfo)((Iterator)localObject1).next();
              PhoneContact localPhoneContact = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsDetailInfo)localObject2).originMobileNo);
              if (localPhoneContact != null)
              {
                localPhoneContact.uin = ((MobileContactsDetailInfo)localObject2).QQ;
                localPhoneContact.nationCode = ((MobileContactsDetailInfo)localObject2).nationCode;
                localPhoneContact.mobileCode = ((MobileContactsDetailInfo)localObject2).mobileCode;
                localPhoneContact.bindingDate = ((MobileContactsDetailInfo)localObject2).bindingDate;
                localPhoneContact.nickName = ((MobileContactsDetailInfo)localObject2).nickname;
                localPhoneContact.isUploaded = true;
                localPhoneContact.originBinder = ((MobileContactsDetailInfo)localObject2).originBinder;
                localPhoneContact.ability = ((MobileContactsDetailInfo)localObject2).accountAbi;
                if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0")))
                {
                  localObject2 = paramList2.c(localPhoneContact.uin);
                  if (localObject2 != null) {
                    localPhoneContact.nickName = ((Friends)localObject2).name;
                  }
                  this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
                  paramList2.a(localPhoneContact.nationCode + localPhoneContact.mobileCode, false);
                }
                if (!TextUtils.isEmpty(localPhoneContact.nationCode)) {
                  this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.nationCode + localPhoneContact.mobileCode, localPhoneContact);
                }
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
              }
            }
          }
          if (this.jdField_b_of_type_JavaUtilList == null) {
            break label838;
          }
        }
        finally
        {
          paramList1.b();
        }
        if (this.jdField_b_of_type_JavaUtilList.size() > 0)
        {
          paramList2 = this.jdField_b_of_type_JavaUtilList.iterator();
          while (paramList2.hasNext())
          {
            localObject1 = (MobileContactsDetailInfo)paramList2.next();
            localObject1 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsDetailInfo)localObject1).originMobileNo);
            if (localObject1 != null)
            {
              if ((((PhoneContact)localObject1).uin != null) && (!((PhoneContact)localObject1).uin.equals("0"))) {
                this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PhoneContact)localObject1).uin);
              }
              ((PhoneContact)localObject1).uin = "";
              ((PhoneContact)localObject1).isUploaded = true;
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
            }
          }
        }
        label838:
        paramList1.c();
        paramList1.b();
      }
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
        p();
      }
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList = null;
    }
  }
  
  public void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = a(a());
    }
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = paramRespondQueryQQBindingStat;
    if (paramRespondQueryQQBindingStat == null) {
      localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    }
    paramRespondQueryQQBindingStat = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", localRespondQueryQQBindingStat.mobileNo);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", localRespondQueryQQBindingStat.nationCode);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", localRespondQueryQQBindingStat.MobileUniqueNo);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", localRespondQueryQQBindingStat.isRecommend);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", localRespondQueryQQBindingStat.originBinder);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", localRespondQueryQQBindingStat.bindingTime);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", localRespondQueryQQBindingStat.lastUsedFlag);
    paramRespondQueryQQBindingStat.commit();
    if (a(localRespondQueryQQBindingStat)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new feq(this));
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 16);
    localNewIntent.putExtra("verify_smscode", paramString);
    localNewIntent.putExtra("session_id", this.jdField_a_of_type_ArrayOfByte);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 13);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          RecommendContactMsg localRecommendContactMsg = (RecommendContactMsg)paramList.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
          if (localIterator.hasNext())
          {
            RecommendContact localRecommendContact = (RecommendContact)localIterator.next();
            if ((!localRecommendContact.key.equals(localRecommendContactMsg.mobileNo)) && (!localRecommendContact.key.equals(localRecommendContactMsg.uin))) {
              break;
            }
            if (!localRecommendContact.isRead)
            {
              localRecommendContact.isRead = true;
              localArrayList.add(localRecommendContact);
            }
          }
        }
      }
    }
    b(false);
    c(localArrayList);
  }
  
  public void a(List paramList, long paramLong)
  {
    if ((paramList != null) && (paramList.size() != 0)) {
      for (;;)
      {
        int i;
        synchronized (this.jdField_a_of_type_JavaUtilVector)
        {
          EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
          try
          {
            localEntityTransaction.a();
            i = paramList.size() - 1;
            if (i >= 0)
            {
              MobileContactsDetailInfo localMobileContactsDetailInfo = (MobileContactsDetailInfo)paramList.get(i);
              if (localMobileContactsDetailInfo != null)
              {
                localPhoneContact = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localMobileContactsDetailInfo.originMobileNo);
                if (localPhoneContact == null) {
                  break label510;
                }
                if (!TextUtils.isEmpty(localPhoneContact.nationCode)) {
                  this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localPhoneContact.nationCode + localPhoneContact.mobileCode);
                }
                localPhoneContact.uin = localMobileContactsDetailInfo.QQ;
                localPhoneContact.nationCode = localMobileContactsDetailInfo.nationCode;
                localPhoneContact.mobileCode = localMobileContactsDetailInfo.mobileCode;
                localPhoneContact.bindingDate = localMobileContactsDetailInfo.bindingDate;
                localPhoneContact.nickName = localMobileContactsDetailInfo.nickname;
                localPhoneContact.originBinder = localMobileContactsDetailInfo.originBinder;
                localPhoneContact.ability = localMobileContactsDetailInfo.accountAbi;
                if (!TextUtils.isEmpty(localPhoneContact.nationCode)) {
                  this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.nationCode + localPhoneContact.mobileCode, localPhoneContact);
                }
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
                if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
                  this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
                }
                if (((localMobileContactsDetailInfo.QQ != null) && (localMobileContactsDetailInfo.QQ.length() != 0) && (!localMobileContactsDetailInfo.QQ.equals("0"))) || ((RecommendContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class, String.valueOf(localMobileContactsDetailInfo.originMobileNo)) != null)) {
                  break label510;
                }
                RecommendContact localRecommendContact = new RecommendContact();
                localRecommendContact.mobileNo = localMobileContactsDetailInfo.originMobileNo;
                localRecommendContact.uin = localPhoneContact.uin;
                localRecommendContact.timeStamp = paramLong;
                localRecommendContact.isRead = false;
                localRecommendContact.type = 0;
                localRecommendContact.key = localMobileContactsDetailInfo.originMobileNo;
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localRecommendContact);
                if (this.jdField_a_of_type_JavaUtilVector.contains(localRecommendContact)) {
                  break label510;
                }
                this.jdField_a_of_type_JavaUtilVector.add(localRecommendContact);
                break label510;
              }
            }
            else
            {
              localEntityTransaction.c();
              localEntityTransaction.b();
              NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
              d();
              p();
              b(false);
              i();
              return;
            }
          }
          finally
          {
            localEntityTransaction.b();
          }
        }
        PhoneContact localPhoneContact = null;
        continue;
        label510:
        i -= 1;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "onFirstQueryResp" + jdField_c_of_type_Boolean);
    }
    for (;;)
    {
      int i;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          i = d();
          bool = d();
          if ((i != 7) || (bool)) {
            break label111;
          }
          e();
          return true;
          if (!h()) {
            continue;
          }
          a(true);
        }
      }
      return false;
      label111:
      if ((i != 4) || (!bool)) {}
    }
  }
  
  public int b()
  {
    return d();
  }
  
  public PhoneContact b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      if (this.jdField_d_of_type_JavaUtilHashtable.isEmpty()) {
        b();
      }
    } while ((this.jdField_d_of_type_JavaUtilHashtable == null) || (this.jdField_d_of_type_JavaUtilHashtable.size() <= 0));
    return (PhoneContact)this.jdField_d_of_type_JavaUtilHashtable.get(paramString);
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (localEntityManager == null) {
        return null;
      }
      PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localEntityManager.a(PhoneNumInfo.class, paramString);
      if (localPhoneNumInfo != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPhoneNumInfo.uin);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneNumInfo.uin, paramString);
      }
      localEntityManager.a();
    }
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashtable.clear();
    this.jdField_d_of_type_JavaUtilHashtable.clear();
    this.jdField_e_of_type_JavaUtilHashtable.clear();
    this.jdField_c_of_type_JavaUtilHashtable.clear();
    if ((this.jdField_a_of_type_JavaUtilHashtable == null) || (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) || (this.jdField_a_of_type_JavaUtilHashtable.size() == 0))
    {
      System.out.println("cuiyl return 0 ");
      return localArrayList;
    }
    System.out.println("cuiyl begin merge ");
    Enumeration localEnumeration = this.jdField_a_of_type_JavaUtilHashtable.elements();
    Hashtable localHashtable = b();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject3 = (PhoneContact)localEnumeration.nextElement();
      if (!((PhoneContact)localObject3).allPhoneNumber.isEmpty())
      {
        Object localObject1 = null;
        Iterator localIterator = ((PhoneContact)localObject3).allPhoneNumber.iterator();
        Object localObject2;
        while (localIterator.hasNext())
        {
          VoipPhoneNumber localVoipPhoneNumber = (VoipPhoneNumber)localIterator.next();
          localObject2 = (PhoneContact)localHashtable.get(localVoipPhoneNumber.a);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ((PhoneContact)localObject2).mobileNo = localVoipPhoneNumber.a;
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null)
        {
          ((PhoneContact)localObject1).allPhoneNumber = ((PhoneContact)localObject3).allPhoneNumber;
          ((PhoneContact)localObject1).photoUri = ((PhoneContact)localObject3).photoUri;
          ((PhoneContact)localObject1).lookupID = ((PhoneContact)localObject3).lookupID;
          this.jdField_b_of_type_JavaUtilHashtable.put(String.format("%d", new Object[] { Integer.valueOf(((PhoneContact)localObject1).contactID) }), localObject1);
          this.jdField_c_of_type_JavaUtilHashtable.put(((PhoneContact)localObject1).lookupID, localObject1);
          if ((((PhoneContact)localObject1).uin != null) && (((PhoneContact)localObject1).uin.length() > 0) && (!((PhoneContact)localObject1).uin.equals("0"))) {
            this.jdField_d_of_type_JavaUtilHashtable.put(((PhoneContact)localObject1).uin, localObject1);
          }
          localObject2 = ((PhoneContact)localObject1).allPhoneNumber.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (VoipPhoneNumber)((Iterator)localObject2).next();
            this.jdField_e_of_type_JavaUtilHashtable.put(((VoipPhoneNumber)localObject3).a, localObject1);
            this.jdField_e_of_type_JavaUtilHashtable.put(((VoipPhoneNumber)localObject3).jdField_c_of_type_JavaLangString, localObject1);
          }
          localArrayList.add(localObject1);
        }
        else
        {
          if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(String.format("%d", new Object[] { Integer.valueOf(((PhoneContact)localObject3).contactID) })))
          {
            this.jdField_b_of_type_JavaUtilHashtable.put(String.format("%d", new Object[] { Integer.valueOf(((PhoneContact)localObject3).contactID) }), localObject3);
            this.jdField_c_of_type_JavaUtilHashtable.put(((PhoneContact)localObject3).lookupID, localObject3);
            localArrayList.add(localObject3);
          }
          localObject1 = ((PhoneContact)localObject3).allPhoneNumber.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (VoipPhoneNumber)((Iterator)localObject1).next();
            this.jdField_e_of_type_JavaUtilHashtable.put(((VoipPhoneNumber)localObject2).a, localObject3);
            this.jdField_e_of_type_JavaUtilHashtable.put(((VoipPhoneNumber)localObject2).jdField_c_of_type_JavaLangString, localObject3);
          }
        }
      }
    }
    Collections.sort(localArrayList, new fek(this));
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_c_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 12);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new feo(this, paramString));
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = paramList.isEmpty();
        if (bool) {
          return;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityTransaction.c();
      }
      finally {}
      localEntityTransaction.b();
    }
  }
  
  public void b(List paramList, long paramLong)
  {
    EntityTransaction localEntityTransaction;
    if ((paramList != null) && (paramList.size() > 0)) {
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    for (;;)
    {
      int i;
      try
      {
        localEntityTransaction.a();
        i = paramList.size() - 1;
        if (i >= 0)
        {
          CircleFriendInfo localCircleFriendInfo = (CircleFriendInfo)paramList.get(i);
          if ((localCircleFriendInfo != null) && (localCircleFriendInfo.uin >= 0L) && ((RecommendContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class, String.valueOf(localCircleFriendInfo.uin)) == null))
          {
            RecommendContact localRecommendContact = new RecommendContact();
            localRecommendContact.uin = String.valueOf(localCircleFriendInfo.uin);
            localRecommendContact.nickName = localCircleFriendInfo.strRemark;
            localRecommendContact.source = localCircleFriendInfo.source;
            localRecommendContact.timeStamp = paramLong;
            localRecommendContact.type = 1;
            localRecommendContact.isRead = false;
            localRecommendContact.key = String.valueOf(localCircleFriendInfo.uin);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localRecommendContact);
            if (!this.jdField_a_of_type_JavaUtilVector.contains(localRecommendContact)) {
              this.jdField_a_of_type_JavaUtilVector.add(localRecommendContact);
            }
          }
        }
        else
        {
          localEntityTransaction.c();
          return;
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
      i -= 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      RecommendMessage localRecommendMessage = new RecommendMessage(e(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(localRecommendMessage);
    }
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public PhoneContact c(String paramString)
  {
    PhoneContact localPhoneContact2 = null;
    PhoneContact localPhoneContact1;
    if (paramString == null) {
      localPhoneContact1 = localPhoneContact2;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localPhoneContact1;
              if (this.jdField_e_of_type_JavaUtilHashtable.isEmpty()) {
                b();
              }
              localPhoneContact1 = localPhoneContact2;
            } while (this.jdField_e_of_type_JavaUtilHashtable == null);
            localPhoneContact1 = localPhoneContact2;
          } while (this.jdField_e_of_type_JavaUtilHashtable.size() <= 0);
          localPhoneContact2 = (PhoneContact)this.jdField_e_of_type_JavaUtilHashtable.get(paramString);
          localPhoneContact1 = localPhoneContact2;
        } while (localPhoneContact2 != null);
        paramString = new VoipPhoneNumber(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        localPhoneContact1 = localPhoneContact2;
      } while (paramString.jdField_c_of_type_JavaLangString == null);
      localPhoneContact1 = localPhoneContact2;
    } while (paramString.jdField_c_of_type_JavaLangString.length() <= 0);
    return (PhoneContact)this.jdField_e_of_type_JavaUtilHashtable.get(paramString.jdField_c_of_type_JavaLangString);
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String c(String paramString)
  {
    Object localObject = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (localObject == null) {
      return null;
    }
    paramString = (PhoneNumInfo)((EntityManager)localObject).a(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public List c()
  {
    Object localObject1 = null;
    long l = System.currentTimeMillis();
    Object localObject2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    FriendManager localFriendManager;
    if (this.jdField_c_of_type_JavaUtilList == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      Collections.sort((List)localObject2, new fel(this));
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (((List)localObject2).size() > 0) {
        if (a() != null) {}
      }
    }
    label296:
    label370:
    do
    {
      return localObject1;
      String str = a().mobileNo;
      Iterator localIterator = ((List)localObject2).iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = (PhoneContact)localIterator.next();
        if ((str == null) || (!str.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
        {
          PhoneContact localPhoneContact = (PhoneContact)((PhoneContact)localObject2).clone();
          if (localPhoneContact.pinyinFirst == null) {
            localPhoneContact.pinyinFirst = d(localPhoneContact.pinyinInitial);
          }
          if (TextUtils.isEmpty(localPhoneContact.uin))
          {
            if (localObject1 == null) {
              localObject1 = localPhoneContact;
            }
            for (;;)
            {
              break;
              if (localPhoneContact.contactID == ((PhoneContact)localObject1).contactID)
              {
                ((PhoneContact)localObject1).mobileNo = (((PhoneContact)localObject1).mobileNo + "|" + localPhoneContact.mobileNo);
              }
              else
              {
                localArrayList2.add(localObject1);
                localObject1 = localPhoneContact;
              }
            }
          }
          if (localPhoneContact.uin.equals("0"))
          {
            localObject2 = null;
            if ((localObject2 == null) || (((Friends)localObject2).groupid < 0)) {
              break label370;
            }
            localPhoneContact.nickName = ContactSorter.a((Friends)localObject2);
            localPhoneContact.remark = ((Friends)localObject2).remark;
            localPhoneContact.faceUrl = Short.toString(((Friends)localObject2).faceid);
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localFriendManager.c(localPhoneContact.uin);
            break label296;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new fem(this);
      Collections.sort(localArrayList1, (Comparator)localObject1);
      Collections.sort(localArrayList2, (Comparator)localObject1);
      this.jdField_c_of_type_JavaUtilList = localArrayList1;
      this.jdField_d_of_type_JavaUtilList = localArrayList2;
      localObject2 = new ArrayList();
      ((List)localObject2).add(this.jdField_c_of_type_JavaUtilList);
      ((List)localObject2).add(this.jdField_d_of_type_JavaUtilList);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("PhoneContactManager", 2, "sort contact cost time: " + (System.currentTimeMillis() - l));
    return localObject2;
  }
  
  public void c()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void c(String paramString1, String paramString2)
  {
    int i = 0;
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      paramString1 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString1 != null)
      {
        int j = 1;
        paramString1.uin = paramString2;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString1);
        i = j;
        if (!TextUtils.isEmpty(paramString1.uin))
        {
          i = j;
          if (!paramString1.uin.equals("0"))
          {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
            i = j;
          }
        }
      }
      localEntityTransaction.c();
      localEntityTransaction.b();
      if (i != 0) {}
      return;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public boolean c()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    switch (localPhoneContactManagerImp.b())
    {
    case 5: 
    default: 
      return true;
    case 0: 
    case 4: 
    case 6: 
    case 7: 
      return true;
    case 1: 
    case 2: 
      return false;
    }
    return localPhoneContactManagerImp.i();
  }
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      this.jdField_a_of_type_Int = a(a());
      return d();
    case 6: 
      return 6;
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return 7;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public PhoneContact d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (PhoneContact)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public List d()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (;;)
    {
      HashSet localHashSet;
      int i;
      Object localObject2;
      RecommendContactMsg localRecommendContactMsg;
      Object localObject1;
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactManager", 2, "getRecommendContactList size is " + this.jdField_a_of_type_JavaUtilVector.size());
        }
        localArrayList2.addAll(this.jdField_a_of_type_JavaUtilVector);
        if (localArrayList2.isEmpty()) {
          return null;
        }
        localHashSet = new HashSet();
        i = localArrayList2.size() - 1;
        if (i < 0) {
          break label696;
        }
        localObject2 = (RecommendContact)localArrayList2.get(i);
        localRecommendContactMsg = new RecommendContactMsg();
        if ((((RecommendContact)localObject2).type != 1) || (((RecommendContact)localObject2).uin == null) || (((RecommendContact)localObject2).uin.length() <= 0)) {
          break label353;
        }
        if (localObject2 == null) {
          break label712;
        }
        localRecommendContactMsg.timeStamp = ((RecommendContact)localObject2).timeStamp;
        localRecommendContactMsg.uin = ((RecommendContact)localObject2).uin;
        localRecommendContactMsg.nickName = ((RecommendContact)localObject2).nickName;
        localRecommendContactMsg.source = ((RecommendContact)localObject2).source;
        localRecommendContactMsg.isRead = ((RecommendContact)localObject2).isRead;
        localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localObject1 != null) && (((FriendManager)localObject1).b(localRecommendContactMsg.uin)))
        {
          localRecommendContactMsg.friendStatus = 2;
          if (!localHashSet.add(localRecommendContactMsg.uin)) {
            break label712;
          }
          localArrayList1.add(localRecommendContactMsg);
          break label712;
        }
        if ((localObject1 != null) && ((((FriendManager)localObject1).e(localRecommendContactMsg.uin)) || (((FriendManager)localObject1).e(localRecommendContactMsg.nationCode + localRecommendContactMsg.mobileCode)))) {
          localRecommendContactMsg.friendStatus = 1;
        }
      }
      localRecommendContactMsg.friendStatus = 0;
      continue;
      label353:
      if (((RecommendContact)localObject2).type == 0)
      {
        localObject1 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((RecommendContact)localObject2).key);
        if ((localObject1 != null) && (((PhoneContact)localObject1).uin != null))
        {
          localRecommendContactMsg.timeStamp = ((RecommendContact)localObject2).timeStamp;
          localRecommendContactMsg.mobileNo = ((RecommendContact)localObject2).key;
          localRecommendContactMsg.nationCode = ((PhoneContact)localObject1).nationCode;
          localRecommendContactMsg.mobileCode = ((PhoneContact)localObject1).mobileCode;
          localRecommendContactMsg.contactName = ((PhoneContact)localObject1).name;
          localRecommendContactMsg.uin = ((PhoneContact)localObject1).uin;
          localRecommendContactMsg.nickName = ((PhoneContact)localObject1).nickName;
          localRecommendContactMsg.isRead = ((RecommendContact)localObject2).isRead;
          localRecommendContactMsg.originBinder = ((PhoneContact)localObject1).originBinder;
          localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          localObject1 = ((FriendManager)localObject2).c(((PhoneContact)localObject1).uin);
          if ((localObject1 != null) && (((Friends)localObject1).groupid >= 0)) {
            if ((((Friends)localObject1).remark != null) && (((Friends)localObject1).remark.length() > 0))
            {
              localRecommendContactMsg.nickName = ((Friends)localObject1).remark;
              localRecommendContactMsg.faceid = ((Friends)localObject1).faceid;
              localRecommendContactMsg.groupId = ((Friends)localObject1).groupid;
              localRecommendContactMsg.friendStatus = 2;
            }
          }
          for (;;)
          {
            if (localHashSet.add(localRecommendContactMsg.mobileCode))
            {
              localList.add(localRecommendContactMsg);
              break label712;
              if ((((Friends)localObject1).name == null) || (((Friends)localObject1).name.length() <= 0)) {
                break;
              }
              localRecommendContactMsg.nickName = ((Friends)localObject1).name;
              break;
              localRecommendContactMsg.uin = "0";
              if (((FriendManager)localObject2).e(localRecommendContactMsg.nationCode + localRecommendContactMsg.mobileCode))
              {
                localRecommendContactMsg.friendStatus = 1;
              }
              else
              {
                localRecommendContactMsg.friendStatus = 0;
                continue;
                Collections.sort(localList, new fen(this));
                return localList;
              }
            }
          }
        }
      }
      label696:
      label712:
      i -= 1;
    }
  }
  
  public void d()
  {
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 100L);
    }
    localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactsInnerFrame.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(3);
      localHandler.sendEmptyMessageDelayed(3, 100L);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if ((localObject == null) || (!((String)localObject).equals(paramString2)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      PhoneNumInfo localPhoneNumInfo = new PhoneNumInfo();
      localPhoneNumInfo.phoneNum = paramString1;
      localPhoneNumInfo.uin = paramString2;
      if (localObject != null)
      {
        ((EntityManager)localObject).b(localPhoneNumInfo);
        ((EntityManager)localObject).a();
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("contact_bind_info_upload", false);
  }
  
  public PhoneContact e(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Int = 6;
      ArrayList localArrayList = new ArrayList(0);
      a(this.jdField_b_of_type_JavaLangString, localArrayList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    if (!"6.0.2".equals(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("phone_version_run", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_b_of_type_AndroidContentSharedPreferences.edit().remove("phone_app_first_run").commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
    }
  }
  
  public PhoneContact f(String paramString)
  {
    return (PhoneContact)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fep(this));
    }
  }
  
  public boolean f()
  {
    if (!"6.0.2".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("phone_contact_need_star_v", ""))) {}
    for (boolean bool = true; bool; bool = false)
    {
      int i = d();
      if ((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 6)) {
        break;
      }
      return false;
    }
    return bool;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "deleteRecommendListSync ");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class);
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public boolean g()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.R, 4000);
    if (localList == null) {
      return false;
    }
    int i = localList.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0) && ((localMessageRecord.msgtype == 1) || (localMessageRecord.msgtype == 0)) && (!localMessageRecord.isread)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_JavaUtilVector == null) || (this.jdField_a_of_type_JavaUtilVector.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteContactRecommendList ");
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
    i();
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).d();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class);
  }
  
  public boolean h()
  {
    int i = d();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + i);
    }
    return i >= 7;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendListView.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(0);
      }
    }
  }
  
  public boolean i()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Int != 6)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 3) {}
    }
    else
    {
      bool1 = bool2;
      if (a() != null)
      {
        bool1 = bool2;
        if (a().lastUsedFlag == 2L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "runPhoneContact");
    }
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("phone_version_run", "6.0.2");
    localEditor.commit();
  }
  
  public void k()
  {
    j();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("phone_contact_need_star_v", "6.0.2");
    localEditor.commit();
  }
  
  public void l()
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject1 = new NewFriendMessage(0, 0, false);
        ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a((NewFriendMessage)localObject1);
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        RecommendContact localRecommendContact = (RecommendContact)((Iterator)localObject1).next();
        if (!localRecommendContact.isRead) {
          localRecommendContact.isRead = true;
        }
      }
    }
    c(this.jdField_a_of_type_JavaUtilVector);
  }
  
  public void onDestroy()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */