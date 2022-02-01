package com.tencent.mobileqq.app;

import acld;
import aqlz;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class RoamSettingManager$1
  implements Runnable
{
  public RoamSettingManager$1(acld paramacld) {}
  
  public void run()
  {
    int i = 0;
    ArrayList localArrayList = (ArrayList)this.this$0.em.query(RoamSetting.class, false, null, null, null, null, null, null);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.this$0.lock.lock();
    }
    for (;;)
    {
      try
      {
        if (i < localArrayList.size())
        {
          RoamSetting localRoamSetting = (RoamSetting)localArrayList.get(i);
          if (aqlz.fk(localRoamSetting.path) == 1) {
            this.this$0.d.put(localRoamSetting.path, localRoamSetting);
          } else {
            this.this$0.c.put(localRoamSetting.path, localRoamSetting);
          }
        }
      }
      finally
      {
        this.this$0.lock.unlock();
      }
      this.this$0.lock.unlock();
      this.this$0.bJj = true;
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamSettingManager.1
 * JD-Core Version:    0.7.0.1
 */