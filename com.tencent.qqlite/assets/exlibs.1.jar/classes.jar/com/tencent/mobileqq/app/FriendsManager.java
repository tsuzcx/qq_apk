package com.tencent.mobileqq.app;

import MessageSvcPack.RequestPushFStatus;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import csw;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason;

public class FriendsManager
  implements Manager
{
  public static final int a = -100;
  private static final long jdField_a_of_type_Long = 500654080L;
  public static final String a = "Q.contacttab.";
  public static final String b = "Q.contacttab.friend";
  public static final String c = "Q.contacttab.extension";
  public static final String d = "Q.contacttab.group";
  private static final String jdField_e_of_type_JavaLangString = "add_friend_request_sp";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(6);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new csw(this);
  private boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private ConcurrentHashMap d = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap f = new ConcurrentHashMap(4);
  private ConcurrentHashMap g = null;
  
  public FriendsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    e();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "add_friend_request_sp", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private ConcurrentHashMap a(boolean paramBoolean)
  {
    label609:
    label612:
    label615:
    label618:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      int i;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Friends localFriends = (Friends)localIterator.next();
          if (localFriends.gathtertype != 1) {
            break label615;
          }
          i += 1;
          if (paramBoolean)
          {
            if (localFriends.gathtertype != 1) {}
          }
          else
          {
            if (localFriends.gathtertype == 0) {
              break label612;
            }
            if (localFriends.gathtertype == 2) {
              continue;
            }
          }
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            ContactSorter.a(localFriends);
          }
          String str = localFriends.groupid + "";
          localObject4 = (ArrayList)localConcurrentHashMap.get(str);
          Object localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = new ArrayList();
            localConcurrentHashMap.put(str, localObject1);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break label609;
            }
            localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label609;
            }
            Groups localGroups = (Groups)((Iterator)localObject4).next();
            if (localGroups.group_id != localFriends.groupid) {
              continue;
            }
            ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
          }
          ((ArrayList)localObject1).add(localFriends);
          if ((!paramBoolean) || ((localFriends.status != 10) && (localFriends.status != 11))) {
            break label618;
          }
          localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
          if (localObject1 == null) {
            ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          } else {
            ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(((Integer)localObject1).intValue() + 1));
          }
        }
      }
      finally {}
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            ContactSorter.b((ArrayList)localObject4);
          }
        }
      }
      if (paramBoolean) {
        this.e = ((ConcurrentHashMap)localObject5);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildNormalAndGatheredUiMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
        QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps end: , size:" + localConcurrentHashMap.size());
      }
      this.jdField_c_of_type_Int = i;
      return localConcurrentHashMap;
      continue;
      continue;
    }
  }
  
  private void a(Friends[] paramArrayOfFriends)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfFriends.length)
    {
      localArrayList.add(paramArrayOfFriends[i].uin);
      i += 1;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), localArrayList);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    c();
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_c_of_type_Boolean;
        if (bool) {
          return;
        }
        long l = System.currentTimeMillis();
        this.jdField_c_of_type_Boolean = true;
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, null, null);
        if (QLog.isColorLevel())
        {
          if (localArrayList == null)
          {
            i = 0;
            QLog.d("Q.contacttab.", 2, "nearby people card count = " + i);
            break label187;
            if (i < localArrayList.size())
            {
              NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localArrayList.get(i);
              if (localNearbyPeopleCard == null) {
                break label197;
              }
              a(localNearbyPeopleCard);
              break label197;
            }
          }
          else
          {
            i = localArrayList.size();
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("Q.contacttab.", 4, "initDateNickNameCache cost time:" + (System.currentTimeMillis() - l));
          continue;
        }
        if (localObject == null) {
          continue;
        }
      }
      finally {}
      label187:
      int i = 0;
      continue;
      label197:
      i += 1;
    }
  }
  
  private boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin empty uin");
      }
    }
    for (;;)
    {
      return false;
      if (paramString.length() >= 4) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin uin=" + paramString);
      }
    }
    return true;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.status;
    }
    return 10;
  }
  
  public Card a(String paramString)
  {
    return (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
  }
  
  public ContactCard a(String paramString)
  {
    return (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
  }
  
  public DateNickNameInfo a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {}
    do
    {
      return null;
      if (!this.jdField_c_of_type_Boolean) {
        f();
      }
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString));
    return (DateNickNameInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public ExtensionInfo a(String paramString)
  {
    return a(paramString, true);
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      ??? = null;
      return ???;
    }
    if (this.d != null) {}
    for (ExtensionInfo localExtensionInfo = (ExtensionInfo)this.d.get(paramString);; localExtensionInfo = null)
    {
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      if (!paramBoolean) {
        return null;
      }
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      ??? = localExtensionInfo;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, paramString);
      ??? = localExtensionInfo;
      if (localExtensionInfo == null) {
        break;
      }
      synchronized (this.d)
      {
        this.d.put(paramString, localExtensionInfo);
        return localExtensionInfo;
      }
    }
  }
  
  public Friends a(String paramString)
  {
    Object localObject = null;
    if (!f(paramString)) {}
    do
    {
      do
      {
        Friends localFriends;
        do
        {
          do
          {
            return localObject;
          } while (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null);
          localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = localFriends;
        } while (localFriends != null);
        localObject = localFriends;
      } while (this.jdField_a_of_type_Boolean);
      paramString = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
      if (paramString != null) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.uin, paramString);
      }
      localObject = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, "findFriendEntifyFromCache from db f=" + paramString);
    return paramString;
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1);
    paramString1.name = paramString2;
    paramString1.datetime = System.currentTimeMillis();
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ContactSorter.a(paramString1);
    return paramString1;
  }
  
  public Friends a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    paramString = b(paramString);
    if (paramString.richTime != paramLong) {
      paramString.setRichBuffer(paramArrayOfByte, paramLong);
    }
    return paramString;
  }
  
  public Groups a(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      localObject = null;
    }
    Groups localGroups;
    do
    {
      do
      {
        return localObject;
        localGroups = (Groups)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localGroups;
      } while (localGroups != null);
      localGroups = (Groups)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, paramString);
      localObject = localGroups;
    } while (localGroups == null);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localGroups);
    ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, localGroups);
    return localGroups;
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    Friends localFriends = c(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (localFriends.alias != null)
      {
        str = paramString;
        if (localFriends.alias.length() > 0) {
          str = localFriends.alias;
        }
      }
    }
    return str;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (((Friends)localObject).groupid == paramInt) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  protected ArrayList a(String paramString)
  {
    return (ArrayList)this.f.get(paramString);
  }
  
  public ConcurrentHashMap a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, Friends.class.getSimpleName(), false, "gathtertype=?", new String[] { String.valueOf(2) }, null, null, null, null);
    Object localObject1 = new ConcurrentHashMap();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Friends)((Iterator)localObject2).next();
        ((ConcurrentHashMap)localObject1).put(((Friends)localObject3).uin, localObject3);
      }
    }
    Object localObject3 = new ConcurrentHashMap(6);
    Iterator localIterator = ((ConcurrentHashMap)localObject1).values().iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      String str = localFriends.groupid + "";
      localObject2 = (ArrayList)((ConcurrentHashMap)localObject3).get(str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        ((ConcurrentHashMap)localObject3).put(str, localObject1);
      }
      ((ArrayList)localObject1).add(localFriends);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArrayList)((ConcurrentHashMap)localObject3).get(String.valueOf(((Groups)((Iterator)localObject1).next()).group_id));
        if (localObject2 != null) {
          ContactSorter.b((ArrayList)localObject2);
        }
      }
    }
    return localObject3;
  }
  
  public void a()
  {
    label530:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildUIMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label299;
        }
        Friends localFriends = (Friends)localIterator.next();
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
          ContactSorter.a(localFriends);
        }
        String str = localFriends.groupid + "";
        localObject4 = (ArrayList)localConcurrentHashMap.get(str);
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new ArrayList();
          localConcurrentHashMap.put(str, localObject1);
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label530;
          }
          localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label530;
          }
          Groups localGroups = (Groups)((Iterator)localObject4).next();
          if (localGroups.group_id != localFriends.groupid) {
            continue;
          }
          ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
        }
        ((ArrayList)localObject1).add(localFriends);
        if ((localFriends.status != 10) && (localFriends.status != 11)) {
          continue;
        }
        localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
        if (localObject1 == null)
        {
          ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          continue;
        }
        ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(localObject2.intValue() + 1));
      }
      finally {}
      continue;
      label299:
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            ContactSorter.b((ArrayList)localObject4);
          }
        }
      }
      this.e = ((ConcurrentHashMap)localObject5);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildUIMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
        QLog.d("Q.contacttab.", 2, "buildUIMaps end: , size:" + localConcurrentHashMap.size());
      }
      this.f = localConcurrentHashMap;
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 440	java/lang/StringBuffer
    //   6: dup
    //   7: invokespecial 441	java/lang/StringBuffer:<init>	()V
    //   10: astore 9
    //   12: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +19 -> 34
    //   18: aload 9
    //   20: ldc_w 443
    //   23: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: aload 9
    //   29: iload_1
    //   30: invokevirtual 449	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   33: pop
    //   34: aload_0
    //   35: iload_1
    //   36: invokevirtual 451	com/tencent/mobileqq/app/FriendsManager:a	(I)Ljava/util/ArrayList;
    //   39: astore 8
    //   41: aconst_null
    //   42: astore 6
    //   44: aload_0
    //   45: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   51: astore 7
    //   53: aload 7
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 454	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload 8
    //   64: invokevirtual 205	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_2
    //   71: aload 7
    //   73: invokeinterface 157 1 0
    //   78: ifeq +170 -> 248
    //   81: aload 7
    //   83: invokeinterface 161 1 0
    //   88: checkcast 163	com/tencent/mobileqq/persistence/Entity
    //   91: checkcast 165	com/tencent/mobileqq/data/Friends
    //   94: astore 10
    //   96: aload_0
    //   97: aload 10
    //   99: getfield 266	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   102: invokevirtual 456	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   105: istore 5
    //   107: iload_2
    //   108: istore_3
    //   109: aload 10
    //   111: getfield 169	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   114: iconst_1
    //   115: if_icmpeq +14 -> 129
    //   118: iload_2
    //   119: istore_3
    //   120: iload 5
    //   122: ifeq +7 -> 129
    //   125: iload_2
    //   126: iconst_1
    //   127: iadd
    //   128: istore_3
    //   129: aload 10
    //   131: iconst_0
    //   132: putfield 186	com/tencent/mobileqq/data/Friends:groupid	I
    //   135: aload_0
    //   136: aload 10
    //   138: invokevirtual 459	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   141: pop
    //   142: iload_3
    //   143: istore_2
    //   144: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq -76 -> 71
    //   150: aload 9
    //   152: ldc_w 461
    //   155: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: aload 9
    //   161: aload 10
    //   163: getfield 266	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   166: iconst_0
    //   167: iconst_4
    //   168: invokevirtual 465	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   174: pop
    //   175: aload 9
    //   177: ldc_w 467
    //   180: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   183: pop
    //   184: aload 9
    //   186: iload 5
    //   188: invokevirtual 470	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   191: pop
    //   192: iload_3
    //   193: istore_2
    //   194: goto -123 -> 71
    //   197: astore 7
    //   199: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +31 -> 233
    //   205: ldc 24
    //   207: iconst_2
    //   208: new 113	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 472
    //   218: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload_1
    //   222: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: aload 7
    //   230: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload 6
    //   235: ifnull +8 -> 243
    //   238: aload 6
    //   240: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   243: aload_0
    //   244: invokevirtual 293	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   247: return
    //   248: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +14 -> 265
    //   254: ldc 24
    //   256: iconst_2
    //   257: aload 9
    //   259: invokevirtual 478	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   262: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_0
    //   266: iconst_0
    //   267: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   270: invokevirtual 480	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   273: astore 7
    //   275: aload 7
    //   277: ifnull +31 -> 308
    //   280: aload 7
    //   282: aload 7
    //   284: getfield 213	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   287: aload 8
    //   289: invokevirtual 258	java/util/ArrayList:size	()I
    //   292: iadd
    //   293: putfield 213	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   296: aload 7
    //   298: iload_2
    //   299: aload 7
    //   301: getfield 483	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   304: iadd
    //   305: putfield 483	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   308: aload_0
    //   309: aload 7
    //   311: invokevirtual 486	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   314: pop
    //   315: aload_0
    //   316: new 113	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   323: iload_1
    //   324: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc 191
    //   329: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 480	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   338: astore 7
    //   340: aload_0
    //   341: getfield 405	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   344: ifnull +30 -> 374
    //   347: aload_0
    //   348: getfield 405	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   351: new 113	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   358: iload_1
    //   359: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 191
    //   364: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokevirtual 489	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: aload_0
    //   375: getfield 204	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   378: invokevirtual 492	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   381: checkcast 197	java/util/ArrayList
    //   384: astore 8
    //   386: iload 4
    //   388: istore_2
    //   389: iload_2
    //   390: aload 8
    //   392: invokevirtual 258	java/util/ArrayList:size	()I
    //   395: if_icmpge +26 -> 421
    //   398: iload_1
    //   399: aload 8
    //   401: iload_2
    //   402: invokevirtual 317	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   405: checkcast 207	com/tencent/mobileqq/data/Groups
    //   408: getfield 210	com/tencent/mobileqq/data/Groups:group_id	I
    //   411: if_icmpne +44 -> 455
    //   414: aload 8
    //   416: iload_2
    //   417: invokevirtual 494	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   420: pop
    //   421: aload_0
    //   422: aload 8
    //   424: putfield 204	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   427: aload_0
    //   428: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   431: aload 7
    //   433: invokevirtual 496	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   436: pop
    //   437: aload 6
    //   439: invokevirtual 497	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   442: aload 6
    //   444: ifnull -201 -> 243
    //   447: aload 6
    //   449: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   452: goto -209 -> 243
    //   455: iload_2
    //   456: iconst_1
    //   457: iadd
    //   458: istore_2
    //   459: goto -70 -> 389
    //   462: astore 7
    //   464: aconst_null
    //   465: astore 6
    //   467: aload 6
    //   469: ifnull +8 -> 477
    //   472: aload 6
    //   474: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   477: aload 7
    //   479: athrow
    //   480: astore 7
    //   482: goto -15 -> 467
    //   485: astore 7
    //   487: goto -20 -> 467
    //   490: astore 7
    //   492: goto -293 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	FriendsManager
    //   0	495	1	paramInt	int
    //   70	389	2	i	int
    //   108	85	3	j	int
    //   1	386	4	k	int
    //   105	82	5	bool	boolean
    //   42	431	6	localObject1	Object
    //   51	31	7	localObject2	Object
    //   197	32	7	localException1	Exception
    //   273	159	7	localGroups	Groups
    //   462	16	7	localObject3	Object
    //   480	1	7	localObject4	Object
    //   485	1	7	localObject5	Object
    //   490	1	7	localException2	Exception
    //   39	384	8	localArrayList	ArrayList
    //   10	248	9	localStringBuffer	java.lang.StringBuffer
    //   94	68	10	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   57	69	197	java/lang/Exception
    //   71	107	197	java/lang/Exception
    //   109	118	197	java/lang/Exception
    //   129	142	197	java/lang/Exception
    //   144	192	197	java/lang/Exception
    //   248	265	197	java/lang/Exception
    //   265	275	197	java/lang/Exception
    //   280	308	197	java/lang/Exception
    //   308	374	197	java/lang/Exception
    //   374	386	197	java/lang/Exception
    //   389	421	197	java/lang/Exception
    //   421	442	197	java/lang/Exception
    //   44	53	462	finally
    //   57	69	480	finally
    //   71	107	480	finally
    //   109	118	480	finally
    //   129	142	480	finally
    //   144	192	480	finally
    //   248	265	480	finally
    //   265	275	480	finally
    //   280	308	480	finally
    //   308	374	480	finally
    //   374	386	480	finally
    //   389	421	480	finally
    //   421	442	480	finally
    //   199	233	485	finally
    //   44	53	490	java/lang/Exception
  }
  
  void a(long paramLong, byte paramByte)
  {
    Groups localGroups = a(paramLong + "");
    if ((localGroups == null) || (localGroups.seqid == paramByte)) {
      return;
    }
    localGroups.seqid = paramByte;
    a(localGroups);
    d();
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramExtensionInfo.uin == null)) {}
    do
    {
      return;
      a(paramExtensionInfo);
    } while (this.d == null);
    synchronized (this.d)
    {
      this.d.put(paramExtensionInfo.uin, paramExtensionInfo);
      return;
    }
  }
  
  public void a(Friends paramFriends)
  {
    if (paramFriends != null)
    {
      ContactSorter.a(paramFriends);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
      a(paramFriends);
    }
  }
  
  public void a(Friends paramFriends, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "updateSingleFriend: " + paramFriends.uin + ", needRefreshUI=" + paramBoolean);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    a(paramFriends);
    if (paramBoolean) {
      a();
    }
  }
  
  public void a(Groups paramGroups)
  {
    int k = 0;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    int i;
    if (paramGroups.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramGroups.group_id + "", paramGroups);
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localGroups.group_id == paramGroups.group_id)
        {
          localGroups.datetime = paramGroups.datetime;
          localGroups.group_friend_count = paramGroups.group_friend_count;
          localGroups.group_id = paramGroups.group_id;
          localGroups.group_name = paramGroups.group_name;
          localGroups.group_online_friend_count = paramGroups.group_online_friend_count;
          localGroups.seqid = paramGroups.seqid;
          localGroups.sqqOnLine_count = paramGroups.sqqOnLine_count;
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, paramGroups);
        }
        a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
        break;
      }
      i += 1;
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    if (paramNearbyPeopleCard == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((TextUtils.isEmpty(paramNearbyPeopleCard.uin)) || (TextUtils.isEmpty(paramNearbyPeopleCard.nickname)) || (paramNearbyPeopleCard.lastUpdateNickTime <= 0L)) {
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramNearbyPeopleCard.uin))
        {
          localDateNickNameInfo = (DateNickNameInfo)this.jdField_a_of_type_JavaUtilMap.get(paramNearbyPeopleCard.uin);
          localDateNickNameInfo.lastUpdateTime = paramNearbyPeopleCard.lastUpdateNickTime;
          localDateNickNameInfo.nickName = paramNearbyPeopleCard.nickname;
          continue;
        }
      }
      finally {}
      DateNickNameInfo localDateNickNameInfo = new DateNickNameInfo(paramNearbyPeopleCard.nickname, paramNearbyPeopleCard.lastUpdateNickTime);
      this.jdField_a_of_type_JavaUtilMap.put(paramNearbyPeopleCard.uin, localDateNickNameInfo);
    }
  }
  
  protected void a(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.g != null) {
      this.g.put(paramString, "");
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      Friends localFriends = b(paramString);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      if (localFriends.groupid >= 0)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Groups localGroups = a(String.valueOf(localFriends.groupid));
        if (localGroups != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localGroups.group_friend_count -= 1;
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (c(paramString))
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localGroups.group_online_friend_count -= 1;
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a(localGroups);
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localFriends.groupid = -1002;
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localFriends.uin);
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      a(localFriends);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.c();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        EntityTransaction localEntityTransaction;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("Q.contacttab.group", 2, "addFriendToBlackList ex", paramString);
        }
        if (localObject1 != null) {
          localObject1.b();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label335;
      }
      localObject2.b();
    }
    a();
  }
  
  protected void a(String paramString, byte paramByte)
  {
    Card localCard = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = paramString;
      localCard.bSingle = paramByte;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.bSingle = paramByte;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  public void a(String paramString, int paramInt)
  {
    Friends localFriends = c(paramString);
    int i;
    Groups localGroups1;
    Groups localGroups2;
    if (localFriends != null)
    {
      i = localFriends.groupid;
      localGroups1 = a(String.valueOf(i));
      if ((i >= 0) && (localGroups1 != null))
      {
        localGroups1.group_friend_count -= 1;
        if (c(localFriends.uin)) {
          localGroups1.group_online_friend_count -= 1;
        }
      }
      localGroups2 = a(String.valueOf(paramInt));
      if (localGroups2 != null)
      {
        localGroups2.group_friend_count += 1;
        if (c(localFriends.uin)) {
          localGroups2.group_online_friend_count += 1;
        }
      }
      localFriends.groupid = paramInt;
      localObject = null;
      paramString = null;
    }
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      a(localFriends);
      if ((i >= 0) && (localGroups1 != null))
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups1);
      }
      if (localGroups2 != null)
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups2);
      }
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.c();
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          localObject = paramString;
          QLog.e("Q.contacttab.group", 2, "setFriendGroup ex=", localException);
        }
        if (paramString != null) {
          paramString.b();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label286;
      }
      ((EntityTransaction)localObject).b();
    }
    a();
  }
  
  void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramGetOnlineInfoResp != null))
    {
      paramString = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        break label28;
      }
    }
    label28:
    do
    {
      return;
      paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
      paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
      paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
      paramString.eNetwork = paramGetOnlineInfoResp.eNetworkType;
      paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
      paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
    } while (((paramGetOnlineInfoResp.iTermType != 67586L) && (paramGetOnlineInfoResp.iTermType != 66566L) && (paramGetOnlineInfoResp.iTermType != 72194L) && (paramGetOnlineInfoResp.iTermType != 65804L) && (paramGetOnlineInfoResp.iTermType != 72706L)) || (paramGetOnlineInfoResp.eNetworkType == 1));
    paramString.netTypeIconIdIphoneOrWphoneNoWifi = paramGetOnlineInfoResp.eIconType;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    Friends localFriends = b(paramString1);
    localFriends.alias = paramString2;
    localFriends.datetime = System.currentTimeMillis();
    if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString1, paramString2);
    }
    a(localFriends);
  }
  
  protected void a(String paramString1, short paramShort, String paramString2, String paramString3)
  {
    paramString1 = b(paramString1);
    paramString1.name = paramString2;
    paramString1.faceid = paramShort;
    if (paramString3 != null) {
      paramString1.signature = paramString3;
    }
    paramString1.datetime = System.currentTimeMillis();
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ContactSorter.a(paramString1);
    a(paramString1);
  }
  
  protected void a(String paramString1, short paramShort1, String paramString2, String paramString3, byte paramByte1, short paramShort2, byte paramByte2)
  {
    byte b1 = 1;
    paramString1 = b(paramString1);
    paramString1.cSpecialFlag = paramByte1;
    paramString1.name = paramString2;
    paramString1.faceid = paramShort1;
    if (paramShort2 == 0) {
      paramByte1 = b1;
    }
    for (;;)
    {
      paramString1.gender = paramByte1;
      paramString1.age = paramByte2;
      if (paramString3 != null) {
        paramString1.signature = paramString3;
      }
      paramString1.datetime = System.currentTimeMillis();
      if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ContactSorter.a(paramString1);
      a(paramString1);
      return;
      if (paramShort2 == 1) {
        paramByte1 = 2;
      } else {
        paramByte1 = 0;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      a().edit().putLong(paramString, System.currentTimeMillis()).commit();
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
    a().edit().remove(paramString).commit();
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte, short paramShort)
  {
    Card localCard = a(paramString);
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = paramString;
      localCard.vContent = paramArrayOfByte;
      localCard.shType = paramShort;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.vContent = paramArrayOfByte;
    localCard.shType = paramShort;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  void a(ArrayList paramArrayList)
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramArrayList != null))
    {
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      Object localObject1;
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject1 = (SimpleOnlineFriendInfo)paramArrayList.next();
        localObject2 = String.valueOf(((SimpleOnlineFriendInfo)localObject1).friendUin);
        Friends localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if (localFriends != null)
        {
          if (((SimpleOnlineFriendInfo)localObject1).isMqqOnLine != 0) {}
          for (boolean bool = true;; bool = false)
          {
            localFriends.isMqqOnLine = bool;
            localFriends.status = ((SimpleOnlineFriendInfo)localObject1).status;
            localFriends.detalStatusFlag = ((SimpleOnlineFriendInfo)localObject1).detalStatusFlag;
            localFriends.sqqOnLineState = ((SimpleOnlineFriendInfo)localObject1).sqqOnLineState;
            localFriends.isIphoneOnline = ((SimpleOnlineFriendInfo)localObject1).isIphoneOnline;
            localFriends.iTermType = ((SimpleOnlineFriendInfo)localObject1).iTermType;
            localFriends.cNetwork = ((SimpleOnlineFriendInfo)localObject1).cNetwork;
            localFriends.abilityBits = ((SimpleOnlineFriendInfo)localObject1).uAbiFlag;
            localFriends.eNetwork = ((SimpleOnlineFriendInfo)localObject1).eNetworkType;
            localFriends.netTypeIconId = ((SimpleOnlineFriendInfo)localObject1).eIconType;
            localFriends.strTermDesc = ((SimpleOnlineFriendInfo)localObject1).strTermDesc;
            if (((((SimpleOnlineFriendInfo)localObject1).iTermType == 67586) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 66566) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 72194) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 65804) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 72706)) && (((SimpleOnlineFriendInfo)localObject1).eNetworkType != 1)) {
              localFriends.netTypeIconIdIphoneOrWphoneNoWifi = ((SimpleOnlineFriendInfo)localObject1).eIconType;
            }
            localHashMap.put(localObject2, Boolean.TRUE);
            break;
          }
        }
      }
      paramArrayList = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if (((Boolean)localHashMap.get(localObject1) == null) && (((Friends)localObject2).isFriend()))
        {
          ((Friends)localObject2).status = 20;
          ((Friends)localObject2).isMqqOnLine = false;
          ((Friends)localObject2).sqqOnLineState = 0;
          ((Friends)localObject2).detalStatusFlag = 20;
          ((Friends)localObject2).isIphoneOnline = 0;
          ((Friends)localObject2).cNetwork = 0;
          ((Friends)localObject2).abilityBits = 0L;
          ((Friends)localObject2).eNetwork = 0;
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramArrayList.iterator();
    Friends localFriends;
    while (((Iterator)localObject2).hasNext())
    {
      localFriends = (Friends)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(localFriends.uin + ",");
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveGatherList  GatherList size : " + paramArrayList.size() + " | saveGatherList : " + ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("everHasGatheredContacts", true).commit();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 1) {
            localFriends.gathtertype = 0;
          }
          a(localFriends);
        }
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 1;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("queryFriends_" + paramList.size());
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i = 1;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i += 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Friends)paramList.next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Friends)localObject).uin, localObject);
        }
      }
    }
    TraceUtils.a();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Card localCard = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localCard.vQQFaceID = paramArrayOfByte;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.vQQFaceID = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +277 -> 281
    //   7: aload_2
    //   8: ifnull +273 -> 281
    //   11: aconst_null
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 7
    //   23: aload 7
    //   25: astore 6
    //   27: aload 6
    //   29: invokevirtual 454	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   32: new 440	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 441	java/lang/StringBuffer:<init>	()V
    //   39: astore 7
    //   41: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +12 -> 56
    //   47: aload 7
    //   49: ldc_w 783
    //   52: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   55: pop
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: istore 4
    //   61: iload 5
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge +217 -> 282
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_1
    //   73: iload 5
    //   75: baload
    //   76: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 480	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   82: astore 8
    //   84: iload_3
    //   85: istore 4
    //   87: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +70 -> 160
    //   93: iload_3
    //   94: istore 4
    //   96: aload 7
    //   98: ldc_w 785
    //   101: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: pop
    //   105: iload_3
    //   106: istore 4
    //   108: aload 7
    //   110: aload_1
    //   111: iload 5
    //   113: baload
    //   114: invokevirtual 449	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_3
    //   119: istore 4
    //   121: aload 7
    //   123: ldc_w 787
    //   126: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: iload_3
    //   131: istore 4
    //   133: aload 7
    //   135: aload_2
    //   136: iload 5
    //   138: baload
    //   139: invokevirtual 449	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 8
    //   145: ifnonnull +15 -> 160
    //   148: iload_3
    //   149: istore 4
    //   151: aload 7
    //   153: ldc_w 789
    //   156: invokevirtual 446	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: aload 8
    //   165: ifnull +220 -> 385
    //   168: iload_3
    //   169: istore 4
    //   171: aload 8
    //   173: getfield 501	com/tencent/mobileqq/data/Groups:seqid	B
    //   176: aload_2
    //   177: iload 5
    //   179: baload
    //   180: if_icmpne +9 -> 189
    //   183: iload_3
    //   184: istore 4
    //   186: goto +199 -> 385
    //   189: iload_3
    //   190: istore 4
    //   192: aload 8
    //   194: aload_2
    //   195: iload 5
    //   197: baload
    //   198: putfield 501	com/tencent/mobileqq/data/Groups:seqid	B
    //   201: iconst_1
    //   202: istore_3
    //   203: iconst_1
    //   204: istore 4
    //   206: aload_0
    //   207: aload 8
    //   209: invokevirtual 486	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   212: pop
    //   213: iload_3
    //   214: istore 4
    //   216: goto +169 -> 385
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: iload 4
    //   225: istore_3
    //   226: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +32 -> 261
    //   232: ldc 24
    //   234: iconst_2
    //   235: new 113	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 791
    //   245: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_2
    //   249: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_1
    //   262: ifnull +117 -> 379
    //   265: aload_1
    //   266: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   269: iload_3
    //   270: istore 4
    //   272: iload 4
    //   274: ifeq +7 -> 281
    //   277: aload_0
    //   278: invokevirtual 503	com/tencent/mobileqq/app/FriendsManager:d	()V
    //   281: return
    //   282: iload_3
    //   283: istore 4
    //   285: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +17 -> 305
    //   291: iload_3
    //   292: istore 4
    //   294: ldc 24
    //   296: iconst_2
    //   297: aload 7
    //   299: invokevirtual 478	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   302: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: iload_3
    //   306: istore 4
    //   308: aload 6
    //   310: invokevirtual 497	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   313: iload_3
    //   314: istore 4
    //   316: aload 6
    //   318: ifnull -46 -> 272
    //   321: aload 6
    //   323: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   326: iload_3
    //   327: istore 4
    //   329: goto -57 -> 272
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 6
    //   336: aload 6
    //   338: ifnull +8 -> 346
    //   341: aload 6
    //   343: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: goto -13 -> 336
    //   352: astore_2
    //   353: aload_1
    //   354: astore 6
    //   356: aload_2
    //   357: astore_1
    //   358: goto -22 -> 336
    //   361: astore_2
    //   362: iconst_0
    //   363: istore_3
    //   364: aload 6
    //   366: astore_1
    //   367: goto -141 -> 226
    //   370: astore_2
    //   371: aload 6
    //   373: astore_1
    //   374: iconst_0
    //   375: istore_3
    //   376: goto -150 -> 226
    //   379: iload_3
    //   380: istore 4
    //   382: goto -110 -> 272
    //   385: iload 5
    //   387: iconst_1
    //   388: iadd
    //   389: istore 5
    //   391: iload 4
    //   393: istore_3
    //   394: goto -336 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	FriendsManager
    //   0	397	1	paramArrayOfByte1	byte[]
    //   0	397	2	paramArrayOfByte2	byte[]
    //   57	337	3	i	int
    //   59	333	4	j	int
    //   1	389	5	k	int
    //   12	360	6	localObject1	Object
    //   21	277	7	localObject2	Object
    //   82	126	8	localGroups	Groups
    // Exception table:
    //   from	to	target	type
    //   61	68	219	java/lang/Exception
    //   71	84	219	java/lang/Exception
    //   87	93	219	java/lang/Exception
    //   96	105	219	java/lang/Exception
    //   108	118	219	java/lang/Exception
    //   121	130	219	java/lang/Exception
    //   133	143	219	java/lang/Exception
    //   151	160	219	java/lang/Exception
    //   171	183	219	java/lang/Exception
    //   192	201	219	java/lang/Exception
    //   206	213	219	java/lang/Exception
    //   285	291	219	java/lang/Exception
    //   294	305	219	java/lang/Exception
    //   308	313	219	java/lang/Exception
    //   14	23	332	finally
    //   27	56	348	finally
    //   61	68	348	finally
    //   71	84	348	finally
    //   87	93	348	finally
    //   96	105	348	finally
    //   108	118	348	finally
    //   121	130	348	finally
    //   133	143	348	finally
    //   151	160	348	finally
    //   171	183	348	finally
    //   192	201	348	finally
    //   206	213	348	finally
    //   285	291	348	finally
    //   294	305	348	finally
    //   308	313	348	finally
    //   226	261	352	finally
    //   14	23	361	java/lang/Exception
    //   27	56	370	java/lang/Exception
  }
  
  void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    int i;
    if (paramArrayOfFriends != null) {
      i = paramArrayOfFriends.length;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveFriendsList: " + i + ", " + paramLong + ", " + paramBoolean);
      }
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        int j = 0;
        while (j < i)
        {
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfFriends[j].uin, paramArrayOfFriends[j]);
          a(paramArrayOfFriends[j]);
          j += 1;
        }
        if (paramBoolean)
        {
          Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Friends localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
            if ((localFriends.datetime < paramLong) && (localFriends.isFriend()))
            {
              localIterator.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localFriends);
            }
          }
        }
        i = -1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
        for (;;)
        {
          if (i > 0) {
            a(paramArrayOfFriends);
          }
          return;
          localEntityTransaction.c();
          localEntityTransaction.b();
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  /* Error */
  void a(Groups[] paramArrayOfGroups)
  {
    // Byte code:
    //   0: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 113	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 812
    //   16: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore_3
    //   20: aload_1
    //   21: ifnull +30 -> 51
    //   24: aload_1
    //   25: arraylength
    //   26: istore_2
    //   27: ldc 18
    //   29: iconst_2
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: ifnull +8 -> 50
    //   45: aload_1
    //   46: arraylength
    //   47: ifne +9 -> 56
    //   50: return
    //   51: iconst_m1
    //   52: istore_2
    //   53: goto -26 -> 27
    //   56: aload_0
    //   57: getfield 204	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   60: ifnonnull +29 -> 89
    //   63: aload_0
    //   64: new 197	java/util/ArrayList
    //   67: dup
    //   68: aload_1
    //   69: arraylength
    //   70: invokespecial 813	java/util/ArrayList:<init>	(I)V
    //   73: putfield 204	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: aload_0
    //   77: new 45	java/util/concurrent/ConcurrentHashMap
    //   80: dup
    //   81: aload_1
    //   82: arraylength
    //   83: invokespecial 57	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   86: putfield 405	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   89: new 197	java/util/ArrayList
    //   92: dup
    //   93: aload_1
    //   94: arraylength
    //   95: invokespecial 813	java/util/ArrayList:<init>	(I)V
    //   98: astore 4
    //   100: new 45	java/util/concurrent/ConcurrentHashMap
    //   103: dup
    //   104: aload_1
    //   105: arraylength
    //   106: invokespecial 57	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   109: astore 5
    //   111: aload_0
    //   112: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   115: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   118: astore_3
    //   119: aload_3
    //   120: invokevirtual 454	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   123: iconst_0
    //   124: istore_2
    //   125: iload_2
    //   126: aload_1
    //   127: arraylength
    //   128: if_icmpge +60 -> 188
    //   131: aload 5
    //   133: new 113	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   140: aload_1
    //   141: iload_2
    //   142: aaload
    //   143: getfield 210	com/tencent/mobileqq/data/Groups:group_id	I
    //   146: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc 191
    //   151: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_1
    //   158: iload_2
    //   159: aaload
    //   160: invokevirtual 202	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload 4
    //   166: aload_1
    //   167: iload_2
    //   168: aaload
    //   169: invokevirtual 220	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload_0
    //   174: aload_1
    //   175: iload_2
    //   176: aaload
    //   177: invokevirtual 486	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   180: pop
    //   181: iload_2
    //   182: iconst_1
    //   183: iadd
    //   184: istore_2
    //   185: goto -60 -> 125
    //   188: aload_1
    //   189: arraylength
    //   190: iconst_1
    //   191: if_icmple +8 -> 199
    //   194: aload 4
    //   196: invokestatic 815	com/tencent/mobileqq/app/ContactSorter:a	(Ljava/util/ArrayList;)V
    //   199: aload_0
    //   200: getfield 405	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: invokevirtual 800	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   206: invokeinterface 255 1 0
    //   211: astore_1
    //   212: aload_1
    //   213: invokeinterface 157 1 0
    //   218: ifeq +91 -> 309
    //   221: aload_1
    //   222: invokeinterface 161 1 0
    //   227: checkcast 802	java/util/Map$Entry
    //   230: astore 6
    //   232: aload 5
    //   234: aload 6
    //   236: invokeinterface 818 1 0
    //   241: checkcast 174	java/lang/String
    //   244: invokevirtual 394	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   247: ifne -35 -> 212
    //   250: aload_0
    //   251: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   254: aload 6
    //   256: invokeinterface 805 1 0
    //   261: checkcast 163	com/tencent/mobileqq/persistence/Entity
    //   264: invokevirtual 496	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   267: pop
    //   268: goto -56 -> 212
    //   271: astore_1
    //   272: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +13 -> 288
    //   278: ldc 24
    //   280: iconst_2
    //   281: ldc_w 820
    //   284: aload_1
    //   285: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload_3
    //   289: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   292: aload_0
    //   293: aload 4
    //   295: putfield 204	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   298: aload_0
    //   299: aload 5
    //   301: putfield 405	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   304: aload_0
    //   305: invokevirtual 293	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   308: return
    //   309: aload_3
    //   310: invokevirtual 497	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   313: aload_3
    //   314: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   317: goto -25 -> 292
    //   320: astore_1
    //   321: aload_3
    //   322: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   325: aload_1
    //   326: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	FriendsManager
    //   0	327	1	paramArrayOfGroups	Groups[]
    //   26	159	2	i	int
    //   19	303	3	localObject	Object
    //   98	196	4	localArrayList	ArrayList
    //   109	191	5	localConcurrentHashMap	ConcurrentHashMap
    //   230	25	6	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   119	123	271	java/lang/Exception
    //   125	181	271	java/lang/Exception
    //   188	199	271	java/lang/Exception
    //   199	212	271	java/lang/Exception
    //   212	268	271	java/lang/Exception
    //   309	313	271	java/lang/Exception
    //   119	123	320	finally
    //   125	181	320	finally
    //   188	199	320	finally
    //   199	212	320	finally
    //   212	268	320	finally
    //   272	288	320	finally
    //   309	313	320	finally
  }
  
  public boolean a()
  {
    boolean bool = b();
    a();
    return bool;
  }
  
  public boolean a(Card paramCard)
  {
    return a(paramCard);
  }
  
  public boolean a(ContactCard paramContactCard)
  {
    return a(paramContactCard);
  }
  
  protected boolean a(Friends paramFriends)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramFriends.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
        if (paramFriends.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while ((paramFriends.getStatus() != 1001) && (paramFriends.getStatus() != 1002));
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
    }
    QLog.d("Q.contacttab.friend", 2, "updateFriendEntity em closed f=" + paramFriends.uin);
    return false;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("Q.contacttab.friend", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.g == null)
    {
      this.g = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.g.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.g.size());
      }
    }
    return this.g.containsKey(paramString);
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: ldc 24
    //   11: iconst_2
    //   12: new 113	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 848
    //   22: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 785
    //   32: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_2
    //   36: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +30 -> 78
    //   51: ldc_w 733
    //   54: iconst_2
    //   55: new 113	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 850
    //   65: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_3
    //   69: invokevirtual 513	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   72: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   82: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   85: astore 8
    //   87: aload 8
    //   89: astore 9
    //   91: aload 8
    //   93: invokevirtual 454	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   96: aload 8
    //   98: astore 9
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual 387	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   105: astore 10
    //   107: aload 8
    //   109: astore 9
    //   111: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +48 -> 162
    //   117: aload 8
    //   119: astore 9
    //   121: ldc_w 733
    //   124: iconst_2
    //   125: new 113	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 852
    //   135: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 854
    //   145: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 10
    //   150: getfield 169	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   153: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload 8
    //   164: astore 9
    //   166: aload 10
    //   168: getfield 186	com/tencent/mobileqq/data/Friends:groupid	I
    //   171: iconst_m1
    //   172: if_icmpne +335 -> 507
    //   175: aload 8
    //   177: astore 9
    //   179: aload 10
    //   181: iload_2
    //   182: putfield 186	com/tencent/mobileqq/data/Friends:groupid	I
    //   185: iconst_m1
    //   186: istore 5
    //   188: iconst_1
    //   189: istore 7
    //   191: aload 8
    //   193: astore 9
    //   195: aload 10
    //   197: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   200: putfield 393	com/tencent/mobileqq/data/Friends:datetime	J
    //   203: iload_3
    //   204: ifeq +99 -> 303
    //   207: aload 8
    //   209: astore 9
    //   211: aload 10
    //   213: iconst_1
    //   214: putfield 169	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   217: aload 8
    //   219: astore 9
    //   221: aload 10
    //   223: ldc_w 856
    //   226: putfield 755	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   229: aload 8
    //   231: astore 9
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 81	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   238: iconst_1
    //   239: iadd
    //   240: putfield 81	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   243: aload 8
    //   245: astore 9
    //   247: aload_0
    //   248: aload 10
    //   250: getfield 266	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   253: invokevirtual 673	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   256: astore 11
    //   258: aload 11
    //   260: ifnull +43 -> 303
    //   263: aload 8
    //   265: astore 9
    //   267: aload 11
    //   269: getfield 859	com/tencent/mobileqq/data/Card:shGender	S
    //   272: ifne +262 -> 534
    //   275: iconst_1
    //   276: istore 4
    //   278: aload 8
    //   280: astore 9
    //   282: aload 10
    //   284: iload 4
    //   286: putfield 640	com/tencent/mobileqq/data/Friends:gender	B
    //   289: aload 8
    //   291: astore 9
    //   293: aload 10
    //   295: aload 11
    //   297: getfield 861	com/tencent/mobileqq/data/Card:age	B
    //   300: putfield 643	com/tencent/mobileqq/data/Friends:age	I
    //   303: aload 8
    //   305: astore 9
    //   307: aload_0
    //   308: aload 10
    //   310: invokevirtual 486	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   313: pop
    //   314: aload 8
    //   316: astore 9
    //   318: aload_0
    //   319: iload_2
    //   320: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   323: invokevirtual 480	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   326: astore 10
    //   328: aload 10
    //   330: ifnull +61 -> 391
    //   333: aload 8
    //   335: astore 9
    //   337: aload 10
    //   339: aload 10
    //   341: getfield 213	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   344: iconst_1
    //   345: iadd
    //   346: putfield 213	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   349: aload 8
    //   351: astore 9
    //   353: aload_0
    //   354: aload_1
    //   355: invokevirtual 456	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   358: ifeq +19 -> 377
    //   361: aload 8
    //   363: astore 9
    //   365: aload 10
    //   367: aload 10
    //   369: getfield 483	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   372: iconst_1
    //   373: iadd
    //   374: putfield 483	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   377: aload 8
    //   379: astore 9
    //   381: aload_0
    //   382: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   385: aload 10
    //   387: invokevirtual 529	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   390: pop
    //   391: iload 7
    //   393: ifne +83 -> 476
    //   396: iload 5
    //   398: iflt +78 -> 476
    //   401: aload 8
    //   403: astore 9
    //   405: aload_0
    //   406: iload 5
    //   408: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   411: invokevirtual 480	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   414: astore 10
    //   416: aload 10
    //   418: ifnull +58 -> 476
    //   421: aload 8
    //   423: astore 9
    //   425: aload 10
    //   427: aload 10
    //   429: getfield 213	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   432: iconst_1
    //   433: isub
    //   434: putfield 213	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   437: aload 8
    //   439: astore 9
    //   441: aload_0
    //   442: aload_1
    //   443: invokevirtual 456	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   446: ifeq +19 -> 465
    //   449: aload 8
    //   451: astore 9
    //   453: aload 10
    //   455: aload 10
    //   457: getfield 483	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   460: iconst_1
    //   461: isub
    //   462: putfield 483	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   465: aload 8
    //   467: astore 9
    //   469: aload_0
    //   470: aload 10
    //   472: invokevirtual 486	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   475: pop
    //   476: aload 8
    //   478: astore 9
    //   480: aload 8
    //   482: invokevirtual 497	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   485: iload 7
    //   487: istore_3
    //   488: aload 8
    //   490: ifnull +11 -> 501
    //   493: aload 8
    //   495: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   498: iload 7
    //   500: istore_3
    //   501: aload_0
    //   502: invokevirtual 293	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   505: iload_3
    //   506: ireturn
    //   507: aload 8
    //   509: astore 9
    //   511: aload 10
    //   513: getfield 186	com/tencent/mobileqq/data/Friends:groupid	I
    //   516: istore 5
    //   518: aload 8
    //   520: astore 9
    //   522: aload 10
    //   524: iload_2
    //   525: putfield 186	com/tencent/mobileqq/data/Friends:groupid	I
    //   528: iconst_0
    //   529: istore 7
    //   531: goto -340 -> 191
    //   534: aload 8
    //   536: astore 9
    //   538: aload 11
    //   540: getfield 859	com/tencent/mobileqq/data/Card:shGender	S
    //   543: istore 6
    //   545: iload 6
    //   547: iconst_1
    //   548: if_icmpne -270 -> 278
    //   551: iconst_2
    //   552: istore 4
    //   554: goto -276 -> 278
    //   557: astore_1
    //   558: aconst_null
    //   559: astore 8
    //   561: iconst_0
    //   562: istore 7
    //   564: aload 8
    //   566: astore 9
    //   568: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +17 -> 588
    //   574: aload 8
    //   576: astore 9
    //   578: ldc 24
    //   580: iconst_2
    //   581: ldc_w 863
    //   584: aload_1
    //   585: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: iload 7
    //   590: istore_3
    //   591: aload 8
    //   593: ifnull -92 -> 501
    //   596: aload 8
    //   598: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   601: iload 7
    //   603: istore_3
    //   604: goto -103 -> 501
    //   607: astore_1
    //   608: aconst_null
    //   609: astore 9
    //   611: aload 9
    //   613: ifnull +8 -> 621
    //   616: aload 9
    //   618: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   621: aload_1
    //   622: athrow
    //   623: astore_1
    //   624: goto -13 -> 611
    //   627: astore_1
    //   628: iconst_0
    //   629: istore 7
    //   631: goto -67 -> 564
    //   634: astore_1
    //   635: goto -71 -> 564
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	this	FriendsManager
    //   0	638	1	paramString	String
    //   0	638	2	paramInt	int
    //   0	638	3	paramBoolean	boolean
    //   1	552	4	b1	byte
    //   186	331	5	i	int
    //   543	6	6	j	int
    //   189	441	7	bool	boolean
    //   85	512	8	localEntityTransaction1	EntityTransaction
    //   89	528	9	localEntityTransaction2	EntityTransaction
    //   105	418	10	localObject	Object
    //   256	283	11	localCard	Card
    // Exception table:
    //   from	to	target	type
    //   78	87	557	java/lang/Exception
    //   78	87	607	finally
    //   91	96	623	finally
    //   100	107	623	finally
    //   111	117	623	finally
    //   121	162	623	finally
    //   166	175	623	finally
    //   179	185	623	finally
    //   195	203	623	finally
    //   211	217	623	finally
    //   221	229	623	finally
    //   233	243	623	finally
    //   247	258	623	finally
    //   267	275	623	finally
    //   282	289	623	finally
    //   293	303	623	finally
    //   307	314	623	finally
    //   318	328	623	finally
    //   337	349	623	finally
    //   353	361	623	finally
    //   365	377	623	finally
    //   381	391	623	finally
    //   405	416	623	finally
    //   425	437	623	finally
    //   441	449	623	finally
    //   453	465	623	finally
    //   469	476	623	finally
    //   480	485	623	finally
    //   511	518	623	finally
    //   522	528	623	finally
    //   538	545	623	finally
    //   568	574	623	finally
    //   578	588	623	finally
    //   91	96	627	java/lang/Exception
    //   100	107	627	java/lang/Exception
    //   111	117	627	java/lang/Exception
    //   121	162	627	java/lang/Exception
    //   166	175	627	java/lang/Exception
    //   179	185	627	java/lang/Exception
    //   511	518	627	java/lang/Exception
    //   522	528	627	java/lang/Exception
    //   195	203	634	java/lang/Exception
    //   211	217	634	java/lang/Exception
    //   221	229	634	java/lang/Exception
    //   233	243	634	java/lang/Exception
    //   247	258	634	java/lang/Exception
    //   267	275	634	java/lang/Exception
    //   282	289	634	java/lang/Exception
    //   293	303	634	java/lang/Exception
    //   307	314	634	java/lang/Exception
    //   318	328	634	java/lang/Exception
    //   337	349	634	java/lang/Exception
    //   353	361	634	java/lang/Exception
    //   365	377	634	java/lang/Exception
    //   381	391	634	java/lang/Exception
    //   405	416	634	java/lang/Exception
    //   425	437	634	java/lang/Exception
    //   441	449	634	java/lang/Exception
    //   453	465	634	java/lang/Exception
    //   469	476	634	java/lang/Exception
    //   480	485	634	java/lang/Exception
    //   538	545	634	java/lang/Exception
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends == null) || (paramArrayOfFriends.length == 0)) {
      return true;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      int i = 0;
      while (i < paramInt)
      {
        ContactSorter.a(paramArrayOfFriends[i]);
        a(paramArrayOfFriends[i]);
        i += 1;
      }
      localEntityTransaction.c();
      return true;
    }
    catch (Exception paramArrayOfFriends)
    {
      paramArrayOfFriends.printStackTrace();
      return true;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int b(String paramString)
  {
    int j = 0;
    int i;
    if ((paramString == null) || (paramString.length() == 0)) {
      i = -1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.e == null);
      i = j;
    } while (!this.e.containsKey(paramString));
    return ((Integer)this.e.get(paramString)).intValue();
  }
  
  public Card b(String paramString)
  {
    Card localCard2 = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
    Card localCard1 = localCard2;
    if (localCard2 == null)
    {
      localCard1 = new Card();
      localCard1.uin = paramString;
      localCard1.shGender = -1;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard1);
    }
    return localCard1;
  }
  
  public ContactCard b(String paramString)
  {
    ContactCard localContactCard2 = (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
    ContactCard localContactCard1 = localContactCard2;
    if (localContactCard2 == null)
    {
      localContactCard1 = new ContactCard();
      localContactCard1.mobileNo = paramString;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localContactCard1);
    }
    return localContactCard1;
  }
  
  public Friends b(String paramString)
  {
    Friends localFriends2 = c(paramString);
    Friends localFriends1 = localFriends2;
    if (localFriends2 == null)
    {
      localFriends1 = new Friends();
      localFriends1.uin = paramString;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localFriends1);
      a(localFriends1);
    }
    return localFriends1;
  }
  
  public Friends b(String paramString1, String paramString2)
  {
    Friends localFriends = b(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      ContactSorter.a(localFriends);
      a(localFriends);
      a();
    }
    return localFriends;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Groups)localIterator.next();
        localObject = (List)this.f.get(String.valueOf(((Groups)localObject).group_id));
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap b()
  {
    return a(false);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      synchronized (this.d)
      {
        if (this.jdField_b_of_type_Boolean) {
          return;
        }
        Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class);
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ExtensionInfo localExtensionInfo = (ExtensionInfo)((Iterator)localObject1).next();
            if ((localExtensionInfo != null) && (localExtensionInfo.uin != null)) {
              this.d.put(localExtensionInfo.uin, localExtensionInfo);
            }
          }
        }
      }
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache end: " + this.d.size());
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected void b(String paramString)
  {
    if (this.g != null) {
      this.g.remove(paramString);
    }
    paramString = b(paramString);
    paramString.groupid = -1;
    a(paramString);
  }
  
  void b(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null) {
      paramString.status = ((byte)paramInt);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
    NearbyPeopleCard localNearbyPeopleCard1 = localNearbyPeopleCard2;
    if (localNearbyPeopleCard2 == null)
    {
      localNearbyPeopleCard1 = new NearbyPeopleCard();
      localNearbyPeopleCard1.uin = paramString1;
    }
    localNearbyPeopleCard1.lastUpdateNickTime = System.currentTimeMillis();
    localNearbyPeopleCard1.nickname = paramString2;
    a(localNearbyPeopleCard1);
    a(localNearbyPeopleCard1);
  }
  
  void b(ArrayList paramArrayList)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return;
    }
    int j = 0;
    label11:
    Friends localFriends;
    boolean bool;
    label79:
    byte b1;
    label91:
    int k;
    int i;
    if (j < paramArrayList.size())
    {
      RequestPushFStatus localRequestPushFStatus = (RequestPushFStatus)paramArrayList.get(j);
      localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localRequestPushFStatus.lUin + "");
      if (localRequestPushFStatus.uClientType == 99) {
        break label192;
      }
      bool = true;
      if (localRequestPushFStatus.uClientType != 110) {
        break label198;
      }
      b1 = 1;
      k = localRequestPushFStatus.cStatus;
      if (!bool) {
        break label203;
      }
      i = 1;
      label105:
      k += i;
      if ((20 != k) && (21 != k) && (40 != k) && (41 != k)) {
        break label208;
      }
      i = 20;
      label142:
      if (localFriends != null) {
        break label225;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "update Friend status Fail:" + localRequestPushFStatus.lUin);
      }
    }
    for (;;)
    {
      j += 1;
      break label11;
      break;
      label192:
      bool = false;
      break label79;
      label198:
      b1 = 0;
      break label91;
      label203:
      i = 0;
      break label105;
      label208:
      if (b1 == 1)
      {
        i = 11;
        break label142;
      }
      i = 10;
      break label142;
      label225:
      localFriends.status = ((byte)i);
      localFriends.detalStatusFlag = ((byte)k);
      localFriends.isMqqOnLine = bool;
      localFriends.isIphoneOnline = b1;
    }
  }
  
  public void b(ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveRecommGatherList  list size : " + paramArrayList.size());
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramArrayList.iterator();
    Friends localFriends;
    while (((Iterator)localObject2).hasNext())
    {
      localFriends = (Friends)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(localFriends.uin + ",");
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveRecommGatherList : " + ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 2) {
            localFriends.gathtertype = 0;
          }
          a(localFriends);
        }
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 2;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
  }
  
  /* Error */
  public void b(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 759 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 759 1 0
    //   20: iconst_1
    //   21: if_icmpne +18 -> 39
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 909 2 0
    //   32: checkcast 377	com/tencent/mobileqq/data/ExtensionInfo
    //   35: invokevirtual 911	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   38: return
    //   39: aload_0
    //   40: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 454	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   51: aload_1
    //   52: invokeinterface 430 1 0
    //   57: astore_1
    //   58: aload_1
    //   59: invokeinterface 157 1 0
    //   64: ifeq +60 -> 124
    //   67: aload_0
    //   68: aload_1
    //   69: invokeinterface 161 1 0
    //   74: checkcast 377	com/tencent/mobileqq/data/ExtensionInfo
    //   77: invokevirtual 911	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   80: goto -22 -> 58
    //   83: astore_1
    //   84: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +32 -> 119
    //   90: ldc 21
    //   92: iconst_2
    //   93: new 113	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 913
    //   103: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_2
    //   120: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   123: return
    //   124: aload_2
    //   125: invokevirtual 497	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   128: aload_2
    //   129: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   132: return
    //   133: astore_1
    //   134: aload_2
    //   135: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	FriendsManager
    //   0	140	1	paramList	List
    //   46	89	2	localEntityTransaction	EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   51	58	83	java/lang/Exception
    //   58	80	83	java/lang/Exception
    //   124	128	83	java/lang/Exception
    //   51	58	133	finally
    //   58	80	133	finally
    //   84	119	133	finally
    //   124	128	133	finally
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache begin");
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "initFriendCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
    int i;
    ConcurrentHashMap localConcurrentHashMap;
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    label131:
    Friends localFriends;
    if (localObject2 != null)
    {
      i = ((ArrayList)localObject2).size();
      localConcurrentHashMap = new ConcurrentHashMap(i);
      this.jdField_b_of_type_Int = 0;
      localStringBuilder = new StringBuilder();
      new ArrayList();
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        break label356;
      }
      localArrayList = new ArrayList();
      i = 0;
      if (i >= ((ArrayList)localObject2).size()) {
        break label287;
      }
      localFriends = (Friends)((ArrayList)localObject2).get(i);
      if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
      {
        ContactSorter.a(localFriends);
        localArrayList.add(localFriends);
      }
      localConcurrentHashMap.put(localFriends.uin, localFriends);
      if (localFriends.gathtertype == 1) {
        localStringBuilder.append(localFriends.uin + ";");
      }
      if (localFriends.gathtertype != 2) {
        break label265;
      }
      this.jdField_b_of_type_Int += 1;
    }
    for (;;)
    {
      i += 1;
      break label131;
      i = 0;
      break;
      label265:
      if (localFriends.gathtertype == 1) {
        this.jdField_c_of_type_Int += 1;
      }
    }
    label287:
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      i = 0;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    label356:
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache end: " + localConcurrentHashMap.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "mRecomCount: " + this.jdField_b_of_type_Int + " ; mGatheredCount = " + this.jdField_c_of_type_Int + " ; initFriendCache gathered : " + localStringBuilder);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (localConcurrentHashMap.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return 0;
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() - this.jdField_c_of_type_Int;
  }
  
  public Friends c(String paramString)
  {
    Object localObject2;
    if (!f(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      do
      {
        return localObject2;
        localObject2 = a(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.contacttab.", 2, "findFriendEntityByUin from db isFriendCacheInited=" + this.jdField_a_of_type_Boolean + " f=" + localObject2 + " uin=" + paramString);
            localObject1 = localObject2;
          }
        }
        localObject2 = localObject1;
      } while (localObject1 == null);
      localObject2 = localObject1;
    } while (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    return localObject1;
  }
  
  public ArrayList c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      c();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ConcurrentHashMap c()
  {
    return a(true);
  }
  
  public void c()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localGroups.group_id + "", localGroups);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList end: " + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  protected void c(String paramString)
  {
    paramString = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
    if ((paramString != null) && (paramString.iVoteIncrement > 0))
    {
      paramString.iVoteIncrement = 0;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString);
    }
  }
  
  /* Error */
  public void c(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 759 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 104	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 454	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   26: aload_1
    //   27: invokeinterface 430 1 0
    //   32: astore_1
    //   33: aload_1
    //   34: invokeinterface 157 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_1
    //   43: invokeinterface 161 1 0
    //   48: checkcast 174	java/lang/String
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 48	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_3
    //   57: invokevirtual 195	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 165	com/tencent/mobileqq/data/Friends
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull -32 -> 33
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 169	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 459	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   78: pop
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 81	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   84: iconst_1
    //   85: isub
    //   86: putfield 81	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   89: goto -56 -> 33
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   97: aload_2
    //   98: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   101: aload_0
    //   102: invokevirtual 293	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   105: return
    //   106: aload_2
    //   107: invokevirtual 497	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   110: aload_2
    //   111: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   114: goto -13 -> 101
    //   117: astore_1
    //   118: aload_2
    //   119: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	FriendsManager
    //   0	124	1	paramList	List
    //   21	98	2	localEntityTransaction	EntityTransaction
    //   51	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	33	92	java/lang/Exception
    //   33	64	92	java/lang/Exception
    //   68	89	92	java/lang/Exception
    //   106	110	92	java/lang/Exception
    //   22	33	117	finally
    //   33	64	117	finally
    //   68	89	117	finally
    //   93	97	117	finally
    //   106	110	117	finally
  }
  
  public boolean c()
  {
    return (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0));
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    paramString = c(paramString);
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((paramString.status != 10) && (paramString.status != 11) && ((paramString.status != 20) || (paramString.sqqOnLineState != 1)) && (paramString.status != 30))
      {
        bool1 = bool2;
        if (paramString.status != 31) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public ArrayList d()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = a(true);
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localConcurrentHashMap.get(String.valueOf(((Groups)localIterator.next()).group_id));
        if (localList != null) {
          localArrayList.addAll(localList);
        }
      }
    }
    return localArrayList;
  }
  
  void d()
  {
    c();
    a();
  }
  
  public void d(String paramString)
  {
    Friends localFriends1 = null;
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localFriends1 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    if (localFriends1 != null)
    {
      if (localFriends1.gathtertype != 2) {
        break label81;
      }
      this.jdField_b_of_type_Int -= 1;
    }
    for (;;)
    {
      Friends localFriends2 = localFriends1;
      if (localFriends1 == null) {
        localFriends2 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
      }
      if (localFriends2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localFriends2);
      }
      a();
      return;
      label81:
      if (localFriends1.gathtertype == 1) {
        this.jdField_c_of_type_Int -= 1;
      }
    }
  }
  
  public void d(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localObject = (String)paramList.next();
        localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject == null) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 2) {
          this.jdField_b_of_type_Int -= 1;
        }
        if ((((Friends)localObject).gathtertype != 2) && (((Friends)localObject).gathtertype != 0)) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 0) {
          ((Friends)localObject).recommReason = "手工设置";
        }
        ((Friends)localObject).gathtertype = 1;
        localCard = a(((Friends)localObject).uin);
        if (localCard == null) {
          continue;
        }
        if (localCard.shGender != 0) {
          continue;
        }
        b1 = 1;
      }
      catch (Exception paramList)
      {
        Object localObject;
        Card localCard;
        paramList.printStackTrace();
        localEntityTransaction.b();
        return;
        if (localCard.shGender != 1) {
          break label238;
        }
        b1 = 2;
        continue;
        localEntityTransaction.c();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      ((Friends)localObject).gender = b1;
      ((Friends)localObject).age = localCard.age;
      a((Friends)localObject);
      this.jdField_c_of_type_Int += 1;
      continue;
      label238:
      byte b1 = 0;
    }
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    long l2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      l2 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
    }
    while (l2 == 0L)
    {
      return false;
      l2 = a().getLong(paramString, 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramString.startsWith("+")) {
          l1 = a().getLong(paramString.replace("+", ""), 0L);
        }
      }
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (paramString.startsWith("+86")) {
          l2 = a().getLong(paramString.replace("+86", ""), 0L);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l2));
    }
    long l1 = System.currentTimeMillis() - l2;
    if ((l1 > 0L) && (l1 < 500654080L)) {
      return true;
    }
    a().edit().remove(paramString).commit();
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
    return false;
  }
  
  public void e(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cmd0x7c4.RecommendReason)paramList.next();
        String str = String.valueOf(((cmd0x7c4.RecommendReason)localObject).uint32_reason_id.get());
        localObject = ((cmd0x7c4.RecommendReason)localObject).bytes_recommend_reason.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "key : " + str + " ; reason : " + (String)localObject);
        }
      }
    }
  }
  
  public boolean e(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager
 * JD-Core Version:    0.7.0.1
 */