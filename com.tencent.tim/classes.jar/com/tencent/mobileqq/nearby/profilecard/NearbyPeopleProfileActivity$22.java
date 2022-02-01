package com.tencent.mobileqq.nearby.profilecard;

import aqmr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

class NearbyPeopleProfileActivity$22
  implements Runnable
{
  NearbyPeopleProfileActivity$22(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if (!aqmr.isEmpty(NearbyPeopleProfileActivity.a(this.this$0).uin)) {
      this.this$0.app.l(NearbyPeopleProfileActivity.a(this.this$0).uin, 200, false);
    }
    if (this.this$0.adP > 0L) {
      this.this$0.app.l(String.valueOf(this.this$0.adP), 202, false);
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return;
      } while (aqmr.isEmpty(NearbyPeopleProfileActivity.a(this.this$0).uin));
      localEntityManager = this.this$0.app.a().createEntityManager();
    } while (localEntityManager == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.this$0).uin });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
      this.this$0.app.l(String.valueOf(localNearbyPeopleCard.tinyId), 202, false);
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.22
 * JD-Core Version:    0.7.0.1
 */