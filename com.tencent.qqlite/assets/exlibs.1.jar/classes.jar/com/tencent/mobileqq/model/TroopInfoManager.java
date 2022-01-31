package com.tencent.mobileqq.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.data.TroopVideoUrlEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopInfoManager
  extends Observable
  implements Manager
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "TROOP_INFO_MANAGER_CONFIG";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "VIDEO_GET_TIME";
  public static final int c = 1;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_c_of_type_Boolean;
  private ConcurrentHashMap d;
  
  /* Error */
  public TroopInfoManager(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 39	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_Boolean	Z
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 41	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_Boolean	Z
    //   19: aload_0
    //   20: new 43	java/util/concurrent/ConcurrentHashMap
    //   23: dup
    //   24: invokespecial 44	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   27: putfield 46	com/tencent/mobileqq/model/TroopInfoManager:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 48	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 50	com/tencent/mobileqq/model/TroopInfoManager:jdField_c_of_type_Boolean	Z
    //   40: aload_0
    //   41: new 52	dzf
    //   44: dup
    //   45: aload_0
    //   46: invokestatic 57	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Looper;
    //   49: invokespecial 60	dzf:<init>	(Lcom/tencent/mobileqq/model/TroopInfoManager;Landroid/os/Looper;)V
    //   52: putfield 62	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   55: aload_0
    //   56: aload_1
    //   57: putfield 64	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   65: invokevirtual 75	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   68: putfield 77	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   71: aload_0
    //   72: getfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: ifnonnull +25 -> 100
    //   78: aload_0
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   84: ifnonnull +14 -> 98
    //   87: aload_0
    //   88: new 43	java/util/concurrent/ConcurrentHashMap
    //   91: dup
    //   92: invokespecial 44	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   95: putfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: getfield 79	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   104: ifnonnull +25 -> 129
    //   107: aload_0
    //   108: monitorenter
    //   109: aload_0
    //   110: getfield 79	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: ifnonnull +14 -> 127
    //   116: aload_0
    //   117: new 43	java/util/concurrent/ConcurrentHashMap
    //   120: dup
    //   121: invokespecial 44	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   124: putfield 79	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	TroopInfoManager
    //   0	140	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   80	98	130	finally
    //   98	100	130	finally
    //   131	133	130	finally
    //   109	127	135	finally
    //   127	129	135	finally
    //   136	138	135	finally
  }
  
  private void a(List paramList)
  {
    Object localObject;
    TroopVideoUrlEntity localTroopVideoUrlEntity;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        localTroopVideoUrlEntity = new TroopVideoUrlEntity();
        localTroopVideoUrlEntity.videoUrl = ((String)localObject);
        this.jdField_a_of_type_JavaUtilList.add(localTroopVideoUrlEntity);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean == true) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)((Iterator)localObject).next();
          if (localTroopMessageNavigateInfo != null) {
            if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localTroopMessageNavigateInfo.troopCode))
            {
              localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localTroopMessageNavigateInfo.troopCode);
              if ((localTroopMessageNavigateInfo != null) && (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD))
              {
                localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
                this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopMessageNavigateInfo.troopCode, localTroopMessageNavigateInfo);
              }
            }
            else
            {
              localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_NORMAL;
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopMessageNavigateInfo.troopCode, localTroopMessageNavigateInfo);
            }
          }
        }
      }
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator.next();
      if (localTroopMessageNavigateInfo != null) {
        if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
        }
        else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_MODIFY)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
        }
        else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE)
        {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localTroopMessageNavigateInfo.troopCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
        }
      }
    }
  }
  
  private void d()
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new JSONObject(HttpUtil.a(BaseApplication.getContext(), "http://pub.idqqimg.com/pc/misc/shouq/videohost/whitelist", "GET", null, null));
        if (((JSONObject)localObject1).getInt("ret") == 0)
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("domains");
          if (localObject1 != null)
          {
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              if (localObject2 == null) {
                break label112;
              }
              localObject2 = ((JSONObject)localObject2).getString("dm");
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label112;
              }
              localArrayList.add(localObject2);
              break label112;
            }
          }
        }
        a(localArrayList);
        return;
      }
      catch (Exception localException)
      {
        this.jdField_c_of_type_Boolean = false;
        return;
      }
      label112:
      i += 1;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopVideoUrlEntity.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopVideoUrlEntity localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaUtilList.add(localTroopVideoUrlEntity);
        }
      }
    }
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_c_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0));
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_b_of_type_Boolean;
        if (bool) {
          return;
        }
        this.jdField_b_of_type_Boolean = true;
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAppInfo.class);
        if (localObject1 == null) {
          break label108;
        }
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          TroopAppInfo localTroopAppInfo = (TroopAppInfo)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(localTroopAppInfo.appId), localTroopAppInfo);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.d(TroopInfoManager.class.getSimpleName(), 2, "initTroopAppInfoCache success");
      continue;
      label108:
      if (QLog.isColorLevel()) {
        QLog.d(TroopInfoManager.class.getSimpleName(), 2, "initTroopAppInfoCache failed, query database, return null");
      }
    }
  }
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
    {
      paramString = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString.status == TroopMessageNavigateInfo.STATUS_DELETE) {
        return -1;
      }
      return paramString.type;
    }
    return -1;
  }
  
  public long a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
    {
      paramString = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString.status == TroopMessageNavigateInfo.STATUS_DELETE) {
        return 0L;
      }
      return paramString.msgseq;
    }
    return 0L;
  }
  
  public TroopAppInfo a(Long paramLong)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
  }
  
  public MessageInfo a(String paramString)
  {
    return (MessageInfo)this.d.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    MessageInfo localMessageInfo = (MessageInfo)this.d.get(paramString);
    if ((paramMessageInfo == null) || (!paramMessageInfo.a())) {
      return localMessageInfo;
    }
    if (localMessageInfo == null)
    {
      paramMessageInfo = new MessageInfo(paramMessageInfo);
      this.d.put(paramString, paramMessageInfo);
      return paramMessageInfo;
    }
    localMessageInfo.a(paramMessageInfo);
    return localMessageInfo;
  }
  
  public TroopFeedsDataManager a(Long paramLong, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    TroopFeedsDataManager localTroopFeedsDataManager2 = (TroopFeedsDataManager)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    TroopFeedsDataManager localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
    if (localTroopFeedsDataManager2 == null)
    {
      localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
      if (paramBoolean)
      {
        localTroopFeedsDataManager1 = new TroopFeedsDataManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, localTroopFeedsDataManager1);
      }
    }
    return localTroopFeedsDataManager1;
  }
  
  public ArrayList a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet());
  }
  
  public List a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_c_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    d();
  }
  
  public void a(TroopAppInfo paramTroopAppInfo)
  {
    if (paramTroopAppInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!this.jdField_b_of_type_Boolean) {
          g();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramTroopAppInfo.appId), paramTroopAppInfo);
        paramTroopAppInfo.setStatus(1000);
        if ((a(paramTroopAppInfo)) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.d(TroopInfoManager.class.getSimpleName(), 2, "saveTroopAppInfo failed because DB operation failed");
      }
      finally {}
    }
  }
  
  public void a(Long paramLong)
  {
    try
    {
      if (!this.jdField_b_of_type_Boolean) {
        g();
      }
      TroopAppInfo localTroopAppInfo = (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
      if (localTroopAppInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopAppInfo);
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramLong);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((paramInt == localTroopMessageNavigateInfo.type) || (paramInt == 0))
      {
        if (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_ADD) {
          break label55;
        }
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
    }
    return;
    label55:
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramInt <= 0) {}
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    do
    {
      return;
      localTroopMessageNavigateInfo = new TroopMessageNavigateInfo();
      localTroopMessageNavigateInfo.type = paramInt;
      localTroopMessageNavigateInfo.troopCode = paramString1;
      localTroopMessageNavigateInfo.msgseq = paramLong;
      localTroopMessageNavigateInfo.summary = paramString2;
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)) {
        break;
      }
      paramString2 = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    } while ((paramInt < paramString2.type) && (paramString2.status != TroopMessageNavigateInfo.STATUS_DELETE));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localTroopMessageNavigateInfo);
    if (paramString2.status == TroopMessageNavigateInfo.STATUS_ADD)
    {
      localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
      return;
    }
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
    return;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localTroopMessageNavigateInfo);
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
  }
  
  public void a(String paramString, MessageInfo paramMessageInfo)
  {
    this.d.put(paramString, paramMessageInfo);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) && (!this.jdField_c_of_type_Boolean);
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    e();
    if (a()) {
      return true;
    }
    f();
    paramString = paramString.toLowerCase();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramString.indexOf(((TroopVideoUrlEntity)localIterator.next()).videoUrl.toLowerCase()) != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int b(String paramString)
  {
    return 0;
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.d.remove(paramString);
  }
  
  public boolean b()
  {
    boolean bool = VersionUtils.d();
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    int i;
    if (str1.equalsIgnoreCase("Xiaomi")) {
      if ((str2.equalsIgnoreCase("MI 1S")) || (str2.equalsIgnoreCase("MI 1SC"))) {
        i = 0;
      }
    }
    for (;;)
    {
      if ((bool) && (i != 0))
      {
        return true;
        if (str2.equalsIgnoreCase("MI-ONE Plus")) {
          i = 0;
        }
      }
      else
      {
        return false;
      }
      i = 1;
    }
  }
  
  public void onDestroy()
  {
    c();
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFeedsDataManager localTroopFeedsDataManager = (TroopFeedsDataManager)localIterator.next();
        if (localTroopFeedsDataManager != null)
        {
          localTroopFeedsDataManager.c();
          localTroopFeedsDataManager.deleteObservers();
        }
      }
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.TroopInfoManager
 * JD-Core Version:    0.7.0.1
 */