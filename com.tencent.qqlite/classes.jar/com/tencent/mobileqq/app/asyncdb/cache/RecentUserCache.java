package com.tencent.mobileqq.app.asyncdb.cache;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cws;
import cwt;
import cwu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class RecentUserCache
  extends FullCache
{
  private static final int jdField_a_of_type_Int = 99;
  private static final String jdField_a_of_type_JavaLangString = "Q.db.Cache.RecentUserCache";
  public static final boolean a = true;
  private static final int jdField_b_of_type_Int = 90;
  private static final String jdField_b_of_type_JavaLangString = "check_newfriend_when_upgrade";
  private static final String c = "new_friend_upgrade_pref";
  Comparator jdField_b_of_type_JavaUtilComparator = new cwt(this);
  protected ConcurrentHashMap b;
  
  public RecentUserCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, RecentUser.class);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new RecentUserCache.CacheMap(this, null);
    d();
  }
  
  private RecentUser a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.troopUin == null) {
      paramRecentUser.troopUin = "";
    }
    if (paramRecentUser.displayName == null) {
      paramRecentUser.displayName = "";
    }
    return paramRecentUser;
  }
  
  private final String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(0, 4);
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  private void a(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser != null) {
        if ((localObject1 == null) && (AppConstants.Y.equals(localRecentUser.uin)))
        {
          localObject1 = localRecentUser;
        }
        else if ((localObject2 == null) && ((AppConstants.V.equals(localRecentUser.uin)) || (4000 == localRecentUser.type)))
        {
          if ((localRecentUser.msg == null) && (localRecentUser.msgData != null)) {
            localRecentUser.doParse();
          }
          if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String))) {
            localObject2 = localRecentUser;
          }
        }
      }
    }
    if (localObject1 != null) {
      paramList.remove(localObject1);
    }
    if (localObject2 != null)
    {
      paramList.remove(localObject2);
      long l = localObject2.getId();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cws(this, l));
    }
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("new_friend_upgrade_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_newfriend_when_upgrade", true))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | descRecentList == null");
      }
    }
    return;
    label71:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cwu(this, localSharedPreferences));
  }
  
  public RecentUser a(String paramString, int paramInt)
  {
    RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt));
    if (localRecentUser == null)
    {
      localRecentUser = new RecentUser();
      localRecentUser.uin = paramString;
      localRecentUser.type = paramInt;
      localRecentUser.displayName = localRecentUser.uin;
      localRecentUser.parse();
      a(localRecentUser);
      paramString = localRecentUser;
    }
    do
    {
      return paramString;
      paramString = localRecentUser;
    } while (localRecentUser.msg != null);
    if (localRecentUser.mIsParsed)
    {
      localRecentUser.reParse();
      return localRecentUser;
    }
    localRecentUser.parse();
    return localRecentUser;
  }
  
  public String a(Entity paramEntity)
  {
    paramEntity = (RecentUser)paramEntity;
    return paramEntity.uin + "&" + paramEntity.type;
  }
  
  public Comparator a()
  {
    return this.jdField_b_of_type_JavaUtilComparator;
  }
  
  protected void a() {}
  
  public void a(RecentUser paramRecentUser)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser);
    }
    Object localObject1 = paramRecentUser;
    Object localObject2;
    if (paramRecentUser.type != 1)
    {
      localObject1 = paramRecentUser;
      if (paramRecentUser.type != 3000)
      {
        localObject1 = paramRecentUser;
        if (paramRecentUser.type != 7000)
        {
          localObject2 = new ArrayList();
          localObject1 = MsgProxyUtils.i;
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            int k = localObject1[i];
            if (k != paramRecentUser.type)
            {
              String str = a(paramRecentUser.uin, k);
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
                ((ArrayList)localObject2).add(str);
              }
            }
            i += 1;
          }
          j = ((ArrayList)localObject2).size();
          localObject1 = paramRecentUser;
          if (j > 0)
          {
            i = 0;
            if (i < j)
            {
              if (i == 0)
              {
                localObject1 = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((ArrayList)localObject2).get(i));
                ((RecentUser)localObject1).type = paramRecentUser.type;
                ((RecentUser)localObject1).displayName = paramRecentUser.displayName;
                ((RecentUser)localObject1).lastmsgtime = paramRecentUser.lastmsgtime;
                ((RecentUser)localObject1).troopUin = paramRecentUser.troopUin;
                ((RecentUser)localObject1).lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
                ((RecentUser)localObject1).msgData = paramRecentUser.msgData;
                ((RecentUser)localObject1).msgType = paramRecentUser.msgType;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((ArrayList)localObject2).get(i));
                paramRecentUser = (RecentUser)localObject1;
              }
              for (;;)
              {
                i += 1;
                break;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((ArrayList)localObject2).get(i));
                this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.a((Entity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((ArrayList)localObject2).get(i)), 2, 0, null);
              }
            }
            localObject1 = paramRecentUser;
          }
        }
      }
    }
    a((RecentUser)localObject1);
    if (QLog.isColorLevel())
    {
      paramRecentUser = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (paramRecentUser.hasNext()) {
        localObject2 = (RecentUser)((Map.Entry)paramRecentUser.next()).getValue();
      }
    }
    a((Entity)localObject1);
    if (QLog.isColorLevel())
    {
      paramRecentUser = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (paramRecentUser.hasNext()) {
        localObject1 = (RecentUser)((Map.Entry)paramRecentUser.next()).getValue();
      }
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    return (paramString != null) && (paramString.isEmpty());
  }
  
  public boolean a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      return (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt)) != null;
    }
  }
  
  public RecentUser b(String paramString, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        paramString = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt));
        if (paramString == null) {
          return null;
        }
        if (paramString.msg == null)
        {
          if (paramString.mIsParsed) {
            paramString.reParse();
          }
        }
        else {
          return paramString;
        }
      }
      paramString.parse();
    }
  }
  
  public List b()
  {
    try
    {
      List localList = a();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((RecentUser)localIterator.next()).parse();
      }
      return localException;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getCacheList is error!", localException);
      }
      return new ArrayList();
    }
  }
  
  protected void b() {}
  
  public void b(RecentUser paramRecentUser)
  {
    c(paramRecentUser);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  protected void d()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject1 = localEntityManager.a(RecentUser.class, false, null, null, null, null, "lastmsgtime desc", null);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = RecentUser.class.getSimpleName();
      localObject1 = localEntityManager.a(RecentUser.class, (String)localObject2, false, null, null, null, null, "lastmsgtime desc", null);
      if (localObject1 != null)
      {
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser = (RecentUser)localIterator.next();
          localRecentUser.setStatus(1000);
          localRecentUser.setId(-1L);
          a(localRecentUser);
        }
        localEntityManager.a((String)localObject2);
      }
    }
    label419:
    label433:
    label440:
    for (;;)
    {
      localEntityManager.a();
      a((List)localObject1);
      Collections.sort((List)localObject1, a());
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label419;
          }
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          a((RecentUser)localObject2);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a((Entity)localObject2), localObject2);
          continue;
          localObject1 = new ArrayList(20);
          break;
          if (((List)localObject1).size() <= 99) {
            break label440;
          }
          long l = System.currentTimeMillis();
          try
          {
            localObject2 = new RecentUser().getTableName();
            bool = localEntityManager.b("delete from " + (String)localObject2 + " where max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)((List)localObject1).get(90)).lastmsgtime, ((RecentUser)((List)localObject1).get(90)).lastmsgdrafttime) + "; ");
            if (!bool) {
              break label433;
            }
            localObject2 = new ArrayList(((List)localObject1).subList(0, 90));
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              boolean bool;
              Exception localException3 = localException1;
              continue;
              Object localObject3 = localObject1;
            }
          }
          localObject1 = localObject2;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.db.Cache.RecentUserCache", 2, "doInit int recentUserProxy delete recent table >99 isOk = " + bool + "; time = " + (System.currentTimeMillis() - l));
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            localObject1 = localObject2;
          }
        }
        localException2.printStackTrace();
        break;
      }
      e();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache
 * JD-Core Version:    0.7.0.1
 */