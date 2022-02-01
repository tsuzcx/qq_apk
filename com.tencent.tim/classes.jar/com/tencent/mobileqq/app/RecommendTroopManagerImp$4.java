package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;

public final class RecommendTroopManagerImp$4
  implements Runnable
{
  public RecommendTroopManagerImp$4(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager;
    if ((this.a instanceof BrowserAppInterface)) {
      localEntityManager = this.a.getEntityManagerFactory(null).createEntityManager();
    }
    for (;;)
    {
      if (localEntityManager == null) {}
      for (;;)
      {
        return;
        if (!(this.a instanceof QQAppInterface)) {
          break label89;
        }
        localEntityManager = ((QQAppInterface)this.a).a().createEntityManager();
        break;
        if (this.atX == 2) {}
        for (Entity localEntity = localEntityManager.find(NotificationRecommendTroopItem.class, this.val$uin); localEntity != null; localEntity = null)
        {
          localEntityManager.remove(localEntity);
          return;
        }
      }
      label89:
      localEntityManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecommendTroopManagerImp.4
 * JD-Core Version:    0.7.0.1
 */