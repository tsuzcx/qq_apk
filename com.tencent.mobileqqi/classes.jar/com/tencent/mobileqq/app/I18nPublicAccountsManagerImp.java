package com.tencent.mobileqq.app;

import com.tencent.i18n.publicaccount.WhitePublicAccount;
import com.tencent.mobileqq.data.RecommendFriend;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class I18nPublicAccountsManagerImp
  implements Manager
{
  private static final long jdField_b_of_type_Long = 86400000L;
  long jdField_a_of_type_Long = 0L;
  private I18nPublicAccountHandler jdField_a_of_type_ComTencentMobileqqAppI18nPublicAccountHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Object jdField_b_of_type_JavaLangObject;
  
  public I18nPublicAccountsManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.b = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_ComTencentMobileqqAppI18nPublicAccountHandler = ((I18nPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(38));
  }
  
  public void a()
  {
    TraceUtils.a("preload white public account uin");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(WhitePublicAccount.class);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WhitePublicAccount localWhitePublicAccount = (WhitePublicAccount)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localWhitePublicAccount.uin, localWhitePublicAccount);
      }
    }
    localObject = new WhitePublicAccount(1752794996L);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((WhitePublicAccount)localObject).uin, localObject);
    TraceUtils.a();
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(WhitePublicAccount.class);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (Long)paramList.next();
          WhitePublicAccount localWhitePublicAccount = new WhitePublicAccount();
          localWhitePublicAccount.uin = String.valueOf(localObject);
          localObject = new WhitePublicAccount();
          ((WhitePublicAccount)localObject).uin = String.valueOf(localWhitePublicAccount.uin);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
      localEntityTransaction.b();
      a();
    }
  }
  
  public void a(List paramList, long paramLong) {}
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppI18nPublicAccountHandler.a();
      return true;
    }
  }
  
  public boolean a(String paramString)
  {
    if (Long.parseLong(paramString) == 2927565187L) {}
    do
    {
      do
      {
        return false;
        if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
          return true;
        }
      } while ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() != 0));
      a();
    } while ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)));
    return true;
  }
  
  public boolean b()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.b)
      {
        if (NetConnInfoCenter.getServerTime() > this.jdField_a_of_type_Long)
        {
          Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ArrayList localArrayList = new ArrayList();
          List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendFriend.class, false, null, null, null, null, "timeStamp desc", null);
          if ((localList != null) && (localList.size() != 0) && (i < localList.size()))
          {
            RecommendFriend localRecommendFriend = (RecommendFriend)localList.get(i);
            if (localRecommendFriend != null) {
              localArrayList.add(Long.valueOf(localRecommendFriend.uin));
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppI18nPublicAccountHandler.a(localArrayList, this.jdField_a_of_type_Long);
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.I18nPublicAccountsManagerImp
 * JD-Core Version:    0.7.0.1
 */