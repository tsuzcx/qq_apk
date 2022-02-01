package com.tencent.mobileqq.troop.utils;

import aprp;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAppMgr$3
  implements Runnable
{
  public TroopAppMgr$3(aprp paramaprp, ArrayList paramArrayList, EntityManager paramEntityManager, int paramInt) {}
  
  public void run()
  {
    if (this.Ck != null)
    {
      Object localObject1 = TableBuilder.getTableNameSafe(TroopAIOAppInfo.class);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = this.e.query(TroopAIOAppInfo.class);
        this.this$0.c(".troop.troop_appVASH", "before delete type:" + this.cY, (List)localObject2);
      }
      this.e.delete((String)localObject1, "groupType=?", new String[] { String.valueOf(this.cY) });
      if (QLog.isColorLevel())
      {
        localObject1 = this.e.query(TroopAIOAppInfo.class);
        this.this$0.c(".troop.troop_appVASH", "before update after delete type:" + this.cY, (List)localObject1);
      }
      localObject1 = this.Ck.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
        ((TroopAIOAppInfo)localObject2).setStatus(1000);
        this.this$0.updateEntity(this.e, (Entity)localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.e.query(TroopAIOAppInfo.class);
        this.this$0.c(".troop.troop_appVASH", "after update type:" + this.cY, (List)localObject1);
      }
    }
    this.e.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.3
 * JD-Core Version:    0.7.0.1
 */