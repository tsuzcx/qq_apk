package com.tencent.mobileqq.onlinestatus;

import aktw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class OnlineStatusPermissionManager$1
  implements Runnable
{
  public OnlineStatusPermissionManager$1(aktw paramaktw, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.val$app.a().createEntityManager();
    Object localObject = localEntityManager.query(OnlineStatusPermissionEntity.class, false, null, null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      OnlineStatusPermissionEntity localOnlineStatusPermissionEntity = (OnlineStatusPermissionEntity)((Iterator)localObject).next();
      aktw.a(this.this$0, localOnlineStatusPermissionEntity, false);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, "initOpenIdFromDB size is 0");
      }
    }
    aktw.a(this.this$0, 1);
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.1
 * JD-Core Version:    0.7.0.1
 */