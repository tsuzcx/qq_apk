import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class vwg
  implements Runnable
{
  public vwg(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
    if (localNearbyPeopleCard != null) {
      this.a.n = localNearbyPeopleCard.gender;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwg
 * JD-Core Version:    0.7.0.1
 */