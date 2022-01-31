import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class aye
  implements Runnable
{
  aye(ayd paramayd) {}
  
  public void run()
  {
    this.a.a.a.app.a(this.a.a.a.app.a(), 3000, true);
    EntityManager localEntityManager = this.a.a.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.a.a.app.a() });
      if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
        this.a.a.a.app.a(String.valueOf(localNearbyPeopleCard.tinyId), 3001, true);
      }
      localEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aye
 * JD-Core Version:    0.7.0.1
 */