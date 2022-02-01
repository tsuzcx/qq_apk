package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MiniAppLocalSearchManager$1
  implements Runnable
{
  MiniAppLocalSearchManager$1(MiniAppLocalSearchManager paramMiniAppLocalSearchManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject1 = MiniAppLocalSearchManager.access$000();
    if (localObject1 == null) {
      QLog.e("MiniAppLocalSearchManager", 2, "updateDataToDB, app is null.");
    }
    for (;;)
    {
      return;
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      if (localObject1 != null)
      {
        localObject2 = MiniAppLocalSearchEntity.class.getSimpleName();
        Object localObject3 = this.val$miniAppInfo.appId;
        String str = this.val$miniAppInfo.appId;
        localObject2 = ((EntityManager)localObject1).query(MiniAppLocalSearchEntity.class, (String)localObject2, false, "appId = ?", new String[] { localObject3 }, null, null, null, str);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MiniAppLocalSearchEntity)((Iterator)localObject2).next();
          ((MiniAppLocalSearchEntity)localObject3).showMask = 1;
          MiniAppLocalSearchManager.access$100(this.this$0, (EntityManager)localObject1, (Entity)localObject3);
        }
      }
    }
    Object localObject2 = new MiniAppLocalSearchEntity(this.val$miniAppInfo.appId, this.val$miniAppInfo.name, this.val$miniAppInfo.iconUrl, this.val$miniAppInfo.desc, 1);
    MiniAppLocalSearchManager.access$100(this.this$0, (EntityManager)localObject1, (Entity)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.1
 * JD-Core Version:    0.7.0.1
 */