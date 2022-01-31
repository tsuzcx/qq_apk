package com.tencent.mobileqq.app;

import MessageSvcPack.RequestPushFStatus;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import fcn;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;

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
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new fcn(this);
  private boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private ConcurrentHashMap c = new ConcurrentHashMap();
  private ConcurrentHashMap d;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap f = null;
  
  public FriendsManager(QQAppInterface paramQQAppInterface)
  {
    this.e = new ConcurrentHashMap(4);
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
  
  public ExtensionInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if (!"".equals(paramString)) {
        break label24;
      }
      localObject1 = localObject2;
    }
    label24:
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = localObject3;
          if (this.c != null) {
            localObject2 = (ExtensionInfo)this.c.get(paramString);
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject1 = localObject2;
      } while (this.jdField_b_of_type_Boolean);
      localObject2 = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, paramString);
      localObject1 = localObject2;
    } while (localObject2 == null);
    this.c.put(paramString, localObject2);
    return localObject2;
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
          } while (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null);
          localFriends = (Friends)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = localFriends;
        } while (localFriends != null);
        localObject = localFriends;
      } while (this.jdField_a_of_type_Boolean);
      paramString = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
      if (paramString != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.uin, paramString);
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
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
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
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      localObject = null;
    }
    Groups localGroups;
    do
    {
      do
      {
        return localObject;
        localGroups = (Groups)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localGroups;
      } while (localGroups != null);
      localGroups = (Groups)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, paramString);
      localObject = localGroups;
    } while (localGroups == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localGroups);
    ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, localGroups);
    return localGroups;
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
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
    Object localObject;
    int j;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label56;
      }
      if (-1006 != ((Groups)((Iterator)localObject).next()).group_id) {
        break label144;
      }
      i = 1;
    }
    label144:
    for (;;)
    {
      break;
      j = 0;
      label56:
      if (j == 0)
      {
        localObject = new Groups();
        ((Groups)localObject).group_id = -1006;
        ((Groups)localObject).group_name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131562981);
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Groups)localObject).group_id + "", localObject);
      }
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
  }
  
  public ArrayList a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Friends)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (((Friends)localObject).groupid == paramInt) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  protected ArrayList a(String paramString)
  {
    return (ArrayList)this.e.get(paramString);
  }
  
  public void a()
  {
    label540:
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
        Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
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
            break label540;
          }
          localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label540;
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
      this.d = ((ConcurrentHashMap)localObject5);
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
      }
      this.e = localConcurrentHashMap;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "buildUIMaps end: , size:" + this.e.size());
      }
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 376	java/lang/StringBuffer
    //   6: dup
    //   7: invokespecial 377	java/lang/StringBuffer:<init>	()V
    //   10: astore 9
    //   12: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +19 -> 34
    //   18: aload 9
    //   20: ldc_w 379
    //   23: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: aload 9
    //   29: iload_1
    //   30: invokevirtual 385	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   33: pop
    //   34: aload_0
    //   35: iload_1
    //   36: invokevirtual 387	com/tencent/mobileqq/app/FriendsManager:a	(I)Ljava/util/ArrayList;
    //   39: astore 8
    //   41: aconst_null
    //   42: astore 6
    //   44: aload_0
    //   45: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: invokevirtual 276	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   51: astore 7
    //   53: aload 7
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload 8
    //   64: invokevirtual 285	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_2
    //   71: aload 7
    //   73: invokeinterface 290 1 0
    //   78: ifeq +159 -> 237
    //   81: aload 7
    //   83: invokeinterface 294 1 0
    //   88: checkcast 296	com/tencent/mobileqq/persistence/Entity
    //   91: checkcast 124	com/tencent/mobileqq/data/Friends
    //   94: astore 10
    //   96: aload_0
    //   97: aload 10
    //   99: getfield 127	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   102: invokevirtual 392	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   105: istore 5
    //   107: iload_2
    //   108: istore_3
    //   109: iload 5
    //   111: ifeq +7 -> 118
    //   114: iload_2
    //   115: iconst_1
    //   116: iadd
    //   117: istore_3
    //   118: aload 10
    //   120: iconst_0
    //   121: putfield 325	com/tencent/mobileqq/data/Friends:groupid	I
    //   124: aload_0
    //   125: aload 10
    //   127: invokevirtual 395	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   130: pop
    //   131: iload_3
    //   132: istore_2
    //   133: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq -65 -> 71
    //   139: aload 9
    //   141: ldc_w 397
    //   144: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   147: pop
    //   148: aload 9
    //   150: aload 10
    //   152: getfield 127	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   155: iconst_0
    //   156: iconst_4
    //   157: invokevirtual 401	java/lang/String:substring	(II)Ljava/lang/String;
    //   160: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   163: pop
    //   164: aload 9
    //   166: ldc_w 403
    //   169: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   172: pop
    //   173: aload 9
    //   175: iload 5
    //   177: invokevirtual 406	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   180: pop
    //   181: iload_3
    //   182: istore_2
    //   183: goto -112 -> 71
    //   186: astore 7
    //   188: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +31 -> 222
    //   194: ldc 24
    //   196: iconst_2
    //   197: new 101	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 408
    //   207: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload_1
    //   211: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 7
    //   219: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload 6
    //   224: ifnull +8 -> 232
    //   227: aload 6
    //   229: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   232: aload_0
    //   233: invokevirtual 166	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   236: return
    //   237: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +14 -> 254
    //   243: ldc 24
    //   245: iconst_2
    //   246: aload 9
    //   248: invokevirtual 414	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   251: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_0
    //   255: iconst_0
    //   256: invokestatic 355	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   259: invokevirtual 416	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   262: astore 7
    //   264: aload 7
    //   266: ifnull +31 -> 297
    //   269: aload 7
    //   271: aload 7
    //   273: getfield 341	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   276: aload 8
    //   278: invokevirtual 192	java/util/ArrayList:size	()I
    //   281: iadd
    //   282: putfield 341	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   285: aload 7
    //   287: iload_2
    //   288: aload 7
    //   290: getfield 419	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   293: iadd
    //   294: putfield 419	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   297: aload_0
    //   298: aload 7
    //   300: invokevirtual 422	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   303: pop
    //   304: aload_0
    //   305: new 101	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   312: iload_1
    //   313: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: ldc 214
    //   318: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 416	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   327: astore 7
    //   329: aload_0
    //   330: getfield 268	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   333: ifnull +30 -> 363
    //   336: aload_0
    //   337: getfield 268	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   340: new 101	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   347: iload_1
    //   348: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: ldc 214
    //   353: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokevirtual 425	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: pop
    //   363: aload_0
    //   364: getfield 189	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   367: invokevirtual 428	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   370: checkcast 121	java/util/ArrayList
    //   373: astore 8
    //   375: iload 4
    //   377: istore_2
    //   378: iload_2
    //   379: aload 8
    //   381: invokevirtual 192	java/util/ArrayList:size	()I
    //   384: if_icmpge +26 -> 410
    //   387: iload_1
    //   388: aload 8
    //   390: iload_2
    //   391: invokevirtual 431	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   394: checkcast 270	com/tencent/mobileqq/data/Groups
    //   397: getfield 299	com/tencent/mobileqq/data/Groups:group_id	I
    //   400: if_icmpne +44 -> 444
    //   403: aload 8
    //   405: iload_2
    //   406: invokevirtual 433	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   409: pop
    //   410: aload_0
    //   411: aload 8
    //   413: putfield 189	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   416: aload_0
    //   417: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   420: aload 7
    //   422: invokevirtual 435	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   425: pop
    //   426: aload 6
    //   428: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   431: aload 6
    //   433: ifnull -201 -> 232
    //   436: aload 6
    //   438: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   441: goto -209 -> 232
    //   444: iload_2
    //   445: iconst_1
    //   446: iadd
    //   447: istore_2
    //   448: goto -70 -> 378
    //   451: astore 7
    //   453: aconst_null
    //   454: astore 6
    //   456: aload 6
    //   458: ifnull +8 -> 466
    //   461: aload 6
    //   463: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   466: aload 7
    //   468: athrow
    //   469: astore 7
    //   471: goto -15 -> 456
    //   474: astore 7
    //   476: goto -20 -> 456
    //   479: astore 7
    //   481: goto -293 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	FriendsManager
    //   0	484	1	paramInt	int
    //   70	378	2	i	int
    //   108	74	3	j	int
    //   1	375	4	k	int
    //   105	71	5	bool	boolean
    //   42	420	6	localObject1	Object
    //   51	31	7	localObject2	Object
    //   186	32	7	localException1	Exception
    //   262	159	7	localGroups	Groups
    //   451	16	7	localObject3	Object
    //   469	1	7	localObject4	Object
    //   474	1	7	localObject5	Object
    //   479	1	7	localException2	Exception
    //   39	373	8	localArrayList	ArrayList
    //   10	237	9	localStringBuffer	java.lang.StringBuffer
    //   94	57	10	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   57	69	186	java/lang/Exception
    //   71	107	186	java/lang/Exception
    //   118	131	186	java/lang/Exception
    //   133	181	186	java/lang/Exception
    //   237	254	186	java/lang/Exception
    //   254	264	186	java/lang/Exception
    //   269	297	186	java/lang/Exception
    //   297	363	186	java/lang/Exception
    //   363	375	186	java/lang/Exception
    //   378	410	186	java/lang/Exception
    //   410	431	186	java/lang/Exception
    //   44	53	451	finally
    //   57	69	469	finally
    //   71	107	469	finally
    //   118	131	469	finally
    //   133	181	469	finally
    //   237	254	469	finally
    //   254	264	469	finally
    //   269	297	469	finally
    //   297	363	469	finally
    //   363	375	469	finally
    //   378	410	469	finally
    //   410	431	469	finally
    //   188	222	474	finally
    //   44	53	479	java/lang/Exception
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
    } while (this.c == null);
    this.c.put(paramExtensionInfo.uin, paramExtensionInfo);
  }
  
  public void a(Friends paramFriends)
  {
    if (paramFriends != null)
    {
      ContactSorter.a(paramFriends);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
      a(paramFriends);
    }
  }
  
  public void a(Friends paramFriends, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "updateSingleFriend: " + paramFriends.uin + ", needRefreshUI=" + paramBoolean);
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    a(paramFriends);
    if (paramBoolean) {
      a();
    }
  }
  
  public void a(Groups paramGroups)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    int i;
    if (paramGroups.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramGroups.group_id + "", paramGroups);
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
  
  protected void a(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.f != null) {
      this.f.put(paramString, "");
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
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localFriends.uin);
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
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramGetOnlineInfoResp != null))
    {
      paramString = (Friends)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {}
    }
    else
    {
      return;
    }
    paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
    paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
    paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
    paramString.eNetwork = paramGetOnlineInfoResp.eNetworkType;
    paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
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
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ContactSorter.a(paramString1);
    a(paramString1);
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
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramArrayList != null))
    {
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      Object localObject1;
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject1 = (SimpleOnlineFriendInfo)paramArrayList.next();
        localObject2 = String.valueOf(((SimpleOnlineFriendInfo)localObject1).friendUin);
        Friends localFriends = (Friends)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
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
            if (((((SimpleOnlineFriendInfo)localObject1).iTermType == 67586) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 66566) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 72194) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 65804) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 72706)) && (((SimpleOnlineFriendInfo)localObject1).eNetworkType != 1))
            {
              localFriends.netTypeIconIdIphoneOrWphoneNoWifi = ((SimpleOnlineFriendInfo)localObject1).eIconType;
              localFriends.netTypeIphoneOrWphoneNoWifi = ((SimpleOnlineFriendInfo)localObject1).eNetworkType;
            }
            localHashMap.put(localObject2, Boolean.TRUE);
            break;
          }
        }
      }
      paramArrayList = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (Friends)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
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
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Friends)localObject).uin, localObject);
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
    //   15: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 276	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 7
    //   23: aload 7
    //   25: astore 6
    //   27: aload 6
    //   29: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   32: new 376	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 377	java/lang/StringBuffer:<init>	()V
    //   39: astore 7
    //   41: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +12 -> 56
    //   47: aload 7
    //   49: ldc_w 658
    //   52: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
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
    //   76: invokestatic 355	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 416	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   82: astore 8
    //   84: iload_3
    //   85: istore 4
    //   87: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +70 -> 160
    //   93: iload_3
    //   94: istore 4
    //   96: aload 7
    //   98: ldc_w 660
    //   101: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: pop
    //   105: iload_3
    //   106: istore 4
    //   108: aload 7
    //   110: aload_1
    //   111: iload 5
    //   113: baload
    //   114: invokevirtual 385	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_3
    //   119: istore 4
    //   121: aload 7
    //   123: ldc_w 662
    //   126: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: iload_3
    //   131: istore 4
    //   133: aload 7
    //   135: aload_2
    //   136: iload 5
    //   138: baload
    //   139: invokevirtual 385	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 8
    //   145: ifnonnull +15 -> 160
    //   148: iload_3
    //   149: istore 4
    //   151: aload 7
    //   153: ldc_w 664
    //   156: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: aload 8
    //   165: ifnull +220 -> 385
    //   168: iload_3
    //   169: istore 4
    //   171: aload 8
    //   173: getfield 443	com/tencent/mobileqq/data/Groups:seqid	B
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
    //   198: putfield 443	com/tencent/mobileqq/data/Groups:seqid	B
    //   201: iconst_1
    //   202: istore_3
    //   203: iconst_1
    //   204: istore 4
    //   206: aload_0
    //   207: aload 8
    //   209: invokevirtual 422	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   212: pop
    //   213: iload_3
    //   214: istore 4
    //   216: goto +169 -> 385
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: iload 4
    //   225: istore_3
    //   226: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +32 -> 261
    //   232: ldc 24
    //   234: iconst_2
    //   235: new 101	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 666
    //   245: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_2
    //   249: invokevirtual 669	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_1
    //   262: ifnull +117 -> 379
    //   265: aload_1
    //   266: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   269: iload_3
    //   270: istore 4
    //   272: iload 4
    //   274: ifeq +7 -> 281
    //   277: aload_0
    //   278: invokevirtual 445	com/tencent/mobileqq/app/FriendsManager:d	()V
    //   281: return
    //   282: iload_3
    //   283: istore 4
    //   285: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +17 -> 305
    //   291: iload_3
    //   292: istore 4
    //   294: ldc 24
    //   296: iconst_2
    //   297: aload 7
    //   299: invokevirtual 414	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   302: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: iload_3
    //   306: istore 4
    //   308: aload 6
    //   310: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   313: iload_3
    //   314: istore 4
    //   316: aload 6
    //   318: ifnull -46 -> 272
    //   321: aload 6
    //   323: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   326: iload_3
    //   327: istore 4
    //   329: goto -57 -> 272
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 6
    //   336: aload 6
    //   338: ifnull +8 -> 346
    //   341: aload 6
    //   343: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
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
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfFriends[j].uin, paramArrayOfFriends[j]);
          a(paramArrayOfFriends[j]);
          j += 1;
        }
        if (paramBoolean)
        {
          Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
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
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 101	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 690
    //   16: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   32: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   57: getfield 189	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   60: ifnonnull +29 -> 89
    //   63: aload_0
    //   64: new 121	java/util/ArrayList
    //   67: dup
    //   68: aload_1
    //   69: arraylength
    //   70: invokespecial 691	java/util/ArrayList:<init>	(I)V
    //   73: putfield 189	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: aload_0
    //   77: new 43	java/util/concurrent/ConcurrentHashMap
    //   80: dup
    //   81: aload_1
    //   82: arraylength
    //   83: invokespecial 55	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   86: putfield 268	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   89: new 121	java/util/ArrayList
    //   92: dup
    //   93: aload_1
    //   94: arraylength
    //   95: invokespecial 691	java/util/ArrayList:<init>	(I)V
    //   98: astore 4
    //   100: new 43	java/util/concurrent/ConcurrentHashMap
    //   103: dup
    //   104: aload_1
    //   105: arraylength
    //   106: invokespecial 55	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   109: astore 5
    //   111: aload_0
    //   112: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   115: invokevirtual 276	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   118: astore_3
    //   119: aload_3
    //   120: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   123: iconst_0
    //   124: istore_2
    //   125: iload_2
    //   126: aload_1
    //   127: arraylength
    //   128: if_icmpge +60 -> 188
    //   131: aload 5
    //   133: new 101	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   140: aload_1
    //   141: iload_2
    //   142: aaload
    //   143: getfield 299	com/tencent/mobileqq/data/Groups:group_id	I
    //   146: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc 214
    //   151: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_1
    //   158: iload_2
    //   159: aaload
    //   160: invokevirtual 227	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload 4
    //   166: aload_1
    //   167: iload_2
    //   168: aaload
    //   169: invokevirtual 311	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload_0
    //   174: aload_1
    //   175: iload_2
    //   176: aaload
    //   177: invokevirtual 422	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
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
    //   196: invokestatic 693	com/tencent/mobileqq/app/ContactSorter:a	(Ljava/util/ArrayList;)V
    //   199: aload_0
    //   200: getfield 268	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: invokevirtual 675	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   206: invokeinterface 322 1 0
    //   211: astore_1
    //   212: aload_1
    //   213: invokeinterface 290 1 0
    //   218: ifeq +91 -> 309
    //   221: aload_1
    //   222: invokeinterface 294 1 0
    //   227: checkcast 677	java/util/Map$Entry
    //   230: astore 6
    //   232: aload 5
    //   234: aload 6
    //   236: invokeinterface 696 1 0
    //   241: checkcast 181	java/lang/String
    //   244: invokevirtual 252	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   247: ifne -35 -> 212
    //   250: aload_0
    //   251: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   254: aload 6
    //   256: invokeinterface 680 1 0
    //   261: checkcast 296	com/tencent/mobileqq/persistence/Entity
    //   264: invokevirtual 435	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   267: pop
    //   268: goto -56 -> 212
    //   271: astore_1
    //   272: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +13 -> 288
    //   278: ldc 24
    //   280: iconst_2
    //   281: ldc_w 698
    //   284: aload_1
    //   285: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload_3
    //   289: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   292: aload_0
    //   293: aload 4
    //   295: putfield 189	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   298: aload_0
    //   299: aload 5
    //   301: putfield 268	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   304: aload_0
    //   305: invokevirtual 166	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   308: return
    //   309: aload_3
    //   310: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   313: aload_3
    //   314: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   317: goto -25 -> 292
    //   320: astore_1
    //   321: aload_3
    //   322: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
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
    if (this.f == null)
    {
      this.f = new ConcurrentHashMap();
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
          this.f.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.f.size());
      }
    }
    return this.f.containsKey(paramString);
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 24
    //   8: iconst_2
    //   9: new 101	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 726
    //   19: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 660
    //   29: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   46: invokevirtual 276	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   49: astore 6
    //   51: aload 6
    //   53: astore 7
    //   55: aload 6
    //   57: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   60: aload 6
    //   62: astore 7
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 237	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   69: astore 8
    //   71: aload 6
    //   73: astore 7
    //   75: aload 8
    //   77: getfield 325	com/tencent/mobileqq/data/Friends:groupid	I
    //   80: iconst_m1
    //   81: if_icmpne +235 -> 316
    //   84: aload 6
    //   86: astore 7
    //   88: aload 8
    //   90: iload_2
    //   91: putfield 325	com/tencent/mobileqq/data/Friends:groupid	I
    //   94: iconst_m1
    //   95: istore_3
    //   96: iconst_1
    //   97: istore 4
    //   99: aload 6
    //   101: astore 7
    //   103: aload 8
    //   105: invokestatic 246	java/lang/System:currentTimeMillis	()J
    //   108: putfield 249	com/tencent/mobileqq/data/Friends:datetime	J
    //   111: aload 6
    //   113: astore 7
    //   115: aload_0
    //   116: aload 8
    //   118: invokevirtual 422	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   121: pop
    //   122: aload 6
    //   124: astore 7
    //   126: aload_0
    //   127: iload_2
    //   128: invokestatic 355	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   131: invokevirtual 416	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   134: astore 8
    //   136: aload 8
    //   138: ifnull +61 -> 199
    //   141: aload 6
    //   143: astore 7
    //   145: aload 8
    //   147: aload 8
    //   149: getfield 341	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   152: iconst_1
    //   153: iadd
    //   154: putfield 341	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   157: aload 6
    //   159: astore 7
    //   161: aload_0
    //   162: aload_1
    //   163: invokevirtual 392	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   166: ifeq +19 -> 185
    //   169: aload 6
    //   171: astore 7
    //   173: aload 8
    //   175: aload 8
    //   177: getfield 419	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   180: iconst_1
    //   181: iadd
    //   182: putfield 419	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   185: aload 6
    //   187: astore 7
    //   189: aload_0
    //   190: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   193: aload 8
    //   195: invokevirtual 468	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   198: pop
    //   199: iload 4
    //   201: ifne +81 -> 282
    //   204: iload_3
    //   205: iflt +77 -> 282
    //   208: aload 6
    //   210: astore 7
    //   212: aload_0
    //   213: iload_3
    //   214: invokestatic 355	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   217: invokevirtual 416	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   220: astore 8
    //   222: aload 8
    //   224: ifnull +58 -> 282
    //   227: aload 6
    //   229: astore 7
    //   231: aload 8
    //   233: aload 8
    //   235: getfield 341	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   238: iconst_1
    //   239: isub
    //   240: putfield 341	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   243: aload 6
    //   245: astore 7
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual 392	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   252: ifeq +19 -> 271
    //   255: aload 6
    //   257: astore 7
    //   259: aload 8
    //   261: aload 8
    //   263: getfield 419	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   266: iconst_1
    //   267: isub
    //   268: putfield 419	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   271: aload 6
    //   273: astore 7
    //   275: aload_0
    //   276: aload 8
    //   278: invokevirtual 422	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   281: pop
    //   282: aload 6
    //   284: astore 7
    //   286: aload 6
    //   288: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   291: iload 4
    //   293: istore 5
    //   295: aload 6
    //   297: ifnull +12 -> 309
    //   300: aload 6
    //   302: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   305: iload 4
    //   307: istore 5
    //   309: aload_0
    //   310: invokevirtual 166	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   313: iload 5
    //   315: ireturn
    //   316: aload 6
    //   318: astore 7
    //   320: aload 8
    //   322: getfield 325	com/tencent/mobileqq/data/Friends:groupid	I
    //   325: istore_3
    //   326: aload 6
    //   328: astore 7
    //   330: aload 8
    //   332: iload_2
    //   333: putfield 325	com/tencent/mobileqq/data/Friends:groupid	I
    //   336: iconst_0
    //   337: istore 4
    //   339: goto -240 -> 99
    //   342: astore_1
    //   343: aconst_null
    //   344: astore 6
    //   346: iconst_0
    //   347: istore 4
    //   349: aload 6
    //   351: astore 7
    //   353: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +17 -> 373
    //   359: aload 6
    //   361: astore 7
    //   363: ldc 24
    //   365: iconst_2
    //   366: ldc_w 728
    //   369: aload_1
    //   370: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: iload 4
    //   375: istore 5
    //   377: aload 6
    //   379: ifnull -70 -> 309
    //   382: aload 6
    //   384: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   387: iload 4
    //   389: istore 5
    //   391: goto -82 -> 309
    //   394: astore_1
    //   395: aconst_null
    //   396: astore 7
    //   398: aload 7
    //   400: ifnull +8 -> 408
    //   403: aload 7
    //   405: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: goto -13 -> 398
    //   414: astore_1
    //   415: iconst_0
    //   416: istore 4
    //   418: goto -69 -> 349
    //   421: astore_1
    //   422: goto -73 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	FriendsManager
    //   0	425	1	paramString	String
    //   0	425	2	paramInt	int
    //   95	231	3	i	int
    //   97	320	4	bool1	boolean
    //   293	97	5	bool2	boolean
    //   49	334	6	localEntityTransaction1	EntityTransaction
    //   53	351	7	localEntityTransaction2	EntityTransaction
    //   69	262	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	51	342	java/lang/Exception
    //   42	51	394	finally
    //   55	60	410	finally
    //   64	71	410	finally
    //   75	84	410	finally
    //   88	94	410	finally
    //   103	111	410	finally
    //   115	122	410	finally
    //   126	136	410	finally
    //   145	157	410	finally
    //   161	169	410	finally
    //   173	185	410	finally
    //   189	199	410	finally
    //   212	222	410	finally
    //   231	243	410	finally
    //   247	255	410	finally
    //   259	271	410	finally
    //   275	282	410	finally
    //   286	291	410	finally
    //   320	326	410	finally
    //   330	336	410	finally
    //   353	359	410	finally
    //   363	373	410	finally
    //   55	60	414	java/lang/Exception
    //   64	71	414	java/lang/Exception
    //   75	84	414	java/lang/Exception
    //   88	94	414	java/lang/Exception
    //   320	326	414	java/lang/Exception
    //   330	336	414	java/lang/Exception
    //   103	111	421	java/lang/Exception
    //   115	122	421	java/lang/Exception
    //   126	136	421	java/lang/Exception
    //   145	157	421	java/lang/Exception
    //   161	169	421	java/lang/Exception
    //   173	185	421	java/lang/Exception
    //   189	199	421	java/lang/Exception
    //   212	222	421	java/lang/Exception
    //   231	243	421	java/lang/Exception
    //   247	255	421	java/lang/Exception
    //   259	271	421	java/lang/Exception
    //   275	282	421	java/lang/Exception
    //   286	291	421	java/lang/Exception
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
      } while (this.d == null);
      i = j;
    } while (!this.d.containsKey(paramString));
    return ((Integer)this.d.get(paramString)).intValue();
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
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localFriends1);
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
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      ContactSorter.a(localFriends);
      a(localFriends);
      a();
    }
    return localFriends;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Groups)localIterator.next();
        localObject = (List)this.e.get(String.valueOf(((Groups)localObject).group_id));
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ExtensionInfo localExtensionInfo = (ExtensionInfo)((Iterator)localObject).next();
        if ((localExtensionInfo != null) && (localExtensionInfo.uin != null)) {
          this.c.put(localExtensionInfo.uin, localExtensionInfo);
        }
      }
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache end: " + this.c.size());
    }
  }
  
  protected void b(String paramString)
  {
    if (this.f != null) {
      this.f.remove(paramString);
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
  
  void b(ArrayList paramArrayList)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
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
      localFriends = (Friends)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localRequestPushFStatus.lUin + "");
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
  
  /* Error */
  public void b(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 630 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 630 1 0
    //   20: iconst_1
    //   21: if_icmpne +18 -> 39
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 765 2 0
    //   32: checkcast 223	com/tencent/mobileqq/data/ExtensionInfo
    //   35: invokevirtual 767	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   38: return
    //   39: aload_0
    //   40: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: invokevirtual 276	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   51: aload_1
    //   52: invokeinterface 650 1 0
    //   57: astore_1
    //   58: aload_1
    //   59: invokeinterface 290 1 0
    //   64: ifeq +60 -> 124
    //   67: aload_0
    //   68: aload_1
    //   69: invokeinterface 294 1 0
    //   74: checkcast 223	com/tencent/mobileqq/data/ExtensionInfo
    //   77: invokevirtual 767	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   80: goto -22 -> 58
    //   83: astore_1
    //   84: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +32 -> 119
    //   90: ldc 21
    //   92: iconst_2
    //   93: new 101	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 769
    //   103: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 669	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_2
    //   120: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   123: return
    //   124: aload_2
    //   125: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   128: aload_2
    //   129: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   132: return
    //   133: astore_1
    //   134: aload_2
    //   135: invokevirtual 413	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
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
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        break label238;
      }
      localArrayList = new ArrayList();
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        Friends localFriends = (Friends)((ArrayList)localObject2).get(i);
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
        {
          ContactSorter.a(localFriends);
          localArrayList.add(localFriends);
        }
        localConcurrentHashMap.put(localFriends.uin, localFriends);
        i += 1;
      }
    }
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
    label238:
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache end: " + localConcurrentHashMap.size());
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
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
    } while (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    return localObject1;
  }
  
  public ArrayList c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      c();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void c()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localGroups.group_id + "", localGroups);
        i += 1;
      }
    }
    Groups localGroups = new Groups();
    localGroups.group_id = -1006;
    localGroups.group_name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131562981);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localGroups.group_id + "", localGroups);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList end: " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  protected void c(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (Card)localEntityManager.a(Card.class, paramString);
    if ((paramString != null) && (paramString.iVoteIncrement > 0))
    {
      paramString.iVoteIncrement = 0;
      localEntityManager.a(paramString);
    }
    localEntityManager.a();
  }
  
  public boolean c()
  {
    return (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0));
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
  
  void d()
  {
    c();
    a();
  }
  
  public void d(String paramString)
  {
    Friends localFriends1 = null;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localFriends1 = (Friends)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    Friends localFriends2 = localFriends1;
    if (localFriends1 == null) {
      localFriends2 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
    }
    if (localFriends2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localFriends2);
    }
    a();
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
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager
 * JD-Core Version:    0.7.0.1
 */