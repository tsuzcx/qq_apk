package com.tencent.mobileqq.managers;

import aizr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.EntityManager;

public class TroopRemindSettingManager$1
  implements Runnable
{
  public TroopRemindSettingManager$1(aizr paramaizr, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.val$app.a().createEntityManager();
    if ((TroopRemindSettingData)localEntityManager.find(TroopRemindSettingData.class, this.bQk) == null)
    {
      TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
      localTroopRemindSettingData.troopUin = this.bQk;
      localTroopRemindSettingData.isOpenState = 0;
      localEntityManager.persistOrReplace(localTroopRemindSettingData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopRemindSettingManager.1
 * JD-Core Version:    0.7.0.1
 */