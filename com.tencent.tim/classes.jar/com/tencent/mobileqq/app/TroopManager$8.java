package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;

class TroopManager$8
  implements Runnable
{
  TroopManager$8(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.a().createEntityManager();
    if (this.f.getStatus() == 1000) {
      ((EntityManager)localObject).persistOrReplace(this.f);
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      localObject = this.this$0.E(this.Uf);
      new Handler(Looper.getMainLooper()).post(new TroopManager.8.1(this, (ArrayList)localObject));
      return;
      ((EntityManager)localObject).update(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.8
 * JD-Core Version:    0.7.0.1
 */