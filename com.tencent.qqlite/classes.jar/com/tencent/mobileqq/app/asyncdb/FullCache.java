package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FullCache
  extends BaseCache
{
  public FullCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager, Class paramClass)
  {
    super(paramQQAppInterface, paramDBDelayManager, paramClass);
  }
  
  protected void a()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject = localEntityManager.a(this.jdField_a_of_type_JavaLangClass, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localEntity), localEntity);
      }
    }
    localEntityManager.a();
  }
  
  public void a(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    String str = a(paramEntity);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramEntity);
    if (paramEntity.getStatus() == 1000)
    {
      this.a.a(paramEntity, 0, paramInt, paramProxyListener);
      return;
    }
    this.a.a(paramEntity, 1, paramInt, paramProxyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.FullCache
 * JD-Core Version:    0.7.0.1
 */