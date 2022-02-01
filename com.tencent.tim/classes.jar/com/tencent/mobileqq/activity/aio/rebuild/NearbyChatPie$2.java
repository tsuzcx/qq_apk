package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import ybt;

public class NearbyChatPie$2
  implements Runnable
{
  public NearbyChatPie$2(ybt paramybt) {}
  
  public void run()
  {
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)this.this$0.app.a().createEntityManager().find(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.sessionInfo.aTl });
    if (localNearbyPeopleCard != null) {
      this.this$0.mGender = localNearbyPeopleCard.gender;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2
 * JD-Core Version:    0.7.0.1
 */