import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class eib
  implements Runnable
{
  public eib(NearbyTroopsActivity paramNearbyTroopsActivity, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.c(0);
    NearbyTroopsBaseView localNearbyTroopsBaseView = NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity, 0);
    if ((localNearbyTroopsBaseView != null) && ((localNearbyTroopsBaseView instanceof NearbyTroopsView))) {
      ((NearbyTroopsView)localNearbyTroopsBaseView).setHasHotTroopRedDot(this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.e();
    if (NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity) != null) {
      NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eib
 * JD-Core Version:    0.7.0.1
 */