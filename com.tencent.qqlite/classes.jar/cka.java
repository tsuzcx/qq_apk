import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.struct.PushBanner;
import java.util.List;

class cka
  implements Runnable
{
  cka(cjz paramcjz, PushBanner paramPushBanner) {}
  
  public void run()
  {
    int i = 0;
    EntityManager localEntityManager = BannerManager.a(this.jdField_a_of_type_Cjz.a).app.a().createEntityManager();
    ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
    List localList = localEntityManager.a(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
    if (localList != null) {
      while (i < localList.size() - 9)
      {
        localEntityManager.b((ExpiredPushBanner)localList.get(i));
        i += 1;
      }
    }
    long l3 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqStructPushBanner.a);
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentMobileqqStructPushBanner.c != null)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqStructPushBanner.c.contains("|")) {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqStructPushBanner.c.substring(this.jdField_a_of_type_ComTencentMobileqqStructPushBanner.c.indexOf("|") + 1));
      }
    }
    localExpiredPushBanner.cid = l3;
    localExpiredPushBanner.md5 = this.jdField_a_of_type_ComTencentMobileqqStructPushBanner.m;
    localExpiredPushBanner.endtime = l1;
    localEntityManager.a(localExpiredPushBanner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cka
 * JD-Core Version:    0.7.0.1
 */