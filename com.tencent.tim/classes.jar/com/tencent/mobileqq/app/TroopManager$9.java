package com.tencent.mobileqq.app;

import android.os.Handler;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;

class TroopManager$9
  implements Runnable
{
  TroopManager$9(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, Handler paramHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
    if (this.a.getStatus() == 1000) {
      localEntityManager.persistOrReplace(this.a);
    }
    for (;;)
    {
      localEntityManager.close();
      this.val$handler.post(new TroopManager.9.1(this));
      return;
      localEntityManager.update(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.9
 * JD-Core Version:    0.7.0.1
 */