import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import mqq.os.MqqHandler;

public class uhc
  implements Runnable
{
  public uhc(TroopRequestActivity paramTroopRequestActivity, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.b);
    ThreadManager.getUIHandler().post(new uhd(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhc
 * JD-Core Version:    0.7.0.1
 */