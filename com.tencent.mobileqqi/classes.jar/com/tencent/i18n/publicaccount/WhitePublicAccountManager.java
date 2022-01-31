package com.tencent.i18n.publicaccount;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WhitePublicAccountManager
{
  private static volatile WhitePublicAccountManager jdField_a_of_type_ComTencentI18nPublicaccountWhitePublicAccountManager = null;
  private static List jdField_a_of_type_JavaUtilList = null;
  protected QQAppInterface a;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private WhitePublicAccountManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static WhitePublicAccountManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentI18nPublicaccountWhitePublicAccountManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentI18nPublicaccountWhitePublicAccountManager == null)
      {
        jdField_a_of_type_ComTencentI18nPublicaccountWhitePublicAccountManager = new WhitePublicAccountManager(paramQQAppInterface);
        jdField_a_of_type_ComTencentI18nPublicaccountWhitePublicAccountManager.a();
      }
      return jdField_a_of_type_ComTencentI18nPublicaccountWhitePublicAccountManager;
    }
    finally {}
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
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (localEntityManager.a(WhitePublicAccount.class) == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(new WhitePublicAccount(1752794996L));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WhitePublicAccount localWhitePublicAccount = (WhitePublicAccount)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localWhitePublicAccount.uin, localWhitePublicAccount);
      }
    }
    Object localObject = new WhitePublicAccount(1752794996L);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((WhitePublicAccount)localObject).uin, localObject);
    localEntityManager.a();
  }
  
  public List a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(WhitePublicAccount.class);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(new WhitePublicAccount(1752794996L));
    }
    return localObject;
  }
  
  public boolean a(long paramLong, List paramList)
  {
    if ((paramList != null) && (paramList.size() >= 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramLong == Long.valueOf(((WhitePublicAccount)paramList.next()).uin).longValue()) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.publicaccount.WhitePublicAccountManager
 * JD-Core Version:    0.7.0.1
 */