import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.struct.PushBanner;
import java.util.List;

class xjj
  implements Runnable
{
  xjj(xji paramxji, int paramInt, List paramList) {}
  
  public void run()
  {
    int k = 0;
    EntityManager localEntityManager = BannerManager.a(this.jdField_a_of_type_Xji.a).app.getEntityManagerFactory().createEntityManager();
    Object localObject = localEntityManager.a(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
    int j = k;
    if (localObject != null)
    {
      int m = ((List)localObject).size() + this.jdField_a_of_type_Int - 10;
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
          localEntityManager.b((ExpiredPushBanner)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (PushBanner)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((PushBanner)localObject).c != null)
        {
          l1 = l2;
          if (((PushBanner)localObject).c.contains("|")) {
            l1 = Long.parseLong(((PushBanner)localObject).c.substring(((PushBanner)localObject).c.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((PushBanner)localObject).a);
        localExpiredPushBanner.md5 = ((PushBanner)localObject).m;
        localExpiredPushBanner.endtime = l1;
        localEntityManager.a(localExpiredPushBanner);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjj
 * JD-Core Version:    0.7.0.1
 */