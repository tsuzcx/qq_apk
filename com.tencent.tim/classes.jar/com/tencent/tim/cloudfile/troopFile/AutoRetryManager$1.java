package com.tencent.tim.cloudfile.troopFile;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class AutoRetryManager$1
  implements Runnable
{
  AutoRetryManager$1(AutoRetryManager paramAutoRetryManager, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        AutoRetryManager.a(this.this$0).getTransaction().begin();
        if (this.KJ != null)
        {
          int i = this.KJ.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localIterator = this.KJ.iterator();
      }
      catch (Exception localException)
      {
        ArrayList localArrayList;
        Iterator localIterator;
        TroopFileCopyInfoEntity localTroopFileCopyInfoEntity;
        QLog.e("AutoRetryManager.TroopAutoSaveToCloud", 1, "saveDB failed exception:  " + localException.toString());
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("AutoRetryManager.TroopAutoSaveToCloud", 1, localTroopFileCopyInfoEntity.strFileName + " is existed!");
        continue;
      }
      finally
      {
        AutoRetryManager.a(this.this$0).getTransaction().end();
      }
      if (!localIterator.hasNext()) {
        break label219;
      }
      localTroopFileCopyInfoEntity = (TroopFileCopyInfoEntity)localIterator.next();
      AutoRetryManager.a(this.this$0).persist(localTroopFileCopyInfoEntity);
      if (localTroopFileCopyInfoEntity.getId() == -1L) {
        continue;
      }
      localArrayList.add(localTroopFileCopyInfoEntity);
    }
    label219:
    AutoRetryManager.a(this.this$0).getTransaction().commit();
    AutoRetryManager.a(this.this$0).addAll(localCollection);
    AutoRetryManager.a(this.this$0).getTransaction().end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.AutoRetryManager.1
 * JD-Core Version:    0.7.0.1
 */