package com.tencent.mobileqq.troop.utils;

import aprp;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopAppMgr$5
  implements Runnable
{
  public TroopAppMgr$5(aprp paramaprp, ArrayList paramArrayList, EntityManager paramEntityManager) {}
  
  public void run()
  {
    Iterator localIterator = this.Cl.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      this.this$0.updateEntity(this.e, localTroopAIOAppInfo);
    }
    this.e.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.5
 * JD-Core Version:    0.7.0.1
 */