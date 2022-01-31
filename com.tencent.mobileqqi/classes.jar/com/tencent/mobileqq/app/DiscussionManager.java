package com.tencent.mobileqq.app;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class DiscussionManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 100;
  public static final String a = "Q.contacttab.dscs";
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  public DiscussionManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "setDiscussionMemberNum disUin=" + paramString + " count=" + paramInt);
    }
    this.b.put(paramString, Long.valueOf(paramInt));
  }
  
  private void c()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      this.b.clear();
      if (localObject2 == null) {
        break label285;
      }
      b();
      localArrayList = new ArrayList(10);
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((ArrayList)localObject2).get(i);
        localConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
        if (ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDiscussionInfo))
        {
          Map localMap = a(localDiscussionInfo.uin);
          if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDiscussionInfo.uin, localDiscussionInfo, localMap, false)) {
            localArrayList.add(localDiscussionInfo);
          }
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache, updateList=" + localArrayList.size());
    }
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      i = j;
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
    label285:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "buildDiscussUI begin: ");
      }
      ArrayList localArrayList1 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        break label132;
      }
      int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      if (i <= 0) {
        break label132;
      }
      localArrayList1.ensureCapacity(i);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
        if ((localDiscussionInfo.mCompareSpell == null) || (localDiscussionInfo.mCompareSpell.length() == 0)) {
          ContactSorter.a(localDiscussionInfo);
        }
        localArrayList1.add(localDiscussionInfo);
      }
      if (i <= 1) {
        break label132;
      }
    }
    finally {}
    ContactSorter.a(localArrayList2);
    label132:
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "buildDiscussUI end: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public int a(String paramString)
  {
    paramString = (Long)this.b.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public DiscussionInfo a(String paramString)
  {
    Object localObject;
    if (!DiscussionInfo.isValidDisUin(paramString)) {
      localObject = null;
    }
    do
    {
      do
      {
        return localObject;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "findDiscussionInfoByID " + paramString);
        }
        localDiscussionInfo = (DiscussionInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localDiscussionInfo;
      } while (localDiscussionInfo != null);
      localObject = localDiscussionInfo;
    } while (this.jdField_a_of_type_Boolean);
    DiscussionInfo localDiscussionInfo = (DiscussionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("findDiscussionInfoByID db ");
      if (localDiscussionInfo == null) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.contacttab.dscs", 2, bool);
      localObject = localDiscussionInfo;
      if (localDiscussionInfo == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localDiscussionInfo);
      return localDiscussionInfo;
    }
  }
  
  public DiscussionMemberInfo a(String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = a(paramString1);
    if (paramString1 != null) {
      paramString1 = (DiscussionMemberInfo)paramString1.get(paramString2);
    }
    do
    {
      return paramString1;
      paramString1 = localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfo null");
    return null;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    paramString = a(paramString);
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (paramString.size() > 0)) {
      localArrayList.addAll(paramString.values());
    }
    return localArrayList;
  }
  
  public Map a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin param is null");
      }
      return null;
    }
    Object localObject2 = (Map)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("getDiscussionMemberInfoListByUin from map list disUin=").append(paramString).append(" size=");
        if (localObject2 != null) {
          break label101;
        }
        i = -1;
        label82:
        QLog.d("Q.contacttab.dscs", 2, i);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return localObject1;
      label101:
      i = ((Map)localObject2).size();
      break label82;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? ", new String[] { paramString }, null, null, "memberUin", null);
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from DB list is null disUin=" + paramString);
        return null;
      }
      localObject1 = new HashMap(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject2).next();
        ((Map)localObject1).put(localDiscussionMemberInfo.memberUin, localDiscussionMemberInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from db list disUin=" + paramString + " size=" + ((Map)localObject1).size());
      }
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
    }
  }
  
  public void a()
  {
    c();
    d();
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("saveDiscussInfo ");
      if (paramDiscussionInfo == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject1 = paramDiscussionInfo.uin;; localObject1 = Integer.valueOf(-1))
    {
      QLog.d("Q.contacttab.dscs", 2, localObject1);
      if (paramDiscussionInfo != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDiscussionInfo.uin, paramDiscussionInfo);
    }
    a(paramDiscussionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject2 = ((ProxyManager)localObject1).a().a(paramDiscussionInfo.uin, 3000);
    if (((RecentUser)localObject2).getStatus() == 1001)
    {
      ((RecentUser)localObject2).displayName = paramDiscussionInfo.discussionName;
      ((ProxyManager)localObject1).a().a((RecentUser)localObject2);
    }
    d();
  }
  
  public void a(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    if (paramDiscussionMemberInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfo " + paramDiscussionMemberInfo);
      }
      Map localMap = a(paramDiscussionMemberInfo.discussionUin);
      if (localMap != null) {
        localMap.put(paramDiscussionMemberInfo.memberUin, paramDiscussionMemberInfo);
      }
      a(paramDiscussionMemberInfo);
      DiscussionInfo localDiscussionInfo = a(paramDiscussionMemberInfo.discussionUin);
      if ((localDiscussionInfo != null) && (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionMemberInfo.discussionUin, localDiscussionInfo, localMap, false))) {
        a(localDiscussionInfo);
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMember disUin=" + paramString1 + " memberUin=" + paramString2);
    }
    Object localObject1 = (Map)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (DiscussionMemberInfo)((Map)localObject1).remove(paramString2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        if ("removed from cache " + localObject2 == null) {
          break label193;
        }
        localObject1 = "true";
        QLog.d("Q.contacttab.dscs", 2, (String)localObject1);
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, new String[] { paramString1, paramString2 });
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject2);
        a(paramString1, a(paramString1) - 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "removed from db ");
        }
      }
      return;
      label193:
      localObject1 = "false";
      break;
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList) {}
  
  public void a(String paramString, Set paramSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers disuin=" + paramString);
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) || (paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        localMap = a(paramString);
        if (localMap != null)
        {
          paramSet = paramSet.iterator();
          while (paramSet.hasNext())
          {
            String str = (String)paramSet.next();
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localMap.remove(str);
            if (localDiscussionMemberInfo != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionMemberInfo);
              if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "remove member=" + str.substring(0, 4));
              }
            }
          }
        }
      }
      catch (Exception paramSet)
      {
        Map localMap;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers exp disUin=" + paramString, paramSet);
        }
        return;
        paramSet = a(paramString);
        if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramSet, localMap, false)) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramSet);
        }
        localEntityTransaction.c();
        if (localMap != null) {
          a(paramString, localMap.size());
        }
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("queryDiscs_" + paramList.size());
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "preloadData size=" + paramList.size());
    }
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i = 1;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i += 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (DiscussionInfo)paramList.next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((DiscussionInfo)localObject).uin, localObject);
        }
      }
    }
    TraceUtils.a();
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
    DiscussionInfo localDiscussionInfo = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscuss uin=" + paramString);
    }
    if (localDiscussionInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
      paramString = "delete from DiscussionMemberInfo where discussionUin='" + paramString + "'";
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionInfo);
      d();
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    if ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin=?", new String[] { paramString1, paramString2 }, null, null, "memberUin", null) != null) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public boolean a(String paramString, Map paramMap, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +54 -> 57
    //   6: ldc 12
    //   8: iconst_2
    //   9: new 70	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 418
    //   19: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 420
    //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokeinterface 245 1 0
    //   38: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 422
    //   44: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: lload_3
    //   48: invokevirtual 425	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 40	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 282	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast 237	java/util/Map
    //   69: astore 6
    //   71: aload 6
    //   73: ifnull +56 -> 129
    //   76: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +50 -> 129
    //   82: ldc 12
    //   84: iconst_2
    //   85: new 70	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 427
    //   95: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 6
    //   100: invokeinterface 245 1 0
    //   105: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: ldc_w 429
    //   111: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_2
    //   115: invokeinterface 245 1 0
    //   120: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload_0
    //   130: aload_1
    //   131: aload_2
    //   132: invokeinterface 245 1 0
    //   137: invokespecial 352	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;I)V
    //   140: new 431	java/util/HashSet
    //   143: dup
    //   144: invokespecial 432	java/util/HashSet:<init>	()V
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 60	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   153: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   156: astore 6
    //   158: aload 6
    //   160: invokevirtual 154	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   163: aload_2
    //   164: invokeinterface 436 1 0
    //   169: invokeinterface 364 1 0
    //   174: astore 8
    //   176: aload 8
    //   178: invokeinterface 190 1 0
    //   183: ifeq +150 -> 333
    //   186: aload 8
    //   188: invokeinterface 194 1 0
    //   193: checkcast 438	java/util/Map$Entry
    //   196: astore 9
    //   198: aload 9
    //   200: invokeinterface 441 1 0
    //   205: checkcast 199	java/lang/String
    //   208: astore 10
    //   210: aload 9
    //   212: invokeinterface 444 1 0
    //   217: checkcast 240	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   220: astore 9
    //   222: new 70	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   229: aload 9
    //   231: getfield 328	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   234: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 446
    //   240: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 9
    //   245: getfield 278	com/tencent/mobileqq/data/DiscussionMemberInfo:memberUin	Ljava/lang/String;
    //   248: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 10
    //   256: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +30 -> 289
    //   262: ldc 12
    //   264: iconst_2
    //   265: new 70	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 448
    //   275: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 10
    //   280: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload 7
    //   291: aload 10
    //   293: invokevirtual 451	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   296: ifne -120 -> 176
    //   299: aload_0
    //   300: aload 9
    //   302: invokevirtual 159	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   305: pop
    //   306: goto -130 -> 176
    //   309: astore_1
    //   310: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +13 -> 326
    //   316: ldc 12
    //   318: iconst_2
    //   319: ldc_w 453
    //   322: aload_1
    //   323: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   326: aload 6
    //   328: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   331: iconst_0
    //   332: ireturn
    //   333: aload_0
    //   334: getfield 47	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   337: invokevirtual 456	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   340: ifnull +76 -> 416
    //   343: aload_0
    //   344: getfield 47	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: invokevirtual 456	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   350: new 240	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   353: dup
    //   354: invokespecial 457	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   357: invokevirtual 460	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   360: ldc_w 462
    //   363: iconst_2
    //   364: anewarray 199	java/lang/String
    //   367: dup
    //   368: iconst_0
    //   369: aload_1
    //   370: aastore
    //   371: dup
    //   372: iconst_1
    //   373: lload_3
    //   374: invokestatic 465	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   377: aastore
    //   378: invokevirtual 470	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   381: istore 5
    //   383: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +30 -> 416
    //   389: ldc 12
    //   391: iconst_2
    //   392: new 70	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 472
    //   402: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: iload 5
    //   407: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload_0
    //   417: aload_1
    //   418: invokevirtual 330	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   421: astore 7
    //   423: aload_0
    //   424: getfield 47	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: aload_1
    //   428: aload 7
    //   430: aload_2
    //   431: iconst_0
    //   432: invokestatic 141	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   435: ifeq +13 -> 448
    //   438: aload_0
    //   439: getfield 60	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   442: aload 7
    //   444: invokevirtual 376	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   447: pop
    //   448: aload 6
    //   450: invokevirtual 161	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   453: aload 6
    //   455: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   458: iconst_1
    //   459: ireturn
    //   460: astore_1
    //   461: aload 6
    //   463: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   466: aload_1
    //   467: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	DiscussionManager
    //   0	468	1	paramString	String
    //   0	468	2	paramMap	Map
    //   0	468	3	paramLong	long
    //   381	25	5	i	int
    //   69	393	6	localObject1	Object
    //   147	296	7	localObject2	Object
    //   174	13	8	localIterator	Iterator
    //   196	105	9	localObject3	Object
    //   208	84	10	str	String
    // Exception table:
    //   from	to	target	type
    //   163	176	309	java/lang/Exception
    //   176	289	309	java/lang/Exception
    //   289	306	309	java/lang/Exception
    //   333	416	309	java/lang/Exception
    //   416	448	309	java/lang/Exception
    //   448	453	309	java/lang/Exception
    //   163	176	460	finally
    //   176	289	460	finally
    //   289	306	460	finally
    //   310	326	460	finally
    //   333	416	460	finally
    //   416	448	460	finally
    //   448	453	460	finally
  }
  
  boolean a(ArrayList paramArrayList, long paramLong)
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    label293:
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        int i;
        DiscussionInfo localDiscussionInfo;
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          i = 0;
          if (i < paramArrayList.size())
          {
            localDiscussionInfo = (DiscussionInfo)paramArrayList.get(i);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
            a(localDiscussionInfo);
            if (!QLog.isColorLevel()) {
              break label293;
            }
            QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been updated");
            break label293;
          }
        }
        paramArrayList = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (paramArrayList.hasNext())
        {
          localDiscussionInfo = (DiscussionInfo)((Map.Entry)paramArrayList.next()).getValue();
          if (localDiscussionInfo.timeSec < paramLong)
          {
            paramArrayList.remove();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionInfo);
            if (QLog.isColorLevel()) {
              QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been removed");
            }
          }
        }
        else
        {
          boolean bool;
          i += 1;
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 2, "saveAllDiscussions exception:", paramArrayList);
        }
        localEntityTransaction.b();
        bool = false;
        d();
        return bool;
        localEntityTransaction.c();
        localEntityTransaction.b();
        bool = true;
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  public ArrayList b(String paramString)
  {
    ArrayList localArrayList = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin<>? ", new String[] { paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() }, null, null, "memberUin", String.valueOf(5));
    paramString = localArrayList;
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localArrayList.add(((DiscussionMemberInfo)((Iterator)localObject).next()).memberUin);
      }
    }
    return paramString;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 47	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   11: ldc_w 502
    //   14: aconst_null
    //   15: invokevirtual 505	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore 4
    //   20: aload 4
    //   22: astore_2
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokeinterface 510 1 0
    //   33: ifeq +60 -> 93
    //   36: aload 4
    //   38: astore_2
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 514 2 0
    //   50: istore_1
    //   51: aload 4
    //   53: astore_2
    //   54: aload 4
    //   56: astore_3
    //   57: aload_0
    //   58: aload 4
    //   60: iconst_1
    //   61: invokeinterface 517 2 0
    //   66: iload_1
    //   67: invokespecial 352	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;I)V
    //   70: goto -50 -> 20
    //   73: astore 4
    //   75: aload_2
    //   76: astore_3
    //   77: aload 4
    //   79: invokevirtual 520	java/lang/Exception:printStackTrace	()V
    //   82: aload_2
    //   83: ifnull +9 -> 92
    //   86: aload_2
    //   87: invokeinterface 523 1 0
    //   92: return
    //   93: aload 4
    //   95: ifnull -3 -> 92
    //   98: aload 4
    //   100: invokeinterface 523 1 0
    //   105: return
    //   106: astore_2
    //   107: aload_3
    //   108: ifnull +9 -> 117
    //   111: aload_3
    //   112: invokeinterface 523 1 0
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	DiscussionManager
    //   50	17	1	i	int
    //   3	84	2	localObject1	Object
    //   106	12	2	localObject2	Object
    //   1	111	3	localObject3	Object
    //   18	41	4	localCursor	android.database.Cursor
    //   73	26	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	20	73	java/lang/Exception
    //   26	36	73	java/lang/Exception
    //   42	51	73	java/lang/Exception
    //   57	70	73	java/lang/Exception
    //   4	20	106	finally
    //   26	36	106	finally
    //   42	51	106	finally
    //   57	70	106	finally
    //   77	82	106	finally
  }
  
  /* Error */
  public void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 12
    //   8: iconst_2
    //   9: new 70	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 525
    //   19: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 527
    //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 60	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 154	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload_0
    //   63: getfield 60	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: ldc 240
    //   68: iconst_0
    //   69: ldc_w 529
    //   72: iconst_1
    //   73: anewarray 199	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: aconst_null
    //   81: aconst_null
    //   82: ldc_w 267
    //   85: aconst_null
    //   86: invokevirtual 112	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   89: checkcast 42	java/util/ArrayList
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +174 -> 270
    //   99: aload 4
    //   101: invokevirtual 116	java/util/ArrayList:size	()I
    //   104: ifle +166 -> 270
    //   107: aload 4
    //   109: invokevirtual 530	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   112: astore 4
    //   114: aload 4
    //   116: invokeinterface 190 1 0
    //   121: ifeq +149 -> 270
    //   124: aload 4
    //   126: invokeinterface 194 1 0
    //   131: checkcast 240	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   134: getfield 328	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   137: astore 5
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 330	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   145: astore 6
    //   147: aload_0
    //   148: aload 5
    //   150: invokevirtual 138	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Ljava/util/Map;
    //   153: astore 7
    //   155: aload 7
    //   157: ifnull +45 -> 202
    //   160: aload 7
    //   162: aload_1
    //   163: invokeinterface 238 2 0
    //   168: checkcast 240	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   171: astore 8
    //   173: aload 8
    //   175: ifnull +27 -> 202
    //   178: aload 8
    //   180: aload_2
    //   181: putfield 533	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   184: aload 8
    //   186: ldc2_w 534
    //   189: putfield 538	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   192: aload_0
    //   193: getfield 60	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   196: aload 8
    //   198: invokevirtual 376	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   201: pop
    //   202: aload 6
    //   204: ifnull -90 -> 114
    //   207: aload 6
    //   209: aload 6
    //   211: getfield 541	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   214: ldc2_w 542
    //   217: lor
    //   218: putfield 541	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   221: aload_0
    //   222: getfield 47	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   225: aload 5
    //   227: aload 6
    //   229: aload 7
    //   231: iconst_0
    //   232: invokestatic 141	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   235: ifeq -121 -> 114
    //   238: aload_0
    //   239: aload 6
    //   241: invokevirtual 159	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   244: pop
    //   245: goto -131 -> 114
    //   248: astore_1
    //   249: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +13 -> 265
    //   255: ldc 12
    //   257: iconst_2
    //   258: ldc_w 545
    //   261: aload_1
    //   262: invokestatic 548	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_3
    //   266: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   269: return
    //   270: aload_3
    //   271: invokevirtual 161	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   274: aload_3
    //   275: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   278: return
    //   279: astore_1
    //   280: aload_3
    //   281: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   284: aload_1
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	DiscussionManager
    //   0	286	1	paramString1	String
    //   0	286	2	paramString2	String
    //   57	224	3	localEntityTransaction	EntityTransaction
    //   92	33	4	localObject	Object
    //   137	89	5	str	String
    //   145	95	6	localDiscussionInfo	DiscussionInfo
    //   153	77	7	localMap	Map
    //   171	26	8	localDiscussionMemberInfo	DiscussionMemberInfo
    // Exception table:
    //   from	to	target	type
    //   58	94	248	java/lang/Exception
    //   99	114	248	java/lang/Exception
    //   114	155	248	java/lang/Exception
    //   160	173	248	java/lang/Exception
    //   178	202	248	java/lang/Exception
    //   207	245	248	java/lang/Exception
    //   270	274	248	java/lang/Exception
    //   58	94	279	finally
    //   99	114	279	finally
    //   114	155	279	finally
    //   160	173	279	finally
    //   178	202	279	finally
    //   207	245	279	finally
    //   249	265	279	finally
    //   270	274	279	finally
  }
  
  public void b(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList");
    }
    int i;
    if (paramList == null)
    {
      i = 1;
      if (paramList.size() != 0) {
        break label44;
      }
    }
    label44:
    for (int j = 1;; j = 0)
    {
      if ((i | j) == 0) {
        break label49;
      }
      return;
      i = 0;
      break;
    }
    label49:
    if (paramList.size() == 1)
    {
      a((DiscussionMemberInfo)paramList.get(0));
      return;
    }
    HashSet localHashSet = new HashSet();
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    localEntityTransaction.a();
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localStringBuffer = new StringBuffer();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.next();
            String str = localDiscussionMemberInfo.discussionUin + "_" + localDiscussionMemberInfo.memberUin;
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(str);
              localStringBuffer.append(";");
            }
            if (localHashSet.contains(str)) {
              continue;
            }
            a(localDiscussionMemberInfo);
            localHashSet.add(str);
            continue;
          }
        }
        StringBuffer localStringBuffer = null;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList ex=", paramList);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList info=" + localStringBuffer.toString());
        }
        localEntityTransaction.c();
        return;
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionManager
 * JD-Core Version:    0.7.0.1
 */