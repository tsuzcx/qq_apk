import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;

class axz
  implements Runnable
{
  axz(axy paramaxy, NearbyPeopleCard paramNearbyPeopleCard) {}
  
  public void run()
  {
    if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
      this.jdField_a_of_type_Axy.a.app.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 3000, false);
    }
    Object localObject2;
    int i;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Axy.a) > 0L)
    {
      this.jdField_a_of_type_Axy.a.app.a(String.valueOf(NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Axy.a)), 3001, false);
      localObject2 = this.jdField_a_of_type_Axy.a.app;
      i = NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Axy.a).g;
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Axy.a) == null) {
        break label262;
      }
    }
    label262:
    for (Object localObject1 = NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Axy.a).uin;; localObject1 = "")
    {
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004CC5", "0X8004CC5", i, 0, (String)localObject1, "", "", "");
      return;
      if (StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
        break;
      }
      localObject1 = this.jdField_a_of_type_Axy.a.app.a().createEntityManager();
      if (localObject1 == null) {
        break;
      }
      localObject2 = (NearbyPeopleCard)((EntityManager)localObject1).a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
      if ((localObject2 != null) && (((NearbyPeopleCard)localObject2).tinyId > 0L)) {
        this.jdField_a_of_type_Axy.a.app.a(String.valueOf(((NearbyPeopleCard)localObject2).tinyId), 3001, false);
      }
      ((EntityManager)localObject1).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axz
 * JD-Core Version:    0.7.0.1
 */