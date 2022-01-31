import android.os.Handler;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class aya
  implements Runnable
{
  aya(axy paramaxy) {}
  
  public void run()
  {
    this.a.a.app.b(this.a.a.app.a(), 3000);
    EntityManager localEntityManager = this.a.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.a.app.a() });
      if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
        this.a.a.app.b(String.valueOf(localNearbyPeopleCard.tinyId), 3001);
      }
      localEntityManager.a();
    }
    if (NearbyPeopleProfileActivity.d(this.a.a)) {
      NearbyPeopleProfileActivity.q(this.a.a);
    }
    new Handler(ThreadManager.b()).postDelayed(new ayb(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aya
 * JD-Core Version:    0.7.0.1
 */