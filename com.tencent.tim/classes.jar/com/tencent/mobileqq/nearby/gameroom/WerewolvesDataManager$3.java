package com.tencent.mobileqq.nearby.gameroom;

import ajtw;
import com.tencent.mobileqq.persistence.EntityManager;

public class WerewolvesDataManager$3
  implements Runnable
{
  public WerewolvesDataManager$3(ajtw paramajtw, RecentInviteUser paramRecentInviteUser) {}
  
  public void run()
  {
    if (this.a.getStatus() == 1000)
    {
      this.this$0.em.persistOrReplace(this.a);
      return;
    }
    this.this$0.em.update(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.3
 * JD-Core Version:    0.7.0.1
 */