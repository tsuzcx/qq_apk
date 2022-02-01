package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$19
  implements Runnable
{
  DesktopDataManager$19(DesktopDataManager paramDesktopDataManager, DesktopItemInfo paramDesktopItemInfo) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch, app is null.");
    }
    EntityManager localEntityManager;
    do
    {
      return;
      localEntityManager = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = null;
        if (!(this.val$data instanceof DesktopAppInfo)) {
          break label148;
        }
        localObject = new DeskTopAppEntity(((DesktopAppInfo)this.val$data).mMiniAppInfo);
        if (localObject != null)
        {
          ((DeskTopAppEntity)localObject).setStatus(1000);
          DesktopDataManager.access$3200(this.this$0, localEntityManager, (Entity)localObject);
          localStringBuilder.append(((DeskTopAppEntity)localObject).name).append(", ");
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("DesktopDataManager", 2, new Object[] { "insertEntity : ", localStringBuilder.toString() });
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DesktopDataManager", 2, "insertEntity exception: ", localException);
      return;
      label148:
      if ((this.val$data instanceof DesktopSearchInfo)) {
        DeskTopAppEntity localDeskTopAppEntity = new DeskTopAppEntity(((DesktopSearchInfo)this.val$data).mAppInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.19
 * JD-Core Version:    0.7.0.1
 */