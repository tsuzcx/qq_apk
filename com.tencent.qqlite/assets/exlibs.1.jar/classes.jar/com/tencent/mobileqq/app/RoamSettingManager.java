package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class RoamSettingManager
  implements Manager
{
  RoamSetting jdField_a_of_type_ComTencentMobileqqDataRoamSetting;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(100);
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  
  public RoamSettingManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RoamSetting.class, "setting_revision"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = null;
      return 0;
    }
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "parse revision.value exception, revision.value=" + this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
        }
        int i = 0;
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    return RoamSetting.getIntValue(a(paramString), paramInt);
  }
  
  public RoamSetting a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      RoamSetting localRoamSetting = (RoamSetting)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
      Object localObject = localRoamSetting;
      if (localRoamSetting == null)
      {
        paramString = (RoamSetting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RoamSetting.class, paramString);
        localObject = paramString;
        if (paramString != null)
        {
          localObject = paramString;
          if (paramString.path != null)
          {
            localObject = paramString;
            if (paramString.value != null)
            {
              this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString.path, paramString);
              localObject = paramString;
            }
          }
        }
      }
      return localObject;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting != null)
    {
      localObject = Integer.toString(paramInt);
      if (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value = ((String)localObject);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting);
      return;
      localObject = new RoamSetting();
      ((RoamSetting)localObject).path = "setting_revision";
      ((RoamSetting)localObject).value = Integer.toString(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)localObject);
    }
  }
  
  public void a(RoamSetting paramRoamSetting)
  {
    if ((paramRoamSetting == null) || (paramRoamSetting.path == null) || (paramRoamSetting.value == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramRoamSetting.path, paramRoamSetting);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      a(paramRoamSetting);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.path == null) || (paramString.value == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(paramString.path);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      b(paramString);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    RoamSetting localRoamSetting = a(paramString1);
    if (localRoamSetting == null) {}
    for (paramString1 = new RoamSetting(paramString1, paramString2);; paramString1 = localRoamSetting)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString1.path, paramString1);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if (paramString2.equals(localRoamSetting.value)) {
        break;
      }
      localRoamSetting.value = paramString2;
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((RoamSetting)paramList.next());
    }
  }
  
  boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  boolean b(Entity paramEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
    }
    return false;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamSettingManager
 * JD-Core Version:    0.7.0.1
 */