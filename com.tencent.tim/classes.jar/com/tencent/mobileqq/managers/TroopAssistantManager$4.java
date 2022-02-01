package com.tencent.mobileqq.managers;

import aizp;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.EntityManager;

public class TroopAssistantManager$4
  implements Runnable
{
  public TroopAssistantManager$4(aizp paramaizp, TroopAssistantData paramTroopAssistantData, EntityManager paramEntityManager) {}
  
  public void run()
  {
    if (this.b.getStatus() == 1000)
    {
      this.e.persist(this.b);
      return;
    }
    this.e.update(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.4
 * JD-Core Version:    0.7.0.1
 */