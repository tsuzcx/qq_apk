import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class wbt
  implements Runnable
{
  public wbt(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    String[] arrayOfString = NearbyRecommenderUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.a.O = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbt
 * JD-Core Version:    0.7.0.1
 */