package com.tencent.mobileqq.app.proxy;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import fpb;
import fpc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentUserProxy
  extends BaseProxy
{
  private static final int jdField_a_of_type_Int = 100;
  private static final String jdField_a_of_type_JavaLangString = "RecentUserProxy";
  public static final boolean a = true;
  private static final int jdField_b_of_type_Int = 90;
  private static final String jdField_b_of_type_JavaLangString = "check_newfriend_when_upgrade";
  private static final int jdField_c_of_type_Int = 30;
  private static final String jdField_c_of_type_JavaLangString = "new_friend_upgrade_pref";
  private List jdField_a_of_type_JavaUtilList;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public RecentUserProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
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
  
  private void c(RecentUser paramRecentUser)
  {
    this.a.c(paramRecentUser.uin, paramRecentUser.type, paramRecentUser.getTableName(), paramRecentUser, 5, null);
  }
  
  private void d()
  {
    if (this.b) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilList = localEntityManager.a(RecentUser.class, false, null, null, null, null, "lastmsgtime desc", null);
    Object localObject1;
    Object localObject3;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      localObject1 = RecentUser.class.getSimpleName();
      this.jdField_a_of_type_JavaUtilList = localEntityManager.a(RecentUser.class, (String)localObject1, false, null, null, null, null, "lastmsgtime desc", null);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          localRecentUser.setStatus(1000);
          localRecentUser.setId(-1L);
          d(localRecentUser);
          this.jdField_a_of_type_JavaUtilMap.put(a(localRecentUser.uin, localRecentUser.type), localRecentUser);
        }
        localEntityManager.a((String)localObject1);
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (RecentUser)((Iterator)localObject3).next();
        } while ((localObject1 == null) || (!AppConstants.U.equals(((RecentUser)localObject1).uin)));
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        b((RecentUser)localObject1);
      }
      localObject1 = new fpb(this);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, (Comparator)localObject1);
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          a((RecentUser)((Iterator)localObject1).next());
          continue;
          this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
          break;
          long l;
          if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
            l = System.currentTimeMillis();
          }
          try
          {
            localObject1 = new RecentUser().getTableName();
            boolean bool = localEntityManager.b("delete from " + (String)localObject1 + " where max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)this.jdField_a_of_type_JavaUtilList.get(90)).lastmsgtime, ((RecentUser)this.jdField_a_of_type_JavaUtilList.get(90)).lastmsgdrafttime) + "; ");
            if (bool) {
              this.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, 90));
            }
            if (QLog.isColorLevel()) {
              QLog.d("RecentUserProxy", 2, "doInit int recentUserProxy delete recent table >100 isOk = " + bool + "; time = " + (System.currentTimeMillis() - l));
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (RecentUser)((Iterator)localObject1).next();
            this.jdField_a_of_type_JavaUtilMap.put(a(((RecentUser)localObject3).uin, ((RecentUser)localObject3).type), localObject3);
          }
          break;
        }
      }
      e();
      this.b = true;
      localEntityManager.a();
      return;
      Object localObject2 = null;
    }
  }
  
  private void d(RecentUser paramRecentUser)
  {
    if (paramRecentUser.getStatus() == 1000)
    {
      this.a.c(paramRecentUser.uin, paramRecentUser.type, paramRecentUser.getTableName(), paramRecentUser, 3, null);
      return;
    }
    this.a.c(paramRecentUser.uin, paramRecentUser.type, paramRecentUser.getTableName(), paramRecentUser, 4, null);
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("new_friend_upgrade_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_newfriend_when_upgrade", true))
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label72;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentUserProxy", 2, "checkNewFriendUpgrade | descRecentList == null");
      }
    }
    return;
    label72:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fpc(this, localSharedPreferences));
  }
  
  public RecentUser a(String paramString, int paramInt)
  {
    for (;;)
    {
      RecentUser localRecentUser;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        localRecentUser = (RecentUser)this.jdField_a_of_type_JavaUtilMap.get(a(paramString, paramInt));
        if (localRecentUser == null)
        {
          localRecentUser = new RecentUser();
          localRecentUser.uin = paramString;
          localRecentUser.type = paramInt;
          localRecentUser.displayName = localRecentUser.uin;
          localRecentUser.parse();
          a(localRecentUser);
          paramString = localRecentUser;
          return paramString;
        }
        paramString = localRecentUser;
        if (localRecentUser.msg != null) {
          continue;
        }
        if (localRecentUser.mIsParsed)
        {
          localRecentUser.reParse();
          paramString = localRecentUser;
        }
      }
      localRecentUser.parse();
      paramString = localRecentUser;
    }
  }
  
  public List a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          i = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(i);
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ((RecentUser)localIterator.next()).parse();
        }
      }
      int i = 0;
    }
    return localList2;
  }
  
  protected void a() {}
  
  public void a(RecentUser paramRecentUser)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUserProxy", 2, "saveRecentUser:" + a(paramRecentUser.uin) + " Type:" + paramRecentUser.type);
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    Object localObject1 = paramRecentUser;
    Object localObject2;
    try
    {
      if (paramRecentUser.type != 1)
      {
        localObject1 = paramRecentUser;
        if (paramRecentUser.type != 3000)
        {
          localObject2 = new ArrayList();
          localObject1 = MsgProxyUtils.k;
          j = localObject1.length;
          i = 0;
          if (i < j)
          {
            int k = localObject1[i];
            if (k == paramRecentUser.type) {
              break label743;
            }
            Object localObject3 = paramRecentUser.uin;
            localObject3 = (RecentUser)this.jdField_a_of_type_JavaUtilMap.remove(a((String)localObject3, k));
            if (localObject3 == null) {
              break label743;
            }
            ((ArrayList)localObject2).add(localObject3);
            break label743;
          }
          j = ((ArrayList)localObject2).size();
          localObject1 = paramRecentUser;
          if (j > 0)
          {
            if (paramRecentUser.getStatus() != 1000) {
              break label738;
            }
            localObject1 = (RecentUser)((ArrayList)localObject2).get(0);
            this.jdField_a_of_type_JavaUtilList.remove(localObject1);
            ((RecentUser)localObject1).type = paramRecentUser.type;
            ((RecentUser)localObject1).displayName = paramRecentUser.displayName;
            ((RecentUser)localObject1).lastmsgtime = paramRecentUser.lastmsgtime;
            ((RecentUser)localObject1).troopUin = paramRecentUser.troopUin;
            ((RecentUser)localObject1).lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
            ((RecentUser)localObject1).msgData = paramRecentUser.msgData;
            ((RecentUser)localObject1).msgType = paramRecentUser.msgType;
            i = 1;
            paramRecentUser = (RecentUser)localObject1;
            for (;;)
            {
              label283:
              localObject1 = paramRecentUser;
              if (i >= j) {
                break;
              }
              localObject1 = (RecentUser)((ArrayList)localObject2).get(i);
              this.jdField_a_of_type_JavaUtilList.remove(localObject1);
              c((RecentUser)localObject1);
              i += 1;
            }
          }
        }
      }
      a((RecentUser)localObject1);
      if (QLog.isColorLevel())
      {
        QLog.d("RecentUserProxy", 2, "saveRecentUser before save:");
        paramRecentUser = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramRecentUser.hasNext())
        {
          localObject2 = (RecentUser)paramRecentUser.next();
          QLog.d("RecentUserProxy", 2, "Ru:" + a(((RecentUser)localObject2).uin) + ", " + ((RecentUser)localObject2).type + ", " + ((RecentUser)localObject2).lastmsgtime + ", " + ((RecentUser)localObject2).lastmsgdrafttime);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.put(a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).type), localObject1);
    }
    finally {}
    this.jdField_a_of_type_JavaUtilList.remove(localObject1);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        paramRecentUser = (RecentUser)this.jdField_a_of_type_JavaUtilList.get(i);
        if (Math.max(((RecentUser)localObject1).lastmsgtime, ((RecentUser)localObject1).lastmsgdrafttime) > Math.max(paramRecentUser.lastmsgtime, paramRecentUser.lastmsgdrafttime)) {
          this.jdField_a_of_type_JavaUtilList.add(i, localObject1);
        }
      }
      else
      {
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), localObject1);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("RecentUserProxy", 2, "saveRecentUser after save:");
            paramRecentUser = this.jdField_a_of_type_JavaUtilList.iterator();
            while (paramRecentUser.hasNext())
            {
              localObject2 = (RecentUser)paramRecentUser.next();
              QLog.d("RecentUserProxy", 2, "Ru:" + a(((RecentUser)localObject2).uin) + ", " + ((RecentUser)localObject2).type + ", " + ((RecentUser)localObject2).lastmsgtime + ", " + ((RecentUser)localObject2).lastmsgdrafttime);
            }
          }
          d((RecentUser)localObject1);
          return;
        }
        label738:
        i = 0;
        break label283;
        label743:
        i += 1;
        break;
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      return (RecentUser)this.jdField_a_of_type_JavaUtilMap.get(a(paramString, paramInt)) != null;
    }
  }
  
  public RecentUser b(String paramString, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        paramString = (RecentUser)this.jdField_a_of_type_JavaUtilMap.get(a(paramString, paramInt));
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
  
  protected void b() {}
  
  public void b(RecentUser paramRecentUser)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramRecentUser);
      this.jdField_a_of_type_JavaUtilMap.remove(a(paramRecentUser.uin, paramRecentUser.type));
      c(paramRecentUser);
      return;
    }
  }
  
  public void c()
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
 * Qualified Name:     com.tencent.mobileqq.app.proxy.RecentUserProxy
 * JD-Core Version:    0.7.0.1
 */