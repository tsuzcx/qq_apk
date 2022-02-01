package com.tencent.mobileqq.nearby;

import ajrb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public final class NearbyCardManager$1
  implements Runnable
{
  public NearbyCardManager$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.val$app.l(this.val$app.getCurrentAccountUin(), 200, true);
    long l1 = ((Long)ajrb.c(this.val$app.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
    long l2 = l1;
    EntityManager localEntityManager;
    if (l1 == 0L)
    {
      localEntityManager = this.val$app.getEntityManagerFactory(this.val$app.getAccount()).createEntityManager();
      l2 = l1;
      if (localEntityManager != null)
      {
        NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.val$app.getCurrentAccountUin() });
        if (localNearbyPeopleCard == null) {
          break label143;
        }
        l1 = localNearbyPeopleCard.tinyId;
      }
    }
    label143:
    for (;;)
    {
      localEntityManager.close();
      l2 = l1;
      if (l2 != 0L) {
        this.val$app.l(String.valueOf(l2), 202, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyCardManager.1
 * JD-Core Version:    0.7.0.1
 */