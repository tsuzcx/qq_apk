package com.tencent.mobileqq.addon;

import abgl;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;

public class DiyPendantFetcher$5
  implements Runnable
{
  public DiyPendantFetcher$5(abgl paramabgl, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = this.val$app.a().createEntityManager().query(DiyPendantEntity.class, true, null, null, null, null, null, " 20 ");
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)localIterator.next();
        if (!TextUtils.isEmpty(localDiyPendantEntity.uinAndDiyId)) {
          this.this$0.g.put(localDiyPendantEntity.uinAndDiyId, localDiyPendantEntity);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "initCacheFromDB, size: " + localList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.5
 * JD-Core Version:    0.7.0.1
 */