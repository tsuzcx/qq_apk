package com.tencent.mobileqq.util;

import aqek;
import aqmr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

public final class NearbyProfileUtil$1
  implements Runnable
{
  public void run()
  {
    EntityManager localEntityManager = this.val$app.a().createEntityManager();
    Object localObject1;
    long l;
    if (localEntityManager != null)
    {
      localObject1 = null;
      if (this.asz > 0L) {
        localObject1 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.asz) });
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (!aqmr.isEmpty(this.val$uin)) {
          localObject2 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.val$uin });
        }
      }
      if (localObject2 != null)
      {
        localObject1 = ((NearbyPeopleCard)localObject2).vSeed;
        l = ((NearbyPeopleCard)localObject2).feedPreviewTime;
        localEntityManager.close();
      }
    }
    for (;;)
    {
      aqek.a(this.e, this.val$app, this.asz, this.val$uin, this.val$type, (byte[])localObject1, l, false, 0L, false, 0L, 0);
      return;
      localObject1 = null;
      l = 0L;
      break;
      l = 0L;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.NearbyProfileUtil.1
 * JD-Core Version:    0.7.0.1
 */