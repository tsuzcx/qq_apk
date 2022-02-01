package com.tencent.mobileqq.nearby;

import acff;
import ajqp;
import ajrb;
import akkx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;

public final class NearbyProxy$9
  implements Runnable
{
  public NearbyProxy$9(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2 = (acff)this.val$app.getManager(51);
    Object localObject1 = ((acff)localObject2).c(this.val$app.getCurrentAccountUin());
    if ((localObject1 != null) && (((Card)localObject1).iVoteIncrement > 0))
    {
      ((Card)localObject1).iVoteIncrement = 0;
      ((acff)localObject2).a((Card)localObject1);
    }
    localObject2 = this.val$app.a().createEntityManager();
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).find(NearbyPeopleCard.class, "uin=?", new String[] { this.val$app.getCurrentAccountUin() });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.likeCountInc > 0))
    {
      localNearbyPeopleCard.likeCountInc = 0;
      ((EntityManager)localObject2).update(localNearbyPeopleCard);
    }
    ((EntityManager)localObject2).close();
    localObject2 = this.val$app.getAccount();
    long l;
    if (localObject1 == null)
    {
      l = 0L;
      ajrb.b((String)localObject2, l, 0);
      this.val$app.getApp().getSharedPreferences(this.val$app.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", 0).commit();
      if (!ConnectNearbyProcService.arA()) {
        break label211;
      }
      ajqp.a(this.val$app.a(), 4117);
    }
    label211:
    do
    {
      return;
      l = ((Card)localObject1).lVoteCount;
      break;
      localObject1 = akkx.a(this.val$app);
    } while (localObject1 == null);
    ((NearbyMyTabCard)localObject1).newLikeNum = 0;
    akkx.a(this.val$app, (NearbyMyTabCard)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.9
 * JD-Core Version:    0.7.0.1
 */