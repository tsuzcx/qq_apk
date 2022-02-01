package com.tencent.mobileqq.nearby.profilecard;

import akcx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

public class NearbyProfileDisplayPanel$17
  implements Runnable
{
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.update(akcx.a(this.this$0));
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.17
 * JD-Core Version:    0.7.0.1
 */