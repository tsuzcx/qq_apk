package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MiniAppUserAppInfoListManager$11
  implements Runnable
{
  MiniAppUserAppInfoListManager$11(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "saveDataToDBWithBatch, app is null.");
    }
    for (;;)
    {
      return;
      if (this.val$needCheckDbData) {
        MiniAppUserAppInfoListManager.access$1200(this.this$0, (AppInterface)localObject1, this.val$appInfoList);
      }
      EntityManager localEntityManager = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      if (localEntityManager == null) {
        continue;
      }
      localObject1 = localEntityManager.getTransaction();
      if (localObject1 != null) {}
      try
      {
        ((EntityTransaction)localObject1).begin();
        localStringBuilder = new StringBuilder();
        Iterator localIterator = this.val$appInfoList.iterator();
        int i = 1;
        while (localIterator.hasNext())
        {
          MiniAppInfo localMiniAppInfo = (MiniAppInfo)localIterator.next();
          localMiniAppInfo.position = i;
          MiniAppEntity localMiniAppEntity = new MiniAppEntity(localMiniAppInfo);
          localMiniAppEntity.setStatus(1000);
          MiniAppUserAppInfoListManager.access$1100(this.this$0, localEntityManager, localMiniAppEntity);
          i += 1;
          localStringBuilder.append(localMiniAppInfo.name).append(", ");
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppUserAppInfoListManager", 2, "saveMiniAppInfoList exception: ", localException);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppUserAppInfoListManager", 2, new Object[] { "saveMiniAppInfoList : ", localStringBuilder.toString() });
        }
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).commit();
        }
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).end();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.11
 * JD-Core Version:    0.7.0.1
 */