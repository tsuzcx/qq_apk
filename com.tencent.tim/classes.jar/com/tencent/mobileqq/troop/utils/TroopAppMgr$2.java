package com.tencent.mobileqq.troop.utils;

import aprp;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAppMgr$2
  implements Runnable
{
  public TroopAppMgr$2(aprp paramaprp, EntityManager paramEntityManager, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.e.query(TroopAIOAppInfo.class);
      this.this$0.c(".troop.troop_appVASH", "before updateEntity(" + this.cY + ")", (List)localObject);
    }
    Object localObject = this.Ck.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      this.this$0.updateEntity(this.e, localTroopAIOAppInfo);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.e.query(TroopAIOAppInfo.class);
      this.this$0.c(".troop.troop_appVASH", "after updateEntity(" + this.cY + ")", (List)localObject);
    }
    this.e.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.2
 * JD-Core Version:    0.7.0.1
 */