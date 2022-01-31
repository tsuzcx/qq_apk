import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HornListActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.statistics.ReportController;

public class cqg
  implements View.OnClickListener
{
  public cqg(HornListActivity paramHornListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHornListActivity.b, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_enterProfileCard", 0, 0, "", "", "", "");
    paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 41);
    paramView.g = this.jdField_a_of_type_ComTencentMobileqqActivityHornListActivity.a.nickName;
    paramView.a = this.jdField_a_of_type_ComTencentMobileqqActivityHornListActivity.a.seg;
    paramView.e = 4;
    paramView.f = 5;
    ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHornListActivity, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqg
 * JD-Core Version:    0.7.0.1
 */