package com.tencent.mobileqq.emosm;

import affx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class CustomEmotionRoamingDBManagerBase$2
  implements Runnable
{
  public CustomEmotionRoamingDBManagerBase$2(affx paramaffx, int paramInt, CustomEmotionBase paramCustomEmotionBase) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    EntityManager localEntityManager;
    do
    {
      return;
      localEntityManager = this.this$0.app.a().createEntityManager();
    } while (localEntityManager == null);
    boolean bool2 = false;
    boolean bool1;
    switch (this.RK)
    {
    case 3: 
    default: 
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CustomEmotionRoamingDBManagerBase", 2, "can not save fav emoticon data, type:" + this.RK);
        bool1 = bool2;
      }
      break;
    }
    for (;;)
    {
      localEntityManager.close();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CustomEmotionRoamingDBManagerBase", 2, "updateCustomEmotionDataListInDB type:" + this.RK + "save result: " + bool1);
      return;
      this.a.setStatus(1000);
      localEntityManager.persist(this.a);
      bool1 = bool2;
      continue;
      bool1 = localEntityManager.update(this.a);
      continue;
      bool1 = localEntityManager.remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.2
 * JD-Core Version:    0.7.0.1
 */