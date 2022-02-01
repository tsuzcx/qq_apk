package com.tencent.mobileqq.mini.entry;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class MiniAppUserAppInfoListManager$6
  implements Runnable
{
  MiniAppUserAppInfoListManager$6(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "initLocalDataRunnable, app is null.");
    }
    for (;;)
    {
      return;
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager().query(MiniAppRedDotEntity.class, MiniAppRedDotEntity.class.getSimpleName(), false, null, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MiniAppRedDotEntity localMiniAppRedDotEntity = (MiniAppRedDotEntity)((Iterator)localObject).next();
          if ((localMiniAppRedDotEntity != null) && (!TextUtils.isEmpty(localMiniAppRedDotEntity.appId))) {
            MiniAppUserAppInfoListManager.access$900(this.this$0).put(localMiniAppRedDotEntity.appId, Integer.valueOf(localMiniAppRedDotEntity.wnsPushRedDotNum));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.6
 * JD-Core Version:    0.7.0.1
 */