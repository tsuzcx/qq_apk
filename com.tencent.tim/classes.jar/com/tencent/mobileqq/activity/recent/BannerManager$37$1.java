package com.tencent.mobileqq.activity.recent;

import aahb;
import aaii;
import anqr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class BannerManager$37$1
  implements Runnable
{
  public BannerManager$37$1(aaii paramaaii, int paramInt, List paramList) {}
  
  public void run()
  {
    int k = 0;
    EntityManager localEntityManager = aahb.a(this.a.this$0).app.a().createEntityManager();
    Object localObject = localEntityManager.query(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
    int j = k;
    if (localObject != null)
    {
      int m = ((List)localObject).size() + this.val$count - 10;
      j = k;
      if (m > 0)
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          localEntityManager.remove((ExpiredPushBanner)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    while (j < this.vl.size())
    {
      localObject = (anqr)this.vl.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((anqr)localObject).time != null)
        {
          l1 = l2;
          if (((anqr)localObject).time.contains("|")) {
            l1 = Long.parseLong(((anqr)localObject).time.substring(((anqr)localObject).time.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((anqr)localObject).id);
        localExpiredPushBanner.md5 = ((anqr)localObject).md5;
        localExpiredPushBanner.endtime = l1;
        localEntityManager.persist(localExpiredPushBanner);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager.37.1
 * JD-Core Version:    0.7.0.1
 */