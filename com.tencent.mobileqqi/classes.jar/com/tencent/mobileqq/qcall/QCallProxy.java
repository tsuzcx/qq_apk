package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gkd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCallProxy
  extends BaseProxy
{
  private static final String jdField_a_of_type_JavaLangString = QCallProxy.class.getSimpleName();
  private static final int jdField_b_of_type_Int = 100;
  private static final int c = 90;
  private int jdField_a_of_type_Int = 20;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List jdField_a_of_type_JavaUtilList = new ArrayList(20);
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public QCallProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  private Object a(String arg1, int paramInt)
  {
    String str = a(???, paramInt);
    if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  private ArrayList a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new gkd(this));
    SparseIntArray localSparseIntArray = new SparseIntArray();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      QCallRecord localQCallRecord1 = (QCallRecord)localIterator.next();
      if ((localQCallRecord1 != null) && (localQCallRecord1.type != QCallRecord.TYPE_DATE))
      {
        if (localSparseIntArray.get(localQCallRecord1.getDate(), -1) == -1)
        {
          QCallRecord localQCallRecord2 = new QCallRecord(QCallRecord.TYPE_DATE);
          localQCallRecord2.time = localQCallRecord1.time;
          localArrayList.add(localQCallRecord2);
          localSparseIntArray.put(localQCallRecord1.getDate(), 0);
        }
        localArrayList.add(localQCallRecord1);
      }
    }
    paramList.clear();
    return localArrayList;
  }
  
  private boolean a(QCallRecord paramQCallRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 5, null);
    return true;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, QCallRecord.getTableName(paramString, paramInt), null, null, 2, null);
    return true;
  }
  
  private String b(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  private List b(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return null;
    }
    paramString = QCallRecord.getTableName(paramString, paramInt);
    paramInt = localSQLiteDatabase.a(paramString);
    if (paramInt > this.jdField_a_of_type_Int) {
      localSQLiteDatabase.a(String.format("delete from %s where time in (select time from %s order by time limit %s)", new Object[] { paramString, paramString, Integer.valueOf(paramInt - this.jdField_a_of_type_Int) }));
    }
    paramString = "select * from " + paramString + " order by time asc";
    return a().a(QCallRecord.class, paramString, null);
  }
  
  private boolean b(QCallRecord paramQCallRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 3, null);
    return true;
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      QCallRecent localQCallRecent2 = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      QCallRecent localQCallRecent1 = localQCallRecent2;
      if (localQCallRecent2 == null)
      {
        localQCallRecent1 = new QCallRecent();
        localQCallRecent1.uin = paramString;
        localQCallRecent1.type = paramInt;
        localQCallRecent1.displayName = localQCallRecent1.uin;
      }
      return localQCallRecent1;
    }
  }
  
  public String a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().concat("_").concat(paramString).concat(String.valueOf(paramInt));
  }
  
  public List a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      return localArrayList;
    }
  }
  
  public List a(String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    Object localObject1 = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    Object localObject2;
    try
    {
      localObject2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localObject2 != null) {
        return localObject2;
      }
      paramString = b(paramString, paramInt);
      if (paramString == null)
      {
        paramString = new ArrayList();
        return paramString;
      }
    }
    finally {}
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("getListRecord ThreadName:").append(Thread.currentThread().getName()).append(" getListRecord (DB) records size:");
      if (paramString == null) {
        break label242;
      }
    }
    label242:
    for (paramInt = paramString.size();; paramInt = 0)
    {
      QLog.d((String)localObject2, 2, paramInt);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getListRecord" + paramString);
      paramString = a(paramString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
      return paramString;
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          d();
          this.jdField_a_of_type_Boolean = true;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 2, localException.getMessage(), localException);
      }
    }
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramQCallRecent);
      this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, paramQCallRecent.type));
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 5, null);
      return;
    }
  }
  
  public void a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord == null) {
      return;
    }
    for (;;)
    {
      synchronized (a(paramQCallRecord.friendUin, paramQCallRecord.uinType))
      {
        String str1 = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
        if (localList == null)
        {
          localList = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
          localList.add(paramQCallRecord);
          if (QLog.isColorLevel())
          {
            String str2 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder().append("insertRecord ThreadName:").append(Thread.currentThread().getName()).append(" insertRecord records size:");
            if (localList != null)
            {
              i = localList.size();
              QLog.d(str2, 2, i);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, a(localList));
            b(paramQCallRecord);
            return;
          }
          int i = 0;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = a(paramString, paramInt);
    localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    if (localObject != null) {
      ((List)localObject).clear();
    }
    a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("Conversation_call_prompt_flag", false);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public QCallRecent b(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      return paramString;
    }
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    e();
    c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 3, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 4, null);
  }
  
  public void b(QCallRecord paramQCallRecord)
  {
    synchronized (a(paramQCallRecord.friendUin, paramQCallRecord.uinType))
    {
      String str = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localList != null)
      {
        localList.remove(paramQCallRecord);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, a(localList));
      }
      a(paramQCallRecord);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void c(QCallRecent paramQCallRecent)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    Object localObject1 = paramQCallRecent;
    for (;;)
    {
      try
      {
        if (paramQCallRecent.type != 1)
        {
          localObject1 = paramQCallRecent;
          if (paramQCallRecent.type != 3000)
          {
            localObject2 = new ArrayList();
            localObject1 = MsgProxyUtils.k;
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              int k = localObject1[i];
              if (k == paramQCallRecent.type) {
                break label567;
              }
              QCallRecent localQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, k));
              if (localQCallRecent == null) {
                break label567;
              }
              ((ArrayList)localObject2).add(localQCallRecent);
              break label567;
            }
            j = ((ArrayList)localObject2).size();
            localObject1 = paramQCallRecent;
            if (j > 0)
            {
              if (paramQCallRecent.getStatus() != 1000) {
                break label562;
              }
              localObject1 = (QCallRecent)((ArrayList)localObject2).get(0);
              this.jdField_a_of_type_JavaUtilList.remove(localObject1);
              ((QCallRecent)localObject1).type = paramQCallRecent.type;
              ((QCallRecent)localObject1).troopUin = paramQCallRecent.troopUin;
              ((QCallRecent)localObject1).displayName = paramQCallRecent.displayName;
              ((QCallRecent)localObject1).lastCallTime = paramQCallRecent.lastCallTime;
              ((QCallRecent)localObject1).lastCallMsg = paramQCallRecent.lastCallMsg;
              ((QCallRecent)localObject1).sendFlag = paramQCallRecent.sendFlag;
              ((QCallRecent)localObject1).isVideo = paramQCallRecent.isVideo;
              ((QCallRecent)localObject1).missedCallCount = paramQCallRecent.missedCallCount;
              i = 1;
              paramQCallRecent = (QCallRecent)localObject1;
              localObject1 = paramQCallRecent;
              if (i < j)
              {
                localObject1 = (QCallRecent)((ArrayList)localObject2).get(i);
                this.jdField_a_of_type_JavaUtilList.remove(localObject1);
                a((QCallRecent)localObject1);
                i += 1;
                continue;
              }
            }
          }
        }
        paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
        Object localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRecentCall before put:" + Arrays.toString((Object[])localObject2));
        }
        this.jdField_a_of_type_JavaUtilMap.put(b(((QCallRecent)localObject1).uin, ((QCallRecent)localObject1).type), localObject1);
        paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
        localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRecentCall after put:" + Arrays.toString((Object[])localObject2));
        }
        this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          paramQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilList.get(i);
          if (((QCallRecent)localObject1).lastCallTime > paramQCallRecent.lastCallTime)
          {
            this.jdField_a_of_type_JavaUtilList.add(i, localObject1);
            i = 1;
            if (i == 0) {
              this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), localObject1);
            }
            b((QCallRecent)localObject1);
            return;
          }
          i += 1;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label562:
      int i = 0;
      continue;
      label567:
      i += 1;
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: getstatic 27	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc_w 440
    //   13: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 74	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   24: aload_0
    //   25: getfield 74	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: invokevirtual 252	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   31: iconst_0
    //   32: invokevirtual 351	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: ldc_w 359
    //   38: iconst_1
    //   39: invokeinterface 444 3 0
    //   44: putfield 342	com/tencent/mobileqq/qcall/QCallProxy:jdField_b_of_type_Boolean	Z
    //   47: aload_0
    //   48: getfield 74	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   51: invokevirtual 79	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   54: invokevirtual 84	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: astore 8
    //   59: aload 8
    //   61: ldc 242
    //   63: iconst_0
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: ldc_w 446
    //   71: aconst_null
    //   72: invokevirtual 449	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   75: astore 6
    //   77: aload 6
    //   79: ifnull +271 -> 350
    //   82: aload 6
    //   84: invokeinterface 299 1 0
    //   89: ifle +261 -> 350
    //   92: aload 6
    //   94: invokeinterface 299 1 0
    //   99: bipush 100
    //   101: if_icmple +293 -> 394
    //   104: invokestatic 455	java/lang/System:currentTimeMillis	()J
    //   107: lstore_1
    //   108: aload 8
    //   110: new 457	java/lang/StringBuffer
    //   113: dup
    //   114: invokespecial 458	java/lang/StringBuffer:<init>	()V
    //   117: ldc_w 460
    //   120: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   123: ldc_w 465
    //   126: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: ldc_w 467
    //   132: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: aload 6
    //   137: bipush 90
    //   139: invokeinterface 433 2 0
    //   144: checkcast 242	com/tencent/mobileqq/data/QCallRecent
    //   147: getfield 397	com/tencent/mobileqq/data/QCallRecent:lastCallTime	J
    //   150: invokevirtual 470	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   153: ldc_w 472
    //   156: invokevirtual 463	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: invokevirtual 473	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   162: invokevirtual 475	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   165: istore 5
    //   167: iload 5
    //   169: ifeq +222 -> 391
    //   172: new 55	java/util/ArrayList
    //   175: dup
    //   176: aload 6
    //   178: iconst_0
    //   179: bipush 90
    //   181: invokeinterface 479 3 0
    //   186: invokespecial 482	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   189: astore 7
    //   191: aload 7
    //   193: astore 6
    //   195: aload 6
    //   197: astore 7
    //   199: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +51 -> 253
    //   205: invokestatic 455	java/lang/System:currentTimeMillis	()J
    //   208: lstore_3
    //   209: getstatic 27	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   212: iconst_2
    //   213: new 186	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 484
    //   223: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: iload 5
    //   228: invokevirtual 487	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   231: ldc_w 489
    //   234: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload_3
    //   238: lload_1
    //   239: lsub
    //   240: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload 6
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 60	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   257: aload 7
    //   259: invokeinterface 266 2 0
    //   264: pop
    //   265: aload_0
    //   266: getfield 60	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   269: invokeinterface 122 1 0
    //   274: astore 6
    //   276: aload 6
    //   278: invokeinterface 127 1 0
    //   283: ifeq +67 -> 350
    //   286: aload 6
    //   288: invokeinterface 131 1 0
    //   293: checkcast 242	com/tencent/mobileqq/data/QCallRecent
    //   296: astore 7
    //   298: aload_0
    //   299: getfield 65	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   302: aload_0
    //   303: aload 7
    //   305: getfield 246	com/tencent/mobileqq/data/QCallRecent:uin	Ljava/lang/String;
    //   308: aload 7
    //   310: getfield 247	com/tencent/mobileqq/data/QCallRecent:type	I
    //   313: invokespecial 237	com/tencent/mobileqq/qcall/QCallProxy:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   316: aload 7
    //   318: invokeinterface 430 3 0
    //   323: pop
    //   324: goto -48 -> 276
    //   327: astore 7
    //   329: getstatic 27	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   332: iconst_4
    //   333: aload 7
    //   335: invokevirtual 313	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: aload 7
    //   340: invokestatic 494	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   343: aload 6
    //   345: astore 7
    //   347: goto -94 -> 253
    //   350: getstatic 27	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   353: iconst_4
    //   354: aload_0
    //   355: getfield 60	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   358: invokevirtual 495	java/lang/Object:toString	()Ljava/lang/String;
    //   361: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 8
    //   366: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   369: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +13 -> 385
    //   375: getstatic 27	com/tencent/mobileqq/qcall/QCallProxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   378: iconst_2
    //   379: ldc_w 497
    //   382: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: return
    //   386: astore 7
    //   388: goto -59 -> 329
    //   391: goto -196 -> 195
    //   394: aload 6
    //   396: astore 7
    //   398: goto -145 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	QCallProxy
    //   107	132	1	l1	long
    //   208	30	3	l2	long
    //   165	62	5	bool	boolean
    //   75	320	6	localObject1	Object
    //   189	128	7	localObject2	Object
    //   327	12	7	localException1	Exception
    //   345	1	7	localObject3	Object
    //   386	1	7	localException2	Exception
    //   396	1	7	localObject4	Object
    //   57	308	8	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   108	167	327	java/lang/Exception
    //   172	191	327	java/lang/Exception
    //   199	249	386	java/lang/Exception
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy
 * JD-Core Version:    0.7.0.1
 */