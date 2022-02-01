package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MiniAppUserAppInfoListManager$7
  implements Runnable
{
  MiniAppUserAppInfoListManager$7(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "queryMiniAppInfoFromDb, app is null.");
    }
    do
    {
      return;
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while (localObject1 == null);
    Object localObject3 = ((EntityManager)localObject1).query(MiniAppEntity.class, MiniAppEntity.class.getSimpleName(), false, null, null, null, null, "position asc", null);
    localObject1 = new StringBuilder();
    if (localObject3 != null)
    {
      try
      {
        if ((((List)localObject3).size() > 0) && (MiniAppUserAppInfoListManager.access$800(this.this$0).size() <= 0))
        {
          MiniAppUserAppInfoListManager.access$800(this.this$0).clear();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = (MiniAppEntity)((Iterator)localObject3).next();
            if ((localObject4 != null) && (((MiniAppEntity)localObject4).appInfo != null))
            {
              localObject4 = ((MiniAppEntity)localObject4).createFromBuffer(((MiniAppEntity)localObject4).appInfo);
              if (localObject4 != null)
              {
                MiniAppUserAppInfoListManager.access$800(this.this$0).add(localObject4);
                ((StringBuilder)localObject1).append(((MiniAppInfo)localObject4).name).append(",");
              }
            }
          }
          MiniAppUtils.updateMiniAppList(9);
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppUserAppInfoListManager", 2, "queryMiniAppInfoFromDb, mDbCacheAppList size = " + MiniAppUserAppInfoListManager.access$800(this.this$0).size() + ", " + localObject2.toString());
      }
      return;
    }
    QLog.d("MiniAppUserAppInfoListManager", 1, "queryMiniAppInfoFromDb, mDbCacheAppList tempList is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.7
 * JD-Core Version:    0.7.0.1
 */