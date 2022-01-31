package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.manager.Manager;

public class ShortVideoTransManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 43200000;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  public ShortVideoTransManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface.a().createEntityManager();
  }
  
  public ShortVideoUpInfo a(String paramString)
  {
    ShortVideoUpInfo localShortVideoUpInfo = (ShortVideoUpInfo)this.a.a(ShortVideoUpInfo.class, paramString);
    paramString = localShortVideoUpInfo;
    if (localShortVideoUpInfo != null)
    {
      paramString = localShortVideoUpInfo;
      if (43200000L <= System.currentTimeMillis() - localShortVideoUpInfo.timeStamp)
      {
        this.a.b(localShortVideoUpInfo);
        paramString = null;
      }
    }
    return paramString;
  }
  
  public void a(ShortVideoUpInfo paramShortVideoUpInfo)
  {
    ShortVideoUpInfo localShortVideoUpInfo = (ShortVideoUpInfo)this.a.a(ShortVideoUpInfo.class, paramShortVideoUpInfo.key);
    if (localShortVideoUpInfo != null)
    {
      localShortVideoUpInfo.transferedSize = paramShortVideoUpInfo.transferedSize;
      localShortVideoUpInfo.timeStamp = paramShortVideoUpInfo.timeStamp;
      this.a.a(localShortVideoUpInfo);
      return;
    }
    this.a.a(paramShortVideoUpInfo);
  }
  
  public boolean a(String paramString)
  {
    return this.a.a(ShortVideoUpInfo.class, paramString) == null;
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = this.a.b(paramString);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShortVideoTransManager
 * JD-Core Version:    0.7.0.1
 */